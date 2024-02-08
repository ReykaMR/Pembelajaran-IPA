package com.example.pembelajaranipa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer audio;
    private MediaPlayer effect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnBelajar = findViewById(R.id.btnBelajar);
        Button btnQuiz = findViewById(R.id.btnQuiz);
        Button btnKeluar = findViewById(R.id.btnKeluar);
        ToggleButton toggleButton = findViewById(R.id.sound);

        audio = MediaPlayer.create(this, R.raw.music);
        effect = MediaPlayer.create(this, R.raw.effecttapnotification);

        audio.setLooping(true);
        audio.setVolume(1, 1);
        audio.start();

        btnBelajar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (effect != null) {
                    effect.start();
                }
                // Ganti kode ini sesuai dengan aktivitas pembelajaran
                Intent intent = new Intent(MainActivity.this, MateriPembelajaranActivity.class);
                startActivity(intent);
            }
        });

        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (effect != null) {
                    effect.start();
                }
                // Ganti kode ini sesuai dengan aktivitas kuis
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });

        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (effect != null) {
                    effect.start();
                }
                showDialog();
            }
        });

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (effect != null) {
                    effect.start();
                }
                onToggleClicked(view);
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (audio != null) {
            audio.release();
        }
        if (effect != null) {
            effect.release();
        }
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (audio != null && audio.isPlaying()) {
            audio.pause();
        }
    }

    public void onToggleClicked(View view) {
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            // Stop audio playback
            if (audio != null && audio.isPlaying()) {
                audio.pause();
            }
        } else {
            // Resume audio playback
            if (audio != null && !audio.isPlaying()) {
                audio.start();
            }
        }
    }

    @Override
    public void onBackPressed() {
        showDialog();
    }

    private void showDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle("Keluar dari aplikasi?");
        alertDialogBuilder
                .setMessage("Klik Ya untuk keluar!")
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Stop audio and finish activity
                        if (audio != null && audio.isPlaying()) {
                            audio.stop();
                        }
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
