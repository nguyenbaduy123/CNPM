/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.ThuPhiManagerFrame;
import Bean.KhoanThuBean;
import Bean.NhanKhauBean;
import controllers.NhanKhauManagerController.DangKyTamTruController;
import controllers.ThuPhiManagerController.NopTienController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import  javax.swing.JButton;
import models.NopTienModel;
import views.NhanKhauManagerFrame.AddNewPeopleJFrame;
/**
 *
 * @author Duy
 */
public class NopTien extends javax.swing.JFrame {

    /**
     * Creates new form ThemMoiKhoanThu
     */
    private JFrame parentJFrame;
    private DangKyTamTruController tamTruController = new DangKyTamTruController();
    private KhoanThuBean khoanThuBean = new KhoanThuBean();
    private NhanKhauBean nguoiNop = new NhanKhauBean();
    private NopTienModel nopTienModel = new NopTienModel();
    private NopTienController controller;
    
    public NopTien(JFrame parentJFrame) {
        initComponents();
        this.parentJFrame = parentJFrame;
        parentJFrame.setEnabled(false);
        controller = new NopTienController(this);
//        controller.setTableBotJpn(tableBotJpn);
//        controller.setTableRightJpn(tableRigthJtf);
        controller.setTableTopJpn(tableTopJpn);
        controller.init();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        tableTopJpn = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        loaiKhoanThuJtf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tenKhoanThuJtf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        soTienJtf = new javax.swing.JTextField();
        soCmtJtf = new javax.swing.JTextField();
        checkBtn = new javax.swing.JButton();
        availableIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Nhập người nộp:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Chọn khoản thu:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        saveBtn.setText("Lưu");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Hủy");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        tableTopJpn.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout tableTopJpnLayout = new javax.swing.GroupLayout(tableTopJpn);
        tableTopJpn.setLayout(tableTopJpnLayout);
        tableTopJpnLayout.setHorizontalGroup(
            tableTopJpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        tableTopJpnLayout.setVerticalGroup(
            tableTopJpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Tên khoản thu:");

        loaiKhoanThuJtf.setBackground(new java.awt.Color(240, 240, 240));
        loaiKhoanThuJtf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Số tiền:");

        tenKhoanThuJtf.setBackground(new java.awt.Color(240, 240, 240));
        tenKhoanThuJtf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Loại khoản thu:");

        soTienJtf.setBackground(new java.awt.Color(240, 240, 240));
        soTienJtf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        soTienJtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soTienJtfActionPerformed(evt);
            }
        });

        soCmtJtf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        checkBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        checkBtn.setText("Check");
        checkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBtnActionPerformed(evt);
            }
        });

        availableIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/checked.png"))); // NOI18N
        availableIcon.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tableTopJpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tenKhoanThuJtf, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(loaiKhoanThuJtf, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(soTienJtf, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(soCmtJtf, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(checkBtn)
                                .addGap(18, 18, 18)
                                .addComponent(availableIcon)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(soCmtJtf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(availableIcon))
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 221, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tableTopJpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(tenKhoanThuJtf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(soTienJtf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(loaiKhoanThuJtf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelBtn)
                            .addComponent(saveBtn))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
//        if (this.tenKhoanThuJtf.getText().trim().isEmpty()
//            || this.soTienJtf.getText().trim().isEmpty())
////            || this.loaiKhoanThuJtf.getText().trim().isEmpty()) 
//                {
//            JOptionPane.showMessageDialog(null, "Vui lòng nhập hết các thông tin bắt buộc", "Warning", JOptionPane.ERROR_MESSAGE);
//        } else {
//            this.khoanThuBean.getKhoanThuModel().setTenKhoanThu(tenKhoanThuJtf.getText().trim());
//            this.khoanThuBean.getKhoanThuModel().setSoTien(Integer.parseInt(soTienJtf.getText().trim()));
////            this.hoKhauBean.getHoKhauModel().setDiaChi(diaChiJtf.getText().trim());
//            int loaiKhoanThu = 0;
//            if(loaiKhoanThuJcb.getSelectedItem().toString().equals("Tự Nguyện")) {
//                loaiKhoanThu = 0;
//            } else {
//                loaiKhoanThu = 1;
//            }
//            this.khoanThuBean.getKhoanThuModel().setLoaiKhoanThu(loaiKhoanThu);
//            try {
//                this.controller.addNew(khoanThuBean);
//                this.parentJFrame.setEnabled(true);
//                dispose();
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        close();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void soTienJtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soTienJtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soTienJtfActionPerformed

    private void checkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBtnActionPerformed
        if (checkCMT(soCmtJtf.getText())) {
            int idNhanKhau = this.tamTruController.checkCMT(soCmtJtf.getText());
            if (idNhanKhau > 0) {
                this.nopTienModel.setIdNguoiNop(idNhanKhau);
                soCmtJtf.setEnabled(false);
                checkBtn.setEnabled(false);
                availableIcon.setEnabled(true);
            } else {
                if (JOptionPane.showConfirmDialog(null, "Không tìm thấy người có số CMT: " + soCmtJtf.getText() + ". Thêm mới?", "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                    AddNewPeopleJFrame addNewPeopleJFrame = new AddNewPeopleJFrame(this);
                    addNewPeopleJFrame.setLocationRelativeTo(null);
                    addNewPeopleJFrame.setResizable(false);
                    addNewPeopleJFrame.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_checkBtnActionPerformed

    private boolean checkCMT(String cmt) {
        if (cmt.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số CMT", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            try {
                long temp = Long.parseLong(cmt);
                if (cmt.trim().length() != 9 && cmt.trim().length() != 12) {
                    throw new Exception("Sai dinh dang");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng số CMT!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
        return true;
    }
    
    /**
     * @param args the command line arguments
     */
    
    private void close() {
        if (JOptionPane.showConfirmDialog(this, "Are you sure to close??", "Confirm", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            this.parentJFrame.setEnabled(true);
            dispose();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel availableIcon;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton checkBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField loaiKhoanThuJtf;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField soCmtJtf;
    private javax.swing.JTextField soTienJtf;
    private javax.swing.JPanel tableTopJpn;
    private javax.swing.JTextField tenKhoanThuJtf;
    // End of variables declaration//GEN-END:variables
}