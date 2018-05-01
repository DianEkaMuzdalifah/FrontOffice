package com.ichigohoshimiya.frontoffice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText uname, pass;
    Button button;
    int posisi = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        uname = (EditText) findViewById(R.id.uname);
        pass = (EditText) findViewById(R.id.pass);
        button = (Button) findViewById(R.id.login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(uname.getText().toString().equals("laboran") && pass.getText().toString().equals("laboran")) {
                    startActivity(new Intent(LoginActivity.this, MainActivityLaboran.class));
                }
                else if (uname.getText().toString().equals("admin1") && pass.getText().toString().equals("admin1")){
                    startActivity(new Intent(LoginActivity.this, MainActivityLaboran.class));
                }
                else if (uname.getText().toString().equals("admin2") && pass.getText().toString().equals("admin2")){
                    startActivity(new Intent(LoginActivity.this, MainActivityLaboran.class));
                }
                else if (uname.getText().toString().equals("admin3") && pass.getText().toString().equals("admin3")){
                    startActivity(new Intent(LoginActivity.this, MainActivityLaboran.class));
                }
                else {
                    Toast.makeText(LoginActivity.this, "Gagal, Username atau Password salah!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
