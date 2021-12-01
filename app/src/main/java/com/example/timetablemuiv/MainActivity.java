package com.example.timetablemuiv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

import androidx.drawerlayout.widget.DrawerLayout;

import com.example.timetablemuiv.databinding.ActivityCurrentTimetableBinding;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    TextView textView;
    Button myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settingsToolbarNavigationViewDrawerLayout();
        final Spinner spinner = findViewById(R.id.spinnerGroup);


        ArrayAdapter<?> adapter =
                ArrayAdapter.createFromResource(this, R.array.groups, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setAdapter(adapter);

    }

    private void settingsToolbarNavigationViewDrawerLayout() {
        toolbar = findViewById(R.id.toolbarMain);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setSupportActionBar(toolbar);
        textView = findViewById(R.id.textView);
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
        NetworkService.getInstance()
                .getJSONApi()
                .getPostWithID(11712)
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                        if (response.code() == 200) {
                            Post post   = response.body();


                            textView.append(post.getFaculty() + "\n");
                            textView.append( post.getGroup().get(0).getWeek().get(0).getCouples().get(0).getTime() +"\n");
                          //  textView.append(Post.Week.class + "\n");
                            //textView.append(post.getWeekId() + "\n");
                            ActivityCurrentTimetable.post2=post;
                        }
                        else
                        {
                            String text = response.errorBody().source()+"";
                            text = text.substring(1,text.length()-1);
                            text = text.substring(5);
                            textView.append(""+response.code()+"\n"+text);
                            String x ="";

                        }


                    //    textView.append(post.getUserId() + "\n");
                     //   textView.append(post.getTitle() + "\n");
                      //  textView.append(post.getBody() + "\n");
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