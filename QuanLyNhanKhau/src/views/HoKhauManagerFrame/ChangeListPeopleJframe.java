/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.HoKhauManagerFrame;

import Bean.MemOfFamily;
import controllers.HoKhauManagerController.ChangeListPeopleController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Hien
 */
public class ChangeListPeopleJframe extends javax.swing.JFrame {

    /**
     *     public ChangeListPeopleController(List<MemOfFamily> listMember, JButton addBtn, JButton removeBtn, JTextField searchJtf, JPanel peopleJpn, JPanel memJpn) {
     */
    private List<MemOfFamily> listMember;
    private List<MemOfFamily> listMemberTemp;
    private ChangeListPeopleController controller;
    private JFrame parentJframe;
    private String operation;
    
    /**
     * Creates new form ChangeListPeopleJframe
     * @param listMember
     * @param parentJFrame
     */
    public ChangeListPeopleJframe(List<MemOfFamily> listMember, JFrame parentJFrame, String operation) {
        initComponents();
        this.operation = operation;
        this.listMember = listMember;
        this.listMemberTemp = new ArrayList<>();
        this.listMemberTemp.addAll(listMember);
        this.parentJframe = parentJFrame;
        this.controller = new ChangeListPeopleController(this.listMemberTemp, addBtn, removeBtn, jTextField1, PeopleTableJpn, MemTableJpn);
        this.parentJframe.setEnabled(false);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                close();
            }
            
        });
    }
    private void close() {
        if (JOptionPane.showConfirmDialog(this, "Are you sure to close??", "Confirm", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            this.parentJframe.setEnabled(true);
            dispose();
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

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        PeopleTableJpn = new javax.swing.JPanel();
        MemTableJpn = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        jTextField1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout PeopleTableJpnLayout = new javax.swing.GroupLayout(PeopleTableJpn);
        PeopleTableJpn.setLayout(PeopleTableJpnLayout);
        PeopleTableJpnLayout.setHorizontalGroup(
            PeopleTableJpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PeopleTableJpnLayout.setVerticalGroup(
            PeopleTableJpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout MemTableJpnLayout = new javax.swing.GroupLayout(MemTableJpn);
        MemTableJpn.setLayout(MemTableJpnLayout);
        MemTableJpnLayout.setHorizontalGroup(
            MemTableJpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
        );
        MemTableJpnLayout.setVerticalGroup(
            MemTableJpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
        );

        addBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        addBtn.setText(">>");

        removeBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        removeBtn.setText("<<");

        saveBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        saveBtn.setText("Lưu thay đổi");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                    .addComponent(PeopleTableJpn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(saveBtn)
                            .addComponent(MemTableJpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addBtn)
                            .addComponent(removeBtn))
                        .addGap(333, 333, 333))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PeopleTableJpn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MemTableJpn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeBtn)
                        .addGap(0, 244, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        
//        for(int i=0; i<this.listMember.size(); i++) {
//            System.out.println(this.listMemberTemp.get(i).getNhanKhau().getNhanKhauModel().getID());
//        }
        if(this.operation.equals("add")) {
            this.listMember.clear();
            this.listMember.addAll(this.listMemberTemp);
            ThemMoiHoKhau themMoiHoKhau = (ThemMoiHoKhau)this.parentJframe;
            themMoiHoKhau.setDataThanhVien();
        } else if(this.operation.equals("edit")) {
//            this.listMemberTemp.removeAll(this.listMember);
            for(int i = 0; i < listMemberTemp.size(); i++) {
                System.out.println(listMemberTemp.get(i).getNhanKhau().getNhanKhauModel().getID());
            }
//            this.listMember.clear();
//            this.listMember.addAll(this.controller.getListMember());
            EditHoKhauJFrame editHoKhau = (EditHoKhauJFrame)this.parentJframe;
            editHoKhau.setList(this.listMemberTemp);
            editHoKhau.setDataChuHo();
            editHoKhau.setDataThanhVien();
        }
        close();
    }//GEN-LAST:event_saveBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MemTableJpn;
    private javax.swing.JPanel PeopleTableJpn;
    private javax.swing.JButton addBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton removeBtn;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
