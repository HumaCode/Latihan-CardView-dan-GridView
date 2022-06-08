package com.example.wisataindonesia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.wisataindonesia.adapter.AdapterClass;
import com.example.wisataindonesia.adapter.AdapterGrid;
import com.example.wisataindonesia.model.DataWisata;
import com.example.wisataindonesia.model.ModelWisata;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvWisata;
    private ArrayList<ModelWisata> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvWisata = findViewById(R.id.rv_wisata);
        rvWisata.setHasFixedSize(true);

        setJudulActionBar("Mode Card");

//        ambil data
        data.addAll(DataWisata.ambilDataWisata());

        tampilDataCard();
    }

//    menampilkan data dalam bentuk card
    private void tampilDataCard(){
        rvWisata.setLayoutManager(new LinearLayoutManager(this));
        AdapterClass colokanCard = new AdapterClass(data);
        rvWisata.setAdapter(colokanCard);
    }
    
//    menampilkan data dalam bentuk grid
    private void tampilDataGrid(){
        rvWisata.setLayoutManager(new GridLayoutManager(this,2));
        AdapterGrid colokanGrid = new AdapterGrid(data);
        rvWisata.setAdapter(colokanGrid);

        colokanGrid.setOnItemClickCallBack(new AdapterGrid.OnItemClickCallBack() {
            @Override
            public void onItemClicked(ModelWisata data) {
                showSelectedWisata(data);
            }
        });
    }

    public void showSelectedWisata(ModelWisata wisata){
        Toast.makeText(this, "Anda Memilih " + wisata.getNama(), Toast.LENGTH_SHORT).show();
    }


//    menambahkan menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tampilan, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setModeTampilan(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setModeTampilan(int selectedMode){
        switch (selectedMode) {
            case R.id.menu_card:
                setJudulActionBar("Mode Card");
                tampilDataCard();
                break;
            case R.id.menu_grid:
                setJudulActionBar("Mode Grid");
                tampilDataGrid();
                break;
        }
    }


//    custom action bar
    public void setJudulActionBar(String judul){
        if (getSupportActionBar()!=null) {
            getSupportActionBar().setTitle(judul);
        }
    }
}