package com.jiyun.qcloud.dashixummoban.ui.live.tebie;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;

/**
 * Created by my301s on 2017/8/25.
 */

public interface TeBieContract {
    interface TeBieView extends IBaseView<TeBiePresenter>{
        void getResultdata(SplendBean splendBean);
    }
    interface TeBiePresenter extends IBasePresenter{

    }
}
