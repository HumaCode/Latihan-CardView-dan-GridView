package com.example.wisataindonesia.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.wisataindonesia.R;
import com.example.wisataindonesia.model.ModelWisata;

import java.util.ArrayList;

public class AdapterGrid extends RecyclerView.Adapter<AdapterGrid.GridViewHolder>{
    private ArrayList<ModelWisata> dataWisata;

//    constructor
    public AdapterGrid(ArrayList<ModelWisata> dataWisata) {
        this.dataWisata = dataWisata;
    }

    private OnItemClickCallBack callBack;
    public void setOnItemClickCallBack(OnItemClickCallBack callBack) {
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(dataWisata.get(position).getFoto())
                .apply(new RequestOptions().override(350,550))
                .into(holder.ivFotoGrid);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.onItemClicked(dataWisata.get(holder.getAdapterPosition()));
            }
        });
    }



    @Override
    public int getItemCount() {
        return dataWisata.size();
    }

    public interface OnItemClickCallBack {
        void onItemClicked(ModelWisata data);
    }



    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFotoGrid;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);

            ivFotoGrid = itemView.findViewById(R.id.iv_foto_grid);
        }
    }
}
