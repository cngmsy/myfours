package com.jiyun.qcloud.dashixummoban.ui.live.splendid;

import android.content.Context;
import android.content.Intent;
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
import com.jiyun.qcloud.dashixummoban.ui.live.detail_video.PandaVideoActivity;

import java.util.List;

/**
 * Created by my301s on 2017/8/25.
 */

public class SplendAdapter extends RecyclerView.Adapter<SplendAdapter.SplendViewHolder> {
    private Context context;
    private List<SplendBean.VideoBean> list;
    private SplendViewHolder viewHolder;

    public SplendAdapter(Context context, List<SplendBean.VideoBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public SplendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==0){
            View view = LayoutInflater.from(context).inflate(R.layout.activity_splendid_item, null);
            viewHolder = new SplendViewHolder(view);

        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SplendViewHolder holder, final int position) {
        holder.tv_splendid_daytime.setText(list.get(position).getPtime());
        holder.tv_splendid_length.setText(list.get(position).getLen());
        holder.tv_splendid_title.setText(list.get(position).getT());
        Glide.with(context).load(list.get(position).getImg()).into(holder.iv_splendid);

        holder.rl_splendid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PandaVideoActivity.class);
                intent.putExtra("video_url","http://115.182.9.189/api/getVideoInfoForCBox.do?pid="+list.get(position).getVid());
                context.startActivity(intent);
            }
        });
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
        private final RelativeLayout rl_splendid;

        public SplendViewHolder(View itemView) {
            super(itemView);
            rl_splendid = itemView.findViewById(R.id.rl_splendid);
            iv_splendid = itemView.findViewById(R.id.iv_splendid);
            tv_splendid_title = itemView.findViewById(R.id.tv_splendid_title);
            tv_splendid_daytime = itemView.findViewById(R.id.tv_splendid_daytime);
            tv_splendid_length = itemView.findViewById(R.id.tv_splendid_length);
        }
    }
}
