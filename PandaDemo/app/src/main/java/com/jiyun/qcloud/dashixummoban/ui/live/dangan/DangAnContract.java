package com.jiyun.qcloud.dashixummoban.ui.live.dangan;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;

import java.util.Map;

/**
 * Created by my301s on 2017/8/25.
 */

public interface DangAnContract {
    interface DangAnView extends IBaseView<DangAnPresenter>{
        void setResultData(SplendBean resultData);
    }
    interface DangAnPresenter extends IBasePresenter{
        void mapData(Map<String,String> map);
    }
}
