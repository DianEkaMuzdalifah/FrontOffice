package com.ichigohoshimiya.frontoffice;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by CruthOvr on 11/05/2018.
 */

public class ComplainProvider extends ContentProvider{
    private ComplainDatabase mDatabaseHelper;

    private static final int COMPLAINS = 100;
    private static final int COMPLAIN_ID = 101;

    private static final UriMatcher sUriMatcher =
            new UriMatcher(UriMatcher.NO_MATCH);
    static {
        sUriMatcher.addURI(ComplainContract.AUTHORITY, ComplainContract.Complain.TABLE_NAME, COMPLAINS );
        sUriMatcher.addURI(ComplainContract.AUTHORITY, ComplainContract.Complain.TABLE_NAME + "/#", COMPLAIN_ID );
    }

    @Override
    public boolean onCreate() {
        mDatabaseHelper = new ComplainDatabase(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase db = mDatabaseHelper.getReadableDatabase();
        Cursor cursor;
        int match = sUriMatcher.match(uri);
        switch (match){
            case COMPLAINS :
                projection = new String[]{
                        ComplainContract.Complain.COLUMN_ID,
                        ComplainContract.Complain.COLUMN_NAME,
                        ComplainContract.Complain.COLUMN_CATEGORY,
                        ComplainContract.Complain.COLUMN_DESCRIPTION,
                        ComplainContract.Complain.COLUMN_STATUS
                };
                cursor = db.query(ComplainContract.Complain.TABLE_NAME, projection,
                        null,null,null,null,null);

                break;

            case COMPLAIN_ID :
                projection = new String[]{
                        ComplainContract.Complain.COLUMN_ID,
                        ComplainContract.Complain.COLUMN_NAME,
                        ComplainContract.Complain.COLUMN_CATEGORY,
                        ComplainContract.Complain.COLUMN_DESCRIPTION,
                        ComplainContract.Complain.COLUMN_STATUS
                };
                selection = ComplainContract.Complain.COLUMN_ID + " = ?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = db.query(ComplainContract.Complain.TABLE_NAME, projection,
                        selection,selectionArgs,null,null,null);
                break;

            default:
                throw new IllegalArgumentException("Invalid URI: " + uri);

        }
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
        long result ;
        int match = sUriMatcher.match(uri);
        switch (match){
            case COMPLAINS:
                result = db.insert(ComplainContract.Complain.TABLE_NAME, null, contentValues);
                break;

            default:
                throw new IllegalArgumentException("Invalid URI:" + uri);
        }
        if (result == -1 )
            return null;
        else {
            getContext().getContentResolver().notifyChange(uri, null);
            return ContentUris.withAppendedId(uri, result);
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
        int result ;
        int match = sUriMatcher.match(uri);
        switch (match){
            case COMPLAINS:
                result = db.delete(ComplainContract.Complain.TABLE_NAME, null, null);
                break;

            case COMPLAIN_ID:
                selection = ComplainContract.Complain.COLUMN_ID + " = ?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                result = db.delete(ComplainContract.Complain.TABLE_NAME, selection, selectionArgs);
                break;

            default:
                throw new IllegalArgumentException("Invalid URI:" + uri);
        }
        if (result > 0 )
            getContext().getContentResolver().notifyChange(uri, null);

        return result;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
        int result ;
        int match = sUriMatcher.match(uri);
        switch (match){

            case COMPLAIN_ID:
                selection = ComplainContract.Complain.COLUMN_ID + " = ?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                result = db.update(ComplainContract.Complain.TABLE_NAME, values,
                        selection, selectionArgs);
                break;

            default:
                throw new IllegalArgumentException("Invalid URI:" + uri);
        }
        if (result > 0 )
            getContext().getContentResolver().notifyChange(uri, null);

        return result;
    }
}
