package com.jiyun.qcloud.dashixummoban.adapter.shareadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.entity.share.ShareBean;

import java.util.List;

/**
 * Created by my301s on 2017/8/27.
 */

public class ShareAdapter extends RecyclerView.Adapter<ShareAdapter.MyViewHolder> implements View.OnClickListener {
    private OnrecyclerClick onrecyclerClick;

    public void setOnrecyclerClick(OnrecyclerClick onrecyclerClick) {
        this.onrecyclerClick = onrecyclerClick;
    }

    private Context context;
    private List<ShareBean.InteractiveBean> list;

    public ShareAdapter(Context context, List<ShareBean.InteractiveBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.share_item, null);
        MyViewHolder myViewHolder= new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.share_title.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImage()).into(holder.share_image);
        holder.itemView.setOnClickListener(this);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView share_title;
        private final ImageView share_image;

        public MyViewHolder(View itemView) {
            super(itemView);
            share_title = itemView.findViewById(R.id.share_title);
            share_image = itemView.findViewById(R.id.share_image);
        }
    }

    public interface OnrecyclerClick{
        public void onClick(int position);
    }
    @Override
    public void onClick(View view) {
        Integer position = (Integer) view.getTag();
        if(onrecyclerClick!=null){
            onrecyclerClick.onClick(position);
        }
    }
}
