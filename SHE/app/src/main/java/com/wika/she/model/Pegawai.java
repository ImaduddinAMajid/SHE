package com.wika.she.model;

import java.util.Date;

public class Pegawai {
    private String nama;
    private Date tanggalInduksi;
    private String instansi;
    private String jabatan;
    private Integer foto;

    public Pegawai(String nama, Date tanggalInduksi, String instansi, String jabatan, Integer foto) {
        this.nama = nama;
        this.tanggalInduksi = tanggalInduksi;
        this.instansi = instansi;
        this.jabatan = jabatan;
        this.foto = foto;
    }

    public String getNama() {
        return nama;
    }

    public Date getTanggalInduksi() {
        return tanggalInduksi;
    }

    public String getInstansi() {
        return instansi;
    }

    public String getJabatan() {
        return jabatan;
    }

    public Integer getFoto() {
        return foto;
    }
}
