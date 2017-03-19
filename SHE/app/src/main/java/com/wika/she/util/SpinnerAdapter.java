package com.wika.she.util;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.wika.she.R;
import com.wika.she.model.Pegawai;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<Pegawai> {

    int groupid;
    ArrayList<Pegawai> list;
    LayoutInflater inflater;

    public SpinnerAdapter(Activity context, int groupid, int id, ArrayList<Pegawai> list){
        super(context,id,list);
        this.list = list;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.groupid = groupid;
    }

    public View getView(int position, View convertView, ViewGroup parent ){
        View itemView = inflater.inflate(groupid,parent,false);
        ImageView imageView = (ImageView)itemView.findViewById(R.id.img);
        imageView.setImageResource(list.get(position).getFoto());
        TextView textView = (TextView)itemView.findViewById(R.id.txt);
        textView.setText(list.get(position).getNama());
        return itemView;
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent){
        return getView(position,convertView,parent);
    }
}