package com.example.checktest;

import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.checktest.utils.ActivityCollector;

public class BaseActivity extends AppCompatActivity {

    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK){
            if ((System.currentTimeMillis() - exitTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出应用", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                ActivityCollector.finishAll();
                System.exit(0);
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
