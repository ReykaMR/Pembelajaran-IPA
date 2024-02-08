package com.example.pembelajaranipa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    TextView quiz;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    String[] pertanyaan_quiz = new String[] {
            "1. Persendian yang memungkinkan terjadinya gerakan ke segala arah disebut sendi ….",
            "2. Berikut ini adalah ciri-ciri otot polos, kecuali ….",
            "3. Struktur pada laring yang berfungsi untuk mencegah masukknya partikel makanan tau minuman ke dalam laring dan trakea adalah .....",
            "4. Berikut ini merupakan upaya dalam menjaga kesehatan sistem pernapasan manusia adalah .....",
            "5. Penyakit pada sistem pencernaan yang disebabkan oleh penyerapan air yang berlebihan oleh usus besar hingga menyebabkan sulit buang air besar disebut ...."
    };

    String[] pilihan_jawaban = new String[] {
            "Peluru", "Engsel", "Pelana", "Putar",
            "Pada Usus", "Berbentuk Gelendong", "Menempel Pada Rangka", "Bekerja di Luar Kesadaran",
            "Silia", "Tonsil", "Epiglotis", "Pita Suara",
            "Saling Bertukar Masker Bekas Pakai", "Berolahraga di Malam Hari", "Duduk di Daerah Banyak Asap", "Tidak Merokok",
            "Tukak Lambung", "Diare", "Kolik", "Sembelit"
    };

    String[] jawaban_benar = new String[] {
            "Peluru",
            "Menempel Pada Rangka",
            "Epiglotis",
            "Tidak Merokok",
            "Sembelit"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        quiz = (TextView) findViewById(R.id.quiz);
        rg = (RadioGroup) findViewById(R.id.pilihan);
        PilihanA = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) findViewById(R.id.pilihanB);
        PilihanC = (RadioButton) findViewById(R.id.pilihanC);
        PilihanD = (RadioButton) findViewById(R.id.pilihanD);

        quiz.setText(pertanyaan_quiz[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar = 0;
        salah = 0;
    }

    public void next(View view) {
        if (PilihanA.isChecked() || PilihanB.isChecked() || PilihanC.isChecked() || PilihanD.isChecked()) {
            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
            else salah++;
            nomor++;
            if (nomor < pertanyaan_quiz.length) {
                quiz.setText(pertanyaan_quiz[nomor]);
                PilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                PilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                PilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                PilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);
            } else {
                hasil = benar * 20;
                Intent selesai = new Intent(getApplicationContext(), HasilQuizActivity.class);
                startActivity(selesai);
            }
        } else {
            Toast.makeText(this, "Jawab Terlebih Dahulu", Toast.LENGTH_LONG).show();
        }
    }
}