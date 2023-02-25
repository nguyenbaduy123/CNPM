/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.ThuPhiManagerController;

import Bean.KhoanThuBean;
import javax.swing.JOptionPane;
import services.ThuPhiService;

/**
 *
 * @author Duy
 */

public class EditKhoanThuController {
    
    private ThuPhiService service = new ThuPhiService();
    
    public void editKhoanThu(KhoanThuBean khoanThuBean) {
        if(service.editKhoanThu(khoanThuBean)) {
            JOptionPane.showMessageDialog(null, "Đã sửa khoản thu thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
