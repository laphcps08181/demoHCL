package com.example.mrwhite.demo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabchiFragment extends Fragment {
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 2 ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /* gan layout va anh xa */
        View x=inflater.inflate(R.layout.tab_layout,null);
        tabLayout=(TabLayout)x.findViewById(R.id.tabs);
        viewPager=(ViewPager)x.findViewById(R.id.viewpager);

        /* Set adapter cho viewpager  */
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        /* can cai nay chu khong se bi loi */
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        return x;
    }
    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position)
        {
            switch (position){
                case 0 : return new KhoanchiFragment();
                case 1 : return new LoaichiFragment();

            }
            return null;
        }
        @Override
        public int getCount() {
            return int_items;
        }
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "Khoản chi";
                case 1 :
                    return "Loại chi";

            }
            return null;
        }
    }



}
