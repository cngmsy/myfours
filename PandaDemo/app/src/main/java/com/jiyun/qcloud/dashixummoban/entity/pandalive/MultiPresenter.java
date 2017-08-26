package com.jiyun.qcloud.dashixummoban.entity.pandalive;

import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;
import com.jiyun.qcloud.dashixummoban.ui.live.panda_live.fragment.MultiContract;

/**
 * Created by w1565 on 2017/7/20.
 */

public class MultiPresenter implements MultiContract.MultiPresenter  {
    private MultiContract.MultiView multiView;
    private PandaHomeModelImpl modelImp;
    public MultiPresenter(MultiContract.MultiView multiView) {
        this.multiView = multiView;
        modelImp=new PandaHomeModelImpl();
        multiView.setPresenter(this);

    }

    @Override
    public void start() {
        modelImp.getMultiData(new NetWorkCallBack<MultiBean>() {
            @Override
            public void onSuccess(MultiBean multiBean) {
            //    multiView.showProgress();
                multiView.setResultData(multiBean);

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
