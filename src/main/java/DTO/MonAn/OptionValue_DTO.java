package DTO.MonAn;

/**
 *
 * @author LeAnhQuan
 */
public class OptionValue_DTO {
    private int idOption;
    private int idValue;

    public OptionValue_DTO() {
    }

    public OptionValue_DTO(int idOption, int idValue) {
        this.idOption = idOption;
        this.idValue = idValue;
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
    
    
}
