/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class phieuMuon {
    private String maphieumuon , ngaymuon , ngaytra , mataikhoan , makhachhang , maphieumuonct , tinhtrangsach , ghichu , masach ; 
    int soluong ; 
    double giatien ;
    int trangthai;

    public phieuMuon() {
    }

    public phieuMuon(String maphieumuon, String ngaymuon, String ngaytra, String mataikhoan, String makhachhang, String maphieumuonct, String tinhtrangsach, String ghichu, String masach, int soluong, double giatien, int trangthai) {
        this.maphieumuon = maphieumuon;
        this.ngaymuon = ngaymuon;
        this.ngaytra = ngaytra;
        this.mataikhoan = mataikhoan;
        this.makhachhang = makhachhang;
        this.maphieumuonct = maphieumuonct;
        this.tinhtrangsach = tinhtrangsach;
        this.ghichu = ghichu;
        this.masach = masach;
        this.soluong = soluong;
        this.giatien = giatien;
        this.trangthai = trangthai;
    }

    public String getMaphieumuon() {
        return maphieumuon;
    }

    public void setMaphieumuon(String maphieumuon) {
        this.maphieumuon = maphieumuon;
    }

    public String getNgaymuon() {
        return ngaymuon;
    }

    public void setNgaymuon(String ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public String getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(String ngaytra) {
        this.ngaytra = ngaytra;
    }

    public String getMataikhoan() {
        return mataikhoan;
    }

    public void setMataikhoan(String mataikhoan) {
        this.mataikhoan = mataikhoan;
    }

    public String getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    public String getMaphieumuonct() {
        return maphieumuonct;
    }

    public void setMaphieumuonct(String maphieumuonct) {
        this.maphieumuonct = maphieumuonct;
    }

    public String getTinhtrangsach() {
        return tinhtrangsach;
    }

    public void setTinhtrangsach(String tinhtrangsach) {
        this.tinhtrangsach = tinhtrangsach;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getGiatien() {
        return giatien;
    }

    public void setGiatien(double giatien) {
        this.giatien = giatien;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    
}
