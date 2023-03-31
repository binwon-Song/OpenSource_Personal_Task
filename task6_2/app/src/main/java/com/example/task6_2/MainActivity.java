package com.example.task6_2;


import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edtUrl;
    Button btnGo,btnBack;
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUrl = (EditText)findViewById(R.id.etUrl);
        btnGo = (Button)findViewById(R.id.btnMove);
        btnBack = (Button)findViewById(R.id.btnBack);
        web = (WebView)findViewById(R.id.webView);

        web.setWebViewClient(new WebViewClient());

        WebSettings webset = web.getSettings();
        webset.setBuiltInZoomControls(true);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.loadUrl(edtUrl.getText().toString());
            }
        });// btnGo

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.goBack();
            }
        });//btnBack
    }

    class WebViewClient extends android.webkit.WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }//Web
}
