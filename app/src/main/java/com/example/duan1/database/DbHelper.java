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

        String loaiMon = "CREATE TABLE LOAIMON (MALOAI INTEGER PRIMARY KEY AUTOINCREMENT, TENLOAI TEXT)";
        db.execSQL(loaiMon);

        String monAn = "CREATE TABLE MONAN (MAMONAN INTEGER PRIMARY KEY AUTOINCREMENT, TENMON TEXT, GIAMON TEXT, SOLUONG INTEGER, MOTA TEXT, MALOAI INTEGER  REFERENCES LOAIMON(MALOAI))";
        db.execSQL(monAn);

        String gioHang = "CREATE TABLE GIOHANG (MAGIOHANG INTEGER PRIMARY KEY AUTOINCREMENT, MAMONAN INTEGER REFERENCES MONAN(MAMONAN))";
        db.execSQL(gioHang);

        String donHang = "CREATE TABLE DONHANG (MADONHANG INTEGER PRIMARY KEY AUTOINCREMENT, NGAY TEXT, TRANGTHAI INTEGER ,MAMONAN INTEGER REFERENCES MONAN(MAMONAN))";
        db.execSQL(donHang);


        // them du lieu mau vao bang
        db.execSQL("INSERT INTO NGUOIDUNG VALUES (1, 'admin','admin', 'dotrunghieu7490@gmail.com','Admin' ),(2, 'hieu','123', 'phanquocdat7490@gmail.com','Nguoi dung' )");
        db.execSQL("INSERT INTO LOAIMON VALUES (1, 'burger'), (2, 'pizza'), (3, 'cocacola')");
        db.execSQL("INSERT INTO MONAN VALUES(1, 'burger bo', 150000, 1, 'là một chuỗi nhà hàng thức ăn nhanh hamburger toàn cầu của Mỹ. ', 1), (2, 'pizza cheese', 250000, 2, 'là một chuỗi nhà hàng thức ăn nhanh hamburger toàn cầu của Mỹ. ', 2),(3, 'KFC', 50000, 5, 'là một chuỗi nhà hàng thức ăn nhanh hamburger toàn cầu của Mỹ. ', 3)");
        db.execSQL("INSERT INTO GIOHANG VALUES (1, 1)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS NGUOIDUNG");
            db.execSQL("DROP TABLE IF EXISTS MONAN");
        }
    }
}
