package com.example.duan1.DAO;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1.database.DbHelper;
import com.example.duan1.model.loaiMon;
import com.example.duan1.model.monAn;

import java.util.ArrayList;

public class loaiDao {
    DbHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;


    public loaiDao (Context context){
        dbHelper = new DbHelper(context);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }
    public ArrayList<loaiMon>getDSLoaiMon(){
        ArrayList<loaiMon> list = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM LOAIMON", null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                list.add(new loaiMon(cursor.getInt(0),
                        cursor.getString(1)));
            }while (cursor.moveToNext());
        }
        return list;
    }
    @SuppressLint("Range")
    public ArrayList<String> getName(String sql,String...SelectAvgs){
        ArrayList<String> lst=new ArrayList<>();
        Cursor cursor=sqLiteDatabase.rawQuery(sql,SelectAvgs);
        while (cursor.moveToNext()){
            String name=cursor.getString(cursor.getColumnIndex("TENLOAI"));
            lst.add(name);
        }
        return lst;

    }
    public ArrayList<String> name(){
        String name = "SELECT TENLOAI FROM LOAIMON";
        return getName(name);
    }
}
