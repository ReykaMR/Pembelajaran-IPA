package com.example.pembelajaranipa;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MateriPembelajaranAdapter extends RecyclerView.Adapter<MateriPembelajaranAdapter.viewHolder> {

    ArrayList<MateriPembelajaranModel> list;
    Context context;

    public MateriPembelajaranAdapter(ArrayList<MateriPembelajaranModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_materi, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final MateriPembelajaranModel model = list.get(position);

        holder.setName.setText(model.getSetName());
        holder.setImage.setImageResource(model.getSetImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PdfViewsActivity.class);
                intent.putExtra("position", position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView setImage;
        TextView setName;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            setImage = itemView.findViewById(R.id.setImage);
            setName = itemView.findViewById(R.id.setName);
        }
    }
}

