package com.example.appsenzen;

import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static android.os.Looper.getMainLooper;


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

        //Create Live Clock on Dashboard
        liveTime();

        //for testing:
        //addStudents();

        return view;
    }



    @Override
    public void onPause() {
        super.onPause();
    }

    private void addStudents(){
        String className = SchoolClassHandler.getTimetable().getClassName(1, new Date());

        addButton(className);
    }

    private void addButton(final String s) {
        Button button = new Button(getContext());
        button.setText(s);
        LinearLayout linearLayout = view.findViewById(R.id.linearlayout);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        linearLayout.addView(button, params);


        button.setOnClickListener(v -> Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show());
    }

    private void liveTime(){
        TextView currentDateTime = new TextView(getActivity());     //TextView for displaying the live date and time

        //Thread for updating the time every second according to the devices time
        final Handler liveTimeHandler = new Handler(getMainLooper());
        liveTimeHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                currentDateTime.setText(new SimpleDateFormat("HH:mm:ss EEE d MMM yyyy", Locale.US).format(new Date()));
                liveTimeHandler.postDelayed(this, 1000);
            }
        }, 10);

        //Styling of the TextView
        currentDateTime.setGravity(Gravity.CENTER);
        currentDateTime.setTextSize(20);
        currentDateTime.setPadding(10,25,10,10);

        //Create layout and parameters for the TextView
        LinearLayout linearLayout = view.findViewById(R.id.linearlayout);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        currentDateTime.setLayoutParams(params);

        //Add textView to Layout
        linearLayout.addView(currentDateTime, params);
    }
}
