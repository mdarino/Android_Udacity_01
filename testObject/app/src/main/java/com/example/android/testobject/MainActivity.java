package com.example.android.testobject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView text1 = new TextView(this);
        text1.setText("Hola");
        text1.setTextSize(50);
        setContentView(text1);
    }
}
