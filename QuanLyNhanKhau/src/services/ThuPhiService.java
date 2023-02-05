/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import controllers.LoginController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Bean.KhoanThuBean;
import Bean.NhanKhauBean;
import models.KhoanThuModel;
import models.NhanKhauModel;
import models.NopTienModel;
/**
 *
 * @author Duy
 */
public class ThuPhiService {
     public List<KhoanThuBean> getListKhoanThu() {
        List<KhoanThuBean> list = new ArrayList<>();
        
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM khoan_thu";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                KhoanThuBean temp = new KhoanThuBean();
                KhoanThuModel khoanThuModel = temp.getKhoanThuModel();
                khoanThuModel.setId(rs.getInt("id"));
                khoanThuModel.setTenKhoanThu(rs.getString("tenKhoanThu"));
                khoanThuModel.setSoTien(rs.getInt("soTien"));
                khoanThuModel.setLoaiKhoanThu(rs.getInt("loaiKhoanThu"));
                list.add(temp);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
     public boolean addNew(KhoanThuBean khoanThuBean) throws ClassNotFoundException, SQLException{
         Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO khoan_thu(tenKhoanThu, soTien, loaiKhoanThu)" 
                    + " values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, khoanThuBean.getKhoanThuModel().getTenKhoanThu());
        preparedStatement.setInt(2, khoanThuBean.getKhoanThuModel().getSoTien());
        preparedStatement.setInt(3, khoanThuBean.getKhoanThuModel().getLoaiKhoanThu());

        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        JOptionPane.showMessageDialog(null, "Đã thêm khoản thu thành công!", "SUCCEED", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
     public int getIdByCmt(String cmt) throws ClassNotFoundException, SQLException {
         Connection connection = MysqlConnection.getMysqlConnection();
        String query = "SELECT idNhanKhau FROM chung_minh_thu WHERE soCMT=" + cmt;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery(query);
        int x = 0;
        while (rs.next()) {
            x = rs.getInt(1);
        }       
        return x;
     }
     public boolean nopTien(KhoanThuBean nopTienBean) throws ClassNotFoundException, SQLException{
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "SELECT * FROM nop_tien WHERE idNguoiNop = ? AND idKhoanThu = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, nopTienBean.getNopTienModel().getIdNguoiNop());
        preparedStatement.setInt(2, nopTienBean.getNopTienModel().getIdKhoanThu());
        ResultSet rs = preparedStatement.executeQuery();
        if(rs.next()) {
            JOptionPane.showMessageDialog(null, "Nhân khẩu đã nộp tiền khoản thu này trước đó!", "ERROR", JOptionPane.ERROR_MESSAGE);
            preparedStatement.close();
            connection.close();
            return false;
        }
        query = "INSERT INTO nop_tien(idNguoiNop, idKhoanThu, ngayNop)" 
                    + " values (?, ?, NOW())";
        preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, nopTienBean.getNopTienModel().getIdNguoiNop());
        preparedStatement.setInt(2, nopTienBean.getNopTienModel().getIdKhoanThu());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        JOptionPane.showMessageDialog(null, "Đã nộp tiền thành công!", "SUCCEED", JOptionPane.INFORMATION_MESSAGE);
        return true;
     }
     
     public List<NhanKhauBean> getListNopTienKhoan(int idKhoanThu) {
        List<NhanKhauBean> list = new ArrayList<>();
        
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT nk.hoTen, nk.namSinh FROM nhan_khau nk "
                    + "INNER JOIN nop_tien nt ON nt.idNguoiNop = nk.ID "
                    + "WHERE nt.idKhoanThu = " + idKhoanThu;
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                NhanKhauBean temp = new NhanKhauBean();
                NhanKhauModel nhanKhauModel = temp.getNhanKhauModel();
                nhanKhauModel.setHoTen(rs.getString(1));
                nhanKhauModel.setNamSinh(rs.getDate(2));
                list.add(temp);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
