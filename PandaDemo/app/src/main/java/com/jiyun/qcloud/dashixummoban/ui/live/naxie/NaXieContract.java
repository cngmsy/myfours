package com.jiyun.qcloud.dashixummoban.ui.live.naxie;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;

import java.util.Map;

/**
 * Created by my301s on 2017/8/25.
 */

public interface NaXieContract {
    interface NaXieView extends IBaseView<NaXiePresenter>{
        void getResultData(SplendBean splendBean);
    }
    interface NaXiePresenter extends IBasePresenter{
        void mapData(Map<String,String> map);
    }
}
