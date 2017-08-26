package com.jiyun.qcloud.dashixummoban.ui.live.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.MultiBean;

import java.util.List;

/**
 * Created by my301s on 2017/8/24.
 */

public class MultiAdapter extends BaseAdapter {
    private Context context;
    private List<MultiBean.ListBean> list;

    public MultiAdapter(Context context, List<MultiBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            holder=new ViewHolder();
            view= LayoutInflater.from(context).inflate(R.layout.mult_item,null);
            holder.mult_image=view.findViewById(R.id.mult_image);
            holder.mult_name=view.findViewById(R.id.mult_name);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        MultiBean.ListBean listBean = list.get(i);
        holder.mult_name.setText(listBean.getTitle());
        Glide.with(context).load(listBean.getImage()).into(holder.mult_image);
        return view;
    }
    public class ViewHolder{
        ImageView mult_image;
        TextView mult_name;
    }
}
