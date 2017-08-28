package com.jiyun.qcloud.dashixummoban.ui.live.top;

import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by my301s on 2017/8/25.
 */

public class TopPresenter implements  TopContract.TopPresenter {
    private TopContract.TopView topView;
    private PandaHomeModelImpl pandaHomeModel;

    public TopPresenter(TopContract.TopView topView) {
        this.topView = topView;
        pandaHomeModel= new PandaHomeModelImpl();
        topView.setPresenter(this);
    }

    @Override
    public void start() {
      //  topView.showProgress();

    }

    @Override
    public void seconed(String url) {

    }

    @Override
    public void mapData(Map<String, String> map) {
        pandaHomeModel.getTop(map,new NetWorkCallBack<SplendBean>() {
            @Override
            public void onSuccess(SplendBean splendBean) {
                //  topView.dimissProgress();
                topView.getResult(splendBean);
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
