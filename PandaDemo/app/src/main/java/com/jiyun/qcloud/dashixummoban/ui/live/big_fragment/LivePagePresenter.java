package com.jiyun.qcloud.dashixummoban.ui.live.big_fragment;

import com.jiyun.qcloud.dashixummoban.entity.pandalive.BigLiveBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by my301s on 2017/8/26.
 */

public class LivePagePresenter implements LivePageContract.LivePagePresenter {
    private LivePageContract.LivePageView livePageView;
    private PandaHomeModelImpl pandaHomeModel;

    public LivePagePresenter(LivePageContract.LivePageView livePageView) {
        this.livePageView = livePageView;
        pandaHomeModel=new PandaHomeModelImpl();
        livePageView.setPresenter(this);
    }

    @Override
    public void start() {
        pandaHomeModel.getLivaPage(new NetWorkCallBack<BigLiveBean>() {
            @Override
            public void onSuccess(BigLiveBean bigLiveBean) {
                livePageView.getResult(bigLiveBean);
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
