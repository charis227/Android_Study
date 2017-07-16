package com.example.android.hyemin_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    /**
     * @param score         quiz score
     * @param quiz[]        each quiz's correct answer RadioButton
     */
    int score;
    RadioButton quiz[] = new RadioButton[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method submit result into mail application.
     *
     * @param view          submit Button
     */
    public void submitQuiz(View view){
        /**
         * @param name          user name
         * @param result        result string to show correct or not in each quiz and total score
         */
        String name = getName();
        String result = getResult();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.user_name, name));
        intent.putExtra(Intent.EXTRA_TEXT, result);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method get user name from edit text.
     */
    private String getName(){
        EditText name = (EditText) findViewById(R.id.name_edit_txt);
        return name.getText().toString();
    }

    /**
     * This method get each result in quiz and calculate total score.
     * @return          all result string in the quiz page.
     */
    private String getResult(){
        String result="";
        score = 0;

        quiz[0] = (RadioButton) findViewById(R.id.correct_answer1);
        quiz[1] = (RadioButton) findViewById(R.id.correct_answer2);
        quiz[2] = (RadioButton) findViewById(R.id.correct_answer3);

        for(int i=0; i<quiz.length; i++) {
            if(quiz[i].isChecked()) {
                result += getString(R.string.quiz)+(i+1)+": O\n";
                score += 1;
            }
            else {
                result += getString(R.string.quiz)+(i+1)+": X\n";
            }
        }

        result += getString(R.string.total_score)+score+"/3\n";

        if(score==3){
            result += "\n"+getString(R.string.congratulation);
        }

        return result;
    }
}
