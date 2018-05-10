package com.ichigohoshimiya.frontoffice;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class HistoryComplainActivity extends AppCompatActivity {

    TableLayout tableHistoryComplain;
    ComplainDatabase dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_complain);

        tableHistoryComplain = (TableLayout) findViewById(R.id.tablelayout);
        dbHelper = new ComplainDatabase(this);

        TableRow rowHeader = new TableRow(this);
        rowHeader.setBackgroundColor(Color.parseColor("#c0c0c0"));
        rowHeader.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
        String[] headerText={"No","Name","Category","Description","Status","Action"};

        for (String c:headerText){
            TextView textView = new TextView(this);
            textView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(18);
            textView.setPadding(5, 5, 5, 5);
            textView.setText(c);
            rowHeader.addView(textView);
        }
        tableHistoryComplain.addView(rowHeader);

        // Get data from sqlite database and add them to the table
        // Open the database for reading
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        // Start the transaction.
        db.beginTransaction();

        try
        {
            String selectQuery = "SELECT * FROM "+ ComplainContract.Complain.TABLE_NAME;
            Cursor cursor = db.rawQuery(selectQuery,null);
            if(cursor.getCount() >0)
            {
                while (cursor.moveToNext()) {
                    // Read columns data
                    int complain_id = cursor.getInt(cursor.getColumnIndex(ComplainContract.Complain.COLUMN_ID));
                    String complain_name = cursor.getString(cursor.getColumnIndex(ComplainContract.Complain.COLUMN_NAME));
                    String complain_category = "";
                    switch (cursor.getInt(cursor.getColumnIndex(ComplainContract.Complain.COLUMN_CATEGORY))){
                        case 1:
                            complain_category = "Facility";
                            break;
                        case 2:
                            complain_category = "Service";
                            break;
                    }
                    String description = cursor.getString(cursor.getColumnIndex(ComplainContract.Complain.COLUMN_DESCRIPTION));
                    String status = cursor.getString(cursor.getColumnIndex(ComplainContract.Complain.COLUMN_STATUS));

                    // dara rows
                    TableRow row = new TableRow(this);
                    row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.WRAP_CONTENT));
                    String[] colText={complain_id+"",complain_name,String.valueOf(complain_category), description, status};
                    for(String text:colText) {
                        TextView tv = new TextView(this);
                        tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                                TableRow.LayoutParams.WRAP_CONTENT));
                        tv.setGravity(Gravity.CENTER);
                        tv.setTextSize(16);
                        tv.setPadding(5, 5, 5, 5);
                        tv.setText(text);
                        row.addView(tv);
                    }
                    tableHistoryComplain.addView(row);

                }

            }
            db.setTransactionSuccessful();

        }
        catch (SQLiteException e)
        {
            e.printStackTrace();

        }
        finally
        {
            db.endTransaction();
            // End the transaction.
            db.close();
            // Close database
        }
    }
}
