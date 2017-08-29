package com.jiyun.qcloud.dashixummoban.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.activity.PersonActivity;
import com.jiyun.qcloud.dashixummoban.activity.ShareActivity;
import com.jiyun.qcloud.dashixummoban.app.App;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.manager.FragmentMager;
import com.jiyun.qcloud.dashixummoban.ui.china.ChinaPageFragment;
import com.jiyun.qcloud.dashixummoban.ui.culture.CulturePageFragment;
import com.jiyun.qcloud.dashixummoban.ui.home.HomePageFragment;
import com.jiyun.qcloud.dashixummoban.ui.home.HomePresenter;
import com.jiyun.qcloud.dashixummoban.ui.live.big_fragment.LivePageFragment;
import com.jiyun.qcloud.dashixummoban.ui.observation.ObServationFragment;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.OnClick;
import util.UpdateAppUtils;

/**
 * Created by chj on 2017/8/20.
 */

public class MainActivity extends BaseActivity {
    @BindView(R.id.iconImg)
    ImageView iconImg;
    @BindView(R.id.personImg)
    ImageView personImg;
    @BindView(R.id.titleTv)
    TextView titleTv;
    @BindView(R.id.hudongImg)
    ImageView hudongImg;
    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.homePage)
    RadioButton homePage;
    @BindView(R.id.homePandaLive)
    RadioButton homePandaLive;
    @BindView(R.id.homeRollVideo)
    RadioButton homeRollVideo;
    @BindView(R.id.homePandaBroadcast)
    RadioButton homePandaBroadcast;
    @BindView(R.id.homeLiveChina)
    RadioButton homeLiveChina;
    @BindView(R.id.homeBottomGroup)
    RadioGroup homeBottomGroup;
    private FragmentManager fragmentManager;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private boolean isfirst = true;

    @Override
    protected void initData() {
        fragmentManager = App.mBaseActivity.getSupportFragmentManager();
        HomePageFragment homeFragment = (HomePageFragment) FragmentMager.getInstance().start(R.id.container, HomePageFragment.class, false).build();
        //presenter在这里初始化
        new HomePresenter(homeFragment);

        //版本更新
        UpdateAppUtils.from(this)//Activity名
                .serverVersionCode(2)  //服务器versionCode
                .serverVersionName("2.0") //服务器versionName
                .apkPath("http://123.206.14.104:8080/FileUploadDemo/files/app-debug.apk") //最新apk下载地址
                .update();
    }

    @Override
    protected void initView() {
//打印屏幕分辨率
        Display display = getWindowManager().getDefaultDisplay();
        Log.e("width-display :", display.getWidth() + "");
        Log.e("heigth-display :", display.getHeight() + "");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick({R.id.homePage, R.id.homePandaLive, R.id.homeRollVideo, R.id.homePandaBroadcast, R.id.homeLiveChina})
    public void onClicks(View view) {
        switch (view.getId()) {
            case R.id.homePage:
                iconImg.setVisibility(View.VISIBLE);
                titleTv.setText("");
                hudongImg.setVisibility(View.VISIBLE);
                FragmentMager.getInstance().start(R.id.container, HomePageFragment.class, false).build();
                Logger.d("22222");
                break;
            case R.id.homePandaLive:
                iconImg.setVisibility(View.GONE);
                titleTv.setText("熊猫直播");
                hudongImg.setVisibility(View.GONE);
                FragmentMager.getInstance().start(R.id.container, LivePageFragment.class, false).build();
                Logger.d("33333");
                break;
            case R.id.homeRollVideo:
                iconImg.setVisibility(View.GONE);
                titleTv.setText("滚滚视频");
                hudongImg.setVisibility(View.GONE);
                FragmentMager.getInstance().start(R.id.container, CulturePageFragment.class, false).build();
                break;
            case R.id.homePandaBroadcast:
                iconImg.setVisibility(View.GONE);
                titleTv.setText("熊猫播报");
                hudongImg.setVisibility(View.GONE);
                FragmentMager.getInstance().start(R.id.container, ObServationFragment.class, false).build();
                break;
            case R.id.homeLiveChina:
                iconImg.setVisibility(View.GONE);
                titleTv.setText("直播中国");
                hudongImg.setVisibility(View.GONE);
                FragmentMager.getInstance().start(R.id.container, ChinaPageFragment.class, false).build();
                break;
        }
    }

    private long firstTime = 0;

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                long secondTime = System.currentTimeMillis();
                if (secondTime - firstTime > 2000) {
                    Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    firstTime = secondTime;
                    return true;
                } else {
                    System.exit(0);
                }
                break;
        }
        return super.onKeyUp(keyCode, event);
    }

    @OnClick({R.id.personImg, R.id.hudongImg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.personImg:
                startActivity( new Intent(MainActivity.this, PersonActivity.class));
                break;
            case R.id.hudongImg:
                startActivity( new Intent(MainActivity.this, ShareActivity.class));
                break;
        }
    }
}




