package com.example.czds;

import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Kontakt extends AppCompatActivity {

    public TextView tekstNaslovaKontakta,tekstPodatak1, tekstPodatak2, tekstaPodatak3, tekstPodatak4;
    private EditText user_name, email, message;
    private String Name, Email, Message;
    private ImageView topDrawLine, topDrawCorner;
    Button contbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        tekstNaslovaKontakta = findViewById(R.id.txtTitle);
        tekstPodatak1 = findViewById(R.id.txtContactData1);
        tekstPodatak2 = findViewById(R.id.txtContactData2);
        tekstaPodatak3 = findViewById(R.id.txtContactData3);
        tekstPodatak4 = findViewById(R.id.tekstSeldeca2);

       topDrawLine = findViewById(R.id.top_line);
       topDrawCorner = findViewById(R.id.top_corner);

        user_name = findViewById(R.id.user_name);
        email = findViewById(R.id.email);
        message = findViewById(R.id.message);
        contbtn = (Button) findViewById(R.id.contbtn);
        contbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendValidation();
            }
        });
    }

        public void sendValidation() {

            intialize();
            if (!validate()) {

                Toast.makeText(this, "Morate popuniti sva polja ispravno", Toast.LENGTH_SHORT).show();
            } else {
                onSignupSuccess();
            }
        }

            public void onSignupSuccess(){

                    //TODO what will go after the valid input
            }

            public boolean validate(){
                boolean valid = true;
                if(Name.isEmpty()||Name.length()>32){
                    user_name.setError("Molimo Vas unesite ispravno korisnicko ime");
                    valid = false;
                }
                if(Email.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
                    email.setError("Molimo Vas unesite ispravnu email adresu");
                    valid = false;
                }
                if(Message.length()<15) {
                    message.setError("Morate uneti vise karaktera");
                    valid = false;
                }
                return valid;
            }



        public void intialize(){
            Name = user_name.getText().toString().trim();
            Email = email.getText().toString().trim();
            Message = message.getText().toString().trim();

        }

    }

