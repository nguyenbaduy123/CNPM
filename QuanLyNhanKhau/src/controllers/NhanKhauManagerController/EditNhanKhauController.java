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
 * @author Vinh
 */

public class EditNhanKhauController {
    
    private NhanKhauService service = new NhanKhauService();
    
    public EditNhanKhauController() {
        this.service = new NhanKhauService();
    }
    
    public boolean editNhanKhau(NhanKhauBean nhanKhauBean) {
        if(service.editNhanKhau(nhanKhauBean)) {
            return true; 
        }
        return false;
    }
}
