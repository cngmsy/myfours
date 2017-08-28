package com.jiyun.qcloud.dashixummoban.ui.live.splendid;

import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.Map;


public class SplendidPresenter implements SplendidContract.SplendidPresenter {

    private SplendidContract.SplendidView splendidView;
    private PandaHomeModelImpl modelImp;
    public SplendidPresenter(SplendidContract.SplendidView splendidVie) {
        this.splendidView = splendidVie;
        modelImp=new PandaHomeModelImpl();
        splendidView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void seconed(String url) {

    }

    @Override
    public void mapData(Map<String, String> map) {
        modelImp.getSplendData(map,new NetWorkCallBack<SplendBean>() {
            @Override
            public void onSuccess(SplendBean splendBean) {
                //  splendidView.dimissProgress();
                splendidView.setResultData(splendBean);
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
