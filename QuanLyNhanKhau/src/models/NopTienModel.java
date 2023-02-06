/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Duy
 */
public class NopTienModel {
    private int idNguoiNop;
    private int idKhoanThu;
    private String ngayThu;
    private int soTien;

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

    public int getSoTien() {
        return soTien;
    }

    public NopTienModel() {
    }

    public int getIdNguoiNop() {
        return idNguoiNop;
    }

    public int getIdKhoanThu() {
        return idKhoanThu;
    }

    public String getNgayThu() {
        return ngayThu;
    }

    public void setIdNguoiNop(int idNguoiNop) {
        this.idNguoiNop = idNguoiNop;
    }

    public void setIdKhoanThu(int idKhoanThu) {
        this.idKhoanThu = idKhoanThu;
    }

    public void setNgayThu(String ngayThu) {
        this.ngayThu = ngayThu;
    }
    
}
