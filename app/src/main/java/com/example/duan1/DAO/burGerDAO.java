package com.example.duan1.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1.database.DbHelper;
import com.example.duan1.model.monAn;

import java.util.ArrayList;

public class burGerDAO {
    DbHelper dbHelper;

    SQLiteDatabase database;

    public burGerDAO(Context context) {
        dbHelper = new DbHelper(context);
    }



    public ArrayList<monAn> getBuger(){
        ArrayList<monAn> list = new ArrayList<>();
        database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM MONAN WHERE tenloai = 'burger' ", null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                list.add(new monAn(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getString(3),
                        cursor.getString(4)));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public boolean add(monAn ma){
        database = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("TENMON", ma.getTenMonAn());
        cv.put("GIAMON", ma.getGiaMonAn());
        cv.put("MOTA", ma.getMoTaMonAn());
        long result = database.insert("SELECT * FROM MONAN",  null, cv);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean update(monAn ma){
        database = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("TENMON", ma.getTenMonAn());
        cv.put("GIA", ma.getGiaMonAn());
        cv.put("MOTA", ma.getMoTaMonAn());
        int check = database.update("MONAN", cv , "mamonan = ?", new String[]{String.valueOf(ma.getMaMonAn())});
        return check != -1;
    }


}
