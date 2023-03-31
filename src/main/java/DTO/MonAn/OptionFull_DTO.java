package DTO.MonAn;

import java.util.ArrayList;

/**
 *
 * @author LeAnhQuan
 */
public class OptionFull_DTO {
    private int id;
    private String ten;
    private ArrayList<Value_DTO> value;

    public OptionFull_DTO() {
    }

    public OptionFull_DTO(int id, String ten, ArrayList<Value_DTO> value) {
        this.id = id;
        this.ten = ten;
        this.value = value;
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

    public ArrayList<Value_DTO> getValue() {
        return value;
    }

    public void setValue(ArrayList<Value_DTO> value) {
        this.value = value;
    }
}
