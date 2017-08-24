package com.jiyun.qcloud.dashixummoban.ui.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.PandaHome;

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
        LinearLayoutManager   manager = new LinearLayoutManager(getActivity());
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
    public void showHomeListData(PandaHome pandaHome) {

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
}
