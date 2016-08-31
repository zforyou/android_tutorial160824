package com.example.b.a10_json;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    String str = "[ {'name':'kim', 'tel':'010-1111-2222'}," +
            "{'name':'park', 'tel':'010-3333-4444'}," +
            "{'name':'lee', 'tel':'010-5555-6666'}]";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        localJsonTest();
        internetJsonTest();
    }
    private void internetJsonTest(){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://api.androidhive.info/contacts/", new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    JSONArray array = response.getJSONArray("contacts");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Log.d("contacts", response.toString());
            }
        });
    }

    private void localJsonTest() {
        try {
            JSONArray array = new JSONArray(str);
            for(int i=0; i<array.length(); i++){
                JSONObject obj = array.getJSONObject(i);
                String name = obj.getString("name");
                String tel = obj.getString("tel");
                Log.d("json", name + " "+ tel);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
