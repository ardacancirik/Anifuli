package com.example.anifuli;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBAnime extends SQLiteOpenHelper {

    public static final String DBNAME = "DBanime.db";
    private SQLiteHelperAnime dbHelper;
    private SQLiteDatabase MyDB;
    private Context context;


    public DBAnime (Context context) {
        super(context, "Login.db", null, 1);
        this.context=context;
    }


    public DBAnime open() throws SQLException {
        this.dbHelper = new SQLiteHelperAnime(this.context);
        this.MyDB = this.dbHelper.getWritableDatabase();
        return this;
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        this.MyDB=MyDB;
        MyDB.execSQL("create Table animes(name TEXT primary key, score TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        this.MyDB=MyDB;
        MyDB.execSQL("drop Table if exists animes");
    }

    public boolean insertDataAnime(String name, String score){
        MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("score", score);
        long result = MyDB.insert("animes", null, contentValues);
        if (result==-1)
            return false;
        else
            return true;
    }
}
