package com.jiyun.qcloud.dashixummoban.config;

/**
 * Created by xingge on 2017/7/11.
 * 相关参数
 */

public class Urls {

    //服务器地址
    private static final String BASEURL = "http://www.ipanda.com/kehuduan/";
    //首页轮播
    private static final String HOMELUN = BASEURL + "shouye/index.json";
    //首页
    public static final String PANDAHOME = BASEURL + "PAGE14501749764071042/index.json";
    //熊猫直播
    public static final String PANDALIVE = "http://www.ipanda.com/kehuduan/PAGE14501769230331752/index.json";
    //列表
    public static final String PAGELIST = BASEURL+"PAGE14501786751053212/index.json";
    //直播中国
    public static final String LIVECHINA = BASEURL+"PAGE14501775094142282/index.json";



    public static final String PAGEINFOLIST = "http://101.200.142.201/MyListLoadAuto/listload";
    //获取图片验证码
    public static final String IMGCODE = "http://reg.cntv.cn/simple/verificationCode.action";
    //邮箱注册
    public static final String EMAILREGISTER = "https://reg.cntv.cn/api/register.action";

    //滚滚视频
    public static final String GUNGUN = BASEURL+"video/index.json";

    public static final String MULITANGLE="http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE14501787896813312/index.json";

    public static final String SPLENDURL="http://api.cntv.cn/video/videolistById?vsid=VSET100167216881&n=7&serviceId=panda&o=desc&of=time&p=1";

}
