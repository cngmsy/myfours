package com.jiyun.qcloud.dashixummoban.main;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import butterknife.BindView;
import butterknife.OnClick;
import util.UpdateAppUtils;

public class WelComeActivity extends BaseActivity {

    @BindView(R.id.rollpager)
    RollPagerView rollpager;
    @BindView(R.id.bt_jump)
    Button btJump;

    @Override
    protected void initData() {
        //设置透明度
        rollpager.setAnimationDurtion(500);
        //设置适配器
        rollpager.setAdapter(new TestNormalAdapter());
        rollpager.setHintView(new ColorPointHintView(this, Color.YELLOW, Color.WHITE));
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wel_come;
    }



    @OnClick(R.id.bt_jump)
    public void onViewClicked() {
        Intent intent = new Intent(WelComeActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }


    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.drawable.panda1,
                R.drawable.panda2,
                R.drawable.panda3,
        };

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getCount() {
            return imgs.length;
        }
    }

}
