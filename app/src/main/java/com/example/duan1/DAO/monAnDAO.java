package com.example.duan1.DAO;

import android.content.ContentValues;
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
                        cursor.getString(4),
                        cursor.getString(5)));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }



    public boolean add(monAn ma){
        database = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("TENMON",ma.getTenMonAn());
        cv.put("GIAMON",ma.getGiaMonAn());
        cv.put("MOTA", ma.getMoTaMonAn());
        cv.put("HINHANH", ma.getImg());
        cv.put("TENLOAI", ma.getTenLoai());
        long check = database.insert("MONAN", null, cv);
        if(check ==-1){
            return false;
        }else{
            return true;
        }
    }

    public boolean delete(int id){
        database = dbHelper.getWritableDatabase();
        int row = database.delete("MONAN", "mamonan =?", new String[]{String.valueOf(id)});
        return row != -1;
    }
    public ArrayList<String> getTenLoaiMonAnList() {
        ArrayList<String> listTenLoai = new ArrayList<>();
        database = dbHelper.getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT TENLOAI FROM MONAN", null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                listTenLoai.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return listTenLoai;
    }
    public boolean update(monAn ma) {
        database = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("TENMON", ma.getTenMonAn());
        cv.put("GIAMON", ma.getGiaMonAn());
        cv.put("MOTA", ma.getMoTaMonAn());
        cv.put("HINHANH", ma.getImg());
        cv.put("TENLOAI", ma.getTenLoai());

        int row = database.update("MONAN", cv, "mamonan =?", new String[]{String.valueOf(ma.getMaMonAn())});
        return row > 0;
    }


}
