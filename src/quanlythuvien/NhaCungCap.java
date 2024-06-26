/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlythuvien;

import dao.nhaCungcapDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class NhaCungCap extends javax.swing.JFrame {

    DefaultTableModel tblmModel;
    dao.nhaCungcapDAO nhacungcapDAO = new nhaCungcapDAO();
    ArrayList<model.nhacungcap> Listncc = new ArrayList<>();

    /**
     * Creates new form NhaCungCap
     */
    public NhaCungCap() {
        initComponents();
        Listncc = nhacungcapDAO.getList();
        inittable();
        filltotable();
        setLocationRelativeTo(null);
    }

    public void inittable() {
        tblmModel = (DefaultTableModel) tblnhacungcap.getModel();
        tblmModel.setColumnIdentifiers(new String[]{"Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "Điện thoại"});
    }

    public void filltotable() {
        tblmModel = (DefaultTableModel) tblnhacungcap.getModel();
        tblmModel.setRowCount(0);
        for (model.nhacungcap ncc : Listncc) {
            Object[] row = new Object[]{ncc.getManhacungcap(), ncc.getTennhacungcap(), ncc.getDiachi(), ncc.getDienthoai()};
            tblmModel.addRow(row);
        }
    }

    public void showdetail(int index) {
        try {
            txtmanhacungcap.setText(tblnhacungcap.getValueAt(index, 0) + "");
            txttennhacungcap.setText(tblnhacungcap.getValueAt(index, 1) + "");
            txtdiachi.setText(tblnhacungcap.getValueAt(index, 2) + "");
            txtsodienthoai.setText(tblnhacungcap.getValueAt(index, 3) + "");
        } catch (Exception e) {
            System.out.println(e);
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtmanhacungcap = new javax.swing.JTextField();
        txttennhacungcap = new javax.swing.JTextField();
        txtsodienthoai = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdiachi = new javax.swing.JTextArea();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnmoi = new javax.swing.JButton();
        txttimkiem = new javax.swing.JTextField();
        btntimkiem = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblnhacungcap = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Nhà cung cấp");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin"));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Mã nhà cung cấp : ");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Tên nhà cung cấp :");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Địa chỉ :");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Số điện thoại : ");

        txtsodienthoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsodienthoaiActionPerformed(evt);
            }
        });

        txtdiachi.setColumns(20);
        txtdiachi.setRows(5);
        jScrollPane1.setViewportView(txtdiachi);

        btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnxoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnmoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        btnmoi.setText("Mới");
        btnmoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmoiActionPerformed(evt);
            }
        });

        btntimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Zoom.png"))); // NOI18N
        btntimkiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btntimkiemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtmanhacungcap)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtsodienthoai)
                            .addComponent(txttennhacungcap, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnthem)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnsua)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnmoi, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 311, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btntimkiem)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btntimkiem)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtmanhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txttennhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtsodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem)
                    .addComponent(btnsua)
                    .addComponent(btnxoa)
                    .addComponent(btnmoi))
                .addGap(10, 10, 10))
        );

        tblnhacungcap.setModel(new javax.swing.table.DefaultTableModel(
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
        tblnhacungcap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblnhacungcapMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblnhacungcap);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Brick house.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jButton5)
                                .addGap(257, 257, 257)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 5, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblnhacungcapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblnhacungcapMouseClicked
        int selectedrow = tblnhacungcap.getSelectedRow();
        showdetail(selectedrow);
    }//GEN-LAST:event_tblnhacungcapMouseClicked

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        model.nhacungcap ncc = new model.nhacungcap();
        ncc.setManhacungcap(txtmanhacungcap.getText());
        ncc.setTennhacungcap(txttennhacungcap.getText());
        ncc.setDiachi(txtdiachi.getText());
        ncc.setDienthoai(txtsodienthoai.getText());
        String manhacungcap = txtmanhacungcap.getText();
        String tennhacungcap = txttennhacungcap.getText();
        String diachi = txtdiachi.getText();
        String dienthoai = txtsodienthoai.getText();
        boolean check = nhacungcapDAO.add(ncc);
        if (check) {
            JOptionPane.showMessageDialog(this, "Saved !");
        } else {
            JOptionPane.showMessageDialog(this, "Error!");
        }
        Listncc = nhacungcapDAO.getList();
        filltotable();
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        int selectedrow = tblnhacungcap.getSelectedRow();
        if (selectedrow == -1) {
            JOptionPane.showMessageDialog(this, "Deleted !");
            return;
        }
        String manhacungcap = tblmModel.getValueAt(selectedrow, 0).toString();
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure deleted ?", "Confirm deletion", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            boolean result = nhacungcapDAO.xoa(manhacungcap);
            if (result) {
                JOptionPane.showMessageDialog(this, "Deleted !");
                filltotable();
            } else {
                JOptionPane.showMessageDialog(this, "Error !");
            }
        }
        Listncc = nhacungcapDAO.getList();
        filltotable();
    }//GEN-LAST:event_btnxoaActionPerformed

    private void txtsodienthoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsodienthoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsodienthoaiActionPerformed

    private void btntimkiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntimkiemMouseClicked
        String Manhacungcap = txttimkiem.getText();
        if (Manhacungcap.isEmpty()) {
            Listncc = nhacungcapDAO.getList();
        } else {
            model.nhacungcap ncc = nhacungcapDAO.search(Manhacungcap);
            if (ncc != null) {
                Listncc.clear();
                Listncc.add(ncc);
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy nhà cung cấp!");
            }
        }
        filltotable();
    }//GEN-LAST:event_btntimkiemMouseClicked

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        String manhacungcap = txtmanhacungcap.getText();
        String tennhacungcap = txttennhacungcap.getText();
        String diachi = txtdiachi.getText();
        String dienthoai = txtsodienthoai.getText();
        boolean check = nhacungcapDAO.edit(manhacungcap, tennhacungcap, diachi, dienthoai);
        if (check) {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật!");
        }
        Listncc = nhacungcapDAO.getList();
        filltotable();
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnmoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmoiActionPerformed
        txtmanhacungcap.setText("");
        txttennhacungcap.setText("");
        txtdiachi.setText("");
        txtsodienthoai.setText("");
    }//GEN-LAST:event_btnmoiActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       Menu mn = new Menu();
       mn.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(NhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhaCungCap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnmoi;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JLabel btntimkiem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblnhacungcap;
    private javax.swing.JTextArea txtdiachi;
    private javax.swing.JTextField txtmanhacungcap;
    private javax.swing.JTextField txtsodienthoai;
    private javax.swing.JTextField txttennhacungcap;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}
