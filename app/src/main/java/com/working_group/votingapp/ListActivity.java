package com.working_group.votingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.working_group.votingapp.Datasources.Api.ApiClient;

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

    private void viewEnqueteList(JSONObject result) {
        ListView listView = new ListView(this);
        setContentView(listView);
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
