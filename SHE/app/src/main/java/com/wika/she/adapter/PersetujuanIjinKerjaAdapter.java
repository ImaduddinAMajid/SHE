package com.wika.she.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.wika.she.R;
import com.wika.she.activity.pelaksana.PengajuanIjinKerja1;
import com.wika.she.model.PersetujuanIjinKerja;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PersetujuanIjinKerjaAdapter extends ArrayAdapter<com.wika.she.model.PersetujuanIjinKerja> {
    private int groupid;
    private ArrayList<PersetujuanIjinKerja> list;
    private LayoutInflater inflater;
    private Activity context;

    public PersetujuanIjinKerjaAdapter(Activity context, int groupid, int id, ArrayList<PersetujuanIjinKerja> list){
        super(context,id,list);
        this.context = context;
        this.list = list;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.groupid = groupid;
    }

    public View getView(final int position, View convertView, final ViewGroup parent ){
        View itemView = inflater.inflate(groupid,parent,false);

        TextView textViewDiajukanOleh = (TextView) itemView.findViewById(R.id.text_view_diajukan_oleh);
        textViewDiajukanOleh.setText(list.get(position).getDiajukanOleh());
        TextView textViewTanggal = (TextView)itemView.findViewById(R.id.text_view_tanggal_pengajuan);
        textViewTanggal.setText(list.get(position).getTanggal());
        Button button = (Button)itemView.findViewById(R.id.button_detail);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject dataJson = new JSONObject();
                try {
                    dataJson.put("diajukanOleh", list.get(position).getDiajukanOleh());
                    dataJson.put("tanggal", list.get(position).getTanggal());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Intent pengajuanIjinKerja = new Intent(context, PengajuanIjinKerja1.class);
                pengajuanIjinKerja.putExtra("data", dataJson.toString());
                context.startActivity(pengajuanIjinKerja);
            }
        });

        //TODO: Handle toggle button

        return itemView;
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent){
        return getView(position,convertView,parent);
    }
}
