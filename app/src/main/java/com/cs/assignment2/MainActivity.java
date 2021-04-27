package com.cs.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.cs.assignment2.Models.BasicInfo;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String basics="basics";
    Spinner spinner;
    private EditText fname;
    private EditText lname;
    private EditText email;
    private EditText phone;
    private EditText address;
    private boolean flag=true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        populateSpinner();
        checkSave();

    }

    private void checkSave() {

        if(flag){

            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            Gson gson = new Gson();
            String str = prefs.getString(basics, "");
            if(!str.equals("")) {

                BasicInfo basic = gson.fromJson(str, BasicInfo.class);
                fname.setText(basic.getFname());
                lname.setText(basic.getLname());
                email.setText(basic.getEmail());
                phone.setText(basic.getPhone());
                address.setText(basic.getAddress());


            }



        }

    }

    private void setupViews() {
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        email = findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        address=findViewById(R.id.address);
        spinner=findViewById(R.id.gender);


    }

    private void populateSpinner() {
        ArrayList<String> gender = new ArrayList<>();
        gender.add("Male");
        gender.add("female");

        ArrayAdapter<String> adpt = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, gender);
        spinner.setAdapter(adpt);
    }

    public void save_onclick(View view) {
        BasicInfo b1=new BasicInfo(fname.getText().toString(),lname.getText().toString(),email.getText().toString(),
                phone.getText().toString(),address.getText().toString()
                ,spinner.getSelectedItem().toString());


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String basicString = gson.toJson(b1);

        editor.putString("basics", basicString);

        editor.commit();
        Toast.makeText(this, "Data Saved:\n" + basicString,
                Toast.LENGTH_SHORT).show();
    }

    public void next_onclick(View view) {

        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);



    }
}