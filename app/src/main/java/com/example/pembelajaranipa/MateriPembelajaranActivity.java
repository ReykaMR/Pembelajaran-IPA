package com.example.pembelajaranipa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MateriPembelajaranActivity extends AppCompatActivity {

    ArrayList<MateriPembelajaranModel> list;
    MateriPembelajaranAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_pembelajaran);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Materi Pembelajaran");
        }

        recyclerView = findViewById(R.id.rv_materi_pembelajaran);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        list = new ArrayList<>();
        list.add(new MateriPembelajaranModel("Materi - 1", R.drawable.gambar1));
        list.add(new MateriPembelajaranModel("Materi - 2", R.drawable.gambar2));
        list.add(new MateriPembelajaranModel("Materi - 3", R.drawable.gambar3));
        list.add(new MateriPembelajaranModel("Materi - 4", R.drawable.gambar4));
        list.add(new MateriPembelajaranModel("Materi - 5", R.drawable.gambar5));
        list.add(new MateriPembelajaranModel("Materi - 6", R.drawable.gambar6));
        list.add(new MateriPembelajaranModel("Materi - 7", R.drawable.gambar7));
        list.add(new MateriPembelajaranModel("Materi - 8", R.drawable.gambar8));
        list.add(new MateriPembelajaranModel("Materi - 9", R.drawable.gambar9));
        list.add(new MateriPembelajaranModel("Materi - 10", R.drawable.gambar10));
        list.add(new MateriPembelajaranModel("Materi - 11", R.drawable.gambar11));
        list.add(new MateriPembelajaranModel("Materi - 12", R.drawable.gambar12));
        list.add(new MateriPembelajaranModel("Materi - 13", R.drawable.gambar13));
        list.add(new MateriPembelajaranModel("Materi - 14", R.drawable.gambar14));
        list.add(new MateriPembelajaranModel("Materi - 15", R.drawable.gambar15));
        list.add(new MateriPembelajaranModel("Materi - 16", R.drawable.gambar16));
        list.add(new MateriPembelajaranModel("Materi - 17", R.drawable.gambar17));
        list.add(new MateriPembelajaranModel("Materi - 18", R.drawable.gambar18));

        adapter = new MateriPembelajaranAdapter(list,this);
        recyclerView.setAdapter(adapter);
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