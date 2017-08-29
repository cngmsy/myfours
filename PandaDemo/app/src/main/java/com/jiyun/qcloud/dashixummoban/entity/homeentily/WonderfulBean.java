package com.jiyun.qcloud.dashixummoban.entity.homeentily;

import java.util.List;

/**
 * Created by Administrator on 2017/8/23.
 * 首页精彩一刻
 */
//http://www.ipanda.com/kehuduan/shipinliebieye/jingcaiyike/index.json
public class WonderfulBean {
    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * url : http://live.ipanda.com/2017/08/22/VIDEYs5j0grIwgOIhVeLlbKt170822.shtml
         * image : http://p1.img.cctvpic.com/photoworkspace/2017/08/22/2017082213310944191.jpg
         * title : 泰锅锅拿笋的错误打开方式
         * videoLength : 00:19
         * id : TITE1503458603691598
         * daytime : 2017-08-23
         * type : 2
         * pid : http://115.182.35.91/api/getVideoInfoForCBox.do?pid=3a0c8e8a84e14a9aaad9fa32522e9a18
         * vid :
         * order : 1
         */

        private String url;
        private String image;
        private String title;
        private String videoLength;
        private String id;
        private String daytime;
        private String type;
        private String pid;
        private String vid;
        private String order;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getVideoLength() {
            return videoLength;
        }

        public void setVideoLength(String videoLength) {
            this.videoLength = videoLength;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDaytime() {
            return daytime;
        }

        public void setDaytime(String daytime) {
            this.daytime = daytime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }
}
