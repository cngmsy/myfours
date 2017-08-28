package com.jiyun.qcloud.dashixummoban.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Handler;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.entity.share.ShareBean;

import java.lang.reflect.Method;

public class ShareDetailActivity extends BaseActivity implements View.OnClickListener {

    private WebView webview;
    private ImageView share;
    private ImageView share_back;
    private ShareBean.InteractiveBean data;
    private TextView share_title;

    @Override
    protected void initData() {
        share_title.setText(data.getTitle());
        webview.setVisibility(View.GONE);
        webview.getSettings().setBuiltInZoomControls(false);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webview.getSettings().setBlockNetworkImage(true);
        webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webview.getSettings().setAllowFileAccess(true);
        webview.getSettings().setAppCacheEnabled(true);
        webview.getSettings().setSaveFormData(false);
        webview.getSettings().setLoadsImagesAutomatically(true);

        //禁用硬件加速
        Method method = null;
        try {
            method =WebView.class.getMethod("setLayerType", int.class, Paint.class);
            method.setAccessible(true);
            method.invoke(webview, 1, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                webview.getSettings().setBlockNetworkImage(false);
            }
        }, 1000);
        webview.loadUrl(data.getUrl());
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
//结束
                super.onPageFinished(view, url);
                webview.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        data = (ShareBean.InteractiveBean) intent.getSerializableExtra("data");

        share_back = (ImageView) findViewById(R.id.share_back);
        share = (ImageView) findViewById(R.id.share);
        webview = (WebView) findViewById(R.id.webview);
        share_title = (TextView) findViewById(R.id.share_title);

        share.setOnClickListener(this);
        share_back.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_share_detail;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.share:
                break;
            case R.id.share_back:
                finish();
                break;
        }
    }
}
