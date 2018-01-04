package org.threeabn.apps.mysdainterless;

import android.app.Activity;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;
import org.threeabn.apps.mysdainterless.modal.Program;

import java.io.File;

/**
 * Created by k-joseph on 29/10/2017.
 */

public class ProgramsList extends ArrayAdapter<String> {
    private Activity context;
    private String[] programPaths;
    private boolean detailPrograms;


    public ProgramsList(Activity context, String[] programPaths) {
        super(context, R.layout.list_programs, programPaths);//TODO fetch and rather pass in program name here instead of programPaths
        this.context = context;
        this.programPaths = programPaths;
    }

    public ProgramsList(Activity context, String[] programPaths, boolean detailPrograms) {
        super(context, detailPrograms ? R.layout.list_programs_details : R.layout.list_programs, programPaths);//TODO fetch and rather pass in program name here instead of programPaths
        this.context = context;
        this.programPaths = programPaths;
        this.detailPrograms = detailPrograms;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(this.detailPrograms ? R.layout.list_programs_details : R.layout.list_programs, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        String path = programPaths[position];
        Bitmap img = getBitMapFromVideo(MySDAInterlessConstantsAndEvaluations.PROGRAMS_DIRECTORY + File.separator + path);
        String prog = programPaths[position];

        if(StringUtils.isNotBlank(prog)) {
            txtTitle.setText(prog);
            imageView.setImageBitmap(img);

            if (this.detailPrograms) {
                //TODO add all details
                try {
                    TextView desc = (TextView) rowView.findViewById(R.id.p_desc);
                    TextView dur = (TextView) rowView.findViewById(R.id.p_duration);
                    TextView parts = (TextView) rowView.findViewById(R.id.p_participants);
                    Program program = ((MySDAActivity) context).getService().getProgramByCode(prog.substring(0, prog.indexOf(".")));

                    if(program != null) {
                        desc.setText(program.getDescription());
                        dur.setText(program.getDuration());
                        parts.setText(program.getParticipants());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return rowView;
    }

    public Bitmap createThumbnailFromPath(String filePath, int type){
        return ThumbnailUtils.createVideoThumbnail(filePath, type);
    }

    public Bitmap getBitMapFromVideo(String path) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();

        mediaMetadataRetriever.setDataSource(path);
        Bitmap bmFrame = mediaMetadataRetriever.getFrameAtTime(5000000); //unit in microsecond

        return bmFrame;
    }
}
