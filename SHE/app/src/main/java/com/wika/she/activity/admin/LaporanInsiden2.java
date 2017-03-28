package com.wika.she.activity.admin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.wika.she.R;

public class LaporanInsiden2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setSubtitle(R.string.sub_title);
        setContentView(R.layout.activity_laporan_insiden2);
    }
}
