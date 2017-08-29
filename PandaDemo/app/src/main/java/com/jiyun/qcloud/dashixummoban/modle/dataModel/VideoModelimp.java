package com.jiyun.qcloud.dashixummoban.modle.dataModel;

import com.jiyun.qcloud.dashixummoban.entity.homeentily.MovieBean;
import com.jiyun.qcloud.dashixummoban.entity.homeentily.XiuChang;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by Administrator on 2017/8/27.
 */

public class VideoModelimp implements VideoListModel{
    @Override
    public void getZhiBo(String url, NetWorkCallBack<XiuChang> callBack) {
        iHttp.get(url,null,callBack);
    }

    @Override
    public void getVideoList(String url, NetWorkCallBack<MovieBean> callBack) {
       iHttp.get(url,null,callBack);
    }

}
