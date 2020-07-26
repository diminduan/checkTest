package com.example.checktest.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.checktest.BaseActivity;
import com.example.checktest.R;


public class LoginActivity extends BaseActivity implements View.OnClickListener{

    String TAG = "LoginActivity";
    private EditText user_edit;
    private EditText pwd_edit;
    private Button login_btn;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d(String.valueOf(getApplicationContext()), "<------- apply onCreate ------>");
        preferences = getSharedPreferences("user_data", Context.MODE_PRIVATE);
        bindViews();
    }

    protected void onStart(){
        super.onStart();
        Log.d(TAG, "<------- apply onStart ------->");
        //获取默认数据》》记住账号密码
        if (!preferences.getString("user","").equals("")){
            Log.d(TAG, "onStart: user_edit" + preferences.getString("user",""));
            user_edit.setText(preferences.getString("user",""));
            pwd_edit.setText(preferences.getString("pwd",""));
        }
    }

    /**
     * 绑定控件
     */
    private void bindViews() {
        user_edit = findViewById(R.id.user_edit);
        pwd_edit = findViewById(R.id.pwd_edit);
        login_btn = findViewById(R.id.login_btn);
        login_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String user_name = user_edit.getText().toString();
        String user_pwd = pwd_edit.getText().toString();
        editor = preferences.edit();
        editor.putString("user", user_name);
        editor.putString("pwd", user_pwd);
        editor.commit();
        if (user_name.equals("ddm") && user_pwd.equals("123")){
            startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
        }else {
            Toast.makeText(getApplicationContext(),"sd",Toast.LENGTH_SHORT).show();
        }


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
