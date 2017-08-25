package com.jiyun.qcloud.dashixummoban.ui.live.splendid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;

import java.util.List;

/**
 * Created by my301s on 2017/8/25.
 */

public class SplendAdapter extends RecyclerView.Adapter<SplendAdapter.SplendViewHolder> {
    private Context context;
    private List<SplendBean.VideoBean> list;

    public SplendAdapter(Context context, List<SplendBean.VideoBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public SplendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_splendid_item, null);
        SplendViewHolder viewHolder = new SplendViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SplendViewHolder holder, int position) {
        holder.tv_splendid_daytime.setText(list.get(position).getPtime());
        holder.tv_splendid_length.setText(list.get(position).getLen());
        holder.tv_splendid_title.setText(list.get(position).getT());
        Glide.with(context).load(list.get(position).getImg()).into(holder.iv_splendid);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class SplendViewHolder extends RecyclerView.ViewHolder{

        private final ImageView iv_splendid;
        private final TextView tv_splendid_title;
        private final TextView tv_splendid_daytime;
        private final TextView tv_splendid_length;

        public SplendViewHolder(View itemView) {
            super(itemView);
            iv_splendid = itemView.findViewById(R.id.iv_splendid);
            tv_splendid_title = itemView.findViewById(R.id.tv_splendid_title);
            tv_splendid_daytime = itemView.findViewById(R.id.tv_splendid_daytime);
            tv_splendid_length = itemView.findViewById(R.id.tv_splendid_length);
        }
    }
}
