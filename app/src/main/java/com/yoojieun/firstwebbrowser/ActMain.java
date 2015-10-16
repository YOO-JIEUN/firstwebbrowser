package com.yoojieun.firstwebbrowser;

/**
 * Created by yoojieun on 15. 9. 25..
 */

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActMain extends Activity {
    private Context mContext;
    private WebView mWebView;
    private EditText mEtAddress;
    private Button mBtnGo;
    private Button mBtnBack;
    private Button mBtnQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        this.mContext = this;

        mWebView = (WebView) findViewById(R.id.wv_act_main);
        mWebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);

        mBtnBack = (Button) findViewById(R.id.btn_back_act_main);
        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mWebView.canGoBack()) {
                    mWebView.goBack();
                } else {
                    Toast.makeText(ActMain.this, "마지막 페이지 입니다", Toast.LENGTH_LONG).show();
                }
            }
        });

        mEtAddress = (EditText) findViewById(R.id.et_address_act_main);

        mBtnGo = (Button) findViewById(R.id.btn_go_act_main);
        mBtnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlStr = mEtAddress.getText().toString();

                if (!urlStr.startsWith("http://")) {
                    urlStr = "http://" + urlStr;
                }
                mWebView.loadUrl(urlStr);
            }
        });
        mBtnQuit = (Button) findViewById(R.id.btn_quit_act_main);
        mBtnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        mWebView.loadUrl("http://google.com");
    }
}


