package com.jiyun.qcloud.dashixummoban.ui.observation.bobaodetail;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.Bobao.BoBean;

import java.util.Map;

/**
 * Created by my301s on 2017/8/29.
 */

public interface BoContract {
    interface BoView extends IBaseView<BoPresenter>{
        void getData(BoBean boBean);
    }
    interface BoPresenter extends IBasePresenter{
        void mapData(Map<String,String> map);
    }
}
