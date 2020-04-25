package com.example.appsenzen;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.Objects;


public class ClassesFragment extends Fragment {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    private static final ArrayList<String> existingButtons = new ArrayList<>();
    private View view;
    int counter = 0;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_classes, container, false);
        
/*
        for(int i = 0; i <= 20; ++i){
            addButton("Button: " + i);
        }

 */

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        counter = 0;

    }

    @Override
    public void onDestroyView() {           //DO NOT TOUCH !!!!
        super.onDestroyView();              //View gets destroyed upon entering "Settings" (maybe)
        existingButtons.clear();
    }



    public void addButton(final String s) {

        if(!existingButtons.contains(s)) {
            Button button = new Button(getContext());
            button.setText(s);
            LinearLayout linearLayout = view.findViewById(R.id.linearlayout);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            linearLayout.addView(button, params);


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), SchoolClassActivity.class);
                    intent.putExtra("currentClassName", s);
                    Objects.requireNonNull(getActivity()).startActivity(intent);

                }
            });
            existingButtons.add(s);


        }
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


}
