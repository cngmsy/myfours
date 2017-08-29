package com.jiyun.qcloud.dashixummoban.ui.home.videoprestener;

import com.jiyun.qcloud.dashixummoban.entity.homeentily.MovieBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.VideoListModel;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.VideoModelimp;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by Administrator on 2017/8/27.
 */

public class VideoPresenter implements VideoContract.Presenter {
    private VideoContract.View  videoView;
    private VideoListModel  videoListModel;
    public VideoPresenter(VideoContract.View videoView) {
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
        videoListModel.getVideoList(url, new NetWorkCallBack<MovieBean>() {
            @Override
            public void onSuccess(MovieBean movieBean) {
                videoView.showVideoList(movieBean);
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
