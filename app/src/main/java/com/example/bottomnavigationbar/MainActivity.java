package com.example.bottomnavigationbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setBackground(null);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.explore:
                    selectedFragment = new ExploreFragment();
                    break;
                case R.id.create:
                    selectedFragment = new CreateFragment();
                    break;
                case R.id.subscriptions:
                    selectedFragment = new SubscriptionsFragment();
                    break;
                case R.id.library:
                    selectedFragment = new LibraryFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        });

    }
}