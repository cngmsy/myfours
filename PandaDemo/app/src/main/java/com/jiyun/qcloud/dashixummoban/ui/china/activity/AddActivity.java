package com.jiyun.qcloud.dashixummoban.ui.china.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.entity.china.ChinaTabBean;
import com.jiyun.qcloud.dashixummoban.entity.china.EventDragFalse;
import com.jiyun.qcloud.dashixummoban.entity.china.EventDragTrue;
import com.jiyun.qcloud.dashixummoban.entity.china.EventTabList;
import com.jiyun.qcloud.dashixummoban.view.MyGridLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liuwangping on 2017/8/25.
 */

public class AddActivity extends BaseActivity {

    @BindView(R.id.add_back)
    ImageView addBack;
    @BindView(R.id.add_bianji)
    Button addBianji;
    @BindView(R.id.hideText)
    TextView hideText;
    @BindView(R.id.add_top_mygridlayout)
    MyGridLayout addTopMygridlayout;
    @BindView(R.id.add_bottom_mygridlayout)
    MyGridLayout addBottomMygridlayout;
    @BindView(R.id.add_Linearlayout)
    LinearLayout addLinearlayout;

    private List<String> toplist=new ArrayList<>();
    private List<String> bottomlist=new ArrayList<>();

    private List<ChinaTabBean.TablistBean> tablist;
    private ChinaTabBean chinaTabBean;
    private List<ChinaTabBean.AlllistBean> alllist;
    @Override
    protected void initData() {
        Intent intent=getIntent();
        chinaTabBean = (ChinaTabBean) intent.getSerializableExtra("ChinaTabBean");
        tablist = chinaTabBean.getTablist();
        for (int i = 0; i< tablist.size(); i++){
            toplist.add(tablist.get(i).getTitle());
        }
        addTopMygridlayout.setAddList(toplist);
        addTopMygridlayout.setDragAble(true);
        alllist = chinaTabBean.getAlllist();
        for (int i = 0; i< alllist.size(); i++){
            if (!toplist.contains(alllist.get(i).getTitle())){
                bottomlist.add(alllist.get(i).getTitle());
            }
        }
        addBottomMygridlayout.setDragAble(false);
        addBottomMygridlayout.setAddList(bottomlist);
    }

    @Override
    protected void initView() {
        EventBus.getDefault().register(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.add_back, R.id.add_bianji})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add_back:
                EventBus.getDefault().post(new EventTabList(toplist));
                finish();
                break;
            case R.id.add_bianji:
                final String str = addBianji.getText().toString().trim();
                if (str.equals("编辑")) {
                    addBianji.setText("完成");
                    hideText.setVisibility(View.VISIBLE);

                } else if (str.equals("完成")) {

                    addBianji.setText("编辑");
                    hideText.setVisibility(View.GONE);

                }
                break;
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent(EventDragTrue messageEvent) {

        String name = messageEvent.getName();
        if (toplist.contains(name)){
            toplist.remove(name);
            bottomlist.add(name);
            ArrayList<String> arrayList = new ArrayList();
            arrayList.add(name);
            addBottomMygridlayout.setAddList(arrayList);
        }

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent1(EventDragFalse messageEvent) {
        String name = messageEvent.getName();

        if (!toplist.contains(name)){
            toplist.add(name);
            bottomlist.remove(name);
            ArrayList<String> arrayList = new ArrayList();
            arrayList.add(name);
            addTopMygridlayout.setAddList(arrayList);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
