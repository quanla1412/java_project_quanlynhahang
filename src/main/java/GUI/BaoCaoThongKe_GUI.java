package GUI;

import BUS.Ban_BUS;
import BUS.KhachHang_BUS;
import BUS.LoaiBan_BUS;
import BUS.NhanVien_BUS;
import DTO.Ban.Ban_DTO;
import DTO.Ban.LoaiBan_DTO;
import DTO.KhachHang.KhachHang_DTO;
import DTO.NhanVien.NhanVien_DTO;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author LeAnhQuan
 */
public class BaoCaoThongKe_GUI extends javax.swing.JFrame {

    private final LoaiBan_BUS loaiBan_BUS;
    private final Ban_BUS ban_BUS;
    private final KhachHang_BUS khachHang_BUS;
    private final NhanVien_BUS nhanVien_BUS;
    
    private ArrayList<Ban_DTO> listBan;
    private ArrayList<LoaiBan_DTO> listLoaiBan;
    private ArrayList<KhachHang_DTO> listKH;
    private ArrayList<NhanVien_DTO> listNV;
    /**
     * Creates new form BaoCaoThongKe_GUI
     */
    public BaoCaoThongKe_GUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        loaiBan_BUS = new LoaiBan_BUS();
        ban_BUS = new Ban_BUS();
        khachHang_BUS = new KhachHang_BUS();
        nhanVien_BUS = new NhanVien_BUS();
        showPieChartBanTheoSoLuong();
    
    cmbThongKe.addItemListener(new ItemListener() {
    public void itemStateChanged(ItemEvent event) {
        int indexLoaiKH = cmbThongKe.getSelectedIndex();
        if(indexLoaiKH == 0){
            showPieChartBanTheoSoLuong();
        }
        if(indexLoaiKH == 1){
            showPieChartBanTheoTinhTrang();
        }
        if(indexLoaiKH == 2){
            showPieChartKhachHangTheoLoaiKhachHang();
        }
        if(indexLoaiKH == 3){
            showPieChartKhachHangTheoGioiTinh();
        }
        if(indexLoaiKH == 4){
            showPieChartKhachHangTheoDoTuoi();
        }
        if(indexLoaiKH == 5){
            showPieChartNhanVienTheoGioiTinh();
        }
        if(indexLoaiKH == 6){
            showPieChartNhanVienTheoTinhTrang();
        }
        if(indexLoaiKH == 7){
            showPieChartNhanVienTheoDoTuoi();
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
            "Số lượng bàn theo loại bàn",
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
            "Số lượng bàn theo tình trạng bàn",
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
            "Số lượng khách hàng theo bậc",
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
            "Số lượng khách hàng giới tính",
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
            "Số lượng khách hàng theo bậc",
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
            if (countMap.containsKey(nhanVien.getGioiTinhNam())) {
                countMap.put(nhanVien.getGioiTinhNam(), countMap.get(nhanVien.getGioiTinhNam()) + 1);
            } else {
                countMap.put(nhanVien.getGioiTinhNam(), 1);
            }
        }
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }
        // Create the chart
        JFreeChart chart = ChartFactory.createPieChart(
            "Số lượng nhân viên theo giới tính",
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
            if (countMap.containsKey(nhanVien.getTinhTrangNhanVien())) {
                countMap.put(nhanVien.getTinhTrangNhanVien(), countMap.get(nhanVien.getTinhTrangNhanVien()) + 1);
            } else {
                countMap.put(nhanVien.getTinhTrangNhanVien(), 1);
            }
        }
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }
        // Create the chart
        JFreeChart chart = ChartFactory.createPieChart(
            "Số lượng nhân viên theo chức vụ",
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
            int tuoi = Period.between(nhanVien.getNgaySinh().toLocalDateTime().toLocalDate(), LocalDate.now()).getYears();
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
            "Số lượng nhân viên theo độ tuổi",
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlBieuDo = new javax.swing.JPanel();
        cmbThongKe = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Báo cáo thống kê");
        setMinimumSize(new java.awt.Dimension(800, 550));
        setPreferredSize(new java.awt.Dimension(800, 550));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlBieuDo.setMinimumSize(new java.awt.Dimension(800, 450));
        pnlBieuDo.setPreferredSize(new java.awt.Dimension(800, 450));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(pnlBieuDo, gridBagConstraints);

        cmbThongKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thống kê bàn theo số lượng", "Thống kê bàn theo tình trạng bàn", "Thống kê khách hàng theo bậc", "Thống kê khách hàng theo giới tính", "Thống kê khách hàng theo độ tuổi", "Thống kê nhân viên theo giới tính", "Thống kê nhân viên theo tình trạng", "Thống kê nhân viên theo độ tuổi" }));
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
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(cmbThongKe, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
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

    private void cmbThongKeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbThongKeMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmbThongKeMouseEntered

    private void cmbThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbThongKeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbThongKeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BaoCaoThongKe_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BaoCaoThongKe_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BaoCaoThongKe_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BaoCaoThongKe_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BaoCaoThongKe_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbThongKe;
    private javax.swing.JPanel pnlBieuDo;
    // End of variables declaration//GEN-END:variables
}
