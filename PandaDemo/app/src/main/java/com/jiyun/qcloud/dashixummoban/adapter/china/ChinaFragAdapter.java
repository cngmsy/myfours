package com.jiyun.qcloud.dashixummoban.adapter.china;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;
import com.dl7.player.media.IjkPlayerView;
import com.google.gson.Gson;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.entity.china.ChinaFragmentBean;
import com.jiyun.qcloud.dashixummoban.entity.china.LiveChinaLiveBean;
import com.jiyun.qcloud.dashixummoban.view.MyMediaController;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by w1565 on 2017/7/19.
 */

public class ChinaFragAdapter extends BaseAdapter<ChinaFragmentBean.LiveBean> {
    private int i = 1;
    private LiveChinaLiveBean bean;

    private IjkPlayerView player;


    public ChinaFragAdapter(Context context,List<ChinaFragmentBean.LiveBean> datas) {
        super(context, R.layout.item_livechina_fragment, datas);
    }

    @Override
    public void convert(final ViewHolder holder, ChinaFragmentBean.LiveBean liveBean) {
        holder.setText(R.id.look_name,"[正在直播]"+liveBean.getTitle());
        holder.setText(R.id.look_content,liveBean.getBrief());
        holder.setOnclickListener(R.id.look_come, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i==1) {
                    holder.setViewVisiable(R.id.look_content,View.VISIBLE);
                    holder.setImageResource(R.id.look_come,R.drawable.com_facebook_tooltip_blue_topnub);
                    i=0;
                }else {
                    holder.setViewVisiable(R.id.look_content,View.GONE);
                    holder.setImageResource(R.id.look_come,R.drawable.com_facebook_tooltip_blue_bottomnub);
                    i=1;
                }
            }
        });

        final ImageView img=holder.itemView.findViewById(R.id.look_img);
        Glide.with(context).load(liveBean.getImage()).into(img);
        String url = "http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd" + liveBean.getId() + "&client=androidapp";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        final Call call = okHttpClient.newCall(request);

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


        holder.setOnclickListener(R.id.bofang, new View.OnClickListener() {
            private MyMediaController controller;
            @Override
            public void onClick(View view) {
                holder.setViewVisiable(R.id.bofang,View.GONE);
                holder.setViewVisiable(R.id.jcvideoplayer,View.VISIBLE);
                img.setVisibility(View.GONE);
                //视频播放
                player = holder.itemView.findViewById(R.id.jcvideoplayer);

                player.init().setVideoPath(bean.getHls_url().getHls2()).start();



        holder.setOnclickListener(R.id.look_content, new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                player.stop();
                img.setVisibility(View.VISIBLE);
                player.setVisibility(View.GONE);


            }
        });

            }
        });

    }

}
