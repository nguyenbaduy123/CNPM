/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.HoKhauManagerController;

import Bean.HoKhauBean;
import Bean.MemOfFamily;
import Bean.NhanKhauBean;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.EventObject;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import services.HoKhauService;
import utility.TableModelHoKhau;

/**
 *
 * @author Duy
 */
public class EditHoKhauController {
    
    private NhanKhauBean chuHo;
    private List<MemOfFamily> listThanhVien;
    private JPanel memTableJpn;
    private TableModelHoKhau tableModelHoKhau = new TableModelHoKhau();
    private final HoKhauService service = new HoKhauService();
    private final String[] COLUMNS= {"Họ tên", "Ngày sinh", "Quan hệ với chủ hộ"};
    
    public void editHoKhau(HoKhauBean hoKhauBean) {
        if(service.editHoKhau(hoKhauBean)) {
            JOptionPane.showMessageDialog(memTableJpn, "Đã sửa thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void setData(List<MemOfFamily> listMember, JPanel tablePanel) {
        DefaultTableModel model_mem = this.tableModelHoKhau.setTableMember(listMember, COLUMNS);
        JTable table_mem = new JTable(model_mem){
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;   //To change body of generated methods, choose Tools | Templates.
            }
        };
        table_mem.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table_mem.getTableHeader().setPreferredSize(new Dimension(100, 30));
        table_mem.setRowHeight(30);
        table_mem.validate();
        table_mem.repaint();
        table_mem.setFont(new Font("Arial", Font.PLAIN, 14));
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table_mem);
        tablePanel.removeAll();
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(scroll);
        tablePanel.validate();
        tablePanel.repaint();
    }
}
