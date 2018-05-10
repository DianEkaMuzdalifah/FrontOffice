package com.ichigohoshimiya.frontoffice;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by CruthOvr on 11/05/2018.
 */

public class ComplainContract {
    private ComplainContract() {}

    public static final String AUTHORITY ="com.ichigohoshimiya.frontoffice";
    public  static  final Uri BASE_URI = Uri.parse(
            "content://" + AUTHORITY);
    /* Inner class that defines the table contents */
    public static class Complain implements BaseColumns {
        public static final String TABLE_NAME = "complain";
        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_STATUS = "status";

        public static final Uri CONTENT_URI = Uri.withAppendedPath(
                BASE_URI, TABLE_NAME);

    }
}
