package com.example.appsenzen;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class StudentActivity extends AppCompatActivity {

    private String studentName;
    private String studentClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

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
}
