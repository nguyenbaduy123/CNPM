package controllers;

import Bean.NhanKhauBean;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import models.NhanKhauModel;
import services.NhanKhauService;
import utility.ClassTableModel;
import views.NhanKhauManagerFrame.EditNhanKhauJFrame;
import views.infoViews.InfoJframe;


public class NhanKhauManagerPanelController {
    
    private JPanel jpnView;
    private JTextField jtfSearch;
    private NhanKhauService nhanKhauService;
    private List<NhanKhauBean> listNhanKhauBeans;
    private ClassTableModel classTableModel = null;
    private final String[] COLUMNS = {"ID", "Họ tên", "Ngày sinh", "Giới tính", "Địa chỉ hiện nay"};
    private JFrame parentJFrame;
    private int tempId = 0;
    private String tempCmt = "";
    
    public NhanKhauManagerPanelController(JPanel jpnView, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.jtfSearch = jtfSearch;
        classTableModel = new ClassTableModel();
        this.nhanKhauService = new NhanKhauService();
        this.listNhanKhauBeans = this.nhanKhauService.getListNhanKhau();
  
        initAction();
    }

    public NhanKhauManagerPanelController() {
        this.classTableModel = new ClassTableModel();
        this.nhanKhauService = new NhanKhauService();
        this.listNhanKhauBeans = this.nhanKhauService.getListNhanKhau();
    }
    
    
    //
    public void initAction(){
        this.jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String key = jtfSearch.getText();
                listNhanKhauBeans = nhanKhauService.search(key.trim());
                setDataTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String key = jtfSearch.getText();
                listNhanKhauBeans = nhanKhauService.search(key.trim());
                setDataTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String key = jtfSearch.getText();
                listNhanKhauBeans = nhanKhauService.search(key.trim());
                setDataTable();
            }
        });
    }
    
    public void setDataTable() {
        List<NhanKhauModel> listItem = new ArrayList<>();
        this.listNhanKhauBeans.forEach(nhankhau -> {
            listItem.add(nhankhau.getNhanKhauModel());
        });
        DefaultTableModel model = classTableModel.setTableNhanKhau(listItem, COLUMNS);
        JTable table = new JTable(model) {
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }
            
        };
        
        // thiet ke bang
        
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMaxWidth(50);
        table.getColumnModel().getColumn(0).setMinWidth(50);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setMaxWidth(150);
        table.getColumnModel().getColumn(1).setMinWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(50);
        table.getColumnModel().getColumn(2).setMaxWidth(100);
        table.getColumnModel().getColumn(2).setMinWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setMaxWidth(80);
        table.getColumnModel().getColumn(3).setMinWidth(80);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setMaxWidth(270);
        table.getColumnModel().getColumn(4).setMinWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                JOptionPane.showConfirmDialog(null, table.getSelectedRow());
                if(e.getClickCount() == 1) {
                  NhanKhauBean temp = listNhanKhauBeans.get(table.getSelectedRow());
                  tempId = temp.getNhanKhauModel().getID();
                  tempCmt = temp.getChungMinhThuModel().getSoCMT();
                }
                else if (e.getClickCount() > 1) {
                    NhanKhauBean temp = listNhanKhauBeans.get(table.getSelectedRow());
                    NhanKhauBean info = nhanKhauService.getNhanKhau(temp.getChungMinhThuModel().getSoCMT());
                    InfoJframe infoJframe = new InfoJframe(info.toString(), parentJFrame);
                    infoJframe.setLocationRelativeTo(null);
                    infoJframe.setVisible(true);
                }
            }
            
        });
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }

    public void setParentJFrame(JFrame parentJFrame) {
        this.parentJFrame = parentJFrame;
    }
    
    public void refreshData() {
        this.listNhanKhauBeans = this.nhanKhauService.getListNhanKhau();
        setDataTable();
    }
    public JPanel getJpnView() {
        return jpnView;
    }

    public void setJpnView(JPanel jpnView) {
        this.jpnView = jpnView;
    }

    public JTextField getJtfSearch() {
        return jtfSearch;
    }

    public void setJtfSearch(JTextField jtfSearch) {
        this.jtfSearch = jtfSearch;
    }

    public int getTempId() {
        return tempId;
    }

    public String getTempCmt() {
        return tempCmt;
    }
    
    public void delete(int id) {
        if(id == 0) {
            JOptionPane.showMessageDialog(parentJFrame, "Bạn cần chọn nhân khẩu để xóa", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int check = JOptionPane.showConfirmDialog(parentJFrame, "Bạn thực sự muốn xóa nhân khẩu này?", "Warning", JOptionPane.YES_NO_CANCEL_OPTION);
        
        if(check == 0) { 
            if(nhanKhauService.delete(id)) {
                JOptionPane.showMessageDialog(parentJFrame, "Đã xóa nhân khẩu thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                setDataTable();
            }
        } else {
            return;
        }
    }
    public void edit() {
        if(tempCmt.equals("") || tempCmt.equals(null)) {
            JOptionPane.showMessageDialog(parentJFrame, "Bạn cần chọn nhân khẩu để sửa", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        EditNhanKhauJFrame editNhanKhau = new EditNhanKhauJFrame(this.parentJFrame,this, this.tempCmt);
        editNhanKhau.setVisible(true);
    }
}
