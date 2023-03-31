package DTO.MonAn;

import java.util.ArrayList;

/**
 *
 * @author LeAnhQuan
 */
public class CreateBienTheMonAn_DTO {
    private int idMonAn;
    private int idTinhTrang;
    private int gia;
    private ArrayList<OptionValue_DTO> options;

    public CreateBienTheMonAn_DTO() {
    }

    public CreateBienTheMonAn_DTO(int idMonAn, int idTinhTrang, int gia, ArrayList<OptionValue_DTO> options) {
        this.idMonAn = idMonAn;
        this.idTinhTrang = idTinhTrang;
        this.gia = gia;
        this.options = options;
    }

    public int getIdMonAn() {
        return idMonAn;
    }

    public void setIdMonAn(int idMonAn) {
        this.idMonAn = idMonAn;
    }
    
    public int getIdTinhTrang() {
        return idTinhTrang;
    }

    public void setIdTinhTrang(int idTinhTrang) {
        this.idTinhTrang = idTinhTrang;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public ArrayList<OptionValue_DTO> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<OptionValue_DTO> options) {
        this.options = options;
    }
}
