package com.example.android.quizapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class Quest6_Activity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;

    SharedPreferences sharedpreferences;

    public static final String quest6ans1 = "quest6ans1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest6_);

        //Check for saved values in SharedPreferences
        checkPreferences();
    }

    public void previousQuestion(View view) {
        //Save answer
        savePreferences();

        //Call Intent for Question 5
        Intent intentQuestion5 = new Intent(this, Quest5_Activity.class);
        startActivity(intentQuestion5);
        finish();
    }

    public void nextQuestion(View view) {
        //Save answer
        savePreferences();

        //Call Intent for Question 7
        Intent intentQuestion7 = new Intent(this, Quest7_Activity.class);
        startActivity(intentQuestion7);
        finish();
    }

    private void checkPreferences() {

        RadioButton questans1 = (RadioButton) findViewById(R.id.radioButton1Question6);
        RadioButton questans2 = (RadioButton) findViewById(R.id.radioButton2Question6);
        RadioButton questans3 = (RadioButton) findViewById(R.id.radioButton3Question6);
        RadioButton questans4 = (RadioButton) findViewById(R.id.radioButton4Question6);

        // Open Preferences file
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        int questAns1 = sharedpreferences.getInt(quest6ans1,0);

        if (questAns1 != 0) {
            switch (questAns1) {
                case 1:
                    questans1.setChecked(true);
                    break;
                case 2:
                    questans2.setChecked(true);
                    break;
                case 3:
                    questans3.setChecked(true);
                    break;
                case 4:
                    questans4.setChecked(true);
                    break;
                default:
                    break;
            }
        }

        editor.apply();
    }

    private void savePreferences() {

        RadioButton questans1 = (RadioButton) findViewById(R.id.radioButton1Question6);
        RadioButton questans2 = (RadioButton) findViewById(R.id.radioButton2Question6);
        RadioButton questans3 = (RadioButton) findViewById(R.id.radioButton3Question6);
        RadioButton questans4 = (RadioButton) findViewById(R.id.radioButton4Question6);

        // Open Preferences file
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        int ansToSave = 0;
        boolean ansTrueOrFalse = false;

        //Get value from CheckBox and save it

        ansTrueOrFalse = questans1.isChecked();

        if(ansTrueOrFalse){
            ansToSave = 1;
            ansTrueOrFalse = false;
        }

        ansTrueOrFalse = questans2.isChecked();

        if(ansTrueOrFalse) {
            ansToSave = 2;
            ansTrueOrFalse = false;
        }

        ansTrueOrFalse = questans3.isChecked();

        if(ansTrueOrFalse) {
            ansToSave = 3;
            ansTrueOrFalse = false;
        }

        ansTrueOrFalse = questans4.isChecked();

        if(ansTrueOrFalse) {
            ansToSave = 4;
            ansTrueOrFalse = false;
        }

        editor.putInt(quest6ans1, ansToSave);

        //Apply changes to the sharedPreferences
        editor.apply();
    }
}
