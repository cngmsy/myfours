package com.jiyun.qcloud.dashixummoban.ui.live.naxie;

import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by my301s on 2017/8/25.
 */

public class NaXiePresenter implements NaXieContract.NaXiePresenter {
    private NaXieContract.NaXieView naXieView;
    private PandaHomeModelImpl pandaHomeModel;

    public NaXiePresenter(NaXieContract.NaXieView naXieView) {
        this.naXieView = naXieView;
        pandaHomeModel=new PandaHomeModelImpl();
        naXieView.setPresenter(this);
    }

    @Override
    public void start() {
      //  naXieView.showProgress();

    }

    @Override
    public void seconed(String url) {

    }

    @Override
    public void mapData(Map<String, String> map) {
        pandaHomeModel.getNaXie(map,new NetWorkCallBack<SplendBean>() {
            @Override
            public void onSuccess(SplendBean splendBean) {
                //     naXieView.dimissProgress();
                naXieView.getResultData(splendBean);
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
