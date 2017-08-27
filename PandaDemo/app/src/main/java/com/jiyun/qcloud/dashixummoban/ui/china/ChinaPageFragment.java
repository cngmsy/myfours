package com.jiyun.qcloud.dashixummoban.ui.china;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.adapter.ChinaTabAdapter;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.china.ChinaTabBean;
import com.jiyun.qcloud.dashixummoban.entity.china.EventTabList;
import com.jiyun.qcloud.dashixummoban.ui.china.activity.AddActivity;
import com.jiyun.qcloud.dashixummoban.ui.china.vpagerfragment.ChinaItemFragment;
import com.jiyun.qcloud.dashixummoban.view.MyViewPager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 */
public class ChinaPageFragment extends BaseFragment implements LiveChinaContract.View {
    @BindView(R.id.chinaTabLayout)
    TabLayout chinaTabLayout;
    @BindView(R.id.chinaAdd)
    ImageView chinaAdd;
    @BindView(R.id.chinaViewPager)
    MyViewPager chinaViewPager;

    private LiveChinaContract.Presenter presenter;
    private List<String> tabNamelist = new ArrayList<>();
    private List<Fragment> fragmentlist = new ArrayList<>();
    private ChinaTabAdapter adapter;
    private ChinaTabBean chinaTabBean;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 111:
                    adapter = new ChinaTabAdapter(getChildFragmentManager(), fragmentlist, tabNamelist);
                    chinaViewPager.setNoScroll(true);
                    chinaViewPager.setAdapter(adapter);
                    chinaTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
                    chinaTabLayout.setupWithViewPager(chinaViewPager);
                    break;

            }
        }
    };
    private List<ChinaTabBean.AlllistBean> alllist;
    private List<ChinaTabBean.TablistBean> tablist;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_china_page;
    }

    @Override
    protected void initData() {
        presenter = new LiveChinaPresenter(this);
        if (presenter != null) {
            presenter.start();
        }
    }

    @Override
    protected void initView(View view) {
        EventBus.getDefault().register(this);
    }

    @Override
    public void setBundle(Bundle bundle) {

    }


    @Override
    public void showChinaTab(ChinaTabBean chinaTabBean) {
        this.chinaTabBean=chinaTabBean;
        tablist = chinaTabBean.getTablist();
        alllist = chinaTabBean.getAlllist();
        tabNamelist.clear();
        fragmentlist.clear();
        for (int i = 0; i < tablist.size(); i++) {
            tabNamelist.add(tablist.get(i).getTitle());
            fragmentlist.add(new ChinaItemFragment(tablist.get(i).getUrl()));
        }

        handler.sendEmptyMessage(111);
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
    public void setPresenter(LiveChinaContract.Presenter presenter) {
        this.presenter = presenter;

    }



    @OnClick(R.id.chinaAdd)
    public void onViewClicked() {
        Intent intent=new Intent(getActivity(), AddActivity.class);
        intent.putExtra("ChinaTabBean",chinaTabBean);
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onTabList(EventTabList messageEvent) {
        chinaViewPager.removeAllViewsInLayout();
        tabNamelist.clear();
        fragmentlist.clear();
        tabNamelist.addAll(messageEvent.getStrings());

        for (int i=0;i<tabNamelist.size();i++){
            for (int x=0;x<alllist.size();x++){
                if (tabNamelist.get(i).equals(alllist.get(x).getTitle())){
                    fragmentlist.add(new ChinaItemFragment(alllist.get(x).getUrl()));
                }
            }
        }
        handler.sendEmptyMessage(111);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


}
