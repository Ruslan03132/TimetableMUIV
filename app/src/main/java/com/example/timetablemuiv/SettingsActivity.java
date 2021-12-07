package com.example.timetablemuiv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends AppCompatActivity {
    public static final String settingsSharedPreferences = "settingsSharedPreferences";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);
        SharedPreferences sharedPreferences = this.getSharedPreferences(settingsSharedPreferences, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        final Spinner spinner = (Spinner) findViewById(R.id.spinnerGroup);
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinnerGroup2);
        final Spinner spinner3 = (Spinner) findViewById(R.id.spinnerGroup3);
        List<String> faculties = new ArrayList<String>();
        faculties.add("Факультет информационных технологий");
        faculties.add("Факультет управления");
        faculties.add("Факультет экономики и финансов");
        faculties.add("Факультет юридический");
       //_______________________________________________________________________________
        List<String> formofedu = new ArrayList<String>();
        formofedu.add("Очная");

      /*  formofedu.add("Факультет управления");
        formofedu.add("Факультет экономики и финансов");
        formofedu.add("Факультет юридический");*/
        //_______________________________________________________________________________
        List<String> cource = new ArrayList<String>();
        cource.add("1 курс");
        cource.add("1 курс СПО");
        cource.add("2 курс");
        cource.add("2 курс СПО");
        cource.add("3 курс");
        cource.add("3 курс СПО");
        cource.add("4 курс");
        cource.add("4 курс СПО");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, faculties);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, formofedu);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, cource);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);




        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {

                MainActivity.preid1 = selectedItemPosition+1;
                editor.putInt("Факультеты",MainActivity.preid1);
                editor.apply();

            }
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });
        spinner.setSelection(sharedPreferences.getInt("Факультеты",1) - 1);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition2, long selectedId) {

                MainActivity.preid2 = selectedItemPosition2+1;
                editor.putInt("Форма обучения",MainActivity.preid2);
                editor.apply();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner2.setSelection(sharedPreferences.getInt("Форма обучения",1) - 1);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition3, long selectedId) {

                MainActivity.preid3 = selectedItemPosition3+1;
                editor.putInt("Курс",MainActivity.preid3);
                editor.apply();

            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner3.setSelection(sharedPreferences.getInt("Курс",1) - 1);





        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }
}