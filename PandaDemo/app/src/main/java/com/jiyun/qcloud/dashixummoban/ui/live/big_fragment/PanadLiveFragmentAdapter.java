package com.jiyun.qcloud.dashixummoban.ui.live.big_fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;



public class PanadLiveFragmentAdapter extends FragmentStatePagerAdapter{

    private List<Fragment> list;
    private List<String> strList;

    public PanadLiveFragmentAdapter(FragmentManager fm, List<Fragment> list, List<String> strings) {
        super(fm);
        this.list = list;
        this.strList = strings;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strList.get(position);
    }
}

