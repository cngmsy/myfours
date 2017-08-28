package com.jiyun.qcloud.dashixummoban.ui.culture.gungunxiang;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.entity.pandalive.SplendBean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/28.
 */

public class GunAdapter extends RecyclerView.Adapter<GunAdapter.ViewHolder> {
    private Context context;
    private List<SplendBean.VideoBean> list;
    private OnItemClickLinear onItemClickLinear;
    public void setOnItemClickLinear(OnItemClickLinear onItemClickLinear) {
        this.onItemClickLinear = onItemClickLinear;
    }
    public interface OnItemClickLinear {
        public void onItemvlick(int position);
    }
    public GunAdapter(Context context, List<SplendBean.VideoBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public GunAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_splendid_item, null);
        GunAdapter.ViewHolder viewHolder = new GunAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GunAdapter.ViewHolder holder, final int position) {
        holder.tv_splendid_daytime.setText(list.get(position).getPtime());
        holder.tv_splendid_length.setText(list.get(position).getLen());
        holder.tv_splendid_title.setText(list.get(position).getT());
        Glide.with(context).load(list.get(position).getImg()).into(holder.iv_splendid);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickLinear != null) {
                    onItemClickLinear.onItemvlick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       ImageView iv_splendid;
        TextView tv_splendid_title;
        TextView tv_splendid_daytime;
        TextView tv_splendid_length;
        RelativeLayout rl_splendid;
        public ViewHolder(View itemView) {
            super(itemView);
            rl_splendid = itemView.findViewById(R.id.rl_splendid);
            iv_splendid = itemView.findViewById(R.id.iv_splendid);
            tv_splendid_title = itemView.findViewById(R.id.tv_splendid_title);
            tv_splendid_daytime = itemView.findViewById(R.id.tv_splendid_daytime);
            tv_splendid_length = itemView.findViewById(R.id.tv_splendid_length);
        }
    }
}
