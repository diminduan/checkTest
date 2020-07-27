package com.example.checktest.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class MyService extends Service {
    private String TAG = "MyService";

    public  class Mybinder extends Binder{

        public void testFunc(){
            Toast.makeText(getApplicationContext(), "its just a test function", Toast.LENGTH_SHORT).show();
        }
    }

    private Mybinder mbinder = new Mybinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        Log.d(TAG, "onBind: ");
        return mbinder;

    }

//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId){
//        Toast.makeText(this,"services is start",Toast.LENGTH_SHORT).show();
//        long currentTime = System.currentTimeMillis();
//        String timeNow = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentTime);
//        System.out.println("now time is :" + timeNow);
//        Log.d("Time", "Now time is :" + timeNow);
//        return START_STICKY;
//    }




    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"service is stop",Toast.LENGTH_SHORT).show();
    }
}
