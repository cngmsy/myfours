package com.jiyun.qcloud.dashixummoban.ui.live.top;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;

import java.util.Map;

/**
 * Created by my301s on 2017/8/25.
 */

public interface TopContract {
    interface TopView extends IBaseView<TopPresenter>{
        void getResult(SplendBean splendBean);
    }
    interface TopPresenter extends IBasePresenter{
        void mapData(Map<String,String> map);
    }
}
