package com.example.duan1.model;

public class gioHang {
    private int maGioHang;
    private int maMonAn;


    private String tenMonAn;
    private int soLuong;
    private int gia;

    private String img;






    public gioHang() {
    }



    public gioHang(int maGioHang, int maMonAn, String tenMonAn, int gia, String img) {
        this.maGioHang = maGioHang;
        this.maMonAn = maMonAn;
        this.tenMonAn = tenMonAn;
        this.gia = gia;
        this.img = img;
    }

    public int getMaGioHang() {
        return maGioHang;
    }

    public void setMaGioHang(int maGioHang) {
        this.maGioHang = maGioHang;
    }

    public int getMaMonAn() {
        return maMonAn;
    }

    public void setMaMonAn(int maMonAn) {
        this.maMonAn = maMonAn;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
