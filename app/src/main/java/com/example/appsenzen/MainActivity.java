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
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
        setupFloatingButton();
    }

    private void setupTabs(){
        TabLayout tabLayout = findViewById(R.id.tabs);
        TabItem tabClasses = findViewById(R.id.tab_classes);
        TabItem tabDashboard = findViewById(R.id.tab_dashboard);
        TabItem tabTimetable = findViewById(R.id.tab_timetable);

        //selects the second tab
        tabLayout.selectTab(tabLayout.getTabAt(1));

        final MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), this, tabLayout.getTabCount());

        final ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(mainPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);


        //use this if you want to implemet a color changing toolbar
        /*
        //adds listener to change tab selection when swiping between pages
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //changes pages when a tab is clicked
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                //pageAdapter.getItem(tab.getPosition()).onResume();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //pageAdapter.getItem(tab.getPosition()).onPause();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

         */

    }

    private void setupFloatingButton(){
        FloatingActionButton buttonAddClass = findViewById(R.id.buttonAddClass);

        buttonAddClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddClassActivity();
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

    private void openAddClassActivity(){
        Intent intent = new Intent(this, AddClassActivity.class);
        startActivity(intent);
    }



}
