package com.example.duan1.DAO;

import static android.content.Context.MODE_PRIVATE;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1.database.DbHelper;

public class nguoiDungDAO {
    DbHelper dbHelper;
    SQLiteDatabase database;
    SharedPreferences sharedPreferences;

    public nguoiDungDAO(Context context) {
        dbHelper = new DbHelper(context);
        sharedPreferences = context.getSharedPreferences("THONGTIN", MODE_PRIVATE);
    }

    public boolean InsertData (String user, String pass){
        database = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ten", user);
        cv.put("password", pass);
        long result = database.insert("NguoiDung", null, cv);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean checkUserPass(String user, String pass){
        database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM NGUOIDUNG WHERE TEN = ? AND PASSWORD = ?", new String[]{user, pass});
        if(cursor.getCount() !=0){
            // luu  SharedPreferences
            cursor.moveToFirst();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("TEN", cursor.getString(0));
            editor.putString("CHUCVU", cursor.getString(4));
            editor.commit();
            return true;
        }else{
            return  false;
        }
    }

    public boolean checkuser(String ten){
        database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM NGUOIDUNG WHERE TEN = ?", new String[]{ten});
        if(cursor.getCount()>0){
            return  true;
        }else{
            return false;
        }
    }




}
