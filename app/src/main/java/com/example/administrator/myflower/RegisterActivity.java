package com.example.administrator.myflower;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/6/30 0030.
 */
public class RegisterActivity extends Activity {

    private String password;
    private TextView tv;
    private String username=null;
    private SharedPreferences.Editor editor;
    private String checkpassword=null;
    private String email=null;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_register);


//        String info = "info";
//        SharedPreferences sp = getSharedPreferences(info, 0);
//        editor = sp.edit();
//
//        EditText et_register_username= (EditText) findViewById(R.id.et_register_username);
//        username = et_register_username.getText().toString();
//        initpassword();
//        initCheckPassword();
//        initEmail();
//        initbutton();
    }


//
//    private String initCheckPassword() {
//
//        tv = (TextView) findViewById(R.id.tv_email);
//        EditText et_check_password = (EditText) findViewById(R.id.et_check_password);
//
//        String checkPassword = et_check_password.getText().toString();
//        if (!Objects.equals(checkPassword, password)) {
//            et_check_password.setText("");
//        }else {
//            checkpassword= checkPassword;
//        }
//        return checkpassword;
//    }
//
//    private void initEmail() {
//        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
//        EditText et_email = (EditText) findViewById(R.id.et_email);
//        String mEmail = et_email.getText().toString();
//        Pattern p = Pattern.compile(str);
//        Matcher matcher = p.matcher(mEmail);
//
//        if (et_email.isClickable()) {
//            if (TextUtils.isEmpty(mEmail)) {
//                tv.setText(R.string.false_text);
//
//            } else if (!matcher.matches()) {
//                et_email.setText("");
//            }else {
//                email=mEmail;
//            }
//        }
//    }
//
//
//
//    private void initpassword() {
//        EditText et_register_password = (EditText) findViewById(R.id.et_register_password);
//
//        password = et_register_password.getText().toString();
//
//
//    }
//
//
//    private void initbutton() {
//        Button btn= (Button) findViewById(R.id.btn_sure);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                    editor.putString("userName", username);
//                    editor.putString("password", checkpassword);
//                    editor.commit();
//                finish();
//
//
//            }
//        });
//    }


}
