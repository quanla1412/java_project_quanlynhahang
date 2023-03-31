package DTO.MonAn;

/**
 *
 * @author LeAnhQuan
 */
public class BienTheMonAn_DTO {
    private TinhTrangBTMA_DTO tinhTrang;
    private int gia;

    public BienTheMonAn_DTO() {
    }

    public BienTheMonAn_DTO(TinhTrangBTMA_DTO tinhTrang, int gia) {
        this.tinhTrang = tinhTrang;
        this.gia = gia;
    }

    public TinhTrangBTMA_DTO getTinhTrang() {
        return tinhTrang;
    }

    public int getGia() {
        return gia;
    }

    public void setTinhTrang(TinhTrangBTMA_DTO tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
