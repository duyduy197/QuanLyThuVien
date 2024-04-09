/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.nhacungcap;

/**
 *
 * @author LENOVO
 */
public class nhaCungcapDAO {

    private database.DBSQLSever dBSQLSever;
    private Connection connection;

    public nhaCungcapDAO() {
        dBSQLSever = new database.DBSQLSever();
        connection = dBSQLSever.openConnection();
    }

    public ArrayList<model.nhacungcap> getList() {
        ArrayList<model.nhacungcap> List = new ArrayList<>();
        try {
            String sql = "select * from Nhacungcap ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List.clear();
            while (rs.next()) {
                String manhacungcap = rs.getString(1);
                String tennhacungcap = rs.getString(2);
                String diachi = rs.getString(3);
                String dienthoai = rs.getString(4);
                model.nhacungcap ncc = new nhacungcap();
                ncc.setManhacungcap(manhacungcap);
                ncc.setTennhacungcap(tennhacungcap);
                ncc.setDiachi(diachi);
                ncc.setDienthoai(dienthoai);
                List.add(ncc);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return List;
    }

    public boolean add(nhacungcap ncc) {
        boolean check = false;
        if (connection != null) {
            try {
                String query = "INSERT [dbo].[Nhacungcap] ([Manhacungcap],[tennhacungcap],[diachi],[dienthoai]) VALUES (? , ? , ? , ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, ncc.getManhacungcap());
                preparedStatement.setString(2, ncc.getTennhacungcap());
                preparedStatement.setString(3, ncc.getDiachi());
                preparedStatement.setString(4, ncc.getDienthoai());
                if (preparedStatement.executeUpdate() > 0) {
                    check = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return check;
    }
    
    public boolean edit(String manhacungcap, String tennhacungcap, String diachi, String sodienthoai) {
        boolean check = false;
        if (connection != null) {
            try {
                String query = "UPDATE Nhacungcap SET Manhacungcap = ?, tennhacungcap = ?, diachi = ?, dienthoai = ? WHERE Manhacungcap = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, manhacungcap);
                preparedStatement.setString(2, tennhacungcap);
                preparedStatement.setString(3, diachi);
                preparedStatement.setString(4, sodienthoai);
                preparedStatement.setString(5, manhacungcap);
                if (preparedStatement.executeUpdate() > 0) {
                    check = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return check;
    }

    public boolean xoa(String mancc) {
        boolean check = false;
        if (connection != null) {
            try {
                String query = "delete Nhacungcap  WHERE Manhacungcap = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, mancc);
                if (preparedStatement.executeUpdate() > 0) {
                    check = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return check;
    }

    public nhacungcap search(String ma) {
        try {
            String sql = "SELECT * FROM Nhacungcap WHERE Manhacungcap=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String manhacungcap = rs.getString(1);
                String tennhacungcap = rs.getString(2);
                String diachi = rs.getString(3);
                String dienthoai = rs.getString(4);
                return new nhacungcap(manhacungcap, tennhacungcap, diachi, dienthoai);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
}
