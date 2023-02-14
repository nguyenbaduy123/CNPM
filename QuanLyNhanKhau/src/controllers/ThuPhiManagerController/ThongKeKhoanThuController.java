/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.ThuPhiManagerController;

import Bean.HoKhauBean;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.EventObject;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import services.ThuPhiService;
import utility.TableModelThuPhi;

/**
 *
 * @author Duy
 */
public class ThongKeKhoanThuController {

    private JPanel tableJpn;
    private JLabel jLabel;
    private JFrame parentJFrame;
    private ThuPhiService thuPhiService = new ThuPhiService();
    private ThongKeKhoanThuController controller;
    private int idKhoanThuSelected;
    private List<HoKhauBean> list;
    
    private final TableModelThuPhi tableModelThuPhi = new TableModelThuPhi();
    private final String COLUNMS[] = {"STT", "Mã hộ khẩu", "Chủ hộ", "Số tiền đã nộp"}; 
    
    public ThongKeKhoanThuController(JPanel tableJpn, JLabel jlabel, int idKhoanThuSelected) {
        this.tableJpn = tableJpn;
        this.jLabel = jlabel;
        this.list = thuPhiService.getListNopTienKhoan(idKhoanThuSelected);
        setData();
    }
    
    
     public void setData() {
//        this.list = thuPhiService.getListNopTienKhoan(idKhoanThuSelected);
        DefaultTableModel model = tableModelThuPhi.setTableNopTien(list, COLUNMS);

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
         JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        tableJpn.removeAll();
        tableJpn.setLayout(new BorderLayout());
        tableJpn.add(scroll);
        tableJpn.validate();
        tableJpn.repaint();
        int sum = 0;
        for(int i=0; i<list.size(); i++) {
            sum += list.get(i).getNopTienModel().getSoTien();
        }
        this.jLabel.setText("Tổng thu: " + sum + " đồng");
    }

    
    public void setParentJFrame(JFrame parentJFrame) {
        this.parentJFrame = parentJFrame;
    }
}
