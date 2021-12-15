package com.example.pupilsfacebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Toast;

import com.example.pupilsfacebook.Adapters.ViewPagerAdapter;
import com.example.pupilsfacebook.Fragments.AddFragment;
import com.example.pupilsfacebook.Fragments.HomeFragment;
import com.example.pupilsfacebook.Fragments.NotificationFragment;
import com.example.pupilsfacebook.Fragments.ProfileFragment;
import com.example.pupilsfacebook.Fragments.SearchFragment;
import com.example.pupilsfacebook.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.iammert.library.readablebottombar.ReadableBottomBar;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        binding.viewPager.setAdapter(adapter);
        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        if (!user.isEmailVerified()){
            Intent intent = new Intent(getApplicationContext(), VerificationActivity.class);
            startActivity(intent);
            finish();
        }

        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                    binding.readableBottomBar.selectItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        binding.readableBottomBar.setOnItemSelectListener(new ReadableBottomBar.ItemSelectListener() {
            @Override
            public void onItemSelected(int i) {
                binding.viewPager.setCurrentItem(i);
            }
        });
    }
}