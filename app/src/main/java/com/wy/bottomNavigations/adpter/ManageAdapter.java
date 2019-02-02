package com.wy.bottomNavigations.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;


/**
 * Created by songjian on 2016/11/3.
 */
public class ManageAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> list = new ArrayList<>();

    public ManageAdapter(FragmentManager fragmentManager, ArrayList<Fragment> fragments) {
        super(fragmentManager);
        list = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

}
