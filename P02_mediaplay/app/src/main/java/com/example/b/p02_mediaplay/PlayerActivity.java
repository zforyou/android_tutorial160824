package com.example.b.p02_mediaplay;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;

/**
 * Created by b on 2016-09-05.
 */
public class PlayerActivity extends AppCompatActivity{
    MediaPlayer mp = null;
    String path = "";
    SeekBar seekBar;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        path = getIntent().getStringExtra("path");
    }
    public void onPlayClick(View v){
        stopMP();
        mp = new MediaPlayer();
        try {
            mp.setDataSource(path);
            mp.prepare();
            mp.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void onStopClick(View v){
        stopMP();
    }

    private void stopMP(){
        if(mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}
