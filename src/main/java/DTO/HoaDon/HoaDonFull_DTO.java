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
    private boolean tinhTrangHoaDon;
    private ArrayList<ChiTietHoaDon_DTO> listMonAn;
    private int tongGia;
    private float uuDai;
    
    public HoaDonFull_DTO() {
    }

    public HoaDonFull_DTO(int id, String maNhanVien, int idKhachHang, Timestamp ngayGio, boolean tinhTrangHoaDon, ArrayList<ChiTietHoaDon_DTO> listMonAn, int tongGia, float uuDai) {
        this.id = id;
        this.maNhanVien = maNhanVien;
        this.idKhachHang = idKhachHang;
        this.ngayGio = ngayGio;
        this.tinhTrangHoaDon = tinhTrangHoaDon;
        this.listMonAn = listMonAn;
        this.tongGia = tongGia;
        this.uuDai = uuDai;
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
    
    public boolean getTinhTrangHoaDon(){
        return tinhTrangHoaDon;
    }
    
    public void setTinhTrangHoaDon(boolean tinhTrangHoaDon){
        this.tinhTrangHoaDon = tinhTrangHoaDon;
    }
    
    public ArrayList<ChiTietHoaDon_DTO> getListMonAn() {
        return listMonAn;
    }

    public void setListMonAn(ArrayList<ChiTietHoaDon_DTO> listMonAn) {
        this.listMonAn = listMonAn;
    }
    
    public int getTongGia() {
        return tongGia;
    }

    public void setTongGia(int tongGia) {
        this.tongGia = tongGia;
    }

    public float getUuDai() {
        return uuDai;
    }

    public void setUuDai(float uuDai) {
        this.uuDai = uuDai;
    }
    
}
