package com.example.android.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Check if the checkbox question is answered correctly
     *
     * @return 1 if correct else 0
     */

    public int checkBoxes() {
        CheckBox goodAnswer1 = findViewById(R.id.good_answer1);
        boolean isGoodAnswer1Checked = goodAnswer1.isChecked();

        CheckBox goodAnswer2 = findViewById(R.id.good_answer2);
        boolean isGoodAnswer2Checked = goodAnswer2.isChecked();

        CheckBox badAnswer1 = findViewById(R.id.bad_answer1);
        boolean isBadAnswer1Checked = badAnswer1.isChecked();

        CheckBox badAnswer2 = findViewById(R.id.bad_answer2);
        boolean isBadAnswer2Checked = badAnswer2.isChecked();

        if ((!isBadAnswer1Checked && !isBadAnswer2Checked) && (isGoodAnswer1Checked && isGoodAnswer2Checked)) {
            return 1;
        }
        return 0;
    }

    /**
     * Checks if the first EditText question is answered correctly
     *
     * @return 1 if correct else 0
     */

    public int checkEditText1() {
        EditText question3EditText = (EditText) findViewById(R.id.question_3);
        String answer3 = question3EditText.getText().toString();
        if (answer3.equals("Burj Khalifa") || answer3.equals("Burj khalifa") || answer3.equals("burj khalifa")) {
            return 1;
        }
        return 0;
    }

    /**
     * Checks if the second EditText question is answered correctly
     *
     * @return 1 if correct else 0
     */

    public int checkEditText2() {
        EditText question6EditText = (EditText) findViewById(R.id.question_6);
        String answer6 = question6EditText.getText().toString();
        if (answer6.equals("92 cm") || answer6.equals("3.02ft") || answer6.equals("92") || answer6.equals("3.02")
                || answer6.equals("92cm")) {
            return 1;
        }
        return 0;
    }

    /**
     * Checks if a RadioButton question is correct provided by the ID of the question and the ID
     * of the correct answer
     *
     * @param questionID ID of the RadioButton question to be checked
     * @param answerID   ID of the correct answer of the RadioButton question
     * @return 1 if correct else 0
     */

    public int checkRadioButton(int questionID, int answerID) {
        RadioGroup question = (RadioGroup) findViewById(questionID);
        int selectedId = question.getCheckedRadioButtonId();
        RadioButton submitAnswersRadioButton = (RadioButton) findViewById(selectedId);
        if (question.getCheckedRadioButtonId() == -1) {
            return 0;
        } else if (submitAnswersRadioButton.getId() == answerID) {
            return 1;
        }
        return 0;
    }

    /**
     * Calculates the score of the quiz based on the results of the previous methods.
     * Resets the score each time its called. Displays a custom toast based on result.
     *
     * @param view
     */

    public void getScore(View view) {
        int totalScore;
        totalScore = checkBoxes() + checkEditText1() + checkEditText2() + checkRadioButton(R.id.question_1, R.id.question_1_good_answer1)
                + checkRadioButton(R.id.question_4, R.id.question_4_good_answer1)
                + checkRadioButton(R.id.question_5, R.id.question_5_good_answer1)
                + checkRadioButton(R.id.question_7, R.id.question_7_good_answer1);

        switch (totalScore) {
            case 0:
                Toast.makeText(MainActivity.this, "You got: " + totalScore + " out of 7, Too bad, try again.", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(MainActivity.this, "You got: " + totalScore + " out of 7, at least it's not 0.", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(MainActivity.this, "You got: " + totalScore + " out of 7, try to make it better", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(MainActivity.this, "You got: " + totalScore + " out of 7, nice!", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(MainActivity.this, "You got: " + totalScore + " out of 7. Not bad!", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(MainActivity.this, "You got: " + totalScore + " out of 7, pretty good!", Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(MainActivity.this, "You got: " + totalScore + " out of 7, you're almost there!", Toast.LENGTH_SHORT).show();
                break;
            case 7:
                Toast.makeText(MainActivity.this, "You got: " + totalScore + " out of 7! Congratulations!! Perfect!", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
