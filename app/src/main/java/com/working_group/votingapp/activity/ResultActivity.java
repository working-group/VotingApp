package com.working_group.votingapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.working_group.votingapp.Datasources.Api.ApiClient;
import com.working_group.votingapp.R;
import com.working_group.votingapp.entities.Enquete;
import com.working_group.votingapp.entities.Result;
import com.working_group.votingapp.libs.EnqueteListAdapter;
import com.working_group.votingapp.libs.ResultListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("結果画面");

        //intent取得
        Intent intent = getIntent();

        //TODO: intentからアンケートIDを受け取理、APIから結果を取得する
        int enqueteId = intent.getIntExtra("enqueteId",0);
        ApiClient api = new ApiClient(new ApiClient.AsyncCallback() {
            // 実行後 
            public void postExecute(JSONObject result) {
                viewResult(result);
            }
        });
        api.get("http://saitos.wmsol.info:56843/answers/" + enqueteId);

        //TODO: アンケート結果表示（仮）
        TextView title = (TextView) findViewById(R.id.title);
        title.setText(intent.getStringExtra("title"));

        Button returnButton = (Button) findViewById(R.id.return_listActivity);
        returnButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void viewResult(JSONObject answers){
        final ListView listView = (ListView) findViewById(R.id.listView);
        final ResultListAdapter adapter = new ResultListAdapter(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Result result = adapter.getItem(position);
                switch (view.getId()) {
                    //ボタン追加したら書くところ？
//                    case R.id.answer_button:
//                        sendAnswerPage(enquete);
//                        break;
//                    case R.id.result_button:
//                        sendResultPage(enquete);
//                        break;
                }
            }
        });

        try {
            JSONArray answersJson = answers.getJSONArray("answers");

            for (int i=0; i<answersJson.length(); i++) {
                JSONObject json = answersJson.getJSONObject(i);

                int itemId = json.getInt("item_id");
                String comment = json.getString("comment");

                Result result = new Result();
                result.setItemId(itemId);
                result.setComment(comment);
                adapter.add(result);
            }
            listView.setAdapter(adapter);
        }catch(JSONException e) {
            e.printStackTrace();
        }
    }
}
