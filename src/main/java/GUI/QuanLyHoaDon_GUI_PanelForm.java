
package GUI;

import BUS.HoaDon_BUS;
import Constraints.TinhTrangHoaDonConstraints;
import DTO.HoaDon.ChiTietHoaDon_DTO;
import DTO.HoaDon.HoaDonFull_DTO;
import DTO.HoaDon.HoaDon_DTO;
import DTO.Search.SearchHoaDon_DTO;
import com.mycompany.quanlynhahang.Price;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class QuanLyHoaDon_GUI_PanelForm extends javax.swing.JPanel {
    
    private HoaDon_BUS hoaDon_BUS;
    ArrayList<HoaDon_DTO> listHoaDon;
    ArrayList<ChiTietHoaDon_DTO> listChiTietHoaDon;
    
    public QuanLyHoaDon_GUI_PanelForm() {
        initComponents();
         hoaDon_BUS = new HoaDon_BUS();
        
        loadTableHoaDon();
        loadTTHDSearch();
        loadFromDateToDate();
    }

     private void loadTableHoaDon(){
        listHoaDon = hoaDon_BUS.getAllHoaDon();
        
        String col[] = {"ID","Mã nhân viên","Mã khách hàng","Ngày giờ","Tổng giá"};
        DefaultTableModel tableModel = new DefaultTableModel(col,0);
        tblDanhSachHoaDon.setModel(tableModel);
        for(HoaDon_DTO row: listHoaDon){
            Object[] data = {row.getId(), row.getMaNhanVien(),row.getIdKhachHang(),row.getNgayGio(),Price.formatPrice(row.getTongGia())};
            tableModel.addRow(data);
        }
    }
    
    private void loadTableHoaDon(ArrayList<HoaDon_DTO> dataTable){
        listHoaDon = dataTable;
        
        String col[] = {"ID","Mã nhân viên","Mã khách hàng","Ngày giờ","Tổng giá"};
        DefaultTableModel tableModel = new DefaultTableModel(col,0);
        tblDanhSachHoaDon.setModel(tableModel);
        for(HoaDon_DTO row: listHoaDon){
            Object[] data = {row.getId(), row.getMaNhanVien(),row.getIdKhachHang(),row.getNgayGio(),Price.formatPrice(row.getTongGia())};
            tableModel.addRow(data);
        }
    }
    
    
    
    private void loadFromDateToDate(){  
        LocalDate fromDate = LocalDate.now().minusDays(7);
        LocalDate toDate = LocalDate.now();
        
        dtcNgayBatDau.setDate(Date.valueOf(fromDate));
        dtcNgayCuoiCung.setDate(Date.valueOf(toDate));
    }
    
    private void loadTTHDSearch(){
        cmbTTMASearch.addItem("Tất cả");
        cmbTTMASearch.addItem("Hợp lệ");
        cmbTTMASearch.addItem("Đã Huỷ");  
    }
    
    private void resetTable(){
        loadTableHoaDon();
        txtSearchID.setText("");
        
        LocalDate fromDate = LocalDate.now().minusDays(7);
        LocalDate toDate = LocalDate.now();
        dtcNgayBatDau.setDate(Date.valueOf(fromDate));
        dtcNgayCuoiCung.setDate(Date.valueOf(toDate));
        
        sldMinPrice.setValue(sldMinPrice.getMinimum());
        lblMinPrice.setText(Price.formatPrice(sldMinPrice.getValue()));
        sldMaxPrice.setValue(sldMaxPrice.getMaximum());
        lblMaxPrice.setText(Price.formatPrice(sldMaxPrice.getValue()));
        
        cmbTTMASearch.setSelectedIndex(0);
    }
    
    private void loadFormWithHoaDon(int idHoaDon){
        HoaDonFull_DTO result = hoaDon_BUS.getHoaDonFullById(idHoaDon);
        if (result == null){
            JOptionPane.showMessageDialog(this, "Lỗi hệ thống","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        txtMaHoaDon.setText(Integer.toString(result.getId()));
        txtIdNhanVien.setText(result.getMaNhanVien());
        txtIdKhachHang.setText(Integer.toString(result.getIdKhachHang()));
        dtcNgayGio.setDate(result.getNgayGio());
        
        if(result.getTinhTrangHoaDon() == true){
            txtTinhTrangHoaDon.setText("Đã huỷ");
            btnHuyHoaDon.setEnabled(false);
        } else {
            txtTinhTrangHoaDon.setText("Hợp lệ");
            btnHuyHoaDon.setEnabled(true);
        }
        
        loadTableChiTietHoaDonById(result.getListMonAn());
        
        txtUuDai.setText(Float.toString(result.getUuDai()));
        txtThanhTien.setText(Price.formatPrice(result.getTongGia()));
        
       
    }
    
    private void loadTableChiTietHoaDonById(ArrayList<ChiTietHoaDon_DTO> dataTable){
        listChiTietHoaDon = dataTable;
        int count = 1;
        int totalPrice = 0;
        
        String col[] = {"ID","Tên món ăn","Giá","Số Lượng","Thành Tiền"};
        DefaultTableModel tableModel = new DefaultTableModel(col,0);
        tblDonGoi.setModel(tableModel);
        for(ChiTietHoaDon_DTO row : listChiTietHoaDon){
            Object[] data = {count,row.getTenMonAn(),Price.formatPrice(row.getGia()),row.getSoLuong(),Price.formatPrice(row.getThanhTien())};
            tableModel.addRow(data);
            count++;
            totalPrice = totalPrice + row.getThanhTien();
        }
        
        txtTongTien.setText(Price.formatPrice(totalPrice));
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel10 = new javax.swing.JPanel();
        pnlBoLocTimKiem = new javax.swing.JPanel();
        lblNhapID = new javax.swing.JLabel();
        lblLocQuyen = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        dtcNgayCuoiCung = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        dtcNgayBatDau = new com.toedter.calendar.JDateChooser();
        txtSearchID = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lblMinPrice = new javax.swing.JLabel();
        lblMaxPrice = new javax.swing.JLabel();
        sldMinPrice = new javax.swing.JSlider();
        sldMaxPrice = new javax.swing.JSlider();
        jLabel17 = new javax.swing.JLabel();
        cmbTTMASearch = new javax.swing.JComboBox<>();
        btnTimKiem = new javax.swing.JButton();
        pnlBangDanhSachTaiKhoan = new javax.swing.JPanel();
        scrDanhSachTaiKhoan = new javax.swing.JScrollPane();
        tblDanhSachHoaDon = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        pnlThemTaiKhoanMoi = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        lblQuyen = new javax.swing.JLabel();
        lblMatKhau = new javax.swing.JLabel();
        txtIdNhanVien = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDonGoi = new javax.swing.JTable();
        lblID1 = new javax.swing.JLabel();
        lblID2 = new javax.swing.JLabel();
        lblID3 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        txtIdKhachHang = new javax.swing.JTextField();
        txtUuDai = new javax.swing.JTextField();
        txtThanhTien = new javax.swing.JTextField();
        dtcNgayGio = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        btnHuyHoaDon = new javax.swing.JButton();
        lblQuyen1 = new javax.swing.JLabel();
        txtTinhTrangHoaDon = new javax.swing.JTextField();
        lblID4 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.Y_AXIS));

        pnlBoLocTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder("Bộ lọc tìm kiếm"));
        pnlBoLocTimKiem.setMinimumSize(new java.awt.Dimension(520, 160));
        pnlBoLocTimKiem.setPreferredSize(new java.awt.Dimension(520, 160));
        pnlBoLocTimKiem.setLayout(new java.awt.GridBagLayout());

        lblNhapID.setText("Nhập ID");
        lblNhapID.setPreferredSize(new java.awt.Dimension(60, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 8, 12, 8);
        pnlBoLocTimKiem.add(lblNhapID, gridBagConstraints);

        lblLocQuyen.setText("Từ ngày");
        lblLocQuyen.setPreferredSize(new java.awt.Dimension(60, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 8, 12, 8);
        pnlBoLocTimKiem.add(lblLocQuyen, gridBagConstraints);

        btnReset.setText("Reset");
        btnReset.setMaximumSize(new java.awt.Dimension(80, 24));
        btnReset.setMinimumSize(new java.awt.Dimension(80, 24));
        btnReset.setPreferredSize(new java.awt.Dimension(80, 24));
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        pnlBoLocTimKiem.add(btnReset, gridBagConstraints);

        dtcNgayCuoiCung.setMinimumSize(new java.awt.Dimension(120, 24));
        dtcNgayCuoiCung.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        pnlBoLocTimKiem.add(dtcNgayCuoiCung, gridBagConstraints);

        jLabel1.setText("Đến ngày");
        jLabel1.setMaximumSize(new java.awt.Dimension(42, 16));
        jLabel1.setMinimumSize(new java.awt.Dimension(42, 16));
        jLabel1.setPreferredSize(new java.awt.Dimension(60, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        pnlBoLocTimKiem.add(jLabel1, gridBagConstraints);

        dtcNgayBatDau.setMinSelectableDate(new java.util.Date(-62135791113000L));
        dtcNgayBatDau.setMinimumSize(new java.awt.Dimension(120, 24));
        dtcNgayBatDau.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 8);
        pnlBoLocTimKiem.add(dtcNgayBatDau, gridBagConstraints);

        txtSearchID.setMinimumSize(new java.awt.Dimension(310, 24));
        txtSearchID.setPreferredSize(new java.awt.Dimension(310, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 0);
        pnlBoLocTimKiem.add(txtSearchID, gridBagConstraints);

        jLabel10.setText("Khoảng giá:");
        jLabel10.setMinimumSize(new java.awt.Dimension(88, 24));
        jLabel10.setPreferredSize(new java.awt.Dimension(88, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnlBoLocTimKiem.add(jLabel10, gridBagConstraints);

        lblMinPrice.setText("0 VNĐ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        pnlBoLocTimKiem.add(lblMinPrice, gridBagConstraints);

        lblMaxPrice.setText("100.000.000 VNĐ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        pnlBoLocTimKiem.add(lblMaxPrice, gridBagConstraints);

        sldMinPrice.setMaximum(100000000);
        sldMinPrice.setValue(0);
        sldMinPrice.setMinimumSize(new java.awt.Dimension(120, 24));
        sldMinPrice.setPreferredSize(new java.awt.Dimension(120, 24));
        sldMinPrice.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                sldMinPriceMouseDragged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 0);
        pnlBoLocTimKiem.add(sldMinPrice, gridBagConstraints);

        sldMaxPrice.setMaximum(100000000);
        sldMaxPrice.setToolTipText("");
        sldMaxPrice.setValue(100000000);
        sldMaxPrice.setMinimumSize(new java.awt.Dimension(120, 24));
        sldMaxPrice.setPreferredSize(new java.awt.Dimension(120, 24));
        sldMaxPrice.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                sldMaxPriceMouseDragged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        pnlBoLocTimKiem.add(sldMaxPrice, gridBagConstraints);

        jLabel17.setText("Tình trạng hoá đơn");
        jLabel17.setMinimumSize(new java.awt.Dimension(88, 24));
        jLabel17.setPreferredSize(new java.awt.Dimension(88, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnlBoLocTimKiem.add(jLabel17, gridBagConstraints);

        cmbTTMASearch.setMinimumSize(new java.awt.Dimension(120, 24));
        cmbTTMASearch.setPreferredSize(new java.awt.Dimension(250, 24));
        cmbTTMASearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbTTMASearchMouseClicked(evt);
            }
        });
        cmbTTMASearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTTMASearchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnlBoLocTimKiem.add(cmbTTMASearch, gridBagConstraints);

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setMaximumSize(new java.awt.Dimension(80, 24));
        btnTimKiem.setMinimumSize(new java.awt.Dimension(80, 24));
        btnTimKiem.setPreferredSize(new java.awt.Dimension(80, 24));
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
        });
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        pnlBoLocTimKiem.add(btnTimKiem, gridBagConstraints);

        jPanel10.add(pnlBoLocTimKiem);

        pnlBangDanhSachTaiKhoan.setLayout(new java.awt.BorderLayout());

        scrDanhSachTaiKhoan.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách hoá đơn"));
        scrDanhSachTaiKhoan.setMinimumSize(new java.awt.Dimension(200, 320));
        scrDanhSachTaiKhoan.setPreferredSize(new java.awt.Dimension(200, 320));

        tblDanhSachHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã nhân viên", "Mã khách hàng", "Ngày giờ", "Tổng giá"
            }
        ));
        tblDanhSachHoaDon.setMinimumSize(new java.awt.Dimension(375, 100));
        tblDanhSachHoaDon.setPreferredSize(new java.awt.Dimension(375, 100));
        tblDanhSachHoaDon.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblDanhSachHoaDonAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblDanhSachHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachHoaDonMouseClicked(evt);
            }
        });
        scrDanhSachTaiKhoan.setViewportView(tblDanhSachHoaDon);

        pnlBangDanhSachTaiKhoan.add(scrDanhSachTaiKhoan, java.awt.BorderLayout.CENTER);

        jPanel10.add(pnlBangDanhSachTaiKhoan);

        add(jPanel10);

        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.Y_AXIS));

        pnlThemTaiKhoanMoi.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết hoá đơn"));
        pnlThemTaiKhoanMoi.setMinimumSize(new java.awt.Dimension(400, 220));
        pnlThemTaiKhoanMoi.setPreferredSize(new java.awt.Dimension(400, 220));
        pnlThemTaiKhoanMoi.setLayout(new java.awt.GridBagLayout());

        lblID.setText("Mã nhân viên");
        lblID.setMaximumSize(new java.awt.Dimension(100, 16));
        lblID.setMinimumSize(new java.awt.Dimension(100, 16));
        lblID.setPreferredSize(new java.awt.Dimension(100, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 8, 10);
        pnlThemTaiKhoanMoi.add(lblID, gridBagConstraints);

        lblQuyen.setText("Mã khách hàng");
        lblQuyen.setMaximumSize(new java.awt.Dimension(100, 16));
        lblQuyen.setMinimumSize(new java.awt.Dimension(100, 16));
        lblQuyen.setPreferredSize(new java.awt.Dimension(100, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 8, 10);
        pnlThemTaiKhoanMoi.add(lblQuyen, gridBagConstraints);

        lblMatKhau.setText("Ngày giờ");
        lblMatKhau.setMaximumSize(new java.awt.Dimension(100, 16));
        lblMatKhau.setMinimumSize(new java.awt.Dimension(100, 16));
        lblMatKhau.setPreferredSize(new java.awt.Dimension(100, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 8, 10);
        pnlThemTaiKhoanMoi.add(lblMatKhau, gridBagConstraints);

        txtIdNhanVien.setEnabled(false);
        txtIdNhanVien.setMaximumSize(new java.awt.Dimension(172, 24));
        txtIdNhanVien.setMinimumSize(new java.awt.Dimension(172, 24));
        txtIdNhanVien.setPreferredSize(new java.awt.Dimension(172, 24));
        txtIdNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdNhanVienActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        pnlThemTaiKhoanMoi.add(txtIdNhanVien, gridBagConstraints);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jScrollPane3.setMinimumSize(new java.awt.Dimension(300, 180));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(300, 180));

        tblDonGoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên món ăn", "Giá", "Số lượng", "Thành tiền"
            }
        ));
        tblDonGoi.setEnabled(false);
        jScrollPane3.setViewportView(tblDonGoi);

        jPanel1.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 8, 10);
        pnlThemTaiKhoanMoi.add(jPanel1, gridBagConstraints);

        lblID1.setText("Thành tiền");
        lblID1.setMaximumSize(new java.awt.Dimension(100, 16));
        lblID1.setMinimumSize(new java.awt.Dimension(100, 16));
        lblID1.setPreferredSize(new java.awt.Dimension(100, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 8, 10);
        pnlThemTaiKhoanMoi.add(lblID1, gridBagConstraints);

        lblID2.setText("Tổng tiền");
        lblID2.setMaximumSize(new java.awt.Dimension(100, 16));
        lblID2.setMinimumSize(new java.awt.Dimension(100, 16));
        lblID2.setPreferredSize(new java.awt.Dimension(100, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 8, 10);
        pnlThemTaiKhoanMoi.add(lblID2, gridBagConstraints);

        lblID3.setText("Ưu đãi");
        lblID3.setMaximumSize(new java.awt.Dimension(100, 16));
        lblID3.setMinimumSize(new java.awt.Dimension(100, 16));
        lblID3.setPreferredSize(new java.awt.Dimension(100, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 8, 10);
        pnlThemTaiKhoanMoi.add(lblID3, gridBagConstraints);

        txtTongTien.setEnabled(false);
        txtTongTien.setMinimumSize(new java.awt.Dimension(172, 24));
        txtTongTien.setPreferredSize(new java.awt.Dimension(172, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        pnlThemTaiKhoanMoi.add(txtTongTien, gridBagConstraints);

        txtIdKhachHang.setEnabled(false);
        txtIdKhachHang.setMinimumSize(new java.awt.Dimension(172, 24));
        txtIdKhachHang.setPreferredSize(new java.awt.Dimension(172, 24));
        txtIdKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdKhachHangActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        pnlThemTaiKhoanMoi.add(txtIdKhachHang, gridBagConstraints);

        txtUuDai.setEnabled(false);
        txtUuDai.setMinimumSize(new java.awt.Dimension(172, 24));
        txtUuDai.setPreferredSize(new java.awt.Dimension(172, 24));
        txtUuDai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUuDaiActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        pnlThemTaiKhoanMoi.add(txtUuDai, gridBagConstraints);

        txtThanhTien.setEnabled(false);
        txtThanhTien.setMinimumSize(new java.awt.Dimension(172, 24));
        txtThanhTien.setPreferredSize(new java.awt.Dimension(172, 24));
        txtThanhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThanhTienActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        pnlThemTaiKhoanMoi.add(txtThanhTien, gridBagConstraints);

        dtcNgayGio.setEnabled(false);
        dtcNgayGio.setMinimumSize(new java.awt.Dimension(172, 24));
        dtcNgayGio.setPreferredSize(new java.awt.Dimension(172, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        pnlThemTaiKhoanMoi.add(dtcNgayGio, gridBagConstraints);

        jLabel3.setText("Đơn gọi");
        jLabel3.setMaximumSize(new java.awt.Dimension(100, 16));
        jLabel3.setMinimumSize(new java.awt.Dimension(100, 16));
        jLabel3.setPreferredSize(new java.awt.Dimension(100, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 8, 10);
        pnlThemTaiKhoanMoi.add(jLabel3, gridBagConstraints);

        btnHuyHoaDon.setText("Huỷ hoá đơn");
        btnHuyHoaDon.setMaximumSize(new java.awt.Dimension(172, 24));
        btnHuyHoaDon.setMinimumSize(new java.awt.Dimension(172, 24));
        btnHuyHoaDon.setPreferredSize(new java.awt.Dimension(172, 24));
        btnHuyHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHuyHoaDonMouseClicked(evt);
            }
        });
        btnHuyHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHoaDonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        pnlThemTaiKhoanMoi.add(btnHuyHoaDon, gridBagConstraints);

        lblQuyen1.setText("Tình trạng hoá đơn");
        lblQuyen1.setMaximumSize(new java.awt.Dimension(100, 16));
        lblQuyen1.setMinimumSize(new java.awt.Dimension(100, 16));
        lblQuyen1.setPreferredSize(new java.awt.Dimension(100, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 8, 10);
        pnlThemTaiKhoanMoi.add(lblQuyen1, gridBagConstraints);

        txtTinhTrangHoaDon.setEnabled(false);
        txtTinhTrangHoaDon.setMinimumSize(new java.awt.Dimension(172, 24));
        txtTinhTrangHoaDon.setPreferredSize(new java.awt.Dimension(172, 24));
        txtTinhTrangHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTinhTrangHoaDonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        pnlThemTaiKhoanMoi.add(txtTinhTrangHoaDon, gridBagConstraints);

        lblID4.setText("Mã hoá đơn");
        lblID4.setMaximumSize(new java.awt.Dimension(100, 16));
        lblID4.setMinimumSize(new java.awt.Dimension(100, 16));
        lblID4.setPreferredSize(new java.awt.Dimension(100, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 8, 10);
        pnlThemTaiKhoanMoi.add(lblID4, gridBagConstraints);

        txtMaHoaDon.setEnabled(false);
        txtMaHoaDon.setMaximumSize(new java.awt.Dimension(172, 24));
        txtMaHoaDon.setMinimumSize(new java.awt.Dimension(172, 24));
        txtMaHoaDon.setPreferredSize(new java.awt.Dimension(172, 24));
        txtMaHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHoaDonActionPerformed(evt);
            }
        });
        pnlThemTaiKhoanMoi.add(txtMaHoaDon, new java.awt.GridBagConstraints());

        jPanel9.add(pnlThemTaiKhoanMoi);

        add(jPanel9);
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        resetTable();
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetActionPerformed

    private void sldMinPriceMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sldMinPriceMouseDragged
        // TODO add your handling code here:
        lblMinPrice.setText(Price.formatPrice(sldMinPrice.getValue()));
    }//GEN-LAST:event_sldMinPriceMouseDragged

    private void sldMaxPriceMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sldMaxPriceMouseDragged
        // TODO add your handling code here:
        lblMaxPrice.setText(Price.formatPrice(sldMaxPrice.getValue()));
    }//GEN-LAST:event_sldMaxPriceMouseDragged

    private void cmbTTMASearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbTTMASearchMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTTMASearchMouseClicked

    private void cmbTTMASearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTTMASearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTTMASearchActionPerformed

    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        SearchHoaDon_DTO searchHoaDon_DTO = new SearchHoaDon_DTO();

        String id = txtSearchID.getText();
        if(!id.isBlank()){
            searchHoaDon_DTO.setId(id.trim());
        }

        Timestamp ngayBatDau;
        ngayBatDau = new Timestamp(dtcNgayBatDau.getDate().getTime());
        java.util.Date ngayCuoiCung = dtcNgayCuoiCung.getDate();
        ngayCuoiCung.setHours(23);
        ngayCuoiCung.setMinutes(59);
        ngayCuoiCung.setSeconds(59);
        Timestamp ngayCuoiCungTS = new Timestamp(ngayCuoiCung.getTime());

        if((ngayBatDau.compareTo(ngayCuoiCung)) > 0){
            JOptionPane.showMessageDialog(this,"Ngày bắt đầu không được lớn hơn ngày kết thúc","Error",JOptionPane.ERROR_MESSAGE);
        } else {
            searchHoaDon_DTO.setNgayBatDau(ngayBatDau);
            searchHoaDon_DTO.setNgayCuoiCung(ngayCuoiCungTS);
        }

        int minPrice = sldMinPrice.getValue();
        int maxPrice = sldMaxPrice.getValue();
        if(minPrice > maxPrice){
            JOptionPane.showMessageDialog(this,"Giá tối thiểu phải nhỏ hơn giá tối đa","Error",JOptionPane.ERROR_MESSAGE);
        } else {
            searchHoaDon_DTO.setMinPrice(minPrice);
            searchHoaDon_DTO.setMaxPrice(maxPrice);
        }

        int idTTHD = cmbTTMASearch.getSelectedIndex();
        if(idTTHD > 0){
            if(idTTHD == 1){
                searchHoaDon_DTO.setIdTTHD(TinhTrangHoaDonConstraints.HOP_LE);
            } else {
                searchHoaDon_DTO.setIdTTHD(TinhTrangHoaDonConstraints.DA_HUY);
            }
        } else{
            searchHoaDon_DTO.setIdTTHD(TinhTrangHoaDonConstraints.TAT_CA);
        }
        ArrayList<HoaDon_DTO> result = hoaDon_BUS.searchHoaDon(searchHoaDon_DTO);
        loadTableHoaDon(result);
    }//GEN-LAST:event_btnTimKiemMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblDanhSachHoaDonAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblDanhSachHoaDonAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDanhSachHoaDonAncestorAdded

    private void tblDanhSachHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachHoaDonMouseClicked
        int indexRow = tblDanhSachHoaDon.getSelectedRow();
        TableModel model = tblDanhSachHoaDon.getModel();

        int idHoaDon = Integer.parseInt(model.getValueAt(indexRow, 0).toString());
        loadFormWithHoaDon(idHoaDon);

    }//GEN-LAST:event_tblDanhSachHoaDonMouseClicked

    private void txtIdNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdNhanVienActionPerformed

    private void txtIdKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdKhachHangActionPerformed

    private void txtUuDaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUuDaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUuDaiActionPerformed

    private void txtThanhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThanhTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThanhTienActionPerformed

    private void btnHuyHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyHoaDonMouseClicked
        int indexRow = tblDanhSachHoaDon.getSelectedRow();
        TableModel model = tblDanhSachHoaDon.getModel();

        int idHoaDon = Integer.parseInt(model.getValueAt(indexRow, 0).toString());

        boolean result = hoaDon_BUS.deleteHoaDon(idHoaDon);

        if(result){
            JOptionPane.showMessageDialog(this, "Huỷ hoá đơn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
            resetTable();
            loadFormWithHoaDon(idHoaDon);
        } else{
            JOptionPane.showMessageDialog(this, "Huỷ hoá đơn không thành công","Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnHuyHoaDonMouseClicked

    private void btnHuyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHuyHoaDonActionPerformed

    private void txtTinhTrangHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTinhTrangHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTinhTrangHoaDonActionPerformed

    private void txtMaHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHoaDonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyHoaDon;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cmbTTMASearch;
    private com.toedter.calendar.JDateChooser dtcNgayBatDau;
    private com.toedter.calendar.JDateChooser dtcNgayCuoiCung;
    private com.toedter.calendar.JDateChooser dtcNgayGio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblID1;
    private javax.swing.JLabel lblID2;
    private javax.swing.JLabel lblID3;
    private javax.swing.JLabel lblID4;
    private javax.swing.JLabel lblLocQuyen;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblMaxPrice;
    private javax.swing.JLabel lblMinPrice;
    private javax.swing.JLabel lblNhapID;
    private javax.swing.JLabel lblQuyen;
    private javax.swing.JLabel lblQuyen1;
    private javax.swing.JPanel pnlBangDanhSachTaiKhoan;
    private javax.swing.JPanel pnlBoLocTimKiem;
    private javax.swing.JPanel pnlThemTaiKhoanMoi;
    private javax.swing.JScrollPane scrDanhSachTaiKhoan;
    private javax.swing.JSlider sldMaxPrice;
    private javax.swing.JSlider sldMinPrice;
    private javax.swing.JTable tblDanhSachHoaDon;
    private javax.swing.JTable tblDonGoi;
    private javax.swing.JTextField txtIdKhachHang;
    private javax.swing.JTextField txtIdNhanVien;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtSearchID;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTinhTrangHoaDon;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtUuDai;
    // End of variables declaration//GEN-END:variables
}
