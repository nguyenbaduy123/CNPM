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
    private final String COLUNMS[] = {"Tên Khoản Thu", "Số tiền", "Loại khoản thu"}; 
    private JFrame parentJFrame;

    public ThuPhiPanelController(JPanel tableJpn, JTextField jtfSearch) {
        this.tableJpn = tableJpn;
        this.jtfSearch = jtfSearch;
        this.list = thuPhiService.getListKhoanThu();
        initAction();
        setData();
    }
    
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
                if (e.getClickCount() > 1) {
                    KhoanThuBean temp = list.get(table.getSelectedRow());
                    int idKhoanThuSelected = temp.getKhoanThuModel().getId();
                    JFrame nopTienJFrame = new JFrame();
                    nopTienJFrame.setTitle("Danh sách hộ đã nộp khoản thu này");
                    nopTienJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    nopTienJFrame.setPreferredSize(new Dimension(800, 400));
                    nopTienJFrame.pack();
                    nopTienJFrame.setLocationRelativeTo(null);
                    nopTienJFrame.setVisible(true);
                    List<HoKhauBean> listNopTien = thuPhiService.getListNopTienKhoan(idKhoanThuSelected);
                    String COLUNMSNopTien[] = {"STT", "Mã hộ khẩu", "Chủ hộ", "Số tiền đã nộp"}; 
                    DefaultTableModel model = tableModelThuPhi.setTableNopTien(listNopTien, COLUNMSNopTien);

                    JTable tableNopTien = new JTable(model) {
                        @Override
                        public boolean editCellAt(int row, int column, EventObject e) {
                            return false;
                        }

                    };
                    tableNopTien.getColumnModel().getColumn(0).setPreferredWidth(4);
                    tableNopTien.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
                    tableNopTien.getTableHeader().setPreferredSize(new Dimension(100, 50));
                    tableNopTien.setRowHeight(50);
                    tableNopTien.validate();
                    tableNopTien.repaint();
                    tableNopTien.setFont(new Font("Arial", Font.PLAIN, 14));
                    JPanel tableNopTienJpn = new JPanel();
                    JScrollPane scroll = new JScrollPane();
                    scroll.getViewport().add(tableNopTien);
                    nopTienJFrame.getContentPane().add(tableNopTienJpn);
                    tableNopTienJpn.removeAll();
                    tableNopTienJpn.setLayout(new BorderLayout());
                    tableNopTienJpn.add(scroll);
                    tableNopTienJpn.validate();
                    tableNopTienJpn.repaint();
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
    
}
