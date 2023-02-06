/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.ThuPhiManagerController;

import Bean.HoKhauBean;
import Bean.KhoanThuBean;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.EventObject;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import services.ThuPhiService;
import utility.TableModelThuPhi;
import views.infoViews.InfoJframe;
import javax.swing.JOptionPane;
import models.NopTienModel;

/**
 *
 * @author Duy
 */
public class NopTienController {
    private JTextField soCmtJtf;
    private JPanel tableTopJpn;
    private JPanel tableBotJpn;
    private JPanel tableRightJpn;
    private int idKhoanThu;
    private int soNhanKhau;
    private JTextField tenKhoanThuJft;
    private JTextField soTienJft;
    private JTextField loaiKhoanThuJft;
    private JTextField soNhanKhauJtf;
    private JButton cancelBtn;
    private JButton acceptBtn;
    private final ThuPhiService thuPhiService = new ThuPhiService();
    private final TableModelThuPhi tableModelThuPhi = new TableModelThuPhi();
    private JFrame nopTienJFrame;
    
    private List<KhoanThuBean> listKhoanThu;
    private final String[] COLUNMS = {"Tên khoản thu", "Số tiền", "Loại khoản thu"};
    private KhoanThuBean khoanThuSelected;
    private KhoanThuBean nopTienBean = new KhoanThuBean();

    public NopTienController(JFrame nopTienJFrame) {
        this.nopTienJFrame = nopTienJFrame;
    }
    
    public void init() {
        listKhoanThu = this.thuPhiService.getListKhoanThu();
        setData();
        acceptBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tenKhoanThuJft.getText().trim().isEmpty() 
                        || soTienJft.getText().trim().isEmpty() 
                        || loaiKhoanThuJft.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập hết các trường bắt buộc!");
                } else {
                    try {
                        int idNguoiNop = thuPhiService.getIdByCmt(soCmtJtf.getText().trim());
                        nopTienBean.getNopTienModel().setIdNguoiNop(idNguoiNop);
                        nopTienBean.getNopTienModel().setIdKhoanThu(idKhoanThu);
                        nopTienBean.getNopTienModel().setSoTien(Integer.parseInt(soTienJft.getText()));
                        thuPhiService.nopTien(nopTienBean);
//                    TachHoKhau tachHoKhau = (TachHoKhau)tachHoKhauJFrame;
//                    tachHoKhau.getParentJFrame().setEnabled(true);
//                    nopTien.dispose();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(NopTienController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(NopTienController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
        });
    }
    
    public void setData() {
        TableModel hokhau_model = this.tableModelThuPhi.setTableKhoanThu(listKhoanThu, COLUNMS);
        JTable table = new JTable(hokhau_model) {
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }
        };
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 30));
        table.setRowHeight(30);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(soCmtJtf.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "Mời bạn nhập Chứng minh thư trước", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                KhoanThuBean temp = listKhoanThu.get(table.getSelectedRow());
                if (e.getClickCount() > 1) {
                    InfoJframe infoJframe = new InfoJframe(temp.toString(), nopTienJFrame);
                    infoJframe.setLocationRelativeTo(null);
                    infoJframe.setVisible(true);
                } else {
                    // selected data
                    khoanThuSelected = temp;
                    int idNguoiNop = 0;
                    try {
                        idNguoiNop = thuPhiService.getIdByCmt(soCmtJtf.getText().trim());
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(NopTienController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(NopTienController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    soNhanKhau = thuPhiService.getNumberOfMember(idNguoiNop);
                    soNhanKhauJtf.setText(soNhanKhau + "");
                    idKhoanThu = khoanThuSelected.getKhoanThuModel().getId();
                    tenKhoanThuJft.setText(khoanThuSelected.getKhoanThuModel().getTenKhoanThu());
                    int soTien = khoanThuSelected.getKhoanThuModel().getSoTien();
                    int loaiKhoanThu = khoanThuSelected.getKhoanThuModel().getLoaiKhoanThu();
                    if(loaiKhoanThu == 0) {
                        soTienJft.setEditable(true);
                        loaiKhoanThuJft.setText("Tự nguyện");
                    } else {
                        soTienJft.setEnabled(true);
                        soTienJft.setEditable(false);
                        soTienJft.setText(Integer.toString(soTien*soNhanKhau));
                        loaiKhoanThuJft.setText("Bắt buộc");
                    }
                }
            }
            
        });
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(tableTopJpn.getSize());
        tableTopJpn.removeAll();
        tableTopJpn.setLayout(new BorderLayout());
        tableTopJpn.add(scroll);
        tableTopJpn.validate();
        tableTopJpn.repaint();
    }

    public JTextField getSoCmtJtf() {
        return soCmtJtf;
    }

    public void setCancelBtn(JButton cancelBtn) {
        this.cancelBtn = cancelBtn;
    }

    public void setAcceptBtn(JButton acceptBtn) {
        this.acceptBtn = acceptBtn;
    }

    public void setSoNhanKhauJtf(JTextField soNhanKhauJtf) {
        this.soNhanKhauJtf = soNhanKhauJtf;
    }

    public JButton getCancelBtn() {
        return cancelBtn;
    }

    public JButton getAcceptBtn() {
        return acceptBtn;
    }

    public JPanel getTableTopJpn() {
        return tableTopJpn;
    }

    public JPanel getTableBotJpn() {
        return tableBotJpn;
    }

    public JPanel getTableRightJpn() {
        return tableRightJpn;
    }

    public JTextField getTenKhoanThuJft() {
        return tenKhoanThuJft;
    }

    public JTextField getSoTienJft() {
        return soTienJft;
    }

    public JTextField getLoaiKhoanThuJft() {
        return loaiKhoanThuJft;
    }

    public ThuPhiService getThuPhiService() {
        return thuPhiService;
    }

    public TableModelThuPhi getTableModelThuPhi() {
        return tableModelThuPhi;
    }

    public JFrame getNopTienJFrame() {
        return nopTienJFrame;
    }

    public List<KhoanThuBean> getListKhoanThu() {
        return listKhoanThu;
    }

    public String[] getCOLUNMS() {
        return COLUNMS;
    }

    public KhoanThuBean getKhoanThuSelected() {
        return khoanThuSelected;
    }

    public void setSoCmtJtf(JTextField soCmtJtf) {
        this.soCmtJtf = soCmtJtf;
    }

    public void setTableTopJpn(JPanel tableTopJpn) {
        this.tableTopJpn = tableTopJpn;
    }

    public void setTableBotJpn(JPanel tableBotJpn) {
        this.tableBotJpn = tableBotJpn;
    }

    public void setTableRightJpn(JPanel tableRightJpn) {
        this.tableRightJpn = tableRightJpn;
    }

    public void setTenKhoanThuJft(JTextField tenKhoanThuJft) {
        this.tenKhoanThuJft = tenKhoanThuJft;
    }

    public void setSoTienJft(JTextField soTienJft) {
        this.soTienJft = soTienJft;
    }

    public void setLoaiKhoanThuJft(JTextField loaiKhoanThuJft) {
        this.loaiKhoanThuJft = loaiKhoanThuJft;
    }

    public void setNopTienJFrame(JFrame nopTienJFrame) {
        this.nopTienJFrame = nopTienJFrame;
    }

    public void setListKhoanThu(List<KhoanThuBean> listKhoanThu) {
        this.listKhoanThu = listKhoanThu;
    }

    public void setKhoanThuSelected(KhoanThuBean khoanThuSelected) {
        this.khoanThuSelected = khoanThuSelected;
    }

    public int getIdKhoanThu() {
        return idKhoanThu;
    }

    public void setIdKhoanThu(int idKhoanThu) {
        this.idKhoanThu = idKhoanThu;
    }

}
