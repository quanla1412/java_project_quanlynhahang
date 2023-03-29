package DTO;


import DTO.LoaiMonAn_DTO;


/**
 *
 * @author LeAnhQuan
 */
public class UpdateMonAn_DTO {
    private int id;
    private String ten;
    private String hinhAnh;
    private String idLoaiMonAn;

    public UpdateMonAn_DTO() {
    }
    

    public UpdateMonAn_DTO(int id, String ten, LoaiMonAn_DTO loaiMonAn, String hinhAnh, String idLoaiMonAn) {
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

    public String getIdLoaiMonAn() {
        return idLoaiMonAn;
    }

    public void setIdLoaiMonAn(String idLoaiMonAn) {
        this.idLoaiMonAn = idLoaiMonAn;
    }
}
