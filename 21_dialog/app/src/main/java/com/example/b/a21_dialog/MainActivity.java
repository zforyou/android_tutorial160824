package com.example.b.a21_dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Context context;
    private static final int MY_DIALOG = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if( id == MY_DIALOG ){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("TITLE");
            builder.setMessage("MESSAGE");
            builder.setIcon(R.mipmap.ic_launcher);
//            builder.setCancelable(false);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Button btn = (Button) findViewById(R.id.btnDialog);
                    if( btn != null){
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            MyPopup myPopup = new MyPopup(MainActivity.this);
                            myPopup.show();
                        }
                    });
                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.setView(R.layout.dialog_layout);
            return builder.create();
        }
        return null;
    }

    public void onBtnClick(View v){
        showDialog(MY_DIALOG);
//        MyPopup myPopup = new MyPopup(MainActivity.this);
//        myPopup.show();
    }
}
