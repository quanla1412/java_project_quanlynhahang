package DTO.MonAn;

/**
 *
 * @author LeAnhQuan
 */
public class TinhTrangBTMA_DTO {
    private int id;
    private String ten;

    public TinhTrangBTMA_DTO() {
    }

    public TinhTrangBTMA_DTO(int id, String ten) {
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
