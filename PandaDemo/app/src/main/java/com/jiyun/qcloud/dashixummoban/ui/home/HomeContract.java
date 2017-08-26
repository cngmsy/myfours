package com.jiyun.qcloud.dashixummoban.ui.home;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.entity.homeentily.BillowingBean;
import com.jiyun.qcloud.dashixummoban.entity.homeentily.WonderfulBean;

/**
 * Created by chj on 2017/8/21.
 * 这是难点(约定接口协议)
 */

public class HomeContract {

    interface View extends IBaseView<Presenter> {
        void showHomeListData(PandaHome pandaHome, WonderfulBean wonderfulBean, BillowingBean billowingBean);
        void playVideo();
        void loadWebView();
    }

    interface Presenter extends IBasePresenter {}
}
