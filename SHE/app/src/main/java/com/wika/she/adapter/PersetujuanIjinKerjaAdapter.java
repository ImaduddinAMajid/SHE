package com.wika.she.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.wika.she.R;
import com.wika.she.activity.pelaksana.PengajuanIjinKerja1;
import com.wika.she.model.PersetujuanIjinKerjaModel;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PersetujuanIjinKerjaAdapter extends BaseAdapter {
    private ArrayList<PersetujuanIjinKerjaModel> list;
    private Activity context;

    public PersetujuanIjinKerjaAdapter(Activity context, ArrayList<PersetujuanIjinKerjaModel> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public View getView(final int position, View convertView, final ViewGroup parent ){
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.list_persetujuan_ijin_kerja, null);

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

        CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.checkbox_persetujuan);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isSelected = ((CheckBox) view).isChecked();
                list.get(position).setSelected(isSelected);
            }
        });

        return itemView;
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent){
        return getView(position,convertView,parent);
    }

    public ArrayList<PersetujuanIjinKerjaModel> getPengajuanIjinKerja() {
        ArrayList<PersetujuanIjinKerjaModel> list = new ArrayList<>();
        for(int i = 0; i < this.list.size(); i++) {
            if(this.list.get(i).isSelected()) {
                list.add(this.list.get(i));
            }
        }
        return list;
    }
}
