package BUS;

import DAO.QuyenTaiKhoan_DAO;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author LeAnhQuan
 */
public class QuyenTaiKhoan_BUS {
    public ArrayList<Integer> getAllQuyenByMaNV(String maNhanVien){
        QuyenTaiKhoan_DAO quyenTaiKhoan_DAO = new QuyenTaiKhoan_DAO();
        ArrayList<Integer> result = quyenTaiKhoan_DAO.getAllQuyenByMaNV(maNhanVien);
        
        return result;
    }
    
    public boolean luu(String maNhanVien, Map<Integer, Boolean> data){
        boolean result = true;
        QuyenTaiKhoan_DAO quyenTaiKhoan_DAO = new QuyenTaiKhoan_DAO();
        Set<Integer> listKey = data.keySet();
        
        for(int key : listKey){
            if(data.get(key)){
                if(!quyenTaiKhoan_DAO.hasQuyen(maNhanVien, key))
                    result = quyenTaiKhoan_DAO.createQuyen(maNhanVien, key);                
            }
            else
                if(quyenTaiKhoan_DAO.hasQuyen(maNhanVien, key))
                    result = quyenTaiKhoan_DAO.deleteQuyen(maNhanVien, key);
            if(!result)
                return result;
        }
        
        return result;
    }
}
