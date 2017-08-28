package com.jiyun.qcloud.dashixummoban.ui.home;


import android.util.Log;

import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.entity.homeentily.BillowingBean;
import com.jiyun.qcloud.dashixummoban.entity.homeentily.WonderfulBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.IPandaHomeModel;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by xingge on 2017/7/26.
 */

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View homeView;
    private IPandaHomeModel homeModel;
    /*
       在构造方法里面做了什么事情;   初始化了HomeView  这时候的homeView相当于HomePageFragent
       同时在这个构造方法中有初始化了homeModel   HomeModel里面就是网络请求后从服务器返回的bean结果
     */
    public HomePresenter(HomeContract.View homeView){
        this.homeView = homeView;
        homeView.setPresenter(this);//让view层持有presenter层对象
        this.homeModel = new PandaHomeModelImpl();
    }

    @Override//必须重写start（）
    public void start() {
        homeView.showProgress();
        homeModel.loadHomeList(new NetWorkCallBack<PandaHome>() {
            @Override
            public void onSuccess(final PandaHome pandaHome) {
               homeModel.loadJingCaiList(new NetWorkCallBack<WonderfulBean>() {
                   @Override
                   public void onSuccess(final WonderfulBean wonderfulBean) {
                       homeModel.loadGunGunList(new NetWorkCallBack<BillowingBean>() {
                           @Override
                           public void onSuccess(BillowingBean billowingBean) {
                               homeView.showHomeListData(pandaHome,wonderfulBean,billowingBean);
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
                   public void onError(int errorCode, String errorMsg) {

                   }

                   @Override
                   public void onFail(String netOff) {

                   }
               });
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                    homeView.showMessage(errorMsg);
                Log.e("TAG-----",errorMsg.toString());
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
