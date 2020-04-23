package com.example.appsenzen;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;

public class SchoolClassActivity extends AppCompatActivity implements AddStudentDialog.addStudentDialogListener{
    private static final ArrayList<String> existingButtons = new ArrayList<>();
    int counter = 0;
    public String setName = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_school_class);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        if(getIntent().hasExtra("currentClassName")){
            setName = getIntent().getStringExtra("currentClassName");
            Objects.requireNonNull(getSupportActionBar()).setTitle(setName);
        }
        setupFloatingButton();

    }
    public void addButton(final String s) {

        if(!existingButtons.contains(s)) {
            Button button = new Button(this);
            button.setText(s);
            LinearLayout linearLayout = findViewById(R.id.linearlayout);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            linearLayout.addView(button, params);


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Toast.makeText(SchoolClassActivity.this, s, Toast.LENGTH_SHORT).show();

                }
            });
            existingButtons.add(s);

        }
    }
    private void setupFloatingButton(){
        FloatingActionButton buttonAddClass = findViewById(R.id.buttonAddStudent);

        buttonAddClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();

            }
        });
    }

    private void openDialog(){
        Bundle bundle = new Bundle();
        bundle.putString("className", setName);
        AddStudentDialog addStudentDialog = new AddStudentDialog();
        addStudentDialog.setArguments(bundle);
        addStudentDialog.show(getSupportFragmentManager(), "example dialogg");
    }

    @Override
    public void onResume() {
        super.onResume();

        int listSize = SchoolClassHandler.getListSize();                //1

        if(listSize > counter) {                                        //1 > 0
            for (int i = counter; i < listSize; i++) {                  //i = 0; 0<1; 2
                addButton(SchoolClassHandler.getNameByIndex(i));
            }
        }
        counter = listSize;
    }
    public void onPause() {
        super.onPause();
        counter = 0;

    }
    @Override
    public void showToast(String studentName) {
        Toast.makeText(SchoolClassActivity.this,"Added '" +studentName+"' to classes", Toast.LENGTH_SHORT).show();
        addButton(studentName);
    }

}
