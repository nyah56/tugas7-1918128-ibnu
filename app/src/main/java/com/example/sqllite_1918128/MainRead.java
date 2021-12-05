package com.example.sqllite_1918128;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Alat> ListAlat = new
            ArrayList<Alat>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListAlat
        );
        mListView = (ListView) findViewById(R.id.list_alat);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListAlat.clear();
        List<Alat> alat = db.ReadAlat();
        for (Alat alt : alat) {
            Alat daftar = new Alat();
            daftar.set_id(alt.get_id());
            daftar.set_kode(alt.get_kode());
            daftar.set_nama(alt.get_nama());
            daftar.set_jumlah(alt.get_jumlah());
            ListAlat.add(daftar);
            if ((ListAlat.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int
            i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Alat detailAlt = (Alat)o;
        String Sid = detailAlt.get_id();
        String Skode = detailAlt.get_kode();
        String Snama = detailAlt.get_nama();
        String Sjumlah = detailAlt.get_jumlah();
        Intent goUpdel = new Intent(MainRead.this,
                MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Ikode", Skode);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Ijumlah", Sjumlah);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListAlat.clear();
        mListView.setAdapter(adapter_off);
        List<Alat> alat = db.ReadAlat();
        for (Alat alt : alat) {
            Alat daftar = new Alat();
            daftar.set_id(alt.get_id());
            daftar.set_kode(alt.get_kode());
            daftar.set_nama(alt.get_nama());
            daftar.set_jumlah(alt.get_jumlah());
            ListAlat.add(daftar);
            if ((ListAlat.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
