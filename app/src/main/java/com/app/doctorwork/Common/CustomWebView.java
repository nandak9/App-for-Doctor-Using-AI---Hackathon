package com.app.doctorwork.Common;

/**
 * Created by abhisheksingh on 11/24/17.
 */

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import com.app.doctorwork.R;
import com.app.doctorwork.Util.Log;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */

public class CustomWebView extends AppCompatActivity {

    String url = "";
    private WebView mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_custom_web_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getIntent().hasExtra("title")) {
            getSupportActionBar().setTitle(getIntent().getStringExtra("title"));
        } else {
            getSupportActionBar().setTitle(R.string.app_name);
        }
        toolbar.setTitleTextColor(getResources().getColor(R.color.defaultwhite));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_left_white_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.defaultwhite), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        mContentView = (WebView) findViewById(R.id.CustomWebview);
        mContentView.getSettings().setJavaScriptEnabled(true);
        mContentView.getSettings().setLoadWithOverviewMode(true);
        mContentView.getSettings().setUseWideViewPort(true);
        // mContentView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        mContentView.requestFocus(View.FOCUS_DOWN);
        mContentView.setWebChromeClient(new WebChromeClient());
        //if SDK version is greater of 19 then activate hardware acceleration otherwise activate software acceleration
        if (Build.VERSION.SDK_INT >= 19) {
            mContentView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT < 19) {
            mContentView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        url = getIntent().getStringExtra("url");
        //url = "https://docs.google.com/viewer?url=http://www.imdagrimet.gov.in/sites/default/files/daas_bulletin/19122017_English_GKMS__ZARS___Sangli_0.pdf";
        if (TextUtils.isEmpty(url)) {
            finish();
        }
        mContentView.setWebViewClient(new WebViewClient() {
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.loadingPlaceholder);

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                relativeLayout.setVisibility(View.VISIBLE);
                //mContentView.setVisibility(View.GONE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                relativeLayout.setVisibility(View.GONE);
                //mContentView.setVisibility(View.VISIBLE);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.d("abhi", url);

                if (url.contains("http://") || url.contains("https://")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                    return true;
                } else {
                    return false;
                }

            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.cancel();
                finish();
            }
        });
        mContentView.loadUrl(url);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}
