/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class QuanLiThongKe {
    private String masach , tensach ;
    int luotmuon;

    public QuanLiThongKe() {
    }

    public QuanLiThongKe(String masach, String tensach, int luotmuon) {
        this.masach = masach;
        this.tensach = tensach;
        this.luotmuon = luotmuon;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public int getLuotmuon() {
        return luotmuon;
    }

    public void setLuotmuon(int luotmuon) {
        this.luotmuon = luotmuon;
    }
    
}
