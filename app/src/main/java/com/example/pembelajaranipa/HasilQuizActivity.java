package com.example.pembelajaranipa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HasilQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_quiz);

        TextView hasil = (TextView) findViewById(R.id.hasil);
        TextView nilai = (TextView) findViewById(R.id.nilai);

        hasil.setText("Jawaban Benar : " + QuizActivity.benar + "\nJawaban Salah : " + QuizActivity.salah);
        nilai.setText("" + QuizActivity.hasil);
    }

    public void selesai(View view) {
        finish();
        Intent a = new Intent(getApplicationContext(), QuizActivity.class);
        startActivity(a);
    }
}