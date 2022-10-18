package com.example.anew;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    SQLiteDatabase sqLiteDatabase;
    public DataBaseHelper(Context context) {
        super(context, "admindatabase.db", null, 1);
        sqLiteDatabase=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table doners(Name Text,Location Text,Mobile Text,Password Text,Repassword Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }


    public long save_details(String strNameAdmin, String strLocaAdmin, String strMobAdmin, String strPassAdmin, String strRepassAdmin) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", strNameAdmin);
        contentValues.put("Location", strLocaAdmin);
        contentValues.put("Mobile", strMobAdmin);
        contentValues.put("Password", strPassAdmin);
        contentValues.put("Repassword", strRepassAdmin);

        long n = sqLiteDatabase.insert("doners",null,contentValues);
        return n;
    }
}
