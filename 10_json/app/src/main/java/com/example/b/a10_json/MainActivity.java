package com.example.b.a10_json;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String str = "[ {'name':'kim', 'tel':'010-1111-2222'}," +
            "{'name':'park', 'tel':'010-3333-4444'}," +
            "{'name':'lee', 'tel':'010-5555-6666'}]";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
