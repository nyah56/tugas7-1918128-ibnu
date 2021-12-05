package com.example.sqllite_1918128;

public class Alat {
    private String _id, _nama, _kode,_jumlah;
    public Alat (String id,String kode,String nama,String jumlah) {
        this._id = id;
        this._kode = kode;
        this._nama = nama;
        this._jumlah=jumlah;
    }
    public Alat() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_kode() {
        return _kode;
    }
    public void set_kode(String _kode) {
        this._kode = _kode;
    }
    public String get_jumlah() {
        return _jumlah;
    }
    public void set_jumlah(String _jumlah) {
        this._jumlah = _jumlah;
    }
}
