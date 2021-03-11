package com.info.notuygulamas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView rv;
    private FloatingActionButton fab;
    private NotlarAdapter adapter;
    private ArrayList<Notlar> notlarArrayList;
    private Veritabani veritabani;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //idler
        toolbar = findViewById(R.id.toolbar);
        rv = findViewById(R.id.rv);
        fab = findViewById(R.id.fab);

        //fab click

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NotKayitActivity.class));
            }
        });

        //gerekliler
        toolbar.setTitle("Not Uygulaması");

        setSupportActionBar(toolbar);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setHasFixedSize(true);

        veritabani = new Veritabani(getApplicationContext());

        //Tanımlamalar

        notlarArrayList = new NotlarDao().tumNotlariGetir(veritabani);

        adapter = new NotlarAdapter(MainActivity.this, notlarArrayList);
        rv.setAdapter(adapter);

        // toolbar ortalama

        double toplam = 0.0;

        if (notlarArrayList.size() == 0) {
            toolbar.setSubtitle("Ortalama için bir not giriniz..");
        } else {
            for (Notlar n : notlarArrayList) {
                toplam += (n.getNot1() + n.getNot2()) / 2;
            }
            toolbar.setSubtitle("Ortamala : " + (toplam / notlarArrayList.size()));
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}