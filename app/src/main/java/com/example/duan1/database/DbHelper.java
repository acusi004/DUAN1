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

        String monAn = "CREATE TABLE MONAN (MAMONAN INTEGER PRIMARY KEY AUTOINCREMENT, TENMON TEXT, GIAMON TEXT,  MOTA TEXT)";
        db.execSQL(monAn);

        String gioHang = "CREATE TABLE GIOHANG (MAGIOHANG INTEGER PRIMARY KEY AUTOINCREMENT,SOLUONG INTEGER, SUM INTEGER, MAMONAN INTEGER REFERENCES MONAN(MAMONAN))";
        db.execSQL(gioHang);

        String donHang = "CREATE TABLE DONHANG (MADONHANG INTEGER PRIMARY KEY AUTOINCREMENT, TRANGTHAI INTEGER ,SDT TEXT, DIACHI TEXT, THOIGIAN TEXT,MAGIOHANG INTEGER REFERENCES GIOHANG(MAGIOHANG), MAMONAN INTEGER REFERENCES MONAN(MAMONAN))";
        db.execSQL(donHang);

        String lichSu = "CREATE TABLE LICHSU (MALICHSU INTEGER PRIMARY KEY AUTOINCREMENT, MAMONAN INTEGER REFERENCES MONAN(MAMONAN), MAGIOHANG INTEGER REFERENCES GIOHANG(MAGIOHANG), MADONHANG INTEGER REFERENCES DONHANG(MADONHANG))";
        db.execSQL(lichSu);


        // them du lieu mau vao bang
        db.execSQL("INSERT INTO NGUOIDUNG VALUES (1, 'admin','admin', 'dotrunghieu7490@gmail.com','Admin' ),(2, 'hieu','123', 'phanquocdat7490@gmail.com','Nguoi dung' )");
        db.execSQL("INSERT INTO MONAN VALUES" +
                "(1, 'Burger Classic', 150000,  'Một chiếc burger thơm ngon với bánh mì mềm mại, ')," +
                "(2, ' Pizza Pepperoni', 250000, 'Chiếc pizza nổi tiếng với lớp phô mai béo ngậy, ')," +
                "(3, ' Bánh Mì Gà Cajun', 350000, 'Gà nướng với gia vị Cajun đặc trưng, ăn kèm với bánh mì giòn tan')," +
                "(4, ' Salad Cesar Hải Sản', 550000, 'Một sự kết hợp hoàn hảo giữa rau xanh tươi ngon, tôm, mực và nước sốt ')," +
                "(5, 'Gà Rán Hấp Dẫn', 50000, ' Miếng gà tươi ngon, da giòn giòn cùng với lớp vỏ nước mắm')");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS NGUOIDUNG");
            db.execSQL("DROP TABLE IF EXISTS MONAN");
        }
    }
}
