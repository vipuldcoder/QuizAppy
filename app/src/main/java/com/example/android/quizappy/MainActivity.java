package com.example.android.quizappy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submit;
    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(submitButtonOnClickListener);

    }

    private String enterName() {
        EditText writeAnswer = (EditText) findViewById(R.id.name_input);
        String enterYourName = writeAnswer.getText().toString();
        return enterYourName;
    }

    private String checkAnswerOne() {
        EditText writeAnswer = (EditText) findViewById(R.id.answer_input);
        String answer = writeAnswer.getText().toString();
        if (answer == "peacock") {
            correctAnswers += 2;
        }
        return answer;
    }

    private void checkAnswerTwo() {
        RadioButton answerOstrich = (RadioButton) findViewById(R.id.ques_2_option_2);
        boolean answerOstrichClicked = answerOstrich.isChecked();
        if (answerOstrichClicked) {
            correctAnswers += 2;
        }
    }

    private void checkAnswerThree() {
        CheckBox ques3Option1 = (CheckBox) findViewById(R.id.ques_3_option_1);
        CheckBox ques3Option3 = (CheckBox) findViewById(R.id.ques_3_option_3);
        boolean answerThreeOptionOne = ques3Option1.isChecked();
        boolean answerThreeOptionThree = ques3Option3.isChecked();

        if(answerThreeOptionOne && answerThreeOptionThree) {
            correctAnswers += 2;
        }
    }

    private void checkAnswerFour() {
        RadioButton answerBlueJay = (RadioButton) findViewById(R.id.ques_4_option_2);
        boolean answerBlueJayClicked = answerBlueJay.isChecked();
        if (answerBlueJayClicked) {
            correctAnswers += 2;
        }
    }

    private void checkAnswerFive() {
        RadioButton answerBirds = (RadioButton) findViewById(R.id.ques_5_option_3);
        boolean answerBirdsClicked = answerBirds.isChecked();
        if (answerBirdsClicked) {
            correctAnswers += 2;
        }
    }

    private void checkQuestions(){
        checkAnswerOne();
        checkAnswerTwo();
        checkAnswerThree();
        checkAnswerFour();
        checkAnswerFive();
    }

    private void resetButton(){
        correctAnswers = 0;
    }

    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        public void onClick(final View v){
            checkQuestions();
            Toast.makeText(MainActivity.this, "Correct Answers: " + correctAnswers + "/10",
                    Toast.LENGTH_LONG).show();
            resetButton();
        }
    };
}
