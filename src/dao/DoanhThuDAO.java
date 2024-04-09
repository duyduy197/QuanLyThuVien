/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.DoanhThu;

/**
 *
 * @author LENOVO
 */
public class DoanhThuDAO {

    private database.DBSQLSever dBSQLSever;
    private Connection connection;

    public DoanhThuDAO() {
        dBSQLSever = new database.DBSQLSever();
        connection = dBSQLSever.openConnection();
    }

    public ArrayList<model.DoanhThu> getlist(String tungay , String denngay) {
        ArrayList<model.DoanhThu> list = new ArrayList<>();
        try {
            String sql = "SELECT \n"
                    + "    p.ngayMuon,\n"
                    + "    SUM(ct.soLuong * ct.giaTien) AS DoanhThu\n"
                    + "FROM \n"
                    + "    PhieuMuon p\n"
                    + "INNER JOIN \n"
                    + "    PhieuMuonChiTiet ct ON p.maPhieuMuon = ct.maPhieuMuon\n"
                    + "WHERE \n"
                    + "    p.ngayMuon BETWEEN ? AND ?\n"
                    + "GROUP BY \n"
                    + "    p.ngayMuon;";
            PreparedStatement ps = connection.prepareStatement(sql);
            java.sql.Date TuNgaydDate = java.sql.Date.valueOf(tungay);
            java.sql.Date DenngayDate = java.sql.Date.valueOf(denngay);
            ps.setDate(1, TuNgaydDate);
            ps.setDate(2, DenngayDate);
            ResultSet rs = ps.executeQuery();
            list.clear();
            while (rs.next()) {
                model.DoanhThu obj = new DoanhThu();
                obj.setNgaymuon(rs.getString(1));
                obj.setDoanhthu(rs.getDouble(2));
                list.add(obj);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
