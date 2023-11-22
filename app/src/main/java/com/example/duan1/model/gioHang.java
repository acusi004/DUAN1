package com.example.duan1.model;

public class gioHang {
    private int maGioHang;
    private int maMonAn;
    private int soLuong;
    private double gia;



    public gioHang() {
    }

    public gioHang(int maGioHang, int maMonAn, int soLuong, double gia) {
        this.maGioHang = maGioHang;
        this.maMonAn = maMonAn;
        this.soLuong = soLuong;
        this.gia = gia;
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

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
}
