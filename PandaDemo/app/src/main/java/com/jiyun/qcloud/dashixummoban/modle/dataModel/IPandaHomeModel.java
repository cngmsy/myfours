package com.jiyun.qcloud.dashixummoban.modle.dataModel;


import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.entity.homeentily.BillowingBean;
import com.jiyun.qcloud.dashixummoban.entity.homeentily.WonderfulBean;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.BiankanBianliaoBean;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.FasongBean;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.MultiBean;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.PandaLiveBean;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.PandaVideoBean;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by xingge on 2017/7/26.
 */

public interface IPandaHomeModel extends BaseModel {
      //进行首页请求
    void loadHomeList(NetWorkCallBack<PandaHome> callback);
    //进行精彩一刻
    void loadJingCaiList(NetWorkCallBack<WonderfulBean> callback);
    //进行滚滚视频
    void loadGunGunList(NetWorkCallBack<BillowingBean> callback);



    void getPandaLive(NetWorkCallBack<PandaLiveBean> callBack);

    void getMultiData(NetWorkCallBack<MultiBean> callBack);

    void getFasongData(String app, String author, String authorid, String data,String itemid, String message,NetWorkCallBack<FasongBean> callBack);
    void getBiankanBianliaoData(NetWorkCallBack<BiankanBianliaoBean> callBack);

    void getSplendData(Map<String,String> map,NetWorkCallBack<SplendBean> callBack);

    void getDangXiongData(Map<String,String> map,NetWorkCallBack<SplendBean> callBack);

    void getChaoMengData(Map<String,String> map,NetWorkCallBack<SplendBean> callBack);

    void getDangAn(Map<String,String> map,NetWorkCallBack<SplendBean> callBack);

    void getTop(Map<String,String> map,NetWorkCallBack<SplendBean> callBack);

    void getNaXie(Map<String,String> map,NetWorkCallBack<SplendBean> callBack);

    void getTeBie(Map<String,String> map,NetWorkCallBack<SplendBean> callBack);

    void getNews(Map<String,String> map,NetWorkCallBack<SplendBean> callBack);

    void getVideoData(String url,NetWorkCallBack<PandaVideoBean> callBack);
}
