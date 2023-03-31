package DTO.MonAn;

import DTO.MonAn.OptionValue_DTO;
import java.util.ArrayList;

/**
 *
 * @author LeAnhQuan
 */
public class UpdateBienTheMonAn_DTO {
    private int idMonAn;
    private int idBTMA;
    private int idTinhTrang;
    private int gia;
    private ArrayList<OptionValue_DTO> options;

    public UpdateBienTheMonAn_DTO() {
    }

    public UpdateBienTheMonAn_DTO(int idMonAn, int idBTMA, int idTinhTrang, int gia, ArrayList<OptionValue_DTO> options) {
        this.idMonAn = idMonAn;
        this.idBTMA = idBTMA;
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

    public int getIdBTMA() {
        return idBTMA;
    }

    public void setIdBTMA(int idBTMA) {
        this.idBTMA = idBTMA;
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
