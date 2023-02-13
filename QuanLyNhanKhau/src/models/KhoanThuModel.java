/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author Duy
 */
public class KhoanThuModel {
    private int id;
    private String tenKhoanThu;
    private int soTien;
    private int loaiKhoanThu;
    private Date ngayBatDau;
    private Date ngayKetThuc;

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    public void setTenKhoanThu(String tenKhoanThu) {
        this.tenKhoanThu = tenKhoanThu;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

    public void setLoaiKhoanThu(int loaiKhoanThu) {
        this.loaiKhoanThu = loaiKhoanThu;
    }

    public int getId() {
        return id;
    }

    public String getTenKhoanThu() {
        return tenKhoanThu;
    }

    public int getSoTien() {
        return soTien;
    }

    public int getLoaiKhoanThu() {
        return loaiKhoanThu;
    }
    
}
