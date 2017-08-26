package com.jiyun.qcloud.dashixummoban.ui.live.news;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;

import java.util.Map;

/**
 * Created by my301s on 2017/8/25.
 */

public interface NewsContract {
    interface NewsView extends IBaseView<NewsPresenter> {
        void getResult(SplendBean splendBean);
    }
    interface NewsPresenter extends IBasePresenter{
        void mapData(Map<String,String> map);
    }
}
