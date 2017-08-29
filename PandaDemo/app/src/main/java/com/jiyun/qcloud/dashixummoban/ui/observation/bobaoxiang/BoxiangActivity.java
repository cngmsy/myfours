package com.jiyun.qcloud.dashixummoban.ui.observation.bobaoxiang;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.entity.Bobao.BoBean;
import com.jiyun.qcloud.dashixummoban.ui.observation.bobaodetail.BoContract;
import com.jiyun.qcloud.dashixummoban.ui.observation.bobaodetail.BoPresenter;
import com.jiyun.qcloud.dashixummoban.ui.observation.imageloder.MyTagHandler;
import com.jiyun.qcloud.dashixummoban.ui.observation.imageloder.URLImageParser;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;

public class BoxiangActivity extends BaseActivity implements BoContract.BoView {


    private BoContract.BoPresenter boPresenter;
    private Map<String, String> map = new HashMap<>();
    private String id;
    private TextView tvBxcontent,title,soure,time;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        boPresenter = new BoPresenter(this);
        map.put("id", id);
        map.put("serviceId", "panda");
        boPresenter.mapData(map);
    }

    @Override
    protected void initView() {
        tvBxcontent = (TextView) findViewById(R.id.tv_bxcontent);
        title = (TextView) findViewById(R.id.tv_bxtitle);
        soure = (TextView) findViewById(R.id.tv_bxsource);
        time = (TextView) findViewById(R.id.tv_bxpubtime);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_boxiang;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
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
    public void setPresenter(BoContract.BoPresenter boPresente) {
        this.boPresenter = boPresente;
    }

    @Override
    public void getData(BoBean boBean) {
        MyTagHandler myTagHandler = new MyTagHandler(this);
        tvBxcontent.setText(Html.fromHtml(boBean.getContent(), new URLImageParser(tvBxcontent, this), myTagHandler));
        tvBxcontent.setMovementMethod(ScrollingMovementMethod.getInstance());
        title.setText(boBean.getTitle());
        time.setText(boBean.getPubtime());
        soure.setText(boBean.getSource());
    }
}
