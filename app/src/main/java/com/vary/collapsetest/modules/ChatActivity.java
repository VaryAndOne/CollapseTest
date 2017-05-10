package com.vary.collapsetest.modules;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hyphenate.EMCallBack;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMTextMessageBody;
import com.vary.collapsetest.R;

import java.util.List;

/**
 * Created by Administrator on 2017-05-09.
 */

public class ChatActivity extends AppCompatActivity implements EMMessageListener{

    // 聊天信息输入框
    private EditText mInputEdit;
    // 发送按钮
    private Button mSendBtn;

    // 显示内容的 TextView
    private TextView mContentText;

    // 当前聊天的 ID
    private String mChatId = "15738040549377";

    private static final String TAG = ChatActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        mInputEdit = (EditText) findViewById(R.id.ec_edit_message_input);
        mSendBtn = (Button) findViewById(R.id.ec_btn_send);
        mContentText = (TextView) findViewById(R.id.ec_text_content);

        mSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = mInputEdit.getText().toString();
                EMMessage message = EMMessage.createTxtSendMessage(content, mChatId);
                message.setChatType(EMMessage.ChatType.GroupChat);
                EMClient.getInstance().chatManager().sendMessage(message);
                mContentText.setText(mContentText.getText() + "\n" + content);
                message.setMessageStatusCallback(new EMCallBack() {
                    @Override
                    public void onSuccess() {
                        Log.e(TAG,"消息发送成功");
                    }

                    @Override
                    public void onError(int i, String s) {

                    }

                    @Override
                    public void onProgress(int i, String s) {

                    }
                });
            }
        });
    }

    @Override
    public void onMessageReceived(List<EMMessage> list) {
        // 循环遍历当前收到的消息
        for (EMMessage message : list) {
            mContentText.setText(mContentText.getText() + "\n" + ((EMTextMessageBody)message.getBody()).getMessage());
        }
    }

    @Override
    public void onCmdMessageReceived(List<EMMessage> list) {

    }

    @Override
    public void onMessageRead(List<EMMessage> list) {

    }

    @Override
    public void onMessageDelivered(List<EMMessage> list) {

    }

    @Override
    public void onMessageChanged(EMMessage emMessage, Object o) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        // 添加消息监听
        EMClient.getInstance().chatManager().addMessageListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 移除消息监听
        EMClient.getInstance().chatManager().removeMessageListener(this);
    }
}
