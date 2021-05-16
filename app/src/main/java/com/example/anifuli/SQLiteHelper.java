package com.example.anifuli;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    public static final String MAIL = "mail";
    private static final String CREATE_TABLE_USER = " create table USERS ( username STRING PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL , MAIL TEXT );";
    private static final String DB_NAME = "Login.db";
    private static final int DB_VERSION = 1;
    public static final String NAME = "name";
    public static final String PASSWORD = "password";
    public static final String TABLE_NAME_USER = "USERS";
    public static final String USERNAME = "username";

    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USERS");
        onCreate(db);
    }
}
