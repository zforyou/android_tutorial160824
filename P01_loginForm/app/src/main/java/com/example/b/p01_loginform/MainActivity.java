package com.example.b.p01_loginform;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int MY_REQ_NUM = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnNewActivity = (Button)findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyloginForm.class);
                String strID = String.valueOf(findViewById(R.id.editID));
                intent.putExtra("id", strID);
                String strPW = String.valueOf(findViewById(R.id.editPW));
                intent.putExtra("pw", strPW);
                startActivity(intent);
                startActivityForResult(intent, MY_REQ_NUM);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == MY_REQ_NUM){
            if(resultCode == RESULT_OK){
//                String strResult = data.getStringExtra("myResult");
//                Toast.makeText(MainActivity.this, "myResult :"+strResult, Toast.LENGTH_SHORT).show();
            }
        }
    }
}