package GUI;

import BUS.Ban_BUS;
import BUS.DonGoi_BUS;
import Constraints.TinhTrangBanConstraints;
import DTO.Ban.BanFull_DTO;
import DTO.Ban.Ban_DTO;
import DTO.Ban.DonGoi_DTO;
import com.mycompany.quanlynhahang.Price;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author LeAnhQuan
 */
public class QuanLyPhucVu_GUI extends javax.swing.JFrame {
    private Ban_BUS ban_BUS;
    private DonGoi_BUS donGoi_BUS;
    private ArrayList<Ban_DTO> listBanSanSang;
    private BanFull_DTO banDangChon;
    private ArrayList<DonGoi_DTO> listDonGoi;
    
    private Menu_GUI menu_GUI;
    private DatMon_GUI datMon_GUI;
    private ThanhToan_GUI thanhToan_GUI;
    /**
     * Creates new form QuanLyPhucVu_GUI
     */
    public QuanLyPhucVu_GUI() {
        initComponents();
        ban_BUS = new Ban_BUS();
        donGoi_BUS = new DonGoi_BUS();
        
        loadDanhSachBan();
    }
    
    private void loadDanhSachBan() {
        pnlDanhSachBan.removeAll();
        ArrayList<BanFull_DTO> listBan = ban_BUS.getAllBanFull();
        
        for(BanFull_DTO ban : listBan){
            String title = "<html> "
                    + "<p style=\"text-align:center\">Bàn " + ban.getId() + "</p> "
                    + "<p  style=\"text-align:center\">" + ban.getLoaiBan().getTen() + "</p> "
                    + "<p  style=\"text-align:center\">" + ban.getTinhTrangBan().getTen() + "</p> "
                    + "</html>";
            JButton button = new JButton(title);
            button.setPreferredSize(new Dimension(120, 60));
            button.setMinimumSize(new Dimension(120, 60));
            button.setMaximumSize(new Dimension(120, 60));
            
            int idTinhTrangBan = ban.getTinhTrangBan().getId();
            if(idTinhTrangBan == TinhTrangBanConstraints.SAN_SANG)
                button.setBackground(new Color(95, 192, 102));
            else if(idTinhTrangBan == TinhTrangBanConstraints.DANG_PHUC_VU)
                button.setBackground(new Color(231, 197, 76));
            else if(idTinhTrangBan == TinhTrangBanConstraints.DANG_CHUAN_BI)
                button.setBackground(new Color(220, 60, 47));
            else 
                button.setBackground(new Color(141, 141, 141));
                
            
            
            button.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    banDangChon = ban;
                    loadThongTinBan();
                    loadChucNang();
                    if(banDangChon.getTinhTrangBan().getId() == TinhTrangBanConstraints.DANG_PHUC_VU)
                        loadDonGoi();
                }

                @Override
                public void mousePressed(MouseEvent e) {
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
            });
            
            pnlDanhSachBan.add(button);
        }
    }
    
    private void loadThongTinBan(){
        lblIdBan.setText(banDangChon.getId() + "");
        lblLoaiBan.setText(banDangChon.getLoaiBan().getTen());
        lblTinhTrangBan.setText(banDangChon.getTinhTrangBan().getTen());
    }
    
    private void loadComboBoxBanSanSang(){
        listBanSanSang = ban_BUS.getAllBanDangSanSang();
        cmbBanSanSang.removeAllItems();
        for(Ban_DTO banSanSang : listBanSanSang){
            cmbBanSanSang.addItem("Bàn " + banSanSang.getId());
        }        
        cmbBanSanSang.setSelectedIndex(-1);
        if(banDangChon.getTinhTrangBan().getId() == TinhTrangBanConstraints.DANG_PHUC_VU){
            cmbBanSanSang.setEnabled(true);
            btnChuyenBan.setEnabled(true);
        } else {
            cmbBanSanSang.setEnabled(false);
            btnChuyenBan.setEnabled(false);
        }
    }

    private void loadDonGoi(){
        listDonGoi = donGoi_BUS.getAllDonGoiByIdBan(banDangChon.getId());
        
        int total = 0;
        
        String[] col = {"Id món ăn","Tên món ăn", "Đơn giá", "Số lượng", "Thành tiền"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        tblDonGoi.setModel(model);
        for(DonGoi_DTO donGoi : listDonGoi){
            int gia = donGoi.getMonAn().getGiaKhuyenMai() > 0 ? donGoi.getMonAn().getGiaKhuyenMai() : donGoi.getMonAn().getGia();
            int thanhTien = gia * donGoi.getSoLuong();
            Object[] data = {
                donGoi.getMonAn().getId(),
                donGoi.getMonAn().getTen(), 
                Price.formatPrice(gia),
                donGoi.getSoLuong(),
                Price.formatPrice(thanhTien)
            };
            total += thanhTien;
            
            model.addRow(data);
        }  
        
        lblTongGia.setText(Price.formatPrice(total));
    }
    
    private void loadChucNang(){
        int idTinhTrangBan = banDangChon.getTinhTrangBan().getId();
        if(idTinhTrangBan == TinhTrangBanConstraints.SAN_SANG){
            btnSanSang.setEnabled(false);
            btnPhucVu.setEnabled(true);
            btnNgungPhucVu.setEnabled(true);
            btnThemMonMoi.setEnabled(false);
            btnSuaDonGoi.setEnabled(false);
            btnXoa.setEnabled(false);
            btnThanhToan.setEnabled(false);            
        }
        else if(idTinhTrangBan == TinhTrangBanConstraints.DANG_PHUC_VU){
            btnSanSang.setEnabled(false);
            btnPhucVu.setEnabled(false);
            btnNgungPhucVu.setEnabled(false);
            btnThemMonMoi.setEnabled(true);
            btnSuaDonGoi.setEnabled(true);
            btnXoa.setEnabled(true);
            btnThanhToan.setEnabled(true);            
        }
        else if(idTinhTrangBan == TinhTrangBanConstraints.DANG_CHUAN_BI){
            btnSanSang.setEnabled(true);
            btnPhucVu.setEnabled(false);
            btnNgungPhucVu.setEnabled(true);
            btnThemMonMoi.setEnabled(false);
            btnSuaDonGoi.setEnabled(false);
            btnXoa.setEnabled(false);
            btnThanhToan.setEnabled(false);             
        }
        else {            
            btnSanSang.setEnabled(true);
            btnPhucVu.setEnabled(false);
            btnNgungPhucVu.setEnabled(false);
            btnThemMonMoi.setEnabled(false);
            btnSuaDonGoi.setEnabled(false);
            btnXoa.setEnabled(false);
            btnThanhToan.setEnabled(false); 
        }
        loadComboBoxBanSanSang();
    }
    
    private void chuyenTinhTrangBan(int tinhTrangMoi){
        ban_BUS.changeTinhTrangBan(banDangChon.getId(), tinhTrangMoi);
        banDangChon = ban_BUS.getBanFullById(banDangChon.getId());
        
        loadChucNang();
        loadDonGoi();
        loadComboBoxBanSanSang();
        loadDanhSachBan();
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

        jScrollPane3 = new javax.swing.JScrollPane();
        pnlDanhSachBan = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton63 = new javax.swing.JButton();
        jButton59 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        jButton62 = new javax.swing.JButton();
        jButton70 = new javax.swing.JButton();
        jButton71 = new javax.swing.JButton();
        jButton72 = new javax.swing.JButton();
        jButton73 = new javax.swing.JButton();
        jButton74 = new javax.swing.JButton();
        jButton75 = new javax.swing.JButton();
        jButton76 = new javax.swing.JButton();
        jButton77 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton64 = new javax.swing.JButton();
        jButton65 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton66 = new javax.swing.JButton();
        jButton67 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton68 = new javax.swing.JButton();
        jButton69 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton78 = new javax.swing.JButton();
        jButton79 = new javax.swing.JButton();
        jButton80 = new javax.swing.JButton();
        jButton81 = new javax.swing.JButton();
        jButton82 = new javax.swing.JButton();
        jButton83 = new javax.swing.JButton();
        jButton84 = new javax.swing.JButton();
        jButton85 = new javax.swing.JButton();
        jButton86 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton87 = new javax.swing.JButton();
        jButton88 = new javax.swing.JButton();
        jButton89 = new javax.swing.JButton();
        jButton90 = new javax.swing.JButton();
        jButton91 = new javax.swing.JButton();
        jButton92 = new javax.swing.JButton();
        jButton93 = new javax.swing.JButton();
        jButton94 = new javax.swing.JButton();
        jButton95 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton96 = new javax.swing.JButton();
        jButton97 = new javax.swing.JButton();
        jButton98 = new javax.swing.JButton();
        jButton99 = new javax.swing.JButton();
        jButton100 = new javax.swing.JButton();
        jButton101 = new javax.swing.JButton();
        jButton102 = new javax.swing.JButton();
        jButton103 = new javax.swing.JButton();
        jButton104 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jButton105 = new javax.swing.JButton();
        jButton106 = new javax.swing.JButton();
        jButton107 = new javax.swing.JButton();
        jButton108 = new javax.swing.JButton();
        jButton109 = new javax.swing.JButton();
        jButton110 = new javax.swing.JButton();
        jButton111 = new javax.swing.JButton();
        jButton112 = new javax.swing.JButton();
        jButton113 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblIdBan = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTinhTrangBan = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblLoaiBan = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnThemMonMoi = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSuaDonGoi = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cmbBanSanSang = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        btnChuyenBan = new javax.swing.JButton();
        btnSanSang = new javax.swing.JButton();
        btnPhucVu = new javax.swing.JButton();
        btnNgungPhucVu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDonGoi = new javax.swing.JTable();
        btnResetDonGoi = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnThanhToan = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lblTongGia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý phục vụ");
        setMinimumSize(new java.awt.Dimension(1080, 600));
        setPreferredSize(new java.awt.Dimension(1080, 600));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách bàn"));
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setToolTipText("");
        jScrollPane3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane3.setMaximumSize(new java.awt.Dimension(540, 32767));
        jScrollPane3.setMinimumSize(new java.awt.Dimension(540, 600));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(540, 600));
        jScrollPane3.setWheelScrollingEnabled(false);

        pnlDanhSachBan.setMaximumSize(new java.awt.Dimension(520, 600));
        pnlDanhSachBan.setMinimumSize(new java.awt.Dimension(520, 600));
        pnlDanhSachBan.setNextFocusableComponent(pnlDanhSachBan);
        pnlDanhSachBan.setPreferredSize(new java.awt.Dimension(520, 600));
        pnlDanhSachBan.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jButton2.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton2.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton2.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton2);

        jButton3.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton3.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton3.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton3);

        jButton4.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton4.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton4.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton4);

        jButton5.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton5.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton5.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton5);

        jButton6.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton6.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton6.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton6);

        jButton7.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton7.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton7.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton7);

        jButton8.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton8.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton8.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton8);

        jButton63.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton63.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton63.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton63);

        jButton59.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton59.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton59.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton59);

        jButton60.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton60.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton60.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton60);

        jButton61.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton61.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton61.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton61);

        jButton62.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton62.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton62.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton62);

        jButton70.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton70.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton70.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton70);

        jButton71.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton71.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton71.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton71);

        jButton72.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton72.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton72.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton72);

        jButton73.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton73.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton73.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton73);

        jButton74.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton74.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton74.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton74);

        jButton75.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton75.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton75.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton75);

        jButton76.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton76.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton76.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton76);

        jButton77.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton77.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton77.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton77);

        jButton17.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton17.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton17.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton17);

        jButton18.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton18.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton18.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton18);

        jButton19.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton19.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton19.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton19);

        jButton20.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton20.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton20.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton20);

        jButton21.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton21.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton21.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton21);

        jButton22.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton22.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton22.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton22);

        jButton64.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton64.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton64.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton64);

        jButton65.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton65.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton65.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton65);

        jButton23.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton23.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton23.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton23);

        jButton24.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton24.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton24.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton24);

        jButton25.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton25.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton25.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton25);

        jButton26.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton26.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton26.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton26);

        jButton27.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton27.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton27.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton27);

        jButton28.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton28.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton28.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton28);

        jButton66.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton66.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton66.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton66);

        jButton67.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton67.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton67.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton67);

        jButton29.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton29.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton29.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton29);

        jButton30.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton30.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton30.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton30);

        jButton31.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton31.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton31.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton31);

        jButton32.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton32.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton32.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton32);

        jButton33.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton33.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton33.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton33);

        jButton34.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton34.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton34.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton34);

        jButton68.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton68.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton68.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton68);

        jButton69.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton69.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton69.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton69);

        jButton35.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton35.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton35.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton35);

        jButton36.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton36.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton36.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton36);

        jButton37.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton37.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton37.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton37);

        jButton38.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton38.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton38.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton38);

        jButton78.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton78.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton78.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton78);

        jButton79.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton79.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton79.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton79);

        jButton80.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton80.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton80.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton80);

        jButton81.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton81.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton81.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton81);

        jButton82.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton82.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton82.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton82);

        jButton83.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton83.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton83.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton83);

        jButton84.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton84.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton84.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton84);

        jButton85.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton85.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton85.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton85);

        jButton86.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton86.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton86.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton86);

        jButton39.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton39.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton39.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton39);

        jButton40.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton40.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton40.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton40);

        jButton41.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton41.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton41.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton41);

        jButton42.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton42.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton42.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton42);

        jButton87.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton87.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton87.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton87);

        jButton88.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton88.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton88.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton88);

        jButton89.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton89.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton89.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton89);

        jButton90.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton90.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton90.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton90);

        jButton91.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton91.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton91.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton91);

        jButton92.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton92.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton92.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton92);

        jButton93.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton93.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton93.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton93);

        jButton94.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton94.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton94.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton94);

        jButton95.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton95.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton95.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton95);

        jButton43.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton43.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton43.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton43);

        jButton44.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton44.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton44.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton44);

        jButton45.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton45.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton45.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton45);

        jButton46.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton46.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton46.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton46);

        jButton96.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton96.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton96.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton96);

        jButton97.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton97.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton97.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton97);

        jButton98.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton98.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton98.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton98);

        jButton99.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton99.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton99.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton99);

        jButton100.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton100.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton100.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton100);

        jButton101.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton101.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton101.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton101);

        jButton102.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton102.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton102.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton102);

        jButton103.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton103.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton103.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton103);

        jButton104.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton104.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton104.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton104);

        jButton47.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton47.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton47.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton47);

        jButton48.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton48.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton48.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton48);

        jButton49.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton49.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton49.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton49);

        jButton50.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton50.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton50.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton50);

        jButton105.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton105.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton105.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton105);

        jButton106.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton106.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton106.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton106);

        jButton107.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton107.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton107.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton107);

        jButton108.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton108.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton108.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton108);

        jButton109.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton109.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton109.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton109);

        jButton110.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton110.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton110.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton110);

        jButton111.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton111.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton111.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton111);

        jButton112.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton112.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton112.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton112);

        jButton113.setText("<html>\n<p style=\"text-align:center\">Bàn 1</p>\n<p  style=\"text-align:center\">Vuông 2</p>\n<p  style=\"text-align:center\">Đang chuẩn bị</p>\n</html>");
        jButton113.setMinimumSize(new java.awt.Dimension(120, 60));
        jButton113.setPreferredSize(new java.awt.Dimension(120, 60));
        pnlDanhSachBan.add(jButton113);

        jScrollPane3.setViewportView(pnlDanhSachBan);

        getContentPane().add(jScrollPane3);

        jPanel3.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel3.setMinimumSize(new java.awt.Dimension(520, 120));
        jPanel3.setPreferredSize(new java.awt.Dimension(520, 120));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin bàn"));
        jPanel4.setMaximumSize(new java.awt.Dimension(2147483647, 60));
        jPanel4.setMinimumSize(new java.awt.Dimension(520, 60));
        jPanel4.setPreferredSize(new java.awt.Dimension(520, 60));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Bàn số:");
        jLabel1.setMaximumSize(new java.awt.Dimension(44, 24));
        jLabel1.setMinimumSize(new java.awt.Dimension(44, 24));
        jLabel1.setPreferredSize(new java.awt.Dimension(44, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -1;
        gridBagConstraints.insets = new java.awt.Insets(2, 8, 2, 0);
        jPanel4.add(jLabel1, gridBagConstraints);

        lblIdBan.setMaximumSize(new java.awt.Dimension(24, 24));
        lblIdBan.setMinimumSize(new java.awt.Dimension(24, 24));
        lblIdBan.setPreferredSize(new java.awt.Dimension(24, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -1;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 8);
        jPanel4.add(lblIdBan, gridBagConstraints);

        jLabel3.setText("Loại bàn:");
        jLabel3.setMaximumSize(new java.awt.Dimension(54, 24));
        jLabel3.setMinimumSize(new java.awt.Dimension(54, 24));
        jLabel3.setPreferredSize(new java.awt.Dimension(54, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -1;
        gridBagConstraints.insets = new java.awt.Insets(2, 8, 2, 0);
        jPanel4.add(jLabel3, gridBagConstraints);

        lblTinhTrangBan.setMaximumSize(new java.awt.Dimension(88, 24));
        lblTinhTrangBan.setMinimumSize(new java.awt.Dimension(88, 24));
        lblTinhTrangBan.setPreferredSize(new java.awt.Dimension(88, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -1;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 8);
        jPanel4.add(lblTinhTrangBan, gridBagConstraints);

        jLabel5.setText("Tình trạng bàn:");
        jLabel5.setMaximumSize(new java.awt.Dimension(90, 24));
        jLabel5.setMinimumSize(new java.awt.Dimension(90, 24));
        jLabel5.setPreferredSize(new java.awt.Dimension(90, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -1;
        gridBagConstraints.insets = new java.awt.Insets(2, 8, 2, 0);
        jPanel4.add(jLabel5, gridBagConstraints);

        lblLoaiBan.setMaximumSize(new java.awt.Dimension(60, 24));
        lblLoaiBan.setMinimumSize(new java.awt.Dimension(60, 24));
        lblLoaiBan.setPreferredSize(new java.awt.Dimension(60, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -1;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 8);
        jPanel4.add(lblLoaiBan, gridBagConstraints);

        jPanel3.add(jPanel4);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng khác"));
        jPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 120));
        jPanel1.setMinimumSize(new java.awt.Dimension(520, 120));
        jPanel1.setPreferredSize(new java.awt.Dimension(520, 120));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel7.setText("Chức năng");
        jLabel7.setMaximumSize(new java.awt.Dimension(90, 24));
        jLabel7.setMinimumSize(new java.awt.Dimension(90, 24));
        jLabel7.setPreferredSize(new java.awt.Dimension(90, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        jPanel1.add(jLabel7, gridBagConstraints);

        btnThemMonMoi.setText("Thêm món mới");
        btnThemMonMoi.setEnabled(false);
        btnThemMonMoi.setMaximumSize(new java.awt.Dimension(120, 24));
        btnThemMonMoi.setMinimumSize(new java.awt.Dimension(120, 24));
        btnThemMonMoi.setPreferredSize(new java.awt.Dimension(120, 24));
        btnThemMonMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMonMoiMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel1.add(btnThemMonMoi, gridBagConstraints);

        btnXoa.setText("Xóa món ăn");
        btnXoa.setEnabled(false);
        btnXoa.setMaximumSize(new java.awt.Dimension(120, 24));
        btnXoa.setMinimumSize(new java.awt.Dimension(120, 24));
        btnXoa.setPreferredSize(new java.awt.Dimension(120, 24));
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel1.add(btnXoa, gridBagConstraints);

        btnSuaDonGoi.setText("Sửa đơn gọi");
        btnSuaDonGoi.setEnabled(false);
        btnSuaDonGoi.setMaximumSize(new java.awt.Dimension(120, 24));
        btnSuaDonGoi.setMinimumSize(new java.awt.Dimension(120, 24));
        btnSuaDonGoi.setPreferredSize(new java.awt.Dimension(120, 24));
        btnSuaDonGoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaDonGoiMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel1.add(btnSuaDonGoi, gridBagConstraints);

        jLabel8.setText("Chuyển bàn");
        jLabel8.setMaximumSize(new java.awt.Dimension(90, 24));
        jLabel8.setMinimumSize(new java.awt.Dimension(90, 24));
        jLabel8.setPreferredSize(new java.awt.Dimension(90, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        jPanel1.add(jLabel8, gridBagConstraints);

        cmbBanSanSang.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbBanSanSang.setEnabled(false);
        cmbBanSanSang.setMaximumSize(new java.awt.Dimension(120, 24));
        cmbBanSanSang.setMinimumSize(new java.awt.Dimension(120, 24));
        cmbBanSanSang.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel1.add(cmbBanSanSang, gridBagConstraints);

        jLabel9.setText("Tình trạng bàn");
        jLabel9.setMaximumSize(new java.awt.Dimension(90, 24));
        jLabel9.setMinimumSize(new java.awt.Dimension(90, 24));
        jLabel9.setPreferredSize(new java.awt.Dimension(90, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        jPanel1.add(jLabel9, gridBagConstraints);

        btnChuyenBan.setText("Đổi");
        btnChuyenBan.setEnabled(false);
        btnChuyenBan.setMaximumSize(new java.awt.Dimension(120, 24));
        btnChuyenBan.setMinimumSize(new java.awt.Dimension(120, 24));
        btnChuyenBan.setPreferredSize(new java.awt.Dimension(120, 24));
        btnChuyenBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChuyenBanMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel1.add(btnChuyenBan, gridBagConstraints);

        btnSanSang.setText("Sẵn sàng");
        btnSanSang.setEnabled(false);
        btnSanSang.setMaximumSize(new java.awt.Dimension(120, 24));
        btnSanSang.setMinimumSize(new java.awt.Dimension(120, 24));
        btnSanSang.setPreferredSize(new java.awt.Dimension(120, 24));
        btnSanSang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSanSangMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel1.add(btnSanSang, gridBagConstraints);

        btnPhucVu.setText("Phục vụ");
        btnPhucVu.setEnabled(false);
        btnPhucVu.setMaximumSize(new java.awt.Dimension(120, 24));
        btnPhucVu.setMinimumSize(new java.awt.Dimension(120, 24));
        btnPhucVu.setPreferredSize(new java.awt.Dimension(120, 24));
        btnPhucVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPhucVuMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel1.add(btnPhucVu, gridBagConstraints);

        btnNgungPhucVu.setText("Ngừng phục vụ");
        btnNgungPhucVu.setEnabled(false);
        btnNgungPhucVu.setMaximumSize(new java.awt.Dimension(120, 24));
        btnNgungPhucVu.setMinimumSize(new java.awt.Dimension(120, 24));
        btnNgungPhucVu.setPreferredSize(new java.awt.Dimension(120, 24));
        btnNgungPhucVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNgungPhucVuMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel1.add(btnNgungPhucVu, gridBagConstraints);

        jPanel3.add(jPanel1);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách đơn gọi"));

        tblDonGoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Món ăn", "Tên món ăn", "Đơn giá", "Số lượng", "Thành tiền"
            }
        ));
        jScrollPane1.setViewportView(tblDonGoi);

        jPanel3.add(jScrollPane1);

        btnResetDonGoi.setText("Reset");
        btnResetDonGoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetDonGoiMouseClicked(evt);
            }
        });
        jPanel3.add(btnResetDonGoi);

        jPanel5.setMaximumSize(new java.awt.Dimension(2147483647, 60));
        jPanel5.setMinimumSize(new java.awt.Dimension(520, 60));
        jPanel5.setPreferredSize(new java.awt.Dimension(520, 60));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.setMaximumSize(new java.awt.Dimension(120, 24));
        btnThanhToan.setMinimumSize(new java.awt.Dimension(120, 24));
        btnThanhToan.setPreferredSize(new java.awt.Dimension(120, 24));
        btnThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThanhToanMouseClicked(evt);
            }
        });
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 4, 8);
        jPanel5.add(btnThanhToan, gridBagConstraints);

        jLabel10.setText("Tổng tiền");
        jLabel10.setMaximumSize(new java.awt.Dimension(120, 24));
        jLabel10.setMinimumSize(new java.awt.Dimension(120, 24));
        jLabel10.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 8);
        jPanel5.add(jLabel10, gridBagConstraints);

        lblTongGia.setText("0 VNĐ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 0, 8);
        jPanel5.add(lblTongGia, gridBagConstraints);

        jPanel3.add(jPanel5);

        getContentPane().add(jPanel3);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPhucVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPhucVuMouseClicked
        // TODO add your handling code here:
       chuyenTinhTrangBan(TinhTrangBanConstraints.DANG_PHUC_VU);
    }//GEN-LAST:event_btnPhucVuMouseClicked

    private void btnThemMonMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMonMoiMouseClicked
        // TODO add your handling code here:
        if(menu_GUI == null || !menu_GUI.isDisplayable()){
            menu_GUI = new Menu_GUI(banDangChon.getId());
            menu_GUI.setVisible(true);
        } else {
            menu_GUI.setState(JFrame.NORMAL);
            menu_GUI.toFront();
        }
    }//GEN-LAST:event_btnThemMonMoiMouseClicked

    private void btnSuaDonGoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaDonGoiMouseClicked
        // TODO add your handling code here:
        int count = tblDonGoi.getSelectedRowCount();
        if(count < 1)
            JOptionPane.showMessageDialog(this, "Chưa chọn món ăn","Error", JOptionPane.ERROR_MESSAGE);
            
        
        int indexRow = tblDonGoi.getSelectedRow();
        TableModel model = tblDonGoi.getModel();
        
        int idMonAn = Integer.parseInt(model.getValueAt(indexRow, 0).toString());
        if(datMon_GUI == null || !datMon_GUI.isDisplayable()){
            datMon_GUI = new DatMon_GUI(banDangChon.getId(), idMonAn);
            datMon_GUI.setVisible(true);
        } else {
            datMon_GUI.setState(JFrame.NORMAL);
            datMon_GUI.toFront();
        }
    }//GEN-LAST:event_btnSuaDonGoiMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThanhToanMouseClicked
        // TODO add your handling code here:
        if(thanhToan_GUI == null || !thanhToan_GUI.isDisplayable()){
            thanhToan_GUI = new ThanhToan_GUI(banDangChon.getId());
            thanhToan_GUI.setVisible(true);
        } else {
            thanhToan_GUI.setState(JFrame.NORMAL);
            thanhToan_GUI.toFront();
        }
    }//GEN-LAST:event_btnThanhToanMouseClicked

    private void btnResetDonGoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetDonGoiMouseClicked
        // TODO add your handling code here:
        loadDonGoi();
    }//GEN-LAST:event_btnResetDonGoiMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        // TODO add your handling code here:
        int count = tblDonGoi.getSelectedRowCount();
        if(count < 1)
            JOptionPane.showMessageDialog(this, "Chưa chọn món ăn","Error", JOptionPane.ERROR_MESSAGE);
        else if(count > 1)
            JOptionPane.showMessageDialog(this, "Chỉ chọn 1 món ăn","Error", JOptionPane.ERROR_MESSAGE);
        
        int indexRow = tblDonGoi.getSelectedRow();
        TableModel model = tblDonGoi.getModel();
        
        int idMonAn = Integer.parseInt(model.getValueAt(indexRow, 0).toString());
        boolean result = donGoi_BUS.deleteDonGoi(banDangChon.getId(), idMonAn);
        if(result){
            JOptionPane.showMessageDialog(this, "Xóa món ăn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
            loadDonGoi();
        } else {            
            JOptionPane.showMessageDialog(this, "Xóa món ăn thất bại","Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnXoaMouseClicked

    private void btnChuyenBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChuyenBanMouseClicked
        // TODO add your handling code here:
        int indexBan = cmbBanSanSang.getSelectedIndex();
        if(indexBan < 0){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn muốn chuyển","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        boolean result = donGoi_BUS.chuyenBan(banDangChon.getId(), listBanSanSang.get(indexBan).getId());
        if(result){
            JOptionPane.showMessageDialog(this, "Chuyển bàn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
            chuyenTinhTrangBan(TinhTrangBanConstraints.DANG_CHUAN_BI);
        } else {            
            JOptionPane.showMessageDialog(this, "Chuyển bàn thất bại","Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnChuyenBanMouseClicked

    private void btnSanSangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSanSangMouseClicked
        // TODO add your handling code here:
        chuyenTinhTrangBan(TinhTrangBanConstraints.SAN_SANG);
    }//GEN-LAST:event_btnSanSangMouseClicked

    private void btnNgungPhucVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNgungPhucVuMouseClicked
        // TODO add your handling code here:
        chuyenTinhTrangBan(TinhTrangBanConstraints.NGUNG_PHUC_VU);
    }//GEN-LAST:event_btnNgungPhucVuMouseClicked

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
            java.util.logging.Logger.getLogger(QuanLyPhucVu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhucVu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhucVu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhucVu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyPhucVu_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChuyenBan;
    private javax.swing.JButton btnNgungPhucVu;
    private javax.swing.JButton btnPhucVu;
    private javax.swing.JButton btnResetDonGoi;
    private javax.swing.JButton btnSanSang;
    private javax.swing.JButton btnSuaDonGoi;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemMonMoi;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cmbBanSanSang;
    private javax.swing.JButton jButton100;
    private javax.swing.JButton jButton101;
    private javax.swing.JButton jButton102;
    private javax.swing.JButton jButton103;
    private javax.swing.JButton jButton104;
    private javax.swing.JButton jButton105;
    private javax.swing.JButton jButton106;
    private javax.swing.JButton jButton107;
    private javax.swing.JButton jButton108;
    private javax.swing.JButton jButton109;
    private javax.swing.JButton jButton110;
    private javax.swing.JButton jButton111;
    private javax.swing.JButton jButton112;
    private javax.swing.JButton jButton113;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    private javax.swing.JButton jButton66;
    private javax.swing.JButton jButton67;
    private javax.swing.JButton jButton68;
    private javax.swing.JButton jButton69;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton70;
    private javax.swing.JButton jButton71;
    private javax.swing.JButton jButton72;
    private javax.swing.JButton jButton73;
    private javax.swing.JButton jButton74;
    private javax.swing.JButton jButton75;
    private javax.swing.JButton jButton76;
    private javax.swing.JButton jButton77;
    private javax.swing.JButton jButton78;
    private javax.swing.JButton jButton79;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton80;
    private javax.swing.JButton jButton81;
    private javax.swing.JButton jButton82;
    private javax.swing.JButton jButton83;
    private javax.swing.JButton jButton84;
    private javax.swing.JButton jButton85;
    private javax.swing.JButton jButton86;
    private javax.swing.JButton jButton87;
    private javax.swing.JButton jButton88;
    private javax.swing.JButton jButton89;
    private javax.swing.JButton jButton90;
    private javax.swing.JButton jButton91;
    private javax.swing.JButton jButton92;
    private javax.swing.JButton jButton93;
    private javax.swing.JButton jButton94;
    private javax.swing.JButton jButton95;
    private javax.swing.JButton jButton96;
    private javax.swing.JButton jButton97;
    private javax.swing.JButton jButton98;
    private javax.swing.JButton jButton99;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblIdBan;
    private javax.swing.JLabel lblLoaiBan;
    private javax.swing.JLabel lblTinhTrangBan;
    private javax.swing.JLabel lblTongGia;
    private javax.swing.JPanel pnlDanhSachBan;
    private javax.swing.JTable tblDonGoi;
    // End of variables declaration//GEN-END:variables
}
