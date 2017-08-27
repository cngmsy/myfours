package com.jiyun.qcloud.dashixummoban.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.entity.china.ChinaFragmentBean;

import java.util.List;

/**
 * Created by liuwangping on 2017/8/24.
 */

public class ChinaFragAdapter extends BaseAdapter<ChinaFragmentBean.LiveBean>{
    private int i = 1;

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

        ImageView img=holder.itemView.findViewById(R.id.look_img);
        Glide.with(context).load(liveBean.getImage()).into(img);
        String url = "http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd" + liveBean.getId() + "&client=androidapp";

    }
}
