package com.example.b.a07_asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        class MyAsyncTask extends AsyncTask<Integer,Integer,String>{

            @Override
            protected String doInBackground(Integer... params) {
                int start = params[0];
                for(int i = start; i <100; i++){
                    Log.d("Asynctask", "count : "+1);
                }
                return null;
            }
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyAsyncTask task = new MyAsyncTask();
        task.execute(10);
    }
}
