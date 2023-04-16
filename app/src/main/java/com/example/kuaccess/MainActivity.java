package com.example.kuaccess;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myWebView = findViewById(R.id.webView);
        myWebView = findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setSupportZoom(true);
        webSettings.setDefaultTextEncodingName("utf-8");
        myWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);


                if (url.equals("https://ltracy97.github.io/Report.html?")|| url.equals("https://ltracy97.github.io/index.html") || url.equals("https://ltracy97.github.io/Confirm.html")) {
                    // Show the WebView and hide the buttons
                    myWebView.setVisibility(View.VISIBLE);
                    findViewById(R.id.myButton).setVisibility(View.GONE);
                    findViewById(R.id.myButton2).setVisibility(View.GONE);
                } else {
                    // Hide the WebView and show the buttons
                    myWebView.setVisibility(View.GONE);
                    findViewById(R.id.myButton).setVisibility(View.VISIBLE);
                    findViewById(R.id.myButton2).setVisibility(View.VISIBLE);
                }
            }
        });


        Button callButton = findViewById(R.id.myButton);

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "17858645900"; // Replace with your own phone number
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(dialIntent);
            }
        });
        Button webButton = findViewById(R.id.myButton2);

        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myWebView.bringToFront();
                myWebView.loadUrl("https://ltracy97.github.io/Report.html?");
            }
        });
    }
    @Override
    public void onBackPressed() {
        if (myWebView.getVisibility() == View.VISIBLE) {
            // Hide the WebView and show the buttons
            myWebView.setVisibility(View.GONE);
            findViewById(R.id.myButton).setVisibility(View.VISIBLE);
            findViewById(R.id.myButton2).setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();
        }

    }
}
