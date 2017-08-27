package com.jiyun.qcloud.dashixummoban.activity.sharepresent;

import com.jiyun.qcloud.dashixummoban.entity.share.ShareBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by my301s on 2017/8/27.
 */

public class SharePresenter implements ShareContract.SharePresenter{
    private ShareContract.ShareView shareView;
    private PandaHomeModelImpl pandaHomeModel;

    public SharePresenter(ShareContract.ShareView shareView) {
        this.shareView = shareView;
        pandaHomeModel= new PandaHomeModelImpl();
        shareView.setPresenter(this);
    }

    @Override
    public void start() {
        pandaHomeModel.getShareData(new NetWorkCallBack<ShareBean>() {
            @Override
            public void onSuccess(ShareBean shareBean) {
                shareView.getResult(shareBean);
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
