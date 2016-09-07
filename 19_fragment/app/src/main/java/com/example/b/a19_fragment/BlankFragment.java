package com.example.b.a19_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_blank, container, false);
        final TextView texrtView = (TextView) v.findViewById(R.id.textViewCounter);
        Button btnIncrease = (Button) v.findViewById(R.id.btnIncrease);
        btnIncrease.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int val = Integer.parseInt(texrtView.getText().toString());
                val++;
                texrtView.setText(""+val);
            }
        });
        return v;
    }

}
