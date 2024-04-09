/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.QuanLiThongKe;

/**
 *
 * @author LENOVO
 */
public class ThongKeDAO {

    private database.DBSQLSever dBSQLSever;
    private Connection connection;

    public ThongKeDAO() {
        dBSQLSever = new database.DBSQLSever();
        connection = dBSQLSever.openConnection();
    }

    public ArrayList<model.QuanLiThongKe> getlist() {
        ArrayList<model.QuanLiThongKe> list = new ArrayList<>();
        try {
            String sql = "SELECT \n"
                    + "    s.maSach,\n"
                    + "    s.tenSach,\n"
                    + "    COUNT(ct.maPhieuMuon) * SUM(ct.soLuong) AS luotMuon \n"
                    + "FROM \n"
                    + "    SACH s \n"
                    + "INNER JOIN \n"
                    + "    PhieuMuonChiTiet ct ON s.maSach = ct.maSach \n"
                    + "GROUP BY \n"
                    + "    s.maSach, \n"
                    + "    s.tenSach \n"
                    + "ORDER BY \n"
                    + "  COUNT(ct.maPhieuMuon) * SUM(ct.soLuong) DESC;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            list.clear();
            while (rs.next()) {
                model.QuanLiThongKe obj = new QuanLiThongKe();
                obj.setMasach(rs.getString(1));
                obj.setTensach(rs.getString(2));
                obj.setLuotmuon(rs.getInt(3));
                list.add(obj);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
