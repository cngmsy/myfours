package com.jiyun.qcloud.dashixummoban.ui.live.tebie;

import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by my301s on 2017/8/25.
 */

public class TeBiePresenter implements TeBieContract.TeBiePresenter {
    private TeBieContract.TeBieView teBieView;
    private PandaHomeModelImpl pandaHomeModel;

    public TeBiePresenter(TeBieContract.TeBieView teBieView) {
        this.teBieView = teBieView;
        pandaHomeModel=new PandaHomeModelImpl();
        teBieView.setPresenter(this);
    }

    @Override
    public void start() {
      //  teBieView.showProgress();

    }

    @Override
    public void seconed(String url) {

    }

    @Override
    public void mapData(Map<String, String> map) {
        pandaHomeModel.getTeBie(map,new NetWorkCallBack<SplendBean>() {
            @Override
            public void onSuccess(SplendBean splendBean) {
                // teBieView.dimissProgress();
                teBieView.getResultdata(splendBean);
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
