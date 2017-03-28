package com.wika.she.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import com.wika.she.R;
import com.wika.she.activity.admin.ModeAdmin;
import com.wika.she.activity.pelaksana.ModePelaksana;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spinner;
    String spinner_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setSubtitle("SHE INTEGRETED APPLICATION");
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.spinner_user);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        spinner_item = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void masuk(View view) {
        Intent intent;
        switch (spinner_item) {
            case "ADMIN": intent = new Intent(this, ModeAdmin.class);
                startActivity(intent);
                break;
            case "PELAKSANA": intent = new Intent(this, ModePelaksana.class);
                startActivity(intent);
                break;
        }
    }

    public void exit(View view) {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }
}
