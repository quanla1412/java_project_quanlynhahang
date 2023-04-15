/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.NhanVien;

/**
 *
 * @author dinhn
 */
public class NhanVien_DTO {
    private String ma;
    private String tinhTrangNhanVien;
    private String tenChucVu;
    private String hoTen;
    private String sdt;

    public NhanVien_DTO(String ma, String tinhTrangNhanVien, String tenChucVu, String hoTen, String sdt) {
        this.ma = ma;
        this.tinhTrangNhanVien = tinhTrangNhanVien;
        this.tenChucVu = tenChucVu;
        this.hoTen = hoTen;
        this.sdt = sdt;
    }

    public NhanVien_DTO() {
        
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTinhTrangNhanVien() {
        return tinhTrangNhanVien;
    }

    public void setTinhTrangNhanVien(String tinhTrangNhanVien) {
        this.tinhTrangNhanVien = tinhTrangNhanVien;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
    
    
}
