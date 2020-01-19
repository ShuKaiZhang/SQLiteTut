package com.example.administrator.sqlitetut;

import android.provider.BaseColumns;

/**
 * Created by Administrator on 2020/1/17.
 */

public class DBStructure {
    public static abstract class tableEntry implements BaseColumns {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_ID = "userid";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DOB = "dob";
    }
}
