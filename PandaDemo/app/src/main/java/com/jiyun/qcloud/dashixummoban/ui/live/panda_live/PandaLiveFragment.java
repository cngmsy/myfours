package com.jiyun.qcloud.dashixummoban.ui.live.panda_live;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dl7.player.media.IjkPlayerView;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.LiveVideoBean;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.MultiBean;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.PandaLiveBean;
import com.jiyun.qcloud.dashixummoban.ui.live.adapter.LiveAdapter;
import com.jiyun.qcloud.dashixummoban.ui.live.panda_live.fragment.BianLiveFragment;
import com.jiyun.qcloud.dashixummoban.ui.live.panda_live.fragment.MultiFragment;
import com.jiyun.qcloud.dashixummoban.view.MyMediaController;
import com.jiyun.qcloud.dashixummoban.view.MyViewPager;

import java.util.ArrayList;

import butterknife.OnClick;
import io.vov.vitamio.Vitamio;

/**
 *
 */
public class PandaLiveFragment extends BaseFragment implements LiveContract.LiveView {

    ImageView pandanliveVitamio;
    TextView pandanliveName;
    ImageView pandanliveDetail;
    TabLayout pandanliveTablayout;
    MyViewPager pandanliveViewpage;
    TextView pandanliveContent;
    private LiveContract.LivePresenter livePresenter;
    private int co = 1;
    private LiveAdapter adapter;
    private ArrayList<Fragment> list = new ArrayList<>();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    adapter = new LiveAdapter(getActivity().getSupportFragmentManager(), list);
                    pandanliveViewpage.setAdapter(adapter);
                    pandanliveTablayout.setTabMode(TabLayout.MODE_FIXED);
                    pandanliveViewpage.setNoScroll(true);
                    pandanliveTablayout.setupWithViewPager(pandanliveViewpage);
                    break;
            }
        }
    };
    private MultiBean.ListBean listBean;
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            listBean = (MultiBean.ListBean) intent.getSerializableExtra("listBean");
            livePresenter.setURL("http://vdn.live.cntv.cn/api2/live.do?client=androidapp&channel=pa://cctv_p2p_hd" + listBean.getId());
            pandanliveName.setText(listBean.getTitle());
        }
    };
    private IjkPlayerView vitamio;
    private MyMediaController mMediaController;
    private String flv2;


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_panda_live;
    }

    @Override
    protected void initData() {
        livePresenter = new LivePresenter(this);
        livePresenter.start();
    }

    @Override
    protected void initView(View view) {
        Vitamio.isInitialized(getContext());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("zlj");
        getActivity().registerReceiver(receiver, intentFilter);

        pandanliveVitamio = (ImageView) view.findViewById(R.id.pandanlive_vitamio);
        pandanliveName = (TextView) view.findViewById(R.id.pandanlive_name);
        pandanliveContent = (TextView) view.findViewById(R.id.pandanlive_content);
        pandanliveDetail = (ImageView) view.findViewById(R.id.pandanlive_detail);
        pandanliveTablayout = (TabLayout) view.findViewById(R.id.pandanlive_tablayout);
        pandanliveViewpage = (MyViewPager) view.findViewById(R.id.pandanlive_viewpage);
        vitamio = view.findViewById(R.id.vitamio);
        pandanliveContent.setVisibility(View.GONE);

    }

    @Override
    public void setBundle(Bundle bundle) {

    }


    @OnClick(R.id.pandanlive_detail)
    public void onViewClicked() {
        if (co == 1) {
            pandanliveContent.setVisibility(View.VISIBLE);
            pandanliveDetail.setImageResource(R.drawable.com_facebook_tooltip_blue_bottomnub);
            co = 0;
        } else if (co == 0) {
            pandanliveContent.setVisibility(View.GONE);
            pandanliveDetail.setImageResource(R.drawable.com_facebook_tooltip_blue_topnub);
            co = 1;
        }
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
    public void setPresenter(LiveContract.LivePresenter pandaLivePresenter) {
        livePresenter = pandaLivePresenter;
    }

    @Override
    public void setResultData(PandaLiveBean resultData) {

        list.clear();
        list.add(new MultiFragment());
        list.add(new BianLiveFragment());
        Glide.with(getActivity())
                .load(resultData.getLive().get(0).getImage())
                .into(pandanliveVitamio);
        pandanliveContent.setText(resultData.getLive().get(0).getBrief());
        handler.sendEmptyMessage(1);
    }

    @Override
    public void setUrlurl(LiveVideoBean liveBean) {
        pandanliveVitamio.setVisibility(View.GONE);
        flv2 = liveBean.getFlv_url().getFlv2();
        Log.d("PandaLiveFragment", flv2);
        playVideo();

    }

    private void playVideo() {
       /* vitamio.setVideoURI(Uri.parse(flv2));
        mMediaController = new MyMediaController(getContext(),vitamio,getActivity());//实例化控制器
        mMediaController.show(5000);//控制器显示5s后自动隐藏
        vitamio.setMediaController(mMediaController);//绑定控制器
        vitamio.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);//设置播放画质 高画质
        vitamio.requestFocus();//取得焦点*/
        vitamio.init().setVideoPath(flv2).start();
    }

    @Override
    public void onResume() {
        super.onResume();
        vitamio.onResume();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(hidden==true){

        }
    }

    /*
    @Override
    public void onPause() {
        super.onPause();
        vitamio.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        vitamio.onDestroy();
        vitamio.stop();
    }*/
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            livePresenter = new LivePresenter(this);
            livePresenter.start();
        } else {
            if (vitamio != null) {
                if (flv2 != null || vitamio.isPlaying()) {
                    flv2 = null;
                    vitamio.onPause();
                }
                if (flv2 != null || vitamio.isPlaying()) {
                    flv2 = null;
                    vitamio.onDestroy();
                }
            }
        }
    }
}
