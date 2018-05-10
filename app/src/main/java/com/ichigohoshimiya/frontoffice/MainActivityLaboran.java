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

        ImageView imageAlertLaboran = (ImageView) findViewById(R.id.img_alert_laboran);
        imageAlertLaboran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityLaboran.this, AlertActivity.class);
                startActivity(intent);
            }
        });

        ImageView imageSalaryLaboran = (ImageView) findViewById(R.id.img_salary_laboran);
        imageSalaryLaboran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityLaboran.this, SalaryActivity.class);
                startActivity(intent);
            }
        });

        ImageView imageCertificateLaboran = (ImageView) findViewById(R.id.img_cerficate_laboran);
        imageCertificateLaboran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityLaboran.this, CertificateActivity.class);
                startActivity(intent);
            }
        });

        ImageView imageComplainLaboran = (ImageView) findViewById(R.id.img_complain_laboran);
        imageComplainLaboran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityLaboran.this, ComplainActivity.class);
                startActivity(intent);
            }
        });
    }
}
