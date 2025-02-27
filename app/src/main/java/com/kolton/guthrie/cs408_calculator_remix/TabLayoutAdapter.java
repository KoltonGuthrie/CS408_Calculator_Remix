package com.kolton.guthrie.cs408_calculator_remix;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabLayoutAdapter extends FragmentStateAdapter {

    public static final int NUM_TABS = 3;

    public TabLayoutAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new TemperatureConverter();
            case 1:
                return new TipCalculator();
            case 2:
                return new DistanceCalculator();
            default:
                return new TemperatureConverter();
        }
    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }
}