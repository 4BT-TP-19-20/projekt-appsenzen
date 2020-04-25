package com.example.appsenzen;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MainPagerAdapter extends FragmentStatePagerAdapter {
    private final int numOfTabs;
    private final Context context;

    public MainPagerAdapter(@NonNull FragmentManager fm, Context context, int numOfTabs) {
        super(fm);
        this.context = context;
        this.numOfTabs = numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ClassesFragment();
            case 1:
                return new DashboardFragment();
            case 2:
                return new TimetableFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:

                return context.getResources().getString(R.string.tab_classes);
            case 1:
                return context.getResources().getString(R.string.tab_dashboard);
            case 2:
                return context.getResources().getString(R.string.tab_timetable);
            default:
                return null;
        }
    }

}
