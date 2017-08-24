package com.jiyun.qcloud.dashixummoban.ui.live.panda_live;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.PandaLiveBean;
import com.jiyun.qcloud.dashixummoban.ui.live.LiveAdapter;
import com.jiyun.qcloud.dashixummoban.ui.live.panda_live.fragment.BianLiveFragment;
import com.jiyun.qcloud.dashixummoban.ui.live.panda_live.fragment.MultiFragment;
import com.jiyun.qcloud.dashixummoban.view.MyViewPager;

import java.util.ArrayList;

import butterknife.OnClick;

import static com.jiyun.qcloud.dashixummoban.R.id.pandanlive_detail;

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
        pandanliveVitamio = (ImageView) view.findViewById(R.id.pandanlive_vitamio);
        pandanliveName = (TextView) view.findViewById(R.id.pandanlive_name);
        pandanliveContent = (TextView) view.findViewById(R.id.pandanlive_content);
        pandanliveDetail = (ImageView) view.findViewById(R.id.pandanlive_detail);
        pandanliveTablayout = (TabLayout) view.findViewById(R.id.pandanlive_tablayout);
        pandanliveViewpage = (MyViewPager) view.findViewById(R.id.pandanlive_viewpage);
        pandanliveContent.setVisibility(View.GONE);
    }

    @Override
    public void setBundle(Bundle bundle) {

    }


    @OnClick(pandanlive_detail)
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

        list.add(new MultiFragment());
        list.add(new BianLiveFragment());


        Glide.with(getActivity())
                .load(resultData.getLive().get(0).getImage())
                .into(pandanliveVitamio);
        pandanliveContent.setText(resultData.getLive().get(0).getBrief());

        handler.sendEmptyMessage(1);
    }
}
