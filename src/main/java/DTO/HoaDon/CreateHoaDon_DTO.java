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
    private ArrayList<CreateChiTietHoaDon_DTO> listMonAn;

    public CreateHoaDon_DTO() {
    }

    public CreateHoaDon_DTO(String maNhanVien, int idKhachHang, Timestamp ngayGio, int tongGia, ArrayList<CreateChiTietHoaDon_DTO> listMonAn) {
        this.maNhanVien = maNhanVien;
        this.idKhachHang = idKhachHang;
        this.ngayGio = ngayGio;
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
    
    
}
