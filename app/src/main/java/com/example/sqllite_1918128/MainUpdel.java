package com.example.sqllite_1918128;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Skode,Sjumlah;
    private EditText Enama, Ekode,Ejumlah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Skode = i.getStringExtra("Ikode");
        Snama = i.getStringExtra("Inama");
        Sjumlah = i.getStringExtra("Ijumlah");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Ekode = (EditText) findViewById(R.id.updel_kode);
        Ejumlah = (EditText) findViewById(R.id.updel_jml);
        Ekode.setText(Skode);
        Enama.setText(Snama);
        Ejumlah.setText(Sjumlah);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Skode = String.valueOf(Ekode.getText());
                Sjumlah = String.valueOf(Ejumlah.getText());
                if (Skode.equals("")){
                    Ekode.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi kode",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Sjumlah.equals("")){
                    Ekode.requestFocus();
                    Toast.makeText(MainUpdel.this, "Jumlah tidak boleh kosong",
                            Toast.LENGTH_SHORT).show();
                }else {
                    db.UpdateAlat(new Alat(Sid,Skode,Snama,
                            Sjumlah));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteAlat(new Alat(Sid, Skode, Snama,Sjumlah));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
