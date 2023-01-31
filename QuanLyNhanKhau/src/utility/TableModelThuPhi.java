/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import Bean.KhoanThuBean;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Duy
 */
public class TableModelThuPhi {
    public DefaultTableModel setTableKhoanThu(List<KhoanThuBean> listItem, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 3 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((KhoanThuBean item) -> {  
            obj[0] = item.getKhoanThuModel().getTenKhoanThu();
            obj[1] = item.getKhoanThuModel().getSoTien();
            if(item.getKhoanThuModel().getLoaiKhoanThu()== 0) {
                obj[2] = "Tự nguyện";
            } else {
                obj[2] = "Bắt buộc";
            }
            dtm.addRow(obj);
        });
        return dtm;
    }
}