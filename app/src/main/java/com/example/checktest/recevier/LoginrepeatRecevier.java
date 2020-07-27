package com.example.checktest.recevier;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.view.WindowManager;
import android.widget.Toast;

import com.example.checktest.R;
import com.example.checktest.activity.LoginActivity;
import com.example.checktest.utils.ActivityCollector;

public class LoginrepeatRecevier extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Alert");
        builder.setIcon(R.mipmap.alert);
        builder.setMessage("WRONGING! Your account is login elsewhere!");
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActivityCollector.finishAll();
                Intent intent1 = new Intent(context, LoginActivity.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent1);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_TOAST);
        dialog.show();
        Toast.makeText(context, "收到告白啦~", Toast.LENGTH_SHORT).show();
    }
}
