/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class Phieucungcapsach {
    private String maphieunhap , manhacungcap , masach ;
    private int soluonggiao ;

    public Phieucungcapsach() {
    }

    public Phieucungcapsach(String maphieunhap, String manhacungcap, String masach, int soluonggiao) {
        this.maphieunhap = maphieunhap;
        this.manhacungcap = manhacungcap;
        this.masach = masach;
        this.soluonggiao = soluonggiao;
    }

    public String getMaphieunhap() {
        return maphieunhap;
    }

    public void setMaphieunhap(String maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    public String getManhacungcap() {
        return manhacungcap;
    }

    public void setManhacungcap(String manhacungcap) {
        this.manhacungcap = manhacungcap;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public int getSoluonggiao() {
        return soluonggiao;
    }

    public void setSoluonggiao(int soluonggiao) {
        this.soluonggiao = soluonggiao;
    }
    
}
