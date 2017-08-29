package com.jiyun.qcloud.dashixummoban.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class PersonActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.login_image)
    ImageView loginImage;
    @BindView(R.id.login_text)
    TextView loginText;
    @BindView(R.id.login)
    LinearLayout login;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.textt)
    TextView textt;
    @BindView(R.id.hostory)
    RelativeLayout hostory;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.text_cang)
    TextView textCang;
    @BindView(R.id.shoucang)
    RelativeLayout shoucang;
    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.text_set)
    TextView textSet;
    @BindView(R.id.set)
    RelativeLayout set;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_person;
    }

    @OnClick({R.id.login, R.id.hostory, R.id.shoucang, R.id.set,R.id.back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login:
                Intent intent = new Intent(PersonActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.hostory:
                break;
            case R.id.shoucang:
                break;
            case R.id.set:
                startActivity(new Intent(PersonActivity.this, ClearActivity.class));
                break;
            case R.id.back:
                finish();
                break;
        }

    }
}
