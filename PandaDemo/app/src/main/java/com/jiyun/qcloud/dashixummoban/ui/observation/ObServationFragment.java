package com.jiyun.qcloud.dashixummoban.ui.observation;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.Bobao.Bo;
import com.jiyun.qcloud.dashixummoban.entity.Bobao.Bolist;
import com.jiyun.qcloud.dashixummoban.ui.observation.bobaoxiang.BOheaderActivity;
import com.jiyun.qcloud.dashixummoban.ui.observation.bobaoxiang.BoxiangActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 *
 */
public class ObServationFragment extends BaseFragment implements ObContract.View {
    private ImageView boHeaderimage;
    private TextView boHeadercontext;
    @BindView(R.id.obrecycler)
    XRecyclerView obrecycler;
    Unbinder unbinder;
    private int Index = 1;
    List<Bo.DataBean.BigImgBean> list2 = new ArrayList<>();
    List<Bolist.ListBean> bolist = new ArrayList<>();
    ObContract.Presenter presenter;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    adapter.notifyDataSetChanged();
                    break;
                case 2:
                    initData();
                    Index++;
                    obrecycler.refreshComplete();
                    adapter.notifyDataSetChanged();
                    break;
                case 3:
                    Index=1;
                    obrecycler.loadMoreComplete();
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    };
    private BoAdapter adapter;
    private String image;
    private String title;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_ob_servation;
    }

    @Override
    protected void initData() {
        presenter = new ObPresenter(this);
        if (presenter!= null) {
            presenter.start();
        }
    }

    @Override
    protected void initView(View view) {
        presenter = new ObPresenter(this);
        presenter.start();
        View inflas = LayoutInflater.from(getContext()).inflate(R.layout.gungun_header,null);
        boHeaderimage = inflas.findViewById(R.id.gungun_headerimage);
        boHeadercontext = inflas.findViewById(R.id.gungun_headercontext);
        obrecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        obrecycler.setPullRefreshEnabled(true);
        obrecycler.setLoadingMoreProgressStyle(ProgressStyle.Pacman);
        obrecycler.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        obrecycler.setArrowImageView(R.drawable.iconfont_downgrey);
        adapter = new BoAdapter(bolist,getActivity());
        obrecycler.setAdapter(adapter);
        obrecycler.addHeaderView(inflas);

        obrecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
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
    public void showBoData(Bo bo) {

        presenter.seconed(bo.getData().getListurl());
       List<Bo.DataBean.BigImgBean> list2 = new ArrayList<>();
            Glide.with(boHeaderimage.getContext()).load(bo.getData().getBigImg().get(0).getImage()).into(boHeaderimage);
            boHeadercontext.setText(bo.getData().getBigImg().get(0).getTitle());
            handler.sendEmptyMessage(1);
    }

    @Override
    public void showBoListData(final List<Bolist.ListBean> list) {
        bolist.addAll(list);
        handler.sendEmptyMessage(1);
        adapter.setOnItemClickLinear(new BoAdapter.OnItemClickLinear() {
            @Override
            public void onItemvlick(int position) {
                Toast.makeText(getActivity(),"Shaskjasjas",Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(getActivity(), BoxiangActivity.class);
               intent.putExtra("id",bolist.get(position).getId());
                getActivity().startActivity(intent);
            }
        });

        boHeaderimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), BOheaderActivity.class));
            }
        });
    }
    @Override
    public void listener() {

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
    public void setPresenter(ObContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
