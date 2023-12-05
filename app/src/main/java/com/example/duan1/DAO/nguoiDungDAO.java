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

    public boolean InsertData (String user, String pass, String chucvu){
        database = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("TEN", user);
        cv.put("PASSWORD", pass);
        cv.put("CHUCVU", chucvu);
        long result = database.insert("NGUOIDUNG", null, cv);
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
            editor.putString("TEN", cursor.getString(1));
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


    public boolean updatePassWord(String ten, String oldPass, String newPass){
        database = dbHelper.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM NGUOIDUNG WHERE ten = ? AND password = ?", new String[]{ten, oldPass});
        if(cursor.getCount()>0){
            ContentValues cv = new ContentValues();
            cv.put("PASSWORD", newPass);
            long check = database.update("NGUOIDUNG",cv, "ten = ?", new String[]{ten});
            if(check == -1){
                return false;
            }else{
                return true;
            }
        }
        return false;
    }




}
