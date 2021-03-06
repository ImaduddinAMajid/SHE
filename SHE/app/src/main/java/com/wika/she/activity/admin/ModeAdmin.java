package com.wika.she.activity.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.wika.she.R;

public class ModeAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setSubtitle(R.string.sub_title);
        setContentView(R.layout.activity_mode_admin);
    }

    public void onInductionClicked(View view) {
        Intent inductionIntent = new Intent(this, SheIduction.class);
        startActivity(inductionIntent);
    }

    public void onComissioningClicked(View view) {
        Intent comissionIntent = new Intent(this, FormComissioningAlat.class);
        startActivity(comissionIntent);
    }

    public void onLaporanInsidenClicked(View view) {
        Intent laporanInsidenIntent = new Intent(this, LaporanInsiden.class);
        startActivity(laporanInsidenIntent);
    }

    public void onPersetujuanIjinKerjaClicked(View view) {
        Intent persetujuanIjinKerjaIntent = new Intent(this, PersetujuanIjinKerja.class);
        startActivity(persetujuanIjinKerjaIntent);
    }

    public void exit(View view) {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }
}
