package com.jiyun.qcloud.dashixummoban.ui.live.top;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;
import com.jiyun.qcloud.dashixummoban.ui.live.splendid.SplendAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class TopFragment extends BaseFragment implements TopContract.TopView {
    private TopContract.TopPresenter topPresenter;
    private XRecyclerView xRecyclerView;
    private List<SplendBean.VideoBean> beanList = new ArrayList<>();
    private SplendAdapter splendAdapter;
    private int Index = 1;
    Map<String,String> map=new HashMap<>();
    //   private ProgressDialog dialog;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
               /* case 1:
                    dialog.dismiss();
                    break;*/
                case 2:
                    initData();
                    Index++;
                    xRecyclerView.refreshComplete();
                    splendAdapter.notifyDataSetChanged();
                    break;
                case 3:
                    Index=1;
                    xRecyclerView.loadMoreComplete();
                    splendAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };



    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_top;
    }

    @Override
    protected void initData() {
        topPresenter = new TopPresenter(this);
        map.put("vsid","VSET100284428835");
        map.put("n","7");
        map.put("serviceId","panda");
        map.put("o","desc");
        map.put("of","time");
        map.put("p",Index+"");
        //   Log.d("SplendidFragment", map.toString());
        topPresenter.mapData(map);
    }

    @Override
    protected void initView(View view) {
        xRecyclerView = view.findViewById(R.id.topxrv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(layoutManager);
        xRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);
        xRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.Pacman);

        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(2,1000);
            }
            @Override
            public void onLoadMore() {
                handler.sendEmptyMessageDelayed(3,2000);
            }
        });
    }

    @Override
    public void setBundle(Bundle bundle) {

    }

    @Override
    public void showProgress() {
       /* dialog = new ProgressDialog(getActivity());
        dialog.setProgress(100);
        dialog.show();
        handler.sendEmptyMessageDelayed(1,1500);*/
    }

    @Override
    public void dimissProgress() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(TopContract.TopPresenter topPresente) {
        topPresenter = topPresente;
    }

    @Override
    public void getResult(SplendBean splendBean) {
        beanList.addAll(splendBean.getVideo());
        splendAdapter = new SplendAdapter(getContext(), beanList);
        xRecyclerView.setAdapter(splendAdapter);
    }
}
