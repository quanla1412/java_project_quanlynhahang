package DTO.Ban;

import java.sql.Timestamp;

/**
 *
 * @author LeAnhQuan
 */
public class CreateDonGoi_DTO {
    private int idBan;
    private int idMA;
    private int idBTMA;
    private int soLuong;
    private Timestamp ngayGio;
    private String ghiChu;

    public CreateDonGoi_DTO() {
    }

    public CreateDonGoi_DTO(int idBan, int idMA, int idBTMA, int soLuong, Timestamp ngayGio, String ghiChu) {
        this.idBan = idBan;
        this.idMA = idMA;
        this.idBTMA = idBTMA;
        this.soLuong = soLuong;
        this.ngayGio = ngayGio;
        this.ghiChu = ghiChu;
    }

    public int getIdBan() {
        return idBan;
    }

    public void setIdBan(int idBan) {
        this.idBan = idBan;
    }

    public int getIdMA() {
        return idMA;
    }

    public void setIdMA(int idMA) {
        this.idMA = idMA;
    }

    public int getIdBTMA() {
        return idBTMA;
    }

    public void setIdBTMA(int idBTMA) {
        this.idBTMA = idBTMA;
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
