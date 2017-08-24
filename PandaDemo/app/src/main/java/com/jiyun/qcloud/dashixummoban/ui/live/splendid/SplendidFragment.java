package com.jiyun.qcloud.dashixummoban.ui.live.splendid;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;

/**
 *
 */
public class SplendidFragment extends BaseFragment {

    private XRecyclerView xRecyclerView;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_splendid;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        xRecyclerView = view.findViewById(R.id.splendid_xrv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(layoutManager);
        xRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
    }

    @Override
    public void setBundle(Bundle bundle) {

    }
}
