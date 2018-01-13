package com.working_group.votingapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.working_group.votingapp.R;

public class addQuestionConfirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question_confirm);
        setTitle("アンケート作成 ー 確認");

        Button returnButton = (Button) findViewById(R.id.return_addQuestionActivity);
        returnButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        TextView titleView = (TextView) findViewById(R.id.confirm_titleView);
        TextView contentsView = (TextView) findViewById(R.id.confirm_contentsView);
        TextView option1View = (TextView) findViewById(R.id.confirm_firstOptionView);
        TextView option2View = (TextView) findViewById(R.id.confirm_secondOptionView);
        TextView option3View = (TextView) findViewById(R.id.confirm_thirdOptionView);
        TextView option4View = (TextView) findViewById(R.id.confirm_fourthOptionView);

        Intent intent = getIntent();

        try {
            // intentから指定したキーの値を取得する
            String title = intent.getStringExtra("title");
            String contents = intent.getStringExtra("contents");
            String option1 = intent.getStringExtra("option1");
            String option2 = intent.getStringExtra("option2");
            String option3 = intent.getStringExtra("option3");
            String option4 = intent.getStringExtra("option4");

            titleView.setText(title);
            contentsView.setText(contents);
            option1View.setText(option1);
            option2View.setText(option2);
            option3View.setText(option3);
            option4View.setText(option4);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
