package com.jiyun.qcloud.dashixummoban.ui.observation;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.Bobao.Bo;
import com.jiyun.qcloud.dashixummoban.entity.Bobao.Bolist;

import java.util.List;

/**
 * Created by Administrator on 2017/8/24.
 */

public class ObContract {

    interface View extends IBaseView<ObContract.Presenter> {
        void showBoData(Bo bo);
        void showBoListData(List<Bolist.ListBean> list);
        void listener();
    }

    interface Presenter extends IBasePresenter {}
}
