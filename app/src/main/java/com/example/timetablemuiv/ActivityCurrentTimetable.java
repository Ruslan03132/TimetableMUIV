package com.example.timetablemuiv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityCurrentTimetable extends AppCompatActivity {
    Toolbar toolbar;

   static Post post2 ;
    Post post3=post2;
    int x=0;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
       int textViewCount = 10;

       TextView[] Para = new TextView[textViewCount];





        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_timetable);
        toolbar = findViewById(R.id.toolbarMain);
       // textView = findViewById(R.id.textView);

       Para[1] = (TextView)findViewById(R.id.Para1);
    Para[2]= findViewById(R.id.Para2);
    Para[3] = findViewById(R.id.Para4);
    Para[4]= findViewById(R.id.Para3);
    Para[5]= findViewById(R.id.Para5);
    Para[6]= findViewById(R.id.Para6);




    for (int i = 1; i < 8; i++) {

        if (i<=post3.getGroup ().get(0).getWeek().get(4).getCouples().size())
        {
            Para[i].append(post3.getGroup().get(0).getWeek().get(4).getCouples().get(i - 1).getTime()+ "\n");
            Para[i].append(post3.getGroup().get(0).getWeek().get(4).getCouples().get(i - 1).getDiscipline() + "\n");
            Para[i].append(post3.getGroup().get(0).getWeek().get(4).getCouples().get(i - 1).getOtherInfo());
        }
    }




        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    {

    }


}