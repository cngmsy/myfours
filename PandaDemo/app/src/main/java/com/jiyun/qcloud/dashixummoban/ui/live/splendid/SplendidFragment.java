package com.jiyun.qcloud.dashixummoban.ui.live.splendid;

import android.app.ProgressDialog;
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
import java.util.List;

/**
 *
 */
public class SplendidFragment extends BaseFragment implements SplendidContract.SplendidView {

    private SplendidContract.SplendidPresenter splendidPresenter;
    private XRecyclerView xRecyclerView;
    private List<SplendBean.VideoBean> beanList = new ArrayList<>();
    private SplendAdapter splendAdapter;
    private ProgressDialog dialog;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    dialog.dismiss();
                    break;
                case 2:
                    initData();
                    splendAdapter.notifyDataSetChanged();
                    xRecyclerView.refreshComplete();
                    break;
                case 3:
                    xRecyclerView.loadMoreComplete();
                    break;
            }
        }
    };

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_splendid;
    }

    @Override
    protected void initData() {
        splendidPresenter = new SplendidPresenter(this);
        splendidPresenter.start();
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
        dialog = new ProgressDialog(getActivity());
        dialog.setProgress(100);
        dialog.show();
        // handler.sendEmptyMessageDelayed(0, 1000);
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
        Log.e("SplendidFragment", resultData.getVideo().get(0).getEm());
        beanList.addAll(resultData.getVideo());
        splendAdapter = new SplendAdapter(getContext(), beanList);
        xRecyclerView.setAdapter(splendAdapter);
    }
}
