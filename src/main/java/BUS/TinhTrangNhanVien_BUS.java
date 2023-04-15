/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.TinhTrangNhanVien_DAO;
import DTO.NhanVien.TinhTrangNhanVien_DTO;
import java.util.ArrayList;

/**
 *
 * @author dinhn
 */
public class TinhTrangNhanVien_BUS {
    private final TinhTrangNhanVien_DAO tinhTrangNhanVien_DAO = new TinhTrangNhanVien_DAO();
    
    public ArrayList<TinhTrangNhanVien_DTO> getAllLTinhTrangNhanVien(){
        ArrayList<TinhTrangNhanVien_DTO> listTinhTrangNhanVien = tinhTrangNhanVien_DAO.getAllTinhTrangNhanVien();
        
        return listTinhTrangNhanVien;
    }
}
