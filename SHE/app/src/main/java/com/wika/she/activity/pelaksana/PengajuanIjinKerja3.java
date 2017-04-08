package com.wika.she.activity.pelaksana;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.wika.she.R;
import com.wika.she.adapter.PengajuanIjinKerjaAdapter;
import com.wika.she.model.PengajuanIjinKerjaModel;

import java.util.ArrayList;

public class PengajuanIjinKerja3 extends AppCompatActivity {

    private ListView listView;
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

        listView = (ListView)findViewById(R.id.list_pengajuan_ijin_kerja);
        ArrayList<PengajuanIjinKerjaModel> list = new ArrayList<>();
        list.add(this.getPengajuanIjinKerja("adi"));
        list.add(this.getPengajuanIjinKerja("imad"));

        PengajuanIjinKerjaAdapter adapter = new PengajuanIjinKerjaAdapter(this, list);
        listView.setAdapter(adapter);
    }

    public void onKembaliClicked(View view) {
        Intent pengajuanIjinKerja1 = new Intent(this, PengajuanIjinKerja1.class);
        startActivity(pengajuanIjinKerja1);
    }

    private PengajuanIjinKerjaModel getPengajuanIjinKerja(String name) {
        return new PengajuanIjinKerjaModel(name,
                "Direktur",
                false);
    }

    public void onSubmitClicked(View view) {

    }
}
