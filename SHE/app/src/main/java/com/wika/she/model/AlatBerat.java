package com.wika.she.model;

import java.util.Date;

public class AlatBerat {
    private String jenisAlat;
    private Date tanggal;
    private String tipe;
    private String id;
    private String pemilik;
    private String operator;
    private String catatan;

    public AlatBerat(String jenisAlat, Date tanggal, String tipe, String id, String pemilik, String operator, String catatan) {
        this.jenisAlat = jenisAlat;
        this.tanggal = tanggal;
        this.tipe = tipe;
        this.id = id;
        this.pemilik = pemilik;
        this.operator = operator;
        this.catatan = catatan;
    }

    public String getJenisAlat() {
        return jenisAlat;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public String getTipe() {
        return tipe;
    }

    public String getId() {
        return id;
    }

    public String getPemilik() {
        return pemilik;
    }

    public String getOperator() {
        return operator;
    }

    public String getCatatan() {
        return catatan;
    }
}
