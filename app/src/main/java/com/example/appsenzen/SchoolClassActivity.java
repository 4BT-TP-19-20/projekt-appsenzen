package com.example.appsenzen;

import android.content.Intent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;

public class SchoolClassActivity extends AppCompatActivity implements AddStudentDialog.addStudentDialogListener {
    private static final ArrayList<String> existingButtons = new ArrayList<>();
    private static final ArrayList<String> studentsToAdd = new ArrayList<>();
    public static final String EXTRA_MESSAGE = "com.example.appsenzen.MESSAGE";
    int counter = 0;
    public String setName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_school_class);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        if (getIntent().hasExtra("currentClassName")) {
            setName = getIntent().getStringExtra("currentClassName");
            Objects.requireNonNull(getSupportActionBar()).setTitle(setName);
        }

        setupFloatingButton();

        addStudentButton();
    }

    public void addButton(final String s) {

        Button button = new Button(this);
        button.setText(s);
        LinearLayout linearLayout = findViewById(R.id.lineareslayout);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        linearLayout.addView(button, params);


        button.setOnClickListener(v -> {
            //Toast.makeText(SchoolClassActivity.this, s, Toast.LENGTH_SHORT).show();
            openStudent(s);
        });
        existingButtons.add(s);
    }

    private void setupFloatingButton() {
        FloatingActionButton buttonAddClass = findViewById(R.id.button_add_student);

        buttonAddClass.setOnClickListener(v -> openDialog());
    }

    private void openDialog() {
        Bundle bundle = new Bundle();
        bundle.putString("className", setName);
        AddStudentDialog addStudentDialog = new AddStudentDialog();
        addStudentDialog.setArguments(bundle);
        addStudentDialog.show(getSupportFragmentManager(), "example dialog");
    }

    private void openStudent(String s) {
        Intent intent = new Intent(this, StudentActivity.class);
        String message = s + ";" + setName;     //passes name and class to StudentActivity
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void addStudentButton() {                //Gets called when clicking on a "Class" button
        int listSize = SchoolClassHandler.getSchoolClass(setName).getStudentCount();

        if (listSize > counter) {
            for (int i = counter; i < listSize; i++) {
                addButton(SchoolClassHandler.getSchoolClass(setName).getStudent(i).getName());
            }
        }

        counter = listSize;
    }

    @Override
    public void onStop() {
        super.onPause();
        //counter = 0;

    }

    @Override
    protected void onPause() {
        super.onPause();
        //counter = 0;
    }

    public void showToast(String studentName) {
        Toast.makeText(SchoolClassActivity.this, "Added '" + studentName + "' to classes", Toast.LENGTH_SHORT).show();
        addButton(studentName);
        studentsToAdd.add(studentName);
        addStudent(studentName);
    }

    private void addStudent(String name) {
        SchoolClassHandler.getSchoolClass(setName).addStudent(name);
    }
}
