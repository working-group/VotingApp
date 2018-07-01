package com.working_group.votingapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.working_group.votingapp.Datasources.Api.ApiClient;
import com.working_group.votingapp.entities.Enquete;
import com.working_group.votingapp.libs.EnqueteListAdapter;
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
        api.get("http://saitos.wmsol.info:56843/enquetes");
    }

    /**
     * 結果画面遷移
     */
    public void sendResultPage(Enquete enquete) {
        Intent intent = new Intent(getApplication(), ResultActivity.class);
        intent.putExtra("enqueteId", enquete.getId());
        //TODO: デバッグコード（titleは詳細からも取れるハズなので渡さなくても良いハズ）
        intent.putExtra("title", enquete.getTitle());
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
    private void sendAnswerPage(Enquete enquete) {
        Intent intent = new Intent(getApplication(), AnswerActivity.class);
        intent.putExtra("enqueteId", enquete.getId());
        //TODO: デバッグコード（titleは詳細からも取れるハズなので渡さなくても良いハズ）
        intent.putExtra("title", enquete.getTitle());
        startActivity(intent);
    }

    private void viewEnqueteList(JSONObject result) {

        final ListView listView = (ListView) findViewById(R.id.listView);
        final EnqueteListAdapter adapter = new EnqueteListAdapter(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Enquete enquete = adapter.getItem(position);
                switch (view.getId()) {
                    case R.id.answer_button:
                        sendAnswerPage(enquete);
                        break;
                    case R.id.result_button:
                        sendResultPage(enquete);
                        break;
                }
            }
        });

        try {
            JSONArray enqueteJSON = result.getJSONArray("enquetes");

            for (int i=0; i<enqueteJSON.length(); i++) {
                JSONObject json = enqueteJSON.getJSONObject(i);
                String title = json.getString("title");
                int id = json.getInt("id");

                Enquete enquete = new Enquete();
                enquete.setId(id);
                enquete.setTitle(title +"についてのアンケート");
                adapter.add(enquete);
            }
            listView.setAdapter(adapter);
        } catch(JSONException e) {
            e.printStackTrace();
        }
    }

}
