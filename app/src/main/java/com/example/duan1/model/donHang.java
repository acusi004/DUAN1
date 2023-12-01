package com.example.duan1.model;

public class donHang {
   private int idDonHang;
   private int idGioHang;
   private int tongTien;
   private int trangThai;

   private int sdt;
   private String diaChi;
   private String content;

   public donHang() {
   }

   public donHang(int idDonHang, int idGioHang, int tongTien, int trangThai, int sdt, String diaChi, String content) {
      this.idDonHang = idDonHang;
      this.idGioHang = idGioHang;
      this.tongTien = tongTien;
      this.trangThai = trangThai;
      this.sdt = sdt;
      this.diaChi = diaChi;
      this.content = content;
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
}