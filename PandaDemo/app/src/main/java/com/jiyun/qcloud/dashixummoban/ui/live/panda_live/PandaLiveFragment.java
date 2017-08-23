package com.jiyun.qcloud.dashixummoban.ui.live.panda_live;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.view.MyViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 *
 */
public class PandaLiveFragment extends BaseFragment {

    @BindView(R.id.pandanlive_vitamio)
    ImageView pandanliveVitamio;
    @BindView(R.id.pandanlive_name)
    TextView pandanliveName;
    @BindView(R.id.pandanlive_detail)
    ImageView pandanliveDetail;
    @BindView(R.id.pandanlive_tablayout)
    TabLayout pandanliveTablayout;
    @BindView(R.id.pandanlive_viewpage)
    MyViewPager pandanliveViewpage;
    Unbinder unbinder;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_panda_live;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public void setBundle(Bundle bundle) {

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

    @OnClick(R.id.pandanlive_detail)
    public void onViewClicked() {

    }
}
