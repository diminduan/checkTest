package com.example.checktest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.checktest.services.MyService;

public class MainActivity extends BaseActivity {
    String TAG = "<<< MainActivity >>>";
    private MyService.Mybinder mybinder;


    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mybinder = (MyService.Mybinder)service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "<------- apply onCreate ------->");
        Button change_btn = findViewById(R.id.btn1);
        Button test_btn = findViewById(R.id.btn_test);
        change_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,ChangeActivity.class));
                bindService(new Intent(getBaseContext(),MyService.class),connection,BIND_AUTO_CREATE);
            }
        });

        test_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mybinder.testFunc();
            }
        });
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
        unbindService(connection);
        Log.d(TAG, "<------- apply onDestroy ------->");
    }


}
