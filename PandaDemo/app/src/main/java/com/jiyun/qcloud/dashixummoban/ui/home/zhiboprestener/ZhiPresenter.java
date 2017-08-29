package com.jiyun.qcloud.dashixummoban.ui.home.zhiboprestener;

import com.jiyun.qcloud.dashixummoban.entity.homeentily.XiuChang;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.VideoListModel;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.VideoModelimp;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by Administrator on 2017/8/27.
 */

public class ZhiPresenter implements ZhiContract.Presenter {
    private ZhiContract.View  videoView;
    private VideoListModel  videoListModel;
    public ZhiPresenter(ZhiContract.View videoView) {
        this.videoView = videoView;
        videoView.setPresenter(this);
        this.videoListModel = new  VideoModelimp();
    }

    @Override
    public void start() {

    }

    @Override
    public void seconed(String url) {
        videoView.showProgress();
        videoListModel.getZhiBo(url, new NetWorkCallBack<XiuChang>() {
            @Override
            public void onSuccess(XiuChang xiuChang) {
                videoView.showVideoList(xiuChang);
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
