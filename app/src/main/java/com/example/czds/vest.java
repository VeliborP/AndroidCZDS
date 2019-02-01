package com.example.czds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class vest extends AppCompatActivity {

    public TextView tekstNaslova,tekstOpisa, txtLink, tekstSledeca1, tekstSledeca2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vest2);

        tekstNaslova = findViewById(R.id.tekstNaslova);
        tekstOpisa = findViewById(R.id.tekstOpisa);
        txtLink = findViewById(R.id.txtLink);
        tekstSledeca1 = findViewById(R.id.tekstSledeca1);
        tekstSledeca2 = findViewById(R.id.tekstSeldeca2);

        Intent myIntent = getIntent();
        String title = myIntent.getStringExtra("Title");
        String description= myIntent.getStringExtra("Description");
        String link = myIntent.getStringExtra("Link");
        String sledeca1= myIntent.getStringExtra("SledecaVest1");
        String sledeca2= myIntent.getStringExtra("SledecaVest2");

        tekstNaslova.setText(Html.fromHtml(title));
        tekstOpisa.setText(Html.fromHtml(description));
        txtLink.setText(link);
        tekstSledeca1.setText(sledeca1);
        tekstSledeca2.setText(sledeca2);
    }
}
