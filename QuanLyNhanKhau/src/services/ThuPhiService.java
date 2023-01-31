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
import models.KhoanThuModel;
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
        return true;
    }
}
