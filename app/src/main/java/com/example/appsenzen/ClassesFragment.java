package com.example.appsenzen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ClassesFragment extends Fragment {
    private View view;
    static int counter = 0;
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
    }

    public void addButton(final String s) {
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
                startActivity(intent);
            }
        });

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
