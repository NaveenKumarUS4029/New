package com.example.anew;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DonerDBHelper extends SQLiteOpenHelper {
    SQLiteDatabase donersqLiteDatabase;
    public DonerDBHelper( Context context ) {
        super(context, "donerdatabase.db", null, 1);
        donersqLiteDatabase = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table donersdetails(Name TEXT, Password TEXT, Repassword TEXT, Mobile TEXT, Date TEXT, Time TEXT,BloodGroup TEXT,Location TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long save_details(String nameStr, String passStr, String repassStr, String mobStr, String dateStr, String timeStr, String bldgrpStr, String locStr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",nameStr);
        contentValues.put("Password",passStr);
        contentValues.put("Repassword",repassStr);
        contentValues.put("Mobile",mobStr);
        contentValues.put("Date",dateStr);
        contentValues.put("Time",timeStr);
        contentValues.put("Time",bldgrpStr);
        contentValues.put("Location",locStr);

        long n = donersqLiteDatabase.insert("donersdetails",null,contentValues);
         return n;

    }
}
