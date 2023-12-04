package com.example.duan1.model;

public class donHang {
   private int idDonHang;
   private int idGioHang;
   private int tongTien;
   private int trangThai;

   private int sdt;
   private String diaChi;
   private String content;
   private String date;

   public donHang() {
   }



   public donHang(int idDonHang,int trangThai, int sdt, String diaChi, String content,  int tongTien, String date) {
      this.idDonHang = idDonHang;
      this.trangThai = trangThai;
      this.sdt = sdt;
      this.diaChi = diaChi;
      this.content = content;
      this.tongTien = tongTien;
      this.date = date;
   }



   public int getTrangThai() {
      return trangThai;
   }

   public void setTrangThai(int trangThai) {
      this.trangThai = trangThai;
   }

   public int getIdDonHang() {
      return idDonHang;
   }

   public void setIdDonHang(int idDonHang) {
      this.idDonHang = idDonHang;
   }

   public int getIdGioHang() {
      return idGioHang;
   }

   public void setIdGioHang(int idGioHang) {
      this.idGioHang = idGioHang;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
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

   public int getTongTien() {
      return tongTien;
   }

   public void setTongTien(int tongTien) {
      this.tongTien = tongTien;
   }

   public String getDate() {
      return date;
   }

   public void setDate(String date) {
      this.date = date;
   }
}