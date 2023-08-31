package com.example.algotapez.Model;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.example.algotapez.R;

public class radioIn extends AppCompatActivity {

    private MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_in);
        initializeMediaPlayer();
    }

    private void initializeMediaPlayer() {
        music = MediaPlayer.create(this, R.raw.sound);
        music.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                releaseMediaPlayer();
            }
        });
    }

    public void musicplay(View v) {
        if (music != null && !music.isPlaying()) {
            music.start();
        }
    }

    public void musicpause(View v) {
        if (music != null && music.isPlaying()) {
            music.pause();
        }
    }

    public void musicstop(View v) {
        if (music != null) {
            music.stop();
            releaseMediaPlayer();
            initializeMediaPlayer();
        }
    }

    private void releaseMediaPlayer() {
        if (music != null) {
            music.release();
            music = null;
        }
    }

    @Override
    protected void onDestroy() {
        releaseMediaPlayer();
        super.onDestroy();
    }
}
