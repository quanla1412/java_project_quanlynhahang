package DTO.Ban;

import DTO.MonAn.BienTheMonAn_DTO;
import java.sql.Timestamp;

/**
 *
 * @author LeAnhQuan
 */
public class DonGoi_DTO {
    private BienTheMonAn_DTO btma;
    private int soLuong;
    private Timestamp ngayGio;
    private String ghiChu;

    public DonGoi_DTO() {
    }

    public DonGoi_DTO(BienTheMonAn_DTO btma, int soLuong, Timestamp ngayGio, String ghiChu) {
        this.btma = btma;
        this.soLuong = soLuong;
        this.ngayGio = ngayGio;
        this.ghiChu = ghiChu;
    }

    public BienTheMonAn_DTO getBtma() {
        return btma;
    }

    public void setBtma(BienTheMonAn_DTO btma) {
        this.btma = btma;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Timestamp getNgayGio() {
        return ngayGio;
    }

    public void setNgayGio(Timestamp ngayGio) {
        this.ngayGio = ngayGio;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
