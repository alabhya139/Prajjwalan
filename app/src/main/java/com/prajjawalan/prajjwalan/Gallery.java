package com.prajjawalan.prajjwalan;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by Alabhya Pandey on 13-04-2018.
 */

public class Gallery extends AppCompatActivity {

    private WebView webView;
    String url;
    ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_now);
        url = "www.google.com";

        webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar = findViewById(R.id.progressbar1);
                progressBar.setVisibility(ProgressBar.VISIBLE);
                webView.setVisibility(View.GONE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(ProgressBar.GONE);
                webView.setVisibility(View.VISIBLE);
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://pix.sfly.com/CapQboUP");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}