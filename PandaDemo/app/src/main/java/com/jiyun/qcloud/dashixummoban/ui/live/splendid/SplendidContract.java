package com.jiyun.qcloud.dashixummoban.ui.live.splendid;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;

import java.util.Map;


public interface SplendidContract {

    interface SplendidView extends IBaseView<SplendidPresenter> {
        void setResultData(SplendBean resultData);
    }

    interface SplendidPresenter extends IBasePresenter {
        void mapData(Map<String,String> map);

    }
}
