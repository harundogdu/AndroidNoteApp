package com.info.notuygulamas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class DetayActivity extends AppCompatActivity {
    private Toolbar toolbar_detay;
    private EditText editTextDersDetay, editTextNot1Detay, editTextNot2Detay;
    private Veritabani veritabani;
    private Notlar notlar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        //idler
        toolbar_detay = findViewById(R.id.toolbar_detay);
        editTextDersDetay = findViewById(R.id.editTextDersDetay);
        editTextNot1Detay = findViewById(R.id.editTextNot1Detay);
        editTextNot2Detay = findViewById(R.id.editTextNot2Detay);

        toolbar_detay.setTitle("Not Güncelle");
        setSupportActionBar(toolbar_detay);

        // ıntent den gelenler
        notlar = (Notlar) getIntent().getSerializableExtra("notlar");

        editTextDersDetay.setText(notlar.getDers_adi());
        editTextNot1Detay.setText(String.valueOf(notlar.getNot1()));
        editTextNot2Detay.setText(String.valueOf(notlar.getNot2()));

        // veritabanı

        veritabani = new Veritabani(getApplicationContext());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tasarim_kayit, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_sil:
                Snackbar.make(toolbar_detay, "Silinsin mi ?", Snackbar.LENGTH_LONG).setAction("Evet", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        new NotlarDao().notSil(veritabani, notlar.getNot_id());

                        startActivity(new Intent(DetayActivity.this, MainActivity.class));
                        finish();
                    }
                }).show();
                return true;
            case R.id.action_duzenle:

                String ders_adi = editTextDersDetay.getText().toString().trim();
                String not1 = editTextNot1Detay.getText().toString().trim();
                String not2 = editTextNot2Detay.getText().toString().trim();

                if (TextUtils.isEmpty(ders_adi)) {
                    Snackbar.make(toolbar_detay, "Ders Adı Giriniz !!", Snackbar.LENGTH_SHORT).show();
                    return false;
                }
                if (TextUtils.isEmpty(not1)) {
                    Snackbar.make(toolbar_detay, "Not 1 Giriniz !!", Snackbar.LENGTH_SHORT).show();
                    return false;
                }
                if (TextUtils.isEmpty(not2)) {
                    Snackbar.make(toolbar_detay, "Not 2 Giriniz !!", Snackbar.LENGTH_SHORT).show();
                    return false;
                }

                new NotlarDao().notGuncelle(veritabani, notlar.getNot_id(), ders_adi, Integer.parseInt(not1), Integer.parseInt(not2));


                startActivity(new Intent(DetayActivity.this, MainActivity.class));
                finish();
                return true;
            default:
                return false;
        }

    }
}