package com.example.anifuli;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBcreator extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";
    private SQLiteHelper dbHelper;
    private SQLiteDatabase MyDB;
    private Context context;


    public DBcreator(Context context) {
        super(context, "Login.db", null, 1);
        this.context=context;
    }


    public DBcreator open() throws SQLException {
        this.dbHelper = new SQLiteHelper(this.context);
        this.MyDB = this.dbHelper.getWritableDatabase();
        return this;
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        this.MyDB=MyDB;
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT, mail TEXT, name TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        this.MyDB=MyDB;
        MyDB.execSQL("drop Table if exists users");
    }

    public boolean insertData(String username, String password, String mail, String name){
        MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("mail", mail);
        contentValues.put("name", name);
        long result = MyDB.insert("users", null, contentValues);
        if (result==-1) return false;
        else
            return true;
    }

    public boolean checkUsername(String username){
        MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[] {username});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public boolean checkUsernamePassword(String username, String password){
        MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if (cursor.getCount()>0){
            return true;
        }
        else
            return false;
    }

    public Cursor fetch() {
        Cursor cursor = this.MyDB.query(SQLiteHelper.TABLE_NAME_USER, new String[]{SQLiteHelper.USERNAME, SQLiteHelper.NAME, SQLiteHelper.MAIL, SQLiteHelper.PASSWORD}, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(String username, String name, String mail, String password) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLiteHelper.NAME, name);
        contentValues.put(SQLiteHelper.MAIL, mail);
        contentValues.put(SQLiteHelper.PASSWORD, password);
        return this.MyDB.update(SQLiteHelper.TABLE_NAME_USER, contentValues, "username = " + username, null);
    }

}
