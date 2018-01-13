package com.working_group.votingapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.working_group.votingapp.R;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("一覧");
        setContentView(R.layout.activity_list);
    }

    /**
     * 結果画面遷移
     */
    public void questionResult(View view) {

        Intent intent = new Intent(getApplication(), ResultActivity.class);
        startActivity(intent);
    }

    /**
     * アンケート追加画面遷移
     */
    public void addQuestion(View view) {

        Intent intent = new Intent(getApplication(), AddQuestionActivity.class);
        startActivity(intent);
    }

    /**
     * アンケート回答画面遷移
     */
    public void questionAnswer(View view) {

        Intent intent = new Intent(getApplication(), AnswerActivity.class);
        startActivity(intent);
    }
}
