package com.example.b.a09_xml;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
//        If you want use DomParser open here
//        MyDomParser parser = new MyDomParser(textView);
//        If you want use PullParser open here
        MyPullParser parser = new MyPullParser(textView);
        parser.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1159068000");
    }
}
