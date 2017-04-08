package com.wika.she.activity.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import com.wika.she.R;
import com.wika.she.util.Constants;
import org.json.JSONException;
import org.json.JSONObject;

public class FormComissioningAlat extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private String spinner_item;
    private EditText editTextTanggal, editTextTipe, editTextNoIdentitas, editTextPemilik, editTextOperator, editTextCatatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setSubtitle(R.string.sub_title);
        setContentView(R.layout.activity_form_comissioning_alat);

        this.populateElement();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        this.spinner_item = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void next(View view) throws JSONException {
        JSONObject dataJson = new JSONObject();
        dataJson.put(Constants.JENIS_ALAT, this.spinner_item);
        dataJson.put(Constants.TANGGAL, this.editTextTanggal.getText().toString());
        dataJson.put(Constants.TIPE, this.editTextTipe.getText().toString());
        dataJson.put(Constants.NO_IDENTITAS, this.editTextNoIdentitas.getText().toString());
        dataJson.put(Constants.PEMILIK, this.editTextPemilik.getText().toString());
        dataJson.put(Constants.OPERATOR, this.editTextOperator.getText().toString());
        dataJson.put(Constants.CATATAN, this.editTextCatatan.getText().toString());

        Intent comissionIntent2 = new Intent(this, FormComissioningAlat2.class);
        comissionIntent2.putExtra(Constants.DATA, dataJson.toString());
        startActivity(comissionIntent2);
    }

    public void cancel(View view) {

    }

    public void populateElement() {
        this.spinner = (Spinner)findViewById(R.id.spinner_alat);
        this.spinner.setOnItemSelectedListener(this);
        this.editTextTanggal = (EditText)findViewById(R.id.edit_text_tanggal);
        this.editTextTipe = (EditText)findViewById(R.id.edit_text_tipe);
        this.editTextNoIdentitas = (EditText)findViewById(R.id.edit_text_no_identitas);
        this.editTextPemilik = (EditText)findViewById(R.id.edit_text_pemilik);
        this.editTextOperator = (EditText)findViewById(R.id.edit_text_operator);
        this.editTextCatatan = (EditText)findViewById(R.id.edit_text_catatan);
    }
}


