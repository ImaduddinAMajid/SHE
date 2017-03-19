package com.wika.she.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import com.wika.she.R;
import com.wika.she.util.MultiSpinner;
import com.wika.she.util.MultiSpinnerListener;

import java.util.TreeMap;

public class PengajuanIjinKerja1 extends AppCompatActivity {

    final TreeMap<String, Boolean> list = new TreeMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setSubtitle("SHE INTEGRETED APPLICATION");
        setContentView(R.layout.activity_pengajuan_ijin_kerja1);

        list.put("item1", false);
        list.put("item2", false);

        MultiSpinner spinner = (MultiSpinner)findViewById(R.id.spinner_kebutuhan_alat_berat);

        spinner.setItems(list, new MultiSpinnerListener() {

            @Override
            public void onItemsSelected(boolean[] selected) {

                // your operation with code...
                for(int i=0; i<selected.length; i++) {
                    if(selected[i]) {
                        Log.i("TAG", i + " : "+ list.get(i));
                    }
                }
            }
        });
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_sarung_tangan:
                if (checked) {

                }
                else {

                }
                break;
            case R.id.checkbox_kacamata:
                if (checked) {

                }
                else {

                }
                break;
            case R.id.checkbox_masker:
                if (checked) {

                }
                else {

                }
            case R.id.checkbox_body_harness:
                if (checked) {

                }
                else {

                }
            case R.id.checkbox_pelindung_badan:
                if (checked) {

                }
                else {

                }
            case R.id.checkbox_earplug:
                if (checked) {

                }
                else {

                }
        }
    }

    public void next(View view) {
        Intent pengajuanIjinKerja2 = new Intent(this, PengajuanIjinKerja2.class);
        startActivity(pengajuanIjinKerja2);
    }
}
