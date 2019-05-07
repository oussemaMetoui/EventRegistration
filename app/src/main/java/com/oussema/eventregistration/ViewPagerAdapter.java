package com.oussema.eventregistration;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.oussema.eventregistration.fragment.AttendeesListFragment;
import com.oussema.eventregistration.fragment.CameraScreenFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Context context;

    ViewPagerAdapter(FragmentManager fm,Context context) {
        super(fm);
        this.context=context;
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment =null;
        switch (i) {
            case 0: // Fragment # 0 - show camera
                fragment = Fragment.instantiate(context, CameraScreenFragment.class.getName());
            case 1: // Fragment # 0 - show registered list
                fragment = Fragment.instantiate(context, AttendeesListFragment.class.getName());
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}