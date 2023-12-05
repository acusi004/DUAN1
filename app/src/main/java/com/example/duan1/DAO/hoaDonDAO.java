package com.example.duan1.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1.database.DbHelper;
import com.example.duan1.model.donHang;

import java.util.ArrayList;

public class hoaDonDAO {

    DbHelper dbHelper;
    SQLiteDatabase database;

    public hoaDonDAO(Context context) {
       dbHelper = new DbHelper(context);
    }

    public boolean insertDonHang(donHang dh){
        database = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("MAGIOHANG", dh.getIdGioHang());
        cv.put("TRANGTHAI",dh.getTrangThai());
        cv.put("SDT", dh.getSdt());
        cv.put("DIACHI", dh.getDiaChi());
        cv.put("CONTENT", dh.getContent());
        cv.put("TONGTIEN", dh.getTongTien());
        cv.put("DATE", dh.getDate());

        long result = database.insert("DONHANG", null, cv);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public ArrayList<donHang> getAll(){
        ArrayList<donHang> list = new ArrayList<>();
        database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM DONHANG", null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                list.add(new donHang(cursor.getInt(0),
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

    public boolean updateTT(int madh){
        database = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("TRANGTHAI", 1);
       long check =  database.update("DONHANG", cv, "trangthai = ?",new String[]{String.valueOf(madh)});
        if(check==-1){
            return false;
        }else{
            return true;
        }
    }




}
