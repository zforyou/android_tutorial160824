package com.example.b.p01_loginform_byjh;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences pref = getSharedPreferences("Login",0);

        final EditText strID = (EditText)findViewById(R.id.editID);
        final EditText strPW = (EditText)findViewById(R.id.editPW);

        Button btn = (Button)findViewById(R.id.myBtn);


        SharedPreferences.Editor editor = pref.edit();
        editor.putString("id", String.valueOf(strID));
        editor.putString("pw", String.valueOf(strPW));

        editor.commit();

    }
}
