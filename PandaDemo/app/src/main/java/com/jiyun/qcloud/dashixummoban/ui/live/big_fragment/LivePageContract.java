package com.jiyun.qcloud.dashixummoban.ui.live.big_fragment;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.BigLiveBean;

/**
 * Created by my301s on 2017/8/26.
 */

public interface LivePageContract {
    interface LivePageView extends IBaseView<LivePagePresenter>{
        void getResult(BigLiveBean bigLiveBean);
    }
    interface LivePagePresenter extends IBasePresenter{

    }
}
