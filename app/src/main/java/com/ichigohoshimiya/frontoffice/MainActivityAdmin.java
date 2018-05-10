package com.ichigohoshimiya.frontoffice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivityAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        ImageView imageAlertAdmin = (ImageView) findViewById(R.id.img_alert_admin);
        imageAlertAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityAdmin.this, AlertActivity.class);
                startActivity(intent);
            }
        });

        ImageView imageComplainAdmin = (ImageView) findViewById(R.id.img_complain_admin);
        imageComplainAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityAdmin.this, ComplainActivity.class);
                startActivity(intent);
            }
        });
    }
}
