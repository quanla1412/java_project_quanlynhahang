package DTO.HoaDon;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author LeAnhQuan
 */
public class UpdateHoaDon_DTO {
    private int id;
    private String maNhanVien;
    private int idKhachHang;
    private int tongGia;
    private ArrayList<UpdateChiTietHoaDon_DTO> listMonAn;

    public UpdateHoaDon_DTO() {
    }

    public UpdateHoaDon_DTO(int id, String maNhanVien, int idKhachHang, int tongGia, ArrayList<UpdateChiTietHoaDon_DTO> listMonAn) {
        this.id = id;
        this.maNhanVien = maNhanVien;
        this.idKhachHang = idKhachHang;
        this.tongGia = tongGia;
        this.listMonAn = listMonAn;
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

    public int getTongGia() {
        return tongGia;
    }

    public void setTongGia(int tongGia) {
        this.tongGia = tongGia;
    }

    public ArrayList<UpdateChiTietHoaDon_DTO> getListMonAn() {
        return listMonAn;
    }

    public void setListMonAn(ArrayList<UpdateChiTietHoaDon_DTO> listMonAn) {
        this.listMonAn = listMonAn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
