package com.example.duan1.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1.database.DbHelper;
import com.example.duan1.model.donHang;

import java.util.ArrayList;

public class donHangDAO {

    DbHelper dbHelper;
    SQLiteDatabase database;

    public donHangDAO(Context context) {
       dbHelper = new DbHelper(context);
    }

    public boolean insertDonHang(donHang dh){
        database = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("TRANGTHAI",dh.getTrangThai());
        cv.put("SDT", dh.getSdt());
        cv.put("DIACHI", dh.getDiaChi());
        cv.put("THOIGIAN", dh.getThoiGian());
        cv.put("MAGIOHANG", dh.getMaGioHang());
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
        Cursor cursor = database.rawQuery("SELECT dh.MADONHANG,dh.TRANGTHAI,dh.SDT,dh.DIACHI, dh.THOIGIAN, ma.TENMON, ma.GIAMON, gh.SOLUONG FROM DONHANG dh, MONAN ma, GIOHANG gh WHERE dh.magiohang = gh.magiohang AND dh.MAMONAN = ma.mamonan", null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do{

            }while (cursor.moveToNext());
        }
        return list;

    }

}
