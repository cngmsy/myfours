package com.jiyun.qcloud.dashixummoban.ui.china;


import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.adapter.china.ChinaTabAdapter;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.china.ChinaTabBean;
import com.jiyun.qcloud.dashixummoban.ui.china.vpagerfragment.ChinaItemFragment;
import com.jiyun.qcloud.dashixummoban.view.MyGridLayout;
import com.jiyun.qcloud.dashixummoban.view.MyViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 */
public class ChinaPageFragment extends BaseFragment implements LiveChinaContract.View {
    @BindView(R.id.chinaTabLayout)
    TabLayout chinaTabLayout;
    @BindView(R.id.chinaAdd)
    ImageView chinaAdd;
    @BindView(R.id.chinaViewPager)
    MyViewPager chinaViewPager;
    private LiveChinaContract.Presenter presenter;
    private List<String> tabNamelist = new ArrayList<>();
    private List<Fragment> fragmentlist = new ArrayList<>();
    private ChinaTabAdapter adapter;
    private List<ChinaTabBean.AlllistBean> alllist;
    private List<ChinaTabBean.TablistBean> tablist;
    private MyGridLayout topmygridlayout;
    private MyGridLayout bottommygridlayout;
    private Button bianji;
    private TextView hideText;
    private  ArrayList<String> stringArrayList=new ArrayList<>();
    private String title;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_china_page;
    }

    @Override
    protected void initData() {
        presenter = new LiveChinaPresenter(this);
        if (presenter != null) {
            presenter.start();
        }

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public void setBundle(Bundle bundle) {

    }


    @Override
    public void showChinaTab(ChinaTabBean chinaTabBean) {
        tablist = chinaTabBean.getTablist();
        alllist = chinaTabBean.getAlllist();

        //去掉下面集合和上面重复的数据
        if(stringArrayList.size()==0) {
           for (int i = 0; i < alllist.size(); i++) {
                for (int j = 0; j < tablist.size(); j++) {
                    title = alllist.get(i).getTitle();
                    String title1 = tablist.get(j).getTitle();
                    if (title.equals(title1)) {
                        alllist.remove(i);
                    }
                }
                stringArrayList.add(title);
            }
        }

        for (int i = 0; i < tablist.size(); i++) {
            tabNamelist.add(tablist.get(i).getTitle());
            fragmentlist.add(new ChinaItemFragment(tablist.get(i).getUrl()));
        }

        adapter = new ChinaTabAdapter(getChildFragmentManager(), fragmentlist, tabNamelist);
        chinaViewPager.setNoScroll(true);
        chinaViewPager.setAdapter(adapter);
        chinaTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        chinaTabLayout.setupWithViewPager(chinaViewPager);
        adapter.notifyDataSetChanged();
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
    public void setPresenter(LiveChinaContract.Presenter presenter) {
        this.presenter = presenter;

    }



    @OnClick(R.id.chinaAdd)
    public void onViewClicked() {
     initAdd();
    }


    private void initAdd(){
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.activity_add, null);
        topmygridlayout =inflate.findViewById(R.id.add_top_mygridlayout);
        bottommygridlayout=inflate.findViewById(R.id.add_bottom_mygridlayout);
        bianji = inflate.findViewById(R.id.add_bianji);
        hideText = inflate.findViewById(R.id.hideText);
        ImageView back= inflate.findViewById(R.id.add_back);
        topmygridlayout.setDragAble(true);
        bottommygridlayout.setDragAble(false);
        //给上下Gridlayout赋值
        topmygridlayout.setAddList(tabNamelist);
        bottommygridlayout.setAddList(stringArrayList);
        //这是初始化布局为了显示PuPO
        //这是new一个对象后面的参数。第一个参数布局，第二个参数用容器调用一个系统的方法，后面的是旋转的度数
        final PopupWindow popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        popupWindow.setFocusable(true);
        //new一个过期的方法点击屏幕以外消失
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //这是i定义的引用动画
        popupWindow.setAnimationStyle(R.style.fade);

        // 这个是显示的意思
        popupWindow.showAsDropDown(inflate);
        bianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String str =bianji.getText().toString().trim();
                if (str.equals("编辑")) {
                    bianji.setText("完成");
                    hideText.setVisibility(View.VISIBLE);

                    //点击上边的MyGridLayout
                    topmygridlayout.setOnItemClickListener(new MyGridLayout.OnItemClickListener() {
                        @Override
                        public void onItemClick(TextView tv) {
                            if(tablist.size()>4) {
                                //上边的textview删除
                                topmygridlayout.removeView(tv);
                                //下边的textview添加
                                bottommygridlayout.addTvItem(tv.getText().toString().trim());
                                for (int i = 0; i < tablist.size(); i++) {
                                    if (tablist.get(i).getTitle().equals(tv.getText().toString().trim())) {
                                        ChinaTabBean.AlllistBean alllistBean1 = new ChinaTabBean.AlllistBean();
                                        ChinaTabBean.TablistBean tablistBean = tablist.get(i);
                                        alllistBean1.setTitle(tablistBean.getTitle());
                                        alllistBean1.setUrl(tablistBean.getUrl());
                                        alllist.add(alllistBean1);
                                        tablist.remove(i);
                                        tabNamelist.remove(tv.getText().toString().trim());
                                        fragmentlist.remove(i);
                                        adapter.notifyDataSetChanged();

                                    }
                                }
                            }else{
                                Toast.makeText(getActivity(), "栏目区，不能少于4个频道", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    //点击下边
                    bottommygridlayout.setOnItemClickListener(new MyGridLayout.OnItemClickListener() {
                        @Override
                        public void onItemClick(TextView tv) {
                            //下边的textview删除
                            bottommygridlayout.removeView(tv);
                            //上边的textview添加
                           topmygridlayout.addTvItem(tv.getText().toString().trim());

                            for (int i = 0; i <alllist.size(); i++) {
                                if(alllist.get(i).getTitle().equals(tv.getText().toString().trim())){
                                    ChinaTabBean.TablistBean tablistBean = new ChinaTabBean.TablistBean();
                                    ChinaTabBean.AlllistBean alllistBean = alllist.get(i);
                                    tablistBean.setTitle(alllistBean.getTitle());
                                    tablistBean.setUrl(alllistBean.getUrl());
                                    tablist.add(tablistBean);
                                    //移除下边集合的条目
                                    alllist.remove(i);
                                    tabNamelist.add(tv.getText().toString().trim());
                                    fragmentlist.add(new ChinaItemFragment(alllistBean.getUrl()));
                                    adapter.notifyDataSetChanged();

                                }
                            }
                        }
                    });

                } else if (str.equals("完成")) {
                    bianji.setText("编辑");
                    hideText.setVisibility(View.GONE);
                    adapter.notifyDataSetChanged();
                    topmygridlayout.setOnItemClickListener(new MyGridLayout.OnItemClickListener() {
                        @Override
                        public void onItemClick(TextView tv) {
                            adapter.notifyDataSetChanged();

                        }
                    });
                    bottommygridlayout.setOnItemClickListener(new MyGridLayout.OnItemClickListener() {
                        @Override
                        public void onItemClick(TextView tv) {
                            adapter.notifyDataSetChanged();

                        }
                    });
                }

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.notifyDataSetChanged();
                popupWindow.dismiss();
            }
        });
    }

}
