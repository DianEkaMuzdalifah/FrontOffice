package com.ichigohoshimiya.frontoffice;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class ComplainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{
    Spinner dropdownComplain;
    EditText mEtName, mEtDescription;

    Button mBtnSave;
    int mCategory = 0;

    private Uri mCurrentUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);


        dropdownComplain = (Spinner) findViewById(R.id.pilih_category);
        mEtName = (EditText) findViewById(R.id.et_nameComplain);
        mEtDescription = (EditText) findViewById(R.id.et_descriptionComplain);

        setupSpinnerCategory();

        mBtnSave = (Button) findViewById(R.id.btn_save_complain);
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDataComplain();
                finish();
            }
        });

        ImageView historyComplain = (ImageView) findViewById(R.id.history);
        historyComplain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(view.getContext());
                View dialogView = getLayoutInflater().inflate(R.layout.activity_pin, null);

                final EditText enter_pin;
                final ImageView c1, c2, c3, c4, c5;

                c1 = (ImageView) dialogView.findViewById(R.id.circle1);
                c2 = (ImageView) dialogView.findViewById(R.id.circle2);
                c3 = (ImageView) dialogView.findViewById(R.id.circle3);
                c4 = (ImageView) dialogView.findViewById(R.id.circle4);
                c5 = (ImageView) dialogView.findViewById(R.id.circle5);

                Button btnConfirmPin = (Button) dialogView.findViewById(R.id.confirm);
                enter_pin = (EditText) dialogView.findViewById(R.id.enter_pin);
                enter_pin.requestFocus();

                enter_pin.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        int i = 0;
                        if (enter_pin.length() == 0 && i == 0) {
                            c1.setImageResource(R.drawable.circle);
                            c2.setImageResource(R.drawable.circle);
                            c3.setImageResource(R.drawable.circle);
                            c4.setImageResource(R.drawable.circle);
                            c5.setImageResource(R.drawable.circle);
                        } else if (enter_pin.length() == 1){
                            c1.setImageResource(R.drawable.circle2);
                            c2.setImageResource(R.drawable.circle);
                            c3.setImageResource(R.drawable.circle);
                            c4.setImageResource(R.drawable.circle);
                            c5.setImageResource(R.drawable.circle);
                            i = 1;
                        } else if (enter_pin.length() == 2){
                            c1.setImageResource(R.drawable.circle2);
                            c2.setImageResource(R.drawable.circle2);
                            c3.setImageResource(R.drawable.circle);
                            c4.setImageResource(R.drawable.circle);
                            c5.setImageResource(R.drawable.circle);
                            i = 2;
                        } else if (enter_pin.length() == 3){
                            c1.setImageResource(R.drawable.circle2);
                            c2.setImageResource(R.drawable.circle2);
                            c3.setImageResource(R.drawable.circle2);
                            c4.setImageResource(R.drawable.circle);
                            c5.setImageResource(R.drawable.circle);
                            i = 3;
                        } else if (enter_pin.length() == 4){
                            c1.setImageResource(R.drawable.circle2);
                            c2.setImageResource(R.drawable.circle2);
                            c3.setImageResource(R.drawable.circle2);
                            c4.setImageResource(R.drawable.circle2);
                            c5.setImageResource(R.drawable.circle);
                            i = 4;
                        } else if (enter_pin.length() == 5){
                            c1.setImageResource(R.drawable.circle2);
                            c2.setImageResource(R.drawable.circle2);
                            c3.setImageResource(R.drawable.circle2);
                            c4.setImageResource(R.drawable.circle2);
                            c5.setImageResource(R.drawable.circle2);
                            i = 5;
                        }
                    }
                });

                dialogBuilder.setView(dialogView);
                final AlertDialog dialog = dialogBuilder.create();
                dialog.show();

                btnConfirmPin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(enter_pin.getText().toString().equals("01217")){
                            Intent intent = new Intent(ComplainActivity.this, HistoryComplainActivity.class);
                            startActivity(intent);
                            dialog.dismiss();
                        } else if (enter_pin.getText().toString().equals("")){
                            Toast.makeText(ComplainActivity.this, "Enter a Pin !!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ComplainActivity.this, "Wrong Pin !!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    private void saveDataComplain(){
        ContentValues values = new ContentValues();
        values.put(ComplainContract.Complain.COLUMN_NAME,
                mEtName.getText().toString());
        values.put(ComplainContract.Complain.COLUMN_DESCRIPTION,
                mEtDescription.getText().toString());
        values.put(ComplainContract.Complain.COLUMN_CATEGORY,
                mCategory);
        values.put(ComplainContract.Complain.COLUMN_STATUS,
                "Pending");

        if (mCurrentUri == null)
            getContentResolver().insert(ComplainContract.Complain.CONTENT_URI, values);
        else
            getContentResolver().update(mCurrentUri, values, null, null);

        Toast.makeText(this, "Complain has been submitted", Toast.LENGTH_SHORT).show();
    }

    private void setupSpinnerCategory(){
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.categoryComplain));
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownComplain.setAdapter(mAdapter);

        dropdownComplain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.facility))) {
                        mCategory = 1; // facility
                    } else if (selection.equals(getString(R.string.service))) {
                        mCategory = 2; // service
                    } else {
                        mCategory = 0; // Unknown
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mCategory = 0; // Unknown
            }
        });
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this, mCurrentUri,
                null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor.moveToNext()) {
            mEtName.setText(cursor.getString(
                    cursor.getColumnIndex(ComplainContract.Complain.COLUMN_NAME)));
            mEtDescription.setText(cursor.getString(
                    cursor.getColumnIndex(ComplainContract.Complain.COLUMN_DESCRIPTION)));
            dropdownComplain.setSelection(cursor.getInt(
                    cursor.getColumnIndex(ComplainContract.Complain.COLUMN_CATEGORY)));
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mEtName.setText("");
        mEtDescription.setText("");
        dropdownComplain.setSelection(0);
    }
}
