package com.wika.she.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.wika.she.R;

public class ModePelaksana extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setSubtitle("SHE INTEGRATED APPLICATION");
        setContentView(R.layout.activity_mode_pelaksana);
    }

    public void exit(View view) {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }

    public void onIjinClicked(View view) {
        Intent pengajuanIjinIntent = new Intent(this, PengajuanIjinKerja1.class);
        startActivity(pengajuanIjinIntent);
    }
}
