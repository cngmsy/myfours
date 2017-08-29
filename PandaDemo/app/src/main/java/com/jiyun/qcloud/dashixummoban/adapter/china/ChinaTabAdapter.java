package com.jiyun.qcloud.dashixummoban.adapter.china;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by w1565 on 2017/7/19.
 */

public class ChinaTabAdapter extends FragmentStatePagerAdapter {
    private List<String> list;
    private List<Fragment> fragments;
    public ChinaTabAdapter(FragmentManager fm, List<Fragment> fragments,List<String> list) {
        super(fm);
        this.list=list;
        this.fragments=fragments;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }


}
