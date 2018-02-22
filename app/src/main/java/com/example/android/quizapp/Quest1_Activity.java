package com.example.android.quizapp;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Quest1_Activity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;

    SharedPreferences sharedpreferences;

    public static final String quest1ans1 = "quest1ans1";
    public static final String quest1ans2 = "quest1ans2";
    public static final String quest1ans3 = "quest1ans3";
    public static final String quest1ans4 = "quest1ans4";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest1_);
        checkPreferences();
    }


    public void nextQuestion(View view) {
        /* Call the second question of the Quiz */
        Intent intentQuestion2 = new Intent(this, Quest2_Activity.class);
        startActivity(intentQuestion2);

        //Save Preferences before going to the next Question
        savePreferences();
        finish();
    }


    private void checkPreferences() {

        CheckBox checkboxTextView = (CheckBox) findViewById(R.id.checkboxTextView);
        CheckBox checkboxImageView = (CheckBox) findViewById(R.id.checkboxImageView);
        CheckBox checkboxIntent = (CheckBox) findViewById(R.id.checkboxIntent);
        CheckBox checkboxButton = (CheckBox) findViewById(R.id.checkboxButton);

        // Open Preferences file
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        //Get values from Preferences
        boolean questAns1 = sharedpreferences.getBoolean(quest1ans1, false);
        checkboxTextView.setChecked(questAns1);

        boolean questAns2 = sharedpreferences.getBoolean(quest1ans2, false);
        checkboxImageView.setChecked(questAns2);

        boolean questAns3 = sharedpreferences.getBoolean(quest1ans3, false);
        checkboxIntent.setChecked(questAns3);

        boolean questAns4 = sharedpreferences.getBoolean(quest1ans4,false);
        checkboxButton.setChecked(questAns4);

        editor.apply();
    }

    private void savePreferences() {

        CheckBox checkboxTextView = (CheckBox) findViewById(R.id.checkboxTextView);
        CheckBox checkboxImageView = (CheckBox) findViewById(R.id.checkboxImageView);
        CheckBox checkboxIntent = (CheckBox) findViewById(R.id.checkboxIntent);
        CheckBox checkboxButton = (CheckBox) findViewById(R.id.checkboxButton);

        // Open Preferences file
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        // Get value from CheckBox TextView
        boolean questAns1 = checkboxTextView.isChecked();
        editor.putBoolean(quest1ans1, questAns1);

        // Get value from CheckBox ImageView
        boolean questAns2 = checkboxImageView.isChecked();
        editor.putBoolean(quest1ans2, questAns2);

        // Get value form CheckBox Intent
        boolean questAns3 = checkboxIntent.isChecked();
        editor.putBoolean(quest1ans3, questAns3);

        // Get value form CheckBox Intent
        boolean questAns4 = checkboxButton.isChecked();
        editor.putBoolean(quest1ans4, questAns4);

        //Apply changes to the sharedPreferences
        editor.apply();
    }
}
