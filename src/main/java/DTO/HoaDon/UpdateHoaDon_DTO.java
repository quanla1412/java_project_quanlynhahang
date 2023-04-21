package DTO.HoaDon;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author LeAnhQuan
 */
public class UpdateHoaDon_DTO {
    private int idHoaDon;

    public UpdateHoaDon_DTO() {
    }

    public UpdateHoaDon_DTO(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }
   
}
