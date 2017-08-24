package com.jiyun.qcloud.dashixummoban.modle.dataModel;


import com.jiyun.qcloud.dashixummoban.config.Urls;
import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.BiankanBianliaoBean;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.FasongBean;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.MultiBean;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.PandaLiveBean;
import com.jiyun.qcloud.dashixummoban.modle.net.HttpFactory;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xingge on 2017/7/26.
 */

public class  PandaHomeModelImpl implements IPandaHomeModel {
//主页
    @Override
    public void loadHomeList(NetWorkCallBack<PandaHome> callback) {
        iHttp.get(Urls.PANDAHOME,null,callback);
    }
//熊猫直播正在直播
    @Override
    public void getPandaLive(NetWorkCallBack<PandaLiveBean> callBack) {
       iHttp.get(Urls.PANDALIVE,null,callBack);
    }
//多视角直播
    @Override
    public void getMultiData(NetWorkCallBack<MultiBean> callBack) {
        iHttp.get(Urls.MULITANGLE,null,callBack);
    }

    //边看边聊
    @Override
    public void getFasongData(String app, String author, String authorid, String data, String itemid, String message, NetWorkCallBack<FasongBean> callBack) {
        Map<String, String> map = new HashMap<>();
        map.put("app", app);
        map.put("author", author);
        map.put("authorid", authorid);
        map.put("data", data);
        map.put("itemid", itemid);
        map.put("message", message);
        HttpFactory.createOK().post("http://newcomment.cntv.cn/comment/post", map, callBack);
    }

    @Override
    public void getBiankanBianliaoData(NetWorkCallBack<BiankanBianliaoBean> myCallBack) {
        HttpFactory.createOK().get("http://newcomment.cntv.cn/comment/list?prepage=20&app=ipandaApp&itemid=zhiboye_chat&nature=1&page=1", null, myCallBack);
    }
}
