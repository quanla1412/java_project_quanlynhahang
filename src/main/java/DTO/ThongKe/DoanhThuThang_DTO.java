/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.ThongKe;

/**
 *
 * @author tuant
 */
public class DoanhThuThang_DTO {
    private String thang;
    private double tongTien;

    public DoanhThuThang_DTO(String thang, double tongTien) {
        this.thang = thang;
        this.tongTien = tongTien;
    }

    public DoanhThuThang_DTO() {
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
}
