package com.example.checktest.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.checktest.R;
import com.example.checktest.recevier.LoginrepeatRecevier;


public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button login_repeat;
    private LocalBroadcastManager broadcastManager;
    private LoginrepeatRecevier receiver;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        bindViews();

        broadcastManager = LocalBroadcastManager.getInstance(this);
        receiver = new LoginrepeatRecevier();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.checktest.receiver.LOGIN_REPEAT");
        broadcastManager.registerReceiver(receiver, intentFilter);



    }

    private void bindViews() {
        login_repeat = findViewById(R.id.repeat_btn);
        login_repeat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.repeat_btn:
                Intent intent = new Intent("com.example.checktest.receiver.LOGIN_REPEAT");
                broadcastManager.sendBroadcast(intent);
        }
    }


    public void onDestroy(){
        super.onDestroy();
        broadcastManager.unregisterReceiver(receiver);
    }
}
