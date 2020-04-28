package com.example.appsenzen;

import android.content.Intent;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

public class StudentActivity extends AppCompatActivity {

    private String studentName;
    private String studentClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String message = intent.getStringExtra(SchoolClassActivity.EXTRA_MESSAGE);

        String[] infos = message.split(";");
        studentName=infos[0];
        studentClass=infos[1];

        TextView textViewName = findViewById(R.id.textViewName);
        textViewName.setText(studentName);
        TextView textViewClass = findViewById(R.id.textViewClass);
        textViewClass.setText(studentClass);

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
}
