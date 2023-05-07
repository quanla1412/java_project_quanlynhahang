/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.Ban_BUS;
import BUS.KhachHang_BUS;
import BUS.LoaiBan_BUS;
import BUS.NhanVien_BUS;
import BUS.ThongKe_BUS;
import DTO.Ban.Ban_DTO;
import DTO.Ban.LoaiBan_DTO;
import DTO.KhachHang.KhachHang_DTO;
import DTO.NhanVien.NhanVien_DTO;
import DTO.ThongKe.DoanhThuNgay_DTO;
import DTO.ThongKe.DoanhThuNguoi_DTO;
import DTO.ThongKe.DoanhThuThang_DTO;
import DTO.ThongKe.DoanhThuTheoLoaiMonAn_DTO;
import DTO.ThongKe.SoLuongTheoMonAn_DTO;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.TextAnchor;

public class BaoCaoThongKe_GUI extends javax.swing.JPanel {

    private final LoaiBan_BUS loaiBan_BUS;
    private final Ban_BUS ban_BUS;
    private final KhachHang_BUS khachHang_BUS;
    private final NhanVien_BUS nhanVien_BUS;
    private final ThongKe_BUS thongKe_BUS;
    
    private ArrayList<Ban_DTO> listBan;
    private ArrayList<DoanhThuNgay_DTO> listDoanhThuTheoNgay;
    private ArrayList<DoanhThuThang_DTO> listDoanhThuTheoThang;
    private ArrayList<DoanhThuNguoi_DTO> listDoanhThuTheoNguoi;
    private ArrayList<DoanhThuTheoLoaiMonAn_DTO> listDoanhThuTheoLMA;
    private ArrayList<SoLuongTheoMonAn_DTO> listSoLuongTheoMonAn;
    private ArrayList<LoaiBan_DTO> listLoaiBan;
    private ArrayList<KhachHang_DTO> listKH;
    private ArrayList<NhanVien_DTO> listNV;
    
    public BaoCaoThongKe_GUI() {
        initComponents();
//        this.setLocationRelativeTo(null);
        
        thongKe_BUS = new ThongKe_BUS();
        loaiBan_BUS = new LoaiBan_BUS();
        ban_BUS = new Ban_BUS();
        khachHang_BUS = new KhachHang_BUS();
        nhanVien_BUS = new NhanVien_BUS();
        showPieChartBanTheoSoLuong();
        
        cmbThongKe.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent event) {
            int indexLoaiKH = cmbThongKe.getSelectedIndex();
            switch(indexLoaiKH){
                case (0):
                    showPieChartBanTheoSoLuong();
                    break;
                case (1):
                    showPieChartBanTheoTinhTrang();
                    break;
                case (2):
                    showPieChartKhachHangTheoLoaiKhachHang();
                    break;
                case (3):
                    showPieChartKhachHangTheoGioiTinh();
                    break;
                case (4):
                    showPieChartKhachHangTheoDoTuoi();
                    break;
                case (5):
                    showPieChartNhanVienTheoGioiTinh();
                    break;
                case (6):
                    showPieChartNhanVienTheoTinhTrang();
                    break;
                case (7):
                    showPieChartNhanVienTheoDoTuoi();
                    break;
                case (8):
                    showPieChartDoanhThuTheoNhanVienNamHienTai();
                    break;
                case (9):
                    showPieChartDoanhThuTheoKhachHangNamHienTai();
                    break;
                case (10):
                    showPieChartDoanhThuTheo7NgayGanNhat();
                    break;
                case (11):
                    showPieChartDoanhThuNamHienTai();
                    break;
                case (12):
                    showPieChartDoanhThuTheoLoaiMonAnNamHienTai();
                    break;
                case (13):
                    showPieChartTieuThuMonAnThangHienTai();
                    break;
            }
         }
        });
    }

    
    public void showPieChartBanTheoSoLuong(){
        DefaultPieDataset dataset = new DefaultPieDataset();
        listLoaiBan = loaiBan_BUS.getAllLoaiBan();        
        
        for(LoaiBan_DTO loaiBan : listLoaiBan){
        dataset.setValue(loaiBan.getTen(), loaiBan.getSoLuongCho());
        }
        // Create the chart
        JFreeChart chart = ChartFactory.createPieChart(
            "Thống kê bàn theo số lượng",
            dataset,
            true,
            true,
            false
        );
        
        PiePlot plot = (PiePlot) chart.getPlot();
        
        // Định dạng chuỗi giá trị hiển thị trên biểu đồ tròn
        StandardPieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})", // "{0}" là tên section, "{1}" là giá trị, "{2}" là tỷ lệ phần trăm
                new java.text.DecimalFormat("0"), // định dạng cho giá trị
                new java.text.DecimalFormat("0.00%") // định dạng cho tỷ lệ phần trăm
                );
        plot.setLabelGenerator(labelGenerator);
        // Create the chart panel and add it to the main panel
        ChartPanel chartPanel = new ChartPanel(chart);
        this.pnlBieuDo.removeAll();
        this.pnlBieuDo.add(chartPanel);
        this.pnlBieuDo.validate();
        this.pnlBieuDo.repaint();
     }
    public void showPieChartBanTheoTinhTrang(){
        DefaultPieDataset dataset = new DefaultPieDataset();
        listBan = ban_BUS.getAllBan();        
        Map<String, Integer> countMap = new HashMap<String, Integer>();

        for(Ban_DTO ban : listBan){
            if (countMap.containsKey(ban.getTinhTrangBan())) {
                countMap.put(ban.getTinhTrangBan(), countMap.get(ban.getTinhTrangBan()) + 1);
            } else {
                countMap.put(ban.getTinhTrangBan(), 1);
            }
        }
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }
        // Create the chart
        JFreeChart chart = ChartFactory.createPieChart(
            "Thống kê số lượng bàn theo tình trạng",
            dataset,
            true,
            true,
            false
        );
        
        PiePlot plot = (PiePlot) chart.getPlot();
        
        // Định dạng chuỗi giá trị hiển thị trên biểu đồ tròn
        StandardPieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})", // "{0}" là tên section, "{1}" là giá trị, "{2}" là tỷ lệ phần trăm
                new java.text.DecimalFormat("0"), // định dạng cho giá trị
                new java.text.DecimalFormat("0.00%") // định dạng cho tỷ lệ phần trăm
                );
        plot.setLabelGenerator(labelGenerator);
        // Create the chart panel and add it to the main panel
        ChartPanel chartPanel = new ChartPanel(chart);
        this.pnlBieuDo.removeAll();
        this.pnlBieuDo.add(chartPanel);
        this.pnlBieuDo.validate();
        this.pnlBieuDo.repaint();
    }
    public void showPieChartKhachHangTheoLoaiKhachHang(){
        DefaultPieDataset dataset = new DefaultPieDataset();
        listKH = khachHang_BUS.getAllKhachHang();        
        Map<String, Integer> countMap = new HashMap<String, Integer>();

        for(KhachHang_DTO khachHang : listKH){
            if (countMap.containsKey(khachHang.loaiKhachHang())) {
                countMap.put(khachHang.loaiKhachHang(), countMap.get(khachHang.loaiKhachHang()) + 1);
            } else {
                countMap.put(khachHang.loaiKhachHang(), 1);
            }
        }
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }
        // Create the chart
        JFreeChart chart = ChartFactory.createPieChart(
            "Thống kê số lượng khách hàng theo bậc",
            dataset,
            true,
            true,
            false
        );
        
        PiePlot plot = (PiePlot) chart.getPlot();
        
        // Định dạng chuỗi giá trị hiển thị trên biểu đồ tròn
        StandardPieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})", // "{0}" là tên section, "{1}" là giá trị, "{2}" là tỷ lệ phần trăm
                new java.text.DecimalFormat("0"), // định dạng cho giá trị
                new java.text.DecimalFormat("0.00%") // định dạng cho tỷ lệ phần trăm
                );
        plot.setLabelGenerator(labelGenerator);
        // Create the chart panel and add it to the main panel
        ChartPanel chartPanel = new ChartPanel(chart);
        this.pnlBieuDo.removeAll();
        this.pnlBieuDo.add(chartPanel);
        this.pnlBieuDo.validate();
        this.pnlBieuDo.repaint();
     }    
    public void showPieChartKhachHangTheoGioiTinh(){
        DefaultPieDataset dataset = new DefaultPieDataset();
        listKH = khachHang_BUS.getAllKhachHang();        
        Map<String, Integer> countMap = new HashMap<String, Integer>();

        for(KhachHang_DTO khachHang : listKH){
            if (countMap.containsKey(khachHang.gioiTinh())) {
                countMap.put(khachHang.gioiTinh(), countMap.get(khachHang.gioiTinh()) + 1);
            } else {
                countMap.put(khachHang.gioiTinh(), 1);
            }
        }
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }
        // Create the chart
        JFreeChart chart = ChartFactory.createPieChart(
            "Thống kê số lượng khách hàng theo giới tính",
            dataset,
            true,
            true,
            false
        );
        
        PiePlot plot = (PiePlot) chart.getPlot();
        
        // Định dạng chuỗi giá trị hiển thị trên biểu đồ tròn
        StandardPieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})", // "{0}" là tên section, "{1}" là giá trị, "{2}" là tỷ lệ phần trăm
                new java.text.DecimalFormat("0"), // định dạng cho giá trị
                new java.text.DecimalFormat("0.00%") // định dạng cho tỷ lệ phần trăm
                );
        plot.setLabelGenerator(labelGenerator);
        // Create the chart panel and add it to the main panel
        ChartPanel chartPanel = new ChartPanel(chart);
        this.pnlBieuDo.removeAll();
        this.pnlBieuDo.add(chartPanel);
        this.pnlBieuDo.validate();
        this.pnlBieuDo.repaint();
     }  
    public void showPieChartKhachHangTheoDoTuoi(){
        DefaultPieDataset dataset = new DefaultPieDataset();
        listKH = khachHang_BUS.getAllKhachHang();
        int u20=0;
        int u30=0;
        int u40=0;
        int uConLai=0;
        for(KhachHang_DTO khachHang : listKH){
            Timestamp ngaySinh;
            ngaySinh = new Timestamp(khachHang.ngaySinh().getTime());
            int tuoi = Period.between(ngaySinh.toLocalDateTime().toLocalDate(), LocalDate.now()).getYears();
            if (tuoi < 20) {
                u20++;
            }
            else if(tuoi < 30){
                u30++;
            }
            else if(tuoi < 40){
                u40++;
            }
            else 
                uConLai++;               
        }
        if(u20>0) dataset.setValue("Dưới 20",u20 );
        if(u30>0) dataset.setValue("Từ 20 - 29",u30 );
        if(u40>0) dataset.setValue("Từ 30 - 39",u40 );
        if(uConLai>0) dataset.setValue("Từ 40 trở lên",uConLai );
        // Create the chart
        JFreeChart chart = ChartFactory.createPieChart(
            "Thống kê số lượng khách hàng theo độ tuổi",
            dataset,
            true,
            true,
            false
        );
        
        PiePlot plot = (PiePlot) chart.getPlot();
        
        // Định dạng chuỗi giá trị hiển thị trên biểu đồ tròn
        StandardPieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})", // "{0}" là tên section, "{1}" là giá trị, "{2}" là tỷ lệ phần trăm
                new java.text.DecimalFormat("0"), // định dạng cho giá trị
                new java.text.DecimalFormat("0.00%") // định dạng cho tỷ lệ phần trăm
                );
        plot.setLabelGenerator(labelGenerator);
        // Create the chart panel and add it to the main panel
        ChartPanel chartPanel = new ChartPanel(chart);
        this.pnlBieuDo.removeAll();
        this.pnlBieuDo.add(chartPanel);
        this.pnlBieuDo.validate();
        this.pnlBieuDo.repaint();
     }  
    public void showPieChartNhanVienTheoGioiTinh(){
        DefaultPieDataset dataset = new DefaultPieDataset();
        listNV = nhanVien_BUS.getAllNhanVien();        
        Map<String, Integer> countMap = new HashMap<String, Integer>();

        for(NhanVien_DTO nhanVien : listNV){
            if (countMap.containsKey(nhanVien.gioiTinh())) {
                countMap.put(nhanVien.gioiTinh(), countMap.get(nhanVien.gioiTinh()) + 1);
            } else {
                countMap.put(nhanVien.gioiTinh(), 1);
            }
        }
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }
        // Create the chart
        JFreeChart chart = ChartFactory.createPieChart(
            "Thống kê số lượng nhân viên theo giới tính",
            dataset,
            true,
            true,
            false
        );
        
        PiePlot plot = (PiePlot) chart.getPlot();
        
        // Định dạng chuỗi giá trị hiển thị trên biểu đồ tròn
        StandardPieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})", // "{0}" là tên section, "{1}" là giá trị, "{2}" là tỷ lệ phần trăm
                new java.text.DecimalFormat("0"), // định dạng cho giá trị
                new java.text.DecimalFormat("0.00%") // định dạng cho tỷ lệ phần trăm
                );
        plot.setLabelGenerator(labelGenerator);
        // Create the chart panel and add it to the main panel
        ChartPanel chartPanel = new ChartPanel(chart);
        this.pnlBieuDo.removeAll();
        this.pnlBieuDo.add(chartPanel);
        this.pnlBieuDo.validate();
        this.pnlBieuDo.repaint();
     }
    public void showPieChartNhanVienTheoTinhTrang(){
        DefaultPieDataset dataset = new DefaultPieDataset();
        listNV = nhanVien_BUS.getAllNhanVien();        
        Map<String, Integer> countMap = new HashMap<String, Integer>();

        for(NhanVien_DTO nhanVien : listNV){
            if (countMap.containsKey(nhanVien.tinhTrangNhanVien())) {
                countMap.put(nhanVien.tinhTrangNhanVien(), countMap.get(nhanVien.tinhTrangNhanVien()) + 1);
            } else {
                countMap.put(nhanVien.tinhTrangNhanVien(), 1);
            }
        }
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }
        // Create the chart
        JFreeChart chart = ChartFactory.createPieChart(
            "Thống kê số lượng nhân viên theo tính trạng",
            dataset,
            true,
            true,
            false
        );
        
        PiePlot plot = (PiePlot) chart.getPlot();
        
        // Định dạng chuỗi giá trị hiển thị trên biểu đồ tròn
        StandardPieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})", // "{0}" là tên section, "{1}" là giá trị, "{2}" là tỷ lệ phần trăm
                new java.text.DecimalFormat("0"), // định dạng cho giá trị
                new java.text.DecimalFormat("0.00%") // định dạng cho tỷ lệ phần trăm
                );
        plot.setLabelGenerator(labelGenerator);
        // Create the chart panel and add it to the main panel
        ChartPanel chartPanel = new ChartPanel(chart);
        this.pnlBieuDo.removeAll();
        this.pnlBieuDo.add(chartPanel);
        this.pnlBieuDo.validate();
        this.pnlBieuDo.repaint();
     }
    public void showPieChartNhanVienTheoDoTuoi(){
        DefaultPieDataset dataset = new DefaultPieDataset();
        listNV = nhanVien_BUS.getAllNhanVien();        
        int u20=0;
        int u30=0;
        int u40=0;
        int uConLai=0;
        for(NhanVien_DTO nhanVien : listNV){
            Timestamp ngaySinh;
            ngaySinh = new Timestamp(nhanVien.ngaySinh().getTime());
            int tuoi = Period.between(ngaySinh.toLocalDateTime().toLocalDate(), LocalDate.now()).getYears();
            if (tuoi < 20) {
                u20++;
            }
            else if(tuoi < 30){
                u30++;
            }
            else if(tuoi < 40){
                u40++;
            }
            else 
                uConLai++;               
        }
        if(u20>0) dataset.setValue("Dưới 20",u20 );
        if(u30>0) dataset.setValue("Từ 20 - 29",u30 );
        if(u40>0) dataset.setValue("Từ 30 - 39",u40 );
        if(uConLai>0) dataset.setValue("Từ 40 trở lên",uConLai );
        // Create the chart
        JFreeChart chart = ChartFactory.createPieChart(
            "Thống kê số lượng nhân viên theo độ tuổi",
            dataset,
            true,
            true,
            false
        );
        
        PiePlot plot = (PiePlot) chart.getPlot();
        
        // Định dạng chuỗi giá trị hiển thị trên biểu đồ tròn
        StandardPieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})", // "{0}" là tên section, "{1}" là giá trị, "{2}" là tỷ lệ phần trăm
                new java.text.DecimalFormat("0"), // định dạng cho giá trị
                new java.text.DecimalFormat("0.00%") // định dạng cho tỷ lệ phần trăm
                );
        plot.setLabelGenerator(labelGenerator);
        // Create the chart panel and add it to the main panel
        ChartPanel chartPanel = new ChartPanel(chart);
        this.pnlBieuDo.removeAll();
        this.pnlBieuDo.add(chartPanel);
        this.pnlBieuDo.validate();
        this.pnlBieuDo.repaint();
     }
    public void showPieChartDoanhThuTheoNhanVienNamHienTai(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        listDoanhThuTheoNguoi = thongKe_BUS.getAllDoanhThuTheoNhanVien();        
        
        for(DoanhThuNguoi_DTO doanhThu : listDoanhThuTheoNguoi){
        dataset.setValue(doanhThu.getTongTien(), "Doanh thu", doanhThu.getHoTen());
        }
        // Create the chart
        JFreeChart chart = ChartFactory.createBarChart(
            "Thống kê Top 5 nhân viên có doanh thu cao nhất", // Tiêu đề biểu đồ
            "Tên nhân viên",                           // Tên trục x
            "Doanh thu (Triệu VNĐ)",                // Tên trục y
            dataset,                          // Dữ liệu
            PlotOrientation.HORIZONTAL,         // Hướng biểu đồ
            true,                             // Legend
            true,                             // Tooltips
            false                             // URLs
        );
        
        // Create the chart panel and add it to the main panel
        ChartPanel chartPanel = new ChartPanel(chart);
        this.pnlBieuDo.removeAll();
        this.pnlBieuDo.add(chartPanel);
        this.pnlBieuDo.validate();
        this.pnlBieuDo.repaint();
     }
    public void showPieChartDoanhThuTheoKhachHangNamHienTai(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        listDoanhThuTheoNguoi = thongKe_BUS.getAllDoanhThuTheoKhachHang();        
        
        for(DoanhThuNguoi_DTO doanhThu : listDoanhThuTheoNguoi){
        dataset.setValue(doanhThu.getTongTien(), "Doanh thu", doanhThu.getHoTen());
        }
        // Create the chart
        JFreeChart chart = ChartFactory.createBarChart(
            "Thống kê Top 5 khách hàng thân thiết", // Tiêu đề biểu đồ
            "Tên khách hàng",                           // Tên trục x
            "Doanh thu (Triệu VNĐ)",                // Tên trục y
            dataset,                          // Dữ liệu
            PlotOrientation.HORIZONTAL,         // Hướng biểu đồ
            true,                             // Legend
            true,                             // Tooltips
            false                             // URLs
        );
        
        // Create the chart panel and add it to the main panel
        ChartPanel chartPanel = new ChartPanel(chart);
        this.pnlBieuDo.removeAll();
        this.pnlBieuDo.add(chartPanel);
        this.pnlBieuDo.validate();
        this.pnlBieuDo.repaint();
     }
    public void showPieChartDoanhThuTheo7NgayGanNhat(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        listDoanhThuTheoNgay = thongKe_BUS.getAllDoanhThuTheo7NgayGanNhat();        
        
        for(DoanhThuNgay_DTO doanhThu : listDoanhThuTheoNgay){
        dataset.setValue(doanhThu.getTongTien(), "Doanh thu", doanhThu.getDate());
        }
        // Create the chart
        JFreeChart chart = ChartFactory.createBarChart(
            "Thống kê doanh thu theo 7 ngày gần nhất", // Tiêu đề biểu đồ
            "Ngày",                           // Tên trục x
            "Doanh thu (Triệu VNĐ)",                // Tên trục y
            dataset,                          // Dữ liệu
            PlotOrientation.HORIZONTAL,         // Hướng biểu đồ
            true,                             // Legend
            true,                             // Tooltips
            false                             // URLs
        );
        
        // Create the chart panel and add it to the main panel
        ChartPanel chartPanel = new ChartPanel(chart);
        this.pnlBieuDo.removeAll();
        this.pnlBieuDo.add(chartPanel);
        this.pnlBieuDo.validate();
        this.pnlBieuDo.repaint();
     }
    public void showPieChartDoanhThuNamHienTai(){
         DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        listDoanhThuTheoThang = thongKe_BUS.getAllDoanhThuTheoThang();        
        
        
        for(DoanhThuThang_DTO doanhThu : listDoanhThuTheoThang){
            dataset.addValue(doanhThu.getTongTien(), "Sales",doanhThu.getThang());
        }
        // Create the chart
        JFreeChart chart = ChartFactory.createLineChart(
            "Thống kê doanh thu các tháng của năm hiện tại",  // Tiêu đề biểu đồ
            "Month",          // Tiêu đề trục hoành
            "% so với tháng đầu tiên ",      // Tiêu đề trục tung
            dataset           // Dataset
        );
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setBaseShapesVisible(true);
        renderer.setBaseItemLabelGenerator((CategoryItemLabelGenerator) new StandardCategoryItemLabelGenerator("{2}", new DecimalFormat("0.00")));
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, 12));
        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
        // Create the chart panel and add it to the main panel
        ChartPanel chartPanel = new ChartPanel(chart);
        this.pnlBieuDo.removeAll();
        this.pnlBieuDo.add(chartPanel);
        this.pnlBieuDo.validate();
        this.pnlBieuDo.repaint();
     }
    public void showPieChartDoanhThuTheoLoaiMonAnNamHienTai(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        listDoanhThuTheoLMA = thongKe_BUS.getAllDoanhThuTheoLoaiMonAn();        
        
        for(DoanhThuTheoLoaiMonAn_DTO doanhThu : listDoanhThuTheoLMA){
        dataset.setValue(doanhThu.getTongTien(), "Doanh thu", doanhThu.getTenLMA());
        }
        // Create the chart
        JFreeChart chart = ChartFactory.createBarChart(
            "Thống kê doanh thu theo loại món ăn của năm hiện tại", // Tiêu đề biểu đồ
            "Tên loại món ăn",                           // Tên trục x
            "Doanh thu (Triệu VNĐ)",                // Tên trục y
            dataset,                          // Dữ liệu
            PlotOrientation.HORIZONTAL,         // Hướng biểu đồ
            true,                             // Legend
            true,                             // Tooltips
            false                             // URLs
        );
        
        // Create the chart panel and add it to the main panel
        ChartPanel chartPanel = new ChartPanel(chart);
        this.pnlBieuDo.removeAll();
        this.pnlBieuDo.add(chartPanel);
        this.pnlBieuDo.validate();
        this.pnlBieuDo.repaint();
     }
    public void showPieChartTieuThuMonAnThangHienTai(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        listSoLuongTheoMonAn = thongKe_BUS.getAllSoLuongTheoMonAnTheoThang();        
        
        for(SoLuongTheoMonAn_DTO doanhThu : listSoLuongTheoMonAn){
        dataset.setValue(doanhThu.getSoLuong(), "Doanh thu", doanhThu.getTenMonAn());
        }
        // Create the chart
        JFreeChart chart = ChartFactory.createBarChart(
            "Top 5 món ăn bán chạy nhất tháng hiện tại", // Tiêu đề biểu đồ
            "Tên món ăn",                           // Tên trục x
            "Số lượng",                // Tên trục y
            dataset,                          // Dữ liệu
            PlotOrientation.HORIZONTAL,         // Hướng biểu đồ
            true,                             // Legend
            true,                             // Tooltips
            false                             // URLs
        );
        
        // Create the chart panel and add it to the main panel
        ChartPanel chartPanel = new ChartPanel(chart);
        this.pnlBieuDo.removeAll();
        this.pnlBieuDo.add(chartPanel);
        this.pnlBieuDo.validate();
        this.pnlBieuDo.repaint();
     } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        cmbThongKe = new javax.swing.JComboBox<>();
        pnlBieuDo = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());

        cmbThongKe.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmbThongKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thống kê bàn theo số lượng", "Thống kê bàn theo tình trạng bàn", "Thống kê khách hàng theo bậc", "Thống kê khách hàng theo giới tính", "Thống kê khách hàng theo độ tuổi", "Thống kê nhân viên theo giới tính", "Thống kê nhân viên theo tình trạng", "Thống kê nhân viên theo độ tuổi", "Thống kê doanh thu theo nhân viên ( năm hiện tại )", "Thống kê khách hàng thân thiết ( năm hiện tại )", "Thống kê doanh thu 7 ngày gần nhất", "Thống kê doanh thu năm hiện tại", "Thống kê doanh thu theo loại món ăn", "Thống kê lượng tiêu thụ theo món ăn ( tháng hiện tại )" }));
        cmbThongKe.setMinimumSize(new java.awt.Dimension(322, 40));
        cmbThongKe.setPreferredSize(new java.awt.Dimension(322, 40));
        cmbThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbThongKeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmbThongKeMouseEntered(evt);
            }
        });
        cmbThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbThongKeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(12, 20, 12, 20);
        add(cmbThongKe, gridBagConstraints);

        pnlBieuDo.setBackground(new java.awt.Color(102, 102, 255));
        pnlBieuDo.setMinimumSize(new java.awt.Dimension(800, 450));
        pnlBieuDo.setPreferredSize(new java.awt.Dimension(800, 450));
        pnlBieuDo.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        add(pnlBieuDo, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbThongKeMouseClicked
        // TODO add your handling code here:
        //        int indexLoaiKH = cmbThongKe.getSelectedIndex();
        //        if(indexLoaiKH == 1){
            //            showPieChartBanTheoSoLuong();
            //        }
        //        if(indexLoaiKH == 0){
            //            showPieChartBanTheoTinhTrang();
            //        }
    }//GEN-LAST:event_cmbThongKeMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(BaoCaoThongKe_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(BaoCaoThongKe_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(BaoCaoThongKe_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(BaoCaoThongKe_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BaoCaoThongKe_GUI().setVisible(true);
            }
        });
    }
    
    private void cmbThongKeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbThongKeMouseEntered

    }//GEN-LAST:event_cmbThongKeMouseEntered

    private void cmbThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbThongKeActionPerformed
        
    }//GEN-LAST:event_cmbThongKeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbThongKe;
    private javax.swing.JPanel pnlBieuDo;
    // End of variables declaration//GEN-END:variables
}
