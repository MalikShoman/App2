package com.cs.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cs.assignment2.Models.SecondInfo;
import com.google.gson.Gson;

public class MainActivity2 extends AppCompatActivity {

    public static final String second="second";

    private EditText experience;
    private EditText GPA;
    private EditText linkedin;
    private EditText skill;
    private boolean flag=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setupViews();


        setdata();
    }

    private void setdata() {

        if(flag) {

            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            Gson gson = new Gson();
            String str = prefs.getString(second, "");

            if(!str.equals("")){

                SecondInfo second = gson.fromJson(str, SecondInfo.class);
                experience.setText(second.getExperience());
                GPA.setText(second.getGPA());
                linkedin.setText(second.getLinkedin());
                skill.setText(second.getSkill());
            }

        }

    }

    private void setupViews() {
        experience=findViewById(R.id.experience);
        GPA=findViewById(R.id.GPA);
        linkedin=findViewById(R.id.linkedin);
        skill=findViewById(R.id.skill);
    }

    public void save_onclick(View view) {

        SecondInfo b2=new SecondInfo(experience.getText().toString(),GPA.getText().toString(),linkedin.getText().toString(),
                skill.getText().toString());


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String secondString = gson.toJson(b2);

        editor.putString("second", secondString);

        editor.commit();



        Toast.makeText(this, "Data Saved:\n" + secondString,
                Toast.LENGTH_SHORT).show();
    }
}