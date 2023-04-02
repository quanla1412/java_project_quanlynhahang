package DTO.Ban;

/**
 *
 * @author LeAnhQuan
 */
public class TinhTrangBan_DTO {
    private int id;
    private String ten;

    public TinhTrangBan_DTO() {
    }

    public TinhTrangBan_DTO(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
