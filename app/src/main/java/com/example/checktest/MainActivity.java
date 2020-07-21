package com.example.checktest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.checktest.services.MyService;

public class MainActivity extends AppCompatActivity {
    String TAG = "<<< MainActivity >>>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "<------- apply onCreate ------->");
        final Button change_btn = findViewById(R.id.btn1);
        change_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,ChangeActivity.class));

                startService(change_btn);
            }
        });
    }

    private void startService(View view) {
        startService(new Intent(getBaseContext(), MyService.class));
    }

    /**
     * onStart
     */
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "<------- apply onStart ------->");
    }

    /**
     * onResume
     */
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "<------- apply onResume ------->");
    }

    /**
     * onPause
     */
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "<------- apply onPause ------->");
    }

    /**
     * onStop
     */
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "<------- apply onStop ------->");
    }

    /**
     * onRestart
     */
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "<------- apply onRestart ------->");
    }

    /**
     * onDestroy
     */
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "<------- apply onDestroy ------->");
    }


}
