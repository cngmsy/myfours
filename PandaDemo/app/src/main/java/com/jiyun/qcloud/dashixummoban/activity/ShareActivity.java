package com.jiyun.qcloud.dashixummoban.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.activity.sharepresent.ShareContract;
import com.jiyun.qcloud.dashixummoban.activity.sharepresent.SharePresenter;
import com.jiyun.qcloud.dashixummoban.adapter.shareadapter.ShareAdapter;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.entity.share.ShareBean;

import java.util.ArrayList;
import java.util.List;

public class ShareActivity extends BaseActivity implements ShareContract.ShareView{

    private XRecyclerView xRecyclerView;
    private ShareContract.SharePresenter sharePresenter;
    private List<ShareBean.InteractiveBean> list=new ArrayList<>();
    private ShareAdapter shareAdapter;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    xRecyclerView.refreshComplete();
                    shareAdapter.notifyDataSetChanged();
                    break;
                case 2:
                    Toast.makeText(ShareActivity.this, "暂无更多数据", Toast.LENGTH_SHORT).show();
                    xRecyclerView.loadMoreComplete();
                    shareAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };
    private ImageView sha_back;

    @Override
    protected void initData() {
        sharePresenter=new SharePresenter(this);
        sharePresenter.start();
    }

    @Override
    protected void initView() {
        xRecyclerView = (XRecyclerView) findViewById(R.id.share_srv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(layoutManager);
        xRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);
        xRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.Pacman);

        sha_back = (ImageView) findViewById(R.id.sha_back);
        sha_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_share;
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
    public void setPresenter(ShareContract.SharePresenter sharePresente) {
        sharePresenter=sharePresente;
    }

    @Override
    public void getResult(ShareBean shareBean) {
        list.addAll(shareBean.getInteractive());
        shareAdapter = new ShareAdapter(this,list);
        xRecyclerView.setAdapter(shareAdapter);

        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(1,2000);
            }

            @Override
            public void onLoadMore() {
                handler.sendEmptyMessageDelayed(2,2000);
            }
        });
        
        shareAdapter.setOnrecyclerClick(new ShareAdapter.OnrecyclerClick() {
            @Override
            public void onClick(int position) {
                Intent intent= new Intent(ShareActivity.this,ShareDetailActivity.class);
                intent.putExtra("data",list.get(position));
                startActivity(intent);
            }
        });
    }
}
