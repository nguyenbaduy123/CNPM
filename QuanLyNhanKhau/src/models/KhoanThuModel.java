/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Duy
 */
public class KhoanThuModel {
    private int id;
    private String tenKhoanThu;
    private int soTien;
    private int loaiKhoanThu;

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
