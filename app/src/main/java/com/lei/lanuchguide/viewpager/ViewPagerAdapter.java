package com.lei.lanuchguide.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanle on 2018/2/25.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmetns;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragmetns = fragments;

    }
    @Override
    public int getCount() {
        Log.i("tag","adapter getCount" + fragmetns.size());
        return fragmetns.size();
    }

    @Override
    public Fragment getItem(int position) {
        Log.i("tag","adapter getItem" + position);
        return fragmetns.get(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}
