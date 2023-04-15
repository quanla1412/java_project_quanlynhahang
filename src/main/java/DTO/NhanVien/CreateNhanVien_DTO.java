/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.NhanVien;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author dinhn
 */
public class CreateNhanVien_DTO {
    private String ma;
    private int idTinhTrangNhanVien;
    private int idChucVu;
    private String hoTen;
    private Date ngaySinh;
    private boolean gioiTinhNam;
    private String email;
    private String soDienThoai ;
    private String diaChi ;

    
    public CreateNhanVien_DTO(String ma, int idTinhTrangNhanVien, int idChucVu, String hoTen, Date ngaySinh, boolean gioiTinhNam, String email, String soDienThoai, String diaChi) {
        this.ma = ma;
        this.idTinhTrangNhanVien = idTinhTrangNhanVien;
        this.idChucVu = idChucVu;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinhNam = gioiTinhNam;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public int getIdTinhTrangNhanVien() {
        return idTinhTrangNhanVien;
    }

    public void setIdTinhTrangNhanVien(int idTinhTrangNhanVien) {
        this.idTinhTrangNhanVien = idTinhTrangNhanVien;
    }

    public int getIdChucVu() {
        return idChucVu;
    }

    public void setIdChucVu(int idChucVu) {
        this.idChucVu = idChucVu;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    
    

    public boolean isGioiTinhNam() {
        return gioiTinhNam;
    }

    public void setGioiTinhNam(boolean gioiTinhNam) {
        this.gioiTinhNam = gioiTinhNam;
    }
    
     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    
    
}
