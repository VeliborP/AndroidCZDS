package com.example.czds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import com.example.czds.vest;

public class vest extends AppCompatActivity {

    public TextView tekstNaslova,tekstOpisa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vest2);

        tekstNaslova = findViewById(R.id.tekstNaslova);
        tekstOpisa = findViewById(R.id.tekstOpisa);
        Intent myIntent = getIntent(); // gets the previously created intent
        String title = myIntent.getStringExtra("Title"); // will return "FirstKeyValue"
        String description= myIntent.getStringExtra("Description");

        tekstNaslova.setText(Html.fromHtml(title));
        tekstOpisa.setText(Html.fromHtml(description));
    }
}
