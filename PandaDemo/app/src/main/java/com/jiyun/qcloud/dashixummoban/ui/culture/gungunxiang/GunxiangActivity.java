package com.jiyun.qcloud.dashixummoban.ui.culture.gungunxiang;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class GunxiangActivity extends BaseActivity implements XiangContract.TopView {

    @BindView(R.id.xiang_recycler)
    XRecyclerView xiangRecycler;
    @BindView(R.id.jiecaovideo)
    JCVideoPlayer jiecaovideo;
    @BindView(R.id.img_littlejian)
    ImageView imgLittlejian;
    @BindView(R.id.lanmu)
    TextView lanmu;
    @BindView(R.id.refd)
    RelativeLayout refd;
    int co = 1;
    private int Index = 1;
    private String url;
    private List<SplendBean.VideoBean> beanList = new ArrayList<>();
    XiangContract.XiangPresenter xiangPresenter;
    Map<String,String> map=new HashMap<>();
    private GunAdapter splendAdapter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 2:
                    initData();
                    Index++;
                    xiangRecycler.refreshComplete();
                    splendAdapter.notifyDataSetChanged();
                    break;
                case 3:
                    Index=1;
                    xiangRecycler.loadMoreComplete();
                    splendAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };
    private String vid;
    private String url1;
    private String ds;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        url = intent.getStringExtra("vsid");
        xiangPresenter = new XiangPresenter(this);
        map.put("vsid",url);
        map.put("n","7");
        map.put("serviceId","panda");
        map.put("o","desc");
        map.put("of","time");
        map.put("p",Index+"");
        xiangPresenter.mapData(map);
    }

    @Override
    protected void initView() {
        imgLittlejian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (co == 1) {
                    refd.setVisibility(View.VISIBLE);
                    imgLittlejian.setImageResource(R.drawable.com_facebook_tooltip_blue_bottomnub);
                    co = 0;
                } else if (co == 0) {
                    refd.setVisibility(View.GONE);
                    imgLittlejian.setImageResource(R.drawable.com_facebook_tooltip_blue_topnub);
                    co = 1;
                }
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xiangRecycler.setLayoutManager(layoutManager);
        xiangRecycler.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xiangRecycler.setArrowImageView(R.drawable.iconfont_downgrey);
        xiangRecycler.setLoadingMoreProgressStyle(ProgressStyle.Pacman);
        xiangRecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
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
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_gunxiang;
    }

    @Override
    public void getResult(final SplendBean splendBean) {

        beanList.addAll(splendBean.getVideo());
        xiangPresenter.getVid(splendBean.getVideo().get(0).getVid());
       xiangPresenter.start();
        vid= splendBean.getVideo().get(1).getVid();
        String title = beanList.get(1).getT();
        jiecaovideo.setUp(ds,title,true);
        splendAdapter = new GunAdapter(this, beanList);
        xiangRecycler.setAdapter(splendAdapter);

        splendAdapter.setOnItemClickLinear(new GunAdapter.OnItemClickLinear() {
            @Override
            public void onItemvlick(int position) {
                    vid = splendBean.getVideo().get(position).getVid();
                  xiangPresenter.getVid(GunxiangActivity.this.vid);
                xiangPresenter.start();
                jiecaovideo.setUp(url1,beanList.get(position).getT(),true);
            }
        });
    }

    @Override
    public void getvideo(Gunbean gunbean) {
        List<Gunbean.VideoBean.ChaptersBean> chapters = gunbean.getVideo().getChapters();
        Logger.d(chapters.toString());
        for (int i=0;i<chapters.size();i++){
            url1= chapters.get(i).getUrl();
           // ds = chapters.get(1).getUrl();
        }
        jiecaovideo.setUp(chapters.get(0).getUrl(),gunbean.getTitle());
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
    public void setPresenter(XiangContract.XiangPresenter xiangPresenter) {
                this.xiangPresenter = xiangPresenter;

    }


}
