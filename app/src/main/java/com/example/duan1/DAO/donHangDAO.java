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
        cv.put("THOIGIAN", dh.getNgay());
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
        Cursor cursor = database.rawQuery("SELECT dh.madonhang, ma.mamonan,gh.magiohang, ma.tenmon, ma.giamon, gh.soluong, dh.TRANGTHAI, dh.SDT, dh.DIACHI, dh.THOIGIAN FROM  DONHANG dh, MONAN ma, GIOHANG gh WHERE dh.mamonan = ma.mamonan and dh.magiohang = gh.magiohang", null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                list.add(new donHang(cursor.getInt(0),
                        cursor.getInt(1),
                        cursor.getInt(2),
                        cursor.getString(3),
                        cursor.getInt(4),
                        cursor.getString(5),
                        cursor.getInt(6),
                        cursor.getInt(7),
                        cursor.getInt(8),
                        cursor.getString(9),
                        cursor.getString(10)));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return list;

    }

}
