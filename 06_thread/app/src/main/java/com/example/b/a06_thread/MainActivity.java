package com.example.b.a06_thread;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;
//    class MyThread extends Thread{
//        @Override
//        public void run() {
//            for(int i=0; i<100; i++) {
//
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                Log.d("MyThread", "count :" +i);
//                btn.setText("count :" +i);
//            }
//        }
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
    }

    public void onBtnClick(View v){
//        MyThread th = new MyThread();
//        th.start();

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<100; i++) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d("MyThread", "count :" +i);
                    btn.setText("count :" +i);
                }
            }
        });
        th2.start();
    }
}
