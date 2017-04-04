package com.wika.she.model;

import android.widget.Button;
import android.widget.ToggleButton;

public class PersetujuanIjinKerja {
    private String diajukanOleh;
    private String tanggal;
    private Button detailButton;
    private ToggleButton toggleButton;

    public PersetujuanIjinKerja(String diajukanOleh, String tanggal, Button detailButton, ToggleButton toggleButton) {
        this.diajukanOleh = diajukanOleh;
        this.tanggal = tanggal;
        this.detailButton = detailButton;
        this.toggleButton = toggleButton;
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

    public Button getDetailButton() {
        return detailButton;
    }

    public void setDetailButton(Button detailButton) {
        this.detailButton = detailButton;
    }

    public ToggleButton getToggleButton() {
        return toggleButton;
    }

    public void setToggleButton(ToggleButton toggleButton) {
        this.toggleButton = toggleButton;
    }
}
