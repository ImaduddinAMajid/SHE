package com.wika.she.model;

public class Pegawai {
    private String nama;
    private String tanggalInduksi;
    private String instansi;
    private String jabatan;

    public Pegawai(String nama, String tanggalInduksi, String instansi, String jabatan) {
        this.nama = nama;
        this.tanggalInduksi = tanggalInduksi;
        this.instansi = instansi;
        this.jabatan = jabatan;
    }

    public String getNama() {
        return nama;
    }

    public String getTanggalInduksi() {
        return tanggalInduksi;
    }

    public String getInstansi() {
        return instansi;
    }

    public String getJabatan() {
        return jabatan;
    }
}
