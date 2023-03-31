 package DTO.Ban;

/**
 *
 * @author LeAnhQuan
 */
public class UpdateBan_DTO {
    private int idBan;
    private int idTinhTrangBan;
    private int idLoaiBan;

    public UpdateBan_DTO() {
    }

    public UpdateBan_DTO(int idBan, int idTinhTrangBan, int idLoaiBan) {
        this.idBan = idBan;
        this.idTinhTrangBan = idTinhTrangBan;
        this.idLoaiBan = idLoaiBan;
    }

    public int getIdBan() {
        return idBan;
    }

    public void setIdBan(int idBan) {
        this.idBan = idBan;
    }
    
    public int getIdTinhTrangBan() {
        return idTinhTrangBan;
    }

    public void setIdTinhTrangBan(int idTinhTrangBan) {
        this.idTinhTrangBan = idTinhTrangBan;
    }

    public int getIdLoaiBan() {
        return idLoaiBan;
    }

    public void setIdLoaiBan(int idLoaiBan) {
        this.idLoaiBan = idLoaiBan;
    }
}
