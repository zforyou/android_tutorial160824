package com.example.b.a12_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestDBHandler testDBHandler = new TestDBHandler(this);
        testDBHandler.insert("kim", "seoul", 20);
        testDBHandler.insert("가나다", "인천", 21);
        testDBHandler.insert("john", "LA", 22);
        testDBHandler.insert("park", "부산", 23);

        testDBHandler.delete("kim");
        testDBHandler.update("john", 33);

        testDBHandler.showAllData();
    }
}
