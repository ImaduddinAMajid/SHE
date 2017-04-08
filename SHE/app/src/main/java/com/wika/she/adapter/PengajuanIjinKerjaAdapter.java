package com.wika.she.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.wika.she.R;
import com.wika.she.model.PengajuanIjinKerjaModel;

import java.util.ArrayList;

public class PengajuanIjinKerjaAdapter extends BaseAdapter {
    private ArrayList<PengajuanIjinKerjaModel> list;
    private Activity context;

    public PengajuanIjinKerjaAdapter(Activity context, ArrayList<PengajuanIjinKerjaModel> list){
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
        View itemView = inflater.inflate(R.layout.list_pengajuan_ijin_kerja, null);

        TextView textViewNama = (TextView) itemView.findViewById(R.id.text_view_nama);
        textViewNama.setText(list.get(position).getNama());
        TextView textViewJabatan = (TextView)itemView.findViewById(R.id.text_view_jabatan);
        textViewJabatan.setText(list.get(position).getJabatan());

        CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.checkbox_pengajuan);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isSelected = ((CheckBox) view).isChecked();
                list.get(position).setDiIjinkan(isSelected);
            }
        });

        return itemView;
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent){
        return getView(position,convertView,parent);
    }

    public ArrayList<PengajuanIjinKerjaModel> getPengajuanIjinKerja() {
        ArrayList<PengajuanIjinKerjaModel> list = new ArrayList<>();
        for(int i = 0; i < this.list.size(); i++) {
            if(this.list.get(i).isDiIjinkan()) {
                list.add(this.list.get(i));
            }
        }
        return list;
    }
}
