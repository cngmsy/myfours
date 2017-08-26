package com.jiyun.qcloud.dashixummoban.modle.dataModel;


import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.entity.homeentily.BillowingBean;
import com.jiyun.qcloud.dashixummoban.entity.homeentily.WonderfulBean;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

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

}
