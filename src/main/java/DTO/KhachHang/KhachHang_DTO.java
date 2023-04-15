/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.KhachHang;

/**
 *
 * @author tuant
 */
public class KhachHang_DTO {
    private int id;
    private String ten;
    private String sdt;
    private int diemTichLuy;
    private LoaiKhachHang_DTO loaiKhachHang;

    public KhachHang_DTO() {
    }

    public KhachHang_DTO(int id, String ten, String sdt, int diemTichLuy, LoaiKhachHang_DTO loaiKhachHang) {
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
        this.diemTichLuy = diemTichLuy;
        this.loaiKhachHang = loaiKhachHang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LoaiKhachHang_DTO getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(LoaiKhachHang_DTO loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }
    
}
