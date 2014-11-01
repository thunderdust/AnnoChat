
package com.example.voice_rcd;

//import com.chat.anno.selector.TextSelectionSupport;
import com.bossturban.webviewmarker.TextSelectionSupport;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class DocumentViewActivity extends Activity {
    private WebView mWebView;
    private TextSelectionSupport mTextSelectionSupport;
    private String TAG = "document view activity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_view);
        mWebView = (WebView)findViewById(R.id.webView);
        
        mTextSelectionSupport = TextSelectionSupport.support(this, mWebView);
        mTextSelectionSupport.setSelectionListener(new TextSelectionSupport.SelectionListener() {
            @Override
            public void startSelection() {
            }
            @Override
            public void selectionChanged(String text) {
                Toast.makeText(DocumentViewActivity.this, "Annotated", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void endSelection() {
            }
        });
        mWebView.setWebViewClient(new WebViewClient() {
            public void onScaleChanged(WebView view, float oldScale, float newScale) {
                mTextSelectionSupport.onScaleChanged(oldScale, newScale);
            }
        });
        mWebView.loadUrl("file:///android_asset/content.html");
    }
}

