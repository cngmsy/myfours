package com.jiyun.qcloud.dashixummoban.ui.home.zhiboprestener;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.homeentily.XiuChang;

/**
 * Created by Administrator on 2017/8/27.
 */

public class ZhiContract {
   public interface View extends IBaseView<Presenter>{
       void showVideoList(XiuChang xiuChang);
   }
   public interface Presenter extends IBasePresenter{}
}
