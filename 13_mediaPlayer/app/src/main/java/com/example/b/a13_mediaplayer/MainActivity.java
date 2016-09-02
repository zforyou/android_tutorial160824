package com.example.b.a13_mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp = null;
    SeekBar seekBar;
    private static final int SEEKBAR_CURR_POSITION = 100;
    Handler handler = new Handler(){
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            if(msg.what == SEEKBAR_CURR_POSITION){
                int position = msg.arg1;
                seekBar.setProgress(position);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
    }

    public void onPlayClick(View v){
        if(mp != null) {
            mp.stop();
            mp.release();
        }
        String path = Environment.getExternalStorageDirectory().toString();
        path += "/Genie/music/Water Under The Bridge_Adele.mp3";
//        path += "/Download/Kalimba.mp3";
        mp = new MediaPlayer();

        try {
            mp.setDataSource(path);
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        seekBar.setMax(mp.getDuration());

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int position = mp.getCurrentPosition();
                Message msg = handler.obtainMessage();
                msg.what = SEEKBAR_CURR_POSITION;
                msg.arg1 = position;
                handler.sendMessage(msg);
            }
        });
        th.start();
    }

    public void onStopClick(View v){
        if(mp != null) {
            mp.stop();
            mp.release();
        }
    }

}
