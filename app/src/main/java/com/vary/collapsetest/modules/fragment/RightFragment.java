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

import com.vary.collapsetest.R;
import com.vary.collapsetest.modules.ChatActivity;
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
                Intent intent = new Intent(getActivity(), ChatActivity.class);
                startActivity(intent);
            }
        });
        return layout;
    }
}
