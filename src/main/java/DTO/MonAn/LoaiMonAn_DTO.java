package DTO.MonAn;

/**
 *
 * @author LeAnhQuan
 */
public class LoaiMonAn_DTO {
    private int id;
    private String ten;

    public LoaiMonAn_DTO() {
    }

    public LoaiMonAn_DTO(int id, String ten) {
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

    @Override
    public String toString() {
        return "LoaiMonAn_DTO{" + "id=" + id + ", ten=" + ten + '}';
    }
    
    
}
