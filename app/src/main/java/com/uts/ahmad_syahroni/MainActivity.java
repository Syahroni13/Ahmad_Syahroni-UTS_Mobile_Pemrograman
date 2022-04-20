package com.uts.ahmad_syahroni;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.uts.ahmad_syahroni.Hero.HeroAdapter;
import com.uts.ahmad_syahroni.Hero.HeroData;
import com.uts.ahmad_syahroni.Hero.HeroModel;

import java.util.ArrayList;

//Merupakan FIle utama dari aplikasi dimana file ini turunan dari AppCOmpactActivity yang menjadi default android saat mulai menjalankan aplikasi
public class MainActivity extends AppCompatActivity {

    //deklarasi Recycle View
    private RecyclerView recyclerView;

    //deklarasi arrayList untuk mengambil data dari ModelHoro
    private ArrayList<HeroModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_hero);
        recyclerView.setHasFixedSize(true);

        list.addAll(HeroData.getListData());

        tampilRecycleView();
    }

    private void tampilRecycleView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        HeroAdapter heroAdapter = new HeroAdapter(list);

        recyclerView.setAdapter(heroAdapter);
    }
}