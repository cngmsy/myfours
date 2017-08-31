package com.jiyun.qcloud.dashixummoban.ui.home.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;

import com.dl7.player.media.IjkPlayerView;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.entity.homeentily.XiuChang;
import com.jiyun.qcloud.dashixummoban.ui.home.zhiboprestener.ZhiContract;
import com.jiyun.qcloud.dashixummoban.ui.home.zhiboprestener.ZhiPresenter;

import io.vov.vitamio.Vitamio;

import static com.umeng.socialize.utils.ContextUtil.getContext;

public class ZhoBoActivity extends BaseActivity implements ZhiContract.View {


    private ZhiContract.Presenter presenter;
    private String title;
    private IjkPlayerView myview;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        title = intent.getStringExtra("title");
        presenter.seconed(url);

    }

    @Override
    protected void initView() {
        new ZhiPresenter(this);
        Vitamio.isInitialized(getContext());
        myview = (IjkPlayerView) findViewById(R.id.zhiboview);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_zho_bo;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dimissProgress() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(ZhiContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showVideoList(XiuChang xiuChang) {
        XiuChang.FlvUrlBean flv_url = xiuChang.getFlv_url();
        String flv1 = flv_url.getFlv2();
        myview.init().setVideoPath(flv1).start();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myview.stop();
    }
}
