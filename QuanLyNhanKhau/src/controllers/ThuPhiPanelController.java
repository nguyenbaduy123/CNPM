package controllers;

import Bean.HoKhauBean;
import Bean.KhoanThuBean;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import models.KhoanThuModel;
import services.ThuPhiService;
import utility.ClassTableModel;
import utility.TableModelThuPhi;
import views.ThuPhiManagerFrame.EditKhoanThu;
import views.ThuPhiManagerFrame.ThongKeKhoanThu;
import views.infoViews.InfoJframe;

/**
 *
 * @author Hai
 */
public class ThuPhiPanelController {
    
//    private List<KhoanThuBean> list;
    private List<KhoanThuBean> list;
    private JTextField searchJtf;
    private JPanel tableJpn;
    private JTextField jtfSearch;
    private final ThuPhiService thuPhiService = new ThuPhiService();
//        private final HoKhauService hoKhauService = new HoKhauService();

    private final TableModelThuPhi tableModelThuPhi = new TableModelThuPhi();
    private final String COLUNMS[] = {"Tên Khoản Thu", "Số tiền", "Loại khoản thu", "Trạng thái"}; 
    private JFrame parentJFrame;
    
    int idTemp;

    public ThuPhiPanelController(JPanel tableJpn, JTextField jtfSearch) {
        this.tableJpn = tableJpn;
        this.jtfSearch = jtfSearch;
        this.list = thuPhiService.getListKhoanThu();
        initAction();
        setData();
    }
    
    public ThuPhiPanelController() {}
    
    public void initAction(){
    
        if(!this.jtfSearch.getText().equals("")) {
            return;
        }

        this.jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
               
            @Override
            public void insertUpdate(DocumentEvent e) {
                String keyword = jtfSearch.getText();
                list = thuPhiService.search(keyword.trim());
                setData();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String keyword = jtfSearch.getText();
                list = thuPhiService.search(keyword.trim());
                setData();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String keyword = jtfSearch.getText();
                list = thuPhiService.search(keyword.trim());
                setData();
            }
        });

    }

    public void setData() {
//        DefaultTableModel model = tableModelHoKhau.setTableHoKhau(list, COLUNMS);
//        this.list = thuPhiService.getListKhoanThu();
        DefaultTableModel model = tableModelThuPhi.setTableKhoanThu(list, COLUNMS);
        
        JTable table = new JTable(model) {
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }
            
        };
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 1) {
                    KhoanThuBean temp = list.get(table.getSelectedRow());
                    idTemp = temp.getKhoanThuModel().getId();
                }
                if (e.getClickCount() > 1) {
                    KhoanThuBean temp = list.get(table.getSelectedRow());
                    int idKhoanThuSelected = temp.getKhoanThuModel().getId();
                    ThongKeKhoanThu thongke = new ThongKeKhoanThu(parentJFrame, idKhoanThuSelected);
                    thongke.setResizable(false);
                    thongke.setLocationRelativeTo(parentJFrame);
                    thongke.setPreferredSize(new Dimension(800, 400));
                    thongke.setVisible(true);
                    thongke.pack();
                }
            }
            
        });
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        tableJpn.removeAll();
        tableJpn.setLayout(new BorderLayout());
        tableJpn.add(scroll);
        tableJpn.validate();
        tableJpn.repaint();
    }
    
    public void setParentJFrame(JFrame parentJFrame) {
        this.parentJFrame = parentJFrame;
    }
    
    public List<KhoanThuBean> getList() {
        return list;
    }

    public void setList(List<KhoanThuBean> list) {
        this.list = list;
    }

    public JTextField getSearchJtf() {
        return searchJtf;
    }

    public void setSearchJtf(JTextField searchJtf) {
        this.searchJtf = searchJtf;
    }

    public JPanel getTableJpn() {
        return tableJpn;
    }

    public void setTableJpn(JPanel tableJpn) {
        this.tableJpn = tableJpn;
    }
    
    public void delete() {
        
        if(idTemp == 0) {
            JOptionPane.showMessageDialog(parentJFrame, "Bạn cần chọn khoản thu để xóa", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int check = JOptionPane.showConfirmDialog(parentJFrame, "Bạn thực sự muốn xóa khoản thu này?", "Cảnh báo", JOptionPane.YES_NO_CANCEL_OPTION);
        if(check == 0) {     
            if(thuPhiService.deleteKhoanThu(idTemp)) {
               JOptionPane.showMessageDialog(parentJFrame, "Đã xóa khoản thu này thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
               setData();
            }
        } else return;
    }
    
    public void edit() {
        if(idTemp == 0) {
            JOptionPane.showMessageDialog(parentJFrame, "Bạn cần chọn khoản thu để sửa", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        EditKhoanThu edit = new EditKhoanThu(this.parentJFrame, this, idTemp);
        edit.setLocationRelativeTo(null);
        edit.setResizable(false);
        edit.setVisible(true);
//        setData();
    }
}
