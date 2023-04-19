/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhachHang_DAO;
import DTO.KhachHang.CreateKhachHang_DTO;
import DTO.KhachHang.KhachHangFull_DTO;
import DTO.KhachHang.KhachHang_DTO;
import DTO.KhachHang.SearchKhachHang_DTO;
import DTO.KhachHang.UpdateKhachHang_DTO;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author tuant
 */
public class KhachHang_BUS {
    public ArrayList<KhachHang_DTO> getAllKhachHang(){
        KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
        ArrayList<KhachHang_DTO> result = khachHang_DAO.getAllKhachHang();
        
        return result;
    }

    public ArrayList<KhachHang_DTO> searchKhachHang(SearchKhachHang_DTO searchData){
        KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
        ArrayList<KhachHang_DTO> result = khachHang_DAO.searchKhachHang(searchData);
        
        return result;
    }
    
    public KhachHangFull_DTO findKhachHangFullBySDT(String sdt){
        KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
        KhachHangFull_DTO result = khachHang_DAO.findKhachHangFullBySDT(sdt);
        
        return result;
    }
    
    public KhachHangFull_DTO getKhachHangFullById(int id){
        KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
        KhachHangFull_DTO result = khachHang_DAO.getKhachHangFullById(id);
        
        return result;
    }
    
    public boolean createKhachHang(CreateKhachHang_DTO data){
        KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
        
        if(khachHang_DAO.hasSoDienThoaiOrEmail(data.getSdt(), data.getEmail()))
            return false;
        
        boolean result = khachHang_DAO.createKhachHang(data);
    
        return result;
    }
    
    public boolean updateKhachHang(UpdateKhachHang_DTO data){
        KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
        
        if(khachHang_DAO.hasSoDienThoaiOrEmail(data.getId(), data.getSdt(), data.getEmail()))
            return false;
        
        boolean result = khachHang_DAO.updateKhachHang(data);
    
        return result;
    }
    
    public boolean deleteKhachHangById(int id){
        KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
        boolean result = khachHang_DAO.deleteKhachHangById(id);
    
        return result;
    }
    
    public void importKhachHang(KhachHangFull_DTO data){
        KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
        if(khachHang_DAO.hasId( data.getId()))
        {
            UpdateKhachHang_DTO up = new UpdateKhachHang_DTO(data.getId(), data.getLoaiKhachHang().getId(), data.getTen(), data.getSdt(), data.getDiemTichLuy(), data.getEmail(), data.getNgaySinh(), data.isGioiTinhNam());
            updateKhachHang(up);
        }
        else{
            CreateKhachHang_DTO up = new CreateKhachHang_DTO(data.getTen(), data.getSdt(), data.getEmail(), data.getNgaySinh(), data.isGioiTinhNam());
            createKhachHang(up);
        }
    }  
    
    public boolean exportKhachHang(ArrayList<String> listId, String filePath) {
        KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
        ArrayList<KhachHang_DTO> listKhachHang = khachHang_DAO.getListKhachHangByListID(listId);
        
        File saveFile = new File (filePath + "\\danhSachKhachHang.xlsx");

        Workbook wb = new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("Nhân Viên");

        int rowIndex = 1;        
        Row row = sheet.createRow(rowIndex);   
        Cell titleCell = row.createCell(1);
        titleCell.setCellValue("Danh sách khách hàng");
        sheet.addMergedRegion(CellRangeAddress.valueOf("$B$2:$G$2"));        
        CellStyle cellStyleTitle = wb.createCellStyle();
        cellStyleTitle.setAlignment(HorizontalAlignment.CENTER);
        titleCell.setCellStyle(cellStyleTitle);
        

        // tao hang tieu de   
        rowIndex += 2;
        row = sheet.createRow(rowIndex);                
        Cell cell = row.createCell(0);
        cell.setCellValue("Mã khách hàng");    
        
        cell = row.createCell(1);
        cell.setCellValue("Loại khách hàng");   
        
        cell = row.createCell(2);
        cell.setCellValue("Họ và tên");     
        
        cell = row.createCell(3);
        cell.setCellValue("Số điện thoại");          
        
        cell = row.createCell(4);
        cell.setCellValue("Điểm tích lũy");   
        
        cell = row.createCell(5);
        cell.setCellValue("Email");         
        
        cell = row.createCell(6);
        cell.setCellValue("Ngày sinh");     
        
        cell = row.createCell(7);
        cell.setCellValue("Giới tính");


        for (int i=0; i < listKhachHang.size(); i++) {
            KhachHang_DTO data = listKhachHang.get(i);
            
            rowIndex++;            
            row = sheet.createRow(rowIndex);
            
            cell = row.createCell(0);
            cell.setCellValue(data.id());
            
            cell = row.createCell(1);
            cell.setCellValue(data.loaiKhachHang());
            
            cell = row.createCell(2);
            cell.setCellValue(data.ten());
            
            cell = row.createCell(3);
            cell.setCellValue(data.sdt());
            
            cell = row.createCell(4);
            cell.setCellValue(data.diemTichLuy());
            
            cell = row.createCell(5);
            cell.setCellValue(data.email());
            
            CellStyle cellStyleDate = wb.createCellStyle();
            cellStyleDate.setDataFormat(createHelper.createDataFormat().getFormat("d/m/yy"));
            cell = row.createCell(6);
            cell.setCellValue(data.ngaySinh());
            cell.setCellStyle(cellStyleDate);
            
            cell = row.createCell(7);
            cell.setCellValue(data.gioiTinh());
//            cell.setCellStyle(style); // set cell style with color
        }
        
         // Auto resize column witdth
        int numberOfColumn = sheet.getRow(rowIndex).getPhysicalNumberOfCells();
        for (int columnIndex = 0; columnIndex < numberOfColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
        
        
        try (OutputStream os = new FileOutputStream(saveFile.getAbsoluteFile())) {
            wb.write(os);
            openFile(saveFile.toString());  
        } catch (IOException e) {
            System.out.println(e);    
            return false;
        }
        return true;
    }

    public void openFile (String file) {
            try {
                File path = new File(file);
                Desktop.getDesktop().open(path);
            } catch (IOException io) {
            }
    }
    
}
