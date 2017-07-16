package com.example.android.hyemin_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    RadioButton quiz[] = new RadioButton[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz(View view){
        
    }

    private String getName(){
        EditText name = (EditText) findViewById(R.id.name_edit_txt);
        return name.getText().toString();
    }

    private String getResult(){
        String result="";

        quiz[0] = (RadioButton) findViewById(R.id.correct_answer1);
        quiz[1] = (RadioButton) findViewById(R.id.correct_answer2);
        quiz[2] = (RadioButton) findViewById(R.id.correct_answer3);

        result += "Your Result: \n";

        for(int i=0; i<quiz.length; i++) {
            if(quiz[i].isChecked()) {
                result += "Quiz"+(i+1)+": O\n";
                score += 1;
            }
            else {
                result += "Quiz"+(i+1)+": X\n";
            }
        }

        result += "Total score: "+score+"/3\n";

        return result;
    }
}
