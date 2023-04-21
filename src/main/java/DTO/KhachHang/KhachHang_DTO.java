/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.KhachHang;

import java.util.Date;

/**
 *
 * @author tuant
 */
public record KhachHang_DTO(
    int id,
    String ten,
    String sdt,
    int diemTichLuy,
    String loaiKhachHang,
    String email,
    Date ngaySinh,
    String gioiTinh
    ){}
