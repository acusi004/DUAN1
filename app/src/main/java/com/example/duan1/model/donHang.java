package com.example.duan1.model;

public class donHang {
   private int idDonHang;
   private int idMonAn;
   private int idGioHang;

   private String tenMon;
   private int giaMon;

   private String img;
   private int soLuong;
   private int trangThai;
   private int sdt;
   private String  diaChi;


   public donHang() {
   }

   public donHang(int idDonHang, int idMonAn, int idGioHang, String tenMon, int giaMon, String img, int soLuong, int trangThai, int sdt, String diaChi) {
      this.idDonHang = idDonHang;
      this.idMonAn = idMonAn;
      this.idGioHang = idGioHang;
      this.tenMon = tenMon;
      this.giaMon = giaMon;
      this.img = img;
      this.soLuong = soLuong;
      this.trangThai = trangThai;
      this.sdt = sdt;
      this.diaChi = diaChi;

   }

   public int getIdDonHang() {
      return idDonHang;
   }

   public void setIdDonHang(int idDonHang) {
      this.idDonHang = idDonHang;
   }

   public int getIdMonAn() {
      return idMonAn;
   }

   public void setIdMonAn(int idMonAn) {
      this.idMonAn = idMonAn;
   }

   public int getIdGioHang() {
      return idGioHang;
   }

   public void setIdGioHang(int idGioHang) {
      this.idGioHang = idGioHang;
   }

   public String getTenMon() {
      return tenMon;
   }

   public void setTenMon(String tenMon) {
      this.tenMon = tenMon;
   }

   public int getGiaMon() {
      return giaMon;
   }

   public void setGiaMon(int giaMon) {
      this.giaMon = giaMon;
   }

   public int getSoLuong() {
      return soLuong;
   }

   public void setSoLuong(int soLuong) {
      this.soLuong = soLuong;
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



   public String getImg() {
      return img;
   }

   public void setImg(String img) {
      this.img = img;
   }
}