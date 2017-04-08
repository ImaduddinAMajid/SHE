package com.wika.she.activity.admin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import com.wika.she.R;
import com.wika.she.adapter.PersetujuanIjinKerjaAdapter;
import com.wika.she.model.PersetujuanIjinKerjaModel;
import com.wika.she.util.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PersetujuanIjinKerja extends AppCompatActivity {

    private ListView listView;

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

    public void onSendClicked(View view) throws JSONException {
        JSONArray jsonArray = new JSONArray();

        ArrayList<PersetujuanIjinKerjaModel> ijinKerjaList = ((PersetujuanIjinKerjaAdapter)this.listView.getAdapter()).getPengajuanIjinKerja();
        for(PersetujuanIjinKerjaModel ijinKerja : ijinKerjaList) {
            JSONObject ijinKerjaJSON = new JSONObject();
            ijinKerjaJSON.put(Constants.DIAJUKAN_OLEH, ijinKerja.getDiajukanOleh());
            ijinKerjaJSON.put(Constants.TANGGAL, ijinKerja.getTanggal());
            jsonArray.put(ijinKerjaJSON);
        }

        JSONObject ijinKerjaArray = new JSONObject();
        ijinKerjaArray.put(Constants.IJIN_KERJA, jsonArray);

        String str = ijinKerjaArray.toString();
        System.out.println(str);
    }
}
