package com.jiyun.qcloud.dashixummoban.modle.gunModel;

import com.jiyun.qcloud.dashixummoban.entity.Bobao.Bo;
import com.jiyun.qcloud.dashixummoban.entity.Bobao.Bolist;
import com.jiyun.qcloud.dashixummoban.entity.gungun.Gun;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.BaseModel;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;
import com.jiyun.qcloud.dashixummoban.ui.culture.gungunxiang.Gunbean;

import java.util.Map;

/**
 * Created by Administrator on 2017/8/23.
 */

public interface IctltureModel extends BaseModel {
    void getgun(NetWorkCallBack<Gun> callBack);
    //熊猫播报
    void getbo(NetWorkCallBack<Bo> callBack);

    void getbolist(NetWorkCallBack<Bolist> callBack,String url);

    void getpin(Map<String,String> map ,NetWorkCallBack<SplendBean> callBack);

    void getvideo(String vid,NetWorkCallBack<Gunbean> callBack );

}
