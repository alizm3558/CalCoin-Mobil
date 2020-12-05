package com.example.calcoin.DATABASE.models;

public class kullanicilar {
    private String kullaniciAdi,telefon,sifre;
    private int id;

    public kullanicilar(String kullaniciAdi, String telefon, String sifre) {
        this.kullaniciAdi = kullaniciAdi;
        this.telefon = telefon;
        this.sifre = sifre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
}
