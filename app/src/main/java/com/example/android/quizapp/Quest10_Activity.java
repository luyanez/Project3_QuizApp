package com.example.android.quizapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Enumeration;
import java.util.Vector;

public class Quest10_Activity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;

    SharedPreferences sharedpreferences;

    public static final String quest1ans1 = "quest1ans1";
    public static final String quest1ans2 = "quest1ans2";
    public static final String quest1ans3 = "quest1ans3";
    public static final String quest1ans4 = "quest1ans4";
    public static final String quest2ans1 = "quest2ans1";
    public static final String quest3ans1 = "quest3ans1";
    public static final String quest4ans1 = "quest4ans1";
    public static final String quest5ans1 = "quest5ans1";
    public static final String quest6ans1 = "quest6ans1";
    public static final String quest7ans1 = "quest7ans1";
    public static final String quest8ans1 = "quest8ans1";
    public static final String quest9ans1 = "quest9ans1";
    public static final String quest10ans1 = "quest10ans1";
    public static final String quest10ans2 = "quest10ans2";
    public static final String quest10ans3 = "quest10ans3";
    public static final String quest10ans4 = "quest10ans4";

    private boolean quest1ans1Text = false;
    private boolean quest1ans2Text = false;
    private boolean quest1ans3Text = false;
    private boolean quest1ans4Text = false;
    private String quest2ans1Text = null;
    private int quest3ans1Text = 0;
    private int quest4ans1Text = 0;
    private int quest5ans1Text = 0;
    private int quest6ans1Text = 0;
    private int quest7ans1Text = 0;
    private int quest8ans1Text = 0;
    private int quest9ans1Text = 0;
    private boolean quest10ans1Text = false;
    private boolean quest10ans2Text = false;
    private boolean quest10ans3Text = false;
    private boolean quest10ans4Text = false;

    private boolean allAnswersValidation = true;
    private Vector<Integer> vectorMissedAnswers = new Vector<>();
    private int score = 0;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest10_);

        //Check for saved values in SharedPreferences
        checkPreferences();

        // Add Listener for the EndQuiz Text
        TextView endQuiz = (TextView) findViewById(R.id.endQuiz);

        endQuiz.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Submit Quiz text is clicked on.
            @Override
            public void onClick(View view) {
                //Save answer
                savePreferences();

                //Get answers and calculate score, validate that all questions have answers
                validateAllAnswers();

                if (vectorMissedAnswers.isEmpty()) {
                    //If score is 10 then show toast
                    String scoreMessage = "Your score is "+score;
                    Toast.makeText(getApplicationContext(),scoreMessage,Toast.LENGTH_SHORT).show();


                    if(score == 100) {
                        Toast.makeText(getApplicationContext(),"Congratulations!",Toast.LENGTH_SHORT).show();
                        String messageFace = "Congratulations on your perfect score 100/100!";
                        showDialogEndQuiz(messageFace);
                    } else {
                        //If the score is not 10 give the option to try again or leave
                        String message = "Score: "+score+"\nYour score wasn't perfect.\nDo you want to try again?";
                        showDialogTryAgain(message);
                    }

                } else{

                    Enumeration vEnum = vectorMissedAnswers.elements();
                    String messageMissingAns = "You are missing answer(s): ";
                    while(vEnum.hasMoreElements()) {
                        messageMissingAns += ", ";
                        messageMissingAns += vEnum.nextElement().toString();
                    }
                    messageMissingAns+=".";
                    messageMissingAns+="\nYou can not leave any question \nwithout answer.";

                    //Calling Dialog box when missing answers
                    showDialogMissingAnswers(messageMissingAns);

                }

            }
        });

        // Add Listener for the Previous Button
        Button previousQuestion = (Button) findViewById(R.id.previousButton);

        // Set a click listener on that View
        previousQuestion.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family Members View is clicked on.
            @Override
            public void onClick(View view) {
                //Save answer
                savePreferences();

                //Call Intent for Question 9
                Intent question9Intent = new Intent(Quest10_Activity.this, Quest9_Activity.class);
                startActivity(question9Intent);
            }

        });
    }

    private void checkPreferences() {

        CheckBox udacity1 = (CheckBox) findViewById(R.id.udacity1);
        CheckBox udacity2 = (CheckBox) findViewById(R.id.udacity2);
        CheckBox udacity3 = (CheckBox) findViewById(R.id.udacity3);
        CheckBox udacity4 = (CheckBox) findViewById(R.id.udacity4);

        // Open Preferences file
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        boolean questAns1 = sharedpreferences.getBoolean(quest10ans1, false);
        udacity1.setChecked(questAns1);

        boolean questAns2 = sharedpreferences.getBoolean(quest10ans2, false);
        udacity2.setChecked(questAns2);

        boolean questAns3 = sharedpreferences.getBoolean(quest10ans3, false);
        udacity3.setChecked(questAns3);

        boolean questAns4 = sharedpreferences.getBoolean(quest10ans4,false);
        udacity4.setChecked(questAns4);

        editor.apply();
    }

    private void savePreferences() {

        CheckBox udacity1 = (CheckBox) findViewById(R.id.udacity1);
        CheckBox udacity2 = (CheckBox) findViewById(R.id.udacity2);
        CheckBox udacity3 = (CheckBox) findViewById(R.id.udacity3);
        CheckBox udacity4 = (CheckBox) findViewById(R.id.udacity4);

        // Open Preferences file
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        // Get value from CheckBox TextView
        boolean questAns1 = udacity1.isChecked();
        editor.putBoolean(quest10ans1, questAns1);

        // Get value from CheckBox ImageView
        boolean questAns2 = udacity2.isChecked();
        editor.putBoolean(quest10ans2, questAns2);

        // Get value form CheckBox Intent
        boolean questAns3 = udacity3.isChecked();
        editor.putBoolean(quest10ans3, questAns3);

        // Get value form CheckBox Intent
        boolean questAns4 = udacity4.isChecked();
        editor.putBoolean(quest10ans4, questAns4);

        //Apply changes to the sharedPreferences
        editor.apply();
    }

    private void validateAllAnswers(){

        score = 0;
        String rightIDEans = "Integrated Development Environment";

        // Open Preferences file
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        //Validate answer for Question 1
        quest1ans1Text = sharedpreferences.getBoolean(quest1ans1, false);
        quest1ans2Text = sharedpreferences.getBoolean(quest1ans2, false);
        quest1ans3Text = sharedpreferences.getBoolean(quest1ans3, false);
        quest1ans4Text = sharedpreferences.getBoolean(quest1ans4, false);

        if (quest1ans1Text || quest1ans2Text || quest1ans3Text || quest1ans4Text) {
           if ((quest1ans1Text && quest1ans2Text && quest1ans4Text) && quest1ans3Text == false) {
               score += 1;
           }
        } else{
            allAnswersValidation = false;
            vectorMissedAnswers.add(1);
        }

        //Validate answer for Question 2
        quest2ans1Text = sharedpreferences.getString(quest2ans1, null);

        if (quest2ans1Text.length() == 0) {
            allAnswersValidation = false;
            vectorMissedAnswers.add(2);
        } else if (rightIDEans.equalsIgnoreCase(quest2ans1Text)) {
            score+=1;
        }

        //Validate answer for Question 3
        quest3ans1Text = sharedpreferences.getInt(quest3ans1,0);
        score += ValidateRadioButtonQuestion(3,quest3ans1Text,3);

        //Validate answer for Question 4
        quest4ans1Text = sharedpreferences.getInt(quest4ans1, 0);
        score += ValidateRadioButtonQuestion(4,quest4ans1Text,3);

        //Validate answer for Question 5
        quest5ans1Text = sharedpreferences.getInt(quest5ans1,0);
        score += ValidateRadioButtonQuestion(5,quest5ans1Text,2);

        //Validate answer for Question 6
        quest6ans1Text = sharedpreferences.getInt(quest6ans1,0);
        score += ValidateRadioButtonQuestion(6,quest6ans1Text,1);

        //Validate answer for Question 7
        quest7ans1Text = sharedpreferences.getInt(quest7ans1, 0);
        score += ValidateRadioButtonQuestion(7,quest7ans1Text,4);

        //Validate answer for Question 8
        quest8ans1Text = sharedpreferences.getInt(quest8ans1, 0);
        score += ValidateRadioButtonQuestion(8,quest8ans1Text,3);

        //Validate answer for Question 9
        quest9ans1Text = sharedpreferences.getInt(quest9ans1,0);
        score += ValidateRadioButtonQuestion(9,quest9ans1Text,3);

        //Validate answer for Question 10
        quest10ans1Text = sharedpreferences.getBoolean(quest10ans1, false);
        quest10ans2Text = sharedpreferences.getBoolean(quest10ans2, false);
        quest10ans3Text = sharedpreferences.getBoolean(quest10ans3, false);
        quest10ans4Text = sharedpreferences.getBoolean(quest10ans4, false);

        if (quest10ans1Text || quest10ans2Text || quest10ans3Text || quest10ans4Text) {
                score += 1;
        } else{
            allAnswersValidation = false;
            vectorMissedAnswers.add(10);
        }

        score *= 10;

    }

    private int ValidateRadioButtonQuestion(int questNumber, int questAnswer, int questCorrectAnswer) {
        int score = 0;

        if(questAnswer == 0) {
            allAnswersValidation = false;
            vectorMissedAnswers.add(questNumber);
        } else if(questAnswer == questCorrectAnswer) {
            score = 1;
        }

        return score;
    }

    public void showDialogMissingAnswers(String messageMissingAns) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(messageMissingAns)
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //finish();
                        //Call Intent for Question 9
                        Intent question10Intent = new Intent(Quest10_Activity.this, Quest10_Activity.class);
                        startActivity(question10Intent);
                    }
                })
        ;

        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("Error Missing Answer(s)");
        alert.show();
        setContentView(R.layout.activity_quest10_);
    }

    public void showDialogTryAgain(String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        //Call Intent for Main
                        Intent mainActivityIntent = new Intent(Quest10_Activity.this, MainActivity.class);
                        startActivity(mainActivityIntent);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        Quest10_Activity.this.finish();
                    }
                })
        ;

        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("Score not Perfect");
        alert.show();
        setContentView(R.layout.activity_quest10_);
    }

    public void showDialogEndQuiz(String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Quest10_Activity.this.finish();

                    }
                })
        ;

        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("Perfect Score");
        alert.show();
        setContentView(R.layout.activity_end_quiz);
    }
}
