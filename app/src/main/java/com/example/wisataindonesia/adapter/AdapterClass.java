package com.example.wisataindonesia.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.wisataindonesia.R;
import com.example.wisataindonesia.model.ModelWisata;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.CardViewHolder> {
    private ArrayList<ModelWisata> dataWisata;

    public AdapterClass(ArrayList<ModelWisata> dataWisata) {
        this.dataWisata = dataWisata;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);

        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        ModelWisata wisata = dataWisata.get(position);

        holder.tvNama.setText(wisata.getNama());
        holder.tvLokasi.setText(wisata.getLokasi());

//        Menampilkan foto
        Glide.with(holder.itemView.getContext())
                        .load(wisata.getFoto())
                                .apply(new RequestOptions().override(350,550))
                                        .into(holder.ivFoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namaWisata = dataWisata.get(holder.getAdapterPosition()).getNama();
                Toast.makeText(holder.itemView.getContext(), "Anda Memilih "+namaWisata, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataWisata.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
        ImageView ivFoto;
        TextView tvNama, tvLokasi;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            ivFoto = itemView.findViewById(R.id.iv_foto);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvLokasi = itemView.findViewById(R.id.tv_lokasi);
        }
    }
}
