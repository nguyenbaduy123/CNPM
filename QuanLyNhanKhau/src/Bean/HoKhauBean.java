package Bean;

import java.util.ArrayList;
import java.util.List;
import models.HoKhauModel;
import models.KhoanThuModel;
import models.NhanKhauModel;
import models.NopTienModel;
import models.ThanhVienCuaHoModel;

/**
 * ket noi tu nhien gia ho_khau va nhan_khau
 */

public class HoKhauBean {
    private HoKhauModel hoKhauModel;
    private NhanKhauModel chuHo;
    private NopTienModel nopTienModel;
    private List<NhanKhauModel> listNhanKhauModels;
    private List<ThanhVienCuaHoModel> listThanhVienCuaHo;

    public HoKhauBean(HoKhauModel hoKhauModel, NhanKhauModel chuHo, List<NhanKhauModel> listNhanKhauModels, List<ThanhVienCuaHoModel> listThanhVienCuaHo) {
        this.hoKhauModel = hoKhauModel;
        this.chuHo = chuHo;
        this.listNhanKhauModels = listNhanKhauModels;
        this.listThanhVienCuaHo = listThanhVienCuaHo;
    }

    
    public HoKhauBean() {
        this.hoKhauModel = new HoKhauModel();
        this.chuHo = new NhanKhauModel();
        this.listNhanKhauModels = new ArrayList<>();
        this.listThanhVienCuaHo = new ArrayList<>();
        this.nopTienModel = new NopTienModel();
    }

    
    public HoKhauModel getHoKhauModel() {
        return hoKhauModel;
    }

    public NopTienModel getNopTienModel() {
        return nopTienModel;
    }

    public void setNopTienModel(NopTienModel nopTienModel) {
        this.nopTienModel = nopTienModel;
    }

    
    public void setHoKhauModel(HoKhauModel hoKhauModel) {
        this.hoKhauModel = hoKhauModel;
    }

    public NhanKhauModel getChuHo() {
        return chuHo;
    }

    public void setChuHo(NhanKhauModel chuHo) {
        this.chuHo = chuHo;
    }

    public List<NhanKhauModel> getListNhanKhauModels() {
        return listNhanKhauModels;
    }

    public void setListNhanKhauModels(List<NhanKhauModel> listNhanKhauModels) {
        this.listNhanKhauModels = listNhanKhauModels;
    }

    public List<ThanhVienCuaHoModel> getListThanhVienCuaHo() {
        return listThanhVienCuaHo;
    }

    public void setListThanhVienCuaHo(List<ThanhVienCuaHoModel> listThanhVienCuaHo) {
        this.listThanhVienCuaHo = listThanhVienCuaHo;
    }

    @Override
    public String toString() {
        String res = "<html> <style>p {padding: 5px; margin-left: 20px} table, th, td {border: 1px solid black; border-collapse: collapse;} table {width: 500px}</style> <div>"
                + "<h3>Th??ng tin c?? b???n"
                + "<p>M?? h??? kh???u: <b>" + hoKhauModel.getMaHoKhau() + "</p>"
                + "<p>H??? t??n ch??? h???: <b>" + chuHo.getHoTen() + "</p>"
                + "<p>?????a ch???: <b>" + hoKhauModel.getDiaChi() + "</p>"
                + "<p>Ng??y l???p: <b>" + hoKhauModel.getNgayLap().toString() + "</p>"
                + "<h4>Danh s??ch th??nh vi??n<table>"
                + "<tr>"
                + "<th>H??? t??n</th>"
                + "<th>Ng??y sinh</th>"
                + "<th>Gi???i t??nh</th>"
                + "<th>Quan h??? v???i ch??? h???</th>"
                + "</tr>";
        for (int i = 0; i < listNhanKhauModels.size(); i++) {
            res += "<tr>"
                    + "<td>"
                    + listNhanKhauModels.get(i).getHoTen()
                    + "</td>"
                    + "<td>"
                    + listNhanKhauModels.get(i).getNamSinh().toString()
                    + "</td>"
                    + "<td>"
                    + listNhanKhauModels.get(i).getGioiTinh()
                    + "</td>"
                    + "<td>"
                    + listThanhVienCuaHo.get(i).getQuanHeVoiChuHo()
                    + "</td>"
                    + "</tr>";
        }
        res += "</table></div></html>";
        return res;
    }

}
