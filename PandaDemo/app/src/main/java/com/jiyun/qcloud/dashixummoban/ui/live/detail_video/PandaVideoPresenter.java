package com.jiyun.qcloud.dashixummoban.ui.live.detail_video;

import com.jiyun.qcloud.dashixummoban.entity.pandalive.PandaVideoBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by my301s on 2017/8/26.
 */

public class PandaVideoPresenter implements PandaVideoContract.PandaVideoPresenter {
    private PandaVideoContract.PandaVideoView pandaVideoView;
    private PandaHomeModelImpl pandaHomeModel;

    public PandaVideoPresenter(PandaVideoContract.PandaVideoView pandaVideoView) {
        this.pandaVideoView = pandaVideoView;
        pandaHomeModel=new PandaHomeModelImpl();
        pandaVideoView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void seconed(String url) {

    }

    @Override
    public void getURL(String url) {
        pandaHomeModel.getVideoData(url, new NetWorkCallBack<PandaVideoBean>() {
            @Override
            public void onSuccess(PandaVideoBean pandaVideoBean) {
                pandaVideoView.getResultData(pandaVideoBean);
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
