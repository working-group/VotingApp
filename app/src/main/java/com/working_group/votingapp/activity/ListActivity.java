package com.working_group.votingapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.working_group.votingapp.Datasources.Api.ApiClient;
import com.working_group.votingapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("一覧");
        setContentView(R.layout.activity_list);
        ApiClient api = new ApiClient(new ApiClient.AsyncCallback() {
            // 実行後 
            public void postExecute(JSONObject result) {
                viewEnqueteList(result);
            }
        });
        api.get("http://weather.livedoor.com/forecast/webservice/json/v1?city=400040");
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

    private void viewEnqueteList(JSONObject result) {
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        try {
            JSONArray forecasts = result.getJSONArray("forecasts");

            for (int i=0; i<forecasts.length(); i++) {
                JSONObject json = forecasts.getJSONObject(i);
                String date = json.getString("date");
                arrayAdapter.add(date);
            }
            listView.setAdapter(arrayAdapter);
        } catch(JSONException e) {
            e.printStackTrace();
        }
    }

}
