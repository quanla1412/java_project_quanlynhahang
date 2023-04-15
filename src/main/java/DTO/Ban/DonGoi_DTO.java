package DTO.Ban;

import DTO.MonAn.MonAn_DTO;

/**
 *
 * @author LeAnhQuan
 */
public class DonGoi_DTO {
    private int idBan;
    private MonAn_DTO monAn;
    private int soLuong;
    private String ghiChu;

    public DonGoi_DTO() {
    }

    public DonGoi_DTO(int idBan, MonAn_DTO monAn, int soLuong, String ghiChu) {
        this.idBan = idBan;
        this.monAn = monAn;
        this.soLuong = soLuong;
        this.ghiChu = ghiChu;
    }

    public MonAn_DTO getMonAn() {
        return monAn;
    }

    public int getIdBan() {
        return idBan;
    }

    public void setIdBan(int idBan) {
        this.idBan = idBan;
    }

    public void setMonAn(MonAn_DTO monAn) {
        this.monAn = monAn;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
