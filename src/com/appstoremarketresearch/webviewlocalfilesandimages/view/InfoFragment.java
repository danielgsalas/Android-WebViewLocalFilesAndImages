package com.appstoremarketresearch.webviewlocalfilesandimages.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.appstoremarketresearch.webviewlocalfilesandimages.R;

public class InfoFragment extends Fragment
{
    @Override
    public View onCreateView(
        LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);
        
        View topLevelView = inflater.inflate(R.layout.fragment_info, container, false);
        
        initializeWebView(topLevelView);
        
        return topLevelView;
    }
    
    /**
     * initializeWebView
     */
    private void initializeWebView(View topLevelView)
    {
        WebView webview = (WebView) topLevelView.findViewById(R.id.webview);
        webview.loadUrl("file:///android_asset/html/Info.html");
    }
}
