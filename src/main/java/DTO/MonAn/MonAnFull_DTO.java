package DTO.MonAn;

/**
 *
 * @author LeAnhQuan
 */
public class MonAnFull_DTO {
    private int id;
    private String ten;
    private String hinhAnh;
    private LoaiMonAn_DTO loaiMonAn;
    private int gia;
    private int giaKhuyenMai;
    private TinhTrangMonAn_DTO tinhTrangMonAn;
    private String noiDung;

    public MonAnFull_DTO(int id, String ten, String hinhAnh, LoaiMonAn_DTO loaiMonAn, int gia, int giaKhuyenMai, TinhTrangMonAn_DTO tinhTrangMonAn, String noiDung) {
        this.id = id;
        this.ten = ten;
        this.hinhAnh = hinhAnh;
        this.loaiMonAn = loaiMonAn;
        this.gia = gia;
        this.giaKhuyenMai = giaKhuyenMai;
        this.tinhTrangMonAn = tinhTrangMonAn;
        this.noiDung = noiDung;
    }

    

    public MonAnFull_DTO() {
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

    public LoaiMonAn_DTO getLoaiMonAn() {
        return loaiMonAn;
    }

    public void setLoaiMonAn(LoaiMonAn_DTO loaiMonAn) {
        this.loaiMonAn = loaiMonAn;
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

    public TinhTrangMonAn_DTO getTinhTrangMonAn() {
        return tinhTrangMonAn;
    }

    public void setTinhTrangMonAn(TinhTrangMonAn_DTO tinhTrangMonAn) {
        this.tinhTrangMonAn = tinhTrangMonAn;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}