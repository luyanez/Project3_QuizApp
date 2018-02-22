package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EndQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_quiz);

        finish();
    }
}
