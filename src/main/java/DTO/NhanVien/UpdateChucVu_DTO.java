/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.NhanVien;

/**
 *
 * @author dinhn
 */
public class UpdateChucVu_DTO {
    private int id;
    private String ten;

    public UpdateChucVu_DTO(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }
    
    public UpdateChucVu_DTO()
    {
        
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

    
}
