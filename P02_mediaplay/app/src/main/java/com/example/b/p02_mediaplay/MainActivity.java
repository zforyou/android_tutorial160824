package com.example.b.p02_mediaplay;

import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> list = new ArrayList<>();

    class MyData{
        public MyDate(int imgId, String title, String artist, String duration){
            this.imgId = imgId;
            this.title = title;
            this.artist = artist;
            this.duration = duration;
        }
        int imgId;
        String title;
        String artist;
        String duration;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String path = Environment.getExternalStorageDirectory()+"/Genie/music";
//        String path = Environment.getExternalStorageDirectory()+"/Download";
        File dir = new File(path);
        File[] files = dir.listFiles();
        for(int i=0; i<files.length; i++){
            String fileName = files[i].getName();
            if(fileName.endsWith(".mp3")){
                list.add(fileName);
                TextView tvMain = (TextView)findViewById(R.id.tvMain);

                MediaMetadataRetriever metadataRetriever = new MediaMetadataRetriever();
                metadataRetriever.setDataSource("/Genie/music");

                String out = "";

        //        out += metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
        //        out += "\n";
                out += metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
                out += "\n";
                out += metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
                out += "\n";
                out += metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_YEAR);
                out += "\n";
                String duration = metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
                long dur = Integer.parseInt(duration);
                String second = String.valueOf(dur % 60);
                String minutes = String.valueOf(dur / 60000);
                out += "Length : [ " + minutes + "m" + second + "s ]\n";

                metadataRetriever.release();

                tvMain.setText(out);
            }

        }

    }
}
