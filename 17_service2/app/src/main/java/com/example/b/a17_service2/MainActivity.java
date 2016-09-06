package com.example.b.a17_service2;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean isBind;

    MyService myService;
    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.MyBinder myBinder = (MyService.MyBinder) service;
            myService = myBinder.getService();
            isBind = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBind = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, MyService.class);
        bindService(intent, connection, BIND_AUTO_CREATE);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(isBind)
            unbindService(connection);
    }

    public void onBtnClick(View v){
        int number = myService.getRandomNumber();
        Toast.makeText(MainActivity.this, "random : "+number, Toast.LENGTH_LONG).show();
    }
}
