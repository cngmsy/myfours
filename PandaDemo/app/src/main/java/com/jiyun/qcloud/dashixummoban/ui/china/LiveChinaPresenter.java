package com.jiyun.qcloud.dashixummoban.ui.china;

import com.jiyun.qcloud.dashixummoban.entity.china.ChinaTabBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.china.ChinaModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by w1565 on 2017/7/18.
 */

public class LiveChinaPresenter implements LiveChinaContract.Presenter {
    private LiveChinaContract.View  liveChinaView;
    private ChinaModelImpl  modelImp;

    public LiveChinaPresenter(LiveChinaContract.View liveChinaView) {
        this.liveChinaView = liveChinaView;
        modelImp=new ChinaModelImpl();
        liveChinaView.setPresenter(this);
    }

    @Override
    public void start() {

        modelImp.getChinaTab(new NetWorkCallBack<ChinaTabBean>() {
            @Override
            public void onSuccess(ChinaTabBean chinaTabBean) {
                liveChinaView.showChinaTab(chinaTabBean);
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
