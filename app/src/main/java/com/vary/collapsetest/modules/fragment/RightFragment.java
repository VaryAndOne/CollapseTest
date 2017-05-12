package com.vary.collapsetest.modules.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;
import com.vary.collapsetest.R;
import com.vary.collapsetest.modules.ECChatActivity;
import com.vary.collapsetest.modules.MainActivity;

/**
 * Created by Administrator on 2017-04-21.
 */

public class RightFragment extends Fragment {

    // 发起聊天
    private Button mStartChatBtn;

    public static RightFragment getInstance(int position){
        RightFragment myFragment = new RightFragment();
        Bundle args = new Bundle();
        args.putInt("position",position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_right, container, false);
        //   textView = (TextView) layout.findViewById(R.id.position);
        Bundle bundle = getArguments();
        if (bundle != null) {
            //         textView.setText("The page Selected is "+bundle.getInt("position"));
        }
        mStartChatBtn = (Button) layout.findViewById(R.id.ec_btn_start_chat);

        mStartChatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转到聊天界面，开始聊天
                Intent intent = new Intent(getActivity(), ECChatActivity.class);
                intent.putExtra(EaseConstant.EXTRA_USER_ID,"vary1");
                intent.putExtra(EaseConstant.EXTRA_CHAT_TYPE, EMMessage.ChatType.Chat);
                startActivity(intent);
            }
        });
        return layout;
    }
}
