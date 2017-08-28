package com.jiyun.qcloud.dashixummoban.ui.culture.gungunxiang;

import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;
import com.jiyun.qcloud.dashixummoban.modle.gunModel.CtltureImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by Administrator on 2017/8/27.
 */

public class XiangPresenter implements XiangContract.XiangPresenter {
    private XiangContract.TopView xiangeview;
    private CtltureImpl ctltureModel;
    private String vid;
    public XiangPresenter(XiangContract.TopView xiangeview) {
        this.xiangeview = xiangeview;
        xiangeview.setPresenter(this);
        ctltureModel = new CtltureImpl();
    }

    @Override
    public void mapData(Map<String, String> map) {
            ctltureModel.getpin(map, new NetWorkCallBack<SplendBean>() {
                @Override
                public void onSuccess(SplendBean splendBean) {
                    xiangeview.getResult(splendBean);


                }

                @Override
                public void onError(int errorCode, String errorMsg) {

                }

                @Override
                public void onFail(String netOff) {

                }
            });

    }

    @Override
    public String getVid(String vid) {
        this.vid=vid;
        return vid;
    }

    @Override
    public void start() {
        ctltureModel.getvideo(vid, new NetWorkCallBack<Gunbean>() {
            @Override
            public void onSuccess(Gunbean gunbean) {
                xiangeview.getvideo(gunbean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }

            @Override
            public void onFail(String netOff) {

            }
        });

    }

    @Override
    public void seconed(String url) {

    }
}
