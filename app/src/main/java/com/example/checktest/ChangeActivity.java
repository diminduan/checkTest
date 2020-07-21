package com.example.checktest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.checktest.services.MyService;

public class ChangeActivity extends AppCompatActivity {

    String TAG = "<<< ChangeActivity >>>";

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        Log.d(TAG, "<------- apply onCreate -------> ");

        final Button submit_btn = findViewById(R.id.btn2);
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChangeActivity.this,SubmitActivity.class));

                stopService(submit_btn);
            }
        });

//        TextView change_text = findViewById(R.id.text1);
//        change_text.setText("change");

    }

    private void stopService(View view) {
        stopService(new Intent(getBaseContext(), MyService.class));
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
