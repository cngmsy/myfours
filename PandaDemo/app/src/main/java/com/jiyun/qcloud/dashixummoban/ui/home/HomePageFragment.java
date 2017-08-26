package com.jiyun.qcloud.dashixummoban.ui.home;

import android.content.Context;
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
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
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

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        presenter.start();
    }

    @Override
    protected void initView(View view) {
        View headview = LayoutInflater.from(getActivity()).inflate(R.layout.home_head, null);
        homebanner = headview.findViewById(R.id.home_banner);
        homerecycler.addHeaderView(headview);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        homerecycler.setLayoutManager(manager);
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

        PandaHome.DataBean data = pandaHome.getData();
        List<PandaHome.DataBean.BigImgBean> bigImg = data.getBigImg();
        for (int i = 0; i < bigImg.size(); i++) {
            PandaHome.DataBean.BigImgBean bigImgBean = bigImg.get(i);
            String image = bigImgBean.getImage();
            headlist.add(image);
            String title = bigImgBean.getTitle();
            strList.add(title);
        }
        homebanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        homebanner.setImageLoader(new HomeBannerImageLoader());
        homebanner.setImages(headlist);
        homebanner.setBannerTitles(strList);
        homebanner.setIndicatorGravity(BannerConfig.RIGHT);
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
        List<WonderfulBean.ListBean> wonderfulBeanList = wonderfulBean.getList();
        //滚滚视频
        List<BillowingBean.ListBean> billowingBeanList = billowingBean.getList();
        adapter = new HomeAdapter(getActivity(),pandaShouYes,wonderfulBeanList,billowingBeanList);
        homerecycler.setAdapter(adapter);
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
