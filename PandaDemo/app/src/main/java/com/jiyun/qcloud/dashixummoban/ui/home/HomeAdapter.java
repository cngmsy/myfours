package com.jiyun.qcloud.dashixummoban.ui.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.entity.homeentily.BillowingBean;
import com.jiyun.qcloud.dashixummoban.entity.homeentily.WonderfulBean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/23.
 */

public class HomeAdapter extends RecyclerView.Adapter {
    private  List<WonderfulBean.ListBean> wonderfulBeen;
    private  List<BillowingBean.ListBean> billowingBeen;
    private Context context;
    private List<Object> datalist;
    private final int BOBAO = 1;
    private final int ZHIBO = 2;
    private final int JINGCAI = 3;
    private final int GUNGUN = 4;
    private final int CHINA = 5;
    private BoCilcks boCilcks;
    private XiuClicks xiuClicks;
    private GunClicks gunClicks;
    private ChinaClicks chinaClicks;
    private JingClicks jingClicks;
    private String id;
    private ItemTwo itemTwo;
    private String title;

    public HomeAdapter(Context context, List<Object> list, List<WonderfulBean.ListBean> wonderfulBeanList, List<BillowingBean.ListBean> billowinglist) {
        this.context = context;
        datalist = list;
        wonderfulBeen = wonderfulBeanList;
        billowingBeen = billowinglist;

    }

    public void notifys(List<Object> list, List<WonderfulBean.ListBean> wonderfulBeanList, List<BillowingBean.ListBean> billowinglist) {
        datalist = list;
        wonderfulBeen = wonderfulBeanList;
        billowingBeen = billowinglist;
        notifyDataSetChanged();
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return BOBAO;
        } else if (position == 1) {
            return ZHIBO;
        } else if (position == 2) {
            return JINGCAI;
        } else if (position == 3) {
            return GUNGUN;
        } else if (position == 4) {
            return CHINA;
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case BOBAO:
                View view = LayoutInflater.from(context).inflate(R.layout.item_home_bao, parent, false);
                holder = new BaoViewHolder(view);
                break;
            case ZHIBO:
                View xiuview = LayoutInflater.from(context).inflate(R.layout.item_xiuchang, parent, false);
                holder = new XiuViewHolder(xiuview);
                break;
            case JINGCAI:
                View jingview = LayoutInflater.from(context).inflate(R.layout.item_home_jing, parent, false);
                holder = new JingCaiViewHolder(jingview);
                break;
            case CHINA:
                View zhiview = LayoutInflater.from(context).inflate(R.layout.item_home_chaina, parent, false);
                holder = new ZhiBoViewHolder(zhiview);
                break;
            case GUNGUN:
                View gunview = LayoutInflater.from(context).inflate(R.layout.item_home_gun, parent, false);
                holder = new GunViewHolder(gunview);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case BOBAO:
                PandaHome.DataBean.PandaeyeBean guanchabean = (PandaHome.DataBean.PandaeyeBean) datalist.get(position);
                List<PandaHome.DataBean.PandaeyeBean.ItemsBean> items = guanchabean.getItems();
                BaoViewHolder holder1 = (BaoViewHolder) holder;
                    PandaHome.DataBean.PandaeyeBean.ItemsBean itemsBean = items.get(0);
                    PandaHome.DataBean.PandaeyeBean.ItemsBean itemsBean1 = items.get(1);
                    holder1.twotext.setText(itemsBean1.getBrief());
                    holder1.find_text.setText(itemsBean1.getTitle());
                    holder1.live_text.setText(itemsBean.getTitle());
                    holder1.oneText.setText(itemsBean.getBrief());
                final String pid = itemsBean.getPid();
                holder1.live_text.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            boCilcks.setBoListener(view,pid);
                        }
                    });
                final String pid1 = itemsBean1.getPid();
                holder1.find_text.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       itemTwo.setitemListener(view,pid1);
                    }
                });
                break;
            case ZHIBO:
                PandaHome.DataBean.PandaliveBean pandaliveBean = (PandaHome.DataBean.PandaliveBean) datalist.get(position);
                final List<PandaHome.DataBean.PandaliveBean.ListBeanX> list = pandaliveBean.getList();
                XiuViewHolder holder2 = (XiuViewHolder) holder;
                holder2.zhigrid.setAdapter(new BaseAdapter() {
                    @Override
                    public int getCount() {
                        return list.size();
                    }

                    @Override
                    public Object getItem(int i) {
                        return list.get(i);
                    }

                    @Override
                    public long getItemId(int i) {
                        return i;
                    }

                    @Override
                    public View getView(final int i, View view, ViewGroup viewGroup) {
                        ViewHodelr   zhiboholder = null;
                        if (view == null){
                            zhiboholder = new ViewHodelr();
                           view = LayoutInflater.from(context).inflate(R.layout.item_zhibo_home_item,null);
                            zhiboholder.xiuimage=view.findViewById(R.id.myimage);
                            zhiboholder.xiutittext = view.findViewById(R.id.zhibotext);
                            view.setTag(zhiboholder);
                        }else {
                            zhiboholder = (ViewHodelr) view.getTag();
                        }
                        PandaHome.DataBean.PandaliveBean.ListBeanX listBeanX = list.get(i);
                        id = listBeanX.getId();
                        title = listBeanX.getTitle();
                        zhiboholder.xiutittext.setText(listBeanX.getTitle());
                        Glide.with(context).load(listBeanX.getImage()).into(zhiboholder.xiuimage);
                        view.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                xiuClicks.setBoListener(view,i);
                            }
                        });
                        return view;
                    }
                    class ViewHodelr{
                        private TextView xiutittext;
                        private ImageView xiuimage;
                    }
                });


                break;
            case JINGCAI:
                JingCaiViewHolder holder3 = (JingCaiViewHolder) holder;
                holder3.jingGridView.setAdapter(new BaseAdapter() {
                    @Override
                    public int getCount() {
                        return wonderfulBeen.size();
                    }

                    @Override
                    public Object getItem(int i) {
                        return wonderfulBeen.get(i);
                    }

                    @Override
                    public long getItemId(int i) {
                        return i;
                    }

                    @Override
                    public View getView(final int i, View view, ViewGroup viewGroup) {
                        JingCaiHolder   jingCaiHolder = null;
                        if (view == null){
                            jingCaiHolder = new JingCaiHolder();
                            view = LayoutInflater.from(context).inflate(R.layout.item_jingcai_home_item,null);
                            jingCaiHolder.jingimage = view.findViewById(R.id.jingImage);
                            jingCaiHolder.jingtext = view.findViewById(R.id.jingText);
                            jingCaiHolder.jingdata = view.findViewById(R.id.jingdata);
                            view.setTag(jingCaiHolder);
                        }else {
                            jingCaiHolder = (JingCaiHolder) view.getTag();
                        }
                        WonderfulBean.ListBean wonderfulbean = wonderfulBeen.get(i);
                        Glide.with(context).load(wonderfulbean.getImage()).into(jingCaiHolder.jingimage);
                        jingCaiHolder.jingtext.setText(wonderfulbean.getTitle());
                        jingCaiHolder.jingdata.setText(wonderfulbean.getDaytime());
                        view.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                jingClicks.setBoListener(view,i);
                            }
                        });
                        return view;
                    }
                    class JingCaiHolder{
                        private ImageView jingimage;
                        private TextView  jingtext,jingdata;
                    }
                });
                break;
            case GUNGUN:
                GunViewHolder holder4 = (GunViewHolder) holder;
                 holder4.gunList.setAdapter(new BaseAdapter() {
                     @Override
                     public int getCount() {
                         return billowingBeen.size();
                     }

                     @Override
                     public Object getItem(int i) {
                         return billowingBeen.get(i);
                     }

                     @Override
                     public long getItemId(int i) {
                         return i;
                     }

                     @Override
                     public View getView(int i, View view, ViewGroup viewGroup) {
                         GunHolder   gunHolder = null;
                         if (view == null){
                             gunHolder = new GunHolder();
                             view = LayoutInflater.from(context).inflate(R.layout.item_gungun_home_item,null);
                             gunHolder.gunImage = view.findViewById(R.id.gunimage);
                             gunHolder.gundata = view.findViewById(R.id.gundata);
                             gunHolder.titletext = view.findViewById(R.id.guntitle);
                             view.setTag(gunHolder);
                         }else {
                             gunHolder = (GunHolder) view.getTag();
                         }
                         BillowingBean.ListBean gunbean = billowingBeen.get(i);
                         gunHolder.titletext.setText(gunbean.getTitle());
                         gunHolder.gundata.setText(gunbean.getDaytime());
                         final String pid2 = gunbean.getPid();
                         Glide.with(context).load(gunbean.getImage()).into(gunHolder.gunImage);
                         view.setOnClickListener(new View.OnClickListener() {
                             @Override
                             public void onClick(View view) {
                                 gunClicks.setBoListener(view,pid2);
                             }
                         });
                         return view;
                     }
                     class GunHolder{
                         private ImageView  gunImage;
                         private TextView titletext,gundata;
                     }
                 });

                break;
            case CHINA:
                PandaHome.DataBean.ChinaliveBean chinaliveBean = (PandaHome.DataBean.ChinaliveBean) datalist.get(position);
                final List<PandaHome.DataBean.ChinaliveBean.ListBean> chinalist = chinaliveBean.getList();
                ZhiBoViewHolder holder5 = (ZhiBoViewHolder) holder;
                holder5.chinaView.setAdapter(new BaseAdapter() {
                    @Override
                    public int getCount() {
                        return chinalist.size();
                    }

                    @Override
                    public Object getItem(int i) {
                        return chinalist.get(i);
                    }

                    @Override
                    public long getItemId(int i) {
                        return i;
                    }

                    @Override
                    public View getView(final int i, View view, ViewGroup viewGroup) {
                        ChinaHolder   chinaHolder = null;
                        if (view==null){
                            chinaHolder = new ChinaHolder();
                            view = LayoutInflater.from(context).inflate(R.layout.item_zhongguo_home_item,null);
                            chinaHolder.chinaimage = view.findViewById(R.id.chinaimage);
                            chinaHolder.chinatext = view.findViewById(R.id.chinatext);
                            view.setTag(chinaHolder);
                        }else {
                            chinaHolder = (ChinaHolder) view.getTag();
                        }
                        PandaHome.DataBean.ChinaliveBean.ListBean listBean = chinalist.get(i);
                        Glide.with(context).load(listBean.getImage()).into(chinaHolder.chinaimage);
                        chinaHolder.chinatext.setText(listBean.getTitle());
                        view.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                chinaClicks.setBoListener(view,i);
                            }
                        });
                        return view;
                    }
                    class ChinaHolder{
                        private TextView chinatext;
                        private ImageView chinaimage;
                    }
                });


                break;
        }


    }

    @Override
    public int getItemCount() {
        return datalist != null ? datalist.size() : 0;
    }

    public interface ItemTwo{
        void setitemListener(View view,String pid);
    }
    public void setitemListener(ItemTwo itemTwo){
        this.itemTwo = itemTwo;
    }
    public interface BoCilcks{
      void setBoListener(View view,String pid);
  }
    public interface XiuClicks{
        void setBoListener(View view,int i);
    }
    public void setZhiBoListener(XiuClicks xiuClicks){
        this.xiuClicks  = xiuClicks;
    }
    public interface JingClicks{
        void setBoListener(View view,int i);
    }
    public void setWonderListener(JingClicks jingClicks){
        this.jingClicks = jingClicks;
    }
    public interface GunClicks{
        void setBoListener(View view,String pid);
    }
    public void setGunClicks(GunClicks gunClicks){
        this.gunClicks = gunClicks;
    }
    public interface ChinaClicks{
        void setBoListener(View view,int i);
    }
    public void setChinaClicks(ChinaClicks chinaClicks){
        this.chinaClicks = chinaClicks;
    }
    public void setListeners(BoCilcks boCilcks){
        this.boCilcks = boCilcks;
    }

    private class BaoViewHolder extends RecyclerView.ViewHolder {
        private TextView oneText;
        private TextView twotext;
        private View rootView;
        private TextView recyc_title_name;
        private TextView live_text;
        private TextView find_text;
        private ImageView baoimage;
        public BaoViewHolder(View itemView) {
            super(itemView);
            recyc_title_name = itemView.findViewById(R.id.recyc_title_name);
            live_text = itemView.findViewById(R.id.live_text);
            find_text = itemView.findViewById(R.id.find_text);
            oneText = itemView.findViewById(R.id.onetext);
            twotext = itemView.findViewById(R.id.twotext);
            baoimage = itemView.findViewById(R.id.baoimage);
        }
    }


    private class XiuViewHolder extends RecyclerView.ViewHolder {
        private View rootView;
        private  GridView zhigrid;

        public XiuViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            zhigrid = itemView.findViewById(R.id.zhiboview);

        }
    }

    private class JingCaiViewHolder extends RecyclerView.ViewHolder {
        private View rootView;
        private  StationaryGridview jingGridView;
        private JingCaiViewHolder(View jingcai) {
            super(jingcai);
            rootView = jingcai;
            jingGridView = jingcai.findViewById(R.id.jingGridView);
        }
    }

    private class ZhiBoViewHolder extends RecyclerView.ViewHolder {
        private View  view;
        private  GridView chinaView;
        public ZhiBoViewHolder(View zhibo) {
            super(zhibo);
            view = zhibo;
            chinaView = zhibo.findViewById(R.id.chinaview);
        }
    }

    private class GunViewHolder extends RecyclerView.ViewHolder {
        private View rootView;
        private  ListView gunList;

        public GunViewHolder(View gungun) {
            super(gungun);
            rootView = gungun;
            gunList = gungun.findViewById(R.id.gunList);
        }
    }


}
