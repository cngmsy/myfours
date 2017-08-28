package com.jiyun.qcloud.dashixummoban.ui.culture;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.gungun.Gun;
import com.jiyun.qcloud.dashixummoban.ui.culture.gungunxiang.GunxiangActivity;
import com.jiyun.qcloud.dashixummoban.ui.culture.gungunxiang.HeaderActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CulturePageFragment extends BaseFragment implements CultureContract.View {

    private  ImageView gungunHeaderimage;
   private TextView gungunHeadercontext;
    private int refreshTime = 0;
    XRecyclerView gunxrecycler;
    private CultureContract.Presenter presenter;
    Unbinder unbinder;
    List<Gun.ListBean> mList = new ArrayList<>();
    private String image;
    private String title;
    private View infla;
    private CuAdapter adapter;
    private List<Gun.ListBean> list;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_culture_page;
    }

    @Override
    protected void initData() {
        presenter=new CulturePresenter(this);
        if (presenter!= null) {
            presenter.start();
        }
    }

    @Override
    protected void initView(View view) {
       gunxrecycler = view.findViewById(R.id.gunxrecycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        gunxrecycler.setLayoutManager(layoutManager);
        gunxrecycler.setPullRefreshEnabled(true);
        gunxrecycler.setLoadingMoreProgressStyle(ProgressStyle.Pacman);
        gunxrecycler.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        gunxrecycler.setArrowImageView(R.drawable.iconfont_downgrey);
        gunxrecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                refreshTime ++;
                new Handler().postDelayed(new Runnable(){
                    public void run() {
                        mList.clear();
                        mList.addAll(list);
                        adapter = new CuAdapter(getContext(),mList);
                        gunxrecycler.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        gunxrecycler.refreshComplete();
                    }

                }, 3000);
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable(){
                    public void run() {
                      /*  for(int i = 0; i < 15 ;i++){
                            mList.add( i + mList.size() );
                        }*/
                        adapter.notifyDataSetChanged();
                        gunxrecycler.loadMoreComplete();
                    }
                }, 3000);

            }
        });

    }

    @Override
    public void setBundle(Bundle bundle) {

    }
    @Override
    public void showGunlistData(Gun gun) {

        List<Gun.BigImgBean> palist = gun.getBigImg();
        for (int i = 0; i < palist.size(); i++) {
            image = palist.get(i).getImage();
            title = palist.get(i).getTitle();
            Log.e("TAG",image+title+"..............");
        }
        list = gun.getList();
        mList.addAll(list);
        adapter = new CuAdapter(getContext(),mList);
        gunxrecycler.setAdapter(adapter);
        initimage();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
            }
        });
        adapter.setOnItemClickLinear(new CuAdapter.OnItemClickLinear() {
            @Override
            public void onItemvlick(int position) {
                Intent intent = new Intent(getActivity(), GunxiangActivity.class);
                intent.putExtra("vsid",list.get(position).getId());
                startActivity(intent);
            }
        });
        gungunHeaderimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HeaderActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initimage() {
        infla = LayoutInflater.from(getContext()).inflate(R.layout.gungun_header, null);
        gungunHeaderimage = infla.findViewById(R.id.gungun_headerimage);
        gungunHeadercontext = infla.findViewById(R.id.gungun_headercontext);
        gungunHeadercontext.setText(title);
        Glide.with(getContext()).load(image).into(gungunHeaderimage);
        gunxrecycler.addHeaderView(infla);
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
    public void setPresenter(CultureContract.Presenter presenter) {
        this.presenter = presenter;
    }

}
