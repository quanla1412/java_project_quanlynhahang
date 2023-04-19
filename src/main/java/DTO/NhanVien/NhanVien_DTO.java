/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.NhanVien;

import java.sql.Timestamp;
import jdk.jfr.Timespan;

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
    private Timestamp ngaySinh;
    private String email;
    private String DiaChi;
    private String GioiTinhNam;
    

    public NhanVien_DTO(String ma, String tinhTrangNhanVien, String tenChucVu, String hoTen, String sdt) {
        this.ma = ma;
        this.tinhTrangNhanVien = tinhTrangNhanVien;
        this.tenChucVu = tenChucVu;
        this.hoTen = hoTen;
        this.sdt = sdt;
    }

    public NhanVien_DTO(String ma, String tinhTrangNhanVien, String tenChucVu, String hoTen, String sdt, Timestamp ngaySinh, String email, String DiaChi, String GioiTinhNam) {
        this.ma = ma;
        this.tinhTrangNhanVien = tinhTrangNhanVien;
        this.tenChucVu = tenChucVu;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.DiaChi = DiaChi;
        this.GioiTinhNam = GioiTinhNam;
    }

    public Timestamp getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Timestamp ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getGioiTinhNam() {
        return GioiTinhNam;
    }

    public void setGioiTinhNam(String GioiTinhNam) {
        this.GioiTinhNam = GioiTinhNam;
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
