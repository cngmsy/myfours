package com.jiyun.qcloud.dashixummoban.ui.live.splendid;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class SplendidFragment extends BaseFragment implements SplendidContract.SplendidView {

    private SplendidContract.SplendidPresenter splendidPresenter;
    private XRecyclerView xRecyclerView;
    private List<SplendBean.VideoBean> beanList = new ArrayList<>();
    private SplendAdapter splendAdapter;
    private int Index = 1;
    Map<String, String> map = new HashMap<>();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 2:
                    beanList.clear();
                    splendAdapter.notifyDataSetChanged();
                    xRecyclerView.refreshComplete();
                    Index=1;
                    initData();
                    break;
                case 3:
                    xRecyclerView.loadMoreComplete();
                    Index++;
                    initData();
                    break;
            }
        }
    };
  /*  private int i=1;
    private int x=1;
    private int y=1;*/

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_splendid;
    }

    @Override
    protected void initData() {
        Bundle bundle = getArguments();
        String vsid = bundle.getString("vsid");

        splendidPresenter = new SplendidPresenter(this);
        map.put("vsid", vsid);
        map.put("n", "7");
        map.put("serviceId", "panda");
        map.put("o", "desc");
        map.put("of", "time");
        map.put("p", Index + "");
        Log.d("SplendidFragment", "Index:" + Index);
        splendidPresenter.mapData(map);
    }

    @Override
    protected void initView(View view) {
        xRecyclerView = view.findViewById(R.id.splendid_xrv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(layoutManager);
        xRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);
        xRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.Pacman);

        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(2, 1000);
            }

            @Override
            public void onLoadMore() {
                handler.sendEmptyMessageDelayed(3, 2000);
            }
        });
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
    public void setPresenter(SplendidContract.SplendidPresenter splendidPresenter) {
        this.splendidPresenter = splendidPresenter;
    }

    @Override
    public void setResultData(SplendBean resultData) {
        beanList.addAll(resultData.getVideo());
        splendAdapter = new SplendAdapter(getContext(), beanList);
        xRecyclerView.setAdapter(splendAdapter);
    }
}
