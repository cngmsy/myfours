package com.jiyun.qcloud.dashixummoban.ui.live.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by w1565 on 2017/7/20.
 */

public class LiveAdapter extends FragmentPagerAdapter{
    private String[] strings={"多视角直播","边看边聊"};
    private ArrayList<Fragment> list;

    public LiveAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list=list;

    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return strings.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings[position];
    }
}
