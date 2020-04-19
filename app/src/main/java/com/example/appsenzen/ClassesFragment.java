package com.example.appsenzen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;


public class ClassesFragment extends Fragment {
    public Button buttonAddClass;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_classes, container, false);
        Button buttonAddClass = (Button) view.findViewById(R.id.buttonAddClass);
        buttonAddClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ActivityAddClass.class);
                startActivity(intent);
            }
        });
        return view;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
