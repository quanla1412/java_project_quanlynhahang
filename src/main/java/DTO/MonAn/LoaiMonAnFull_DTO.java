package DTO.MonAn;

import java.util.ArrayList;

/**
 *
 * @author LeAnhQuan
 */
public class LoaiMonAnFull_DTO {
    private int id;
    private String ten;
    private ArrayList<MonAn_DTO> listMonAn;

    public LoaiMonAnFull_DTO() {
    }
    

    public LoaiMonAnFull_DTO(int id, String ten, LoaiMonAn_DTO loaiMonAn, ArrayList<MonAn_DTO> listMonAn) {
        this.id = id;
        this.ten = ten;
        this.listMonAn = listMonAn;
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

    public ArrayList<MonAn_DTO> getListMonAn() {
        return listMonAn;
    }

    public void setListMonAn(ArrayList<MonAn_DTO> listMonAn) {
        this.listMonAn = listMonAn;
    }
    
    
}
