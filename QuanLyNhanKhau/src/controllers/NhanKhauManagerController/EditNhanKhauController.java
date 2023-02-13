/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.NhanKhauManagerController;

import Bean.NhanKhauBean;
import javax.swing.JOptionPane;
import services.NhanKhauService;

/**
 *
 * @author Duy
 */
public class EditNhanKhauController {
    
    private NhanKhauService service = new NhanKhauService();
    
    public EditNhanKhauController() {
        this.service = new NhanKhauService();
    }
    
    public boolean editNhanKhau(NhanKhauBean nhanKhauBean) {
        if(service.editNhanKhau(nhanKhauBean)) {
            JOptionPane.showMessageDialog(null, "Đã sửa thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        }
        return false;
    }
}
