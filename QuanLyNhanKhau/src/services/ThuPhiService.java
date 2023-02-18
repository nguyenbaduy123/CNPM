/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import Bean.HoKhauBean;
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
import models.KhoanThuModel;

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
                khoanThuModel.setNgayBatDau(rs.getDate("ngayBatDau"));
                khoanThuModel.setNgayKetThuc(rs.getDate("ngayKetThuc"));
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
        String query = "INSERT INTO khoan_thu(tenKhoanThu, soTien, loaiKhoanThu, ngayBatDau, ngayKetThuc)" 
                    + " values (?, ?, ?, NOW(), ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, khoanThuBean.getKhoanThuModel().getTenKhoanThu());
        preparedStatement.setInt(2, khoanThuBean.getKhoanThuModel().getSoTien());
        preparedStatement.setInt(3, khoanThuBean.getKhoanThuModel().getLoaiKhoanThu());
        java.sql.Date ngaykt = new java.sql.Date(khoanThuBean.getKhoanThuModel().getNgayKetThuc().getTime());
        preparedStatement.setDate(4, ngaykt);

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
        query = "INSERT INTO nop_tien(idNguoiNop, idKhoanThu, ngayNop, soTien)" 
                    + " values (?, ?, NOW(), ?)";
        preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, nopTienBean.getNopTienModel().getIdNguoiNop());
        preparedStatement.setInt(2, nopTienBean.getNopTienModel().getIdKhoanThu());
        preparedStatement.setInt(3, nopTienBean.getNopTienModel().getSoTien());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        JOptionPane.showMessageDialog(null, "Đã nộp tiền thành công!", "SUCCEED", JOptionPane.INFORMATION_MESSAGE);
        return true;
     }
     
     public List<HoKhauBean> getListNopTienKhoan(int idKhoanThu) {
        List<HoKhauBean> list = new ArrayList<>();
        
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT hk.maHoKhau, nk.hoTen, nt.soTien FROM nhan_khau nk "
                    + "INNER JOIN nop_tien nt ON nt.idNguoiNop = nk.id "
                    + "INNER JOIN thanh_vien_cua_ho tvch ON tvch.idNhanKhau = nk.id "
                    + "INNER JOIN ho_khau hk ON hk.id = tvch.idHoKhau "
                    + "WHERE nt.idKhoanThu = " + idKhoanThu;
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                HoKhauBean temp = new HoKhauBean();
                temp.getHoKhauModel().setMaHoKhau(rs.getString(1));
                temp.getChuHo().setHoTen(rs.getString(2));
                temp.getNopTienModel().setSoTien(rs.getInt(3));
                list.add(temp);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
     public int getNumberOfMember(int idNhanKhau) {
         int count = 0;
         try {
             Connection connection = MysqlConnection.getMysqlConnection();
             String query = "SELECT COUNT(*) FROM thanh_vien_cua_ho tvch "
                     + "WHERE idHoKhau = (SELECT idHoKhau FROM thanh_vien_cua_ho tvch2 WHERE tvch2.idNhanKhau = " + idNhanKhau +")";
             PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            } 
         } catch (SQLException ex) {
             Logger.getLogger(ThuPhiService.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(ThuPhiService.class.getName()).log(Level.SEVERE, null, ex);
         }
         return count;
     }
     
     public List<KhoanThuBean> search(String keyword) {
             List<KhoanThuBean> list = new ArrayList<>();
             
             String query = "SELECT * FROM khoan_thu "
                     + "WHERE tenKhoanThu LIKE '%" + keyword + "%'";
        try {

            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                KhoanThuBean temp = new KhoanThuBean();
                KhoanThuModel khoanThuModel = temp.getKhoanThuModel();
                khoanThuModel.setId(rs.getInt(1));
                khoanThuModel.setTenKhoanThu(rs.getString(2));
                khoanThuModel.setSoTien(rs.getInt(3));
                khoanThuModel.setLoaiKhoanThu(rs.getInt(4)); 
                khoanThuModel.setNgayBatDau(rs.getDate("ngayBatDau"));
                khoanThuModel.setNgayKetThuc(rs.getDate("ngayKetThuc"));
                list.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThuPhiService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThuPhiService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
     }
     
     public boolean deleteKhoanThu(int id) {
         try {
             String query = "DELETE FROM nop_tien WHERE idKhoanThu = " + id;
             Connection conn = MysqlConnection.getMysqlConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ps.execute();
             
             query = "DELETE FROM khoan_thu WHERE id=" + id;
             ps = conn.prepareStatement(query);
             ps.execute();
             ps.close();
             conn.close();
             return true;
         } catch (SQLException ex) {
             Logger.getLogger(ThuPhiService.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(ThuPhiService.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;
     }
     
     public KhoanThuBean getKhoanThuById(int id) {
         KhoanThuBean temp = new KhoanThuBean();
         try {
             Connection connection = MysqlConnection.getMysqlConnection();
             String query = "SELECT * FROM khoan_thu WHERE id = " + id;
             PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
             ResultSet rs = preparedStatement.executeQuery();
             while(rs.next()) {
                 temp.getKhoanThuModel().setTenKhoanThu(rs.getString("tenKhoanThu"));
                 temp.getKhoanThuModel().setSoTien(rs.getInt("soTien"));
                 temp.getKhoanThuModel().setLoaiKhoanThu(rs.getInt("loaiKhoanThu"));
                 temp.getKhoanThuModel().setNgayBatDau(rs.getDate("ngayBatDau"));
                 temp.getKhoanThuModel().setNgayBatDau(rs.getDate("ngayKetThuc"));
             }
         } catch (SQLException ex) {
             Logger.getLogger(ThuPhiService.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(ThuPhiService.class.getName()).log(Level.SEVERE, null, ex);
         }
         return temp;
     }
     
     public boolean editKhoanThu(KhoanThuBean khoanThuBean) {
         try {
            Connection conn = MysqlConnection.getMysqlConnection();
            String query = "UPDATE khoan_thu "
                    + "SET tenKhoanThu = ?, soTien = ?, "
                    + "loaiKhoanThu = ?, ngayKetThuc = ? "
                    + "WHERE id = " + khoanThuBean.getKhoanThuModel().getId();

            PreparedStatement ps  = conn.prepareStatement(query);
            java.sql.Date ngaykt = new java.sql.Date(khoanThuBean.getKhoanThuModel().getNgayKetThuc().getTime());
            ps.setString(1, khoanThuBean.getKhoanThuModel().getTenKhoanThu());
            ps.setInt(2, khoanThuBean.getKhoanThuModel().getSoTien());
            ps.setInt(3, khoanThuBean.getKhoanThuModel().getLoaiKhoanThu());
            ps.setDate(4, ngaykt);
             System.out.println(ngaykt);

            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
         
         } catch (SQLException ex) {
             Logger.getLogger(ThuPhiService.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(ThuPhiService.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;
     }
      
}
