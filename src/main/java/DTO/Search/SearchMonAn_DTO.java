package DTO.Search;

/**
 *
 * @author LeAnhQuan
 */
public class SearchMonAn_DTO {
    private String idOrName;
    private int idLoaiMonAn;
    private int minPrice;
    private int maxPrice;
    private int idTTMA;

    public SearchMonAn_DTO(String idOrName, int idLoaiMonAn, int minPrice, int maxPrice, int idTTMA) {
        this.idOrName = idOrName;
        this.idLoaiMonAn = idLoaiMonAn;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.idTTMA = idTTMA;
    }

    public SearchMonAn_DTO() {
    }

    public String getIdOrName() {
        return idOrName;
    }

    public void setIdOrName(String idOrName) {
        this.idOrName = idOrName;
    }

    public int getIdLoaiMonAn() {
        return idLoaiMonAn;
    }

    public void setIdLoaiMonAn(int idLoaiMonAn) {
        this.idLoaiMonAn = idLoaiMonAn;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getIdTTMA() {
        return idTTMA;
    }

    public void setIdTTMA(int idTTMA) {
        this.idTTMA = idTTMA;
    }
    
    
    
}
