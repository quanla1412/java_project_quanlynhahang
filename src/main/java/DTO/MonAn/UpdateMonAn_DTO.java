package DTO.MonAn;

/**
 *
 * @author LeAnhQuan
 */
public class UpdateMonAn_DTO {
    private int id;
    private String ten;
    private String hinhAnh;
    private int idLoaiMonAn;

    public UpdateMonAn_DTO() {
    }
    

    public UpdateMonAn_DTO(int id, String ten, LoaiMonAn_DTO loaiMonAn, String hinhAnh, int idLoaiMonAn) {
        this.id = id;
        this.ten = ten;
        this.hinhAnh = hinhAnh;
        this.idLoaiMonAn = idLoaiMonAn;
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

    public int getIdLoaiMonAn() {
        return idLoaiMonAn;
    }

    public void setIdLoaiMonAn(int idLoaiMonAn) {
        this.idLoaiMonAn = idLoaiMonAn;
    }
}
