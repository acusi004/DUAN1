package com.example.duan1.model;

public class donHang {
    private int maDonHang;
    private int trangThai;
    private int sdt;
    private String diaChi;
    private String thoiGian;
    private int maGioHang;
    private int maMonAn;

    private String tenMonAn;
    private int soLuong;
    private int gia;

    public donHang(int maDonHang, int trangThai, int sdt, String diaChi, String thoiGian, int maGioHang, int maMonAn) {
        this.maDonHang = maDonHang;
        this.trangThai = trangThai;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.thoiGian = thoiGian;
        this.maGioHang = maGioHang;
        this.maMonAn = maMonAn;
    }


    public donHang(int maDonHang, int trangThai, int sdt, String diaChi, String thoiGian, int maGioHang, int maMonAn, String tenMonAn, int soLuong, int gia) {
        this.maDonHang = maDonHang;
        this.trangThai = trangThai;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.thoiGian = thoiGian;
        this.maGioHang = maGioHang;
        this.maMonAn = maMonAn;
        this.tenMonAn = tenMonAn;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public int getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
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

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
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
}