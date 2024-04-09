package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.KhachHang;

public class KhachHangDAO {

    private database.DBSQLSever dBSQLSever;
    private Connection connection;

    public KhachHangDAO() {
        dBSQLSever = new database.DBSQLSever();
        connection = dBSQLSever.openConnection();
    }

    public ArrayList<model.KhachHang> getList() {
        ArrayList<model.KhachHang> List = new ArrayList<>();
        try {
            String sql = "SELECT * FROM KhachHang";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List.clear();
            while (rs.next()) {
                String ma = rs.getString(1);
                String email = rs.getString(2);
                String sdt = rs.getString(3);
                String ten = rs.getString(4);
                String soCCCD = rs.getString(5);
                int gioiTinh = rs.getInt(6);
                int tuoi = rs.getInt(7);
                model.KhachHang kh = new KhachHang();
                kh.setMaKH(ma);
                kh.setEmail(email);
                kh.setSdt(sdt);
                kh.setTen(ten);
                kh.setSoCCCD(soCCCD);
                kh.setGioiTinh(gioiTinh);
                kh.setTuoi(tuoi);
                List.add(kh);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return List;
    }

    public boolean add(String maKH, String email, String sdt, String ten, String soCCCD, int gioiTinh, int tuoi) {
        try {
            String sql = "INSERT INTO KhachHang(maKhachHang, Email, Sdt, Ten, SoCCCD, GioiTinh, Tuoi) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maKH);
            ps.setString(2, email);
            ps.setString(4, ten);
            ps.setString(3, sdt);
            ps.setString(5, soCCCD);
            ps.setInt(6, gioiTinh);
            ps.setInt(7, tuoi);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean edit(String maKH, String email, String sdt, String ten, String soCCCD, int gioiTinh, int tuoi) {
        try {
            String sql = "UPDATE KhachHang SET Email=?, Sdt=?, Ten=?, SoCCCD=?, GioiTinh=?, Tuoi=? WHERE maKhachHang=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(3, ten);
            ps.setString(2, sdt);
            ps.setString(4, soCCCD);
            ps.setInt(5, gioiTinh);
            ps.setInt(6, tuoi);
            ps.setString(7, maKH);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean delete(String maKH) {
        try {
            String sql = "DELETE FROM KhachHang WHERE maKhachHang=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, maKH);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public ArrayList<model.KhachHang> search(String makh) {
        ArrayList<model.KhachHang> List = new ArrayList<>();
        try {
            String sql = "select*from khachHang where maKhachHang = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, makh);
            ResultSet rs = ps.executeQuery();
            List.clear();
            while (rs.next()) {
                makh = rs.getString(1);
                String email = rs.getString(2);
                String sdt = rs.getString(3);
                String ten = rs.getString(4);
                String scccd = rs.getString(5);
                int gioitinh = rs.getInt(6);
                int tuoi = rs.getInt(7);
                model.KhachHang kh = new KhachHang();
                kh.setMaKH(makh);
                kh.setEmail(email);
                kh.setSdt(sdt);
                kh.setTen(ten);
                kh.setSoCCCD(scccd);
                kh.setGioiTinh(gioitinh);
                kh.setTuoi(tuoi);
                List.add(kh);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return List;
    }
}
