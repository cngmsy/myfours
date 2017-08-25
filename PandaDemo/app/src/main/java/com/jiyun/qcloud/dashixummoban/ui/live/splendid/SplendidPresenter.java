package com.jiyun.qcloud.dashixummoban.ui.live.splendid;

import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;


public class SplendidPresenter implements SplendidContract.SplendidPresenter {

    private SplendidContract.SplendidView splendidView;
    private PandaHomeModelImpl modelImp;
    public SplendidPresenter(SplendidContract.SplendidView splendidView) {
        this.splendidView = splendidView;
        modelImp=new PandaHomeModelImpl();
        splendidView.setPresenter(this);
    }

    @Override
    public void start() {
   //     splendidView.showProgress();
        modelImp.getSplendData(new NetWorkCallBack<SplendBean>() {
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

    @Override
    public void seconed(String url) {

    }
}
