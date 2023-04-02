package DTO.Ban;

/**
 *
 * @author LeAnhQuan
 */
public class UpdateDonGoi_DTO {
    private int idBan;
    private int idMA;
    private int idBTMA;
    private int soLuong;
    private String ghiChu;

    public UpdateDonGoi_DTO() {
    }

    public UpdateDonGoi_DTO(int idBan, int idMA, int idBTMA, int soLuong, String ghiChu) {
        this.idBan = idBan;
        this.idMA = idMA;
        this.idBTMA = idBTMA;
        this.soLuong = soLuong;
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

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
