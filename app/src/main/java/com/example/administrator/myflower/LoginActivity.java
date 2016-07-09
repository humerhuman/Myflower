package com.example.administrator.myflower;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Administrator on 2016/6/30 0030.
 */
public class LoginActivity extends Activity {
    private int requestCode=1;
    private EditText et_username;
    private EditText et_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_login);
//
//        SharedPreferences info = getSharedPreferences("info", 0);
//        String userName = info.getString("userName", null);
//        String password = info.getString("password", null);
//
//        et_username= (EditText) findViewById(R.id.et_username);
//        et_username.setText(userName);
//        et_password= (EditText) findViewById(R.id.et_password);
//        et_password.setText(password);
        Button btn_register= (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        Button btn_login= (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }


}
