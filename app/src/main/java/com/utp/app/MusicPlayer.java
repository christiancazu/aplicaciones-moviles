package com.utp.app;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.utp.app.model.Song;

public class MusicPlayer extends AppCompatActivity {

    Song song;
    ImageButton btnPlayPause;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        initBtnPlay();

        initSelectedSong();

        initResSongWithSelectedSong();

        // #TODO:
        //      timer count regressive
        //      functionality for previous/next buttons
        //      gif animation for content_music_player image background
    }

    public void onPlayPause(View v) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            btnPlayPause.setImageResource(R.drawable.ic_play);
        } else {
            mediaPlayer.start();
            btnPlayPause.setImageResource(R.drawable.ic_pause);
        }
    }

    protected void initResSongWithSelectedSong() {
        int id = getResources().getIdentifier(song.getName(), "raw", this.getPackageName());

        mediaPlayer = MediaPlayer.create(this, id);
    }

    protected void initSelectedSong() {
        song = (Song) getIntent().getSerializableExtra("song");

        TextView tvSongName = findViewById(R.id.tv_song_name);
        TextView tvSongDuration = findViewById(R.id.tv_song_duration);

        tvSongName.setText(song.getName());
        tvSongDuration.setText(song.getDuration());
    }

    protected void initBtnPlay() {
        btnPlayPause = findViewById(R.id.btn_play_pause_song);
        btnPlayPause.setImageResource(R.drawable.ic_play);
    }

}
