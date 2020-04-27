package com.example.appsenzen;

import android.os.Bundle;
import android.widget.Toast;
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

    String studentName;

    public StudentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle = this.getArguments();
        if(bundle != null){
            studentName = bundle.getString("studentName");
        }
        Toast.makeText(getContext(), "Received" + studentName, Toast.LENGTH_SHORT).show();

        return inflater.inflate(R.layout.fragment_student, container, false);
    }
}
