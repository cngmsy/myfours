package com.jiyun.qcloud.dashixummoban.ui.live.dangxiong;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;

import java.util.Map;

/**
 * Created by my301s on 2017/8/25.
 */

public interface DangXiongContract {
    interface DangXiongView extends IBaseView<DangXiongPresenter>{
        void setResultData(SplendBean resultData);
    }
    interface DangXiongPresenter extends IBasePresenter {
        void mapData(Map<String,String> map);
    }
}
