package com.jiyun.qcloud.dashixummoban.ui.live.dangxiong;

import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by my301s on 2017/8/25.
 */

public class DangXiongPresenter implements DangXiongContract.DangXiongPresenter {
    private DangXiongContract.DangXiongView dangXiongView;
    private PandaHomeModelImpl pandaHomeModel;

    public DangXiongPresenter(DangXiongContract.DangXiongView dangXiongView) {
        this.dangXiongView = dangXiongView;
        pandaHomeModel= new PandaHomeModelImpl();
        dangXiongView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void seconed(String url) {

    }

    @Override
    public void mapData(Map<String, String> map) {
        pandaHomeModel.getDangXiongData(map,new NetWorkCallBack<SplendBean>() {
            @Override
            public void onSuccess(SplendBean splendBean) {
                dangXiongView.setResultData(splendBean);
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
