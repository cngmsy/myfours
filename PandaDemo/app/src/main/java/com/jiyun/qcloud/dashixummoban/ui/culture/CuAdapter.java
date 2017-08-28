package com.jiyun.qcloud.dashixummoban.ui.culture;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.entity.gungun.Gun;

import java.util.List;

/**
 * Created by Administrator on 2017/8/24.
 */
public class CuAdapter extends RecyclerView.Adapter<CuAdapter.ViewHolder>{
    Context context;
    List<Gun.ListBean> mList;
    private OnItemClickLinear onItemClickLinear;
    public void setOnItemClickLinear(OnItemClickLinear onItemClickLinear) {
        this.onItemClickLinear = onItemClickLinear;
    }
    public interface OnItemClickLinear {
        public void onItemvlick(int position);
    }
    public CuAdapter(Context context, List<Gun.ListBean> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gungun_item,parent,false);
            ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
         Gun.ListBean gun = mList.get(position);
        holder.item_title.setText(gun.getTitle());
        holder.item_contex.setText(gun.getBrief());
        holder.item_time.setText(gun.getVideoLength());
        Glide.with(holder.item_image.getContext()).load(gun.getImage()).into(holder.item_image);
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
        return mList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
            TextView item_title,item_contex,item_time;
            ImageView item_image;

        public ViewHolder(View itemView) {
            super(itemView);
            item_title = itemView.findViewById(R.id.gungun_title);
            item_contex = itemView.findViewById(R.id.gungun_context);
            item_time = itemView.findViewById(R.id.gungun_itemtime);
            item_image = itemView.findViewById(R.id.gungun_image);
        }
    }
}
