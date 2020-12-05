package com.example.calcoin.DATABASE.models;

public class notlar {
    private int id;
    private String kullaniciAdi,baslik,notlar;

    public notlar(int id) {
        this.id = id;
        this.kullaniciAdi = kullaniciAdi;
        this.baslik = baslik;
        this.notlar = notlar;
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

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getNotlar() {
        return notlar;
    }

    public void setNotlar(String notlar) {
        this.notlar = notlar;
    }
}
