package com.wika.she.activity.pelaksana;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.wika.she.R;

public class PengajuanIjinKerja3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setSubtitle(R.string.sub_title);
        setContentView(R.layout.activity_pengajuan_ijin_kerja3);

        TextView textViewJudul = (TextView)findViewById(R.id.judul);
        textViewJudul.setText(getIntent().getStringExtra("unit_kerja"));
    }
}
