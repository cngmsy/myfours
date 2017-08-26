package com.jiyun.qcloud.dashixummoban.ui.live.chaomeng;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
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
 * A simple {@link Fragment} subclass.
 */
public class ChaoMengFragment extends BaseFragment implements ChaoMengContact.ChaoMengView {
    private ChaoMengContact.ChaoMengPresenter chaoMengPresenter;
    private XRecyclerView xRecyclerView;
    private List<SplendBean.VideoBean> beanList = new ArrayList<>();
    private Map<String, String> map = new HashMap<>();
    private int Index = 1;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 2:
                    initData();
                    Index++;
                    splendAdapter.notifyDataSetChanged();
                    xRecyclerView.refreshComplete();
                    splendAdapter.notifyDataSetChanged();
                    break;
                case 3:
                    Index = 1;
                    xRecyclerView.loadMoreComplete();
                    splendAdapter.notifyDataSetChanged();
                    //Toast.makeText(getContext(), "暂无更多数据", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    private SplendAdapter splendAdapter;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_chao_meng;
    }

    @Override
    protected void initData() {
        chaoMengPresenter = new ChaoMengPresenter(this);
        map.put("vsid", "VSET100272959126");
        map.put("n", "7");
        map.put("serviceId", "panda");
        map.put("o", "desc");
        map.put("of", "time");
        map.put("p", Index + "");
        //   Log.d("SplendidFragment", map.toString());
        chaoMengPresenter.mapData(map);
    }

    @Override
    protected void initView(View view) {
        xRecyclerView = view.findViewById(R.id.chaomengxrv);
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
    public void setPresenter(ChaoMengContact.ChaoMengPresenter chaoMengPresente) {
        this.chaoMengPresenter = chaoMengPresente;
    }

    @Override
    public void setResultData(SplendBean resultData) {
        // Log.d("ChaoMengFragment", resultData.getVideo().get(0).getLen());
        beanList.addAll(resultData.getVideo());
        splendAdapter = new SplendAdapter(getContext(), beanList);
        xRecyclerView.setAdapter(splendAdapter);
    }
}
