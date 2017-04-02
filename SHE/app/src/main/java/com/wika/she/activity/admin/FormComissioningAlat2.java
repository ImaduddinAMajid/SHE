package com.wika.she.activity.admin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.wika.she.R;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class FormComissioningAlat2 extends AppCompatActivity {

    private int requestImageCapture = 0;
    private ImageButton[] imageButton = new ImageButton[4];
    private Bitmap[] imageBitmap = new Bitmap[4];
    private JSONObject dataJson;
    private AsyncHttpClient client = new AsyncHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setSubtitle(R.string.sub_title);
        setContentView(R.layout.activity_form_comissioning_alat2);

        this.populateElement();

        this.dataJson = null;
        try {
            this.dataJson = new JSONObject(getIntent().getStringExtra("data"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == requestImageCapture && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            this.imageBitmap[requestImageCapture] = (Bitmap) extras.get("data");
            this.imageButton[requestImageCapture].setImageBitmap(this.imageBitmap[requestImageCapture]);
        }
    }

    public void photoClicked(View view) {
        switch (view.getId()) {
            case R.id.button_image_depan: requestImageCapture = 0;
                break;
            case R.id.button_image_belakang: requestImageCapture = 1;
                break;
            case R.id.button_image_kanan: requestImageCapture = 2;
                break;
            case R.id.button_image_kiri: requestImageCapture = 3;
                break;
        }

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, requestImageCapture);
        }
    }

    public void back(View v) {
        Intent comissionIntent = new Intent(this, FormComissioningAlat.class);
        startActivity(comissionIntent);
    }

    public void submit(View v) throws UnsupportedEncodingException, JSONException {
        this.dataJson.put("fotoDepan", "/x/y");
        this.dataJson.put("fotoBelakang", "/x/y");
        this.dataJson.put("fotoKanan", "/x/y");
        this.dataJson.put("fotoKiri", "x/y");

        StringEntity entity = new StringEntity(this.dataJson.toString());
        final ProgressDialog loading;
        loading = ProgressDialog.show(FormComissioningAlat2.this,"Fetching Data","Please Wait...",false,false);
        client.post(getApplicationContext(), "http://url.com", entity, "application/json", new JsonHttpResponseHandler()
        {
            @Override
            public void onSuccess(int statusCode, Header[] headers, final JSONObject response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loading.dismiss();
                        try {
                            String x = response.getString("xxx");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //editText.setText("");
                    }
                });
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                loading.dismiss();
                Toast.makeText(
                        getApplicationContext(),
                        "Something went wrong :(",
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }


    public void populateElement() {
        this.imageButton[0] = (ImageButton)findViewById(R.id.button_image_depan);
        this.imageButton[1] = (ImageButton)findViewById(R.id.button_image_belakang);
        this.imageButton[2] = (ImageButton)findViewById(R.id.button_image_kanan);
        this.imageButton[3] = (ImageButton)findViewById(R.id.button_image_kiri);
    }
}
