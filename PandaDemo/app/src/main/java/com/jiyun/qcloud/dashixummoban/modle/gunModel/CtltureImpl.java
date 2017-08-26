package com.jiyun.qcloud.dashixummoban.modle.gunModel;

import com.jiyun.qcloud.dashixummoban.config.Urls;
import com.jiyun.qcloud.dashixummoban.entity.Bobao.Bo;
import com.jiyun.qcloud.dashixummoban.entity.Bobao.Bolist;
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

    @Override
    public void getbo(NetWorkCallBack<Bo> callBack) {
        iHttp.get(Urls.BOBAO,null,callBack);
    }

    @Override
    public void getbolist(NetWorkCallBack<Bolist> callBack,String url) {
        iHttp.get(url,null,callBack);
    }


}
