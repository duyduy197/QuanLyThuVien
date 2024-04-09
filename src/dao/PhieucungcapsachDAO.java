/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Phieucungcapsach;


/**
 *
 * @author LENOVO
 */
public class PhieucungcapsachDAO {
    private database.DBSQLSever dBSQLSever ;
    private Connection connection;
    public PhieucungcapsachDAO(){
        dBSQLSever = new database.DBSQLSever();
        connection = dBSQLSever.openConnection();
    }
    public ArrayList<model.Phieucungcapsach> getList(){
        ArrayList<model.Phieucungcapsach> list = new ArrayList<>();
        try {
            String sql = "select * from Phieucungcapsach";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            list.clear();
            while(rs.next()){
                String maphieunhap = rs.getString(1);
                String manhacungcap = rs.getString(2);
                String masach = rs.getString(3);
                int soluonggiao = rs.getInt(4);
                model.Phieucungcapsach pccs = new Phieucungcapsach();
                pccs.setMaphieunhap(maphieunhap);
                pccs.setManhacungcap(manhacungcap);
                pccs.setMasach(masach);
                pccs.setSoluonggiao(soluonggiao);
                list.add(pccs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list ;
    }
}
