package com.wika.she.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.wika.she.R;

public class FormComissioningAlat2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setSubtitle("SHE INTEGRETED APPLICATION");
        setContentView(R.layout.activity_form_comissioning_alat2);
    }

    public void back(View v) {
        Intent comissionIntent = new Intent(this, FormComissioningAlat.class);
        startActivity(comissionIntent);
    }

    public void submit(View v) {

    }
}
