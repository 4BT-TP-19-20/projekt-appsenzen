package com.example.appsenzen;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements AddClassDialog.addClassDialogListener{
    TextView addClassName;
    @Override
    public void showToast(String classname) {
        Toast.makeText(MainActivity.this,"Added '" +classname+"' to classes", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sets the created toolbar as the actionbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupTabs();
        setupFloatingButton();
        init();
    }

    private void init(){
        SchoolClassHandler.setActivityContext(this);

        SchoolClassHandler.loadLists();

        if(SchoolClassHandler.getMultiplier() == 0){
            SchoolClassHandler.setMultiplier(20);
        }
    }

    private void setupTabs(){
        TabLayout tabLayout = findViewById(R.id.tabs);
        TabItem tabClasses = findViewById(R.id.tab_classes);
        TabItem tabDashboard = findViewById(R.id.tab_dashboard);
        TabItem tabTimetable = findViewById(R.id.tab_timetable);

        final MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), this, tabLayout.getTabCount());

        final ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(mainPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        //delete if this causes problems
        //possible keeps all 3 tabs loaded
        //viewPager.setOffscreenPageLimit(2);

        //selects the second tab
        tabLayout.selectTab(tabLayout.getTabAt(1));

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
                //openAddClassActivity();
                openDialog();
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

    private void openDialog(){
        AddClassDialog addClassDialog = new AddClassDialog();
        addClassDialog.show(getSupportFragmentManager(), "example dialog");
    }



}
