package com.example.duan1.model;

public class monAn {

    private int maMonAn;
    private String tenMonAn;
    private int giaMonAn;

    private String moTaMonAn;

    private String img;

    private String tenLoai;

    public monAn(int maMonAn, String tenMonAn, int giaMonAn, String moTaMonAn, String img, String tenLoai) {
        this.maMonAn = maMonAn;
        this.tenMonAn = tenMonAn;
        this.giaMonAn = giaMonAn;
        this.moTaMonAn = moTaMonAn;
        this.img = img;
        this.tenLoai = tenLoai;
    }

    public monAn(int maMonAn, String tenMonAn, int giaMonAn, String moTaMonAn, String tenLoai) {
        this.maMonAn = maMonAn;
        this.tenMonAn = tenMonAn;
        this.giaMonAn = giaMonAn;
        this.moTaMonAn = moTaMonAn;
        this.tenLoai = tenLoai;
    }

    public monAn() {
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public String getMoTaMonAn() {
        return moTaMonAn;
    }

    public void setMoTaMonAn(String moTaMonAn) {
        this.moTaMonAn = moTaMonAn;
    }

    public int getGiaMonAn() {
        return giaMonAn;
    }

    public void setGiaMonAn(int giaMonAn) {
        this.giaMonAn = giaMonAn;
    }



    public int getMaMonAn() {
        return maMonAn;
    }

    public void setMaMonAn(int maMonAn) {
        this.maMonAn = maMonAn;
    }
    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
