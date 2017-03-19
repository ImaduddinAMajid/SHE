package com.wika.she.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.wika.she.R;

public class FormComissioningAlat extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setSubtitle("SHE INTEGRETED APPLICATION");
        setContentView(R.layout.activity_form_comissioning_alat);
    }

    public void next(View view) {
        Intent comissionIntent2 = new Intent(this, FormComissioningAlat2.class);
        startActivity(comissionIntent2);
    }

    public void cancel(View view) {

    }
}


