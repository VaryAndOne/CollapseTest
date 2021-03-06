package com.vary.collapsetest.modules;

/**
 * Created by Administrator on 2017-05-19.
 */

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.vary.collapsetest.R;
import com.vary.collapsetest.modules.widget.media.AndroidMediaController;
import com.vary.collapsetest.modules.widget.media.IjkVideoView;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class  VideoPlayerActivity extends AppCompatActivity {
    IjkVideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
//        Button button = (Button) findViewById(R.id.fullscreen);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setOrientation(getResources().getConfiguration().orientation);
//            }
//        });
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        videoView = (IjkVideoView) findViewById(R.id.ijkPlayer);
        AndroidMediaController controller = new AndroidMediaController(this, false);
        videoView.setMediaController(controller);
//        String url = "https://wdl.wallstreetcn.com/41aae4d2-390a-48ff-9230-ee865552e72d";
//         String url = "http://o6wf52jln.bkt.clouddn.com/演员.mp3";
         String url = Environment.getExternalStorageDirectory().getAbsolutePath() + "/"
                 +"wsffmpegcamera.mp4";
        videoView.setVideoURI(Uri.parse(url));
        videoView.start();
    }

    private void setOrientation(int orientation) {
        if (orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPause() {
        super.onPause();
        videoView.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        IjkMediaPlayer.native_profileEnd();
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoView.resume();
    }
}
