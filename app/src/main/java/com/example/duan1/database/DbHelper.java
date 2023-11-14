package com.example.duan1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {



    public DbHelper( Context context) {
        super(context,"monAn", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // tao bang Nguoi dung
        String nguoiDung = "CREATE TABLE NGUOIDUNG (MANGUOIDUNG INTEGER PRIMARY KEY AUTOINCREMENT, TEN TEXT,PASSWORD TEXT, EMAIL TEXT, CHUCVU TEXT)";
        db.execSQL(nguoiDung);

        String monAn = "CREATE TABLE MONAN (MAMONAN INTEGER PRIMARY KEY AUTOINCREMENT, TENMON TEXT, GIAMON TEXT, SOLUONG INTEGER, MOTA TEXT, HINHANH INTEGER)";
        db.execSQL(monAn);

        db.execSQL("INSERT INTO NGUOIDUNG VALUES (1, 'admin','admin', 'dotrunghieu7490@gmail.com','Admin' ),(2, 'hieu','123', 'phanquocdat7490@gmail.com','Nguoi dung' )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS NGUOIDUNG");
        }
    }
}
