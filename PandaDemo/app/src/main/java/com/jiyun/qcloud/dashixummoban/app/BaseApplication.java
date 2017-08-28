package com.jiyun.qcloud.dashixummoban.app;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.multidex.MultiDexApplication;

import com.jiyun.qcloud.dashixummoban.manager.ActivityCollector;
import com.orhanobut.logger.AndroidLogTool;
import com.orhanobut.logger.Logger;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by chj on 2017/8/20.
 * 解决65535的一个包如果大家又需要使用MoB
 *
 * 方案两种一种使用配置文件设置连个app
 * 一种吧mod里面的代码给copy过来
 *
 */

public class BaseApplication extends MultiDexApplication {
    public static final String UPDATE_STATUS_ACTION = "com.umeng.message.example.action.UPDATE_STATUS";
    public static class Config{
        public static final boolean DEVELOPER_MORE=false;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);
        //全局异常捕获

//        CrashHandler crashHandler = CrashHandler.getInstance();
//        crashHandler.init(getApplicationContext());

        if (Config.DEVELOPER_MORE&& Build.VERSION.SDK_INT<=Build.VERSION_CODES.GINGERBREAD) {
            //设置线程的严苛模式
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyDialog().build());
            //设置虚拟机的严苛模式
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyDeath().build());
        }
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.ICE_CREAM_SANDWICH){
            registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
                @Override
                public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

                }

                @Override
                public void onActivityStarted(Activity activity) {

                }

                @Override
                public void onActivityResumed(Activity activity) {
                    //设置Activity的栈管理
                    ActivityCollector.getInstance().setCurrentActivity(activity);
                }

                @Override
                public void onActivityPaused(Activity activity) {

                }

                @Override
                public void onActivityStopped(Activity activity) {

                }

                @Override
                public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

                }

                @Override
                public void onActivityDestroyed(Activity activity) {

                }
            });
        }
        initLogger();
    }
    private void initLogger(){
        Logger.init()                         // default PRETTYLOGGER or use just init()
                .methodCount(3)                 // default 2
//              .hideThreadInfo()               // default shown
//              .logLevel(LogLevel.FULL)        // default LogLevel.FULL
//              .methodOffset(2)                // default 0
                .logTool(new AndroidLogTool()); // custom log tool, optional
    }
    //当内存低时发送广播可以释放一些内存
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
    //退出整个应用
    public void exit(){
        ActivityCollector.getInstance().exit(this);
    }

    {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("2828143782", "9056270e0000507b476d6c229f29c340", "http://sns.whalecloud.com");
    }
}
