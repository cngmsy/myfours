package com.jiyun.qcloud.dashixummoban.ui.home.videoprestener;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.homeentily.MovieBean;

/**
 * Created by Administrator on 2017/8/27.
 */

public class VideoContract {
   public interface View extends IBaseView<Presenter>{
       void showVideoList(MovieBean movieBean);
   }
   public interface Presenter extends IBasePresenter{}
}
