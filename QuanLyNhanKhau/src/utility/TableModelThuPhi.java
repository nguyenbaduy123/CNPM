/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import Bean.KhoanThuBean;
import Bean.NhanKhauBean;
import Bean.HoKhauBean;
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
    public DefaultTableModel setTableNopTien(List<HoKhauBean> listItem, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 4 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        int stt = 1;
        for(int i=0; i<listItem.size(); i++) {
            obj[0] = stt++;
            obj[1] = listItem.get(i).getHoKhauModel().getMaHoKhau();
            obj[2] = listItem.get(i).getChuHo().getHoTen();
            obj[3] = listItem.get(i).getNopTienModel().getSoTien();
            dtm.addRow(obj);
        }
//        listItem.forEach((NhanKhauBean item) -> {  
//            obj[0] = stt;
//            obj[1] = item.getNhanKhauModel().getHoTen();
//            obj[2] = item.getNhanKhauModel().getNamSinh();
//            dtm.addRow(obj);
//        });
        return dtm;
    }
}
