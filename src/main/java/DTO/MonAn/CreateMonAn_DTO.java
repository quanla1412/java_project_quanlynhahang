package DTO.MonAn;

/**
 *
 * @author LeAnhQuan
 */
public class CreateMonAn_DTO {
    private String ten;
    private String hinhAnh;
    private int idLoaiMonAn;
    private int gia;
    private int giaKhuyenMai;
    private int idTtinhTrangMonAn;
    private String noiDung;

    public CreateMonAn_DTO(String ten, String hinhAnh, int idLoaiMonAn, int gia, int giaKhuyenMai, int idTtinhTrangMonAn, String noiDung) {
        this.ten = ten;
        this.hinhAnh = hinhAnh;
        this.idLoaiMonAn = idLoaiMonAn;
        this.gia = gia;
        this.giaKhuyenMai = giaKhuyenMai;
        this.idTtinhTrangMonAn = idTtinhTrangMonAn;
        this.noiDung = noiDung;
    }

    
    public CreateMonAn_DTO() {
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
    
    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getGiaKhuyenMai() {
        return giaKhuyenMai;
    }

    public void setGiaKhuyenMai(int giaKhuyenMai) {
        this.giaKhuyenMai = giaKhuyenMai;
    }

    public int getIdLoaiMonAn() {
        return idLoaiMonAn;
    }

    public void setIdLoaiMonAn(int idLoaiMonAn) {
        this.idLoaiMonAn = idLoaiMonAn;
    }

    public int getIdTtinhTrangMonAn() {
        return idTtinhTrangMonAn;
    }

    public void setIdTtinhTrangMonAn(int idTtinhTrangMonAn) {
        this.idTtinhTrangMonAn = idTtinhTrangMonAn;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    
}