package com.jiyun.qcloud.dashixummoban.ui.live.panda_live;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.PandaLiveBean;
import com.jiyun.qcloud.dashixummoban.view.MyViewPager;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.jiyun.qcloud.dashixummoban.R.id.pandanlive_detail;
import static com.jiyun.qcloud.dashixummoban.R.id.pandanlive_tablayout;
import static com.jiyun.qcloud.dashixummoban.R.id.pandanlive_viewpage;

/**
 *
 */
public class PandaLiveFragment extends BaseFragment implements LiveContract.LiveView{

    @BindView(R.id.pandanlive_vitamio)
    ImageView pandanliveVitamio;
    @BindView(R.id.pandanlive_name)
    TextView pandanliveName;
    @BindView(pandanlive_detail)
    ImageView pandanliveDetail;
    @BindView(pandanlive_tablayout)
    TabLayout pandanliveTablayout;
    @BindView(pandanlive_viewpage)
    MyViewPager pandanliveViewpage;
    Unbinder unbinder;
    @BindView(R.id.pandanlive_content)
    TextView pandanliveContent;
    private LiveContract.LivePresenter livePresenter;
    private int co=1;

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
        pandanliveContent.setVisibility(View.GONE);
    }

    @Override
    public void setBundle(Bundle bundle) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(pandanlive_detail)
    public void onViewClicked() {
        if (co==1){
            pandanliveContent.setVisibility(View.VISIBLE);
            pandanliveDetail.setImageResource(R.drawable.com_facebook_tooltip_blue_bottomnub);
            co=0;
        }else if (co==0){
            pandanliveContent.setVisibility(View.GONE);
            pandanliveDetail.setImageResource(R.drawable.com_facebook_tooltip_blue_topnub);
            co=1;
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
        Glide.with(getActivity())
                .load(resultData.getLive().get(0).getImage())
                .into(pandanliveVitamio );
        pandanliveContent.setText(resultData.getLive().get(0).getBrief());
    }
}
