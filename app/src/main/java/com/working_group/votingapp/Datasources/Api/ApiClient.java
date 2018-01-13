package com.working_group.votingapp.Datasources.Api;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiClient extends AsyncTask<String, Void, JSONObject> {

    private AsyncCallback mAsyncCallback = null;
    private OkHttpClient client = new OkHttpClient();

    public interface AsyncCallback {
        void postExecute(JSONObject result);
    }

    public ApiClient(AsyncCallback _asyncCallback) {
        mAsyncCallback = _asyncCallback;
    }

    @Override
    protected JSONObject doInBackground(String... _uri) {
        JSONObject resJson = null;
        try {
            String result = run(_uri[0]);
            resJson = new JSONObject(result);
        } catch(IOException e) {
            e.printStackTrace();
        } catch(JSONException e) {
            e.printStackTrace();
        }
        return resJson;
    }

    @Override
    protected void onPostExecute(JSONObject _result) {
        super.onPostExecute(_result);
        mAsyncCallback.postExecute(_result);
    }

    public void get(String... _uri) {
        execute(_uri);
    }

    // OKHttpを使った通信処理
    private String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}