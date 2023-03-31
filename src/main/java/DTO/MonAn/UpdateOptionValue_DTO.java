package DTO.MonAn;

/**
 *
 * @author LeAnhQuan
 */
public class UpdateOptionValue_DTO {
    private int idOption;
    private int idValue;
    private String tenValue;

    public UpdateOptionValue_DTO() {
    }

    public UpdateOptionValue_DTO(int idOption, int idValue, String tenValue) {
        this.idOption = idOption;
        this.idValue = idValue;
        this.tenValue = tenValue;
    }

    public int getIdOption() {
        return idOption;
    }

    public void setIdOption(int idOption) {
        this.idOption = idOption;
    }

    public int getIdValue() {
        return idValue;
    }

    public void setIdValue(int idValue) {
        this.idValue = idValue;
    }

    public String getTenValue() {
        return tenValue;
    }

    public void setTenValue(String tenValue) {
        this.tenValue = tenValue;
    }
}
