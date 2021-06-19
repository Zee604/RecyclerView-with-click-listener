package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen);
        TextView textView = (TextView) findViewById(R.id.tv);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        textView.setText(String.valueOf("Index Is: "+bundle.getInt("indexIs")));
    }
}