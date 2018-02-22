package com.example.android.quizapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class Quest5_Activity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;

    SharedPreferences sharedpreferences;

    public static final String quest5ans1 = "quest5ans1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest5_);
        checkPreferences();
    }

    public void previousQuestion(View view) {
        //Save answer
        savePreferences();

        //Call Intent for Question 4
        Intent intentQuestion4 = new Intent(this, Quest4_Activity.class);
        startActivity(intentQuestion4);
        finish();
    }

    public void nextQuestion(View view) {
        //Save answer
        savePreferences();

        //Call Intent for Question 6
        Intent intentQuestion6 = new Intent(this, Quest6_Activity.class);
        startActivity(intentQuestion6);
        finish();
    }

    private void checkPreferences() {

        RadioButton questans1 = (RadioButton) findViewById(R.id.radioButton1Question5);
        RadioButton questans2 = (RadioButton) findViewById(R.id.radioButton2Question5);
        RadioButton questans3 = (RadioButton) findViewById(R.id.radioButton3Question5);

        // Open Preferences file
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        int questAns1 = sharedpreferences.getInt(quest5ans1,0);

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
                default:
                    break;
            }
        }

        editor.apply();
    }

    private void savePreferences() {

        RadioButton questans1 = (RadioButton) findViewById(R.id.radioButton1Question5);
        RadioButton questans2 = (RadioButton) findViewById(R.id.radioButton2Question5);
        RadioButton questans3 = (RadioButton) findViewById(R.id.radioButton3Question5);

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

        editor.putInt(quest5ans1, ansToSave);

        //Apply changes to the sharedPreferences
        editor.apply();
    }

}
