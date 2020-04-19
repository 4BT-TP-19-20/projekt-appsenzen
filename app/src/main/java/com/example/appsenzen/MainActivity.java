package com.example.appsenzen;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sets the created toolbar as the actionbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupTabs();
    }


    private void setupTabs(){
        TabLayout tabLayout = findViewById(R.id.tabs);
        TabItem tabClasses = findViewById(R.id.tab_classes);
        TabItem tabDashboard = findViewById(R.id.tab_dashboard);
        TabItem tabTimetable = findViewById(R.id.tab_timetable);

        //selects the second tab
        tabLayout.selectTab(tabLayout.getTabAt(1));

        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        final ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(pageAdapter);

        //adds listener to change tab selection when swiping between pages
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //changes pages when a tab is clicked
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    //methodes for the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                openSettingsActivity();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void openSettingsActivity(){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
