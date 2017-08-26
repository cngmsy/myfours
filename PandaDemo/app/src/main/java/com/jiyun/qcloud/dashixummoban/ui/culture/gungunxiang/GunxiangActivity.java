package com.jiyun.qcloud.dashixummoban.ui.culture.gungunxiang;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class GunxiangActivity extends BaseActivity {


    @BindView(R.id.jiecaovideo)
    JCVideoPlayer jiecaovideo;
    @BindView(R.id.img_littlejian)
    ImageView imgLittlejian;
    @BindView(R.id.lanmu)
    TextView lanmu;
    @BindView(R.id.refd)
    RelativeLayout refd;
    int co = 1;
    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        imgLittlejian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (co == 1) {
                    refd.setVisibility(View.VISIBLE);
                    imgLittlejian.setImageResource(R.drawable.com_facebook_tooltip_blue_bottomnub);
                    co = 0;
                } else if (co == 0) {
                    refd.setVisibility(View.GONE);
                    imgLittlejian.setImageResource(R.drawable.com_facebook_tooltip_blue_topnub);
                    co = 1;
                }

            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_gunxiang;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
