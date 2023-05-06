/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.ThongKe;

import java.sql.Timestamp;

/**
 *
 * @author tuant
 */
public class DoanhThuNgay_DTO {
    private Timestamp date;
    private double tongTien;

    public DoanhThuNgay_DTO() {
    }

    public DoanhThuNgay_DTO(Timestamp date, double tongTien) {
        this.date = date;
        this.tongTien = tongTien;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    
    
}
