package com.example.duan1.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1.database.DbHelper;
import com.example.duan1.model.lichSu;

import java.util.ArrayList;

public class lichSuDAO {

    Context context;
    DbHelper dbHelper;

    SQLiteDatabase database;

    public lichSuDAO(Context context) {
        dbHelper = new DbHelper(context);
    }




    public ArrayList<lichSu> getALl(){
        ArrayList<lichSu> list = new ArrayList<>();
        database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM DONHANG", null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                list.add(new lichSu(
                        cursor.getInt(0),
                        cursor.getInt(1),
                        cursor.getInt(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getInt(5),
                        cursor.getString(6)));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }



}
