package com.jiyun.qcloud.dashixummoban.ui.live.panda_live.fragment;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.MultiBean;

/**
 * Created by w1565 on 2017/7/20.
 */

public interface MultiContract {

    interface MultiView extends IBaseView<MultiPresenter> {
        void setResultData(MultiBean resultData);
    }

    interface MultiPresenter extends IBasePresenter {

    }
}
