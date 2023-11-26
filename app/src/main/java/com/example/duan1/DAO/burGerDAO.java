package com.example.duan1.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1.database.DbHelper;
import com.example.duan1.model.monAn;

public class burGerDAO {
    DbHelper dbHelper;

    SQLiteDatabase database;

    public burGerDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    public boolean add(monAn ma){
        database = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("TENMON", ma.getTenMonAn());
        cv.put("GIAMON", ma.getGiaMonAn());
        cv.put("MOTA", ma.getMoTaMonAn());
        cv.put("MALOAI", ma.getMaLoai());
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
