/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.ThuPhiManagerController;
import java.sql.SQLException;
import Bean.KhoanThuBean;
import services.ThuPhiService;
/**
 *
 * @author Duy
 */
public class AddKhoanThuController {
    private KhoanThuBean khoanThuBean;
    private ThuPhiService thuPhiService = new ThuPhiService();
    
    public void addNew(KhoanThuBean hoKhauBean) throws ClassNotFoundException, SQLException{
        this.thuPhiService.addNew(hoKhauBean);
    }
}
