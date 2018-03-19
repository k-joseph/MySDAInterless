package org.threeabn.apps.mysdainterless.screens;

import android.os.Bundle;

import org.threeabn.apps.mysdainterless.R;

public class MainActivity extends MySDAActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runBlockByByView(findViewById(R.id.image_search), MainActivity.this);
        runBlockByByView(findViewById(R.id.image_favorite), MainActivity.this);
        runBlockByByView(findViewById(R.id.image_list), MainActivity.this);
    }
}