package com.example.administrator.myflower;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * Created by Administrator on 2016/6/24 0024.
 */
public class SplashActivity extends Activity {
    private String FIRSTCODE;
    private static final int GO_HOME = 1;
    private static final int GO_GUID = 0;

    public Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int what = msg.what;
            switch (what){
                case GO_HOME:
                    goHome();

                    break;
                case GO_GUID:
                    goGuid();

                    break;
            }
            super.handleMessage(msg);
        }
    };

    private void goGuid() {
        Intent intent = new Intent(this, GuidActivity.class);
        SplashActivity.this.startActivity(intent);
        SplashActivity.this.finish();
    }

    private void goHome() {
        Intent intent = new Intent(this, MainActivity.class);
        SplashActivity.this.startActivity(intent);
        SplashActivity.this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        init();
    }

    private void init() {
//        获得sp实例
        SharedPreferences sp = getSharedPreferences("firstcode", MODE_PRIVATE);

        // 取得相应的值，如果没有该值，说明还未写入，用true作为默认值
        boolean isFirstin = sp.getBoolean(FIRSTCODE, true);

        if (isFirstin){

            //        拿到编辑器
            SharedPreferences.Editor edit = sp.edit();
//        将启动次数存入
            edit.putBoolean(FIRSTCODE,false);
            edit.commit();
            mHandler.sendEmptyMessageDelayed(GO_GUID,1000);

        }else {
            mHandler.sendEmptyMessageDelayed(GO_HOME,1000);

        }

    }
}
