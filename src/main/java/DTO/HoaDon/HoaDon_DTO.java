package DTO.HoaDon;

import java.sql.Timestamp;

/**
 *
 * @author LeAnhQuan
 */
public class HoaDon_DTO {
    private int id;
    private String maNhanVien;
    private int idKhachHang;
    private Timestamp ngayGio;
    private int tongGia;

    public HoaDon_DTO() {
    }

    public HoaDon_DTO(int id, String maNhanVien, int idKhachHang, Timestamp ngayGio, int tongGia) {
        this.id = id;
        this.maNhanVien = maNhanVien;
        this.idKhachHang = idKhachHang;
        this.ngayGio = ngayGio;
        this.tongGia = tongGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public Timestamp getNgayGio() {
        return ngayGio;
    }

    public void setNgayGio(Timestamp ngayGio) {
        this.ngayGio = ngayGio;
    }
    
    public int getTongGia() {
        return tongGia;
    }

    public void setTongGia(int tongGia) {
        this.tongGia = tongGia;
    }
}
