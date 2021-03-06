package com.vary.collapsetest.modules.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.vary.collapsetest.modules.fragment.LeftFragment;
import com.vary.collapsetest.modules.fragment.MyFragment;
import com.vary.collapsetest.modules.fragment.RightFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-04-19.
 */

public class MyPagerAdapter extends FragmentPagerAdapter{

    List<Fragment> fragments = new ArrayList<Fragment>();

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments.add(new RightFragment());
        fragments.add(new MyFragment());
        fragments.add(new LeftFragment());
    }

    @Override
    public Fragment getItem(int position) {
        MyFragment myFragment = MyFragment.getInstance(position);
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
