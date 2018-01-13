package com.working_group.votingapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
// import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.working_group.votingapp.R;

public class AddQuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        setTitle("アンケート作成");

        Button returnButton = (Button) findViewById(R.id.return_listActivity);
        returnButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void addQuestionConfirm(View view) {

        Intent intent = new Intent(AddQuestionActivity.this, addQuestionConfirm.class);

        try {
            // タイトル名の取得
            EditText editTitle = (EditText)findViewById(R.id.add_title);
            String getTitle = editTitle.getText().toString();
            if (getTitle.isEmpty()) {
                Toast.makeText(this, "タイトルを入力してください。", Toast.LENGTH_SHORT).show();
                return;
            }

            // 質問内容の取得
            EditText editContents = (EditText)findViewById(R.id.add_contents);
            String getContents = editContents.getText().toString();
            if (getContents.isEmpty()) {
                Toast.makeText(this, "質問を入力してください。", Toast.LENGTH_SHORT).show();
                return;
            }

            // 選択肢1の取得
            EditText editOption1 = (EditText)findViewById(R.id.add_first_option);
            String getOption1 = editOption1.getText().toString();
            if (getOption1.isEmpty()) {
                Toast.makeText(this, "選択肢1を入力してください。", Toast.LENGTH_SHORT).show();
                return;
            }

            // 選択肢2の取得
            EditText editOption2 = (EditText)findViewById(R.id.add_second_option);
            String getOption2 = editOption2.getText().toString();
            if (getOption2.isEmpty()) {
                Toast.makeText(this, "選択肢2を入力してください。", Toast.LENGTH_SHORT).show();
                return;
            }

            // 選択肢3の取得
            EditText editOption3 = (EditText)findViewById(R.id.add_third_option);
            String getOption3 = editOption3.getText().toString();
            if (getOption3.isEmpty()) {
                Toast.makeText(this, "選択肢3を入力してください。", Toast.LENGTH_SHORT).show();
                return;
            }

            // 選択肢4の取得
            EditText editOption4 = (EditText)findViewById(R.id.add_fourth_option);
            String getOption4 = editOption4.getText().toString();
            if (getOption4.isEmpty()) {
                Toast.makeText(this, "選択肢4を入力してください。", Toast.LENGTH_SHORT).show();
                return;
            }

            intent.putExtra("title", getTitle);
            intent.putExtra("contents", getContents);
            intent.putExtra("option1", getOption1);
            intent.putExtra("option2", getOption2);
            intent.putExtra("option3", getOption3);
            intent.putExtra("option4", getOption4);

            startActivity(intent);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}