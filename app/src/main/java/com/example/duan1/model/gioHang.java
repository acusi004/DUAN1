package com.example.duan1.model;

public class gioHang {
    private int maGioHang;
    private int maMonAn;
    private int soLuong;
    private int gia;
    private String tenMon;


    public gioHang() {
    }

    public gioHang(int maGioHang, int maMonAn, String tenMon,int soLuong, int gia) {
        this.maGioHang = maGioHang;
        this.maMonAn = maMonAn;
        this.tenMon = tenMon;
        this.soLuong = soLuong;
        this.gia = gia;

    }



    public int getMaMonAn() {
        return maMonAn;
    }

    public void setMaMonAn(int maMonAn) {
        this.maMonAn = maMonAn;
    }

    public int getMaGioHang() {
        return maGioHang;
    }

    public void setMaGioHang(int maGioHang) {
        this.maGioHang = maGioHang;
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

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }
}
