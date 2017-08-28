package com.jiyun.qcloud.dashixummoban.ui.live.big_fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.BigLiveBean;
import com.jiyun.qcloud.dashixummoban.ui.live.panda_live.PandaLiveFragment;
import com.jiyun.qcloud.dashixummoban.ui.live.splendid.SplendidFragment;
import com.jiyun.qcloud.dashixummoban.view.MyViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by chj on 2017/8/20.
 */

public class LivePageFragment extends BaseFragment implements LivePageContract.LivePageView{

    Unbinder unbinder;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_page)
    MyViewPager viewPage;
    private PanadLiveFragmentAdapter panadLiveFragmentAdapter;
    private LivePageContract.LivePagePresenter livePresenter;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_live;
    }

    @Override
    protected void initData() {
        livePresenter=new LivePagePresenter(this);
        livePresenter.start();
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
    public void setPresenter(LivePageContract.LivePagePresenter livePagePresente) {
        livePresenter=livePagePresente;
    }

    @Override
    public void getResult(BigLiveBean bigLiveBean) {
        if(bigLiveBean!=null){
            List<Fragment> contentList = new ArrayList<>();
            List<String> titleList = new ArrayList<>();
            contentList.add(new PandaLiveFragment());

            for (int x = 0; x < bigLiveBean.getTablist().size(); x++) {
                titleList.add(bigLiveBean.getTablist().get(x).getTitle());
                if (x > 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("vsid", bigLiveBean.getTablist().get(x).getId());
                    SplendidFragment momentFragment = new SplendidFragment();
                    momentFragment.setArguments(bundle);
                    contentList.add(momentFragment);
                }
            }
            tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
            panadLiveFragmentAdapter = new PanadLiveFragmentAdapter(getActivity().getSupportFragmentManager(), contentList, titleList);
            viewPage.setAdapter(panadLiveFragmentAdapter);
            viewPage.setNoScroll(true);
            tabLayout.setupWithViewPager(viewPage);
        }
    }
}
