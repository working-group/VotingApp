package com.working_group.votingapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.working_group.votingapp.R;

public class AnswerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        setTitle("回答画面");

        //intent取得
        Intent intent = getIntent();

        //TODO: intentからアンケートIDを受け取理、APIから詳細情報を取得する

        //TODO: アンケート情報表示（仮）
        TextView title = (TextView) findViewById(R.id.title);
        title.setText(intent.getStringExtra("title"));

        Button returnButton = (Button) findViewById(R.id.return_listActivity);
        returnButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}
