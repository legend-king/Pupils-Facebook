package com.example.pupilsfacebook.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.pupilsfacebook.Fragments.AddFragment;
import com.example.pupilsfacebook.Fragments.HomeFragment;
import com.example.pupilsfacebook.Fragments.NotificationFragment;
import com.example.pupilsfacebook.Fragments.ProfileFragment;
import com.example.pupilsfacebook.Fragments.SearchFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 1:
                return new NotificationFragment();
            case 2:
                return new AddFragment();
            case 3:
                return new SearchFragment();
            case 4:
                return new ProfileFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
