package DTO.MonAn;

/**
 *
 * @author LeAnhQuan
 */
public class MonAn_DTO {
    private int id;
    private String ten;
    private String hinhAnh;
    private LoaiMonAn_DTO loaiMonAn_DTO;

    public MonAn_DTO() {
    }
    

    public MonAn_DTO(int id, String ten, String hinhAnh, LoaiMonAn_DTO loaiMonAn) {
        this.id = id;
        this.ten = ten;
        this.hinhAnh = hinhAnh;
        this.loaiMonAn_DTO = loaiMonAn;
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

    public LoaiMonAn_DTO getLoaiMonAn_DTO() {
        return loaiMonAn_DTO;
    }

    public void setLoaiMonAn_DTO(LoaiMonAn_DTO loaiMonAn_DTO) {
        this.loaiMonAn_DTO = loaiMonAn_DTO;
    }
}