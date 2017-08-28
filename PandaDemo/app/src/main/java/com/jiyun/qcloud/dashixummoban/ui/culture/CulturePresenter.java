package com.jiyun.qcloud.dashixummoban.ui.culture;

import android.util.Log;

import com.jiyun.qcloud.dashixummoban.entity.gungun.Gun;
import com.jiyun.qcloud.dashixummoban.modle.gunModel.CtltureImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;
import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2017/8/23.
 */

public class CulturePresenter implements CultureContract.Presenter{
    private CultureContract.View cultureview;
    private CtltureImpl ctltureModel;

    public CulturePresenter(CultureContract.View cultureview) {
        this.cultureview = cultureview;
        cultureview.setPresenter(this);
        this.ctltureModel = new CtltureImpl();
    }

    @Override
    public void start() {
        cultureview.showProgress();
        cultureview.listener();
        ctltureModel.getgun(new NetWorkCallBack<Gun>() {
            @Override
            public void onSuccess(Gun gun) {
                Log.d("gungun----------",gun.toString());
                Logger.d("gungun----------",gun.toString());
                cultureview.showGunlistData(gun);
                cultureview.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                    cultureview.showMessage(errorMsg);
                cultureview.dimissProgress();
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
