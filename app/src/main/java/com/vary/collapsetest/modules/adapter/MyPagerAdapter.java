package com.vary.collapsetest.modules.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.vary.collapsetest.modules.fragment.MyFragment;

/**
 * Created by Administrator on 2017-04-19.
 */

public class MyPagerAdapter extends FragmentPagerAdapter{

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        MyFragment myFragment = MyFragment.getInstance(position);
        return myFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
