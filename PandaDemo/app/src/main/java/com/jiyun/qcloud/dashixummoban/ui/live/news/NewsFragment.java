package com.jiyun.qcloud.dashixummoban.ui.live.news;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;
import com.jiyun.qcloud.dashixummoban.ui.live.splendid.SplendAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class NewsFragment extends BaseFragment implements NewsContract.NewsView {

    private NewsContract.NewsPresenter newsPresenter;
    private XRecyclerView xRecyclerView;
    private List<SplendBean.VideoBean> beanList = new ArrayList<>();
    private SplendAdapter splendAdapter;
    private ProgressDialog dialog;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
              /*  case 1:
                    dialog.dismiss();
                    break;*/
                case 2:
                    initData();
                    splendAdapter.notifyDataSetChanged();
                    xRecyclerView.refreshComplete();
                    break;
                case 3:
                    xRecyclerView.loadMoreComplete();
                    Toast.makeText(getContext(), "暂无更多数据", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initData() {
        newsPresenter=new NewsPresenter(this);
        newsPresenter.start();
    }

    @Override
    protected void initView(View view) {
        xRecyclerView = view.findViewById(R.id.newsxrv);
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
      /*  dialog = new ProgressDialog(getActivity());
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
    public void setPresenter(NewsContract.NewsPresenter newsPresente) {
        newsPresenter=newsPresente;
    }

    @Override
    public void getResult(SplendBean splendBean) {
        beanList.addAll(splendBean.getVideo());
        splendAdapter = new SplendAdapter(getContext(), beanList);
        xRecyclerView.setAdapter(splendAdapter);
    }
}
