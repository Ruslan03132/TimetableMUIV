package com.example.timetablemuiv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.os.HandlerCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.google.android.material.navigation.NavigationView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    TextView textView;
    int spinnerContent;
    Post post3;
    String groupName[]=new String[15];
    Integer groupSize;
    String strDate = "2021-08-29 23:59:59";
 String preid;
 static Integer preid1;
    static Integer preid2;
    static Integer preid3;

    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settingsToolbarNavigationViewDrawerLayout();




    }
    public void createWeekCurrentSemestr(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        Date dateJan = new Date();
        Date dateSep = new Date();
        try {
            dateSep = formatter.parse(strDate);

        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        long longDifference = dateJan.getTime() - dateSep.getTime();
        Log.e("longDifferenceMills",longDifference + "");
        longDifference = longDifference / (1000 * 60 * 60 * 24 * 7);
        Log.e("longDifferenceWeek",longDifference + "");
        id = (int)longDifference + 1;

        if(preid1!=null) {
            preid = "117";
        }
            if(preid==null){
            preid="117";
        }else {
            preid = String.valueOf(preid1);
            preid = preid + String.valueOf(preid2);
            preid = preid + String.valueOf(preid3);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);
        if (dayOfTheWeek.equals("суббота") || dayOfTheWeek.equals("воскресенье")){
            id = id + 1;
        }

        Log.e("preid",preid + "");
        String container = preid + id;
        id = Integer.parseInt(container);
    }

    private void settingsToolbarNavigationViewDrawerLayout() {
        toolbar = findViewById(R.id.toolbarMain);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setSupportActionBar(toolbar);
        textView = findViewById(R.id.test);
        drawer = findViewById(R.id.activity_main);
     //   myButton = (Button) findViewById(R.id.button);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

        };
        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }



    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {

            case R.id.home:
                drawer.closeDrawer(GravityCompat.START);

                break;
            case R.id.site:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.muiv.ru/")));
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.info:
                startActivity(new Intent(this, info_activity.class));
                drawer.closeDrawer(GravityCompat.START);
                break;


        }
        drawer.closeDrawer(GravityCompat.START);


        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings_menu, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {

            case (R.id.settings):
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }

    public void onMyButtonCurrent(View view) {
        startActivity(new Intent(this, ActivityCurrentTimetable.class));

    }

    public void onMyButtonWeek(View view) {
        startActivity(new Intent(this, ActivityWeekTimetable.class));
    }








//editText.setText("79293557688");


        //   body1.setPhoneNumber(i);
        //textView4.append("\n"+body1+"\n");

    {
        createWeekCurrentSemestr();
        NetworkService.getInstance()
                .getJSONApi()
                .getPostWithID(id)
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                        if (response.code() == 200) {
                            Post post = response.body();


                            //textView.append(post.getFaculty() + "\n");

                            //textView.append( post.getGroup().get(0).getWeek().get(0).getCouples().get(0).getTime() +"\n");
                            //  textView.append(Post.Week.class + "\n");
                            //textView.append(post.getWeekId() + "\n");
                            ActivityCurrentTimetable.post2 = post;
                            ActivityWeekTimetable.post3 = post;
                            post3 = post;
                            //________________________________________________________________________________
                            //Спинер
                            for (int i = 0; i < 15; i++) {
                                if (i < post3.getGroup().size()) {
                                    groupName[i]=post3.getGroup().get(i).getGroupName();
                                    groupSize=i;
                                }


                            }
                            final Spinner spinner = findViewById(R.id.spinnerGroup);
                            List<String> groups = new ArrayList<String>();
                            for (int i = 0; i < 15; i++) {
                                if (groupName[i]!=null) {
                                    groups.add(groupName[i]);
                                }
                            }
                            groups.add("Все");


                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, groups);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spinner.setAdapter(adapter);

                            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                public void onItemSelected(AdapterView<?> parent,
                                                           View itemSelected, int selectedItemPosition, long selectedId) {


                                    if (selectedItemPosition>groupSize){
                                        spinnerContent=99;
                                    }
                                    else
                                    {
                                        spinnerContent = selectedItemPosition;
                                    }
                                    ActivityCurrentTimetable.spinnerContent=spinnerContent;
                                    ActivityWeekTimetable.spinnerContent=spinnerContent;
                                }
                                public void onNothingSelected(AdapterView<?> parent) {
                                }
                            });


                        } else {
                            String text = response.errorBody().source() + "";
                            text = text.substring(1, text.length() - 1);
                            text = text.substring(5);
                            textView.append("" + response.code() + "\n" + text);
                            String x = "";

                        }

                    }
                    @Override
                    public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {


                        textView.append("Error occurred while getting request!");
                        textView.append(t.getMessage());
                        t.printStackTrace();
                    }
                });


    }


}