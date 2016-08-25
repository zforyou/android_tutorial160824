package com.example.b.a02_widget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText myEdit = (EditText)findViewById(R.id.myEdit);
        Button btnHello = (Button) findViewById(R.id.btnHello);
        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w("Widget", "button clicked!!!");
                String str = myEdit.getText().toString();
                Toast.makeText(MainActivity.this, myEdit.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        final CheckBox myCheckBox = (CheckBox)findViewById(R.id.mycheckBox);
        myCheckBox.setChecked(true);
        myCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "checked", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        RadioGroup myRadioGroup = (RadioGroup)findViewById(R.id.myRadioGroup);
        myRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.myRadio1:
                        Toast.makeText(MainActivity.this, "radio1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.myRadio2:
                        Toast.makeText(MainActivity.this, "radio2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.myRadio3:
                        Toast.makeText(MainActivity.this, "radio3", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
