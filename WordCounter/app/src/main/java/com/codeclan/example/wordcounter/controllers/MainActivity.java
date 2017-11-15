package com.codeclan.example.wordcounter.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.codeclan.example.wordcounter.R;
import com.codeclan.example.wordcounter.models.WordCounter;
import com.codeclan.example.wordcounter.models.WordCounterExtended;

/**
 * Created by sandy on 26/10/2016.
 */
public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button buttonWordCount;
    Button buttonConcordance;
    WordCounter wordCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.text_to_scan);
        buttonWordCount = (Button) findViewById(R.id.button_scan);
        buttonConcordance = (Button) findViewById(R.id.button_concordance);
        textView = (TextView) findViewById(R.id.text_result);

        wordCounter = new WordCounter();
    }

    public void onWordCountButtonClick(View view) {
//        String textToScan = editText.getText().toString();
//        Log.d("WordCounter", "Counting words in : '" + textToScan + "'");
//
//        int numberOfWords = WordCounter.getCount(textToScan);
//
//        textView.setText(Integer.toString(numberOfWords) + " words entered");
        Intent intent = new Intent(this, CountActivity.class);
        WordCounter wordcounter = new WordCounter();
        String textToScan = editText.getText().toString();
        int result = wordcounter.getCount(textToScan);
        intent.putExtra("WordCount", result);
        startActivity(intent);

    }

    public void onConcordanceButtonClick(View view) {
        String textToScan = editText.getText().toString();
        Log.d("WordCounter", "Creating concordance for : '" + textToScan + "'");

        WordCounterExtended wordCounter = new WordCounterExtended(textToScan);
        textView.setText(wordCounter.toString());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.action_settings) {
//
            Intent intent = new Intent(this, settingsActivity.class);
            startActivity(intent);
        }
        return true;

    }
}
