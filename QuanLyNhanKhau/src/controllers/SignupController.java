/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import models.UserMoldel;
import services.MysqlConnection;


public class SignupController {
     public static UserMoldel currentUser = new UserMoldel();
    
    public boolean signup(String userName, String password, String rePassword) throws SQLException, ClassNotFoundException{
        if(!password.equals(rePassword)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu xác nhận không trùng khớp", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        Connection connection = MysqlConnection.getMysqlConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM users WHERE userName = '" + userName +"'");
        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Tên tài khoản đã tồn tại", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else {
            currentUser.setUserName(userName);
            currentUser.setPasswd(password);
            st.execute("INSERT INTO users(userName, passwd) VALUES('" + currentUser.getUserName() + "', '" + currentUser.getPasswd() +"')");
            connection.close();
            JOptionPane.showMessageDialog(null, "Chúc mừng bạn đã đăng ký tài khoản thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
//    return true;
    }
}
