package com.jiyun.qcloud.dashixummoban.config;

/**
 * Created by xingge on 2017/7/11.
 * 相关参数
 */

public class Urls {

    //服务器地址
    private static final String BASEURL = "http://www.ipanda.com/kehuduan/";
    //首页精彩一刻http://www.ipanda.com/kehuduan/shipinliebieye/video/index.json
    public static final String WONDERFUL = BASEURL+"shipinliebieye/jingcaiyike/index.json";
    //首页滚滚视频
    public static final String  BILLOWING = BASEURL+"shipinliebieye/video/index.json";
    //首页总接口
    public static final String HOMELUN = BASEURL+"shouye/index.json";
    //首页
    public static final String PANDAHOME = BASEURL + "PAGE14501749764071042/index.json";
    //熊猫直播
    public static final String PANDALIVE = "http://www.ipanda.com/kehuduan/PAGE14501769230331752/index.json";
    //列表
    public static final String PAGELIST = BASEURL + "PAGE14501786751053212/index.json";
    //直播中国
    public static final String LIVECHINA = BASEURL + "PAGE14501775094142282/index.json";


    public static final String PAGEINFOLIST = "http://101.200.142.201/MyListLoadAuto/listload";
    //获取图片验证码
    public static final String IMGCODE = "http://reg.cntv.cn/simple/verificationCode.action";
    //邮箱注册
    public static final String EMAILREGISTER = "https://reg.cntv.cn/api/register.action";

    //滚滚视频
    public static final String GUNGUN = BASEURL + "video/index.json";


    public static final String MULITANGLE = "http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE14501787896813312/index.json";
    //熊猫播报
    public static final String BOBAO = BASEURL + "news/index.json";
    public static final String BOBAOList = "http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda";
    //精彩一刻
    public static final String SPLENDURL = "http://api.cntv.cn/video/videolistById?vsid=VSET100167216881&n=7&serviceId=panda&o=desc&of=time&p=1";
    //当熊不让
    public static final String DANGXIONG = "http://api.cntv.cn/video/videolistById?vsid=VSET100332640004&n=7&serviceId=panda&o=desc&of=time&p=1";

    //超萌滚滚
    public static final String CHAOMENG = "http://api.cntv.cn/video/videolistById?vsid=VSET100272959126&n=7&serviceId=panda&o=desc&of=time&p=1";
    //熊猫档案
    public static final String DANGAN = "http://api.cntv.cn/video/videolistById?vsid=VSET100340574858&n=7&serviceId=panda&o=desc&of=time&p=1";
    //熊猫TOP榜
    public static final String TOP = "http://api.cntv.cn/video/videolistById?vsid=VSET100284428835&n=7&serviceId=panda&o=desc&of=time&p=1";
    //熊猫那些事
    public static final String NAXIE = "http://api.cntv.cn/video/videolistById?vsid=VSET100237714751&n=7&serviceId=panda&o=desc&of=time&p=1";
    //特别节目
    public static final String TEBIE = "http://api.cntv.cn/video/videolistById?vsid=VSET100167308855&n=7&serviceId=panda&o=desc&of=time&p=1";
    //原创新闻
    public static final String NEWS = "http://api.cntv.cn/video/videolistById?vsid=VSET100219009515&n=7&serviceId=panda&o=desc&of=time&p=1";
}
