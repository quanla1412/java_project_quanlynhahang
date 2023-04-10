/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.KhachHang;

import java.sql.Timestamp;

/**
 *
 * @author tuant
 */
public class CreateKhachHang_DTO {
    private int id;
    private int loaiKhachHang;
    private String ten;
    private String sdt;
    private String diemTichLuy;
    private String email;
    private Timestamp ngaySinh;

    public CreateKhachHang_DTO() {
    }

    public CreateKhachHang_DTO(int id, int loaiKhachHang, String ten, String sdt, String diemTichLuy, String email, Timestamp ngaySinh) {
        this.id = id;
        this.loaiKhachHang = loaiKhachHang;
        this.ten = ten;
        this.sdt = sdt;
        this.diemTichLuy = diemTichLuy;
        this.email = email;
        this.ngaySinh = ngaySinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(int loaiKhachHang) {
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

    public String getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(String diemTichLuy) {
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
