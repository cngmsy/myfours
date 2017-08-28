package com.jiyun.qcloud.dashixummoban.ui.live.news;

import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by my301s on 2017/8/25.
 */

public class NewsPresenter implements NewsContract.NewsPresenter {
    private NewsContract.NewsView newsView;
    private PandaHomeModelImpl pandaHomeModel;

    public NewsPresenter(NewsContract.NewsView newsView) {
        this.newsView = newsView;
        pandaHomeModel=new PandaHomeModelImpl();
        newsView.setPresenter(this);
    }

    @Override
    public void start() {
      //  newsView.showProgress();

    }

    @Override
    public void seconed(String url) {

    }

    @Override
    public void mapData(Map<String, String> map) {
        pandaHomeModel.getNews(map,new NetWorkCallBack<SplendBean>() {
            @Override
            public void onSuccess(SplendBean splendBean) {
                //   newsView.dimissProgress();
                newsView.getResult(splendBean);
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
