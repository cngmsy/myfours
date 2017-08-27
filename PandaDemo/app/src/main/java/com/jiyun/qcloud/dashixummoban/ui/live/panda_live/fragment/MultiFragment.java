package com.jiyun.qcloud.dashixummoban.ui.live.panda_live.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.MultiBean;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.MultiPresenter;
import com.jiyun.qcloud.dashixummoban.ui.live.adapter.MultiAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MultiFragment extends BaseFragment implements MultiContract.MultiView{

    private GridView multi_grid;
    private MultiContract.MultiPresenter multiPresenter;
    private List<MultiBean.ListBean> list= new ArrayList<>();

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_multi;
    }

    @Override
    protected void initData() {
        multiPresenter = new MultiPresenter(this);
        multiPresenter.start();
    }

    @Override
    protected void initView(View view) {
        multi_grid = view.findViewById(R.id.multi_grid);
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
    public void setPresenter(MultiContract.MultiPresenter multiPresenter) {
        this.multiPresenter=multiPresenter;
    }

    @Override
    public void setResultData(MultiBean resultData) {
        list.addAll(resultData.getList());
        MultiAdapter multiAdapter = new MultiAdapter(getContext(),list);
        multi_grid.setAdapter(multiAdapter);

        multi_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.putExtra("listBean", list.get(i));
                intent.setAction("zlj");
                getActivity().sendBroadcast(intent);
            }
        });
    }
}
