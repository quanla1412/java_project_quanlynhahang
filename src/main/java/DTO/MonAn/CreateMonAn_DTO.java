package DTO.MonAn;

/**
 *
 * @author LeAnhQuan
 */
public class CreateMonAn_DTO {
    private String ten;
    private String hinhAnh;
    private int idLoaiMonAn;

    public CreateMonAn_DTO() {
    }

    public CreateMonAn_DTO(String ten, String hinhAnh, int idLoaiMonAn) {
        this.ten = ten;
        this.hinhAnh = hinhAnh;
        this.idLoaiMonAn = idLoaiMonAn;
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
