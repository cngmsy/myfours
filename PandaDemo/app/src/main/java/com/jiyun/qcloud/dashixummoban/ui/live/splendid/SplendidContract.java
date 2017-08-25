package com.jiyun.qcloud.dashixummoban.ui.live.splendid;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;

/**
 * Created by 魏柯柯 on 2017/7/19.
 */

public interface SplendidContract {

    interface SplendidView extends IBaseView<SplendidPresenter> {
        void setResultData(SplendBean resultData);
    }

    interface SplendidPresenter extends IBasePresenter {

    }
}
