package com.jiyun.qcloud.dashixummoban.ui.home.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.entity.homeentily.MovieBean;
import com.jiyun.qcloud.dashixummoban.ui.home.videoprestener.VideoContract;
import com.jiyun.qcloud.dashixummoban.ui.home.videoprestener.VideoPresenter;

import java.util.List;

import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class JCVideoActivity extends BaseActivity implements VideoContract.View{

    private JCVideoPlayer jcvView;
    private VideoContract.Presenter presenter;
    private String url;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        new VideoPresenter(this);
        ButterKnife.bind(this);
        jcvView = (JCVideoPlayer) findViewById(R.id.jcv_view);
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        presenter.start();
        presenter.seconed(url);
    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_jcvideo;

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        JCVideoPlayer.releaseAllVideos();
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
    public void setPresenter(VideoContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showVideoList(MovieBean movieBean) {
        MovieBean.VideoBean video = movieBean.getVideo();
        List<MovieBean.VideoBean.Chapters2Bean> chapters2 = video.getChapters2();
        MovieBean.VideoBean.Chapters2Bean chapters2Bean = chapters2.get(0);
        String url = chapters2Bean.getUrl();
        String title = movieBean.getTitle();
        jcvView.setUp(url,title);

        /**
         * 设置为横屏
         */
        if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }


    }
}
