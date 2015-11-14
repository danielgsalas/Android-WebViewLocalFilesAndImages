package com.appstoremarketresearch.webviewlocalfilesandimages.view;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.appstoremarketresearch.webviewlocalfilesandimages.controller.InfoActivity;
import com.appstoremarketresearch.webviewlocalfilesandimages.controller.MediaActivity;
import com.appstoremarketresearch.webviewlocalfilesandimages.R;

public class HomeFragment extends Fragment
{
    @Override
    public View onCreateView(
        LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);
        
        View topLevelView = inflater.inflate(R.layout.fragment_home, container, false);
        
        initializeWebView(topLevelView);
        
        return topLevelView;
    }
    
    /**
     * initializeWebView
     */
    private void initializeWebView(View topLevelView)
    {
        WebView webview = (WebView) topLevelView.findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);        
        webview.addJavascriptInterface(new JavaScriptInterface(), "android");
        webview.loadUrl("file:///android_asset/html/Home.html");
    }
    
    /**
     * Java-JavaScript bridge
     */
    final class JavaScriptInterface
    {
        @JavascriptInterface
        public void requestPage(String pagename)
        {
            android.util.Log.w(this.getClass().getSimpleName(), "pagename=" + pagename);
            
            Activity activity = getActivity();
            
            if ("Info".equals(pagename))
            {
                Intent intent = new Intent(activity, InfoActivity.class);
                activity.startActivity(intent);
            }
            else if ("Media".equals(pagename))
            {
                Intent intent = new Intent(activity, MediaActivity.class);                
                activity.startActivity(intent);
            }
        }
    }
}
