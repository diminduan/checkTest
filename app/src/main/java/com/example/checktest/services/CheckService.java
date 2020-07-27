package com.example.checktest.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;


import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;

public class CheckService extends Service {


    public class CheckBinder extends Binder{

//        public CheckService getService(){
//            return CheckService.this;
//        }

        public void getNowTime(){
            long currentTime = System.currentTimeMillis();
            String timeNow = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentTime);
            Toast.makeText(getApplicationContext(),"北京时间：" + timeNow,Toast.LENGTH_SHORT).show();
        }

    }

    private CheckBinder cbinder = new CheckBinder();




    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("checkService", "Get onBind :)");
        return cbinder;
    }

    public void onDestroy(){
        super.onDestroy();
        Log.d("checkService", "Get onDestroy :)");
    }


}
