package com.example.mikeacre.lincolnparktour;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by mikeacre on 11/12/2016.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    private String tabTitles[] = new String[] { "Night Life", "Restaurants","Activities","Sights"};

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new NightLifeFragment();
        else if(position==1)
            return new PlacesToEatFragment();
        else if(position==2)
            return new ActivityFrag();
        else
            return new SightsFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

}
