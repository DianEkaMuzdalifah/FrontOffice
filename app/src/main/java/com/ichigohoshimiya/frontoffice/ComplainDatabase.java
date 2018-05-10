package com.ichigohoshimiya.frontoffice;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CruthOvr on 11/05/2018.
 */

public class ComplainDatabase extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Complain.db";

    public ComplainDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + ComplainContract.Complain.TABLE_NAME + " (" +
                        ComplainContract.Complain._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        ComplainContract.Complain.COLUMN_NAME + " TEXT NOT NULL," +
                        ComplainContract.Complain.COLUMN_CATEGORY + " INTEGER NOT NULL," +
                        ComplainContract.Complain.COLUMN_DESCRIPTION + " TEXT NOT NULL," +
                        ComplainContract.Complain.COLUMN_STATUS + " TEXT NOT NULL )";
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
