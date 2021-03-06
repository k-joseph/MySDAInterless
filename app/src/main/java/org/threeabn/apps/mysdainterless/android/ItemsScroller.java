package org.threeabn.apps.mysdainterless.android;

import android.widget.AbsListView;

/**
 * Created by k-joseph on 11/03/2018.
 * <p>
 * TODO not currently used, idea is to use it up if listViews and improved and workable, else replace listViews with fragments
 */
public class ItemsScroller implements AbsListView.OnScrollListener {

    private String[] programs = null;
    private int visibleThreshold = 5;
    private int currentPage = 0;
    private int previousTotal = 0;
    private boolean loading = true;

    public ItemsScroller() {
    }

    public ItemsScroller(Integer visibleThreshold, String[] programs) {
        this.visibleThreshold = visibleThreshold;
        this.programs = programs;
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false;
                previousTotal = totalItemCount;
                currentPage++;
            }
        }
        if (!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
            // I load the next page of gigs using a background task,
            // but you can call any function here.
            //TODO new LoadGigsTask().execute(currentPage + 1);
            loading = true;
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }
}
