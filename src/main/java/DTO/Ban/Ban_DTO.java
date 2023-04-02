 package DTO.Ban;

/**
 *
 * @author LeAnhQuan
 */
public class Ban_DTO {
    private int id;
    private TinhTrangBan_DTO tinhTrangBan;
    private LoaiBan_DTO loaiBan;

    public Ban_DTO() {
    }

    public Ban_DTO(int id, TinhTrangBan_DTO tinhTrangBan, LoaiBan_DTO loaiBan) {
        this.id = id;
        this.tinhTrangBan = tinhTrangBan;
        this.loaiBan = loaiBan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TinhTrangBan_DTO getTinhTrangBan() {
        return tinhTrangBan;
    }

    public void setTinhTrangBan(TinhTrangBan_DTO tinhTrangBan) {
        this.tinhTrangBan = tinhTrangBan;
    }

    public LoaiBan_DTO getLoaiBan() {
        return loaiBan;
    }

    public void setLoaiBan(LoaiBan_DTO loaiBan) {
        this.loaiBan = loaiBan;
    }
}
