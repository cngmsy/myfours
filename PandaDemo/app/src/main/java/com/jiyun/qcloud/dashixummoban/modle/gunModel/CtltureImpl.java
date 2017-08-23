package com.jiyun.qcloud.dashixummoban.modle.gunModel;

import com.jiyun.qcloud.dashixummoban.config.Urls;
import com.jiyun.qcloud.dashixummoban.entity.gungun.Gun;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by Administrator on 2017/8/23.
 */

public class CtltureImpl implements IctltureModel {
    @Override
    public void getgun(NetWorkCallBack<Gun> callBack) {
        iHttp.get(Urls.GUNGUN,null,callBack);
    }
}
