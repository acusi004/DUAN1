package com.example.duan1.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1.database.DbHelper;

public class thongKeDAO {

    SQLiteDatabase database;

    DbHelper dbHelper;

    public thongKeDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    public int doanhThu(String tuNgay, String denNgay){
        tuNgay = tuNgay.replace("/", "");
        denNgay = denNgay.replace("/", "");
        database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT SUM(tongtien) FROM DONHANG WHERE substr(date,7)||substr(date,4,2)||substr(date,1,2) BETWEEN ? AND ? ", new String[]{tuNgay, denNgay});
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            return cursor.getInt(0);
        }
        return 0;
    }
}
