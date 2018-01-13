package com.working_group.votingapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.working_group.votingapp.R;

public class AnswerActivity extends AppCompatActivity {

    private RadioGroup answers;
    final private int uncheck = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        setTitle("回答画面");

        answers = (RadioGroup)findViewById(R.id.answers);

        Button returnButton = (Button) findViewById(R.id.return_listActivity);
        returnButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void confirmAnswer(View view) {

        // 選択済みのラジオボタンIDを取得(未選択なら-1)
        int answerId = answers.getCheckedRadioButtonId();
        if (answerId == uncheck) {
            Toast.makeText(this, "回答が選択されていません。", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO
    }
}
