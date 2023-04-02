package DTO.MonAn;

/**
 *
 * @author LeAnhQuan
 */
public class BienTheMonAn_DTO {
    private int idMonAn;
    private int idBTMA;
    private TinhTrangBTMA_DTO tinhTrang;
    private int gia;

    public BienTheMonAn_DTO() {
    }

    public BienTheMonAn_DTO(int idMonAn, int idBTMA, TinhTrangBTMA_DTO tinhTrang, int gia) {
        this.idMonAn = idMonAn;
        this.idBTMA = idBTMA;
        this.tinhTrang = tinhTrang;
        this.gia = gia;
    }

    public int getIdMonAn() {
        return idMonAn;
    }

    public void setIdMonAn(int idMonAn) {
        this.idMonAn = idMonAn;
    }

    public int getIdBTMA() {
        return idBTMA;
    }

    public void setIdBTMA(int idBTMA) {
        this.idBTMA = idBTMA;
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
