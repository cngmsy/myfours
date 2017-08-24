package com.jiyun.qcloud.dashixummoban.ui.china;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.adapter.ChinaTabAdapter;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.china.ChinaTabBean;
import com.jiyun.qcloud.dashixummoban.ui.china.vpagerfragment.ChinaItemFragment;
import com.jiyun.qcloud.dashixummoban.view.MyViewPager;

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

    }

    @Override
    public void setBundle(Bundle bundle) {

    }


    @Override
    public void showChinaTab(ChinaTabBean chinaTabBean) {
        List<ChinaTabBean.TablistBean> tablist = chinaTabBean.getTablist();

        for (int i = 0; i < tablist.size(); i++) {
            tabNamelist.add(tablist.get(i).getTitle());
            fragmentlist.add(new ChinaItemFragment(tablist.get(i).getUrl()));

        }
        adapter = new ChinaTabAdapter(getChildFragmentManager(), fragmentlist, tabNamelist);

        chinaViewPager.setNoScroll(true);
        chinaViewPager.setAdapter(adapter);
        chinaTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        chinaTabLayout.setupWithViewPager(chinaViewPager);

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

    }
}
