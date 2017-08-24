package com.jiyun.qcloud.dashixummoban.ui.live;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.ui.live.chaomeng.ChaoMengFragment;
import com.jiyun.qcloud.dashixummoban.ui.live.dangan.DangAnFragment;
import com.jiyun.qcloud.dashixummoban.ui.live.dangxiong.DangXiongFragment;
import com.jiyun.qcloud.dashixummoban.ui.live.panda_live.PandaLiveFragment;
import com.jiyun.qcloud.dashixummoban.ui.live.splendid.SplendidFragment;
import com.jiyun.qcloud.dashixummoban.ui.live.top.TopFragment;
import com.jiyun.qcloud.dashixummoban.view.MyViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by chj on 2017/8/20.
 */

public class LivePageFragment extends BaseFragment{

    Unbinder unbinder;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_page)
    MyViewPager viewPage;
    private List<String> name = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();
    private PanadLiveFragmentAdapter panadLiveFragmentAdapter;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_live;
    }

    @Override
    protected void initData() {
        fragmentList.add(new PandaLiveFragment());
        fragmentList.add(new SplendidFragment());
        fragmentList.add(new DangXiongFragment());
        fragmentList.add(new ChaoMengFragment());
        fragmentList.add(new DangAnFragment());
        fragmentList.add(new TopFragment());
        name.add("直播");
        name.add("精彩一刻");
        name.add("当熊不让");
        name.add("超萌滚滚秀");
        name.add("熊猫档案");
        name.add("熊猫TOP榜");
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        panadLiveFragmentAdapter = new PanadLiveFragmentAdapter(getActivity().getSupportFragmentManager(), fragmentList, name);
        viewPage.setAdapter(panadLiveFragmentAdapter);
        viewPage.setNoScroll(true);
        tabLayout.setupWithViewPager(viewPage);

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public void setBundle(Bundle bundle) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
