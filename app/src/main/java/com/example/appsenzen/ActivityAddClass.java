package com.example.appsenzen;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityAddClass extends AppCompatActivity implements View.OnClickListener{
    String className;
    Button button;
    EditText inputClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);

        inputClass = findViewById(R.id.editText);
        button = findViewById(R.id.buttonAddClass);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        className = inputClass.getText().toString();
    }
}
