package com.jiyun.qcloud.dashixummoban.ui.live.panda_live;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.PandaLiveBean;

public interface LiveContract {
    interface LiveView extends IBaseView<LivePresenter> {
        void setResultData(PandaLiveBean resultData);
       // void setUrlurl(LivePanBean liveBean);
    }

    interface LivePresenter extends IBasePresenter {
        void setUrlurl(String url);
    }
}
