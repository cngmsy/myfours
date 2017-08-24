package com.jiyun.qcloud.dashixummoban.modle.dataModel;


import com.jiyun.qcloud.dashixummoban.config.Urls;
import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.MultiBean;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.PandaLiveBean;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

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

}
