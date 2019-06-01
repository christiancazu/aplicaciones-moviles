package com.utp.app;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.utp.app.model.Song;
import com.utp.app.model.User;

import java.util.ArrayList;

public class MusicPlayer extends AppCompatActivity {

    Song song;
    ImageButton btnPlayPause;
    MediaPlayer mediaPlayer;

    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;

    Toast toast;

    boolean isInit = false;

    float aux = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        initBtnPlay();

        initSelectedSong();

        initResSongWithSelectedSong();

        toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        initSensor();

        start();
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

    private void initSensor() {
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

                if (!isInit) {
                    toastMessage(Float.toString(event.values[0]));
                    aux = event.values[0];
                    isInit = true;
                }
                if (aux != event.values[0]) {
                    if (event.values[0] > 5) {
                        mediaPlayer.start();
                        btnPlayPause.setImageResource(R.drawable.ic_pause);
                    } else {
                        mediaPlayer.pause();
                        btnPlayPause.setImageResource(R.drawable.ic_play);
                    }
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        };
    }

    public void start() {
        sensorManager.registerListener(sensorEventListener, sensor, 2000 * 1000);
    }

    public void stop() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        sensorManager.unregisterListener(sensorEventListener);
    }

    public void addToList(View v) {
        //User user = ((Global) this.getApplication()).getUser();
        //ArrayList<Song> songs = new ArrayList<>();
        //songs.add(song);
        //user.setSong(song.getName());

        ((Global) this.getApplication()).getUser().setSong(song.getName());

        Toast.makeText(this, song.getName(), Toast.LENGTH_SHORT).show();
    }

    public void toastMessage(String msg) {
        toast.setText(msg);
        toast.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        stop();
    }
}
