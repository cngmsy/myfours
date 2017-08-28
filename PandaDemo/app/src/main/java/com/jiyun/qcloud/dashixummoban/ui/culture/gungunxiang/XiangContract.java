package com.jiyun.qcloud.dashixummoban.ui.culture.gungunxiang;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;

import java.util.Map;

/**
 * Created by Administrator on 2017/8/27.
 */

public interface XiangContract {
    interface TopView extends IBaseView<XiangPresenter>{
        void getResult(SplendBean splendBean);
        void getvideo(Gunbean gunbean);

    }
    interface XiangPresenter extends IBasePresenter{
        void mapData(Map<String,String> map);
        String getVid(String vid);
    }
}
