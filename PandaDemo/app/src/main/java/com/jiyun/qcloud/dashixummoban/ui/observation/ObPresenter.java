package com.jiyun.qcloud.dashixummoban.ui.observation;

import com.jiyun.qcloud.dashixummoban.entity.Bobao.Bo;
import com.jiyun.qcloud.dashixummoban.entity.Bobao.Bolist;
import com.jiyun.qcloud.dashixummoban.modle.gunModel.CtltureImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by Administrator on 2017/8/24.
 */

public class ObPresenter implements ObContract.Presenter{
    private ObContract.View obview;
    private CtltureImpl obModel;

    public ObPresenter(ObContract.View obview) {
        this.obview = obview;
        obview.setPresenter(this);
        this.obModel = new CtltureImpl();
    }

    @Override
    public void start() {
        obview.showProgress();
        obview.listener();
        obModel.getbo(new NetWorkCallBack<Bo>() {
            @Override
            public void onSuccess(Bo bo) {
                obview.showBoData(bo);
                obview.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                obview.showMessage(errorMsg);
                obview.dimissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }

    @Override
    public void seconed(String url) {
        obModel.getbolist(new NetWorkCallBack<Bolist>() {
            @Override
            public void onSuccess(Bolist bolist) {
                obview.showBoListData(bolist.getList());
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }

            @Override
            public void onFail(String netOff) {

            }
        },url);
    }

}
