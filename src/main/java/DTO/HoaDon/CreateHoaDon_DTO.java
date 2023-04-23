package DTO.HoaDon;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author LeAnhQuan
 */
public class CreateHoaDon_DTO {
    private String maNhanVien;
    private int idKhachHang;
    private Timestamp ngayGio;
    private int tongGia;
    private float uuDai;
    private ArrayList<CreateChiTietHoaDon_DTO> listMonAn;

    public CreateHoaDon_DTO() {
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

    public ArrayList<CreateChiTietHoaDon_DTO> getListMonAn() {
        return listMonAn;
    }

    public void setListMonAn(ArrayList<CreateChiTietHoaDon_DTO> listMonAn) {
        this.listMonAn = listMonAn;
    }

    public float getUuDai() {
        return uuDai;
    }

    public void setUuDai(float uuDai) {
        this.uuDai = uuDai;
    }
}
