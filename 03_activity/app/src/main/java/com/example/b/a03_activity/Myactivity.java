package com.example.b.a03_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        Button btnFinish = (Button)findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("myResult", "abcdef");
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
