package DTO.MonAn;

/**
 *
 * @author LeAnhQuan
 */
public class OptionValueFull_DTO {
    private Option_DTO option;
    private Value_DTO value;

    public OptionValueFull_DTO() {
    }

    public OptionValueFull_DTO(Option_DTO option, Value_DTO value) {
        this.option = option;
        this.value = value;
    }

    public Option_DTO getOption() {
        return option;
    }

    public void setOption(Option_DTO option) {
        this.option = option;
    }

    public Value_DTO getValue() {
        return value;
    }

    public void setValue(Value_DTO value) {
        this.value = value;
    }
}
