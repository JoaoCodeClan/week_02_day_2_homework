package com.codeclan.example.wordcounter.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.codeclan.example.wordcounter.R;

public class CountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        String result = extras.get("WordCount").toString();
        TextView resultTextView= findViewById(R.id.count_activity);
        resultTextView.setText(result);

    }
}
