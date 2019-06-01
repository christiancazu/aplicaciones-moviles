package com.utp.app;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.utp.app.adapter.SongAdapter;
import com.utp.app.model.Song;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class PlayList extends AppCompatActivity {

    ArrayList<Song> songs;

    RecyclerView rvSongs;
    SongAdapter songAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);

        // content_main
        rvSongs = findViewById(R.id.rv_songs);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvSongs.setLayoutManager(llm);
        //

        setSongNamesOnResRawToSongList();
        initSongAdapter();

        /* String songName = getResources().getResourceEntryName(R.raw.zyzz_ringtone);*/
    }

    protected void initSongAdapter() {
        songAdapter = new SongAdapter(songs);
        rvSongs.setAdapter(songAdapter);
    }

    protected void setSongNamesOnResRawToSongList() {
        Field[] fields = R.raw.class.getFields();

        songs = new ArrayList<>();

        MediaPlayer mediaPlayer;

        for (int i = 0; i < fields.length; i++) {
            mediaPlayer = MediaPlayer.create(this, getResId(fields[i].getName()));
            songs.add(new Song(fields[i].getName(), mediaPlayer.getDuration()));
        }
    }

    public void selectSong(View v) {
        int itemPosition = rvSongs.getChildViewHolder(v).getAdapterPosition();

        Intent intent = new Intent(this, MusicPlayer.class);
        intent.putExtra("song", songs.get(itemPosition));
        startActivity(intent);
    }

    protected int getResId(String songName) {
        return getResources().getIdentifier(songName, "raw",this.getPackageName());
    }
}
