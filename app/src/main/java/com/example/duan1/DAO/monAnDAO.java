package com.example.duan1.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1.database.DbHelper;
import com.example.duan1.model.monAn;

import java.util.ArrayList;

public class monAnDAO {
    DbHelper dbHelper;
    SQLiteDatabase database;

    public monAnDAO(Context context) {
        dbHelper = new DbHelper(context);
    }


    public ArrayList<monAn> getALl(){
        ArrayList<monAn> list = new ArrayList<>();
        database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM MONAN", null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                list.add(new monAn(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getString(3),
                        cursor.getInt(4)));
            }while (cursor.moveToNext());
        }
        return list;
    }

    public monAn getById(int id){
        Cursor cursor = database.query("MONAN", null, "MAMONAN =?", new String[]{String.valueOf(id)}, null, null, null );
        if(cursor.moveToNext()){
            return new monAn(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getString(3),
                    cursor.getInt(4));
        }else{
            return null;
        }
    }


}
