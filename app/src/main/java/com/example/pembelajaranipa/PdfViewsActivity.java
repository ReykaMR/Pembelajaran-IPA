package com.example.pembelajaranipa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfViewsActivity extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_views);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Halaman PDF");
        }

        pdfView = findViewById(R.id.pdfView);
        int pos = getIntent().getIntExtra("position", 0);

        if (pos == 0) {
            pdfView.fromAsset("materi1.pdf").load();
        } else if (pos == 1) {
            pdfView.fromAsset("materi2.pdf").load();
        } else if (pos == 2) {
            pdfView.fromAsset("materi3.pdf").load();
        } else if (pos == 3) {
            pdfView.fromAsset("materi4.pdf").load();
        } else if (pos == 4) {
            pdfView.fromAsset("materi5.pdf").load();
        } else if (pos == 5) {
            pdfView.fromAsset("materi6.pdf").load();
        } else if (pos == 6) {
            pdfView.fromAsset("materi7.pdf").load();
        } else if (pos == 7) {
            pdfView.fromAsset("materi8.pdf").load();
        } else if (pos == 8) {
            pdfView.fromAsset("materi9.pdf").load();
        } else if (pos == 9) {
            pdfView.fromAsset("materi10.pdf").load();
        } else if (pos == 10) {
            pdfView.fromAsset("materi11.pdf").load();
        } else if (pos == 11) {
            pdfView.fromAsset("materi12.pdf").load();
        } else if (pos == 12) {
            pdfView.fromAsset("materi13.pdf").load();
        } else if (pos == 13) {
            pdfView.fromAsset("materi14.pdf").load();
        } else if (pos == 14) {
            pdfView.fromAsset("materi15.pdf").load();
        } else if (pos == 15) {
            pdfView.fromAsset("materi16.pdf").load();
        } else if (pos == 16) {
            pdfView.fromAsset("materi17.pdf").load();
        } else if (pos == 17) {
            pdfView.fromAsset("materi18.pdf").load();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                super.onOptionsItemSelected(item);
        }
        return true;
    }
}