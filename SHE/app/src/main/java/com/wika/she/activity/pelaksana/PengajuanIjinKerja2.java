package com.wika.she.activity.pelaksana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import com.wika.she.R;

public class PengajuanIjinKerja2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setSubtitle(R.string.sub_title);
        setContentView(R.layout.activity_pengajuan_ijin_kerja2);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_jsa:
                if (checked) {

                }
                else {

                }
                break;
            case R.id.checkbox_isolasi_perlengkapan:
                if (checked) {

                }
                else {

                }
                break;
            case R.id.checkbox_penutupan_jalan:
                if (checked) {

                }
                else {

                }
            case R.id.checkbox_pemutusan_listrik:
                if (checked) {

                }
                else {

                }
            case R.id.checkbox_tanda_khusus:
                if (checked) {

                }
                else {

                }
            case R.id.checkbox_msds:
                if (checked) {

                }
                else {

                }
            case R.id.checkbox_perancah:
                if (checked) {

                }
                else {

                }
            case R.id.checkbox_pelindung_jatuh:
                if (checked) {

                }
                else {

                }
            case R.id.checkbox_kebersihan_area:
                if (checked) {

                }
                else {

                }
            case R.id.checkbox_kerja_panas:
                if (checked) {

                }
                else {

                }
            case R.id.checkbox_kerja_ketinggian:
                if (checked) {

                }
                else {

                }
            case R.id.checkbox_kerja_galian:
                if (checked) {

                }
                else {

                }
            case R.id.checkbox_kerja_listrik:
                if (checked) {

                }
                else {

                }
            case R.id.checkbox_angkat_angkut:
                if (checked) {

                }
                else {

                }
            case R.id.checkbox_area_terbatas:
                if (checked) {

                }
                else {

                }
        }
    }

    public void submit(View view) {

    }

    public void cancel(View view) {
        
    }
}
