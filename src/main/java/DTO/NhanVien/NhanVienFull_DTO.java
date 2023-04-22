/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.NhanVien;

import java.util.Date;

/**
 *
 * @author dinhn
 */
public class NhanVienFull_DTO {
    private String ma;
    private TinhTrangNhanVien_DTO tinhTrangNhanVien;
    private ChucVu_DTO chucVu;
    private String hoTen;
    private Date ngaySinh;
    private boolean gioiTinhNam;
    private String email;
    private String soDienThoai;
    private String diaChi;
    private String CCCD;

    public NhanVienFull_DTO(String ma, TinhTrangNhanVien_DTO tinhTrangNhanVien, ChucVu_DTO chucVu, String hoTen, Date ngaySinh, boolean gioiTinhNam, String email, String soDienThoai, String diaChi, String CCCD) {
        this.ma = ma;
        this.tinhTrangNhanVien = tinhTrangNhanVien;
        this.chucVu = chucVu;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinhNam = gioiTinhNam;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.CCCD = CCCD;
    }

    public NhanVienFull_DTO() {
     
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public TinhTrangNhanVien_DTO getTinhTrangNhanVien() {
        return tinhTrangNhanVien;
    }

    public void setTinhTrangNhanVien(TinhTrangNhanVien_DTO tinhTrangNhanVien) {
        this.tinhTrangNhanVien = tinhTrangNhanVien;
    }

    public ChucVu_DTO getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVu_DTO chucVu) {
        this.chucVu = chucVu;
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

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }
}
