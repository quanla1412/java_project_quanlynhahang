/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
        
import DAO.NhanVien_DAO;
import DTO.NhanVien.ChucVu_DTO;
import DTO.NhanVien.CreateNhanVien_DTO;
import DTO.NhanVien.NhanVienFull_DTO;
import DTO.NhanVien.NhanVien_DTO;
import DTO.NhanVien.SearchNhanVien_DTO;
import DTO.NhanVien.TinhTrangNhanVien_DTO;
import DTO.NhanVien.UpdateNhanVien_DTO;
import DTO.TaiKhoan_DTO;
import com.mycompany.quanlynhahang.OpenFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author dinhn
 */
public class NhanVien_BUS {
    
    public ArrayList<NhanVien_DTO> getAllNhanVien(){
        NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
        ArrayList<NhanVien_DTO> result = nhanVien_DAO.getAllNhanVien();
   
        return result;
    }
    
    public NhanVienFull_DTO getNhanVienbyMa(String ma){
        NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
        
        NhanVienFull_DTO result = nhanVien_DAO.getNhanVienbyMa(ma);
        
        return result;
    }    
   
    public boolean createNhanVien(CreateNhanVien_DTO data){
        NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
     
        if(nhanVien_DAO.hasMaNV(data.getMa()) || nhanVien_DAO.hasSoDienThoaiOrEmail(data.getSoDienThoai(), data.getEmail(), data.getCCCD()))
        {
            return false;
        }
        data.setPassword(data.getMa());
        boolean result = nhanVien_DAO.createNhanVien(data);
    
        return result;
    }
    
    public boolean updateNhanVien(UpdateNhanVien_DTO data){
        NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
        if(nhanVien_DAO.hasSoDienThoaiOrEmail(data.getMa(),data.getSoDienThoai(),data.getEmail()))
            return false;
        boolean result = nhanVien_DAO.updateNhanVien(data);
        return result;
    }
    
    public boolean deleteNhanVien(String NVMa){
        NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
        boolean result = nhanVien_DAO.deleteNhanVien(NVMa);
        
        return result;
    }
    
    public ArrayList<NhanVien_DTO> searchNhanVien(SearchNhanVien_DTO searchData) {
        NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
        ArrayList<NhanVien_DTO> result = nhanVien_DAO.searchNhanVien(searchData);
        
        return result;
    }   
    
    public boolean exportNhanVien(ArrayList<NhanVien_DTO> listNhanVien, String filePath) {
        File saveFile = new File (filePath + "\\danhSachNhanVien.xlsx");

        Workbook wb = new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheetNhanVien = wb.createSheet("Nhân Viên");

        int rowIndex = 1;        
        Row row = sheetNhanVien.createRow(rowIndex);   
        Cell titleCell = row.createCell(1);
        titleCell.setCellValue("Danh sách nhân viên");
        sheetNhanVien.addMergedRegion(CellRangeAddress.valueOf("$B$2:$H$2"));        
        CellStyle cellStyleTitle = wb.createCellStyle();
        cellStyleTitle.setAlignment(HorizontalAlignment.CENTER);
        titleCell.setCellStyle(cellStyleTitle);

        // tao hang tieu de   
        rowIndex += 2;
        row = sheetNhanVien.createRow(rowIndex);                
        Cell cell = row.createCell(0);
        cell.setCellValue("Mã nhân viên");    
        
        cell = row.createCell(1);
        cell.setCellValue("Họ tên");   
        
        cell = row.createCell(2);
        cell.setCellValue("Chức vụ");     
        
        cell = row.createCell(3);
        cell.setCellValue("Ngày sinh");          
        
        cell = row.createCell(4);
        cell.setCellValue("Giới tính");   
        
        cell = row.createCell(5);
        cell.setCellValue("Email");         
        
        cell = row.createCell(6);
        cell.setCellValue("Số điện thoại");     
        
        cell = row.createCell(7);
        cell.setCellValue("Địa chỉ");
        
        cell = row.createCell(8);
        cell.setCellValue("Căn cước công dân");
        
        cell = row.createCell(9);
        cell.setCellValue("Tình trạng");

        for (int i=0; i < listNhanVien.size(); i++) {
            NhanVien_DTO data = listNhanVien.get(i);
            
            rowIndex++;            
            row = sheetNhanVien.createRow(rowIndex);
            
            cell = row.createCell(0);
            cell.setCellValue(data.ma());
            
            cell = row.createCell(1);
            cell.setCellValue(data.hoTen());
            
            cell = row.createCell(2);
            cell.setCellValue(data.tenChucVu());
            
            CellStyle cellStyleDate = wb.createCellStyle();
            cellStyleDate.setDataFormat(createHelper.createDataFormat().getFormat("d/m/yyyy"));
            cell = row.createCell(3);
            cell.setCellValue(data.ngaySinh());
            cell.setCellStyle(cellStyleDate);
            
            cell = row.createCell(4);
            cell.setCellValue(data.gioiTinh());
            
            cell = row.createCell(5);
            cell.setCellValue(data.email());
            
            cell = row.createCell(6);
            cell.setCellValue(data.sdt());
            
            cell = row.createCell(7);
            cell.setCellValue(data.diaChi());
            
            cell = row.createCell(8);
            cell.setCellValue(data.CCCD());
            
            cell = row.createCell(9);
            cell.setCellValue(data.tinhTrangNhanVien());
//            cell.setCellStyle(style); // set cell style with color
        }
        
         // Auto resize column witdth
        int numberOfColumn = sheetNhanVien.getRow(rowIndex).getPhysicalNumberOfCells();
        for (int columnIndex = 0; columnIndex < numberOfColumn; columnIndex++) {
            sheetNhanVien.autoSizeColumn(columnIndex);
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

    public boolean exportAllNhanVienTheoMauImport(String filePath) {
        NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
        ChucVu_BUS chucVu_BUS = new ChucVu_BUS();
        TinhTrangNhanVien_BUS tinhTrangNhanVien_BUS = new TinhTrangNhanVien_BUS();
        
        ArrayList<NhanVienFull_DTO> listNhanVien = nhanVien_DAO.getAllNhanVienFull();
        
        File saveFile = new File (filePath + "\\danhSachNhanVienImport.xlsx");

        Workbook wb = new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheetNhanVien = wb.createSheet("Nhân Viên");

        int rowIndex = 0;       

        // tao hang tieu de           
        Row row = sheetNhanVien.createRow(rowIndex);                 
        Cell cell = row.createCell(0);
        cell.setCellValue("Mã nhân viên");     
        
        cell = row.createCell(1);
        cell.setCellValue("Tình trạng nhân viên");     
        
        cell = row.createCell(2);
        cell.setCellValue("Chức vụ");      
        
        cell = row.createCell(3);
        cell.setCellValue("Họ tên");         
        
        cell = row.createCell(4);
        cell.setCellValue("Ngày sinh");     
        
        cell = row.createCell(5);
        cell.setCellValue("Giới tính nam");
        
        cell = row.createCell(6);
        cell.setCellValue("Email");
        
        cell = row.createCell(7);
        cell.setCellValue("Số điện thoại");
        
        cell = row.createCell(8);
        cell.setCellValue("Căn cước công dân");
        
        cell = row.createCell(9);
        cell.setCellValue("Địa chỉ");


        for (int i=0; i < listNhanVien.size(); i++) {
            NhanVienFull_DTO data = listNhanVien.get(i);
            
            rowIndex++;            
            row = sheetNhanVien.createRow(rowIndex);
            
            cell = row.createCell(0);
            cell.setCellValue(data.getMa());
            
            cell = row.createCell(1);
            cell.setCellValue(data.getTinhTrangNhanVien().getId());
            
            cell = row.createCell(2);
            cell.setCellValue(data.getChucVu().getId());
            
            cell = row.createCell(3);
            cell.setCellValue(data.getHoTen());
            
            cell = row.createCell(4);
            CellStyle cellStyleDate = wb.createCellStyle();
            cellStyleDate.setDataFormat(createHelper.createDataFormat().getFormat("m/d/yyyy"));
            cell.setCellValue(data.getNgaySinh());
            cell.setCellStyle(cellStyleDate);
            
            cell = row.createCell(5);
            cell.setCellValue(data.isGioiTinhNam());
            
            cell = row.createCell(6);
            cell.setCellValue(data.getEmail());
            
            cell = row.createCell(7);
            cell.setCellValue(data.getSoDienThoai());
            
            cell = row.createCell(8);
            cell.setCellValue(data.getCCCD());
            
            cell = row.createCell(9);
            cell.setCellValue(data.getDiaChi());
//            cell.setCellStyle(style); // set cell style with color
        }
        
         // Auto resize column witdth
        int numberOfColumn = sheetNhanVien.getRow(rowIndex).getPhysicalNumberOfCells();
        for (int columnIndex = 0; columnIndex < numberOfColumn; columnIndex++) {
            sheetNhanVien.autoSizeColumn(columnIndex);
        }
        
        //Sheet thông tin chức vụ và tình trạng        
        ArrayList<ChucVu_DTO> listChucVu = chucVu_BUS.getAllChucVu();
        ArrayList<TinhTrangNhanVien_DTO> listTinhTrang = tinhTrangNhanVien_BUS.getAllLTinhTrangNhanVien();
        Sheet sheetThongTin = wb.createSheet("Chức vụ và tình trạng");

        rowIndex = 0;               

        // tao hang tieu de 
        row = sheetThongTin.createRow(rowIndex++);                
        cell = row.createCell(0);
        cell.setCellValue("Danh sách chức vụ"); 
        sheetThongTin.addMergedRegion(CellRangeAddress.valueOf("$A$1:$B$1"));    
        
        row = sheetThongTin.createRow(rowIndex);                
        cell = row.createCell(0);
        cell.setCellValue("ID chức vụ");     
        
        cell = row.createCell(1);
        cell.setCellValue("Tên chức vụ");    


        for (int i=0; i < listChucVu.size(); i++) {
            ChucVu_DTO data = listChucVu.get(i);
            
            rowIndex++;            
            row = sheetThongTin.createRow(rowIndex);
            
            cell = row.createCell(0);
            cell.setCellValue(data.getId());
            
            cell = row.createCell(1);
            cell.setCellValue(data.getTen());
//            cell.setCellStyle(style); // set cell style with color
        }
        
        // tao hang tieu de 
        sheetThongTin.shiftRows(rowIndex, rowIndex+1, 1);
        rowIndex+=2;
        row = sheetThongTin.createRow(rowIndex);                
        cell = row.createCell(0);
        cell.setCellValue("Danh sách tình trạng");   
        sheetThongTin.addMergedRegion(CellRangeAddress.valueOf("$A$" + (rowIndex+1) + ":$B$" + (rowIndex + 1))); 
        
        rowIndex++;
        row = sheetThongTin.createRow(rowIndex);                
        cell = row.createCell(0);
        cell.setCellValue("ID tình trạng");     
        
        cell = row.createCell(1);
        cell.setCellValue("Tên tình trạng");    


        for (int i=0; i < listTinhTrang.size(); i++) {
            ChucVu_DTO data = listChucVu.get(i);
            
            rowIndex++;            
            row = sheetThongTin.createRow(rowIndex);
            
            cell = row.createCell(0);
            cell.setCellValue(data.getId());
            
            cell = row.createCell(1);
            cell.setCellValue(data.getTen());
//            cell.setCellStyle(style); // set cell style with color
        }
        
         // Auto resize column witdth
        numberOfColumn = sheetThongTin.getRow(rowIndex).getPhysicalNumberOfCells();
        for (int columnIndex = 0; columnIndex < numberOfColumn; columnIndex++) {
            sheetThongTin.autoSizeColumn(columnIndex);
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

    public int importNhanVien(String filePath){
        NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
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
                
                String ma = row.getCell(0).getStringCellValue();
                int idTinhTrang = (int) row.getCell(1).getNumericCellValue();
                int idChucVu = (int) row.getCell(2).getNumericCellValue();
                String hoTen = row.getCell(3).getStringCellValue();
                Date ngaySinh = row.getCell(4).getDateCellValue();
                boolean gioiTinhNam = row.getCell(5).getBooleanCellValue();
                String email = row.getCell(6).getStringCellValue();
                String SDT = row.getCell(7).getStringCellValue();
                String CCCD = row.getCell(8).getStringCellValue();
                String diaChi = row.getCell(9).getStringCellValue();
                
                if(nhanVien_DAO.hasMaNV(ma)){
                    UpdateNhanVien_DTO data = new UpdateNhanVien_DTO(
                            ma,
                            idTinhTrang,
                            idChucVu,
                            hoTen,
                            email, 
                            SDT,
                            diaChi
                        );
                    result = updateNhanVien(data);
                } else {
                    CreateNhanVien_DTO data = new CreateNhanVien_DTO(
                            ma,
                            idTinhTrang,
                            idChucVu,
                            hoTen, 
                            ngaySinh,
                            gioiTinhNam,
                            email,
                            SDT,
                            diaChi,
                            CCCD
                        );
                    result = createNhanVien(data);
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
    
    public boolean doiMatKhau(String maNhanVien, String password){
        NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
        boolean result = nhanVien_DAO.doiMatKhau(maNhanVien, password);
        
        return result;
    }
    
    public boolean dangNhap(TaiKhoan_DTO taiKhoan_DTO){
        NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
        TaiKhoan_DTO taiKhoan = nhanVien_DAO.getTaiKhoanByMa(taiKhoan_DTO.username());
        
        if(taiKhoan==null)
            return false;
        
        String password = taiKhoan_DTO.password().trim();
        String passwordCheck = taiKhoan.password().trim();
        
        if(password.equals(passwordCheck))
            return true;
        return false;
    }
}
