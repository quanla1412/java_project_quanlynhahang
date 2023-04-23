/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.KhachHang;

/**
 *
 * @author tuant
 */
public class LoaiKhachHang_DTO {
    private int id;
    private String ten;
    private int diemToiThieu;
    private float mucUuDai;

    public LoaiKhachHang_DTO() {
    }

    public LoaiKhachHang_DTO(int id, String ten, int diemToiThieu, float mucUuDai) {
        this.id = id;
        this.ten = ten;
        this.diemToiThieu = diemToiThieu;
        this.mucUuDai = mucUuDai;
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

    public int getDiemToiThieu() {
        return diemToiThieu;
    }

    public void setDiemToiThieu(int diemToiThieu) {
        this.diemToiThieu = diemToiThieu;
    }

    public float getMucUuDai() {
        return mucUuDai;
    }

    public void setMucUuDai(float mucUuDai) {
        this.mucUuDai = mucUuDai;
    }
    
}
