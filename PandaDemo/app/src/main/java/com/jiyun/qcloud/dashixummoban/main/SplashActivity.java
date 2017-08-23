package com.jiyun.qcloud.dashixummoban.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;

/**
 * Created by my301s on 2017/8/23.
 */

public class SplashActivity extends BaseActivity {
    private SharedPreferences shared;
    private SharedPreferences.Editor editor;

    @Override
    protected void initData() {
        shared = getSharedPreferences("data", MODE_PRIVATE);
        editor = shared.edit();
        Handler handler=new Handler();
        handler.postDelayed(runnable,2000);

    }
    public Runnable runnable=new Runnable(){
        @Override
        public void run() {
            if(shared.getBoolean("boo",true)){
                Intent in=new Intent(SplashActivity.this,WelComeActivity.class);
                startActivity(in);
                editor.putBoolean("boo",false);
                editor.commit();
                finish();
            }else {
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }
}
