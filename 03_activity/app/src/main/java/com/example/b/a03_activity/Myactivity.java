package com.example.b.a03_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Myactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myactivity);

        Intent intent = getIntent();
        String str = intent.getStringExtra("id").toString();


        Toast.makeText(Myactivity.this, "id :"+str, Toast.LENGTH_SHORT).show();
        Toast.makeText(Myactivity.this, "pw :"+intent.getExtras().get("pw").toString(), Toast.LENGTH_SHORT).show();
    }
}
