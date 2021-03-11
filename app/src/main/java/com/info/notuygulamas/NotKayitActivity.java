package com.info.notuygulamas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class NotKayitActivity extends AppCompatActivity {
    private EditText editTextDers, editTextNot1, editTextNot2;
    private Button buttonKaydet;
    private Toolbar toolbar_kayit;
    private Veritabani veritabani;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_kayit);

        //idler
        editTextDers = findViewById(R.id.editTextDers);
        editTextNot1 = findViewById(R.id.editTextNot1);
        editTextNot2 = findViewById(R.id.editTextNot2);
        buttonKaydet = findViewById(R.id.buttonKaydet);
        toolbar_kayit = findViewById(R.id.toolbar_kayit);

        // veritabanı

        veritabani = new Veritabani(getApplicationContext());

        //button click

        buttonKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ders_adi = editTextDers.getText().toString().trim();
                String not1 = editTextNot1.getText().toString().trim();
                String not2 = editTextNot2.getText().toString().trim();

                if(TextUtils.isEmpty(ders_adi)){
                    Snackbar.make(v,"Ders Adı Giriniz !!",Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(not1)){
                    Snackbar.make(v,"Not 1 Giriniz !!",Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(not2)){
                    Snackbar.make(v,"Not 2 Giriniz !!",Snackbar.LENGTH_SHORT).show();
                    return;
                }

                new NotlarDao().notEkle(veritabani,ders_adi,Integer.parseInt(not1),Integer.parseInt(not2));

                startActivity(new Intent(NotKayitActivity.this,MainActivity.class));
                finish();
            }
        });

        //gerekliler

        toolbar_kayit.setTitle("Not Kayıt");
        setSupportActionBar(toolbar_kayit);

    }
}