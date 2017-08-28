package com.jiyun.qcloud.dashixummoban.ui.live.chaomeng;

import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by my301s on 2017/8/25.
 */

public class ChaoMengPresenter implements ChaoMengContact.ChaoMengPresenter {
    private ChaoMengContact.ChaoMengView chaoMengView;
    private PandaHomeModelImpl pandaHomeModel;

    public ChaoMengPresenter(ChaoMengContact.ChaoMengView chaoMengView) {
        this.chaoMengView = chaoMengView;
        pandaHomeModel=new PandaHomeModelImpl();
        chaoMengView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void seconed(String url) {

    }

    @Override
    public void mapData(Map<String, String> map) {
          //  chaoMengView.showProgress();
        pandaHomeModel.getChaoMengData(map,new NetWorkCallBack<SplendBean>() {
            @Override
            public void onSuccess(SplendBean splendBean) {
             //  chaoMengView.dimissProgress();
                chaoMengView.setResultData(splendBean);
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
