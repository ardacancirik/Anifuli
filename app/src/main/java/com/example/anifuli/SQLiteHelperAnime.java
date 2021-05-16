package com.example.anifuli;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelperAnime extends SQLiteOpenHelper {


    private static final String CREATE_TABLE_ANIME = " create table ANIMES ( name STRING PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL);";
    private static final String DB_NAME = "DBanime.db";
    private static final int DB_VERSION = 1;
    public static final String NAME = "name";
    public static final int SCORE = 0;

    public SQLiteHelperAnime(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ANIME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS ANIMES");
        onCreate(db);
    }
}
