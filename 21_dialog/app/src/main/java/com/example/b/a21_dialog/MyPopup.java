package com.example.b.a21_dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by b on 2016-09-08.
 */
public class MyPopup extends Dialog {
    public MyPopup(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);
        Button btn = (Button) findViewById(R.id.btnDialog);
//        setCanceledOnTouchOutside(false);
//        setCancelable(false);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
