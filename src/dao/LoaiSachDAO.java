/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.LoaiSach;

public class LoaiSachDAO {

    private database.DBSQLSever dBSQL;
    private Connection connection;

    public LoaiSachDAO() {
        dBSQL = new database.DBSQLSever();
        connection = dBSQL.openConnection();
    }

    public ArrayList<model.LoaiSach> getList() {
        ArrayList<model.LoaiSach> list = new ArrayList<>();
        try {
            String sql = "Select * from LoaiSach";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            list.clear();
            while (rs.next()) {
                String tenLoai = rs.getString(2);
                String maLoai = rs.getString(1);
                int trangThai = rs.getInt(3);
                LoaiSach ls = new LoaiSach();
                ls.setMaLoai(maLoai);
                ls.setTenLoai(tenLoai);
                ls.setTrangThai(trangThai);
                list.add(ls);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return list;
    }

    public boolean add(String maLoai, String tenMaLoai, int trangThai) {
        try {
            String sql = "INSERT INTO LoaiSach(maLoai,tenLoai,trangThai) " + " VALUES " + "(?,?,?) ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maLoai);
            ps.setString(2, tenMaLoai);
            ps.setInt(3, trangThai);

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean delete(String maloai) {
        try {
            String sql = "delete LoaiSach where maLoai = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maloai);

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean edit(String maLoai, String tenMaLoai, int trangThai) {
        try {
            String sql = "UPDATE LoaiSach SET tenLoai = ?, trangThai = ? WHERE maLoai = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tenMaLoai);
            ps.setInt(2, trangThai);
            ps.setString(3, maLoai);

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

}
