package BUS;

import DAO.DonGoi_DAO;
import DAO.HoaDon_DAO;
import DTO.Ban.DonGoi_DTO;
import DTO.HoaDon.ChiTietHoaDon_DTO;
import DTO.HoaDon.CreateHoaDon_DTO;
import DTO.HoaDon.HoaDonFull_DTO;
import DTO.HoaDon.HoaDon_DTO;
import DTO.KhachHang.KhachHangFull_DTO;
import DTO.NhanVien.NhanVienFull_DTO;
import DTO.Search.SearchHoaDon_DTO;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Tab;
import com.itextpdf.layout.element.TabStop;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TabAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.mycompany.quanlynhahang.OpenFile;
import com.mycompany.quanlynhahang.Price;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;



public class HoaDon_BUS {
    
    public ArrayList<HoaDon_DTO> getAllHoaDon(){
        HoaDon_DAO hoaDon_DAO = new HoaDon_DAO();
        ArrayList<HoaDon_DTO> result = hoaDon_DAO.getAllHoaDon();
        
        return result;
    }
    
    public ArrayList<HoaDon_DTO> searchHoaDon(SearchHoaDon_DTO searchData){
        HoaDon_DAO hoaDon_DAO = new HoaDon_DAO();
        ArrayList<HoaDon_DTO> result = hoaDon_DAO.searchHoaDon(searchData);
        
        return result;
    }
    
    public HoaDonFull_DTO getHoaDonFullById(int id){
        HoaDon_DAO hoaDon_DAO = new HoaDon_DAO();
        HoaDonFull_DTO result = hoaDon_DAO.getHoaDonFullById(id);
        
        if(result.getId() < 0){
            return null;
        }
        return result;
    }
    
    public int createHoaDon(CreateHoaDon_DTO data){
        HoaDon_DAO hoaDon_DAO = new HoaDon_DAO();
        int idHoaDon = hoaDon_DAO.createHoaDon(data);
        
        return idHoaDon;
    }
    
    public boolean deleteHoaDon(int idHoaDon){
        HoaDon_DAO hoaDon_DAO = new HoaDon_DAO();
        boolean result = hoaDon_DAO.deleteHoaDon(idHoaDon);
        
        return result;
    }
    
    public boolean inBill(int idHoaDon, String filePath){
        NhanVien_BUS nhanVien_BUS = new NhanVien_BUS();
        KhachHang_BUS khachHang_BUS = new KhachHang_BUS();
        HoaDonFull_DTO hoaDon = getHoaDonFullById(idHoaDon);
        NhanVienFull_DTO nhanVienFull_DTO = nhanVien_BUS.getNhanVienbyMa(hoaDon.getMaNhanVien());
        KhachHangFull_DTO khachHangFull_DTO = null;
        if(hoaDon.getIdKhachHang() > 0)
            khachHangFull_DTO = khachHang_BUS.getKhachHangFullById(hoaDon.getIdKhachHang());
        ArrayList<ChiTietHoaDon_DTO> listChiTietHoaDon = hoaDon.getListMonAn();
        
        // tạo một document
        String dest = filePath + "\\bill.pdf";
        try {
            // Creating a PdfDocument object     
            
            PdfWriter writer = new PdfWriter(dest);       

            // Creating a PdfDocument object      
            PdfDocument pdf = new PdfDocument(writer); 
            
            //Set font
            String FONT = "D:\\QuanLyNhaHang\\Font\\Roboto-Light.ttf";
            PdfFont font = PdfFontFactory.createFont(FONT);                 

            // Creating a Document object       
            Document doc = new Document(pdf);        
            doc.setTextAlignment(TextAlignment.CENTER);
            doc.setFont(font);            
            
            //Create a title
            Paragraph title = new Paragraph("QUẢN LÝ NHÀ HÀNG");
            title.setFontSize(20);
            doc.add(title);
            
            Paragraph name = new Paragraph("In bill tạm");
            name.setFontSize(16);
            doc.add(name);
            
            // Customer and staff information
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formatDateTimeNow = now.format(formatter);
            
            String hoTenKH = khachHangFull_DTO != null ? khachHangFull_DTO.getTen(): "";
            String sdtKH = khachHangFull_DTO != null ? khachHangFull_DTO.getSdt(): "";
            
            String infoString = "Bàn 1\n"
                    + "Mã nhân viên: " + hoaDon.getMaNhanVien() + "\n"
                    + "Tên nhân viên: " +  nhanVienFull_DTO.getHoTen() + "\n"
                    + "Tên khách hàng: " + hoTenKH + "\n"
                    + "Số điện thoại khách hàng: " + sdtKH;
            Paragraph info = new Paragraph(infoString);
            info.setTextAlignment(TextAlignment.LEFT);
            info.add(new Tab());
            info.addTabStops(new TabStop(1000, TabAlignment.RIGHT));
            info.add("Ngày giờ: " + formatDateTimeNow);
            doc.add(info);

            // Creating a table       
            float [] pointColumnWidths = {150F, 150F, 150F, 150F, 150F};   
            Table table = new Table(pointColumnWidths); 

            // Adding Table to document      
            table.addCell("STT");      
            table.addCell("Tên món ăn");       
            table.addCell("Đơn giá");       
            table.addCell("Số lượng");       
            table.addCell("Thành tiền");  
            
            int total = 0;
            for(int i = 0; i < listChiTietHoaDon.size(); i++){
                ChiTietHoaDon_DTO cthd = listChiTietHoaDon.get(i);
                int gia = cthd.getGia();
                int thanhTien = cthd.getSoLuong() * gia;
                total += thanhTien;
                
                table.addCell(Integer.toString(i + 1));
                table.addCell(cthd.getTenMonAn());
                table.addCell(Price.formatPrice(gia));
                table.addCell(Integer.toString(cthd.getSoLuong()));
                table.addCell(Price.formatPrice(thanhTien));
            }    
                    
            doc.add(table);    
        
            double mucUuDai = khachHangFull_DTO != null ? khachHangFull_DTO.getLoaiKhachHang().getMucUuDai() : 0;
            double tongThanhToanDouble = Math.round(total - total * mucUuDai/100);
            int tongThanhToanInt = (int) tongThanhToanDouble;
            
            String tongThanhToanString = "Tổng tiền: " + Price.formatPrice(total) + "\n"
                    + "Ưu đãi khách hàng: " + mucUuDai + "%\n"
                    + "Tổng thanh toán " + Price.formatPrice(tongThanhToanInt); 
            Paragraph tongThanhToan = new Paragraph(tongThanhToanString);
            tongThanhToan.setTextAlignment(TextAlignment.RIGHT);
            doc.add(tongThanhToan);            
              

            // Closing the document       
            doc.close();
            
            OpenFile.openFile(dest); 
            
        } catch (IOException e){
            System.out.println(e);
            return false;
        }
        return true;
    }
}
