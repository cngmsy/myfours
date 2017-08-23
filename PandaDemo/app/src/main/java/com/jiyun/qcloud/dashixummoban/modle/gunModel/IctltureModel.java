package com.jiyun.qcloud.dashixummoban.modle.gunModel;

import com.jiyun.qcloud.dashixummoban.entity.gungun.Gun;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.BaseModel;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by Administrator on 2017/8/23.
 */

public interface IctltureModel extends BaseModel {
    void getgun(NetWorkCallBack<Gun> callBack);

}
