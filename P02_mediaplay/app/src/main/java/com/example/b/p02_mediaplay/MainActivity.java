package com.example.b.p02_mediaplay;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> list = new ArrayList<>();

//    class MyData {
//        public MyData(int imgId, String title, String artist) {
//            this.imgId = imgId;
//            this.title = title;
//            this.artist = artist;
//        }
//
//        int imgId;
//        String title;
//        String artist;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        final String path = Environment.getExternalStorageDirectory() + "/Genie/music";
//        String path = Environment.getExternalStorageDirectory()+"/Download";
        File dir = new File(path);
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {

//            MediaMetadataRetriever metadataRetriever = new MediaMetadataRetriever();

            String fileName = files[i].getName();

            if (fileName.endsWith(".mp3")) {
//                metadataRetriever.setDataSource("/Genie/music" + fileName);
                list.add(fileName);
//                list.add(new MyData(R.mipmap.ic_launcher,
//                        metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE),
//                        metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST)
//                ));


//                TextView tvMain = (TextView)findViewById(R.id.tvMain);
//                String out = "";

//                out += metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
//                out += "\n";
//                out += metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
//                out += "\n";
//                out += metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
//                out += "\n";
//                out += metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_YEAR);
//                out += "\n";
//                String duration = metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
//                long dur = Integer.parseInt(duration);
//                String second = String.valueOf(dur % 60);
//                String minutes = String.valueOf(dur / 60000);
//                out += "Length : [ " + minutes + "m" + second + "s ]\n";
//
//                metadataRetriever.release();
//
//                tvMain.setText(out);
            }

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, list
        );
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String fileName = list.get(position);
                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                intent.putExtra("path", path+"/"+fileName);
                startActivity(intent);
            }
        });
//        class MyAdapter extends BaseAdapter {
//
//            @Override
//            public int getCount() {
//                return list.size();
//            }
//
//            @Override
//            public Object getItem(int position) {
//                return list.get(position);
//            }
//
//            @Override
//            public long getItemId(int position) {
//                return position;
//            }
//
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                if (convertView == null) {
//                    convertView = getLayoutInflater().inflate(R.layout.item_view, null);
//                }
//
//                String data = list.get(position);
//
//                TextView titleTextView = (TextView) convertView.findViewById(R.id.titleView);
//                TextView descTextView = (TextView) convertView.findViewById(R.id.descView);
//                ImageView iconView = (ImageView) convertView.findViewById(R.id.iconView);
//
//                titleTextView.setText(data.title);
//                descTextView.setText(data.artist);
//                iconView.setImageResource(data.imgId);
//
//                return convertView;
//            }
//
//        }
    }
}
