package com.jiyun.qcloud.dashixummoban.ui.live.detail_video;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.PandaVideoBean;

/**
 * Created by my301s on 2017/8/26.
 */

public interface PandaVideoContract {
    interface PandaVideoView extends IBaseView<PandaVideoPresenter>{
        void getResultData(PandaVideoBean pandaVideoBean);
    }
    interface PandaVideoPresenter extends IBasePresenter{
        void getURL(String url);
    }
}
