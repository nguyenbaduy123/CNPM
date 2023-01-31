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
import java.util.EventObject;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import services.ThuPhiService;
import utility.TableModelThuPhi;
import views.infoViews.InfoJframe;

/**
 *
 * @author Duy
 */
public class NopTienController {
    private JTextField soCmtJtf;
    private JPanel tableTopJpn;
    private JPanel tableBotJpn;
    private JPanel tableRightJpn;
    private JTextField tenKhoanThuJft;
    private JTextField soTienJft;
    private JTextField loaiKhoanThuJft;
    private final ThuPhiService thuPhiService = new ThuPhiService();
    private final TableModelThuPhi tableModelThuPhi = new TableModelThuPhi();
    private JFrame nopTienJFrame;
    
    private List<KhoanThuBean> listKhoanThu;
    private final String[] COLUNMS = {"Tên khoản thu", "Số tiền", "Loại khoản thu"};
    private KhoanThuBean khoanThuSelected;

    public NopTienController(JFrame nopTienJFrame) {
        this.nopTienJFrame = nopTienJFrame;
    }
    
    public void init() {
        listKhoanThu = this.thuPhiService.getListKhoanThu();
        setData();
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
                KhoanThuBean temp = listKhoanThu.get(table.getSelectedRow());
                if (e.getClickCount() > 1) {
                    InfoJframe infoJframe = new InfoJframe(temp.toString(), nopTienJFrame);
                    infoJframe.setLocationRelativeTo(null);
                    infoJframe.setVisible(true);
                } else {
                    // selected data
                    khoanThuSelected = temp;
                    tenKhoanThuJft.setText(khoanThuSelected.getKhoanThuModel().getTenKhoanThu());
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
}
