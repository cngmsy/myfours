package com.jiyun.qcloud.dashixummoban.ui.china.vpagerfragment;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.china.ChinaFragmentBean;

/**
 * Created by liuwangping on 2017/8/24.
 */

public class ChinaFragContract {

    interface View extends IBaseView<ChinaFragContract.Presenter> {
        void showFragment(ChinaFragmentBean fragmentBean);
    }

    interface Presenter extends IBasePresenter {
        String getStringUrl(String url);

    }
}
