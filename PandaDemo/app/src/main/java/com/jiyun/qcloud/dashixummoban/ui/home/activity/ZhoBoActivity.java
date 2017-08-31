package com.jiyun.qcloud.dashixummoban.ui.home.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    private TextView titletext;
    private ImageView backimage;
    @Override
    protected void initData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        title = intent.getStringExtra("title");

        presenter.seconed(url);


            presenter.seconed(url);
        titletext.setText(title);
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void initView() {
        new ZhiPresenter(this);
        Vitamio.isInitialized(getContext());

        myview = (IjkPlayerView) findViewById(R.id.zhiboview);

        titletext = (TextView) findViewById(R.id.titletext);
        backimage = (ImageView) findViewById(R.id.back_image);
        backimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
//        if(View.VISIBLE==backimage.getVisibility())
//        {
//            backimage.setVisibility(View.GONE);
//            titletext.setVisibility(View.GONE);
//        }else {
//            if(View.VISIBLE!=backimage.getVisibility())
//            {
//                backimage.setVisibility(View.VISIBLE);
//        	/*处理其他逻辑*/
//            }
//        }


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
    //真正的沉浸式模式
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myview.stop();
    }
}
