package com.vary.collapsetest.modules;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;
import com.vary.collapsetest.R;

/**
 * Created by Administrator on 2017-05-13.
 */

public class GroupActivity extends AppCompatActivity {

        // 发起聊天 username 输入框
    private EditText mChatIdEdit;
    // 发起聊天
    private Button mStartChatBtn;
    // 退出登录
    private Button mSignOutBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_right);

        mStartChatBtn = (Button) findViewById(R.id.ec_btn_start_chat);
        mChatIdEdit = (EditText) findViewById(R.id.ec_edit_chat_id);

        mStartChatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转到聊天界面，开始聊天
                String chatId = mChatIdEdit.getText().toString().trim();
                Intent intent = new Intent(GroupActivity.this, ECChatActivity.class);
                intent.putExtra(EaseConstant.EXTRA_USER_ID,chatId);
                intent.putExtra(EaseConstant.EXTRA_CHAT_TYPE, EMMessage.ChatType.Chat);
                startActivity(intent);
            }
        });
    }
}
