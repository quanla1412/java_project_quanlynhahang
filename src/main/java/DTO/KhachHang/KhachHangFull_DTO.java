/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.KhachHang;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author tuant
 */
public class KhachHangFull_DTO {
    private int id;
    private LoaiKhachHang_DTO loaiKhachHang;
    private String ten;
    private String sdt;
    private int diemTichLuy;
    private String email;
    private Timestamp ngaySinh;
    private boolean gioiTinhNam;

    public KhachHangFull_DTO() {
    }

    public KhachHangFull_DTO(int id, LoaiKhachHang_DTO loaiKhachHang, String ten, String sdt, int diemTichLuy, String email, Timestamp ngaySinh, boolean gioiTinh) {
        this.id = id;
        this.loaiKhachHang = loaiKhachHang;
        this.ten = ten;
        this.sdt = sdt;
        this.diemTichLuy = diemTichLuy;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.gioiTinhNam = gioiTinh;
    }

    public boolean isGioiTinhNam() {
        return gioiTinhNam;
    }

    public void setGioiTinhNam(boolean gioiTinh) {
        this.gioiTinhNam = gioiTinh;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LoaiKhachHang_DTO getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(LoaiKhachHang_DTO loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(int diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Timestamp ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    
}
