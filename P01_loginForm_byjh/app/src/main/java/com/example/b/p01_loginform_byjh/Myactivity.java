package com.example.b.p01_loginform_byjh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Myactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myactivity);

        String strID = getIntent().getStringExtra("id");
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Hello "+strID);
    }
}