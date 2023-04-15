package BUS;

import DAO.OptionValue_DAO;
import DTO.MonAn.Option_DTO;
import DTO.MonAn.Value_DTO;
import java.util.ArrayList;

/**
 *
 * @author LeAnhQuan
 */
public class OptionValue_BUS {
    public final int SIZE = 1;
    public final int DE = 2;
    public final int LOAI_NUOC = 3;
    
    
    public ArrayList<Option_DTO> getAllOptions(){
        OptionValue_DAO optionValue_DAO = new OptionValue_DAO();
        ArrayList<Option_DTO> result = optionValue_DAO.getAllOptions();
        
        return result;
    }
    
    public ArrayList<Value_DTO> getAllValuesByOptionId(int idOption){
        OptionValue_DAO optionValue_DAO = new OptionValue_DAO();
        ArrayList<Value_DTO> result = optionValue_DAO.getAllValuesByOptionId(idOption);
        
        return result;
    }
}
