package com.jiyun.qcloud.dashixummoban.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.entity.homeentily.BillowingBean;
import com.jiyun.qcloud.dashixummoban.entity.homeentily.WonderfulBean;
import com.jiyun.qcloud.dashixummoban.ui.home.activity.JCVideoActivity;
import com.jiyun.qcloud.dashixummoban.ui.home.activity.ZhoBoActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by chj on 2017/8/20.
 */

public class HomePageFragment extends BaseFragment implements HomeContract.View {

    @BindView(R.id.homerecycler)
    XRecyclerView homerecycler;
    Unbinder unbinder;
    private HomeContract.Presenter presenter;
    //首页总类
    private List<Object>  pandaShouYes = new ArrayList<>();
    //轮播图BEAN
    private List<String>    headlist = new ArrayList<>();
    //轮播图上的字
    private List<String>    strList = new ArrayList<>();
    private Banner homebanner;
    private HomeAdapter adapter;
    private   String url="http://115.182.35.91/api/getVideoInfoForCBox.do?pid=";
    private String zhibo = "http://vdn.live.cntv.cn/api2/live.do?client=androidapp&channel=pa://cctv_p2p_hd";
    private List<WonderfulBean.ListBean> wonderfulBeanList;
    private List<BillowingBean.ListBean> billowingBeanList;
    private PandaHome pandaHome;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        if (pandaShouYes.size()>0){
            pandaShouYes.clear();
        }
        presenter.start();
    }

    @Override
    protected void initView(View view) {
        View headview = LayoutInflater.from(getActivity()).inflate(R.layout.home_head, null);
        homebanner = headview.findViewById(R.id.home_banner);
        homerecycler.addHeaderView(headview);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        homerecycler.setLayoutManager(manager);
        homerecycler.setLoadingMoreEnabled(false);
        adapter = new HomeAdapter(getActivity(),pandaShouYes,wonderfulBeanList,billowingBeanList);
        homerecycler.setAdapter(adapter);
        adapter.setListeners(new HomeAdapter.BoCilcks() {
            @Override
            public void setBoListener(View view, String pid) {
                Intent intent = new Intent(getActivity(), JCVideoActivity.class);
                String adress = url + pid;
                intent.putExtra("url", adress);
                getActivity().startActivity(intent);
            }
        });
       adapter.setitemListener(new HomeAdapter.ItemTwo() {
           @Override
           public void setitemListener(View view, String pid) {
               Intent intent = new Intent(getActivity(), JCVideoActivity.class);
               String adress = url + pid;
               intent.putExtra("url", adress);
               getActivity().startActivity(intent);
           }
       });
         adapter.setZhiBoListener(new HomeAdapter.XiuClicks() {
             @Override
             public void setBoListener(View view,int i) {
                 Intent  intent = new Intent(getActivity(),ZhoBoActivity.class);
                 PandaHome.DataBean.PandaliveBean pandalive = pandaHome.getData().getPandalive();
                 List<PandaHome.DataBean.PandaliveBean.ListBeanX> list = pandalive.getList();
                 PandaHome.DataBean.PandaliveBean.ListBeanX listBeanX = list.get(i);
                 String id = listBeanX.getId();
                 String title = listBeanX.getTitle();
                 String  xiu = zhibo+id;
                 intent.putExtra("url", xiu);
                 intent.putExtra("title",title);
                 getActivity().startActivity(intent);
             }
         });
        adapter.setWonderListener(new HomeAdapter.JingClicks() {
            @Override
            public void setBoListener(View view, int i) {
                WonderfulBean.ListBean listBean = wonderfulBeanList.get(i);
                String pid = listBean.getPid();
                String title = listBean.getTitle();
                String path = url+pid;
                Intent intent = new Intent(getActivity(), JCVideoActivity.class);
                intent.putExtra("url",path);
                getActivity().startActivity(intent);
            }
        });
        adapter.setGunClicks(new HomeAdapter.GunClicks() {
            @Override
            public void setBoListener(View view, String pid) {
                String path = url+pid;
                Intent intent = new Intent(getActivity(), JCVideoActivity.class);
                intent.putExtra("url",path);
                getActivity().startActivity(intent);
            }
        });
        adapter.setChinaClicks(new HomeAdapter.ChinaClicks() {
            @Override
            public void setBoListener(View view, int i) {
                PandaHome.DataBean.ChinaliveBean chinalive = pandaHome.getData().getChinalive();
                List<PandaHome.DataBean.ChinaliveBean.ListBean> list = chinalive.getList();
                PandaHome.DataBean.ChinaliveBean.ListBean listBean = list.get(i);
                String id = listBean.getId();
                String  xiu = zhibo+id;
                String title = listBean.getTitle();
                Intent  intent = new Intent(getActivity(),ZhoBoActivity.class);
                intent.putExtra("url", xiu);
                intent.putExtra("title",title);
                getActivity().startActivity(intent);
            }
        });
        homerecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                homerecycler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        initData();
                    }
                },0);
                homerecycler.refreshComplete();
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onLoadMore() {

            }
        });

    }

    @Override
    public void setBundle(Bundle bundle) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dimissProgress() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = presenter;

    }

    @Override
    public void showHomeListData(PandaHome pandaHome, WonderfulBean wonderfulBean, BillowingBean billowingBean) {
        this.pandaHome = pandaHome;
        PandaHome.DataBean data = pandaHome.getData();
        final List<PandaHome.DataBean.BigImgBean> bigImg = data.getBigImg();
        if (headlist.size()<bigImg.size()) {
            for (int i = 0; i < bigImg.size(); i++) {
                PandaHome.DataBean.BigImgBean bigImgBean = bigImg.get(i);
                String image = bigImgBean.getImage();
                String title = bigImgBean.getTitle();
                headlist.add(image);
                strList.add(title);

            }
        }
        homebanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        homebanner.setImageLoader(new HomeBannerImageLoader());
        homebanner.setImages(headlist);
        homebanner.setBannerTitles(strList);
        homebanner.setIndicatorGravity(BannerConfig.RIGHT);
        homebanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                String pid = bigImg.get(position).getPid();
                String path = url+pid;
                Intent intent = new Intent(getActivity(), JCVideoActivity.class);
                intent.putExtra("url",path);
                getActivity().startActivity(intent);
            }
        });
        homebanner.start();
        //熊猫播报
        pandaShouYes.add(data.getPandaeye());
        //直播秀场
        pandaShouYes.add(data.getPandalive());
        //精彩一刻
        pandaShouYes.add(data.getCctv());
        //滚滚视频
        List<PandaHome.DataBean.ListBeanXX> list = data.getList();
        pandaShouYes.add(list.get(0));
        //直播中国
        pandaShouYes.add(data.getChinalive());
        //精彩一刻
        wonderfulBeanList = wonderfulBean.getList();
        //
        billowingBeanList = billowingBean.getList();
      //  adapter.notifyDataSetChanged();
        adapter.notifys(pandaShouYes,wonderfulBeanList,billowingBeanList);

    }

    @Override
    public void playVideo() {

    }

    @Override
    public void loadWebView() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private class HomeBannerImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }
}
