package com.jiyun.qcloud.dashixummoban.ui.live.detail_video;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.PandaVideoBean;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMVideo;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class PandaVideoActivity extends BaseActivity implements PandaVideoContract.PandaVideoView, View.OnClickListener {

    private JCVideoPlayer panda_video;
    private String video_url;
    PandaVideoContract.PandaVideoPresenter pandaVideoPresenter;
    private ImageView share_bt;
    private String url;
    private String title;

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
        share_bt = (ImageView) findViewById(R.id.share_bt);
        share_bt.setOnClickListener(this);
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
        url = pandaVideoBean.getVideo().getChapters().get(0).getUrl();
        title = pandaVideoBean.getTitle();
        panda_video.setUp(url, title);
    }

  /*  @Override
    protected void onResume() {
        super.onResume();
        *//**
         * 设置为横屏
         *//*
        if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }*/

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onClick(View view) {
        UMVideo video = new UMVideo(url);
        video.setTitle(title);//视频的标题
       // video.setThumb("http://www.umeng.com/images/pic/social/chart_1.png");//视频的缩略图
        video.setDescription("熊猫的日常");//视频的描述
        new ShareAction(PandaVideoActivity.this)
                .withMedia(video)
                .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                .setCallback(shareListener)
                .open();
    }
    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(PandaVideoActivity.this,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(PandaVideoActivity.this,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(PandaVideoActivity.this,"取消了",Toast.LENGTH_LONG).show();

        }
    };


}
