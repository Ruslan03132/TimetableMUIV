package com.example.timetablemuiv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityCurrentTimetable extends AppCompatActivity {
    Toolbar toolbar;
    TextView currentDay;
    static Integer spinnerContent;
    static Post post2 ;
    Post post3=post2;
    int x=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
       Date d = new Date();
       String dayOfTheWeek = sdf.format(d);
       int date = 8;
       int textViewCount = 10;

       TextView[] Para = new TextView[textViewCount];


       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_current_timetable);
       toolbar = findViewById(R.id.toolbarMain);
       currentDay = findViewById(R.id.currentDay);
        int textViewCount2 = 10;

        TextView[] textViewArray = new TextView[textViewCount2];
        LinearLayout LinearLayout = new LinearLayout(this);
        for(int i = 0; i < textViewCount2; i++) {

            LinearLayout.findViewById(R.id.LinearLayout3);
            LinearLayout.setOrientation(android.widget.LinearLayout.VERTICAL);
            textViewArray[i] = new TextView(this);
            textViewArray[i].append(Integer.toString(i)+"элемент");
            textViewArray[i].setTextSize(30);

            LinearLayout.addView(textViewArray[i]);

        }
      //  setContentView(LinearLayout);
       Para[1] = findViewById(R.id.Para1);
       Para[2] = findViewById(R.id.Para2);
       Para[3] = findViewById(R.id.Para4);
       Para[4] = findViewById(R.id.Para3);
       Para[5] = findViewById(R.id.Para5);
       Para[6] = findViewById(R.id.Para6);

       currentDay.setText(dayOfTheWeek);
       if (post3 != null) {

           if (spinnerContent != 99) {


               for (int i = 0; i < 8; i++) {
                   if (i < post3.getGroup().get(spinnerContent).getWeek().size()) {

                       if (dayOfTheWeek.equals(post3.getGroup().get(spinnerContent).getWeek().get(i).getDayName())) {

                           date = i;

                       }
                   }


               }
               if (date < 5) {
                   for (int i = 1; i < 7; i++) {

                       if (i <= post3.getGroup().get(spinnerContent).getWeek().get(date).getCouples().size()) {

                           Para[i].append(post3.getGroup().get(spinnerContent).getWeek().get(date).getCouples().get(i - 1).getTime() + "\n");
                           Para[i].append(post3.getGroup().get(spinnerContent).getWeek().get(date).getCouples().get(i - 1).getDiscipline() + "\n");
                           Para[i].append(post3.getGroup().get(spinnerContent).getWeek().get(date).getCouples().get(i - 1).getOtherInfo());

                       }// костыль, тк в пятницу 3 пары, а не 6
                   }
                   setSupportActionBar(toolbar);
                   getSupportActionBar().setDisplayHomeAsUpEnabled(true);


               }
           }
           else
           {

           }


       }
   }

   }