package com.example.b.p01_loginform_byjh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        SharedPreferences pref = getSharedPreferences("Login",0);
//
//        final EditText strID = (EditText)findViewById(R.id.editID);
//        final EditText strPW = (EditText)findViewById(R.id.editPW);
//
//        Button btn = (Button)findViewById(R.id.myBtn);
//
//
//        SharedPreferences.Editor editor = pref.edit();
//        editor.putString("id", String.valueOf(strID));
//        editor.putString("pw", String.valueOf(strPW));
//
//        editor.commit();
        editId = (EditText) findViewById(R.id.editID);
    }

    public void onLoginClick(View v){
        String strId = editId.getText().toString();
        Intent intent = new Intent(MainActivity.this, Myactivity.class);
        intent.putExtra("id", strId);
        startActivity(intent);
    }
}
