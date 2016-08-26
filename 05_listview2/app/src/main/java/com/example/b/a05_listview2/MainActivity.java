package com.example.b.a05_listview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    class MyData{
        public MyData(int imgId, String title, String desc) {
            this.imgId = imgId;
            this.title = title;
            this.desc = desc;
        }

        int imgId;
        String title;
        String desc;
    }

    ArrayList<MyData> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView)findViewById(R.id.listView);

        for(int i= 0; i< 30; i++){
            list.add(new MyData(R.mipmap.ic_launcher,
                    "title" + i,
                    "desc" + i));
        }

        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);
    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.item_view, null);
            }

            MyData data = list.get(position);

            TextView titleTextView = (TextView) convertView.findViewById(R.id.titleView);
            TextView descTextView = (TextView) convertView.findViewById(R.id.descView);
            ImageView iconView = (ImageView) convertView.findViewById(R.id.iconView);

            titleTextView.setText(data.title);
            descTextView.setText(data.desc);
            iconView.setImageResource(data.imgId);

            return convertView;
        }
    }
}
