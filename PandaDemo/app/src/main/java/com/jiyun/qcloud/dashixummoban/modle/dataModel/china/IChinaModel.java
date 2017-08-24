package com.jiyun.qcloud.dashixummoban.modle.dataModel.china;

import com.jiyun.qcloud.dashixummoban.entity.china.ChinaFragmentBean;
import com.jiyun.qcloud.dashixummoban.entity.china.ChinaTabBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.BaseModel;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by liuwangping on 2017/8/24.
 */

public interface IChinaModel extends BaseModel{

    void getChinaTab(NetWorkCallBack<ChinaTabBean> callBack);

    void getFragment(String url, NetWorkCallBack<ChinaFragmentBean> callBack);

}
