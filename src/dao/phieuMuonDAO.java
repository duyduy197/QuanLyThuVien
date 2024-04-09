/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.phieuMuon;

/**
 *
 * @author LENOVO
 */
public class phieuMuonDAO {

    private database.DBSQLSever dBSQLSever;
    private Connection connection;

    public phieuMuonDAO() {
        dBSQLSever = new database.DBSQLSever();
        connection = dBSQLSever.openConnection();
    }

    public ArrayList<model.phieuMuon> getlist() {
        ArrayList<model.phieuMuon> list = new ArrayList<>();
        try {
            String sql = "SELECT *FROM PhieuMuon pm INNER JOIN PhieuMuonChiTiet pmct ON pm.maPhieuMuon = pmct.maPhieuMuon";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            list.clear();
            while (rs.next()) {
                String maphieumuon = rs.getString(1);
                String ngaymuon = rs.getString(2);
                String ngaytra = rs.getString(3);
                String matk = rs.getString(4);
                String makh = rs.getString(5);
                String maphieumuonct = rs.getString(6);
                int soluong = rs.getInt(7);
                double giatien = rs.getDouble(8);
                int trangthai = rs.getInt(9);
                String tinhtrangsach = rs.getString(10);
                String ghichu = rs.getString(11);
                String masach = rs.getString(13);
                model.phieuMuon pm = new phieuMuon();
                pm.setMaphieumuon(maphieumuon);
                pm.setNgaymuon(ngaymuon);
                pm.setNgaytra(ngaytra);
                pm.setMataikhoan(matk);
                pm.setMakhachhang(makh);
                pm.setMaphieumuonct(maphieumuonct);
                pm.setSoluong(soluong);
                pm.setGiatien(giatien);
                pm.setTrangthai(trangthai);
                pm.setTinhtrangsach(tinhtrangsach);
                pm.setGhichu(ghichu);
                pm.setMasach(masach);
                list.add(pm);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return list;
    }

    public boolean themPhieuMuon(String maPhieuMuon, String ngayMuon, String ngayTra, String maTaiKhoan, String maKhachHang) {
        String query = "INSERT INTO PhieuMuon (maPhieuMuon, ngayMuon, ngayTra, maTaiKhoan, maKhachHang) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, maPhieuMuon);
            pstmt.setString(2, ngayMuon);
            pstmt.setString(3, ngayTra);
            pstmt.setString(4, maTaiKhoan);
            pstmt.setString(5, maKhachHang);
            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean themPhieuMuonChiTiet(String maPhieuMuonCT, int soLuong, int giaTien, int trangThai, String tinhTrangSach, String ghiChu, String maPhieuMuon, String maSach) {
        String query = "INSERT INTO PhieuMuonChiTiet (maPhieuMuonCT, soLuong, giaTien, trangThai, tinhTrangSach, ghiChu, maPhieuMuon, maSach) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, maPhieuMuonCT);
            pstmt.setInt(2, soLuong);
            pstmt.setInt(3, giaTien);
            pstmt.setInt(4, trangThai);
            pstmt.setString(5, tinhTrangSach);
            pstmt.setString(6, ghiChu);
            pstmt.setString(7, maPhieuMuon);
            pstmt.setString(8, maSach);
            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean suaphieumuon(String maPhieuMuon, String ngayMuon, String ngayTra, String maTaiKhoan, String maKhachHang) {
        String sql = "UPDATE PhieuMuon\n"
                + "SET ngayMuon = ?, \n"
                + "    ngayTra = ?,  \n"
                + "    maTaiKhoan = ?,  \n"
                + "    maKhachHang = ?  \n"
                + "where maPhieuMuon = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ngayMuon);
            ps.setString(2, ngayTra);
            ps.setString(3, maTaiKhoan);
            ps.setString(4, maKhachHang);
            ps.setString(5, maPhieuMuon);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean suaphieumuonchitiet(String maPhieuMuonCT, int soLuong, int giaTien, int trangThai, String tinhTrangSach, String ghiChu, String maSach, String maPhieuMuon) {
        String sql = "UPDATE phieumuonchitiet \n"
                + "SET soluong = ?, \n"
                + "    giatien = ?, \n"
                + "    trangthai = ?, \n"
                + "    tinhtrangsach = ?, \n"
                + "    ghichu = ?, \n"
                + "    masach = ? \n"
                + "WHERE maphieumuonct = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, soLuong);
            ps.setInt(2, giaTien);
            ps.setInt(3, trangThai);
            ps.setString(4, tinhTrangSach);
            ps.setString(5, ghiChu);
            ps.setString(6, maSach);
            ps.setString(7, maPhieuMuonCT);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean xoaphieumuon(String maPhieuMuon) {
        String sql = "DELETE FROM PhieuMuon WHERE maPhieuMuon = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maPhieuMuon);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean xoaphieumuonchitiet(String maPhieuMuon) {
        String sql = "DELETE FROM phieumuonchitiet WHERE maPhieuMuon = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maPhieuMuon);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
