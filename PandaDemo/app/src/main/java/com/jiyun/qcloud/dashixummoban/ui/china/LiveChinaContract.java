package com.jiyun.qcloud.dashixummoban.ui.china;


import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.china.ChinaTabBean;

/**
 * Created by w1565 on 2017/7/18.
 */

public interface LiveChinaContract {

    interface View extends IBaseView<LiveChinaContract.Presenter> {
        void showChinaTab(ChinaTabBean chinaTabBean);
    }

    interface Presenter extends IBasePresenter {}
}
