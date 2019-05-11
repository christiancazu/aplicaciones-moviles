package com.utp.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;

import com.utp.app.model.Song;

public class MusicPlayer extends AppCompatActivity {

    Song song;
    ImageButton btnPlayPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        initBtnPlay();

        initSelectedSong();
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
