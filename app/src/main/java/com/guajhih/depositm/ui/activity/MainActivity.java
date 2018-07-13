package com.guajhih.depositm.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.guajhih.depositm.R;
import com.guajhih.depositm.databinding.ActivityMainBinding;
import com.guajhih.depositm.ui.fragment.HomeFragment;
import com.guajhih.depositm.ui.fragment.MoneyBoxFragment;
import com.guajhih.depositm.ui.fragment.NotifyFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final int TAB_MONEY_BOX = 0;
    public static final int TAB_HOME = 1;
    public static final int TAB_NOTIFY = 2;

    private ActivityMainBinding binding;
    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        toolbar = binding.includeToolbar.myToolbar;
        setSupportActionBar(toolbar);
        setBottomNavigationView();
        setViewPager();
    }

    private void setViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(MoneyBoxFragment.newInstance("", ""));
        adapter.addFragment(HomeFragment.newInstance("", ""));
        adapter.addFragment(NotifyFragment.newInstance("", ""));
        binding.viewpager.setAdapter(adapter);
        binding.viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        binding.viewpager.setCurrentItem(TAB_HOME);
    }

    private void setBottomNavigationView() {
        bottomNavigationView = binding.includeBottomNavigationView.bottomNavigation;
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.d(TAG, item.getItemId() + " item was selected-------------------");
                switch (item.getItemId()) {
                    case R.id.action_money_box:
                        binding.viewpager.setCurrentItem(TAB_MONEY_BOX);
                        break;
                    case R.id.action_home:
                        binding.viewpager.setCurrentItem(TAB_HOME);
                        break;
                    case R.id.action_notify:
                        binding.viewpager.setCurrentItem(TAB_NOTIFY);
                        break;
                }
                return true;
            }
        });
    }


    public class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();

        ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }

    }
}


