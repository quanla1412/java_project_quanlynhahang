package DTO.HoaDon;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author LeAnhQuan
 */
public class HoaDonFull_DTO {
    private int id;
    private String maNhanVien;
    private int idKhachHang;
    private Timestamp ngayGio;
    private ArrayList<ChiTietHoaDon_DTO> listMonAn;

    public HoaDonFull_DTO() {
    }

    public HoaDonFull_DTO(int id, String maNhanVien, int idKhachHang, Timestamp ngayGio, ArrayList<ChiTietHoaDon_DTO> listMonAn) {
        this.id = id;
        this.maNhanVien = maNhanVien;
        this.idKhachHang = idKhachHang;
        this.ngayGio = ngayGio;
        this.listMonAn = listMonAn;
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

    public ArrayList<ChiTietHoaDon_DTO> getListMonAn() {
        return listMonAn;
    }

    public void setListMonAn(ArrayList<ChiTietHoaDon_DTO> listMonAn) {
        this.listMonAn = listMonAn;
    }
}
