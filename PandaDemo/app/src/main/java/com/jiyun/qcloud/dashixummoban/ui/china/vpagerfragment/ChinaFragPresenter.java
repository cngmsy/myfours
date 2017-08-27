package com.jiyun.qcloud.dashixummoban.ui.china.vpagerfragment;

import com.jiyun.qcloud.dashixummoban.entity.china.ChinaFragmentBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.china.ChinaModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by liuwangping on 2017/8/24.
 */

public class ChinaFragPresenter implements ChinaFragContract.Presenter {
    private String url;
    private ChinaFragContract.View chinafragView;
    private ChinaModelImpl modelImp;;

    public ChinaFragPresenter(ChinaFragContract.View chinafragView) {
        this.chinafragView = chinafragView;
        modelImp=new ChinaModelImpl();
        chinafragView.setPresenter(this);
    }

    @Override
    public String getStringUrl(String url) {
        this.url=url;
        return url;
    }

    @Override
    public void start() {
        chinafragView.showProgress();
        modelImp.getFragment(url, new NetWorkCallBack<ChinaFragmentBean>() {
            @Override
            public void onSuccess(ChinaFragmentBean fragmentBean) {
                chinafragView.showFragment(fragmentBean);
                chinafragView.dimissProgress();

            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                chinafragView.dimissProgress();
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
