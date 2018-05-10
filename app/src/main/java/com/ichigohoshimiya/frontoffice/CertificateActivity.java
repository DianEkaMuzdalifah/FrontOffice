package com.ichigohoshimiya.frontoffice;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CertificateActivity extends AppCompatActivity {
    Spinner dropdown;
    EditText mEditTextNim;
    TextView mTextViewTaker, mTextViewStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificate);

        dropdown = (Spinner) findViewById(R.id.pilih_mk);
        String[] items = new String[]{"Choose MK", "MK_1", "MK_2"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        mEditTextNim = (EditText) findViewById(R.id.nim_certificate);
        mTextViewTaker = (TextView) findViewById(R.id.tv_taker);
        mTextViewStatus = (TextView) findViewById(R.id.tv_status_certificate);

        Button mSertificate1 = (Button) findViewById(R.id.search_certificate1);
        mSertificate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEditTextNim.getText().toString().equals("6706151115")){
                    TableLayout tableLayout = (TableLayout) findViewById(R.id.table_certificate);
                    tableLayout.setVisibility(View.VISIBLE);
                }
            }
        });
        final Button mBtnTableCertificate = (Button) findViewById(R.id.btn_table_certificate);
        mBtnTableCertificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(view.getContext());
                View dialogView = getLayoutInflater().inflate(R.layout.custom_alert_certificate, null);
                Button mBtnTake = (Button) dialogView.findViewById(R.id.btn_take);
                final EditText mTextViewNameTaker = (EditText) dialogView.findViewById(R.id.name_taker);
                dialogBuilder.setView(dialogView);
                final AlertDialog dialog = dialogBuilder.create();
                dialog.show();
                mBtnTake.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (mTextViewNameTaker.getText().toString().equals("")){
                            Toast.makeText(CertificateActivity.this, "Form Nama Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                        } else{
                            mBtnTableCertificate.setBackgroundColor(R.drawable.button_putih);
                            mBtnTableCertificate.setClickable(false);
                            mTextViewTaker.setText(mTextViewNameTaker.getText().toString());
                            mTextViewStatus.setText("Taken");
                            dialog.dismiss();
                        }
                    }
                });
            }
        });
    }
}
