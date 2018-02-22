package com.example.android.quizapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Quest2_Activity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;

    SharedPreferences sharedpreferences;

    public static final String quest2ans1 = "quest2ans1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest2_);
        checkPreferences();
    }

    public void previousQuestion(View view) {
        //Save answer
        savePreferences();

        //Call Intent for Question 1
        Intent intentQuestion1 = new Intent(this, Quest1_Activity.class);
        startActivity(intentQuestion1);
        finish();
    }

    public void nextQuestion(View view) {
        //Save answer
        savePreferences();

        //Call Intent for Question 3
        Intent intentQuestion3 = new Intent(this, Quest3_Activity.class);
        startActivity(intentQuestion3);
        finish();
    }

    private void checkPreferences() {

        EditText ideEditText = (EditText) findViewById(R.id.name_text_input);

        // Open Preferences file
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        //Get value from Preferences if it exist
        String questAns1 = sharedpreferences.getString(quest2ans1,"");
        ideEditText.setText(questAns1);

        editor.apply();
    }

    private void savePreferences() {

        EditText ideEditText = (EditText) findViewById(R.id.name_text_input);
        String cleanIdeEditText = ideEditText.getText().toString().trim();

        // Open Preferences file
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        //Save clean value
        editor.putString(quest2ans1 ,cleanIdeEditText);

        //Apply changes to the sharedPreferences
        editor.apply();
    }

}
