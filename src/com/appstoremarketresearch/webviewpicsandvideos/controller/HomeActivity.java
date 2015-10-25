package com.appstoremarketresearch.webviewpicsandvideos.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.appstoremarketresearch.webviewpicsandvideos.R;

public class HomeActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
