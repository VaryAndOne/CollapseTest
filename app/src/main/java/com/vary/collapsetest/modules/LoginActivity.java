package com.vary.collapsetest.modules;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMGroupManager;
import com.hyphenate.exceptions.HyphenateException;
import com.vary.collapsetest.R;

/**
 * Created by Administrator on 2017-04-24.
 */

public class LoginActivity extends AppCompatActivity {

    // username 输入框
    private EditText mUsernameEdit;
    // 密码输入框
    private EditText mPasswordEdit;

    // 注册按钮
    private TextView mSignUpBtn;
    // 登录按钮
    private TextView mSignInBtn;

    private static final String TAG = LoginActivity.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    /**
     * 初始化界面控件
     */
    private void initView() {

        new Thread(new Runnable() {
            @Override
            public void run() {
//                EMGroupManager.EMGroupOptions option = new EMGroupManager.EMGroupOptions();
//                option.maxUsers = 200;
//                option.style = EMGroupManager.EMGroupStyle.EMGroupStylePublicOpenJoin ;
//
//                try {
//                    EMClient.getInstance().groupManager().createGroup("瞎扯", "装比", new String[]{}, "", option);
//                    Log.e(TAG,"创建群组" );
//                } catch (HyphenateException e) {
//                    e.printStackTrace();
//                }
//
//                try {
//                    EMClient.getInstance().groupManager().destroyGroup(	"15740650455042");//需异步处理
//                    Log.e(TAG,"解散群组" );
//                } catch (HyphenateException e) {
//                    e.printStackTrace();
//                }
            }
        }).start();

        mUsernameEdit = (EditText) findViewById(R.id.ec_edit_username);
        mPasswordEdit = (EditText) findViewById(R.id.ec_edit_password);

        mSignUpBtn = (TextView) findViewById(R.id.ec_btn_sign_up);
        mSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });

        mSignInBtn = (TextView) findViewById(R.id.ec_btn_sign_in);
        mSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }

    private void signUp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String username = mUsernameEdit.getText().toString().trim();
                String password = mPasswordEdit.getText().toString().trim();
                try {
                    EMClient.getInstance().createAccount(username, password);
                    Toast.makeText(LoginActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                } catch (HyphenateException e) {
                    e.printStackTrace();
                    Log.e(TAG,"注册失败" + e.getErrorCode() + " ,"+e.getMessage());
                }
            }
        }).start();
    }

    private void signIn() {
        String username = mUsernameEdit.getText().toString().trim();
        String password = mPasswordEdit.getText().toString().trim();
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(LoginActivity.this, "用户名和密码不能为空", Toast.LENGTH_LONG).show();
            return;
        }
        EMClient.getInstance().login(username, password, new EMCallBack() {

            @Override
            public void onSuccess() {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onError(int i, String s) {
                Log.e(TAG,"登录失败" +  " ,"+s);
            }

            @Override
            public void onProgress(int i, String s) {

            }
        });
    }
}
