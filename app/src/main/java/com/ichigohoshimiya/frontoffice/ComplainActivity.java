package com.ichigohoshimiya.frontoffice;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class ComplainActivity extends AppCompatActivity {
    Spinner dropdownComplain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);

        dropdownComplain = (Spinner) findViewById(R.id.pilih_category);
        String[] items = new String[]{"Category", "Facility", "Service"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdownComplain.setAdapter(adapter);

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

                enter_pin = (EditText) dialogView.findViewById(R.id.enter_pin);
                enter_pin.requestFocus();
                enter_pin.setInputType(InputType.TYPE_CLASS_NUMBER);
                enter_pin.setFocusableInTouchMode(true);
                

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
                AlertDialog dialog = dialogBuilder.create();
                dialog.show();
            }
        });
    }
}
