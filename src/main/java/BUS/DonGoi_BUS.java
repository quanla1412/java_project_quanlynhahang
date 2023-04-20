package BUS;

import Constraints.TinhTrangBanConstraints;
import DAO.Ban_DAO;
import DAO.DonGoi_DAO;
import DTO.Ban.CreateDonGoi_DTO;
import DTO.Ban.DonGoi_DTO;
import DTO.Ban.UpdateDonGoi_DTO;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Tab;
import com.itextpdf.layout.element.TabStop;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TabAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.mycompany.quanlynhahang.OpenFile;
import com.mycompany.quanlynhahang.Price;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author LeAnhQuan
 */
public class DonGoi_BUS {
    public ArrayList<DonGoi_DTO> getAllDonGoiByIdBan(int idBan){
        DonGoi_DAO donGoi_DAO = new DonGoi_DAO();
        ArrayList<DonGoi_DTO> result = donGoi_DAO.getAllDonGoiByIdBan(idBan);
        
        return result;
    }
    
    public boolean createDonGoi(CreateDonGoi_DTO data){
        DonGoi_DAO donGoi_DAO = new DonGoi_DAO();
        boolean result = donGoi_DAO.createDonGoi(data);
        
        return result;
    }    
    
    public boolean daTonTai(int idBan, int idMonAn){
        DonGoi_DAO donGoi_DAO = new DonGoi_DAO();
        boolean result = donGoi_DAO.daTonTai(idBan, idMonAn);
        
        return result;       
    }
    
    public DonGoi_DTO getDonGoiById(int idBan, int idMonAn){
        DonGoi_DAO donGoi_DAO = new DonGoi_DAO();
        DonGoi_DTO result = donGoi_DAO.getDonGoiById(idBan, idMonAn);
        
        return result;
    }

    public boolean updateDonGoi(UpdateDonGoi_DTO updateDonGoi_DTO) {
        DonGoi_DAO donGoi_DAO = new DonGoi_DAO();
        boolean result = donGoi_DAO.updateDonGoi(updateDonGoi_DTO);
        
        return result;
    }
    
    public boolean deleteDonGoi(int idBan, int idMonAn) {
        DonGoi_DAO donGoi_DAO = new DonGoi_DAO();
        boolean result = donGoi_DAO.deleteDonGoi(idBan, idMonAn);
        
        return result;
    }
    
    public boolean chuyenBan(int idBanCu, int idBanMoi){
        DonGoi_DAO donGoi_DAO = new DonGoi_DAO();
        Ban_DAO ban_DAO = new Ban_DAO();
        boolean result = false;
        
        if(ban_DAO.hasDonGoi(idBanMoi))
            return false;
        
        if(ban_DAO.hasDonGoi(idBanCu)){
            result = donGoi_DAO.chuyenBan(idBanCu, idBanMoi);
            if(!result)
                return false;

            result = ban_DAO.hasDonGoi(idBanMoi) && !ban_DAO.hasDonGoi(idBanCu);
            if(!result)
                return false;
        }
        
        result = ban_DAO.changeTinhTrangBan(idBanMoi, TinhTrangBanConstraints.DANG_PHUC_VU);        
        return result;
    }
    
    public boolean inBillTam(int idBan, String filePath){
        DonGoi_DAO donGoi_DAO = new DonGoi_DAO();
        ArrayList<DonGoi_DTO> listDonGoi = donGoi_DAO.getAllDonGoiByIdBan(idBan);
        
        // tạo một document
        String dest = filePath + "\\billTam.pdf";
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
            
            String infoString = "Bàn 1\n"
                    + "Mã nhân viên: phngnhatan\n"
                    + "Tên nhân viên: Phan Hoàng Nhật Tân\n"
                    + "Tên khách hàng: Lê Anh Quân\n"
                    + "Số điện thoại khách hàng: 0933608977";
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
            for(int i = 0; i < listDonGoi.size(); i++){
                DonGoi_DTO donGoi = listDonGoi.get(i);
                int gia = donGoi.getMonAn().getGiaKhuyenMai() > 0 ? 
                        donGoi.getMonAn().getGiaKhuyenMai() : 
                        donGoi.getMonAn().getGia();
                int thanhTien = donGoi.getSoLuong() * gia;
                total += thanhTien;
                
                table.addCell(Integer.toString(i + 1));
                table.addCell(donGoi.getMonAn().getTen());
                table.addCell(Price.formatPrice(gia));
                table.addCell(Integer.toString(donGoi.getSoLuong()));
                table.addCell(Price.formatPrice(thanhTien));
            }    
                    
            doc.add(table);    
            
            String tongThanhToanString = "Tổng tiền: " + Price.formatPrice(total) + "\n"
                    + "Ưu đãi khách hàng: 0.0%\n"
                    + "Tổng thanh toán " + Price.formatPrice(total); 
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
