/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.NhanVien;

import java.util.Date;

/**
 *
 * @author dinhn
 */
public record NhanVien_DTO (
        String ma, 
        String tinhTrangNhanVien, 
        String tenChucVu, 
        String hoTen, 
        String sdt,
        Date ngaySinh,
        String email,
        String diaChi,
        String gioiTinh,
        String CCCD
){}
