/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhachHang_DAO;
import DAO.LoaiKhachHang_DAO;
import DTO.KhachHang.CreateKhachHang_DTO;
import DTO.KhachHang.KhachHangFull_DTO;
import DTO.KhachHang.KhachHang_DTO;
import DTO.KhachHang.LoaiKhachHang_DTO;
import DTO.KhachHang.SearchKhachHang_DTO;
import DTO.KhachHang.UpdateKhachHang_DTO;
import com.mycompany.quanlynhahang.CheckHopLe;
import com.mycompany.quanlynhahang.OpenFile;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
            cellStyleDate.setDataFormat(createHelper.createDataFormat().getFormat("d/m/yyyy"));
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
            OpenFile.openFile(saveFile.toString());  
        } catch (IOException e) {
            System.out.println(e);    
            return false;
        }
        return true;
    }
    
    public boolean exportAllKhachHangTheoMauImport(String filePath) {
        KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
        
        ArrayList<KhachHangFull_DTO> listKhachHang = khachHang_DAO.getAllKhachHangFull();
        
        File saveFile = new File (filePath + "\\danhSachKhachHangImport.xlsx");

        Workbook wb = new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("Nhân Viên");

        int rowIndex = 1;        
        Row row = sheet.createRow(rowIndex);          

        // tao hang tieu de   
        row = sheet.createRow(rowIndex);                
        Cell cell = row.createCell(0);
        cell.setCellValue("ID khách hàng");     
        
        cell = row.createCell(1);
        cell.setCellValue("Họ và tên");     
        
        cell = row.createCell(2);
        cell.setCellValue("Số điện thoại");      
        
        cell = row.createCell(3);
        cell.setCellValue("Email");         
        
        cell = row.createCell(4);
        cell.setCellValue("Ngày sinh");     
        
        cell = row.createCell(5);
        cell.setCellValue("Giới tính nam");


        for (int i=0; i < listKhachHang.size(); i++) {
            KhachHangFull_DTO data = listKhachHang.get(i);
            
            rowIndex++;            
            row = sheet.createRow(rowIndex);
            
            cell = row.createCell(0);
            cell.setCellValue(data.getId());
            
            cell = row.createCell(1);
            cell.setCellValue(data.getTen());
            
            cell = row.createCell(2);
            cell.setCellValue(data.getSdt());
            
            cell = row.createCell(3);
            cell.setCellValue(data.getEmail());
            
            cell = row.createCell(4);
            CellStyle cellStyleDate = wb.createCellStyle();
            cellStyleDate.setDataFormat(createHelper.createDataFormat().getFormat("d/m/yyyy"));
            cell.setCellValue(data.getNgaySinh());
            cell.setCellStyle(cellStyleDate);
            
            cell = row.createCell(5);
            cell.setCellValue(data.isGioiTinhNam());
//            cell.setCellStyle(style); // set cell style with color
        }
        
         // Auto resize column witdth
        int numberOfColumn = sheet.getRow(rowIndex).getPhysicalNumberOfCells();
        for (int columnIndex = 0; columnIndex < numberOfColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
        
        
        try (OutputStream os = new FileOutputStream(saveFile.getAbsoluteFile())) {
            wb.write(os);
            OpenFile.openFile(saveFile.toString());  
        } catch (IOException e) {
            System.out.println(e);    
            return false;
        }
        return true;
    }
    
    public int importKhachHang(String filePath){
        KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
        int totalSuccess = 0;
        try {
            File file = new File(filePath);
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);
            
                // Đọc dữ liệu từ các hàng trong sheet
            boolean firstRow = true;
            for (Row row : sheet) {
                if (firstRow){
                    firstRow = false;
                    continue;
                }
                boolean result;
                
                int id = (int) row.getCell(0).getNumericCellValue();
                String hoTen = row.getCell(1).getStringCellValue();
                String SDT = row.getCell(2).getStringCellValue();
                String email = row.getCell(3).getStringCellValue();
                Date ngaySinh = row.getCell(4).getDateCellValue();
                boolean gioiTinhNam = row.getCell(5).getBooleanCellValue();
                
                if(khachHang_DAO.hasId(id)){
                    UpdateKhachHang_DTO data = new UpdateKhachHang_DTO(
                            id,
                            hoTen,
                            SDT,
                            email,
                            ngaySinh, 
                            gioiTinhNam
                        );
                    result = updateKhachHang(data);
                } else {
                    CreateKhachHang_DTO data = new CreateKhachHang_DTO(
                            hoTen,
                            SDT,
                            email,
                            ngaySinh, 
                            gioiTinhNam
                        );
                    result = createKhachHang(data);
                }
                
                if(result)
                    totalSuccess++;
            }

                workbook.close();
                
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return totalSuccess;
    }
    
    public boolean capNhatLoaiKhachHang(){
        LoaiKhachHang_BUS loaiKhachHang_BUS = new LoaiKhachHang_BUS();
        KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
        ArrayList<LoaiKhachHang_DTO> listLoaiKhachHang = loaiKhachHang_BUS.getAllLoaiKhachHang();        
        ArrayList<KhachHangFull_DTO>  listKhachHang = khachHang_DAO.getAllKhachHangFull();
        
        for(KhachHangFull_DTO khachHangFull_DTO : listKhachHang){
            for(int i = 1; i < listLoaiKhachHang.size(); i++){
                if(khachHangFull_DTO.getDiemTichLuy() < listLoaiKhachHang.get(i).getDiemToiThieu()){
                    boolean result = khachHang_DAO.capNhatLoaiKhachHang(khachHangFull_DTO.getId(), listLoaiKhachHang.get(i-1).getId());
                    if (!result) {
                        return false;
                    }
                    break;
                }                        
            }
            
        }
        return true;
    }
    
    public boolean capNhatLoaiKhachHangSauXoa(int idLoaiKhachHangBiXoa){         
        LoaiKhachHang_BUS loaiKhachHang_BUS = new LoaiKhachHang_BUS();
        KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
        ArrayList<LoaiKhachHang_DTO> listLoaiKhachHang = loaiKhachHang_BUS.getAllLoaiKhachHang();        
        ArrayList<KhachHangFull_DTO>  listKhachHang = khachHang_DAO.getAllKhachHangFull();
        
        for(KhachHangFull_DTO khachHangFull_DTO : listKhachHang){
            if (khachHangFull_DTO.getLoaiKhachHang().getId() == idLoaiKhachHangBiXoa) {
                for(int i = 1; i < listLoaiKhachHang.size(); i++){
                    if(listLoaiKhachHang.get(i).getId() == idLoaiKhachHangBiXoa){
                        boolean result = khachHang_DAO.capNhatLoaiKhachHang(khachHangFull_DTO.getId(), listLoaiKhachHang.get(i - 1).getId());
                        if (!result) {
                            return false;
                        }
                        break;
                    }                        
                }
            }
        } 
        return true;
    }
}

