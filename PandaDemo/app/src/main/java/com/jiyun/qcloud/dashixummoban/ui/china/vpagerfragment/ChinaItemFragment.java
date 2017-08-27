package com.jiyun.qcloud.dashixummoban.ui.china.vpagerfragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.adapter.ChinaFragAdapter;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.china.ChinaFragmentBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by liuwangping on 2017/8/24.
 */

public class ChinaItemFragment extends BaseFragment implements ChinaFragContract.View{

    @BindView(R.id.chinaPullRv)
    PullToRefreshRecyclerView chinaPullRv;
    private ChinaFragContract.Presenter presenter;
    private String url;
    private ChinaFragAdapter adapter;
    private List<ChinaFragmentBean.LiveBean> beanList=new ArrayList<>();
    private List<ChinaFragmentBean.LiveBean> live;

    public ChinaItemFragment(String url) {
        this.url = url;
    }

    public ChinaItemFragment() {
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_chinaitem;
    }

    @Override
    protected void initData() {
        presenter=new ChinaFragPresenter(this);
        if(presenter!=null) {
            presenter.start();
        }
    }

    @Override
    protected void initView(View view) {
        chinaPullRv.setLayoutManager(new LinearLayoutManager(getContext()));
        chinaPullRv.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                chinaPullRv.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        beanList.clear();
                        initData();
                        adapter.notifyDataSetChanged();
                        chinaPullRv.setRefreshComplete();
                    }
                },2000);

            }

            @Override
            public void onLoadMore() {
                chinaPullRv.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        chinaPullRv.setLoadMoreComplete();
                    }
                },2000);

            }
        });
        adapter=new ChinaFragAdapter(getContext(),beanList);
        chinaPullRv.setAdapter(adapter);
    }

    @Override
    public void setBundle(Bundle bundle) {

    }


    @Override
    public void showFragment(ChinaFragmentBean fragmentBean) {
        live = fragmentBean.getLive();
        beanList.addAll(live);
        adapter.notifyDataSetChanged();
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
    public void setPresenter(ChinaFragContract.Presenter presenter) {
        this.presenter=presenter;
        //获得url
        presenter.getStringUrl(url);

    }
}
