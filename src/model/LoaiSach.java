/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class LoaiSach {
   private String tenLoai, maLoai;
   int  trangThai;

    public LoaiSach() {
    }

    public LoaiSach(String tenLoai, String maLoai, int trangThai) {
        this.tenLoai = tenLoai;
        this.maLoai = maLoai;
        this.trangThai = trangThai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

   

   
   
}
