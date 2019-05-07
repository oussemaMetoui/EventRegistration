package com.oussema.eventregistration;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.oussema.eventregistration.fragment.AttendeesListFragment;
import com.oussema.eventregistration.fragment.CameraScreenFragment;

public class MainActivity extends AppCompatActivity {

    final static String TAG = MainActivity.class.getSimpleName();
    static FragmentPagerAdapter viewPagerAdapter;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),this);
        viewPagerAdapter.notifyDataSetChanged();
        pager.setAdapter(viewPagerAdapter);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                Log.d(TAG, "onPageScrolled + currentItem: "+pager.getCurrentItem());

            }

            @Override
            public void onPageSelected(int i) {
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                Log.d(TAG, "onPageScrollStateChanged + currentItem: "+pager.getCurrentItem());
            }
        });
    }

}