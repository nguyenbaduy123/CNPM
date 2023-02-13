package services;

import Bean.NhanKhauBean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.ChungMinhThuModel;
import models.GiaDinhModel;
import models.NhanKhauModel;
import models.TieuSuModel;

/**
 *
 * @author Hai
 */
public class NhanKhauService {
    
    /* 
     * Ham lay ra 1 nhan khau trong db bang chung minh thu
     * 
     */
    public NhanKhauBean getNhanKhau(String cmt) {
        NhanKhauBean nhanKhauBean = new NhanKhauBean();  
        // truy cap db
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM nhan_khau INNER JOIN chung_minh_thu ON nhan_khau.ID = chung_minh_thu.idNhanKhau WHERE soCMT = " + cmt;
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            int idNhanKhau = -1;
            while (rs.next()){
                NhanKhauModel nhanKhau = nhanKhauBean.getNhanKhauModel();
                ChungMinhThuModel chungMinhThuModel = nhanKhauBean.getChungMinhThuModel();
                idNhanKhau = rs.getInt("idNhanKhau");
                nhanKhau.setID(idNhanKhau);
                nhanKhau.setBietDanh(rs.getString("bietDanh"));
                nhanKhau.setHoTen(rs.getString("hoTen"));
                nhanKhau.setGioiTinh(rs.getString("gioiTinh"));
                nhanKhau.setNamSinh(rs.getDate("namSinh"));
                nhanKhau.setNguyenQuan(rs.getString("nguyenQuan"));
                nhanKhau.setTonGiao(rs.getString("tonGiao"));
                nhanKhau.setDanToc(rs.getString("danToc"));
                nhanKhau.setQuocTich(rs.getString("quocTich"));
                nhanKhau.setSoHoChieu(rs.getString("soHoChieu"));
                nhanKhau.setNoiThuongTru(rs.getString("noiThuongTru"));
                nhanKhau.setDiaChiHienNay(rs.getString("diaChiHienNay"));
                nhanKhau.setTrinhDoNgoaiNgu(rs.getString("trinhDoNgoaiNgu"));
                nhanKhau.setTrinhDoChuyenMon(rs.getString("trinhDoChuyenMon"));
                nhanKhau.setTrinhDoHocVan(rs.getString("trinhDoHocVan"));
                nhanKhau.setBietTiengDanToc(rs.getString("bietTiengDanToc"));
                nhanKhau.setNgheNghiep(rs.getString("ngheNghiep"));
                nhanKhau.setNoiLamViec(rs.getString("noiLamViec"));

                // con nhieu nua
                chungMinhThuModel.setIdNhanKhau(rs.getInt("idNhanKhau"));
                chungMinhThuModel.setSoCMT(rs.getString("soCMT"));
                chungMinhThuModel.setNgayCap(rs.getDate("ngayCap"));
                chungMinhThuModel.setNoiCap(rs.getString("noiCap"));
            }
            preparedStatement.close();
            if (idNhanKhau > 0) {
                query = "SELECT * FROM tieu_su WHERE idNhanKhau = " + idNhanKhau;
                preparedStatement = (PreparedStatement)connection.prepareStatement(query);
                rs = preparedStatement.executeQuery();
                List<TieuSuModel> listTieuSuModels = new ArrayList<>();
                while (rs.next()) {                    
                    TieuSuModel tieuSuModel = new TieuSuModel();
                    tieuSuModel.setID(rs.getInt("ID"));
                    tieuSuModel.setIdNhanKhau(rs.getInt("idNhanKhau"));
                    tieuSuModel.setTuNgay(rs.getDate("tuNgay"));
                    tieuSuModel.setDenNgay(rs.getDate("denNgay"));
                    tieuSuModel.setDiaChi(rs.getString("diaChi"));
                    tieuSuModel.setNgheNghiep(rs.getString("ngheNghiep"));
                    tieuSuModel.setNoiLamViec(rs.getString("noiLamViec"));
                    listTieuSuModels.add(tieuSuModel);
                }
                nhanKhauBean.setListTieuSuModels(listTieuSuModels);
                preparedStatement.close();
                
                query = "SELECT * FROM gia_dinh WHERE idNhanKhau = " + idNhanKhau;
                preparedStatement = (PreparedStatement)connection.prepareStatement(query);
                rs = preparedStatement.executeQuery();
                List<GiaDinhModel> listGiaDinhModels = new ArrayList<>();
                while (rs.next()) {
                    GiaDinhModel giaDinhModel = new GiaDinhModel();
                    giaDinhModel.setID(rs.getInt("ID"));
                    giaDinhModel.setHoTen(rs.getString("hoTen"));
                    giaDinhModel.setNamSinh(rs.getDate("namSinh"));
                    giaDinhModel.setGioiTinh(rs.getString("gioiTinh"));
                    giaDinhModel.setIdNhanKhau(rs.getInt("idNhanKhau"));
                    giaDinhModel.setDiaChiHienTai(rs.getString("diaChiHienTai"));
                    giaDinhModel.setNgheNghiep(rs.getString("ngheNghiep"));
                    giaDinhModel.setQuanHeVoiNhanKhau(rs.getString("quanHeVoiNhanKhau"));
                    listGiaDinhModels.add(giaDinhModel);
                }                    
                nhanKhauBean.setListGiaDinhModels(listGiaDinhModels);
                preparedStatement.close();
            }
            connection.close();
        } catch (Exception e) {
            this.exceptionHandle(e.getMessage());
        }
        return nhanKhauBean;
    }
    
     // lay danh sach 10 nhan khau moi duoc them vao
    public List<NhanKhauBean> getListNhanKhau() {
        List<NhanKhauBean> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM nhan_khau INNER JOIN chung_minh_thu ON nhan_khau.ID = chung_minh_thu.idNhanKhau ORDER BY ngayTao DESC LIMIT 0, 10";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                NhanKhauBean nhanKhauBean = new NhanKhauBean();
                NhanKhauModel nhanKhau = nhanKhauBean.getNhanKhauModel();
                nhanKhau.setID(rs.getInt("ID"));
                nhanKhau.setHoTen(rs.getString("hoTen"));
                nhanKhau.setGioiTinh(rs.getString("gioiTinh"));
                nhanKhau.setNamSinh(rs.getDate("namSinh"));
                nhanKhau.setDiaChiHienNay(rs.getString("diaChiHienNay"));
                ChungMinhThuModel chungMinhThuModel = nhanKhauBean.getChungMinhThuModel();
                chungMinhThuModel.setIdNhanKhau(rs.getInt("idNhanKhau"));
                chungMinhThuModel.setSoCMT(rs.getString("soCMT"));
                chungMinhThuModel.setNgayCap(rs.getDate("ngayCap"));
                chungMinhThuModel.setNoiCap(rs.getString("noiCap"));
                list.add(nhanKhauBean);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(list.size());
        return list;
    }
    
    public List<NhanKhauBean> statisticNhanKhau(int TuTuoi, int denTuoi, String gender, String Status, int tuNam, int denNam) {
        List<NhanKhauBean> list = new ArrayList<>();
        
        String query = "SELECT * FROM nhan_khau "
                    + " INNER JOIN chung_minh_thu ON nhan_khau.ID = chung_minh_thu.idNhanKhau"
                    + " LEFT JOIN tam_tru ON nhan_khau.ID = tam_tru.idNhanKhau "
                    + " LEFT JOIN tam_vang ON nhan_khau.ID = tam_vang.idNhanKhau "
                    + " WHERE ROUND(DATEDIFF(CURDATE(),namSinh)/365 , 0) >= "
                    + TuTuoi
                    + " AND ROUND(DATEDIFF(CURDATE(),namSinh)/365 , 0) <= "
                    + denTuoi;
        if (!gender.equalsIgnoreCase("Toan Bo")) {
            query += " AND nhan_khau.gioiTinh = '" + gender + "'";
        }
        if (Status.equalsIgnoreCase("Toan bo")) {
            query += " AND (tam_tru.denNgay >= CURDATE() OR tam_tru.denNgay IS NULL)"
                    + " AND (tam_vang.denNgay <= CURDATE() OR tam_vang.denNgay IS NULL)";
        } else if (Status.equalsIgnoreCase("Thuong tru")) {
            query += " AND tam_tru.denNgay IS NULL";
            
        } else if (Status.equalsIgnoreCase("Tam tru")) {
            query += " AND (YEAR(tam_tru.tuNgay) BETWEEN "
                    + tuNam
                    + " AND "
                    + denNam
                    + ")";
        } else if (Status.equalsIgnoreCase("Tam vang")) {
            query += " AND (YEAR(tam_vang.tuNgay) BETWEEN "
                    + tuNam
                    + " AND "
                    + denNam
                    + ")";
        }
        query += " ORDER BY ngayTao DESC";
         try {
            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            int idNhanKhau = -1;
            while (rs.next()){
                NhanKhauBean  nhanKhauBean = new NhanKhauBean();
                NhanKhauModel nhanKhau = nhanKhauBean.getNhanKhauModel();
                ChungMinhThuModel chungMinhThuModel = nhanKhauBean.getChungMinhThuModel();
                idNhanKhau = rs.getInt("idNhanKhau");
                nhanKhau.setID(idNhanKhau);
                nhanKhau.setBietDanh(rs.getString("bietDanh"));
                nhanKhau.setHoTen(rs.getString("hoTen"));
                nhanKhau.setGioiTinh(rs.getString("gioiTinh"));
                nhanKhau.setNamSinh(rs.getDate("namSinh"));
                nhanKhau.setNguyenQuan(rs.getString("nguyenQuan"));
                nhanKhau.setTonGiao(rs.getString("tonGiao"));
                nhanKhau.setDanToc(rs.getString("danToc"));
                nhanKhau.setQuocTich(rs.getString("quocTich"));
                nhanKhau.setSoHoChieu(rs.getString("soHoChieu"));
                nhanKhau.setNoiThuongTru(rs.getString("noiThuongTru"));
                nhanKhau.setDiaChiHienNay(rs.getString("diaChiHienNay"));
                // con nhieu nua
                chungMinhThuModel.setIdNhanKhau(rs.getInt("idNhanKhau"));
                chungMinhThuModel.setSoCMT(rs.getString("soCMT"));
                chungMinhThuModel.setNgayCap(rs.getDate("ngayCap"));
                chungMinhThuModel.setNoiCap(rs.getString("noiCap"));
                
                if (idNhanKhau > 0) {
                    String sql = "SELECT * FROM tieu_su WHERE idNhanKhau = " + idNhanKhau;
                    PreparedStatement prst = (PreparedStatement)connection.prepareStatement(sql);
                    ResultSet rs_temp = prst.executeQuery();
                    List<TieuSuModel> listTieuSuModels = new ArrayList<>();
                    while (rs_temp.next()) {                    
                        TieuSuModel tieuSuModel = new TieuSuModel();
                        tieuSuModel.setID(rs_temp.getInt("ID"));
                        tieuSuModel.setIdNhanKhau(rs_temp.getInt("idNhanKhau"));
                        tieuSuModel.setTuNgay(rs_temp.getDate("tuNgay"));
                        tieuSuModel.setDenNgay(rs_temp.getDate("denNgay"));
                        tieuSuModel.setDiaChi(rs_temp.getString("diaChi"));
                        tieuSuModel.setNgheNghiep(rs_temp.getString("ngheNghiep"));
                        tieuSuModel.setNoiLamViec(rs_temp.getString("noiLamViec"));
                        listTieuSuModels.add(tieuSuModel);
                    }
                    nhanKhauBean.setListTieuSuModels(listTieuSuModels);
                    prst.close();

                    sql = "SELECT * FROM gia_dinh WHERE idNhanKhau = " + idNhanKhau;
                    prst = (PreparedStatement)connection.prepareStatement(sql);
                    rs_temp = prst.executeQuery();
                    List<GiaDinhModel> listGiaDinhModels = new ArrayList<>();
                    while (rs_temp.next()) {
                        GiaDinhModel giaDinhModel = new GiaDinhModel();
                        giaDinhModel.setID(rs_temp.getInt("ID"));
                        giaDinhModel.setHoTen(rs_temp.getString("hoTen"));
                        giaDinhModel.setNamSinh(rs_temp.getDate("namSinh"));
                        giaDinhModel.setGioiTinh(rs_temp.getString("gioiTinh"));
                        giaDinhModel.setIdNhanKhau(rs_temp.getInt("idNhanKhau"));
                        giaDinhModel.setDiaChiHienTai(rs_temp.getString("diaChiHienTai"));
                        giaDinhModel.setNgheNghiep(rs_temp.getString("ngheNghiep"));
                        giaDinhModel.setQuanHeVoiNhanKhau(rs_temp.getString("quanHeVoiNhanKhau"));
                        listGiaDinhModels.add(giaDinhModel);
                    }                    
                    nhanKhauBean.setListGiaDinhModels(listGiaDinhModels);
                    prst.close();
                }
                list.add(nhanKhauBean);
            }
            preparedStatement.close();
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
        
        return list;
    }
    
    /*
     * ham tim kiem nhan khau theo ten
     */
    public List<NhanKhauBean> search(String keyword) {
        List<NhanKhauBean> list = new  ArrayList<>();
        String query;
        if (keyword.trim().isEmpty()) {
            return this.getListNhanKhau();
        }
        // truy cap db
        // create query
        try {
            long a = Long.parseLong(keyword);
            query = "SELECT * "
                    + "FROM nhan_khau "
                    + "INNER JOIN chung_minh_thu "
                    + "ON nhan_khau.ID = chung_minh_thu.idNhanKhau "
                    + "WHERE chung_minh_thu.soCMT LIKE '%"
                    + keyword
                    + "%'";
        } catch (Exception e) {
            query = "SELECT * "
                    + "FROM nhan_khau "
                    + "INNER JOIN chung_minh_thu "
                    + "ON nhan_khau.ID = chung_minh_thu.idNhanKhau "
                    + "WHERE MATCH(hoTen, bietDanh) AGAINST ('"
                    + keyword
                    + "' IN NATURAL LANGUAGE MODE);";
        }
        
        // execute query
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                NhanKhauBean temp = new NhanKhauBean();
                NhanKhauModel nhanKhau = temp.getNhanKhauModel();
                nhanKhau.setID(rs.getInt("ID"));
                nhanKhau.setHoTen(rs.getString("hoTen"));
                nhanKhau.setGioiTinh(rs.getString("gioiTinh"));
                nhanKhau.setNamSinh(rs.getDate("namSinh"));
                nhanKhau.setDiaChiHienNay(rs.getString("diaChiHienNay"));
                
                ChungMinhThuModel chungMinhThuModel = temp.getChungMinhThuModel();
                chungMinhThuModel.setIdNhanKhau(rs.getInt("idNhanKhau"));
                chungMinhThuModel.setSoCMT(rs.getString("soCMT"));
                chungMinhThuModel.setNgayCap(rs.getDate("ngayCap"));
                chungMinhThuModel.setNoiCap(rs.getString("noiCap"));
                list.add(temp);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception mysqlException) {
            this.exceptionHandle(mysqlException.getMessage());
        }
        return list;
    }
    
    public boolean delete(int id) {

        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            
             String query = "DELETE FROM chung_minh_thu WHERE idNhanKhau=" + id;
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             preparedStatement.executeUpdate();
             
             query = "DELETE FROM gia_dinh WHERE idNhanKhau=" + id;
             preparedStatement = connection.prepareStatement(query);
             preparedStatement.executeUpdate();
             
             query = "DELETE FROM tam_tru WHERE idNhanKhau=" + id;
             preparedStatement = connection.prepareStatement(query);
             preparedStatement.executeUpdate();
                      
             query = "DELETE FROM tam_vang WHERE idNhanKhau=" + id;
             preparedStatement = connection.prepareStatement(query);
             preparedStatement.executeUpdate();
             
             query = "DELETE FROM thanh_vien_cua_ho WHERE idNhanKhau=" + id;
             preparedStatement = connection.prepareStatement(query);
             preparedStatement.executeUpdate();
             
             query = "DELETE FROM tieu_su WHERE idNhanKhau=" + id;
             preparedStatement = connection.prepareStatement(query);
             preparedStatement.executeUpdate();
             
             query = "DELETE FROM nhan_khau WHERE id=" + id;
             preparedStatement = connection.prepareStatement(query);
             preparedStatement.executeUpdate();
             
            preparedStatement.close();
            connection.close();
            return true;
             
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NhanKhauService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public boolean editNhanKhau(NhanKhauBean nhanKhauBean) {
        try {
            NhanKhauModel nhanKhau = nhanKhauBean.getNhanKhauModel();
            ChungMinhThuModel chungMinhThu = nhanKhauBean.getChungMinhThuModel();
            Connection connection = MysqlConnection.getMysqlConnection();
            
            System.out.println(nhanKhauBean.getNhanKhauModel().getID());
            // 1 - 19
            String query = "UPDATE nhan_khau SET hoTen = ?, bietDanh = ?, namSinh = ?, gioiTinh = ?, noiSinh = ?, "
                    + "nguyenQuan = ?, danToc = ?, tonGiao = ?, quocTich = ?, soHoChieu = ?, noiThuongTru = ?, "
                    + "diaChiHienNay = ?, trinhDoHocVan = ?, TrinhDoChuyenMon = ?, bietTiengDanToc = ?, trinhDoNgoaiNgu = ?, "
                    + "ngheNghiep = ?, noiLamViec = ?, idNguoiTao = ?, ngayTao = ? "
                    + "WHERE id = " + nhanKhauBean.getNhanKhauModel().getID();
                    
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, nhanKhau.getHoTen());
            preparedStatement.setString(2, nhanKhau.getBietDanh());
            java.sql.Date namSinh = new java.sql.Date(nhanKhau.getNamSinh().getTime());
            preparedStatement.setDate(3, namSinh);
            preparedStatement.setString(4, nhanKhau.getGioiTinh());
            preparedStatement.setString(5, nhanKhau.getNoiSinh());
            preparedStatement.setString(6, nhanKhau.getNguyenQuan());
            preparedStatement.setString(7, nhanKhau.getDanToc());
            preparedStatement.setString(8, nhanKhau.getTonGiao());
            preparedStatement.setString(9, nhanKhau.getQuocTich());
            preparedStatement.setString(10, nhanKhau.getSoHoChieu());
            preparedStatement.setString(11, nhanKhau.getNoiThuongTru());
            preparedStatement.setString(12, nhanKhau.getDiaChiHienNay());
            preparedStatement.setString(13, nhanKhau.getTrinhDoHocVan());
            preparedStatement.setString(14, nhanKhau.getTrinhDoChuyenMon());
            preparedStatement.setString(15, nhanKhau.getBietTiengDanToc());
            preparedStatement.setString(16, nhanKhau.getTrinhDoNgoaiNgu());
            preparedStatement.setString(17, nhanKhau.getNgheNghiep());
            preparedStatement.setString(18, nhanKhau.getNoiLamViec());
            preparedStatement.setInt(19, nhanKhau.getIdNguoiTao());
            java.sql.Date createDate = new java.sql.Date(quanlynhankhau.QuanLyNhanKhau.calendar.getTime().getTime());
            preparedStatement.setDate(20, createDate);
            
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            
                String sql = "UPDATE chung_minh_thu SET soCMT = ? "
                        + "WHERE idNhanKhau = " + nhanKhauBean.getNhanKhauModel().getID();
                PreparedStatement prst = connection.prepareStatement(sql);
                prst.setString(1, chungMinhThu.getSoCMT());
                prst.execute();
                nhanKhauBean.getListTieuSuModels().forEach(tieuSu -> {
                    try {
                        String sql_tieu_su = "UPDATE tieu_su SET tuNgay = ?, "
                                + "denNgay = ?, diaChi = ?, ngheNghiep = ?, noiLamViec = ? "
                                + "WHERE idNhanKhau = " + nhanKhauBean.getNhanKhauModel().getID();
                                
                        PreparedStatement preStatement = connection.prepareStatement(sql_tieu_su);
       
                        Date tuNgay = new Date(tieuSu.getTuNgay().getTime());
                        preStatement.setDate(1, tuNgay);
                        preStatement.setDate(2, new Date(tieuSu.getDenNgay().getTime()));
                        preStatement.setString(3, tieuSu.getDiaChi());
                        preStatement.setString(4, tieuSu.getNgheNghiep());
                        preStatement.setString(5, tieuSu.getNoiLamViec());
                        preStatement.execute();
                        preStatement.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                });
                nhanKhauBean.getListGiaDinhModels().forEach(giaDinh -> {
                    try {
                        String sql_tieu_su = "INSERT INTO gia_dinh hoTen = ?, namSinh = ?, gioiTinh = ?,"
                                + " quanHeVoiNhanKhau = ?, ngheNghiep = ?, diaChiHienTai = ? "
                                + "WHERE idNhanKhau = " + nhanKhauBean.getNhanKhauModel().getID();
                        PreparedStatement preStatement = connection.prepareStatement(sql_tieu_su);
   
                        preStatement.setString(1, giaDinh.getHoTen());
                        preStatement.setDate(2, new Date(giaDinh.getNamSinh().getTime()));
                        preStatement.setString(3, giaDinh.getGioiTinh());
                        preStatement.setString(4, giaDinh.getQuanHeVoiNhanKhau());
                        preStatement.setString(5, giaDinh.getNgheNghiep());
                        preStatement.setString(6, giaDinh.getDiaChiHienTai());
                        preStatement.execute();
                        preStatement.close();
                    } catch (Exception e) {
                        System.out.println("controllers.NhanKhauManagerController.AddNewController.addNewPeople()");
                    }
                });
            
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NhanKhauService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NhanKhauService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    /*
     * Ham sử lý ngoại lệ : thông báo ra lỗi nhận được
     */
    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }
}
