package com.jiyun.qcloud.dashixummoban.modle.dataModel.china;

import com.jiyun.qcloud.dashixummoban.config.Urls;
import com.jiyun.qcloud.dashixummoban.entity.china.ChinaFragmentBean;
import com.jiyun.qcloud.dashixummoban.entity.china.ChinaTabBean;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by liuwangping on 2017/8/24.
 */

public class ChinaModelImpl implements IChinaModel{

    @Override
    public void getChinaTab(NetWorkCallBack<ChinaTabBean> callBack) {
        iHttp.get(Urls.LIVECHINA,null,callBack);
    }

    @Override
    public void getFragment(String url, NetWorkCallBack<ChinaFragmentBean> callBack) {
        iHttp.get(url,null,callBack);
    }
}
