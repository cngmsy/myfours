package com.jiyun.qcloud.dashixummoban.ui.live.panda_live;

import android.util.Log;

import com.jiyun.qcloud.dashixummoban.entity.pandalive.LiveVideoBean;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.PandaLiveBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

public class LivePresenter implements LiveContract.LivePresenter {
    private LiveContract.LiveView liveView;
    private PandaHomeModelImpl modelImp;

    public LivePresenter(LiveContract.LiveView liveView) {
        this.liveView = liveView;
        modelImp = new PandaHomeModelImpl();
        liveView.setPresenter(this);
    }


    @Override
    public void start() {
        modelImp.getPandaLive(new NetWorkCallBack<PandaLiveBean>() {
            @Override
            public void onSuccess(PandaLiveBean pandaLiveBean) {
                liveView.setResultData(pandaLiveBean);
                Log.d("LivePresenter", liveView.toString());
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


    @Override
    public void setURL(String url) {
        modelImp.getPandaVideoData(url, new NetWorkCallBack<LiveVideoBean>() {
            @Override
            public void onSuccess(LiveVideoBean liveVideoBean) {
                liveView.setUrlurl(liveVideoBean);
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
