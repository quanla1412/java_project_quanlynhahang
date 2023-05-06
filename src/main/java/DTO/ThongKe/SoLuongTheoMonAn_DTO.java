/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.ThongKe;

/**
 *
 * @author tuant
 */
public class SoLuongTheoMonAn_DTO {
    private String tenMonAn;
    private int soLuong;

    public SoLuongTheoMonAn_DTO() {
    }

    public SoLuongTheoMonAn_DTO(String tenMonAn, int soLuong) {
        this.tenMonAn = tenMonAn;
        this.soLuong = soLuong;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    
}
