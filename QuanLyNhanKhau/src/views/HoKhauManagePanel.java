/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.HoKhauManagerController.EditHoKhauController;
import controllers.HoKhauPanelController;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import views.HoKhauManagerFrame.ChuyenDiNoiKhac;
import views.HoKhauManagerFrame.TachHoKhau;
import views.HoKhauManagerFrame.ThemMoiHoKhau;

/**
 *
 * @author Ai làm thì diền tên vào
 */
public class HoKhauManagePanel extends javax.swing.JPanel {
    
    private JFrame parentFrame;
    private HoKhauPanelController controller;
    /**
     * Creates new form HoKhauManagePanel
     */
    public HoKhauManagePanel(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        initComponents();
        controller = new HoKhauPanelController(jtfSearch, tableJpn);
        controller.setParentJFrame(parentFrame);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfSearch = new javax.swing.JTextField();
        tableJpn = new javax.swing.JPanel();
        Kinh_lup = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        themMoiBtn = new javax.swing.JButton();
        tachHoKhauBtn = new javax.swing.JButton();
        chuyenDiBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        editBtn1 = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 255, 153));

        jtfSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tableJpnLayout = new javax.swing.GroupLayout(tableJpn);
        tableJpn.setLayout(tableJpnLayout);
        tableJpnLayout.setHorizontalGroup(
            tableJpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        tableJpnLayout.setVerticalGroup(
            tableJpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Kinh_lup.setBackground(new java.awt.Color(255, 255, 255));
        Kinh_lup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Kinh_lup_1.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        themMoiBtn.setBackground(new java.awt.Color(204, 204, 204));
        themMoiBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        themMoiBtn.setText("Thêm mới");
        themMoiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themMoiBtnActionPerformed(evt);
            }
        });

        tachHoKhauBtn.setBackground(new java.awt.Color(204, 204, 204));
        tachHoKhauBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tachHoKhauBtn.setText("Tách HK");
        tachHoKhauBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tachHoKhauBtnActionPerformed(evt);
            }
        });

        chuyenDiBtn.setBackground(new java.awt.Color(204, 204, 204));
        chuyenDiBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chuyenDiBtn.setText("Chuyển đi");
        chuyenDiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chuyenDiBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 3, 20)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/rang_cua.png"))); // NOI18N
        jLabel1.setText("TÙY CHỌN");
        jLabel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        editBtn1.setBackground(new java.awt.Color(204, 204, 204));
        editBtn1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        editBtn1.setText("Sửa");
        editBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtn1ActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(204, 204, 204));
        deleteBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        deleteBtn.setText("Xóa");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(chuyenDiBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(tachHoKhauBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(themMoiBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(editBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(themMoiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tachHoKhauBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chuyenDiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(340, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Kinh_lup, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 380, Short.MAX_VALUE))
                    .addComponent(tableJpn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Kinh_lup, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfSearch, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addComponent(tableJpn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSearchActionPerformed

    private void chuyenDiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chuyenDiBtnActionPerformed
        ChuyenDiNoiKhac chuyenDiNoiKhac = new ChuyenDiNoiKhac(this.parentFrame);
        chuyenDiNoiKhac.setLocationRelativeTo(null);
        chuyenDiNoiKhac.setResizable(false);
        chuyenDiNoiKhac.setVisible(true);
    }//GEN-LAST:event_chuyenDiBtnActionPerformed

    private void themMoiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themMoiBtnActionPerformed
        ThemMoiHoKhau themMoiHoKhau = new ThemMoiHoKhau(this.parentFrame);
        themMoiHoKhau.setLocationRelativeTo(null);
        themMoiHoKhau.setResizable(false);
        themMoiHoKhau.setVisible(true);
    }//GEN-LAST:event_themMoiBtnActionPerformed

    private void tachHoKhauBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tachHoKhauBtnActionPerformed
        TachHoKhau tachHoKhau = new TachHoKhau(this.parentFrame);
        tachHoKhau.setLocationRelativeTo(null);
        tachHoKhau.setResizable(false);
        tachHoKhau.setVisible(true);
    }//GEN-LAST:event_tachHoKhauBtnActionPerformed

    private void editBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtn1ActionPerformed
        controller.edit();
    }//GEN-LAST:event_editBtn1ActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int check = JOptionPane.showConfirmDialog(parentFrame, "Bạn thật sự muốn xóa hộ này?", "Cảnh báo!!!", JOptionPane.YES_NO_CANCEL_OPTION);
        if(check == 0) {
         controller.delete();
        } else return;
    }//GEN-LAST:event_deleteBtnActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Kinh_lup;
    private javax.swing.JButton chuyenDiBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jtfSearch;
    private javax.swing.JPanel tableJpn;
    private javax.swing.JButton tachHoKhauBtn;
    private javax.swing.JButton themMoiBtn;
    // End of variables declaration//GEN-END:variables
}
