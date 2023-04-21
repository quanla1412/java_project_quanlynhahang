package DTO.HoaDon;


/**
 *
 * @author LeAnhQuan
 */
public class ChiTietHoaDon_DTO {
//    private BienTheMonAn_DTO bienTheMonAn;
//    private int maHoaDon;
    private String tenMonAn;
    private int soLuong;
    private int gia;
    private int thanhTien;

    public ChiTietHoaDon_DTO() {
    }
    
    public ChiTietHoaDon_DTO(String tenMonAn, int soLuong, int gia, int thanhTien){
//        this.maHoaDon = maHoaDon;
        this.tenMonAn = tenMonAn;
        this.soLuong = soLuong;
        this.gia = gia;
        this.thanhTien = thanhTien;
    }

//    public int getMaHoaDon(){
//        return maHoaDon;
//    }
//    
//    public void setMaHoaDon(int maHoaDon){
//        this.maHoaDon = maHoaDon;
//    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    public String getTenMonAn(){
        return tenMonAn;
    }
    
    public void setTenMonAn(String tenMonAn){
        this.tenMonAn = tenMonAn;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
