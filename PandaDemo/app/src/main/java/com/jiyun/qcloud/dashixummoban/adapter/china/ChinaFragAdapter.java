package com.jiyun.qcloud.dashixummoban.adapter.china;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.entity.china.ChinaFragmentBean;
import com.jiyun.qcloud.dashixummoban.entity.china.LiveChinaLiveBean;

import java.io.IOException;
import java.util.List;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by w1565 on 2017/7/19.
 */

public class ChinaFragAdapter extends RecyclerView.Adapter<ChinaFragAdapter.MyViewHolder> {

    private ImageView look_img;
    private TextView look_name;
    private ImageView look_come;
    private TextView look_content;
    private LiveChinaLiveBean bean;

    private List<ChinaFragmentBean.LiveBean> list;
    private Context context;

    public ChinaFragAdapter(Context context,List<ChinaFragmentBean.LiveBean> list) {
        this.list = list;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_livechina_fragment, null);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT
        );
        view.setLayoutParams(params);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    private int i = 1;

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.look_content.setText(list.get(position).getBrief());
        holder.look_name.setText("[正在直播]" + list.get(position).getTitle());

        Glide.with(holder.look_img.getContext())
                .load(list.get(position).getImage())
//                .placeholder(R.drawable._no_img)
//                .error(R.drawable._no_img)
                .into(holder.look_img);

        String u = "http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd" + list.get(position).getId() + "&client=androidapp";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(u)
                .build();

        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Gson gson = new Gson();
                bean = gson.fromJson(str,LiveChinaLiveBean.class);

            }
        });


        holder.look_come.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (i == 1) {
                    holder.look_come.setImageResource(R.drawable.com_facebook_tooltip_blue_topnub);
                    holder.look_content.setVisibility(View.VISIBLE);
                    i = 0;
                } else {
                    holder.look_come.setImageResource(R.drawable.com_facebook_tooltip_blue_bottomnub);
                    holder.look_content.setVisibility(View.GONE);
                    i = 1;
                }


            }
        });


        holder.look_img.setOnClickListener(new View.OnClickListener() {

            private MediaController controller;

            @Override
            public void onClick(View v) {
                holder.bofang.setVisibility(View.GONE);
                holder.look_img.setVisibility(View.GONE);
                holder.look_video.setVisibility(View.VISIBLE);
                Toast.makeText(context, "播放", Toast.LENGTH_SHORT).show();
                controller = new MediaController(context);//实例化控制器
                controller.show();//控制器显示5s后自动隐藏
                holder.look_video.setMediaController(controller);//绑定控制器
                holder.look_video.setVideoQuality(MediaPlayer.VIDEOQUALITY_LOW);//设置播放画质 高画质
                holder.look_video.setVideoLayout(VideoView.VIDEO_LAYOUT_STRETCH, 0);
                holder.look_video.requestFocus();//取得焦点
                holder.look_video.setVideoPath(bean.getHls_url().getHls2());//设置播放地址
            }
        });
        holder.look_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.look_video.stopPlayback();
                holder.look_img.setVisibility(View.VISIBLE);
                holder.look_video.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView look_name, look_content;
        VideoView look_video;
        ImageView look_come, look_img,bofang;

        public MyViewHolder(View itemView) {
            super(itemView);
            look_content = (TextView) itemView.findViewById(R.id.look_content);
            look_name = (TextView) itemView.findViewById(R.id.look_name);
            look_img = (ImageView) itemView.findViewById(R.id.look_img);
            look_come = (ImageView) itemView.findViewById(R.id.look_come);
            look_video = (VideoView) itemView.findViewById(R.id.look_video);
            bofang= itemView.findViewById(R.id.bofang);
        }
    }

}
