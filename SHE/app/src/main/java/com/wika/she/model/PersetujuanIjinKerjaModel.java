package com.wika.she.model;

public class PersetujuanIjinKerjaModel {
    private String diajukanOleh;
    private String tanggal;
    private boolean selected;

    public PersetujuanIjinKerjaModel(String diajukanOleh, String tanggal) {
        this.diajukanOleh = diajukanOleh;
        this.tanggal = tanggal;
    }

    public String getDiajukanOleh() {
        return diajukanOleh;
    }

    public void setDiajukanOleh(String diajukanOleh) {
        this.diajukanOleh = diajukanOleh;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
