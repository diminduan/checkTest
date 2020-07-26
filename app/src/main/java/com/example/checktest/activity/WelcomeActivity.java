package com.example.checktest.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class WelcomeActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Toast.makeText(getApplicationContext(),"welcome back",Toast.LENGTH_SHORT).show();
    }
}
