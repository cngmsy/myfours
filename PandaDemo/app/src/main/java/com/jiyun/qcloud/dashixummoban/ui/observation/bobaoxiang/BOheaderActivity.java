package com.jiyun.qcloud.dashixummoban.ui.observation.bobaoxiang;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class BOheaderActivity extends BaseActivity {


    @BindView(R.id.jcvideo)
    JCVideoPlayer jcvideo;

    @Override
    protected void initData() {
        jcvideo.setUp("http://vod.cntv.lxdns.com/flash/mp4video61/TMS/2017/08/24/9e05946212aa4e118528ff0e4cfb692a_h2641200000nero_aac16.mp4","华盛顿明星大熊猫“贝贝”迎2岁生日",true);

    }
    @Override
    protected void onResume() {
        super.onResume();
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        }
    }
    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_boheader;
    }
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
