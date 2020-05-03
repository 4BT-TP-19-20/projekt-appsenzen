package com.example.appsenzen;

import android.content.Intent;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

public class StudentActivity extends AppCompatActivity {

    private Student currentStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String message = intent.getStringExtra(SchoolClassActivity.EXTRA_MESSAGE);

        assert message != null;
        setViews(message);

        Button missingButton = findViewById(R.id.missingButton);
        missingButton.setOnClickListener(v -> {
            currentStudent.addPushups(SchoolClassHandler.getMultiplier());
            update();
        });

        Button pushupsdoneButton = findViewById(R.id.pushupsdoneButton);
        pushupsdoneButton.setOnClickListener(v -> {
            currentStudent.clearPushups();
            updatePushups();
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setViews(String message){
        String[] infos = message.split(";");
        String studentName = infos[0];
        String studentClass = infos[1];

        TextView textViewName = findViewById(R.id.text_name);
        textViewName.setText(studentName);
        TextView textViewClass = findViewById(R.id.text_class);
        textViewClass.setText(studentClass);

        currentStudent = SchoolClassHandler.getSchoolClass(studentClass).getStudent(studentName);

        updatePushups();

        updateLog();
    }

    private void updateLog(){
        TextView textViewLog = findViewById(R.id.textViewLog);
        textViewLog.setMovementMethod(new ScrollingMovementMethod());
        if(currentStudent.getLog() == null){
            textViewLog.setText("Never Missed an Hour!");
        } else {
            textViewLog.setText(currentStudent.getLog());
        }
    }

    private void updatePushups(){
        TextView textViewPushups = findViewById(R.id.textViewPushups);
        textViewPushups.setText(String.valueOf(currentStudent.getRemainingPushups()));
    }

    private void update(){
        currentStudent.logMissing(currentStudent.getName());
        updateLog();
        updatePushups();
    }
}
