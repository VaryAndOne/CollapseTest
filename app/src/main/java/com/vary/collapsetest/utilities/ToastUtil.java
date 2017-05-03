package com.vary.collapsetest.utilities;

import android.widget.Toast;

import com.vary.collapsetest.app.TkApplication;

/**
 * Created by Administrator on 2017-05-03.
 */

    public class ToastUtil {
        public static void show(String msg){
            Toast.makeText(TkApplication.appContext, msg, Toast.LENGTH_SHORT).show();
        }
    }
