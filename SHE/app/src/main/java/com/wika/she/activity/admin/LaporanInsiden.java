package com.wika.she.activity.admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import com.wika.she.R;

public class LaporanInsiden extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setSubtitle(R.string.sub_title);
        setContentView(R.layout.activity_laporan_insiden1);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_kecelakaan:
                if (checked) {

                } else {

                }
                break;
            case R.id.checkbox_nearmiss:
                if (checked) {

                } else {

                }
                break;
        }
    }

    public void cancel(View view) {

    }

    public void next(View view) {
        Intent laporanInsiden2Intent = new Intent(this, LaporanInsiden2.class);
        startActivity(laporanInsiden2Intent);
    }
}
