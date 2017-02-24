package com.wika.she;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spinner;
    String spinner_item;
    EditText editText;

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

        Toast toast = Toast.makeText(getApplicationContext(), spinner_item, Toast.LENGTH_SHORT);
        toast.show();
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
//            case "PELAKSANA": intent = new Intent(this, ModePelaksana.class);
//                startActivity(intent);
//                break;
//            case "UMUM": intent = new Intent(this, ModeUmum.class);
//                startActivity(intent);
//                break;
        }
    }

    public void keluar(View view) {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }
}
