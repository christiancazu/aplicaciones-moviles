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
        String url = "https://scontent.cdninstagram.com/vp/d46ccbd350d3b2d4de6addf93307769b/5CD99CFB/t50.2886-16/59667320_372719056675819_3610000207917350912_n.mp4?_nc_ht=scontent.cdninstagram.com";
        videoView.setVideoURI(Uri.parse(url));
        videoView.start();
    }
}
