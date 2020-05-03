package com.example.appsenzen;

import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateUtils;
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
    static TextView textView;
    private static String  HOUR_FORMAT = "HH:mm";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        //Create Live Clock on Dashboard
        liveTime();
        textView = view.findViewById(R.id.currentLessonText);
        checkCurrentLesson();

        return view;
    }



    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        checkCurrentLesson();
    }

    private void addStudents(){
        SimpleDateFormat sdf = new SimpleDateFormat("u");
        String className = SchoolClassHandler.getTimetable().getClassName(new Integer(sdf.format(new Date())), new Date());

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
                currentDateTime.setText(new SimpleDateFormat("HH:mm:ss EEE d MMM yyyy", Locale.GERMANY).format(new Date()));
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
    public static String getCurrentHour() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdfHour = new SimpleDateFormat(HOUR_FORMAT);
        String hour = sdfHour.format(cal.getTime());
        return hour;
    }

    public static boolean isNowInInterval(String start, String end) {
        return isHourInInterval(getCurrentHour(), start, end);
    }

    public static boolean isHourInInterval(String target, String start, String end) {
        return ((target.compareTo(start) >= 0)
                && (target.compareTo(end) <= 0));
    }

    public static void checkCurrentLesson(){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        String lesson1 = "07:50";
        String lesson2 = "08:40";
        String lesson3 = "09:35";
        String lesson4 = "10:25";
        String lesson5 = "11:30";
        String lesson6 = "12:20";
        String pause = "13:10";
        String lesson7 = "14:00";
        String lesson8 = "14:50";
        String endofday = "15:40";
        switch (day){
            case Calendar.MONDAY:
                if(isNowInInterval(lesson1, lesson2)){
                    textView.setText("1DT");//1DT
                }
                if(isNowInInterval(lesson2, lesson3)){
                    textView.setText("4BT");
                    //4BT
                }
                if(isNowInInterval(lesson3, lesson4)){
                    textView.setText("1AT");
                    //1AT
                }
                if(isNowInInterval(lesson5, lesson6)){
                    textView.setText("3AT");
                    //3AT
                }
                if(isNowInInterval(lesson7, lesson8)){
                    textView.setText("4AT");
                    //4AT
                }
                if(isNowInInterval(lesson8, endofday)){
                    textView.setText("5AT");
                    //5AT
                }
                break;
            case Calendar.TUESDAY:
                if(isNowInInterval(lesson3, lesson4)){
                    textView.setText("3BT");
                    //3BT
                }
                if(isNowInInterval(lesson4, lesson5)){
                    textView.setText("2AT");
                    //2AT
                }
                if(isNowInInterval(lesson5, lesson6)){
                    textView.setText("3AT");
                    //3AT
                }
                if(isNowInInterval(lesson6, pause)){
                    textView.setText("5BT");
                    //5BT
                }

                break;
            case Calendar.WEDNESDAY:
                if(isNowInInterval(lesson2, lesson3)){
                    textView.setText("4AT");
                    //4AT
                }
                if(isNowInInterval(lesson5, lesson6)){
                    textView.setText("5AT");
                    //5AT
                }
                if(isNowInInterval(lesson7, lesson8)){
                    textView.setText("1AT");
                    //1AT
                }
                if(isNowInInterval(lesson8, endofday)){
                    textView.setText("4BT");
                    //4BT
                }
                break;
            case Calendar.THURSDAY:
                if(isNowInInterval(lesson4, lesson5)){
                    textView.setText("5BT");
                    //5BT
                }
                if(isNowInInterval(lesson6, pause)){
                    textView.setText("1DT");
                    //1DT
                }
                break;
            case Calendar.FRIDAY:
                if(isNowInInterval(lesson3, lesson4)){
                    textView.setText("3BT");
                    //3BT
                }
                if(isNowInInterval(lesson4, lesson5)){
                    textView.setText("2AT");
                    //2AT
                }

                break;
        }





    }
}
