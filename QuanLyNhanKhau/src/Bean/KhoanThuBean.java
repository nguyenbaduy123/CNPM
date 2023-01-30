/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bean;
import java.util.ArrayList;
import java.util.List;
import models.KhoanThuModel;
/**
 *
 * @author Duy
 */
public class KhoanThuBean {
    private KhoanThuModel khoanThuModel;
//    private List<KhoanThuModel> listKhoanThu;

    public KhoanThuBean(KhoanThuModel khoanThuModel) {
        this.khoanThuModel = khoanThuModel;
//        this.listKhoanThu = listKhoanThu;
    }

    public KhoanThuModel getKhoanThuModel() {
        return khoanThuModel;
    }



    public void setKhoanThuModel(KhoanThuModel khoanThuModel) {
        this.khoanThuModel = khoanThuModel;
    }

    public KhoanThuBean() {
        this.khoanThuModel = new KhoanThuModel();
    }
    
    
}
