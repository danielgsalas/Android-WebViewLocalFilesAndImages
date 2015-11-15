package com.appstoremarketresearch.webviewlocalfilesandimages.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.appstoremarketresearch.webviewlocalfilesandimages.R;

public class MediaFragment extends Fragment
{
    @Override
    public View onCreateView(
        LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);
        
        View topLevelView = inflater.inflate(R.layout.fragment_media, container, false);
        
        initializeWebViews(topLevelView);
        
        return topLevelView;
    }
    
    /**
     * initializeWebViews
     */
    private void initializeWebViews(View topLevelView)
    {
        WebView mediaPreview = (WebView) topLevelView.findViewById(R.id.media_preview);
        mediaPreview.getSettings().setJavaScriptEnabled(true);

        WebView mediaContent = (WebView) topLevelView.findViewById(R.id.media_content);
        mediaContent.getSettings().setJavaScriptEnabled(true);

        JSInterface jsi = new JSInterface(mediaContent);
        mediaPreview.addJavascriptInterface(jsi, "android");
        mediaContent.addJavascriptInterface(jsi, "android");

        mediaPreview.loadUrl("file:///android_asset/html/MediaPreview.html");
        mediaContent.loadUrl("file:///android_asset/html/MediaContent.html");
    }
    
    /**
     * Java-JavaScript bridge
     */
    final class JSInterface
    {
        private WebView mediaContent;
        
        public JSInterface(WebView mediaContent) 
        {
            this.mediaContent = mediaContent;
        }
        
        @JavascriptInterface
        public void showImage(final String imageName)
        {            
            // java.lang.Throwable: A WebView method was called on thread 'JavaBridge'.
            // All WebView methods must be called on the same thread.
            //mediaContent.loadUrl("javascript:showImage('" + imageName + "')");

            // pass the request from MediaPreview.html to MediaContent.html
            // by calling JavaScript on the Android UI thread not a background thread
            mediaContent.post(new Runnable() {
                public void run() {
                    mediaContent.loadUrl("javascript:showImage('" + imageName + "')");
                }
            });
        }
    }
}
