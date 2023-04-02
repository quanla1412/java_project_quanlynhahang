package DTO.HoaDon;

/**
 *
 * @author LeAnhQuan
 */
public class UpdateChiTietHoaDon_DTO {
    private int idMA;
    private int idBTMA;
    private int soLuong;

    public UpdateChiTietHoaDon_DTO() {
    }

    public UpdateChiTietHoaDon_DTO(int idMA, int idBTMA, int soLuong) {
        this.idMA = idMA;
        this.idBTMA = idBTMA;
        this.soLuong = soLuong;
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
}
