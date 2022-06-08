package com.example.wisataindonesia.model;

import java.util.ArrayList;

public class DataWisata {

    public static String[][] data = new String[][] {
            {"Jembatan Ampera", "Kota Palembang", "https://palembang.go.id/asset/uploads/22_Jembatan_Ampera_Foto_By_Dispar_Plg_(1).jpg"},
            {"Kota Lama", "Kota Semarang", "https://img.alinea.id/img/content/2019/11/27/57363/intip-pesona-kota-lama-semarang-yang-otentik-QM1F0yZNR1.jpg"},
            {"Pantai Losari", "Kota Makasar", "https://piknikwisata.com/wp-content/uploads/2019/11/info-lengkap-wisata-pantai-losari.jpg"},
            {"Pulau Labengki", "Kota Kendari", "https://www.celebes.co/wp-content/uploads/2019/08/Tips-Berkunjung-ke-Pulau-Labengki.jpg"},
            {"Danau Ranau", "Kabupaten OKU Selatan", "https://cdn-2.tstatic.net/tribunnews/foto/bank/images/danau-ranau-di-oku-selatan_20150526_132230.jpg"},
    };

    public static ArrayList<ModelWisata> ambilDataWisata(){
        ArrayList<ModelWisata> dataWisata = new ArrayList<>();
        for (String[] varData : data){
            ModelWisata model = new ModelWisata();
            model.setNama(varData[0]);
            model.setLokasi(varData[1]);
            model.setFoto(varData[2]);

            dataWisata.add(model);
        }


        return dataWisata;
    }

}
