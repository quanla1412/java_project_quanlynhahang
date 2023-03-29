package DTO;

/**
 *
 * @author LeAnhQuan
 */
public class MonAn_DTO {
    private int id;
    private String ten;
    private String hinhAnh;

    public MonAn_DTO() {
    }
    

    public MonAn_DTO(int id, String ten, LoaiMonAn_DTO loaiMonAn, String hinhAnh) {
        this.id = id;
        this.ten = ten;
        this.hinhAnh = hinhAnh;
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

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
    
}