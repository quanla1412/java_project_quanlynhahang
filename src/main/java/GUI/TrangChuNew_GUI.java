/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;


import BUS.NhanVien_BUS;
import BUS.QuyenTaiKhoan_BUS;
import Constraints.ChucNangConstraints;
import DTO.NhanVien.NhanVienFull_DTO;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JComponent;
import javax.swing.JPanel;
import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.swing.FontIcon;

/**
 *
 * @author tanph
 */
public class TrangChuNew_GUI extends javax.swing.JFrame {

    private final QuyenTaiKhoan_BUS quyenTaiKhoan_BUS;    
    private final NhanVien_BUS nhanVien_BUS;

    
    private final String maNhanVien;
    private final ArrayList<Integer> listQuyen;
    private NhanVienFull_DTO nhanVien;
    
    public TrangChuNew_GUI(String maNhanVien) {
        initComponents();
        quyenTaiKhoan_BUS = new QuyenTaiKhoan_BUS();
        nhanVien_BUS = new NhanVien_BUS();
        
        prepareIcon();
        btnQuanLyPhucVu.setBackground(new java.awt.Color(0,0,0,100));
        this.maNhanVien = maNhanVien;
        nhanVien = nhanVien_BUS.getNhanVienbyMa(maNhanVien);
        listQuyen = quyenTaiKhoan_BUS.getAllQuyenByMaNV(maNhanVien);
        
        lblTenNhanVien.setText(nhanVien.getHoTen());
        
        checkQuyen();
    }

    class jPanelGradient extends JPanel {

        @Override
        protected void paintComponent(Graphics grphcs) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            GradientPaint g = new GradientPaint(0,0,Color.decode("#26D0CE"),0, getHeight(),Color.decode("#1A2980"));
            g2.setPaint(g);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        }
    }
    
    private void showForm(JComponent com){
        pnlForm.removeAll();
        pnlForm.add(com);
        pnlForm.repaint();
        pnlForm.revalidate();
    }
    
     private void resetColorButton(){
        btnQuanLyPhucVu.setBackground(new java.awt.Color(0,0,0,0));
        btnQuanLyBan.setBackground(new java.awt.Color(0,0,0,0));
        btnQuanLyMonAn.setBackground(new java.awt.Color(0,0,0,0));
        btnQuanLyHoaDon.setBackground(new java.awt.Color(0,0,0,0));
        btnQuanLyNhanVien.setBackground(new java.awt.Color(0,0,0,0));
        btnQuanLyKhachHang.setBackground(new java.awt.Color(0,0,0,0));
        btnBaoCaoThongKe.setBackground(new java.awt.Color(0,0,0,0));
        btnDangXuat.setBackground(new java.awt.Color(0,0,0,0));
    }
    
    private void prepareIcon() {
        FontIcon iconAvatarNhanVien = FontIcon.of(MaterialDesign.MDI_ACCOUNT_CIRCLE,32,Color.WHITE);
        FontIcon iconQuanLyPhucVu = FontIcon.of(MaterialDesign.MDI_FOOD_FORK_DRINK,28,Color.WHITE);
        FontIcon iconQuanLyBan = FontIcon.of(MaterialDesign.MDI_TABLE,28,Color.WHITE);
        FontIcon iconQuanLyMonAn = FontIcon.of(MaterialDesign.MDI_FOOD,28,Color.WHITE);
        FontIcon iconQuanLyHoaDon = FontIcon.of(MaterialDesign.MDI_LIBRARY_BOOKS,28,Color.WHITE);
        FontIcon iconQuanLyNhanVien = FontIcon.of(MaterialDesign.MDI_ACCOUNT,28,Color.WHITE);
        FontIcon iconQuanLyKhachHang = FontIcon.of(MaterialDesign.MDI_ACCOUNT_MULTIPLE,28,Color.WHITE);
        FontIcon iconBaoCaoThongKe = FontIcon.of(MaterialDesign.MDI_CHART_LINE,28,Color.WHITE);
        FontIcon iconDangXuat = FontIcon.of(MaterialDesign.MDI_LOGOUT,28,Color.WHITE);
        
        lblTenNhanVien.setIcon(iconAvatarNhanVien);
        btnQuanLyPhucVu.setIcon(iconQuanLyPhucVu);
        btnQuanLyBan.setIcon(iconQuanLyBan);
        btnQuanLyMonAn.setIcon(iconQuanLyMonAn);
        btnQuanLyHoaDon.setIcon(iconQuanLyHoaDon);
        btnQuanLyNhanVien.setIcon(iconQuanLyNhanVien);
        btnQuanLyKhachHang.setIcon(iconQuanLyKhachHang);
        btnBaoCaoThongKe.setIcon(iconBaoCaoThongKe);
        btnDangXuat.setIcon(iconDangXuat);

    }
    
    private void checkQuyen(){
        if(!listQuyen.contains(ChucNangConstraints.QUAN_LY_PHUC_VU))
            pnlMenu.remove(btnQuanLyPhucVu);
        if(!listQuyen.contains(ChucNangConstraints.QUAN_LY_BAN))
            pnlMenu.remove(btnQuanLyBan);
        if(!listQuyen.contains(ChucNangConstraints.QUAN_LY_MON_AN))
            pnlMenu.remove(btnQuanLyMonAn);
        if(!listQuyen.contains(ChucNangConstraints.QUAN_LY_HOA_DON))
            pnlMenu.remove(btnQuanLyHoaDon);
        if(!listQuyen.contains(ChucNangConstraints.QUAN_LY_NHAN_VIEN))
            pnlMenu.remove(btnQuanLyNhanVien);
        if(!listQuyen.contains(ChucNangConstraints.QUAN_LY_KHACH_HANG))
            pnlMenu.remove(btnQuanLyKhachHang);
        if(!listQuyen.contains(ChucNangConstraints.QUAN_LY_THONG_KE))
            pnlMenu.remove(btnBaoCaoThongKe);
        
        int selectedDefault = !listQuyen.isEmpty() ? Collections.min(listQuyen) : -1;
        
        switch (selectedDefault) {
            case ChucNangConstraints.QUAN_LY_PHUC_VU:
                btnQuanLyPhucVu.setBackground(new java.awt.Color(0,0,0,100));
                showForm(new QuanLyPhucVu_GUI(maNhanVien));                
                break;
            case ChucNangConstraints.QUAN_LY_BAN:
                btnQuanLyBan.setBackground(new java.awt.Color(0,0,0,100));
                showForm(new QuanLyLoaiBanVaBan_GUI());                
                break;
            case ChucNangConstraints.QUAN_LY_MON_AN:
                btnQuanLyMonAn.setBackground(new java.awt.Color(0,0,0,100));
                showForm(new QuanLyMonAn_GUI());                
                break;
            case ChucNangConstraints.QUAN_LY_HOA_DON:
                btnQuanLyHoaDon.setBackground(new java.awt.Color(0,0,0,100));
                showForm(new QuanLyHoaDon_GUI());                
                break;
            case ChucNangConstraints.QUAN_LY_NHAN_VIEN:
                btnQuanLyNhanVien.setBackground(new java.awt.Color(0,0,0,100));
                showForm(new QuanLyNhanVien_GUI());                
                break;
            case ChucNangConstraints.QUAN_LY_KHACH_HANG:
                btnQuanLyKhachHang.setBackground(new java.awt.Color(0,0,0,100));
                showForm(new QuanLyKhachHang_GUI());                
                break;
            case ChucNangConstraints.QUAN_LY_THONG_KE:
                btnBaoCaoThongKe.setBackground(new java.awt.Color(0,0,0,100));
                showForm(new BaoCaoThongKe_GUI());                
                break;
            default:
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlForm = new javax.swing.JPanel();
        pnlMenu = new jPanelGradient();
        lblLogo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblTenNhanVien = new javax.swing.JLabel();
        btnQuanLyPhucVu = new javax.swing.JButton();
        btnQuanLyBan = new javax.swing.JButton();
        btnQuanLyMonAn = new javax.swing.JButton();
        btnQuanLyHoaDon = new javax.swing.JButton();
        btnQuanLyNhanVien = new javax.swing.JButton();
        btnQuanLyKhachHang = new javax.swing.JButton();
        btnBaoCaoThongKe = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1300, 720));

        pnlForm.setMinimumSize(new java.awt.Dimension(800, 400));
        pnlForm.setPreferredSize(new java.awt.Dimension(800, 400));
        pnlForm.setLayout(new java.awt.BorderLayout());

        pnlMenu.setMinimumSize(new java.awt.Dimension(240, 502));
        pnlMenu.setPreferredSize(new java.awt.Dimension(240, 502));

        lblLogo.setBackground(new java.awt.Color(255, 255, 255));
        lblLogo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setText("Borcelle Restaurant");
        lblLogo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setName(""); // NOI18N

        lblTenNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lblTenNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenNhanVien.setText("Phan Hoàng Nhật Tân");
        lblTenNhanVien.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblTenNhanVien.setIconTextGap(8);

        btnQuanLyPhucVu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnQuanLyPhucVu.setForeground(new java.awt.Color(255, 255, 255));
        btnQuanLyPhucVu.setText("Quản Lý Phục Vụ");
        btnQuanLyPhucVu.setToolTipText("");
        btnQuanLyPhucVu.setBorderPainted(false);
        btnQuanLyPhucVu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnQuanLyPhucVu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQuanLyPhucVu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnQuanLyPhucVu.setIconTextGap(12);
        //jButton1.setBorder(null);
        //jButton1.setBorder(new java.awt.Color(0,0,0,1));
        btnQuanLyPhucVu.setBackground(new java.awt.Color(0,0,0,1));
        //jButton1.setContentAreaFilled(false);
        btnQuanLyPhucVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLyPhucVuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnQuanLyPhucVuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnQuanLyPhucVuMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnQuanLyPhucVuMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnQuanLyPhucVuMouseReleased(evt);
            }
        });

        btnQuanLyBan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnQuanLyBan.setForeground(new java.awt.Color(255, 255, 255));
        btnQuanLyBan.setText("Quản Lý Bàn");
        btnQuanLyBan.setToolTipText("");
        btnQuanLyBan.setBorderPainted(false);
        btnQuanLyBan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnQuanLyBan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQuanLyBan.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnQuanLyBan.setIconTextGap(12);
        btnQuanLyBan.setBackground(new java.awt.Color(0,0,0,1));
        btnQuanLyBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLyBanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnQuanLyBanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnQuanLyBanMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnQuanLyBanMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnQuanLyBanMouseReleased(evt);
            }
        });

        btnQuanLyMonAn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnQuanLyMonAn.setForeground(new java.awt.Color(255, 255, 255));
        btnQuanLyMonAn.setText("Quản Lý Món Ăn");
        btnQuanLyMonAn.setToolTipText("");
        btnQuanLyMonAn.setBorderPainted(false);
        btnQuanLyMonAn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnQuanLyMonAn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQuanLyMonAn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnQuanLyMonAn.setIconTextGap(12);
        btnQuanLyMonAn.setBackground(new java.awt.Color(0,0,0,1));
        btnQuanLyMonAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLyMonAnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnQuanLyMonAnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnQuanLyMonAnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnQuanLyMonAnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnQuanLyMonAnMouseReleased(evt);
            }
        });

        btnQuanLyHoaDon.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnQuanLyHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnQuanLyHoaDon.setText("Quản Lý Hoá Đơn");
        btnQuanLyHoaDon.setToolTipText("");
        btnQuanLyHoaDon.setBorderPainted(false);
        btnQuanLyHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnQuanLyHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQuanLyHoaDon.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnQuanLyHoaDon.setIconTextGap(12);
        btnQuanLyHoaDon.setBackground(new java.awt.Color(0,0,0,1));
        btnQuanLyHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLyHoaDonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnQuanLyHoaDonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnQuanLyHoaDonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnQuanLyHoaDonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnQuanLyHoaDonMouseReleased(evt);
            }
        });

        btnQuanLyNhanVien.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnQuanLyNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnQuanLyNhanVien.setText("Quản Lý Nhân Viên");
        btnQuanLyNhanVien.setToolTipText("");
        btnQuanLyNhanVien.setBorderPainted(false);
        btnQuanLyNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnQuanLyNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQuanLyNhanVien.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnQuanLyNhanVien.setIconTextGap(12);
        btnQuanLyNhanVien.setBackground(new java.awt.Color(0,0,0,1));
        btnQuanLyNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLyNhanVienMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnQuanLyNhanVienMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnQuanLyNhanVienMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnQuanLyNhanVienMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnQuanLyNhanVienMouseReleased(evt);
            }
        });

        btnQuanLyKhachHang.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnQuanLyKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        btnQuanLyKhachHang.setText("Quản Lý Khách Hàng");
        btnQuanLyKhachHang.setToolTipText("");
        btnQuanLyKhachHang.setBorderPainted(false);
        btnQuanLyKhachHang.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnQuanLyKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQuanLyKhachHang.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnQuanLyKhachHang.setIconTextGap(12);
        btnQuanLyKhachHang.setBackground(new java.awt.Color(0,0,0,1));
        btnQuanLyKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLyKhachHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnQuanLyKhachHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnQuanLyKhachHangMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnQuanLyKhachHangMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnQuanLyKhachHangMouseReleased(evt);
            }
        });
        btnQuanLyKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyKhachHangActionPerformed(evt);
            }
        });

        btnBaoCaoThongKe.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnBaoCaoThongKe.setForeground(new java.awt.Color(255, 255, 255));
        btnBaoCaoThongKe.setText("Báo Cáo & Thống Kê");
        btnBaoCaoThongKe.setToolTipText("");
        btnBaoCaoThongKe.setBorderPainted(false);
        btnBaoCaoThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBaoCaoThongKe.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBaoCaoThongKe.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnBaoCaoThongKe.setIconTextGap(12);
        btnBaoCaoThongKe.setBackground(new java.awt.Color(0,0,0,1));
        btnBaoCaoThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBaoCaoThongKeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBaoCaoThongKeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBaoCaoThongKeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBaoCaoThongKeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnBaoCaoThongKeMouseReleased(evt);
            }
        });

        btnDangXuat.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        btnDangXuat.setText("Đăng Xuất");
        btnDangXuat.setToolTipText("");
        btnDangXuat.setBorderPainted(false);
        btnDangXuat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDangXuat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDangXuat.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnDangXuat.setIconTextGap(12);
        btnDangXuat.setBackground(new java.awt.Color(0,0,0,1));
        btnDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDangXuatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDangXuatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDangXuatMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDangXuatMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDangXuatMouseReleased(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQuanLyPhucVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuanLyBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuanLyMonAn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuanLyHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuanLyNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuanLyKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBaoCaoThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTenNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuanLyPhucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuanLyBan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuanLyMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuanLyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuanLyKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBaoCaoThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(pnlForm, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuanLyPhucVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyPhucVuMouseClicked
        resetColorButton();
        btnQuanLyPhucVu.setBackground(new java.awt.Color(0,0,0,100));
        showForm(new QuanLyPhucVu_GUI(maNhanVien));
    }//GEN-LAST:event_btnQuanLyPhucVuMouseClicked

    private void btnQuanLyPhucVuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyPhucVuMouseEntered
        //        jButton1.setBackground(new java.awt.Color(0,0,0,40));
        //        over = true;
    }//GEN-LAST:event_btnQuanLyPhucVuMouseEntered

    private void btnQuanLyPhucVuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyPhucVuMouseExited
        //        jButton1.setBackground(new java.awt.Color(0,0,0,0));
        //        over = false;
    }//GEN-LAST:event_btnQuanLyPhucVuMouseExited

    private void btnQuanLyPhucVuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyPhucVuMousePressed
        //        jButton1.setBackground(new java.awt.Color(0,0,0,100));
    }//GEN-LAST:event_btnQuanLyPhucVuMousePressed

    private void btnQuanLyPhucVuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyPhucVuMouseReleased
        //        if (over) {
            //            jButton1.setBackground(new java.awt.Color(0,0,0,100));
            //        } else {
            //            jButton1.setBackground(new java.awt.Color(0,0,0,0));
            //        }
    }//GEN-LAST:event_btnQuanLyPhucVuMouseReleased

    private void btnQuanLyBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyBanMouseClicked
        resetColorButton();
        btnQuanLyBan.setBackground(new java.awt.Color(0,0,0,100));
        showForm(new QuanLyLoaiBanVaBan_GUI());
    }//GEN-LAST:event_btnQuanLyBanMouseClicked

    private void btnQuanLyBanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyBanMouseEntered

    }//GEN-LAST:event_btnQuanLyBanMouseEntered

    private void btnQuanLyBanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyBanMouseExited

    }//GEN-LAST:event_btnQuanLyBanMouseExited

    private void btnQuanLyBanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyBanMousePressed

    }//GEN-LAST:event_btnQuanLyBanMousePressed

    private void btnQuanLyBanMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyBanMouseReleased

    }//GEN-LAST:event_btnQuanLyBanMouseReleased

    private void btnQuanLyMonAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyMonAnMouseClicked
        resetColorButton();
        btnQuanLyMonAn.setBackground(new java.awt.Color(0,0,0,100));
        showForm(new QuanLyMonAn_GUI());
    }//GEN-LAST:event_btnQuanLyMonAnMouseClicked

    private void btnQuanLyMonAnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyMonAnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLyMonAnMouseEntered

    private void btnQuanLyMonAnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyMonAnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLyMonAnMouseExited

    private void btnQuanLyMonAnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyMonAnMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLyMonAnMousePressed

    private void btnQuanLyMonAnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyMonAnMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLyMonAnMouseReleased

    private void btnQuanLyHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyHoaDonMouseClicked
        resetColorButton();
        btnQuanLyHoaDon.setBackground(new java.awt.Color(0,0,0,100));
        showForm(new QuanLyHoaDon_GUI());
    }//GEN-LAST:event_btnQuanLyHoaDonMouseClicked

    private void btnQuanLyHoaDonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyHoaDonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLyHoaDonMouseEntered

    private void btnQuanLyHoaDonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyHoaDonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLyHoaDonMouseExited

    private void btnQuanLyHoaDonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyHoaDonMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLyHoaDonMousePressed

    private void btnQuanLyHoaDonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyHoaDonMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLyHoaDonMouseReleased

    private void btnQuanLyNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyNhanVienMouseClicked
        resetColorButton();
        btnQuanLyNhanVien.setBackground(new java.awt.Color(0,0,0,100));
        showForm(new QuanLyNhanVien_GUI());
    }//GEN-LAST:event_btnQuanLyNhanVienMouseClicked

    private void btnQuanLyNhanVienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyNhanVienMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLyNhanVienMouseEntered

    private void btnQuanLyNhanVienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyNhanVienMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLyNhanVienMouseExited

    private void btnQuanLyNhanVienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyNhanVienMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLyNhanVienMousePressed

    private void btnQuanLyNhanVienMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyNhanVienMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLyNhanVienMouseReleased

    private void btnQuanLyKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyKhachHangMouseClicked
        resetColorButton();
        btnQuanLyKhachHang.setBackground(new java.awt.Color(0,0,0,100));
        showForm(new QuanLyKhachHang_GUI());
    }//GEN-LAST:event_btnQuanLyKhachHangMouseClicked

    private void btnQuanLyKhachHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyKhachHangMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLyKhachHangMouseEntered

    private void btnQuanLyKhachHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyKhachHangMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLyKhachHangMouseExited

    private void btnQuanLyKhachHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyKhachHangMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLyKhachHangMousePressed

    private void btnQuanLyKhachHangMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyKhachHangMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLyKhachHangMouseReleased

    private void btnQuanLyKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLyKhachHangActionPerformed

    private void btnBaoCaoThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBaoCaoThongKeMouseClicked
        resetColorButton();
        btnBaoCaoThongKe.setBackground(new java.awt.Color(0,0,0,100));
        showForm(new BaoCaoThongKe_GUI());
    }//GEN-LAST:event_btnBaoCaoThongKeMouseClicked

    private void btnBaoCaoThongKeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBaoCaoThongKeMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBaoCaoThongKeMouseEntered

    private void btnBaoCaoThongKeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBaoCaoThongKeMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBaoCaoThongKeMouseExited

    private void btnBaoCaoThongKeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBaoCaoThongKeMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBaoCaoThongKeMousePressed

    private void btnBaoCaoThongKeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBaoCaoThongKeMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBaoCaoThongKeMouseReleased

    private void btnDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangXuatMouseClicked
        DangNhap_GUI dangNhap_GUI = new DangNhap_GUI();
        dangNhap_GUI.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnDangXuatMouseClicked

    private void btnDangXuatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangXuatMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDangXuatMouseEntered

    private void btnDangXuatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangXuatMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDangXuatMouseExited

    private void btnDangXuatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangXuatMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDangXuatMousePressed

    private void btnDangXuatMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangXuatMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDangXuatMouseReleased

    
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
            java.util.logging.Logger.getLogger(TrangChuNew_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChuNew_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChuNew_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChuNew_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TrangChuNew_GUI().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaoCaoThongKe;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnQuanLyBan;
    private javax.swing.JButton btnQuanLyHoaDon;
    private javax.swing.JButton btnQuanLyKhachHang;
    private javax.swing.JButton btnQuanLyMonAn;
    private javax.swing.JButton btnQuanLyNhanVien;
    private javax.swing.JButton btnQuanLyPhucVu;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}
