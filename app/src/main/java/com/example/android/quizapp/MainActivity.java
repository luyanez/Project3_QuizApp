package com.example.android.quizapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the View for the StartQuiz Text
        TextView startQuiz = (TextView) findViewById(R.id.startQuiz);

        // Set a click listener on that View
        startQuiz.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family Members View is clicked on.
            @Override
            public void onClick(View view) {

                // Create Preferences file and clean it
                sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editor.commit();

                // Call the beginning of the quiz.
                Intent question1Intent = new Intent(MainActivity.this, Quest1_Activity.class);
                startActivity(question1Intent);

                //Finish View once the Question is called.
                finish();
            }
        });
    }
}
