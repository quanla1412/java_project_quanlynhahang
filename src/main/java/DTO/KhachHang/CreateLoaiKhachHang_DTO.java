/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.KhachHang;

/**
 *
 * @author tuant
 */
public class CreateLoaiKhachHang_DTO {
    private String ten;
    private int diemToiThieu;
    private Double mucUuDai;

    public CreateLoaiKhachHang_DTO() {
    }

    public CreateLoaiKhachHang_DTO( String ten, int diemToiThieu, Double mucUuDai) {
        this.ten = ten;
        this.diemToiThieu = diemToiThieu;
        this.mucUuDai = mucUuDai;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getDiemToiThieu() {
        return diemToiThieu;
    }

    public void setDiemToiThieu(int diemToiThieu) {
        this.diemToiThieu = diemToiThieu;
    }

    public Double getMucUuDai() {
        return mucUuDai;
    }

    public void setMucUuDai(Double mucUuDai) {
        this.mucUuDai = mucUuDai;
    }
    
}
