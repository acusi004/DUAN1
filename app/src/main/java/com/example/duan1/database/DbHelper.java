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

        String loaiMon = "CREATE TABLE LOAIMON(MALOAI INTEGER PRIMARY KEY AUTOINCREMENT, TENLOAI TEXT)";
        db.execSQL(loaiMon);

        String monAn = "CREATE TABLE MONAN (MAMONAN INTEGER PRIMARY KEY AUTOINCREMENT, TENMON TEXT, GIAMON TEXT, MOTA TEXT, HINHANH TEXT, TENLOAI TEXT REFERENCES LOAIMON(TENLOAI))";
        db.execSQL(monAn);

        String gioHang = "CREATE TABLE GIOHANG (MAGIOHANG INTEGER PRIMARY KEY AUTOINCREMENT,SOLUONG INTEGER, SUM INTEGER, MAMONAN INTEGER REFERENCES MONAN(MAMONAN))";
        db.execSQL(gioHang);

        String donHang = "CREATE TABLE DONHANG (MADONHANG INTEGER PRIMARY KEY AUTOINCREMENT, TRANGTHAI INTEGER ,SDT TEXT, DIACHI TEXT, THOIGIAN TEXT,MAGIOHANG INTEGER REFERENCES GIOHANG(MAGIOHANG), MAMONAN INTEGER REFERENCES MONAN(MAMONAN))";
        db.execSQL(donHang);

        String lichSu = "CREATE TABLE LICHSU (MALICHSU INTEGER PRIMARY KEY AUTOINCREMENT, MAMONAN INTEGER REFERENCES MONAN(MAMONAN), MAGIOHANG INTEGER REFERENCES GIOHANG(MAGIOHANG), MADONHANG INTEGER REFERENCES DONHANG(MADONHANG))";
        db.execSQL(lichSu);


        // them du lieu mau vao bang
        db.execSQL("INSERT INTO NGUOIDUNG VALUES (1, 'admin','admin', 'dotrunghieu7490@gmail.com','Admin' ),(2, 'hieu','123', 'phanquocdat7490@gmail.com','Nguoi dung' )");
        db.execSQL("INSERT INTO LOAIMON VALUES (1, 'burger'), (2, 'pizza'), (3, 'nuoc uong')");


        db.execSQL("INSERT INTO MONAN VALUES " +
                "(1, 'Burger Classic', 100000, 'Một chiếc burger thơm  ngon với bánh mì mềm mại','https://i.pinimg.com/236x/eb/cb/c6/ebcbc6aaa9deca9d6efc1efc93b66945.jpg', 'burger')," +
                " (2, 'Pizza Pepperoni', 200000, 'Chiếc pizza nổi tiếng với lớp phô mai béo ngậy','https://i.pinimg.com/236x/e6/1c/ef/e61cef37dffe3af9ce48d9e119176203.jpg', 'pizza')," +
                " (3, 'cocacola', 10000, 'Sự kết hợp đặc sắc giữa mâm xôi mát lạnh và hương bạc hà tươi mới','https://i.pinimg.com/236x/ec/c3/fa/ecc3fa67154eb6a9ee8bd58943233322.jpg', 'nuoc uong')," +
                " (4, 'Spicy Chicken Delight', 200000, 'Burger gà cay nồng, với patty gà chiên giòn','https://i.pinimg.com/236x/c8/4d/1e/c84d1e202914a5b04b648c9f528d27b9.jpg', 'burger')," +
                "(5,'Mushroom Swiss Bliss', 100000, 'Một trải nghiệm thú vị với patty bò','https://i.pinimg.com/236x/09/37/b6/0937b659acd0ae46a1e1c173ae9bcbc3.jpg','burger')," +
                "(6,'BBQ Bacon Explosion', 3000, 'Burger đậm chất BBQ với patty bò, bacon giòn ','https://i.pinimg.com/236x/13/d8/a3/13d8a33b9ee9c5705ea7ea07af3b8744.jpg', 'burger')," +
                "(7, 'Fishermans Catch Burger', 40000, ' Burger hải sản tươi ngon với patty cá hồi ','https://i.pinimg.com/236x/1e/65/4f/1e654fac595d426d7ffffccd754b5977.jpg', 'burger')," +
                "(8 ,'Margherita Supreme', 9000, 'Pizza cổ điển với sốt cà chua, phô mai mozzarella ','https://i.pinimg.com/236x/fe/a7/dd/fea7ddb8e979bb8e78a0595213b3e0fc.jpg', 'pizza')," +
                "(9, 'Vegetarian Garden Delight', 84000, 'Pizza chay ngon miệng với nấm tươi','https://i.pinimg.com/236x/b1/4e/96/b14e967be4d2d4d121ec19d6de13ea7c.jpg', 'pizza')," +
                "(10, 'BBQ Chicken Fiesta', 47000, 'Pizza gà BBQ ngon tuyệt với patty gà','https://i.pinimg.com/236x/54/60/a0/5460a0721c26e6d3c7a1848ac1a24abd.jpg', 'pizza')," +
                "(11, 'Seafood Sensation', 75000, 'Pizza hải sản đặc biệt với hải sản tươi','https://i.pinimg.com/236x/21/81/e4/2181e40e5fe024074073f44edee40293.jpg', 'pizza')," +
                "(12, 'Sparkling Citrus Burst', 20000, 'Một hòa quyện tuyệt vời giữa cam  ','https://i.pinimg.com/236x/16/0d/bc/160dbcd3eecf04afafbd4eb0aac43b80.jpg','nuoc uong' )," +
                "(13, 'Berry Fizz Delight', 19000, 'Hương vị ngọt ngào của dâu tây và mâm xôi','https://i.pinimg.com/236x/20/1e/41/201e41ff15b6599bb597a9bb801c4b34.jpg', 'nuoc uong')," +
                "(14, 'Chocolate Coffee Sparkle', 20000, 'Một kết hợp độc đáo giữa sô cô la ','https://i.pinimg.com/236x/f2/65/7c/f2657c204b9893a2f8f2207dfc16e0c9.jpg', 'nuoc uong')," +
                "(15, 'Velvet Grape Splash', 29000, ' Hương vị tinh tế của nho và vải, ','https://i.pinimg.com/236x/e8/b4/e5/e8b4e57c0a3e814d669c37d3b84a3225.jpg', 'nuoc uong')");


//        db.execSQL("INSERT INTO MONAN VALUES" +
//                "(1, 'Burger Classic', 150000,  'Một chiếc burger thơm ngon với bánh mì mềm mại, ')," +
//                "(2, ' Pizza Pepperoni', 250000, 'Chiếc pizza nổi tiếng với lớp phô mai béo ngậy, ')," +
//                "(3, ' Bánh Mì Gà Cajun', 350000, 'Gà nướng với gia vị Cajun đặc trưng, ăn kèm với bánh mì giòn tan')," +
//                "(4, ' Salad Cesar Hải Sản', 550000, 'Một sự kết hợp hoàn hảo giữa rau xanh tươi ngon, tôm, mực và nước sốt ')," +
//                "(5, 'Gà Rán Hấp Dẫn', 50000, ' Miếng gà tươi ngon, da giòn giòn cùng với lớp vỏ nước mắm')");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS NGUOIDUNG");
            db.execSQL("DROP TABLE IF EXISTS MONAN");
        }
    }
}
