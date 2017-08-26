package com.jiyun.qcloud.dashixummoban.ui.culture;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.gungun.Gun;

/**
 * Created by Administrator on 2017/8/23.
 */

public class CultureContract {

    interface View extends IBaseView<Presenter>{
        void showGunlistData(Gun gun);
        void listener();
    }

   public interface Presenter extends IBasePresenter{}
}
