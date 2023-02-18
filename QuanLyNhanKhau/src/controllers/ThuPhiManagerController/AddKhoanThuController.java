/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.ThuPhiManagerController;
import java.sql.SQLException;
import Bean.KhoanThuBean;
import controllers.ThuPhiPanelController;
import services.ThuPhiService;

public class AddKhoanThuController {
    private ThuPhiPanelController controller = new ThuPhiPanelController();
    private KhoanThuBean khoanThuBean;
    private ThuPhiService thuPhiService = new ThuPhiService();
    
    public void addNew(KhoanThuBean hoKhauBean) throws ClassNotFoundException, SQLException{
        this.thuPhiService.addNew(hoKhauBean);
//        this.controller = new ThuPhiPanelController();
    }
}
