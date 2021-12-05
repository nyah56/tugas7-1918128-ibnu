package com.example.sqllite_1918128;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity{
    private MyDatabase db;
    private EditText Enama, Ekode, Ejumlah;
    private String Snama, Skode, Sjumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Ekode = (EditText) findViewById(R.id.create_kode);
        Enama = (EditText) findViewById(R.id.create_nama);
        Ejumlah = (EditText) findViewById(R.id.create_jml);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Skode = String.valueOf(Ekode.getText());
                Snama = String.valueOf(Enama.getText());
                Sjumlah = String.valueOf(Ejumlah.getText());
                if (Skode.equals("")) {
                    Ekode.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi kode",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Snama.equals("")) {
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjumlah.equals("")) {
                    Ejumlah.requestFocus();
                    Toast.makeText(MainCreate.this, "Jumlah tidak boleh kosong",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Ekode.setText("");
                    Enama.setText("");
                    Ejumlah.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateAlat(new Alat(null,Skode,Snama,Sjumlah
                            ));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
