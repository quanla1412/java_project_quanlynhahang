/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.ThongKe;

/**
 *
 * @author tuant
 */
public class DoanhThuTheoLoaiMonAn_DTO {
    private String tenLMA;
    private double tongTien;

    public DoanhThuTheoLoaiMonAn_DTO() {
    }

    public DoanhThuTheoLoaiMonAn_DTO(String tenLMA, double tongTien) {
        this.tenLMA = tenLMA;
        this.tongTien = tongTien;
    }

    public String getTenLMA() {
        return tenLMA;
    }

    public void setTenLMA(String tenLMA) {
        this.tenLMA = tenLMA;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
}
