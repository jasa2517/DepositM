package com.guajhih.depositm.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.guajhih.depositm.R;
import com.guajhih.depositm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

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
    }

    private void setBottomNavigationView() {
        bottomNavigationView = binding.includeBottomNavigationView.bottomNavigation;
        bottomNavigationView.setSelectedItemId(R.id.action_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.d(TAG, item.getItemId() + " item was selected-------------------");
                // you can return false to cancel select
                int id = 0;
                switch (item.getItemId()) {
                    case R.id.action_favorites:
                        id = 0;
                        break;
                    case R.id.action_home:
                        id = 1;
                        break;
                    case R.id.action_notify:
                        id = 2;
                        break;
                }
//                vp.setCurrentItem(id, false);// 改变的 ViewPager 的当前页面
                return true;
            }
        });
    }
}
