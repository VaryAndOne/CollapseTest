package com.vary.collapsetest.modules;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.vary.collapsetest.R;
import com.vary.collapsetest.modules.fragment.CameraFragment;

/**
 * Created by Administrator on 2017-04-26.
 */

public class MediaActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new CameraFragment()).commit();
        }
    }
}
