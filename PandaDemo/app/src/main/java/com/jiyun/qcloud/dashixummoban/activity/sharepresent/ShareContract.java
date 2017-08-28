package com.jiyun.qcloud.dashixummoban.activity.sharepresent;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.share.ShareBean;

/**
 * Created by my301s on 2017/8/27.
 */

public interface ShareContract {
    interface ShareView extends IBaseView<SharePresenter>{
        void getResult(ShareBean shareBean);
    }

    interface SharePresenter extends IBasePresenter{

    }
}
