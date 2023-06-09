
package GUI;

import BUS.ChucVu_BUS;
import BUS.NhanVien_BUS;
import BUS.TinhTrangNhanVien_BUS;
import Constraints.GioiTinhConstraints;
import Constraints.TinhTrangNhanVienConstraints;
import DTO.NhanVien.ChucVu_DTO;
import DTO.NhanVien.CreateNhanVien_DTO;
import DTO.NhanVien.NhanVienFull_DTO;
import DTO.NhanVien.NhanVien_DTO;
import DTO.NhanVien.SearchNhanVien_DTO;
import DTO.NhanVien.TinhTrangNhanVien_DTO;
import DTO.NhanVien.UpdateNhanVien_DTO;
import GUI.DoiMatKhau_GUI;
import GUI.QuanLyChucVu_GUI;
import GUI.QuanLyQuyen_GUI;
import com.mycompany.quanlynhahang.CheckHopLe;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class QuanLyNhanVien_GUI extends javax.swing.JPanel {

    private final NhanVien_BUS nhanVien_BUS;
    private final ChucVu_BUS   chucVu_BUS;
    private final TinhTrangNhanVien_BUS tinhTrangNhanVien_BUS;
    private boolean dangThemNhanVien = true;
    
    private QuanLyChucVu_GUI quanLyChucVu_GUI;
    private QuanLyQuyen_GUI quanLyQuyen_GUI;
    private DoiMatKhau_GUI doiMatKhau_GUI;
    
    private ArrayList<ChucVu_DTO> listChucVu;
    private ArrayList<TinhTrangNhanVien_DTO> listTinhTrangNhanVien;
    ArrayList<NhanVien_DTO> listNhanVien;
    
    public QuanLyNhanVien_GUI() {
        initComponents();
        nhanVien_BUS = new NhanVien_BUS();
        chucVu_BUS = new ChucVu_BUS();
        tinhTrangNhanVien_BUS = new TinhTrangNhanVien_BUS();
        
        loadTableNhanVien();
        loadComboBoxChucVu();
        loadComboBoxTinhTrangNhanVien();
    }

   public void loadTableNhanVien (){
        listNhanVien = nhanVien_BUS.getAllNhanVien();
        String col[] = {"Mã nhân viên", "Tên nhân viên", "SDT", "Chức Vụ", "Tình trạng"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        tblDanhSachNV.setModel(tableModel);
        for(NhanVien_DTO row : listNhanVien){
            Object[] data = {row.ma(), row.hoTen(), row.sdt(), row.tenChucVu(), row.tinhTrangNhanVien()};
            tableModel.addRow(data);
        }
    }
    
    private void loadTableNhanVien(ArrayList<NhanVien_DTO> dataTable){

       listNhanVien = dataTable;
       String col[] = {"Mã nhân viên", "Tên nhân viên", "SDT", "Chức Vụ", "Tình Trạng"};
       DefaultTableModel tableModel = new DefaultTableModel(col, 0);
       tblDanhSachNV.setModel(tableModel);
       for(NhanVien_DTO row : listNhanVien){
            Object[] data = {row.ma(), row.hoTen(), row.sdt(), row.tenChucVu(), row.tinhTrangNhanVien()};
           tableModel.addRow(data);
       }
    }
    
    
    
    private void loadComboBoxChucVu(){
        listChucVu = chucVu_BUS.getAllChucVu();
        cmbThemChucVu.removeAllItems();
        cmbTimKiemChucVu.removeAllItems();
        for (ChucVu_DTO cv : listChucVu)
        {
            cmbThemChucVu.addItem(cv.getTen());
            cmbTimKiemChucVu.addItem(cv.getTen());
           
        }
        cmbThemChucVu.setSelectedIndex(-1);
        cmbTimKiemChucVu.setSelectedIndex(0);
    }
    
    private void loadComboBoxTinhTrangNhanVien(){
        listTinhTrangNhanVien = tinhTrangNhanVien_BUS.getAllLTinhTrangNhanVien();
        
        for(TinhTrangNhanVien_DTO ttnv : listTinhTrangNhanVien){
            cmbTinhTrangNV.addItem(ttnv.getTen());
        }        
        
        cmbTinhTrangNV.setSelectedIndex(-1);
    }
    
    private void clearTextViewNhanVien(){
        txtMaNV.setText("");
        txtDiaChiNV.setText("");
        txtEmailNV.setText("");
        txtHoTenNV.setText("");
        txtSDTNV.setText("");
        jdcNgaySinh.getDate();
        txtCCCD.setText("");
        cmbTinhTrangNV.setSelectedIndex(-1);
        cmbTimKiemChucVu.setSelectedIndex(-1);
        cmbGioiTinhNVThemSua.setSelectedIndex(-1);
        cmbThemChucVu.setSelectedIndex(-1);
    } 
    
    private void clearSearchBox(){
        txtMaOrTen.setText("");
        cmbTimKiemGioiTinhNhanVien.setSelectedIndex(0);
        cmbTimKiemChucVu.setSelectedIndex(0);    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaOrTen = new javax.swing.JTextField();
        cmbTimKiemGioiTinhNhanVien = new javax.swing.JComboBox<>();
        cmbTimKiemChucVu = new javax.swing.JComboBox<>();
        btnTimKiemNhanVien = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        cmbTinhTrangNhanVienSearch = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachNV = new javax.swing.JTable();
        btnResetTable = new javax.swing.JButton();
        btnImportNV = new javax.swing.JButton();
        btnExportMauImport = new javax.swing.JButton();
        btnExportNV = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnThemNV = new javax.swing.JButton();
        btnSuaNV = new javax.swing.JButton();
        btnXoaNV = new javax.swing.JButton();
        btnDoiMatKhau = new javax.swing.JButton();
        btnPhanQuyen = new javax.swing.JButton();
        pnlThemNhanVien = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtSDTNV = new javax.swing.JTextField();
        txtHoTenNV = new javax.swing.JTextField();
        txtEmailNV = new javax.swing.JTextField();
        txtDiaChiNV = new javax.swing.JTextField();
        cmbTinhTrangNV = new javax.swing.JComboBox<>();
        btnResetThemNV = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmbThemChucVu = new javax.swing.JComboBox<>();
        cmbGioiTinhNVThemSua = new javax.swing.JComboBox<>();
        jdcNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        txtCCCD = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        btnQuanLyChucVu = new javax.swing.JButton();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setPreferredSize(new java.awt.Dimension(514, 231));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Bộ lọc danh sách nhân viên"));
        jPanel2.setMaximumSize(new java.awt.Dimension(2147483647, 160));
        jPanel2.setMinimumSize(new java.awt.Dimension(604, 160));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 160));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Nhập Mã hoặc Tên");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 4);
        jPanel2.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Giới tính");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 4);
        jPanel2.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Chức Vụ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel2.add(jLabel3, gridBagConstraints);

        txtMaOrTen.setMinimumSize(new java.awt.Dimension(200, 22));
        txtMaOrTen.setPreferredSize(new java.awt.Dimension(250, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
        jPanel2.add(txtMaOrTen, gridBagConstraints);

        cmbTimKiemGioiTinhNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", "Nam", "Nữ" }));
        cmbTimKiemGioiTinhNhanVien.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel2.add(cmbTimKiemGioiTinhNhanVien, gridBagConstraints);

        cmbTimKiemChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cmbTimKiemChucVu.setMinimumSize(new java.awt.Dimension(120, 22));
        cmbTimKiemChucVu.setPreferredSize(new java.awt.Dimension(120, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
        jPanel2.add(cmbTimKiemChucVu, gridBagConstraints);

        btnTimKiemNhanVien.setText("Tìm kiếm");
        btnTimKiemNhanVien.setMaximumSize(new java.awt.Dimension(120, 22));
        btnTimKiemNhanVien.setMinimumSize(new java.awt.Dimension(120, 22));
        btnTimKiemNhanVien.setPreferredSize(new java.awt.Dimension(120, 22));
        btnTimKiemNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemNhanVienMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
        jPanel2.add(btnTimKiemNhanVien, gridBagConstraints);

        jLabel13.setText("Tình trạng nhân viên");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 4);
        jPanel2.add(jLabel13, gridBagConstraints);

        cmbTinhTrangNhanVienSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đang hoạt động", "Tạm nghỉ ", "Đã nghỉ" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        jPanel2.add(cmbTinhTrangNhanVienSearch, gridBagConstraints);

        jPanel1.add(jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách nhân viên"));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        tblDanhSachNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên nhân viên", "Số diện thoại", "Chức vụ", "Tình trạng"
            }
        )

    );
    tblDanhSachNV.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    tblDanhSachNV.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tblDanhSachNVMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            tblDanhSachNVMouseEntered(evt);
        }
    });
    jScrollPane1.setViewportView(tblDanhSachNV);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
    jPanel3.add(jScrollPane1, gridBagConstraints);

    btnResetTable.setText("Reset bảng");
    btnResetTable.setMaximumSize(new java.awt.Dimension(100, 24));
    btnResetTable.setMinimumSize(new java.awt.Dimension(100, 24));
    btnResetTable.setPreferredSize(new java.awt.Dimension(100, 24));
    btnResetTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btnResetTableMouseClicked(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 20);
    jPanel3.add(btnResetTable, gridBagConstraints);

    btnImportNV.setText("Import");
    btnImportNV.setMaximumSize(new java.awt.Dimension(80, 24));
    btnImportNV.setMinimumSize(new java.awt.Dimension(80, 24));
    btnImportNV.setPreferredSize(new java.awt.Dimension(80, 24));
    btnImportNV.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btnImportNVMouseClicked(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 12, 4);
    jPanel3.add(btnImportNV, gridBagConstraints);

    btnExportMauImport.setText("Export mẫu import");
    btnExportMauImport.setMaximumSize(new java.awt.Dimension(140, 24));
    btnExportMauImport.setMinimumSize(new java.awt.Dimension(140, 24));
    btnExportMauImport.setPreferredSize(new java.awt.Dimension(140, 24));
    btnExportMauImport.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btnExportMauImportMouseClicked(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 4, 12, 4);
    jPanel3.add(btnExportMauImport, gridBagConstraints);

    btnExportNV.setText("Export");
    btnExportNV.setMaximumSize(new java.awt.Dimension(80, 24));
    btnExportNV.setMinimumSize(new java.awt.Dimension(80, 24));
    btnExportNV.setPreferredSize(new java.awt.Dimension(80, 24));
    btnExportNV.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btnExportNVMouseClicked(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 4, 12, 4);
    jPanel3.add(btnExportNV, gridBagConstraints);

    jPanel1.add(jPanel3);

    add(jPanel1);

    jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.PAGE_AXIS));

    jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
    jPanel5.setMaximumSize(new java.awt.Dimension(2147483647, 160));
    jPanel5.setMinimumSize(new java.awt.Dimension(380, 160));
    jPanel5.setPreferredSize(new java.awt.Dimension(380, 160));
    jPanel5.setLayout(new java.awt.GridBagLayout());

    btnThemNV.setText("Thêm ");
    btnThemNV.setEnabled(false);
    btnThemNV.setMaximumSize(new java.awt.Dimension(120, 24));
    btnThemNV.setMinimumSize(new java.awt.Dimension(120, 24));
    btnThemNV.setPreferredSize(new java.awt.Dimension(120, 24));
    btnThemNV.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btnThemNVMouseClicked(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 0);
    jPanel5.add(btnThemNV, gridBagConstraints);

    btnSuaNV.setText("Sửa");
    btnSuaNV.setMaximumSize(new java.awt.Dimension(120, 24));
    btnSuaNV.setMinimumSize(new java.awt.Dimension(120, 24));
    btnSuaNV.setPreferredSize(new java.awt.Dimension(120, 24));
    btnSuaNV.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btnSuaNVMouseClicked(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 20);
    jPanel5.add(btnSuaNV, gridBagConstraints);

    btnXoaNV.setText("Xóa");
    btnXoaNV.setMaximumSize(new java.awt.Dimension(120, 24));
    btnXoaNV.setMinimumSize(new java.awt.Dimension(120, 24));
    btnXoaNV.setPreferredSize(new java.awt.Dimension(120, 24));
    btnXoaNV.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btnXoaNVMouseClicked(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    jPanel5.add(btnXoaNV, gridBagConstraints);

    btnDoiMatKhau.setText("Đổi mật khẩu");
    btnDoiMatKhau.setMaximumSize(new java.awt.Dimension(120, 24));
    btnDoiMatKhau.setMinimumSize(new java.awt.Dimension(120, 24));
    btnDoiMatKhau.setPreferredSize(new java.awt.Dimension(120, 24));
    btnDoiMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btnDoiMatKhauMouseClicked(evt);
        }
    });
    btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnDoiMatKhauActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 0);
    jPanel5.add(btnDoiMatKhau, gridBagConstraints);

    btnPhanQuyen.setText("Phân quyền tài khoản");
    btnPhanQuyen.setMinimumSize(new java.awt.Dimension(140, 24));
    btnPhanQuyen.setPreferredSize(new java.awt.Dimension(140, 24));
    btnPhanQuyen.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btnPhanQuyenMouseClicked(evt);
        }
    });
    btnPhanQuyen.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnPhanQuyenActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 20);
    jPanel5.add(btnPhanQuyen, gridBagConstraints);

    jPanel4.add(jPanel5);

    pnlThemNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder("Thêm nhân viên"));
    pnlThemNhanVien.setLayout(new java.awt.GridBagLayout());

    jLabel4.setText("Mã nhân viên");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 8);
    pnlThemNhanVien.add(jLabel4, gridBagConstraints);

    jLabel5.setText("Tình trạng");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 8);
    pnlThemNhanVien.add(jLabel5, gridBagConstraints);

    jLabel6.setText("Chức vụ");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 8);
    pnlThemNhanVien.add(jLabel6, gridBagConstraints);

    jLabel7.setText("Ngày sinh");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 8);
    pnlThemNhanVien.add(jLabel7, gridBagConstraints);

    jLabel8.setText("Họ tên");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 8);
    pnlThemNhanVien.add(jLabel8, gridBagConstraints);

    jLabel9.setText("Giới tính");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 8);
    pnlThemNhanVien.add(jLabel9, gridBagConstraints);

    jLabel10.setText("Email");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 8);
    pnlThemNhanVien.add(jLabel10, gridBagConstraints);

    txtMaNV.setPreferredSize(new java.awt.Dimension(150, 22));
    txtMaNV.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtMaNVActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    pnlThemNhanVien.add(txtMaNV, gridBagConstraints);

    txtSDTNV.setPreferredSize(new java.awt.Dimension(150, 22));
    txtSDTNV.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtSDTNVActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 7;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    pnlThemNhanVien.add(txtSDTNV, gridBagConstraints);

    txtHoTenNV.setMinimumSize(new java.awt.Dimension(72, 22));
    txtHoTenNV.setPreferredSize(new java.awt.Dimension(150, 22));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    pnlThemNhanVien.add(txtHoTenNV, gridBagConstraints);

    txtEmailNV.setPreferredSize(new java.awt.Dimension(150, 22));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    pnlThemNhanVien.add(txtEmailNV, gridBagConstraints);

    txtDiaChiNV.setPreferredSize(new java.awt.Dimension(150, 22));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    pnlThemNhanVien.add(txtDiaChiNV, gridBagConstraints);

    cmbTinhTrangNV.setPreferredSize(new java.awt.Dimension(150, 22));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    pnlThemNhanVien.add(cmbTinhTrangNV, gridBagConstraints);

    btnResetThemNV.setText("Reset");
    btnResetThemNV.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btnResetThemNVMouseClicked(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 10;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    pnlThemNhanVien.add(btnResetThemNV, gridBagConstraints);

    btnLuu.setText("Lưu");
    btnLuu.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btnLuuMouseClicked(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 10;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    pnlThemNhanVien.add(btnLuu, gridBagConstraints);

    jLabel11.setText("Địa chỉ");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 8);
    pnlThemNhanVien.add(jLabel11, gridBagConstraints);

    jLabel12.setText("SDT");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 7;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 8);
    pnlThemNhanVien.add(jLabel12, gridBagConstraints);

    cmbThemChucVu.setPreferredSize(new java.awt.Dimension(150, 22));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    pnlThemNhanVien.add(cmbThemChucVu, gridBagConstraints);

    cmbGioiTinhNVThemSua.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam ", "Nữ" }));
    cmbGioiTinhNVThemSua.setPreferredSize(new java.awt.Dimension(150, 22));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    pnlThemNhanVien.add(cmbGioiTinhNVThemSua, gridBagConstraints);

    jdcNgaySinh.setPreferredSize(new java.awt.Dimension(150, 22));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    pnlThemNhanVien.add(jdcNgaySinh, gridBagConstraints);

    jLabel14.setText("CCCD");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 9;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 8);
    pnlThemNhanVien.add(jLabel14, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 9;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 20);
    pnlThemNhanVien.add(txtCCCD, gridBagConstraints);

    jPanel4.add(pnlThemNhanVien);

    jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng khác"));
    jPanel7.setMaximumSize(new java.awt.Dimension(2147483647, 60));
    jPanel7.setMinimumSize(new java.awt.Dimension(157, 60));
    jPanel7.setPreferredSize(new java.awt.Dimension(157, 60));
    jPanel7.setLayout(new java.awt.GridBagLayout());

    btnQuanLyChucVu.setText("Quản lý chức vụ");
    btnQuanLyChucVu.setMaximumSize(new java.awt.Dimension(140, 24));
    btnQuanLyChucVu.setMinimumSize(new java.awt.Dimension(140, 24));
    btnQuanLyChucVu.setPreferredSize(new java.awt.Dimension(140, 24));
    btnQuanLyChucVu.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btnQuanLyChucVuMouseClicked(evt);
        }
    });
    btnQuanLyChucVu.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnQuanLyChucVuActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(4, 4, 12, 4);
    jPanel7.add(btnQuanLyChucVu, gridBagConstraints);

    jPanel4.add(jPanel7);

    add(jPanel4);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemNhanVienMouseClicked
        // TODO add your handling code here:
        SearchNhanVien_DTO searchNhanVien_DTO = new SearchNhanVien_DTO();

        String maOrName = txtMaOrTen.getText();
        if(!maOrName.isBlank()){
            searchNhanVien_DTO.setMaOrhoTen(maOrName.trim());
        }

        int idChucVu = cmbTimKiemChucVu.getSelectedIndex();
        if(idChucVu > 0){
            searchNhanVien_DTO.setChucVu(listChucVu.get(idChucVu -1).getId());
        }

        int gioiTinh = cmbTimKiemGioiTinhNhanVien.getSelectedIndex();
        switch (gioiTinh) {
            case 1 -> searchNhanVien_DTO.setGioiTinh(GioiTinhConstraints.NAM);
            case 2 -> searchNhanVien_DTO.setGioiTinh(GioiTinhConstraints.NU);
            default -> searchNhanVien_DTO.setGioiTinh(-1);
        }

        int tinhTrangNhanVien = cmbTinhTrangNhanVienSearch.getSelectedIndex();
        switch (tinhTrangNhanVien) {
            case 0 -> searchNhanVien_DTO.setTinhTrang(new int[]{
                TinhTrangNhanVienConstraints.DANG_HOAT_DONG,
                TinhTrangNhanVienConstraints.TAM_NGHI});

        case 1 -> searchNhanVien_DTO.setTinhTrang(new int[]{
            TinhTrangNhanVienConstraints.DANG_HOAT_DONG});

    case 2 -> searchNhanVien_DTO.setTinhTrang(new int[]{
        TinhTrangNhanVienConstraints.TAM_NGHI});

        case 3 -> searchNhanVien_DTO.setTinhTrang(new int[]{
            TinhTrangNhanVienConstraints.DA_NGHI});
    }

    ArrayList<NhanVien_DTO> result = nhanVien_BUS.searchNhanVien(searchNhanVien_DTO);
    loadTableNhanVien(result);
    }//GEN-LAST:event_btnTimKiemNhanVienMouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseClicked

    private void tblDanhSachNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachNVMouseClicked
        // TODO add your handling code here:
        if(dangThemNhanVien){
            return;
        }

        int index = tblDanhSachNV.getSelectedRow();
        TableModel model = tblDanhSachNV.getModel();

        String ma = model.getValueAt(index, 0).toString().trim();
        NhanVienFull_DTO result = nhanVien_BUS.getNhanVienbyMa(ma);

        if(result == null){
            JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int indexChucVu = -1;
        for (int i = 0; i < listChucVu.size(); i++) {
            if(result.getChucVu().getId() == listChucVu.get(i).getId())
            indexChucVu = i;
        }
        int indexTinhTrangNhanVien = -1;
        for (int i = 0; i < listTinhTrangNhanVien.size(); i++) {
            if(result.getTinhTrangNhanVien().getId() == listTinhTrangNhanVien.get(i).getId())
            indexTinhTrangNhanVien = i;
        }

        if(indexChucVu == -1 || indexTinhTrangNhanVien == -1){
            JOptionPane.showMessageDialog(this, "Dữ liệu bị lỗi","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int gioitinh = 1;

        txtMaNV.setText(result.getMa());
        txtHoTenNV.setText(result.getHoTen());
        txtDiaChiNV.setText(result.getDiaChi());
        txtEmailNV.setText(result.getEmail());
        txtSDTNV.setText(result.getSoDienThoai());
        jdcNgaySinh.setDate(result.getNgaySinh());
        txtCCCD.setText(result.getCCCD());
        if (result.isGioiTinhNam())
        {
            gioitinh = 0;
        }
        cmbGioiTinhNVThemSua.setSelectedIndex(gioitinh);
        cmbThemChucVu.setSelectedIndex(indexChucVu);
        cmbTinhTrangNV.setSelectedIndex(indexTinhTrangNhanVien);
        btnLuu.setEnabled(true);

    }//GEN-LAST:event_tblDanhSachNVMouseClicked

    private void tblDanhSachNVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachNVMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDanhSachNVMouseEntered

    private void btnResetTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetTableMouseClicked
        // TODO add your handling code here:
        loadTableNhanVien();
        clearSearchBox();
    }//GEN-LAST:event_btnResetTableMouseClicked

    private void btnThemNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemNVMouseClicked
        // TODO add your handling code here:
        btnThemNV.setEnabled(false);
        btnSuaNV.setEnabled(true);
        dangThemNhanVien = true;
        cmbGioiTinhNVThemSua.setEnabled(true);
        jdcNgaySinh.setEnabled(true);
        txtMaNV.setEnabled(true);
        txtCCCD.setEnabled(true);
        pnlThemNhanVien.setBorder(BorderFactory.createTitledBorder("Thêm nhân viên mới"));
        pnlThemNhanVien.repaint();
        clearTextViewNhanVien();
        btnLuu.setEnabled(true);
        
    }//GEN-LAST:event_btnThemNVMouseClicked

    private void btnSuaNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaNVMouseClicked
        // TODO add your handling code here:
        btnThemNV.setEnabled(true);
        btnSuaNV.setEnabled(false);
        dangThemNhanVien = false;
        cmbGioiTinhNVThemSua.setEnabled(false);
        jdcNgaySinh.setEnabled(false);
        txtCCCD.setEnabled(false);
        pnlThemNhanVien.setBorder(BorderFactory.createTitledBorder("Sửa nhân viên "));
        pnlThemNhanVien.repaint();
        txtMaNV.setEnabled(false);
        clearTextViewNhanVien();
        btnLuu.setEnabled(false);
    }//GEN-LAST:event_btnSuaNVMouseClicked

    private void btnXoaNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaNVMouseClicked
        // TODO add your handling code here:
        int total = tblDanhSachNV.getSelectedRowCount();
        TableModel model = tblDanhSachNV.getModel();
        if(total < 1){
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn nhân viên muốn xóa","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null,
            "Bạn có chắc chắn muốn xóa " + total + " nhân viên không ?", "Xóa dữ liệu nhân viên!", JOptionPane.OK_CANCEL_OPTION);

        if(confirm == JOptionPane.CANCEL_OPTION)
        return;

        int index = tblDanhSachNV.getSelectedRow();

        String ma = model.getValueAt(index, 0).toString();

        boolean result = nhanVien_BUS.deleteNhanVien(ma);
        if(result){
            JOptionPane.showMessageDialog(this, "Xóa 1 nhân viên thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);

        }
        else
        JOptionPane.showMessageDialog(this, "Xóa thất bại","Error", JOptionPane.ERROR_MESSAGE);

        clearTextViewNhanVien();
        loadTableNhanVien();
    }//GEN-LAST:event_btnXoaNVMouseClicked

    private void txtMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNVActionPerformed

    private void txtSDTNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTNVActionPerformed

    private void btnResetThemNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetThemNVMouseClicked
        // TODO add your handling code here:
        loadComboBoxChucVu();
        
        if(dangThemNhanVien){
            cmbGioiTinhNVThemSua.setSelectedIndex(-1);
            cmbTinhTrangNV.setSelectedIndex(-1);
        } else {
            String ma = txtMaNV.getText();
            NhanVienFull_DTO result = nhanVien_BUS.getNhanVienbyMa(ma);

            if(result == null){
                JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int indexChucVu = -1;
            for (int i = 0; i < listChucVu.size(); i++) {
                if(result.getChucVu().getId() == listChucVu.get(i).getId())
                indexChucVu = i;
            }
            int indexTinhTrangNhanVien = -1;
            for (int i = 0; i < listTinhTrangNhanVien.size(); i++) {
                if(result.getTinhTrangNhanVien().getId() == listTinhTrangNhanVien.get(i).getId())
                indexTinhTrangNhanVien = i;
            }

            if(indexChucVu == -1 || indexTinhTrangNhanVien == -1){
                JOptionPane.showMessageDialog(this, "Dữ liệu bị lỗi","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int gioitinh = 0;

            txtMaNV.setText(result.getMa());
            txtHoTenNV.setText(result.getHoTen());
            txtDiaChiNV.setText(result.getDiaChi());
            txtEmailNV.setText(result.getEmail());
            txtSDTNV.setText(result.getSoDienThoai());
            if (!(result.isGioiTinhNam()))
            {
                gioitinh = 1;
            }
            cmbGioiTinhNVThemSua.setSelectedIndex(gioitinh);
            cmbThemChucVu.setSelectedIndex(indexChucVu);
            cmbTinhTrangNV.setSelectedIndex(indexTinhTrangNhanVien);
        }
    }//GEN-LAST:event_btnResetThemNVMouseClicked

    private void btnLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuMouseClicked
        // TODO add your handling code here:
        int indexChucVu = cmbThemChucVu.getSelectedIndex();
        if(indexChucVu < 0)
        JOptionPane.showMessageDialog(this, "Chưa chọn chức vụ","Error", JOptionPane.ERROR_MESSAGE);

        int indexTinhTrangNhanVien = cmbTinhTrangNV.getSelectedIndex();
        if(indexTinhTrangNhanVien < 0)
        JOptionPane.showMessageDialog(this, "Chưa chọn tình trạng nhân viên","Error", JOptionPane.ERROR_MESSAGE);

        int idChucVu = listChucVu.get(indexChucVu).getId();
        int idTinhTrangNhanVien = listTinhTrangNhanVien.get(indexTinhTrangNhanVien).getId();

        String ma = txtMaNV.getText().trim();
        if(ma.isBlank())
        JOptionPane.showMessageDialog(this, "Mã nhân viên không được để trống","Error", JOptionPane.ERROR_MESSAGE);

        String hoTen = txtHoTenNV.getText().trim();
        if(hoTen.isBlank())
        JOptionPane.showMessageDialog(this, "Tên nhân viên không được để trống","Error", JOptionPane.ERROR_MESSAGE);

        String diaChi = txtDiaChiNV.getText().trim();
        if(diaChi.isBlank())
        JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống","Error", JOptionPane.ERROR_MESSAGE);

        String email = txtEmailNV.getText().trim();
        if(!CheckHopLe.checkEmail(email)){
            JOptionPane.showMessageDialog(this, "Email không hợp lệ","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sdt = txtSDTNV.getText().trim();
        if(!CheckHopLe.checkSoDienThoai(sdt)){
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean gioiTinhNam = false;
        if (cmbGioiTinhNVThemSua.getSelectedIndex() == 0){
            gioiTinhNam = true;
        }

        Date ngaySinh = jdcNgaySinh.getDate();
        int tuoi = Period.between(ngaySinh.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears();
        if(tuoi < 18){
            JOptionPane.showMessageDialog(this, "Nhân viên phải từ 18 tuổi trở lên","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String CCCD = txtCCCD.getText();
        if(!CheckHopLe.checkCCCD(CCCD)){
            JOptionPane.showMessageDialog(this, "CCCD sai định dạng","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (dangThemNhanVien){
            CreateNhanVien_DTO data = new CreateNhanVien_DTO(ma, idTinhTrangNhanVien, idChucVu, hoTen, ngaySinh, gioiTinhNam, email, sdt, diaChi, CCCD);

            boolean result = nhanVien_BUS.createNhanVien(data);
            if(result){
                JOptionPane.showMessageDialog(this, "Thêm nhân viên mới thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                clearTextViewNhanVien();
                loadTableNhanVien();
            }
            else
            JOptionPane.showMessageDialog(this, "Thêm nhân viên mới thất bại, check lại thông tin đã thêm","Error", JOptionPane.ERROR_MESSAGE);
        } else {
            UpdateNhanVien_DTO data = new UpdateNhanVien_DTO(ma, idTinhTrangNhanVien, idChucVu, hoTen, email, sdt, diaChi);

            boolean result = nhanVien_BUS.updateNhanVien(data);
            if(result){
                JOptionPane.showMessageDialog(this, "Sửa nhân viên thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                loadTableNhanVien();
            }
            else
            JOptionPane.showMessageDialog(this, "Sửa nhân viên thất bại","Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLuuMouseClicked

    private void btnQuanLyChucVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyChucVuMouseClicked
        // TODO add your handling code here:
         if(quanLyChucVu_GUI == null || !quanLyChucVu_GUI.isDisplayable()){
            quanLyChucVu_GUI = new QuanLyChucVu_GUI();
            quanLyChucVu_GUI.setVisible(true);
            quanLyChucVu_GUI.btnLuuChucVu.addActionListener(e -> loadComboBoxChucVu());
        } else {
            quanLyChucVu_GUI.setState(JFrame.NORMAL);
            quanLyChucVu_GUI.toFront();
        }
    }//GEN-LAST:event_btnQuanLyChucVuMouseClicked

    private void btnQuanLyChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyChucVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLyChucVuActionPerformed

    private void btnImportNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImportNVMouseClicked
        // TODO add your handling code here:
        int totalSuccess = 0;

        JFileChooser jFileChooser = new JFileChooser("D:");
        if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            totalSuccess = nhanVien_BUS.importNhanVien(jFileChooser.getSelectedFile().getAbsolutePath());

            JOptionPane.showMessageDialog(this, "Cập nhật " + totalSuccess + " nhân viên","Import danh sách nhân viên", JOptionPane.INFORMATION_MESSAGE);

            loadTableNhanVien();
        }else {
            JOptionPane.showMessageDialog(this, "Import file excel thất bại","Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnImportNVMouseClicked

    private void btnExportNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportNVMouseClicked
        // TODO add your handling code here:
        boolean result = false;
        JFileChooser jFileChooser = new JFileChooser("D:");
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (jFileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            result = nhanVien_BUS.exportNhanVien(listNhanVien, jFileChooser.getSelectedFile().getAbsolutePath());
        }

        if (!result) {
            JOptionPane.showMessageDialog(this, "Xuất file excel thất bại","Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExportNVMouseClicked

    private void btnPhanQuyenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPhanQuyenMouseClicked
        // TODO add your handling code here:
        int total = tblDanhSachNV.getSelectedRowCount();
        TableModel model = tblDanhSachNV.getModel();
        if(total < 1){
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn nhân viên muốn phân quyền","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int index = tblDanhSachNV.getSelectedRow();
        String ma = model.getValueAt(index, 0).toString();

        if(quanLyQuyen_GUI == null || !quanLyQuyen_GUI.isDisplayable()){
            quanLyQuyen_GUI = new QuanLyQuyen_GUI(ma);
            quanLyQuyen_GUI.setVisible(true);
        } else {
            quanLyQuyen_GUI.setState(JFrame.NORMAL);
            quanLyQuyen_GUI.toFront();
        }
    }//GEN-LAST:event_btnPhanQuyenMouseClicked

    private void btnPhanQuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhanQuyenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPhanQuyenActionPerformed

    private void btnDoiMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoiMatKhauMouseClicked
        // TODO add your handling code here:
        int total = tblDanhSachNV.getSelectedRowCount();
        TableModel model = tblDanhSachNV.getModel();
        if(total < 1){
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn nhân viên muốn đổi mật khẩu","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int index = tblDanhSachNV.getSelectedRow();
        String ma = model.getValueAt(index, 0).toString();

        if(doiMatKhau_GUI == null || !doiMatKhau_GUI.isDisplayable()){
            doiMatKhau_GUI = new DoiMatKhau_GUI(ma);
            doiMatKhau_GUI.setVisible(true);
        } else {
            doiMatKhau_GUI.setState(JFrame.NORMAL);
            doiMatKhau_GUI.toFront();
        }
    }//GEN-LAST:event_btnDoiMatKhauMouseClicked

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

    private void btnExportMauImportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportMauImportMouseClicked
        // TODO add your handling code here:
        boolean result = false;

        JFileChooser jFileChooser = new JFileChooser("D:");
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (jFileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            result = nhanVien_BUS.exportAllNhanVienTheoMauImport(jFileChooser.getSelectedFile().getAbsolutePath());
        }

        if (!result) {
            JOptionPane.showMessageDialog(this, "Export file excel thất bại","Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExportMauImportMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnExportMauImport;
    private javax.swing.JButton btnExportNV;
    private javax.swing.JButton btnImportNV;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnPhanQuyen;
    private javax.swing.JButton btnQuanLyChucVu;
    private javax.swing.JButton btnResetTable;
    private javax.swing.JButton btnResetThemNV;
    private javax.swing.JButton btnSuaNV;
    private javax.swing.JButton btnThemNV;
    private javax.swing.JButton btnTimKiemNhanVien;
    private javax.swing.JButton btnXoaNV;
    private javax.swing.JComboBox<String> cmbGioiTinhNVThemSua;
    private javax.swing.JComboBox<String> cmbThemChucVu;
    private javax.swing.JComboBox<String> cmbTimKiemChucVu;
    private javax.swing.JComboBox<String> cmbTimKiemGioiTinhNhanVien;
    private javax.swing.JComboBox<String> cmbTinhTrangNV;
    private javax.swing.JComboBox<String> cmbTinhTrangNhanVienSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcNgaySinh;
    private javax.swing.JPanel pnlThemNhanVien;
    private javax.swing.JTable tblDanhSachNV;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtDiaChiNV;
    private javax.swing.JTextField txtEmailNV;
    private javax.swing.JTextField txtHoTenNV;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaOrTen;
    private javax.swing.JTextField txtSDTNV;
    // End of variables declaration//GEN-END:variables
}
