package com.working_group.votingapp.Datasources.Api;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class ApiClient extends AsyncTask<Void, Void, JSONObject> {

    private AsyncCallback mAsyncCallback = null;
    private OkHttpClient client = new OkHttpClient();
    private Request request;

    public interface AsyncCallback {
        void postExecute(JSONObject result);
    }

    public ApiClient(AsyncCallback _asyncCallback) {
        mAsyncCallback = _asyncCallback;
    }

    @Override
    protected JSONObject doInBackground(Void... _params) {
        JSONObject resJson = null;
        try {
            String result = run(request);
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

    public void get(String uri) {
        request = new Request.Builder()
                .url(uri)
                .build();

        execute();
    }

    public void post(String uri, JSONObject body) {
        MediaType MIMEType= MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create (MIMEType, body.toString());
        request = new Request.Builder().url(uri).post(requestBody).build();

        execute();
    }

    // OKHttpを使った通信処理
    private String run(Request request) throws IOException {
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}