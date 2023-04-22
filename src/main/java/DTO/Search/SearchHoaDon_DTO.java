/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.Search;

import java.sql.Timestamp;

public class SearchHoaDon_DTO{
    private String id;
    private Timestamp ngayBatDau;
    private Timestamp ngayCuoiCung;
    private int minPrice;
    private int maxPrice;
    private int idTTHD;
    
    public SearchHoaDon_DTO(String id, Timestamp ngayBatDau, Timestamp ngayCuoiCung, int minPrice, int maxPrice, int idTTHD){
        this.id = id;
        this.ngayBatDau = ngayBatDau;
        this.ngayCuoiCung = ngayCuoiCung;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.idTTHD = idTTHD;
    }
    
    public SearchHoaDon_DTO(){
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Timestamp ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }
    
    public Timestamp getNgayCuoiCung() {
        return ngayCuoiCung;
    }

    public void setNgayCuoiCung(Timestamp ngayCuoiCung) {
        this.ngayCuoiCung = ngayCuoiCung;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getIdTTHD() {
        return idTTHD;
    }

    public void setIdTTHD(int idTTHD) {
        this.idTTHD = idTTHD;
    }
}


