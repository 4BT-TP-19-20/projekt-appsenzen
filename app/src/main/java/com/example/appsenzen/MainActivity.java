package com.example.appsenzen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements AddClassDialog.addClassDialogListener {
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        //sets the created toolbar as the actionbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupTabs();
        setupFloatingButton();
        init();
        setupTimetable();
    }

    private void setupTabs() {
        TabLayout tabLayout = findViewById(R.id.tabs);

        final MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), this, tabLayout.getTabCount());

        final ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(mainPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        //selects the second tab
        tabLayout.selectTab(tabLayout.getTabAt(1));

    }

    private void setupFloatingButton() {
        FloatingActionButton buttonAddClass = findViewById(R.id.button_add_class);

        buttonAddClass.setOnClickListener(v -> openDialog());
    }

    private void init() {
        SchoolClassHandler.setActivityContext(this);

        SchoolClassHandler.loadLists();

        if (SchoolClassHandler.getMultiplier() == 0) {
            SchoolClassHandler.setMultiplier(20);
        }
    }

    //TODO replace with file
    private void setupTimetable() {
        SchoolClassHandler.getTimetable().addLesson("1DT", 1, 1);
        SchoolClassHandler.getTimetable().addLesson("4BT", 1, 2);
        SchoolClassHandler.getTimetable().addLesson("1AT", 1, 3);
        SchoolClassHandler.getTimetable().addLesson("3AT", 1, 5);
        SchoolClassHandler.getTimetable().addLesson("4AT", 1, 7);
        SchoolClassHandler.getTimetable().addLesson("5AT", 1, 8);

        SchoolClassHandler.getTimetable().addLesson("3BT", 2, 3);
        SchoolClassHandler.getTimetable().addLesson("2AT", 2, 4);
        SchoolClassHandler.getTimetable().addLesson("3AT", 2, 5);
        SchoolClassHandler.getTimetable().addLesson("5BT", 2, 6);

        SchoolClassHandler.getTimetable().addLesson("4AT", 3, 2);
        SchoolClassHandler.getTimetable().addLesson("5AT", 3, 5);
        SchoolClassHandler.getTimetable().addLesson("1AT", 3, 7);
        SchoolClassHandler.getTimetable().addLesson("4BT", 3, 8);

        SchoolClassHandler.getTimetable().addLesson("5BT", 4, 4);
        SchoolClassHandler.getTimetable().addLesson("1DT", 4, 6);

        SchoolClassHandler.getTimetable().addLesson("3BT", 5, 3);
        SchoolClassHandler.getTimetable().addLesson("2AT", 5, 4);

        //for testing:
        //SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        //try{
        //    SchoolClassHandler.getTimetable().addLesson("4BT", 1, sdf.parse("23:00"), sdf.parse("23:59"));
        //}catch (ParseException ignored){}

    }

    //methodes for the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                openSettingsActivity();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showToast(String classname) {
        Toast.makeText(MainActivity.this, "Added '" + classname + "' to classes", Toast.LENGTH_SHORT).show();
    }

    private void openSettingsActivity() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    private void openDialog() {
        AddClassDialog addClassDialog = new AddClassDialog();
        addClassDialog.show(getSupportFragmentManager(), "example dialog");
    }

    public static Context getContext(){
        return context;
    }

    public void refresh() {
        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);
    }

}
