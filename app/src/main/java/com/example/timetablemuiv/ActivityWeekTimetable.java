package com.example.timetablemuiv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityWeekTimetable extends AppCompatActivity {
    Toolbar toolbar;
    String[] DayName = new String[7];
    int DayNamer;
    static Integer spinnerContent;
    static Post post3 ;
    int date = 8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        DayName[0]="Понедельник";
        DayName[1]="Вторник";
        DayName[2]="Среда";
        DayName[3]="Четверг";
        DayName[4]="Пятница";
        DayName[5]="Суббота";
        DayName[6]="Воскресенье";
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_timetable);
        toolbar = findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //int textViewCount2 = 7;

        TextView[] textViewArray = new TextView[150];
    //    LinearLayout LinearLayout = new LinearLayout(this);
        for (int w = 0; w < 7; w++) {
            for (int i = 0; i < 7; i++) {
                //setContentView(R.layout.activity_week_timetable);

                LinearLayout mainLayout = findViewById(R.id.LinearLayout3);

                textViewArray[i] = new TextView(this);
                 textViewArray[i].setTextSize(24);
               // LinearLayout.addView(textViewArray[i]);
              //  LinearLayout.addView(textViewArray[i]);
                textViewArray[i].setTextColor(Color.BLACK);
                textViewArray[i].setPadding(16,16,16,16);

                android.widget.LinearLayout.LayoutParams imageViewLayoutParams = new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, android.widget.LinearLayout.LayoutParams.WRAP_CONTENT);
                textViewArray[i].setLayoutParams(imageViewLayoutParams);

                mainLayout.addView(textViewArray[i]);
                if (i==0)
                {
                    textViewArray[i].setText(DayName[DayNamer]);
                    textViewArray[i].setWidth(4000);
                    textViewArray[i].setBackgroundColor(Color.parseColor("#ef4136"));
                    textViewArray[i].setTextColor(Color.WHITE);
                    textViewArray[i].setPadding(8,8,8,150);


                    DayNamer++;
                }
                else
                    {
                        if (post3 != null) {

                            if (spinnerContent != 99) {


                                for (int r = 0; r < 8; r++) {
                                    if (r < post3.getGroup().get(spinnerContent).getWeek().size()) {

                                        if (dayOfTheWeek.equals(post3.getGroup().get(spinnerContent).getWeek().get(r).getDayName())) {

                                            date = r;

                                        }
                                    }


                                }
                                if (w < post3.getGroup().get(spinnerContent).getWeek().size()) {


                                        if (i <= post3.getGroup().get(spinnerContent).getWeek().get(w).getCouples().size()) {

                                            textViewArray[i].append(post3.getGroup().get(spinnerContent).getWeek().get(w).getCouples().get(i-1).getTime() + "\n");
                                            textViewArray[i].append(post3.getGroup().get(spinnerContent).getWeek().get(w).getCouples().get(i-1).getDiscipline() + "\n");
                                            textViewArray[i].append(post3.getGroup().get(spinnerContent).getWeek().get(w).getCouples().get(i-1).getOtherInfo());

                                        }// костыль, тк в пятницу 3 пары, а не 6




                                }
                            }
                            else
                            {

                            }


                        }






                    }

            }


        }
   //     setContentView(LinearLayout);


    }
}