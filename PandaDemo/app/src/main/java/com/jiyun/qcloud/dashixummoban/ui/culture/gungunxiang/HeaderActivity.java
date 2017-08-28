package com.jiyun.qcloud.dashixummoban.ui.culture.gungunxiang;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class HeaderActivity extends BaseActivity {


    @BindView(R.id.headvideo)
    JCVideoPlayer headvidsasaseo;

    @Override
    protected void initData() {
        headvidsasaseo.setUp("http://cntv.vod.cdn.myqcloud.com/flash/mp4video61/TMS/2017/08/25/026839787dfb4eb597e724e835b44782_h264418000nero_aac32.mp4","《当熊不让》 20170825 第二十四期：大熊猫生日扎堆是什么体验？",true);
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
        return R.layout.activity_header;
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
