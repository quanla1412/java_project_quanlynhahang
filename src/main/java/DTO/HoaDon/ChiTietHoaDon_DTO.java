package DTO.HoaDon;

import DTO.MonAn.BienTheMonAn_DTO;

/**
 *
 * @author LeAnhQuan
 */
public class ChiTietHoaDon_DTO {
    private BienTheMonAn_DTO bienTheMonAn;
    private int soLuong;

    public ChiTietHoaDon_DTO() {
    }

    public ChiTietHoaDon_DTO(BienTheMonAn_DTO bienTheMonAn, int soLuong) {
        this.bienTheMonAn = bienTheMonAn;
        this.soLuong = soLuong;
    }

    public BienTheMonAn_DTO getBienTheMonAn() {
        return bienTheMonAn;
    }

    public void setBienTheMonAn(BienTheMonAn_DTO bienTheMonAn) {
        this.bienTheMonAn = bienTheMonAn;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
