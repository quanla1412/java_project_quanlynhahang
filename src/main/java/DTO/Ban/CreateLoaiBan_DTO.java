package DTO.Ban;

/**
 *
 * @author LeAnhQuan
 */
public class CreateLoaiBan_DTO {
    private String ten;
    private int soLuongCho;

    public CreateLoaiBan_DTO() {
    }

    public CreateLoaiBan_DTO(String ten, int soLuongCho) {
        this.ten = ten;
        this.soLuongCho = soLuongCho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoLuongCho() {
        return soLuongCho;
    }

    public void setSoLuongCho(int soLuongCho) {
        this.soLuongCho = soLuongCho;
    }
    
    
}
