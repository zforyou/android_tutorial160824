package com.example.b.a24_notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onBtnClick(View v){
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                NotificationManager notificationManager =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Intent intent = new Intent(MainActivity.this, Newactivity.class);
                PendingIntent pIntent = PendingIntent.getActivity(
                        MainActivity.this, 0, intent, 0);

                Bitmap bitmap = BitmapFactory.decodeResource(
                        getResources(), R.drawable.lighthouse);

                Notification notification =
                        new NotificationCompat.Builder(MainActivity.this)
                                .setContentTitle("TITLE")
                                .setContentText("TEXT")
                                .setSubText("SUBTEXT")
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setLargeIcon(bitmap)
                                .setContentIntent(pIntent)
                                .build();


                notificationManager.notify(1234, notification);
            }
        }, 3000);
    }
}
