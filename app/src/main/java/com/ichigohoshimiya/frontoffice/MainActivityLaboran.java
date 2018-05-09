package com.ichigohoshimiya.frontoffice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivityLaboran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_laboran);

        ImageView imageAlert = (ImageView) findViewById(R.id.img_alert);
        imageAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityLaboran.this, AlertActivity.class);
                startActivity(intent);
            }
        });

        ImageView imageCertificate = (ImageView) findViewById(R.id.img_cerficate);
        imageCertificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityLaboran.this, CertificateActivity.class);
                startActivity(intent);
            }
        });

        ImageView imageComplain = (ImageView) findViewById(R.id.img_complain);
        imageComplain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityLaboran.this, ComplainActivity.class);
                startActivity(intent);
            }
        });
    }
}
