package com.example.b.a11_webview;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    ProgressDialog dlg;
    class MyWebViewClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            dlg.show();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            dlg.dismiss();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new MyWebViewClient());

        dlg = new ProgressDialog(this);

        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);

        webView.loadUrl("http://www.naver.com");
    }

    public void onBtnClick(View v){
        EditText editURL = (EditText) findViewById(R.id.editURL);
        webView.loadUrl(editURL.getText().toString());
    }
}
