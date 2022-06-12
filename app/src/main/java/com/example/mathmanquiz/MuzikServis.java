package com.example.mathmanquiz;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MuzikServis extends Service {

    MediaPlayer mediaPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.backmusic);
        mediaPlayer.setLooping(true); // Set looping
        mediaPlayer.setVolume(100, 100);
    }
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (intent.getAction().equals("PLAY")) {
            if(mediaPlayer.isPlaying() == false) {
                mediaPlayer.start();
              //  Toast.makeText(getApplicationContext(), "Arkaplan sesi açıldı.", Toast.LENGTH_SHORT).show();

            }
        }
        if (intent.getAction().equals("STOP")) {
            this.stopService(intent);
          //  Toast.makeText(getApplicationContext(), "Arkaplan sesi kapatıldı.",    Toast.LENGTH_SHORT).show();

        }

        return startId;
    }
    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();
    }
    @Override
    public void onLowMemory() {
    }
}

