package com.example.appsenzen;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;
import java.util.Date;


public class DashboardFragment extends Fragment {
    View view;
    Date currentTime;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        TextView currentDateTime = new TextView(getActivity());

        currentTime = Calendar.getInstance().getTime();

        String timeString = currentTime.toString();
        String[] splitString = timeString.split(" ");
        timeString = splitString[0] + " " + splitString[1] + " " + splitString[2] + " " + splitString[5] + " " + splitString[3];

        currentDateTime.setText(timeString);
        currentDateTime.setGravity(Gravity.CENTER);

        LinearLayout linearLayout = view.findViewById(R.id.linearlayout);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        currentDateTime.setLayoutParams(params);

        linearLayout.addView(currentDateTime, params);

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
            }
        });
    }
}
