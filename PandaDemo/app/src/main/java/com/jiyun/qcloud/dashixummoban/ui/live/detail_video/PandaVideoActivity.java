package com.jiyun.qcloud.dashixummoban.ui.live.detail_video;

import android.content.Intent;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.PandaVideoBean;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class PandaVideoActivity extends BaseActivity implements PandaVideoContract.PandaVideoView{

    private JCVideoPlayer panda_video;
    private String video_url;
    PandaVideoContract.PandaVideoPresenter pandaVideoPresenter;

    @Override
    protected void initData() {
        pandaVideoPresenter=new PandaVideoPresenter(this);
        pandaVideoPresenter.getURL(video_url);

    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        video_url = intent.getStringExtra("video_url");
        panda_video = (JCVideoPlayer) findViewById(R.id.panda_video);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_panda_video;
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
    public void setPresenter(PandaVideoContract.PandaVideoPresenter pandaVideoPresente) {
        this.pandaVideoPresenter=pandaVideoPresente;
    }

    @Override
    public void getResultData(PandaVideoBean pandaVideoBean) {
        String url = pandaVideoBean.getVideo().getChapters().get(0).getUrl();
        String title = pandaVideoBean.getTitle();
        panda_video.setUp(url,title);
    }

    @Override
    protected void onResume() {
       //设置为横屏
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
