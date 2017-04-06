package com.wika.she.activity.admin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.wika.she.R;
import com.wika.she.adapter.PersetujuanIjinKerjaAdapter;
import com.wika.she.model.PersetujuanIjinKerjaModel;

import java.util.ArrayList;

public class PersetujuanIjinKerja extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listView;
    private String test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setSubtitle(R.string.sub_title);
        setContentView(R.layout.activity_persetujuan_ijin_kerja);

        listView = (ListView)findViewById(R.id.list_ijin_kerja);
        ArrayList<PersetujuanIjinKerjaModel> list = new ArrayList<>();
        list.add(this.getPersIjinKerja("adi"));
        list.add(this.getPersIjinKerja("imad"));

        PersetujuanIjinKerjaAdapter adapter = new PersetujuanIjinKerjaAdapter(this, list);
        listView.setAdapter(adapter);
    }

    private PersetujuanIjinKerjaModel getPersIjinKerja(String name) {
        return new PersetujuanIjinKerjaModel(name,
                "11/2/1993");
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        long viewId = view.getId();

        if (viewId == R.id.toggle_button) {
            Toast.makeText(this, i, Toast.LENGTH_SHORT).show();
        }
    }
}
