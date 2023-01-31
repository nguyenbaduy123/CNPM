/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.ThuPhiManagerFrame;
import Bean.KhoanThuBean;
import controllers.ThuPhiManagerController.AddKhoanThuController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import  javax.swing.JButton;
/**
 *
 * @author Duy
 */
public class ThemKhoanThu extends javax.swing.JFrame {

    /**
     * Creates new form ThemMoiKhoanThu
     */
    private JFrame parentJFrame;
    private KhoanThuBean khoanThuBean = new KhoanThuBean();
    private final AddKhoanThuController controller = new AddKhoanThuController();
    public ThemKhoanThu(JFrame parentJFrame) {
        initComponents();
        this.parentJFrame = parentJFrame;
        parentJFrame.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tenKhoanThuJtf = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        soTienJtf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        loaiKhoanThuJcb = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tenKhoanThuJtf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tenKhoanThuJtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenKhoanThuJtfActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Tên khoản thu:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Số tiền:");

        soTienJtf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        soTienJtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soTienJtfActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Loại khoản thu:");

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

        loaiKhoanThuJcb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tự Nguyện", "Bắt buộc"}));
        loaiKhoanThuJcb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loaiKhoanThuJcbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tenKhoanThuJtf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(soTienJtf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loaiKhoanThuJcb, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tenKhoanThuJtf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soTienJtf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loaiKhoanThuJcb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(cancelBtn))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tenKhoanThuJtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenKhoanThuJtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenKhoanThuJtfActionPerformed

    private void soTienJtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soTienJtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soTienJtfActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        if (this.tenKhoanThuJtf.getText().trim().isEmpty()
            || this.soTienJtf.getText().trim().isEmpty())
//            || this.loaiKhoanThuJtf.getText().trim().isEmpty()) 
                {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập hết các thông tin bắt buộc", "Warning", JOptionPane.ERROR_MESSAGE);
        } else {
            this.khoanThuBean.getKhoanThuModel().setTenKhoanThu(tenKhoanThuJtf.getText().trim());
            this.khoanThuBean.getKhoanThuModel().setSoTien(Integer.parseInt(soTienJtf.getText().trim()));
//            this.hoKhauBean.getHoKhauModel().setDiaChi(diaChiJtf.getText().trim());
            int loaiKhoanThu = 0;
            if(loaiKhoanThuJcb.getSelectedItem().toString().equals("Tự Nguyện")) {
                loaiKhoanThu = 0;
            } else {
                loaiKhoanThu = 1;
            }
            this.khoanThuBean.getKhoanThuModel().setLoaiKhoanThu(loaiKhoanThu);
            try {
                this.controller.addNew(khoanThuBean);
                this.parentJFrame.setEnabled(true);
                dispose();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        close();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void loaiKhoanThuJcbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loaiKhoanThuJcbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loaiKhoanThuJcbActionPerformed

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
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> loaiKhoanThuJcb;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField soTienJtf;
    private javax.swing.JTextField tenKhoanThuJtf;
    // End of variables declaration//GEN-END:variables
}
