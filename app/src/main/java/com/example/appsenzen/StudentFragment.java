package com.example.appsenzen;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudentFragment extends Fragment {

    public StudentFragment() {
        // Required empty public constructor
    }
    String studentName;
    String studentClass;
    TextView textViewStudent;
    TextView textViewClass;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student, container, false);
        Toolbar toolbar = view.findViewById(R.id.studentToolBar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        // Inflate the layout for this fragment
        textViewStudent = view.findViewById(R.id.editTextStudentName);
        textViewClass = view.findViewById(R.id.editTextClassName);
        Bundle bundle = this.getArguments();
        if(bundle != null){
            studentName = bundle.getString("studentName");
            studentClass = bundle.getString("studentClass");
            textViewClass.setText(studentClass);
            textViewStudent.setText(studentName);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(studentClass + " "+studentName);
        }
        //Toast.makeText(getContext(), "Received" + studentName, Toast.LENGTH_SHORT).show();
        return view;
    }
}
