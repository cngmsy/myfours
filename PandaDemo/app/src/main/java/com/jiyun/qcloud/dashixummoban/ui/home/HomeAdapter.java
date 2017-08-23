package com.jiyun.qcloud.dashixummoban.ui.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.qcloud.dashixummoban.R;

import java.util.List;

/**
 * Created by Administrator on 2017/8/23.
 */

public class HomeAdapter extends RecyclerView.Adapter{
    private Context   context;
    private List   datalist;

    public HomeAdapter(Context context, List datalist) {
        this.context = context;
        this.datalist = datalist;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_bao, parent, false);
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
