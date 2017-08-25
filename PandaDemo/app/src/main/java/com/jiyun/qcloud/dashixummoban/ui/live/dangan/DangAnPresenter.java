package com.jiyun.qcloud.dashixummoban.ui.live.dangan;

import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by my301s on 2017/8/25.
 */

public class DangAnPresenter implements DangAnContract.DangAnPresenter {
    private DangAnContract.DangAnView dangAnView;
    private PandaHomeModelImpl pandaHomeModel;

    public DangAnPresenter(DangAnContract.DangAnView dangAnView) {
        this.dangAnView = dangAnView;
        pandaHomeModel=new PandaHomeModelImpl();
        dangAnView.setPresenter(this);
    }

    @Override
    public void start() {
     //   dangAnView.showProgress();
        pandaHomeModel.getDangAn(new NetWorkCallBack<SplendBean>() {
            @Override
            public void onSuccess(SplendBean splendBean) {
           //     dangAnView.dimissProgress();
                dangAnView.setResultData(splendBean);
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
