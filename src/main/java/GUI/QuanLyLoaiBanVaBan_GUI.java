package GUI;

import BUS.Ban_BUS;
import BUS.LoaiBan_BUS;
import DAO.LoaiBan_DAO;
import DTO.Ban.BanFull_DTO;
import DTO.Ban.Ban_DTO;
import DTO.Ban.CreateBan_DTO;
import DTO.Ban.CreateLoaiBan_DTO;
import DTO.Ban.LoaiBan_DTO;
import DTO.Ban.TinhTrangBan_DTO;
import DTO.Ban.UpdateBan_DTO;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author LeAnhQuan
 */
public class QuanLyLoaiBanVaBan_GUI extends javax.swing.JFrame {

    private final LoaiBan_BUS loaiBan_BUS;
    private final Ban_BUS ban_BUS;
    private boolean dangThemLoaiBan = true;
    private boolean dangThemBan = true;
    
    private ArrayList<LoaiBan_DTO> listLoaiBan;
    private ArrayList<TinhTrangBan_DTO> listTinhTrangBan;
    
    /**
     * Creates new form Test
     */
    public QuanLyLoaiBanVaBan_GUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        loaiBan_BUS = new LoaiBan_BUS();
        ban_BUS = new Ban_BUS();
        
        
        loadTableLoaiBan();
        loadTableBan();
        loadComboBoxLoaiBan();
        loadComboBoxTinhTrangBan();
    }
    
    private void loadTableLoaiBan(){
        ArrayList<LoaiBan_DTO> listLoaiBan = loaiBan_BUS.getAllLoaiBan();
        String col[] = {"ID", "Tên loại bàn", "Số chỗ ngồi"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        tblLoaiBan.setModel(tableModel);
        for(LoaiBan_DTO row : listLoaiBan){
            Object[] data = {row.getId(), row.getTen(), row.getSoLuongCho()};
            tableModel.addRow(data);
        }
    }
    
    private void loadTableBan(){
        ArrayList<Ban_DTO> listBan = ban_BUS.getAllBan();
        String col[] = {"ID", "Tên loại bàn", "Tình trạng"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        tblBan.setModel(tableModel);
        for(Ban_DTO row : listBan){
            Object[] data = {row.getId(), row.getLoaiBan(), row.getTinhTrangBan()};
            tableModel.addRow(data);
        }
    }
    
    private void loadComboBoxLoaiBan(){
        listLoaiBan = loaiBan_BUS.getAllLoaiBan();        
        
        for(LoaiBan_DTO loaiBan : listLoaiBan){
            cmbLoaiBan.addItem(loaiBan.getTen());
        }      
        
        cmbLoaiBan.setSelectedIndex(-1);
    }
    
    private void loadComboBoxTinhTrangBan(){
        listTinhTrangBan = ban_BUS.getAllTinhTrangBan();        
        
        for(TinhTrangBan_DTO ttb : listTinhTrangBan){
            cmbTinhTrangBan.addItem(ttb.getTen());
        }        
        
        cmbTinhTrangBan.setSelectedIndex(-1);
    }
    
    private void clearTextViewLoaiBan(){
        txtIDLoaiBan.setText("");
        txtTenLoaiBan.setText("");
        txtSoChoNgoi.setText("");
    }
    
    private void clearTextViewBan(){
        txtIdBan.setText("");
        cmbLoaiBan.setSelectedIndex(-1);
        cmbTinhTrangBan.setSelectedIndex(-1);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLoaiBan = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnThemLoaiBan = new javax.swing.JButton();
        btnSuaLoaiBan = new javax.swing.JButton();
        btnXoaLoaiBan = new javax.swing.JButton();
        pnlThemSuaLoaiBan = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtIDLoaiBan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTenLoaiBan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSoChoNgoi = new javax.swing.JTextField();
        btnResetLoaiBan = new javax.swing.JButton();
        btnLuuLoaiBan = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10));
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblBan = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnThemBan = new javax.swing.JButton();
        btnSuaBan = new javax.swing.JButton();
        btnXoaBan = new javax.swing.JButton();
        pnlThemSuaBan = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtIdBan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnResetBan = new javax.swing.JButton();
        btnLuuBan = new javax.swing.JButton();
        cmbLoaiBan = new javax.swing.JComboBox<>();
        cmbTinhTrangBan = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý bàn và loại bàn");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Quản lý loại bàn\n"));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách loại bàn\n"));
        jPanel2.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(387, 197));

        tblLoaiBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Tên loại bàn", "Số chỗ ngồi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        tblLoaiBan.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        tblLoaiBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiBanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblLoaiBan);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2);

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng cho loại bàn\n"));

        btnThemLoaiBan.setText("Thêm");
        btnThemLoaiBan.setEnabled(false);
        btnThemLoaiBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemLoaiBanMouseClicked(evt);
            }
        });
        btnThemLoaiBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLoaiBanActionPerformed(evt);
            }
        });
        jPanel3.add(btnThemLoaiBan);

        btnSuaLoaiBan.setText("Sửa");
        btnSuaLoaiBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaLoaiBanMouseClicked(evt);
            }
        });
        jPanel3.add(btnSuaLoaiBan);

        btnXoaLoaiBan.setText("Xóa");
        btnXoaLoaiBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaLoaiBanMouseClicked(evt);
            }
        });
        jPanel3.add(btnXoaLoaiBan);

        jPanel4.add(jPanel3);

        pnlThemSuaLoaiBan.setBorder(javax.swing.BorderFactory.createTitledBorder("Thêm loại bàn mới\n"));
        pnlThemSuaLoaiBan.setName(""); // NOI18N
        pnlThemSuaLoaiBan.setLayout(new java.awt.GridBagLayout());

        jLabel4.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlThemSuaLoaiBan.add(jLabel4, gridBagConstraints);

        txtIDLoaiBan.setEnabled(false);
        txtIDLoaiBan.setPreferredSize(new java.awt.Dimension(128, 22));
        txtIDLoaiBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDLoaiBanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        pnlThemSuaLoaiBan.add(txtIDLoaiBan, gridBagConstraints);

        jLabel5.setText("Tên loại bàn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlThemSuaLoaiBan.add(jLabel5, gridBagConstraints);

        txtTenLoaiBan.setMinimumSize(new java.awt.Dimension(128, 22));
        txtTenLoaiBan.setPreferredSize(new java.awt.Dimension(128, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        pnlThemSuaLoaiBan.add(txtTenLoaiBan, gridBagConstraints);

        jLabel6.setText("Số chỗ ngồi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        pnlThemSuaLoaiBan.add(jLabel6, gridBagConstraints);

        txtSoChoNgoi.setMinimumSize(new java.awt.Dimension(128, 22));
        txtSoChoNgoi.setPreferredSize(new java.awt.Dimension(128, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        pnlThemSuaLoaiBan.add(txtSoChoNgoi, gridBagConstraints);

        btnResetLoaiBan.setText("Reset");
        btnResetLoaiBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetLoaiBanMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlThemSuaLoaiBan.add(btnResetLoaiBan, gridBagConstraints);

        btnLuuLoaiBan.setText("Lưu");
        btnLuuLoaiBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLuuLoaiBanMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlThemSuaLoaiBan.add(btnLuuLoaiBan, gridBagConstraints);

        jPanel4.add(pnlThemSuaLoaiBan);

        jPanel1.add(jPanel4);

        getContentPane().add(jPanel1);
        getContentPane().add(filler1);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Quản lý bàn\n"));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.X_AXIS));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách bàn\n"));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jScrollPane4.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(387, 197));

        tblBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Tên loại bàn", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        tblBan.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        tblBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBanMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblBan);

        jPanel6.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel6);

        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng cho bàn\n"));

        btnThemBan.setText("Thêm");
        btnThemBan.setEnabled(false);
        btnThemBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemBanMouseClicked(evt);
            }
        });
        jPanel12.add(btnThemBan);

        btnSuaBan.setText("Sửa");
        btnSuaBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaBanMouseClicked(evt);
            }
        });
        jPanel12.add(btnSuaBan);

        btnXoaBan.setText("Xóa");
        btnXoaBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaBanMouseClicked(evt);
            }
        });
        jPanel12.add(btnXoaBan);

        jPanel11.add(jPanel12);

        pnlThemSuaBan.setBorder(javax.swing.BorderFactory.createTitledBorder("Thêm loại bàn mới\n"));
        pnlThemSuaBan.setName(""); // NOI18N
        pnlThemSuaBan.setLayout(new java.awt.GridBagLayout());

        jLabel7.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlThemSuaBan.add(jLabel7, gridBagConstraints);

        txtIdBan.setEnabled(false);
        txtIdBan.setPreferredSize(new java.awt.Dimension(128, 22));
        txtIdBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdBanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        pnlThemSuaBan.add(txtIdBan, gridBagConstraints);

        jLabel8.setText("Tên loại bàn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlThemSuaBan.add(jLabel8, gridBagConstraints);

        jLabel9.setText("Tình trạng bàn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        pnlThemSuaBan.add(jLabel9, gridBagConstraints);

        btnResetBan.setText("Reset");
        btnResetBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetBanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnResetBanMouseEntered(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlThemSuaBan.add(btnResetBan, gridBagConstraints);

        btnLuuBan.setText("Lưu");
        btnLuuBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLuuBanMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlThemSuaBan.add(btnLuuBan, gridBagConstraints);

        cmbLoaiBan.setPreferredSize(new java.awt.Dimension(128, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        pnlThemSuaBan.add(cmbLoaiBan, gridBagConstraints);

        cmbTinhTrangBan.setPreferredSize(new java.awt.Dimension(128, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        pnlThemSuaBan.add(cmbTinhTrangBan, gridBagConstraints);

        jPanel11.add(pnlThemSuaBan);

        jPanel5.add(jPanel11);

        getContentPane().add(jPanel5);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDLoaiBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDLoaiBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDLoaiBanActionPerformed

    private void btnLuuLoaiBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuLoaiBanMouseClicked
        // TODO add your handling code here:
        String tenLoaiBan = txtTenLoaiBan.getText().trim();
        if(tenLoaiBan.isBlank())
            JOptionPane.showMessageDialog(this, "Tên bàn không được để trống","Error", JOptionPane.ERROR_MESSAGE);
            
        int soChoNgoi;
        try{            
            soChoNgoi = Integer.parseInt(txtSoChoNgoi.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Nhập sai định dạng số chỗ ngồi","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(soChoNgoi <= 0){
            JOptionPane.showMessageDialog(this, "Số chỗ ngồi phải lớn hơn 0","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(dangThemLoaiBan){
            CreateLoaiBan_DTO data = new CreateLoaiBan_DTO(tenLoaiBan, soChoNgoi);

            boolean result = loaiBan_BUS.createLoaiBan(data);
            if(result){
                JOptionPane.showMessageDialog(this, "Thêm loại bàn mới thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                clearTextViewLoaiBan();            
            }            
            else
                JOptionPane.showMessageDialog(this, "Thêm loại bàn mới thất bại","Error", JOptionPane.ERROR_MESSAGE);

        } else {
            int id = Integer.parseInt(txtIDLoaiBan.getText());
            
            LoaiBan_DTO data = new LoaiBan_DTO(id, tenLoaiBan, soChoNgoi);
            
            boolean result = loaiBan_BUS.updateLoaiBan(data);
            if(result){
                JOptionPane.showMessageDialog(this, "Sửa loại bàn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                clearTextViewLoaiBan();            
            }            
            else
                JOptionPane.showMessageDialog(this, "Sửa loại bàn mới thất bại","Error", JOptionPane.ERROR_MESSAGE);
        }
        loadTableLoaiBan();
    }//GEN-LAST:event_btnLuuLoaiBanMouseClicked

    private void btnSuaLoaiBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaLoaiBanMouseClicked
        // TODO add your handling code here:
        btnThemLoaiBan.setEnabled(true);
        btnSuaLoaiBan.setEnabled(false);
        dangThemLoaiBan = false;
        pnlThemSuaLoaiBan.setBorder(BorderFactory.createTitledBorder("Sửa loại bàn"));
        pnlThemSuaLoaiBan.repaint();
        clearTextViewLoaiBan();
    }//GEN-LAST:event_btnSuaLoaiBanMouseClicked

    private void btnResetLoaiBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetLoaiBanMouseClicked
        // TODO add your handling code here:
        if(dangThemLoaiBan)
            clearTextViewLoaiBan();
        else {
            int id = Integer.parseInt(txtIDLoaiBan.getText());
            LoaiBan_DTO result = loaiBan_BUS.getLoaiBanByID(id);
        
            if(result == null){
                JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            txtTenLoaiBan.setText(result.getTen());
            txtSoChoNgoi.setText(Integer.toString(result.getSoLuongCho()));
        }        
    }//GEN-LAST:event_btnResetLoaiBanMouseClicked

    private void btnThemLoaiBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemLoaiBanMouseClicked
        // TODO add your handling code here:
        btnThemLoaiBan.setEnabled(false);
        btnSuaLoaiBan.setEnabled(true);
        dangThemLoaiBan = true;
        pnlThemSuaLoaiBan.setBorder(BorderFactory.createTitledBorder("Thêm loại bàn mới"));
        pnlThemSuaLoaiBan.repaint();
        clearTextViewLoaiBan();
    }//GEN-LAST:event_btnThemLoaiBanMouseClicked

    private void tblLoaiBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiBanMouseClicked
        // TODO add your handling code here:  
        if(dangThemLoaiBan)
            return;
        
        int index = tblLoaiBan.getSelectedRow();
        TableModel model = tblLoaiBan.getModel();
        
        int id = Integer.parseInt(model.getValueAt(index, 0).toString());
        LoaiBan_DTO result = loaiBan_BUS.getLoaiBanByID(id);
        
        if(result == null){
            JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        txtIDLoaiBan.setText(Integer.toString(result.getId()));
        txtTenLoaiBan.setText(result.getTen());
        txtSoChoNgoi.setText(Integer.toString(result.getSoLuongCho()));
    }//GEN-LAST:event_tblLoaiBanMouseClicked

    private void btnXoaLoaiBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaLoaiBanMouseClicked
        // TODO add your handling code here:
        int total = tblLoaiBan.getSelectedRowCount();
        TableModel model = tblLoaiBan.getModel();
        if(total < 1)
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn loại bàn muốn xóa","Error", JOptionPane.ERROR_MESSAGE);
        
        int confirm = JOptionPane.showConfirmDialog(null, 
                "Bạn có chắc chắn muốn xóa " + total + " loại bàn không ?", "Xóa dữ liệu loại bàn!", JOptionPane.OK_CANCEL_OPTION);
        
        if(confirm == JOptionPane.CANCEL_OPTION)
            return;
        
        if(total == 1){
            int index = tblLoaiBan.getSelectedRow();

            int id = Integer.parseInt(model.getValueAt(index, 0).toString());

            boolean result = loaiBan_BUS.deleteLoaiBanById(id); 
            if(result){
                JOptionPane.showMessageDialog(this, "Xóa 1 loại bàn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                
            }            
            else
                JOptionPane.showMessageDialog(this, "Xóa thất bại","Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int[] listIndex = tblLoaiBan.getSelectedRows();
            ArrayList<Integer> listID = new ArrayList<>();
            
            for(int index : listIndex) {
                listID.add(Integer.valueOf(model.getValueAt(index, 0).toString()));
            }
            
            int result = loaiBan_BUS.deleteNhieuLoaiBan(listID);
            if(result == listID.size())
                JOptionPane.showMessageDialog(this, "Xóa " + total + " loại bàn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
            else if(result > 0)
                JOptionPane.showMessageDialog(this, "Xóa thất bại, chỉ xóa được " + total + " loại bàn","Error", JOptionPane.ERROR_MESSAGE);
            else 
                JOptionPane.showMessageDialog(this, "Xóa thất bại, không loại bàn nào được xóa","Error", JOptionPane.ERROR_MESSAGE);            
                
        }
        clearTextViewLoaiBan();  
        loadTableLoaiBan();
    }//GEN-LAST:event_btnXoaLoaiBanMouseClicked

    private void tblBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBanMouseClicked
        // TODO add your handling code here:
        if(dangThemBan)
            return;
        
        int index = tblBan.getSelectedRow();
        TableModel model = tblBan.getModel();
        
        int id = Integer.parseInt(model.getValueAt(index, 0).toString());
        BanFull_DTO result = ban_BUS.getBanFullById(id);
        
        if(result == null){
            JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int indexLoaiBan = -1;
        for (int i = 0; i < listLoaiBan.size(); i++) {
            if(result.getLoaiBan().getId() == listLoaiBan.get(i).getId())
                indexLoaiBan = i;
        }
        int indexTinhTrangBan = -1;
        for (int i = 0; i < listTinhTrangBan.size(); i++) {
            if(result.getTinhTrangBan().getId() == listTinhTrangBan.get(i).getId())
                indexTinhTrangBan = i;
        }
        
        if(indexLoaiBan == -1 || indexTinhTrangBan == -1){
            JOptionPane.showMessageDialog(this, "Dữ liệu bị lỗi","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        txtIdBan.setText(Integer.toString(id));
        cmbLoaiBan.setSelectedIndex(indexLoaiBan);
        cmbTinhTrangBan.setSelectedIndex(indexTinhTrangBan);
    }//GEN-LAST:event_tblBanMouseClicked

    private void btnThemBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemBanMouseClicked
        // TODO add your handling code here:
        btnThemBan.setEnabled(false);
        btnSuaBan.setEnabled(true);
        dangThemBan = true;
        pnlThemSuaBan.setBorder(BorderFactory.createTitledBorder("Thêm loại bàn mới"));
        pnlThemSuaBan.repaint();
        clearTextViewLoaiBan();
    }//GEN-LAST:event_btnThemBanMouseClicked

    private void btnSuaBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaBanMouseClicked
        // TODO add your handling code here:
        btnThemBan.setEnabled(true);
        btnSuaBan.setEnabled(false);
        dangThemBan = false;
        pnlThemSuaBan.setBorder(BorderFactory.createTitledBorder("Sửa loại bàn"));
        pnlThemSuaBan.repaint();
        clearTextViewBan();
    }//GEN-LAST:event_btnSuaBanMouseClicked

    private void btnXoaBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaBanMouseClicked
        // TODO add your handling code here:
        int total = tblBan.getSelectedRowCount();
        TableModel model = tblBan.getModel();
        if(total < 1)
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn bàn muốn xóa","Error", JOptionPane.ERROR_MESSAGE);
        
        int confirm = JOptionPane.showConfirmDialog(null, 
                "Bạn có chắc chắn muốn xóa " + total + " bàn không ?", "Xóa dữ liệu loại bàn!", JOptionPane.OK_CANCEL_OPTION);
        
        if(confirm == JOptionPane.CANCEL_OPTION)
            return;
        
        if(total == 1){
            int index = tblBan.getSelectedRow();

            int id = Integer.parseInt(model.getValueAt(index, 0).toString());

            boolean result = ban_BUS.deleteBanById(id); 
            if(result){
                JOptionPane.showMessageDialog(this, "Xóa 1 bàn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                
            }            
            else
                JOptionPane.showMessageDialog(this, "Xóa thất bại","Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int[] listIndex = tblBan.getSelectedRows();
            ArrayList<Integer> listID = new ArrayList<>();
            
            for(int index : listIndex) {
                listID.add(Integer.valueOf(model.getValueAt(index, 0).toString()));
            }
            
            int result = ban_BUS.deleteNhieuBanByListId(listID);
            if(result == listID.size())
                JOptionPane.showMessageDialog(this, "Xóa " + total + " loại bàn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
            else if(result > 0)
                JOptionPane.showMessageDialog(this, "Xóa thất bại, chỉ xóa được " + total + " loại bàn","Error", JOptionPane.ERROR_MESSAGE);
            else 
                JOptionPane.showMessageDialog(this, "Xóa thất bại, không loại bàn nào được xóa","Error", JOptionPane.ERROR_MESSAGE);            
                
        }
        clearTextViewBan();  
        loadTableBan();       
    }//GEN-LAST:event_btnXoaBanMouseClicked

    private void txtIdBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdBanActionPerformed

    private void btnResetBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetBanMouseClicked
        // TODO add your handling code here:
        if(dangThemBan){
            loadComboBoxLoaiBan();
            loadComboBoxTinhTrangBan();
        } else {
            int id = Integer.parseInt(txtIdBan.getText());
            BanFull_DTO result = ban_BUS.getBanFullById(id);

            if(result == null){
                JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int indexLoaiBan = -1;
            for (int i = 0; i < listLoaiBan.size(); i++) {
                if(result.getLoaiBan().getId() == listLoaiBan.get(i).getId())
                    indexLoaiBan = i;
            }
            int indexTinhTrangBan = -1;
            for (int i = 0; i < listTinhTrangBan.size(); i++) {
                if(result.getTinhTrangBan().getId() == listTinhTrangBan.get(i).getId())
                    indexTinhTrangBan = i;
            }

            if(indexLoaiBan == -1 || indexTinhTrangBan == -1){
                JOptionPane.showMessageDialog(this, "Dữ liệu bị lỗi","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            txtIdBan.setText(Integer.toString(id));
            cmbLoaiBan.setSelectedIndex(indexLoaiBan);
            cmbTinhTrangBan.setSelectedIndex(indexTinhTrangBan);
        }
    }//GEN-LAST:event_btnResetBanMouseClicked

    private void btnLuuBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuBanMouseClicked
        // TODO add your handling code here:
        int indexLoaiBan = cmbLoaiBan.getSelectedIndex();
        if(indexLoaiBan < 0)
            JOptionPane.showMessageDialog(this, "Chưa chọn loại bàn","Error", JOptionPane.ERROR_MESSAGE);

        int indexTinhTrangBan = cmbTinhTrangBan.getSelectedIndex();
        if(indexTinhTrangBan < 0)
            JOptionPane.showMessageDialog(this, "Chưa chọn tình trạng bàn","Error", JOptionPane.ERROR_MESSAGE);         

        int idLoaiBan = listLoaiBan.get(indexLoaiBan).getId();
        int idTinhTrangBan = listTinhTrangBan.get(indexTinhTrangBan).getId();
        if (dangThemBan){
            CreateBan_DTO data = new CreateBan_DTO(idLoaiBan, idTinhTrangBan);

            boolean result = ban_BUS.createBan(data);
            if(result){
                JOptionPane.showMessageDialog(this, "Thêm bàn mới thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                clearTextViewBan();  
                loadTableBan();
            }            
            else
                JOptionPane.showMessageDialog(this, "Thêm bàn mới thất bại","Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int idBan = Integer.parseInt(txtIdBan.getText());
            UpdateBan_DTO data = new UpdateBan_DTO(idBan, idTinhTrangBan, idLoaiBan);
            
            boolean result = ban_BUS.updateBan(data);
            if(result){
                JOptionPane.showMessageDialog(this, "Sửa bàn thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                clearTextViewBan();  
                loadTableBan();
            }            
            else
                JOptionPane.showMessageDialog(this, "Sửa bàn thất bại","Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLuuBanMouseClicked

    private void btnThemLoaiBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLoaiBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemLoaiBanActionPerformed

    private void btnResetBanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetBanMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetBanMouseEntered

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
            java.util.logging.Logger.getLogger(QuanLyLoaiBanVaBan_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyLoaiBanVaBan_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyLoaiBanVaBan_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyLoaiBanVaBan_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyLoaiBanVaBan_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuuBan;
    private javax.swing.JButton btnLuuLoaiBan;
    private javax.swing.JButton btnResetBan;
    private javax.swing.JButton btnResetLoaiBan;
    private javax.swing.JButton btnSuaBan;
    private javax.swing.JButton btnSuaLoaiBan;
    private javax.swing.JButton btnThemBan;
    private javax.swing.JButton btnThemLoaiBan;
    private javax.swing.JButton btnXoaBan;
    private javax.swing.JButton btnXoaLoaiBan;
    private javax.swing.JComboBox<String> cmbLoaiBan;
    private javax.swing.JComboBox<String> cmbTinhTrangBan;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel pnlThemSuaBan;
    private javax.swing.JPanel pnlThemSuaLoaiBan;
    private javax.swing.JTable tblBan;
    private javax.swing.JTable tblLoaiBan;
    private javax.swing.JTextField txtIDLoaiBan;
    private javax.swing.JTextField txtIdBan;
    private javax.swing.JTextField txtSoChoNgoi;
    private javax.swing.JTextField txtTenLoaiBan;
    // End of variables declaration//GEN-END:variables

}
