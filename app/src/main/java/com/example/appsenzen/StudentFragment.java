package com.example.appsenzen;

import android.os.Bundle;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudentFragment extends Fragment {

    public StudentFragment() {
        // Required empty public constructor
    }
    String studentName;

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
