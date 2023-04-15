/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.LoaiMonAn_BUS;
import BUS.MonAn_BUS;
import DTO.MonAn.LoaiMonAn_DTO;
import DTO.MonAn.MonAn_DTO;
import com.mycompany.quanlynhahang.Price;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author tanph
 */
public class Menu_GUI extends javax.swing.JFrame {

    private LoaiMonAn_BUS loaiMonAn_BUS;
    private MonAn_BUS monAn_BUS;
    private static int idBan;
    
    private DatMon_GUI datMon_GUI;
    /**
     * Creates new form Menu_GUI
     */
    public Menu_GUI(int idBan) {
        initComponents();
        loaiMonAn_BUS = new LoaiMonAn_BUS();
        monAn_BUS = new MonAn_BUS();
        this.idBan = idBan;
        
        loadMenu();
    }
    
    private void loadMenu(){
        ArrayList<LoaiMonAn_DTO> listLoaiMonAn = loaiMonAn_BUS.getAllLoaiMonAn();
        tabMenu.removeAll();
        for(LoaiMonAn_DTO loaiMonAn : listLoaiMonAn){
            JScrollPane scrMenu = new JScrollPane();
            JPanel pnlCategory = new JPanel(new FlowLayout());
            
            scrMenu.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            
            pnlCategory.setPreferredSize(new Dimension(820, 600));
            pnlCategory.setMaximumSize(new Dimension(820, 600));
            pnlCategory.setMinimumSize(new Dimension(820, 600));
            
            ArrayList<MonAn_DTO> listMonAn = monAn_BUS.getListMonAnByLoaiMonAn(loaiMonAn.getId());
            for(MonAn_DTO monAn : listMonAn){
                JPanel pnlItem = new JPanel(new GridBagLayout());
                GridBagConstraints c = new GridBagConstraints();
                
                pnlItem.setPreferredSize(new Dimension(200, 280));
                pnlItem.setMinimumSize(new Dimension(200, 280));
//                pnlItem.setBorder(BorderFactory.createRaisedBevelBorder());
                        
                JLabel lblHinhAnh = new JLabel();
                lblHinhAnh.setIcon(new ImageIcon(monAn.getHinhAnh()));
                lblHinhAnh.setPreferredSize(new Dimension(140, 140));
                c.anchor = GridBagConstraints.CENTER;
                c.gridx = 0;
                c.gridy = 0;
                c.gridwidth = 2;
                c.insets = new Insets(8, 8, 8, 8);
                pnlItem.add(lblHinhAnh, c);
                
                JLabel lblTenMonAn = new JLabel(monAn.getTen());
                c.anchor = GridBagConstraints.CENTER;
                c.gridx = 0;
                c.gridy = 1;
                c.gridwidth = 2;
                c.insets = new Insets(6, 2, 6, 2);
                pnlItem.add(lblTenMonAn, c);              
                
                JLabel lblTitleGia = new JLabel("Giá");
                c.anchor = GridBagConstraints.WEST;
                c.gridx = 0;
                c.gridy = 2;
                c.insets = new Insets(10, 8, 4, 8);
                pnlItem.add(lblTitleGia, c);
                
                JLabel lblGia = new JLabel(Price.formatPrice(monAn.getGia()));
                c.anchor = GridBagConstraints.EAST;
                c.gridx = 1;
                c.gridy = 2;
                c.insets = new Insets(10, 8, 4, 8);
                pnlItem.add(lblGia, c);       
                
                JLabel lblTitleGiaKhuyenMai = new JLabel("Giá khuyến mãi");
                c.anchor = GridBagConstraints.WEST;
                c.gridx = 0;
                c.gridy = 3;
                c.insets = new Insets(4, 8, 10, 8);
                pnlItem.add(lblTitleGiaKhuyenMai, c);
                
                if(monAn.getGiaKhuyenMai() > 0){
                    JLabel lblGiaKhuyenMai = new JLabel(Price.formatPrice(monAn.getGiaKhuyenMai()));
                    c.anchor = GridBagConstraints.EAST;
                    c.gridx = 1;
                    c.gridy = 3;
                    c.insets = new Insets(4, 8, 10, 8);
                    pnlItem.add(lblGiaKhuyenMai, c);                    
                }
                
                JButton btnDatMon = new JButton("Đặt ngay");
                c.anchor = GridBagConstraints.CENTER;
                c.gridx = 0;
                c.gridy = 4;
                c.gridwidth = 2;
                c.insets = new Insets(4, 4, 4, 4);
                btnDatMon.addMouseListener(new MouseInputListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {                        
                        if(datMon_GUI == null){
                            datMon_GUI = new DatMon_GUI(monAn.getId(), idBan);
                            datMon_GUI.setVisible(true);
                        } else {
                            datMon_GUI.setState(JFrame.NORMAL);
                            datMon_GUI.toFront();
                        }
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                    }

                    @Override
                    public void mouseDragged(MouseEvent e) {
                    }

                    @Override
                    public void mouseMoved(MouseEvent e) {
                    }
                });
                pnlItem.add(btnDatMon, c);  
                
                pnlCategory.add(pnlItem);
            }
            scrMenu.setViewportView(pnlCategory);
            tabMenu.add(loaiMonAn.getTen(), scrMenu);
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
        java.awt.GridBagConstraints gridBagConstraints;

        tabMenu = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jButton16 = new javax.swing.JButton();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(822, 32767));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(822, 600));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(822, 600));

        jPanel1.setMaximumSize(new java.awt.Dimension(822, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(822, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(822, 600));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setMinimumSize(new java.awt.Dimension(200, 280));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 280));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("Đặt ngay");
        jButton1.setMaximumSize(new java.awt.Dimension(100, 24));
        jButton1.setMinimumSize(new java.awt.Dimension(100, 24));
        jButton1.setPreferredSize(new java.awt.Dimension(100, 24));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel3.add(jButton1, gridBagConstraints);

        jLabel1.setText("Giá ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel3.add(jLabel1, gridBagConstraints);

        jLabel2.setMaximumSize(new java.awt.Dimension(140, 140));
        jLabel2.setMinimumSize(new java.awt.Dimension(140, 140));
        jLabel2.setPreferredSize(new java.awt.Dimension(140, 140));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel3.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Tàu Hủ Nóng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        jPanel3.add(jLabel3, gridBagConstraints);

        jLabel4.setText("90000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel3.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Giá khuyến mãi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel3.add(jLabel5, gridBagConstraints);

        jLabel6.setText("75000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel3.add(jLabel6, gridBagConstraints);

        jPanel1.add(jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setMinimumSize(new java.awt.Dimension(200, 280));
        jPanel4.setPreferredSize(new java.awt.Dimension(200, 280));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jButton2.setText("Đặt ngay");
        jButton2.setMaximumSize(new java.awt.Dimension(100, 24));
        jButton2.setMinimumSize(new java.awt.Dimension(100, 24));
        jButton2.setPreferredSize(new java.awt.Dimension(100, 24));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel4.add(jButton2, gridBagConstraints);

        jLabel7.setText("Giá ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel4.add(jLabel7, gridBagConstraints);

        jLabel8.setMaximumSize(new java.awt.Dimension(140, 140));
        jLabel8.setMinimumSize(new java.awt.Dimension(140, 140));
        jLabel8.setPreferredSize(new java.awt.Dimension(140, 140));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel4.add(jLabel8, gridBagConstraints);

        jLabel9.setText("Tàu Hủ Nóng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        jPanel4.add(jLabel9, gridBagConstraints);

        jLabel10.setText("90000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel4.add(jLabel10, gridBagConstraints);

        jLabel11.setText("Giá khuyến mãi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel4.add(jLabel11, gridBagConstraints);

        jLabel12.setText("75000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel4.add(jLabel12, gridBagConstraints);

        jPanel1.add(jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setMinimumSize(new java.awt.Dimension(200, 280));
        jPanel5.setPreferredSize(new java.awt.Dimension(200, 280));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jButton3.setText("Đặt ngay");
        jButton3.setMaximumSize(new java.awt.Dimension(100, 24));
        jButton3.setMinimumSize(new java.awt.Dimension(100, 24));
        jButton3.setPreferredSize(new java.awt.Dimension(100, 24));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel5.add(jButton3, gridBagConstraints);

        jLabel13.setText("Giá ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel5.add(jLabel13, gridBagConstraints);

        jLabel14.setMaximumSize(new java.awt.Dimension(140, 140));
        jLabel14.setMinimumSize(new java.awt.Dimension(140, 140));
        jLabel14.setPreferredSize(new java.awt.Dimension(140, 140));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel5.add(jLabel14, gridBagConstraints);

        jLabel15.setText("Tàu Hủ Nóng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        jPanel5.add(jLabel15, gridBagConstraints);

        jLabel16.setText("90000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel5.add(jLabel16, gridBagConstraints);

        jLabel17.setText("Giá khuyến mãi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel5.add(jLabel17, gridBagConstraints);

        jLabel18.setText("75000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel5.add(jLabel18, gridBagConstraints);

        jPanel1.add(jPanel5);

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setMinimumSize(new java.awt.Dimension(200, 280));
        jPanel6.setPreferredSize(new java.awt.Dimension(200, 280));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jButton4.setText("Đặt ngay");
        jButton4.setMaximumSize(new java.awt.Dimension(100, 24));
        jButton4.setMinimumSize(new java.awt.Dimension(100, 24));
        jButton4.setPreferredSize(new java.awt.Dimension(100, 24));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel6.add(jButton4, gridBagConstraints);

        jLabel19.setText("Giá ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel6.add(jLabel19, gridBagConstraints);

        jLabel20.setMaximumSize(new java.awt.Dimension(140, 140));
        jLabel20.setMinimumSize(new java.awt.Dimension(140, 140));
        jLabel20.setPreferredSize(new java.awt.Dimension(140, 140));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel6.add(jLabel20, gridBagConstraints);

        jLabel21.setText("Tàu Hủ Nóng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        jPanel6.add(jLabel21, gridBagConstraints);

        jLabel22.setText("90000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel6.add(jLabel22, gridBagConstraints);

        jLabel23.setText("Giá khuyến mãi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel6.add(jLabel23, gridBagConstraints);

        jLabel24.setText("75000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel6.add(jLabel24, gridBagConstraints);

        jPanel1.add(jPanel6);

        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel11.setMinimumSize(new java.awt.Dimension(200, 280));
        jPanel11.setPreferredSize(new java.awt.Dimension(200, 280));
        jPanel11.setLayout(new java.awt.GridBagLayout());

        jButton9.setText("Đặt ngay");
        jButton9.setMaximumSize(new java.awt.Dimension(100, 24));
        jButton9.setMinimumSize(new java.awt.Dimension(100, 24));
        jButton9.setPreferredSize(new java.awt.Dimension(100, 24));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel11.add(jButton9, gridBagConstraints);

        jLabel49.setText("Giá ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel11.add(jLabel49, gridBagConstraints);

        jLabel50.setMaximumSize(new java.awt.Dimension(140, 140));
        jLabel50.setMinimumSize(new java.awt.Dimension(140, 140));
        jLabel50.setPreferredSize(new java.awt.Dimension(140, 140));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel11.add(jLabel50, gridBagConstraints);

        jLabel51.setText("Tàu Hủ Nóng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        jPanel11.add(jLabel51, gridBagConstraints);

        jLabel52.setText("90000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel11.add(jLabel52, gridBagConstraints);

        jLabel53.setText("Giá khuyến mãi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel11.add(jLabel53, gridBagConstraints);

        jLabel54.setText("75000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel11.add(jLabel54, gridBagConstraints);

        jPanel1.add(jPanel11);

        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel12.setMinimumSize(new java.awt.Dimension(200, 280));
        jPanel12.setPreferredSize(new java.awt.Dimension(200, 280));
        jPanel12.setLayout(new java.awt.GridBagLayout());

        jButton10.setText("Đặt ngay");
        jButton10.setMaximumSize(new java.awt.Dimension(100, 24));
        jButton10.setMinimumSize(new java.awt.Dimension(100, 24));
        jButton10.setPreferredSize(new java.awt.Dimension(100, 24));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel12.add(jButton10, gridBagConstraints);

        jLabel55.setText("Giá ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel12.add(jLabel55, gridBagConstraints);

        jLabel56.setMaximumSize(new java.awt.Dimension(140, 140));
        jLabel56.setMinimumSize(new java.awt.Dimension(140, 140));
        jLabel56.setPreferredSize(new java.awt.Dimension(140, 140));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel12.add(jLabel56, gridBagConstraints);

        jLabel57.setText("Tàu Hủ Nóng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        jPanel12.add(jLabel57, gridBagConstraints);

        jLabel58.setText("90000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel12.add(jLabel58, gridBagConstraints);

        jLabel59.setText("Giá khuyến mãi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel12.add(jLabel59, gridBagConstraints);

        jLabel60.setText("75000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel12.add(jLabel60, gridBagConstraints);

        jPanel1.add(jPanel12);

        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel13.setMinimumSize(new java.awt.Dimension(200, 280));
        jPanel13.setPreferredSize(new java.awt.Dimension(200, 280));
        jPanel13.setLayout(new java.awt.GridBagLayout());

        jButton11.setText("Đặt ngay");
        jButton11.setMaximumSize(new java.awt.Dimension(100, 24));
        jButton11.setMinimumSize(new java.awt.Dimension(100, 24));
        jButton11.setPreferredSize(new java.awt.Dimension(100, 24));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel13.add(jButton11, gridBagConstraints);

        jLabel61.setText("Giá ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel13.add(jLabel61, gridBagConstraints);

        jLabel62.setMaximumSize(new java.awt.Dimension(140, 140));
        jLabel62.setMinimumSize(new java.awt.Dimension(140, 140));
        jLabel62.setPreferredSize(new java.awt.Dimension(140, 140));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel13.add(jLabel62, gridBagConstraints);

        jLabel63.setText("Tàu Hủ Nóng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        jPanel13.add(jLabel63, gridBagConstraints);

        jLabel64.setText("90000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel13.add(jLabel64, gridBagConstraints);

        jLabel65.setText("Giá khuyến mãi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel13.add(jLabel65, gridBagConstraints);

        jLabel66.setText("75000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel13.add(jLabel66, gridBagConstraints);

        jPanel1.add(jPanel13);

        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel14.setMinimumSize(new java.awt.Dimension(200, 280));
        jPanel14.setPreferredSize(new java.awt.Dimension(200, 280));
        jPanel14.setLayout(new java.awt.GridBagLayout());

        jButton12.setText("Đặt ngay");
        jButton12.setMaximumSize(new java.awt.Dimension(100, 24));
        jButton12.setMinimumSize(new java.awt.Dimension(100, 24));
        jButton12.setPreferredSize(new java.awt.Dimension(100, 24));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel14.add(jButton12, gridBagConstraints);

        jLabel67.setText("Giá ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel14.add(jLabel67, gridBagConstraints);

        jLabel68.setMaximumSize(new java.awt.Dimension(140, 140));
        jLabel68.setMinimumSize(new java.awt.Dimension(140, 140));
        jLabel68.setPreferredSize(new java.awt.Dimension(140, 140));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel14.add(jLabel68, gridBagConstraints);

        jLabel69.setText("Tàu Hủ Nóng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        jPanel14.add(jLabel69, gridBagConstraints);

        jLabel70.setText("90000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel14.add(jLabel70, gridBagConstraints);

        jLabel71.setText("Giá khuyến mãi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel14.add(jLabel71, gridBagConstraints);

        jLabel72.setText("75000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel14.add(jLabel72, gridBagConstraints);

        jPanel1.add(jPanel14);

        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel15.setMinimumSize(new java.awt.Dimension(200, 280));
        jPanel15.setPreferredSize(new java.awt.Dimension(200, 280));
        jPanel15.setLayout(new java.awt.GridBagLayout());

        jButton13.setText("Đặt ngay");
        jButton13.setMaximumSize(new java.awt.Dimension(100, 24));
        jButton13.setMinimumSize(new java.awt.Dimension(100, 24));
        jButton13.setPreferredSize(new java.awt.Dimension(100, 24));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel15.add(jButton13, gridBagConstraints);

        jLabel73.setText("Giá ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel15.add(jLabel73, gridBagConstraints);

        jLabel74.setMaximumSize(new java.awt.Dimension(140, 140));
        jLabel74.setMinimumSize(new java.awt.Dimension(140, 140));
        jLabel74.setPreferredSize(new java.awt.Dimension(140, 140));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel15.add(jLabel74, gridBagConstraints);

        jLabel75.setText("Tàu Hủ Nóng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        jPanel15.add(jLabel75, gridBagConstraints);

        jLabel76.setText("90000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel15.add(jLabel76, gridBagConstraints);

        jLabel77.setText("Giá khuyến mãi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel15.add(jLabel77, gridBagConstraints);

        jLabel78.setText("75000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel15.add(jLabel78, gridBagConstraints);

        jPanel1.add(jPanel15);

        jPanel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel16.setMinimumSize(new java.awt.Dimension(200, 280));
        jPanel16.setPreferredSize(new java.awt.Dimension(200, 280));
        jPanel16.setLayout(new java.awt.GridBagLayout());

        jButton14.setText("Đặt ngay");
        jButton14.setMaximumSize(new java.awt.Dimension(100, 24));
        jButton14.setMinimumSize(new java.awt.Dimension(100, 24));
        jButton14.setPreferredSize(new java.awt.Dimension(100, 24));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel16.add(jButton14, gridBagConstraints);

        jLabel79.setText("Giá ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel16.add(jLabel79, gridBagConstraints);

        jLabel80.setMaximumSize(new java.awt.Dimension(140, 140));
        jLabel80.setMinimumSize(new java.awt.Dimension(140, 140));
        jLabel80.setPreferredSize(new java.awt.Dimension(140, 140));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel16.add(jLabel80, gridBagConstraints);

        jLabel81.setText("Tàu Hủ Nóng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        jPanel16.add(jLabel81, gridBagConstraints);

        jLabel82.setText("90000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel16.add(jLabel82, gridBagConstraints);

        jLabel83.setText("Giá khuyến mãi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel16.add(jLabel83, gridBagConstraints);

        jLabel84.setText("75000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel16.add(jLabel84, gridBagConstraints);

        jPanel1.add(jPanel16);

        jPanel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel17.setMinimumSize(new java.awt.Dimension(200, 280));
        jPanel17.setPreferredSize(new java.awt.Dimension(200, 280));
        jPanel17.setLayout(new java.awt.GridBagLayout());

        jButton15.setText("Đặt ngay");
        jButton15.setMaximumSize(new java.awt.Dimension(100, 24));
        jButton15.setMinimumSize(new java.awt.Dimension(100, 24));
        jButton15.setPreferredSize(new java.awt.Dimension(100, 24));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel17.add(jButton15, gridBagConstraints);

        jLabel85.setText("Giá ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel17.add(jLabel85, gridBagConstraints);

        jLabel86.setMaximumSize(new java.awt.Dimension(140, 140));
        jLabel86.setMinimumSize(new java.awt.Dimension(140, 140));
        jLabel86.setPreferredSize(new java.awt.Dimension(140, 140));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel17.add(jLabel86, gridBagConstraints);

        jLabel87.setText("Tàu Hủ Nóng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        jPanel17.add(jLabel87, gridBagConstraints);

        jLabel88.setText("90000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel17.add(jLabel88, gridBagConstraints);

        jLabel89.setText("Giá khuyến mãi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel17.add(jLabel89, gridBagConstraints);

        jLabel90.setText("75000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel17.add(jLabel90, gridBagConstraints);

        jPanel1.add(jPanel17);

        jPanel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel18.setMinimumSize(new java.awt.Dimension(200, 280));
        jPanel18.setPreferredSize(new java.awt.Dimension(200, 280));
        jPanel18.setLayout(new java.awt.GridBagLayout());

        jButton16.setText("Đặt ngay");
        jButton16.setMaximumSize(new java.awt.Dimension(100, 24));
        jButton16.setMinimumSize(new java.awt.Dimension(100, 24));
        jButton16.setPreferredSize(new java.awt.Dimension(100, 24));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel18.add(jButton16, gridBagConstraints);

        jLabel91.setText("Giá ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel18.add(jLabel91, gridBagConstraints);

        jLabel92.setMaximumSize(new java.awt.Dimension(140, 140));
        jLabel92.setMinimumSize(new java.awt.Dimension(140, 140));
        jLabel92.setPreferredSize(new java.awt.Dimension(140, 140));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel18.add(jLabel92, gridBagConstraints);

        jLabel93.setText("Tàu Hủ Nóng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 6, 2);
        jPanel18.add(jLabel93, gridBagConstraints);

        jLabel94.setText("90000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 4, 8);
        jPanel18.add(jLabel94, gridBagConstraints);

        jLabel95.setText("Giá khuyến mãi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel18.add(jLabel95, gridBagConstraints);

        jLabel96.setText("75000vnđ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 10, 8);
        jPanel18.add(jLabel96, gridBagConstraints);

        jPanel1.add(jPanel18);

        jScrollPane1.setViewportView(jPanel1);

        tabMenu.addTab("Món Nóng", jScrollPane1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 861, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        tabMenu.addTab("Xôi lạc", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(tabMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tabMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 608, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_GUI(idBan).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane tabMenu;
    // End of variables declaration//GEN-END:variables
}
