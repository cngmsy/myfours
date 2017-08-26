package com.jiyun.qcloud.dashixummoban.ui.live.chaomeng;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;

import java.util.Map;

/**
 * Created by my301s on 2017/8/25.
 */

public interface ChaoMengContact {
    interface ChaoMengView extends IBaseView<ChaoMengPresenter>{
        void setResultData(SplendBean resultData);
    }
    interface ChaoMengPresenter extends IBasePresenter{
        void mapData(Map<String,String> map);
    }
}
