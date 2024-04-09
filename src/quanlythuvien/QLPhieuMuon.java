/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlythuvien;

import dao.KhachHangDAO;
import dao.QLySachDAO;
import dao.ThuThuDAO;
import dao.phieuMuonDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class QLPhieuMuon extends javax.swing.JFrame {

    dao.phieuMuonDAO phieumuondao = new phieuMuonDAO();
    dao.QLySachDAO qLySachDAO = new QLySachDAO();
    dao.KhachHangDAO khachHangDAO = new KhachHangDAO();
    dao.ThuThuDAO thuThuDAO = new ThuThuDAO();
    DefaultTableModel tblModel;
    ArrayList<model.phieuMuon> list = new ArrayList<>();
    ArrayList<model.Sach> listqls = new ArrayList<>();
    ArrayList<model.KhachHang> listkh = new ArrayList<>();
    ArrayList<model.ThuThu> listtt = new ArrayList<>();

    /**
     * Creates new form QLThuThu
     */
    public QLPhieuMuon() {
        initComponents();
        list = phieumuondao.getlist();
        init();
        initTable();
        comboboxTrangThai();
        getCBbox();
        makhachhang();
        mataikhoan();
        filltotable();
        setLocationRelativeTo(null);
    }

    void init() {
        setTitle("CHÀO MỪNG ĐẾN VỚI THƯ VIỆN");
    }

    public void initTable() {
        tblModel = (DefaultTableModel) tblphieumuon.getModel();
        tblModel.setColumnIdentifiers(new String[]{"Mã phiếu mượn", "Ngày mượn", "Ngày trả", "Mã tài khoản", "Mã Khách hàng", "Mã phiếu mượn chi tiết", "Số lượng", "Gía tiền", "Trạng thái", "Tình trạng sách", "Ghi chú", "Mã sách"});
    }

    public void comboboxTrangThai() {
        cbotrangthai.addItem("Đã thanh toán");
        cbotrangthai.addItem("Chưa thanh toán");
        System.out.println("Item in combobox" + cbotrangthai.getItemCount());
    }

    private void getCBbox() {
        try {
            listqls = qLySachDAO.getlist();
            cbomasach.removeAllItems();
            for (model.Sach qls : listqls) {
                cbomasach.addItem(qls.getTensach());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String masach = listqls.get(0).getMasach();
        listqls = qLySachDAO.getlist();
    }

    private void makhachhang() {
        try {
            listkh = khachHangDAO.getList();
            cbomakhachhang.removeAllItems();
            for (model.KhachHang kh : listkh) {
                cbomakhachhang.addItem(kh.getMaKH());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String makh = listkh.get(0).getMaKH();
        listkh = khachHangDAO.getList();
    }

    public void mataikhoan() {
        try {
            listtt = thuThuDAO.getList();
            cbomataikhoan.removeAllItems();
            for (model.ThuThu tt : listtt) {
                cbomataikhoan.addItem(tt.getMaTK());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String matk = listtt.get(0).getMaTK();
        listtt = thuThuDAO.getList();
    }

    public void filltotable() {
        tblModel = (DefaultTableModel) tblphieumuon.getModel();
        tblModel.setRowCount(0);
        String trangthai = "";
        for (model.phieuMuon pm : list) {
            if (pm.getTrangthai() == 1) {
                trangthai = "Đã thanh toán";
            } else {
                trangthai = "Chưa thanh toán";
            }
            Object[] row = new Object[]{pm.getMaphieumuon(), pm.getNgaymuon(), pm.getNgaytra(), pm.getMataikhoan(), pm.getMakhachhang(), pm.getMaphieumuonct(), pm.getSoluong(), pm.getGiatien(), trangthai, pm.getTinhtrangsach(), pm.getGhichu(), pm.getMasach()};
            tblModel.addRow(row);
        }
    }

    public void showdeltaill(int index) {
        try {
            txtmaphieumuon.setText(tblphieumuon.getValueAt(index, 0) + "");
            txtngaymuon.setText(tblphieumuon.getValueAt(index, 1) + "");
            txtngaytra.setText(tblphieumuon.getValueAt(index, 2) + "");
            Object objmatk = tblphieumuon.getValueAt(index, 3);
            cbomataikhoan.setSelectedItem(objmatk);
            Object objmakhachhang = tblphieumuon.getValueAt(index, 4);
            cbomakhachhang.setSelectedItem(objmakhachhang);
            txtmaphieumuonchitiet.setText(tblphieumuon.getValueAt(index, 5) + "");
            txtsoluong.setText(tblphieumuon.getValueAt(index, 6) + "");
            txtgiatien.setText(tblphieumuon.getValueAt(index, 7) + "");
            Object objTrangThai = tblphieumuon.getValueAt(index, 8);
            if (objTrangThai instanceof Integer) {
                int trangthai = (int) objTrangThai;
                if (trangthai == 0) {
                    cbotrangthai.setSelectedItem("Chưa thanh toán");
                } else {
                    cbotrangthai.setSelectedItem("Đã thanh toán");
                }
            } else if (objTrangThai instanceof String) {
                String trangthai = (String) objTrangThai;
                cbotrangthai.setSelectedItem(trangthai);
            }
            txttinhtrang.setText(tblphieumuon.getValueAt(index, 9) + "");
            txtghichu.setText(tblphieumuon.getValueAt(index, 10) + "");
            String maSach = tblphieumuon.getValueAt(index, 11) + "";
            for (int i = 0; i < listqls.size(); i++) {
                model.Sach qls = listqls.get(i);
                if (qls.getMasach().equals(maSach)) {
                    cbomasach.setSelectedIndex(i);
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtmaphieumuon = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtngaymuon = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtngaytra = new javax.swing.JTextField();
        btnAn1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtghichu = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblphieumuon = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txtsoluong = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtgiatien = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txttinhtrang = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtmaphieumuonchitiet = new javax.swing.JTextField();
        cbotrangthai = new javax.swing.JComboBox<>();
        cbomasach = new javax.swing.JComboBox<>();
        cbomataikhoan = new javax.swing.JComboBox<>();
        cbomakhachhang = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Mã phiếu mượn:");

        txtmaphieumuon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Ngày Mượn");

        txtngaymuon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtngaymuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtngaymuonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Ngày trả:");

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnMoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo-small.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Mã tài khoản");

        txtngaytra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        btnAn1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAn1.setText("Xóa");
        btnAn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAn1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Ghi chú");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Mã khách hàng");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel11.setText("Mã phiếu mượn CT:");

        txtghichu.setColumns(20);
        txtghichu.setRows(5);
        jScrollPane1.setViewportView(txtghichu);

        tblphieumuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblphieumuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblphieumuonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblphieumuon);

        jLabel12.setText("Số lượng:");

        jLabel13.setText("Gía tiền:");

        jLabel6.setText("Trạng thái:");

        jLabel10.setText("Tình trạng sách:");

        jLabel14.setText("Ten sach");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Brick house.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnThem)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSua)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAn1)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnMoi))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cbomasach, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtmaphieumuon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                                            .addComponent(txtngaymuon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                                            .addComponent(txtngaytra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                                            .addComponent(txtsoluong, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtgiatien, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txttinhtrang, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtmaphieumuonchitiet, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbotrangthai, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbomataikhoan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbomakhachhang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jButton1))))))
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtmaphieumuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtngaytra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtngaymuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbomataikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbomakhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtmaphieumuonchitiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtgiatien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbotrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txttinhtrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel14))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbomasach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnSua)
                            .addComponent(btnAn1)
                            .addComponent(btnMoi)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        jTabbedPane1.addTab("EDIT", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        txtghichu.setText("");
        txtgiatien.setText("");
        cbomataikhoan.setSelectedIndex(0);
        txtmaphieumuon.setText("");
        txtmaphieumuonchitiet.setText("");
        cbomasach.setSelectedIndex(0);
        cbomakhachhang.setSelectedIndex(0);
        txtngaymuon.setText("");
        txtngaytra.setText("");
        txtsoluong.setText("");
        txttinhtrang.setText("");
        cbotrangthai.setSelectedIndex(0);
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnAn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAn1ActionPerformed
        String maphieumuon = txtmaphieumuon.getText();
        boolean delete = phieumuondao.xoaphieumuonchitiet(maphieumuon);
        boolean check = phieumuondao.xoaphieumuon(maphieumuon);
        if (delete && check) {
            JOptionPane.showMessageDialog(this, "Deleted !");
            list = phieumuondao.getlist();
        }else{
            JOptionPane.showMessageDialog(this, "Erorr !");
        }
        filltotable();
    }//GEN-LAST:event_btnAn1ActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        try {
            String maPhieuMuon = txtmaphieumuon.getText();
            String ngayMuon = txtngaymuon.getText();
            String ngayTra = txtngaytra.getText();
            String maTaiKhoan = listtt.get(cbomataikhoan.getSelectedIndex()).getMaTK();
            String maKhachHang = listkh.get(cbomakhachhang.getSelectedIndex()).getMaKH();
            String maPhieuMuonCT = txtmaphieumuonchitiet.getText();
            int soLuong = (int) Math.round(Double.parseDouble(txtsoluong.getText()));
            int giaTien = (int) Math.round(Double.parseDouble(txtgiatien.getText()));
            int trangThai;
            if (cbotrangthai.getSelectedItem().toString().equals("Chưa thanh toán")) {
                trangThai = 0;
            } else {
                trangThai = 1;
            }
            String tinhTrangSach = txttinhtrang.getText();
            String ghiChu = txtghichu.getText();
            String maSach = listqls.get(cbomasach.getSelectedIndex()).getMasach();
            boolean check1 = phieumuondao.themPhieuMuon(maPhieuMuon, ngayMuon, ngayTra, maTaiKhoan, maKhachHang);
            boolean check2 = false;
            if (check1) {
                check2 = phieumuondao.themPhieuMuonChiTiet(maPhieuMuonCT, soLuong, giaTien, trangThai, tinhTrangSach, ghiChu, maPhieuMuon, maSach);
                if (check2) {
                    JOptionPane.showMessageDialog(this, "Saved !");
                    list = phieumuondao.getlist();
                } else {
                    JOptionPane.showMessageDialog(this, "Error !");
                }
            }
            filltotable();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên hợp lệ cho Số lượng và Giá tiền!");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtngaymuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtngaymuonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtngaymuonActionPerformed

    private void tblphieumuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblphieumuonMouseClicked
        int selectedRow = tblphieumuon.getSelectedRow();
        showdeltaill(selectedRow);
    }//GEN-LAST:event_tblphieumuonMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            String maSach = listqls.get(cbomasach.getSelectedIndex()).getMasach();
            String maPhieuMuon = txtmaphieumuon.getText();
            String ngayMuon = txtngaymuon.getText();
            String ngayTra = txtngaytra.getText();
            String maTaiKhoan = listtt.get(cbomataikhoan.getSelectedIndex()).getMaTK();
            String maKhachHang = listkh.get(cbomakhachhang.getSelectedIndex()).getMaKH();
            boolean check1 = phieumuondao.suaphieumuon(maPhieuMuon, ngayMuon, ngayTra, maTaiKhoan, maKhachHang);
            boolean check2 = phieumuondao.suaphieumuonchitiet(
                    txtmaphieumuonchitiet.getText(),
                    Integer.parseInt(txtsoluong.getText()),
                    Integer.parseInt(txtgiatien.getText()),
                    cbotrangthai.getSelectedItem().toString().equals("Chưa thanh toán") ? 0 : 1,
                    txttinhtrang.getText(),
                    txtghichu.getText(),
                    maSach,
                    txtmaphieumuon.getText());
            if (check1 && check2) {
                JOptionPane.showMessageDialog(this, "Updated !");
                list = phieumuondao.getlist();
            } else {
                JOptionPane.showMessageDialog(this, "Error !");
            }
            filltotable();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên hợp lệ cho Số lượng và Giá tiền!");
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Menu mn = new Menu();
        mn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLPhieuMuon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAn1;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbomakhachhang;
    private javax.swing.JComboBox<String> cbomasach;
    private javax.swing.JComboBox<String> cbomataikhoan;
    private javax.swing.JComboBox<String> cbotrangthai;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblphieumuon;
    private javax.swing.JTextArea txtghichu;
    private javax.swing.JTextField txtgiatien;
    private javax.swing.JTextField txtmaphieumuon;
    private javax.swing.JTextField txtmaphieumuonchitiet;
    private javax.swing.JTextField txtngaymuon;
    private javax.swing.JTextField txtngaytra;
    private javax.swing.JTextField txtsoluong;
    private javax.swing.JTextField txttinhtrang;
    // End of variables declaration//GEN-END:variables
}
