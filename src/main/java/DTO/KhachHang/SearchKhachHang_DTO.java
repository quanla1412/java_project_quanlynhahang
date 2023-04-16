/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.KhachHang;

/**
 *
 * @author tuant
 */
public class SearchKhachHang_DTO {
    private String idOrName;
    private int loaiKhachHang;
    private int gioiTinh;

    public SearchKhachHang_DTO() {
    }

    public SearchKhachHang_DTO(String idOrName, int loaiKhachHang, int gioiTinh) {
        this.idOrName = idOrName;
        this.loaiKhachHang = loaiKhachHang;
        this.gioiTinh = gioiTinh;
    }

    public int isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    

    public String getIdOrName() {
        return idOrName;
    }

    public void setIdOrName(String idOrName) {
        this.idOrName = idOrName;
    }

    public int getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(int loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }
    
}
