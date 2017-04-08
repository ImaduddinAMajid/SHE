package com.wika.she.model;

public class PengajuanIjinKerjaModel {
    private String nama;
    private String jabatan;
    private boolean isDiIjinkan;

    public PengajuanIjinKerjaModel(String nama, String jabatan, boolean isDiIjinkan) {
        this.nama = nama;
        this.jabatan = jabatan;
        this.isDiIjinkan = isDiIjinkan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public boolean isDiIjinkan() {
        return isDiIjinkan;
    }

    public void setDiIjinkan(boolean diIjinkan) {
        isDiIjinkan = diIjinkan;
    }
}
