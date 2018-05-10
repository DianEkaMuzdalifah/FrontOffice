package com.ichigohoshimiya.frontoffice;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

public class SalaryActivity extends AppCompatActivity {
    EditText editTextNim;
    TextView mTextViewStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary);

        editTextNim = (EditText) findViewById(R.id.nim_salary);
        mTextViewStatus = (TextView) findViewById(R.id.tv_status_salary);

        Button mSalary1 = (Button) findViewById(R.id.search_salary);
        mSalary1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextNim.getText().toString().equals("6706151115")){
                    TableLayout tableLayout = (TableLayout) findViewById(R.id.table_salary);
                    tableLayout.setVisibility(View.VISIBLE);
                }
            }
        });
        final Button mBtnTableSalary = (Button) findViewById(R.id.btn_table_salary);
        mBtnTableSalary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(view.getContext());
                dialogBuilder.setTitle("Alert");
                dialogBuilder.setMessage("Are you sure want to take your salary?").
                        setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                mBtnTableSalary.setBackgroundColor(R.drawable.button_putih);
                                mBtnTableSalary.setClickable(false);
                                mTextViewStatus.setText("Requested");
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                    }
                });
                dialogBuilder.create().show();
            }
        });
    }
}
