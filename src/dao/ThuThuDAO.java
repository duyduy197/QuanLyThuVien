/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.ThuThu;

public class ThuThuDAO {

    private database.DBSQLSever dBSQL;
    private Connection connection;

    public ThuThuDAO() {
        dBSQL = new database.DBSQLSever();
        connection = dBSQL.openConnection();
    }

    public ArrayList<model.ThuThu> getList() {
        ArrayList<model.ThuThu> List = new ArrayList<>();
        try {
            String sql = "select * from TaiKhoan ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List.clear();
            while (rs.next()) {
                String maTK = rs.getString(1);
                String tenTK = rs.getString(2);
                String matKhau = rs.getString(3);
                String Email = rs.getString(4);
                int vaitro = rs.getInt(5);
                int trangthai = rs.getInt(6);
                model.ThuThu nv = new ThuThu();
                nv.setMaTK(maTK);
                nv.setTenTK(tenTK);
                nv.setMatkhau(matKhau);
                nv.setEmail(Email);
                nv.setVaitro(vaitro);
                nv.setTrangthai(trangthai);
                List.add(nv);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return List;
    }

    public boolean add(String matk, String tentk, String matkhau, String email, int vaitro, int trangthai) {
        try {
            String sql = " INSERT INTO TaiKhoan(maTaiKhoan, tenTaiKhoan ,matKhau , email, vaiTro, trangThai) " + " VALUES " + " (? , ? , ? , ? , ? , ? )";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, matk);
            ps.setString(2, tentk);
            ps.setString(3, matkhau);
            ps.setString(4, email);
            ps.setInt(5, vaitro);
            ps.setInt(6, trangthai);

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean delete(String matk) {
        try {
            String sql = "delete TaiKhoan where maTaiKhoan = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, matk);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean edit(String matk, String hotentk, String email, String matkhau, int vaitro, int trangthai) {
        try {
            String sql = "UPDATE TaiKhoan SET tenTaiKhoan = ?, matKhau = ?, eMail = ?, vaiTro = ?, trangThai = ? WHERE maTaiKhoan = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, hotentk);
            ps.setString(2, matkhau);
            ps.setString(3, email);
            ps.setInt(4, vaitro);
            ps.setInt(5, trangthai);
            ps.setString(6, matk);

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public ArrayList<model.ThuThu> search(String matk) {
        ArrayList<model.ThuThu> List = new ArrayList<>();
        try {
            String sql = "select * from TaiKhoan\n" + "where maTaiKhoan = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, matk);
            ResultSet rs = ps.executeQuery();
            List.clear();
            while (rs.next()) {
                matk = rs.getString(1);
                String tentaikhoan = rs.getString(2);
                String matkhau = rs.getString(3);
                String email = rs.getString(4);
                int vaitro = rs.getInt(5);
                int trangthai = rs.getInt(6);
                model.ThuThu nv = new ThuThu();
                nv.setMaTK(matk);
                nv.setTenTK(tentaikhoan);
                nv.setMatkhau(matkhau);
                nv.setEmail(email);
                nv.setVaitro(vaitro);
                nv.setTrangthai(trangthai);
                List.add(nv);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return List;
    }

    public boolean authenticate(String maTK, String matKhau) {
        try {
            String sql = "SELECT * FROM TaiKhoan WHERE maTaiKhoan = ? AND matKhau = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maTK);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
