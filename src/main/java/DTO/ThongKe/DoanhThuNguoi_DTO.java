/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.ThongKe;

/**
 *
 * @author tuant
 */
public class DoanhThuNguoi_DTO {
    private String hoTen;
    private double tongTien;

    public DoanhThuNguoi_DTO() {
    }

    public DoanhThuNguoi_DTO(String hoTen, double tongTien) {
        this.hoTen = hoTen;
        this.tongTien = tongTien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    
    
}
