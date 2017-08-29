package com.jiyun.qcloud.dashixummoban.ui.observation.bobaodetail;

import com.jiyun.qcloud.dashixummoban.entity.Bobao.BoBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by my301s on 2017/8/29.
 */

public class BoPresenter implements BoContract.BoPresenter {
    private BoContract.BoView boView;
    private PandaHomeModelImpl pandaHomeModel;

    public BoPresenter(BoContract.BoView boView) {
        this.boView = boView;
        pandaHomeModel= new PandaHomeModelImpl();
        boView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void seconed(String url) {

    }

    @Override
    public void mapData(Map<String, String> map) {
        pandaHomeModel.getBoBaoDetail(map, new NetWorkCallBack<BoBean>() {
            @Override
            public void onSuccess(BoBean boBean) {
                boView.getData(boBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }
}
