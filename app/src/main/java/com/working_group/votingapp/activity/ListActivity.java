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
     * 結果ページ
     */
    public void resultAct(View view) {

        Intent intent = new Intent(getApplication(), ResultActivity.class);
        startActivity(intent);
    }
}
