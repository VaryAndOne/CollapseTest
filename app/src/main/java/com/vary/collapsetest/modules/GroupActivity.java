package com.vary.collapsetest.modules;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;
import com.jaeger.ninegridimageview.NineGridImageView;
import com.vary.collapsetest.R;
import com.vary.collapsetest.modules.adapter.PostAdapter;
import com.vary.collapsetest.mvp.model.Post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    private RecyclerView mRvPostLister;
    private PostAdapter mPostAdapter;

    private List<Post> mPostList;
    private String[] IMG_URL_LIST = {
            "https://pic4.zhimg.com/02685b7a5f2d8cbf74e1fd1ae61d563b_xll.jpg",
            "https://pic4.zhimg.com/fc04224598878080115ba387846eabc3_xll.jpg",
            "https://pic3.zhimg.com/d1750bd47b514ad62af9497bbe5bb17e_xll.jpg",
            "https://pic4.zhimg.com/da52c865cb6a472c3624a78490d9a3b7_xll.jpg",
            "https://pic3.zhimg.com/0c149770fc2e16f4a89e6fc479272946_xll.jpg",
            "https://pic1.zhimg.com/76903410e4831571e19a10f39717988c_xll.png",
            "https://pic3.zhimg.com/33c6cf59163b3f17ca0c091a5c0d9272_xll.jpg",
            "https://pic4.zhimg.com/52e093cbf96fd0d027136baf9b5cdcb3_xll.png",
            "https://pic3.zhimg.com/f6dc1c1cecd7ba8f4c61c7c31847773e_xll.jpg",
    };

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

        mRvPostLister = (RecyclerView) findViewById(R.id.rv_post_list);
        mRvPostLister.setLayoutManager(new LinearLayoutManager(this));

        mPostList = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            List<String> imgUrls = new ArrayList<>();
            imgUrls.addAll(Arrays.asList(IMG_URL_LIST).subList(0, i % 9 + 1));
            Post post = new Post("看图，字不重要。想看大图？抱歉我还没做这个 ( •̀ .̫ •́ )", imgUrls);
            mPostList.add(post);
        }
        mPostAdapter = new PostAdapter(this, mPostList, NineGridImageView.STYLE_FILL);
        mRvPostLister.setAdapter(mPostAdapter);
    }
}
