package com.jiyun.qcloud.dashixummoban.modle.gunModel;

import com.jiyun.qcloud.dashixummoban.config.Urls;
import com.jiyun.qcloud.dashixummoban.entity.Bobao.Bo;
import com.jiyun.qcloud.dashixummoban.entity.Bobao.Bolist;
import com.jiyun.qcloud.dashixummoban.entity.gungun.Gun;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;
import com.jiyun.qcloud.dashixummoban.modle.net.HttpFactory;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;
import com.jiyun.qcloud.dashixummoban.ui.culture.gungunxiang.Gunbean;

import java.util.HashMap;
import java.util.Map;

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

    @Override
    public void getpin(Map<String, String> map, NetWorkCallBack<SplendBean> callBack) {
        HttpFactory.createOK().get(Urls.SPLENDURL,map,callBack);
    }

    @Override
    public void getvideo(String pid, NetWorkCallBack<Gunbean> callBack) {
        Map<String, String> map=new HashMap<String, String>();
        map.put("pid",pid);
        HttpFactory.createOK().get(Urls.GunGunVIDEO,map,callBack);
    }


}
