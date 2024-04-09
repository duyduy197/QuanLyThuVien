/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class KhachHang {
    private String MaKH, Email , Ten, Sdt , SoCCCD;
    int GioiTinh, Tuoi ;

    public KhachHang() {
    }

    public KhachHang(String MaKH, String Email, String Ten, String Sdt, String SoCCCD, int GioiTinh, int Tuoi) {
        this.MaKH = MaKH;
        this.Email = Email;
        this.Ten = Ten;
        this.Sdt = Sdt;
        this.SoCCCD = SoCCCD;
        this.GioiTinh = GioiTinh;
        this.Tuoi = Tuoi;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getSoCCCD() {
        return SoCCCD;
    }

    public void setSoCCCD(String SoCCCD) {
        this.SoCCCD = SoCCCD;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setTuoi(int Tuoi) {
        this.Tuoi = Tuoi;
    }

    
}
