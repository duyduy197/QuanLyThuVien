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
import model.Sach;

/**
 *
 * @author user
 */
public class QLySachDAO {

    private database.DBSQLSever dBSQLSever;
    private Connection connection;

    public QLySachDAO() {
        dBSQLSever = new database.DBSQLSever();
        connection = dBSQLSever.openConnection();
    }

    public ArrayList<Sach> getlist() {
        ArrayList<Sach> list = new ArrayList<>();
        try {
            String sql = "select*from SACH ";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            list.clear();
            while (rs.next()) {
                String maSach = rs.getString(1);
                String tenSach = rs.getString(2);
                int giaThue = rs.getInt(3);
                int soLuong = rs.getInt(4);
                int trangThai = rs.getInt(5);
                String moTa = rs.getString(6);
                String tenTacGia = rs.getString(7);
                String ngay = rs.getString(8);
                int maLoai = rs.getInt(9);
                Sach qls = new Sach();
                qls.setMasach(maSach);
                qls.setTensach(tenSach);
                qls.setGiathue(giaThue);
                qls.setSoluong(soLuong);
                qls.setTrangthai(trangThai);
                qls.setMota(moTa);
                qls.setTentacgia(tenTacGia);
                qls.setNgay(ngay);
                qls.setMaloai(maLoai);
                list.add(qls);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return list;
    }

    public boolean add(Sach qls) {
        boolean check = false;
        if (connection != null) {
            try {
                String query = "Insert SACH (maSach, tenSach, giaThue, SoLuong, trangThai, moTa, tenTacGia, ngay, maLoai)  values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, qls.getMasach());
                preparedStatement.setString(2, qls.getTensach());
                preparedStatement.setInt(3, qls.getGiathue());
                preparedStatement.setInt(4, qls.getSoluong());
                preparedStatement.setInt(5, qls.getTrangthai());
                preparedStatement.setString(6, qls.getMota());
                preparedStatement.setString(7, qls.getTentacgia());
                preparedStatement.setString(8, qls.getNgay());
//                preparedStatement.setInt(1, qls.getMaloai());
                preparedStatement.setInt(9, qls.getMaloai());
                if (preparedStatement.executeUpdate() > 0) {
                    check = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return check;
    }

    public boolean edit(String maSach, String tenSach, int giaThue, int soLuong, int trangThai, String moTa, String tenTacGia, String ngay, int maLoai) {
        boolean check = false;
        if (connection != null) {
            try {
                String query = "UPDATE SACH SET tenSach = ?, giaThue = ?, soLuong = ?, trangThai = ?, moTa = ?, ngay = ?, tenTacGia = ?, maLoai = ? WHERE maSach = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, tenSach);
                preparedStatement.setInt(2, giaThue);
                preparedStatement.setInt(3, soLuong);
                preparedStatement.setInt(4, trangThai);
                preparedStatement.setString(5, moTa);
                preparedStatement.setString(7, tenTacGia);
                preparedStatement.setString(6, ngay);
                preparedStatement.setInt(8, maLoai);
                preparedStatement.setString(9, maSach);
                if (preparedStatement.executeUpdate() > 0) {
                    check = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return check;
    }

    public Sach search(String maSach) {
        try {
            String sql = "SELECT * FROM SACH WHERE maSach=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maSach);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String tenSach = rs.getString(2);
                int giaThue = rs.getInt(3);
                int soLuong = rs.getInt(4);
                int trangThai = rs.getInt(5);
                String moTa = rs.getString(6);
                String tenTacGia = rs.getString(7);
                String ngay = rs.getString(8);
                int maLoai = rs.getInt(9);
//                return new Sach(maSach, tenSach, giaThue, soLuong, trangThai, moTa, tenTacGia, ngay, maLoai);
                 return new Sach(maSach,tenSach, moTa, tenTacGia,ngay, giaThue, soLuong, trangThai, maLoai);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public boolean hide(String maSach) {
        boolean check = false;
        if (connection != null) {
            try {
                String query = "delete SACH  WHERE maSach = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, maSach);
                if (preparedStatement.executeUpdate() > 0) {
                    check = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return check;
    }
}
