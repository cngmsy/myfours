package com.jiyun.qcloud.dashixummoban.ui.observation.bobaoxiang;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BoxiangActivity extends BaseActivity {


    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.img_cang)
    ImageView imgCang;
    @BindView(R.id.img_share)
    ImageView imgShare;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        WebSettings webSettings = webview.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webview.loadUrl(url);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_boxiang;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
