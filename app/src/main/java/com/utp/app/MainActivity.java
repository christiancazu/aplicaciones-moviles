package com.utp.app;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class MainActivity extends Activity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.vv_player);
    }

    public void playLocal(View v) {
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video));
        videoView.start();
    }

    public void playInternal(View v) {
        String url = "android.resource://" + getPackageName() + "/" + R.raw.video;
        videoView.setVideoURI(Uri.parse(url));
        videoView.start();
    }

    public void playExternal(View v) {
        String url = "https://scontent.cdninstagram.com/vp/8b57af3a68ceea7a8d0b7fa39dce59d1/5CE4508A/t50.2886-16/61016544_321814305152618_7283928767922239784_n.mp4?_nc_ht=scontent.cdninstagram.com";
        videoView.setVideoURI(Uri.parse(url));
        videoView.start();
    }
}
