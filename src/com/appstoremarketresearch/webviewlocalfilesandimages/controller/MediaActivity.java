package com.appstoremarketresearch.webviewlocalfilesandimages.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.appstoremarketresearch.webviewlocalfilesandimages.R;

public class MediaActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.media, menu);
        return true;
    }

}
