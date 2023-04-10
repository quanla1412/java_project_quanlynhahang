/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

/**
 *
 * @author dinhn
 */
public class ThemMonAn_GUI extends javax.swing.JFrame {

    /**
     * Creates new form ThemMonAn_GUI
     */
    public ThemMonAn_GUI() {
        initComponents();
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

        jPanel3 = new javax.swing.JPanel();
        lblImageMonAn = new javax.swing.JLabel();
        lblGiaTienMonAn = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmbSizeMonAn = new javax.swing.JComboBox<>();
        cmbDeMonAn = new javax.swing.JComboBox<>();
        cmbLoaiNuoc = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaGhiChuMonAn = new javax.swing.JTextArea();
        lblTinhTrangMonAn = new javax.swing.JLabel();
        btnThemMonAn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        lblImageMonAn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImageMonAn.setIcon(new javax.swing.ImageIcon("C:\\Users\\dinhn\\OneDrive\\Máy tính\\ảnh kỷ yếu\\test.jpg")); // NOI18N
        lblImageMonAn.setMinimumSize(new java.awt.Dimension(250, 250));
        lblImageMonAn.setPreferredSize(new java.awt.Dimension(250, 250));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel3.add(lblImageMonAn, gridBagConstraints);

        lblGiaTienMonAn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblGiaTienMonAn.setForeground(new java.awt.Color(51, 255, 204));
        lblGiaTienMonAn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGiaTienMonAn.setText("69.000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel3.add(lblGiaTienMonAn, gridBagConstraints);

        getContentPane().add(jPanel3);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Hàn kiểu Nhật");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        jPanel2.add(jLabel10, gridBagConstraints);

        jLabel11.setText("Size");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel2.add(jLabel11, gridBagConstraints);

        jLabel12.setText("Đế");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel2.add(jLabel12, gridBagConstraints);

        cmbSizeMonAn.setMinimumSize(new java.awt.Dimension(110, 25));
        cmbSizeMonAn.setName(""); // NOI18N
        cmbSizeMonAn.setPreferredSize(new java.awt.Dimension(110, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        jPanel2.add(cmbSizeMonAn, gridBagConstraints);

        cmbDeMonAn.setMinimumSize(new java.awt.Dimension(110, 25));
        cmbDeMonAn.setPreferredSize(new java.awt.Dimension(110, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        jPanel2.add(cmbDeMonAn, gridBagConstraints);

        cmbLoaiNuoc.setMinimumSize(new java.awt.Dimension(110, 25));
        cmbLoaiNuoc.setPreferredSize(new java.awt.Dimension(110, 25));
        cmbLoaiNuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLoaiNuocActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        jPanel2.add(cmbLoaiNuoc, gridBagConstraints);

        jLabel13.setText("Loại nước");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel2.add(jLabel13, gridBagConstraints);

        jLabel14.setText("Ghi chú");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel2.add(jLabel14, gridBagConstraints);

        jLabel15.setText("Tình trạng:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel2.add(jLabel15, gridBagConstraints);

        txaGhiChuMonAn.setColumns(20);
        txaGhiChuMonAn.setRows(5);
        txaGhiChuMonAn.setMinimumSize(new java.awt.Dimension(0, 0));
        jScrollPane2.setViewportView(txaGhiChuMonAn);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(jScrollPane2, gridBagConstraints);

        lblTinhTrangMonAn.setText("Sẵn Sàng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        jPanel2.add(lblTinhTrangMonAn, gridBagConstraints);

        btnThemMonAn.setText("Thêm món ăn");
        btnThemMonAn.setPreferredSize(new java.awt.Dimension(120, 30));
        btnThemMonAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMonAnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        jPanel2.add(btnThemMonAn, gridBagConstraints);

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemMonAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMonAnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemMonAnActionPerformed

    private void cmbLoaiNuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLoaiNuocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbLoaiNuocActionPerformed

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
            java.util.logging.Logger.getLogger(ThemMonAn_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemMonAn_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemMonAn_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemMonAn_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemMonAn_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThemMonAn;
    private javax.swing.JComboBox<String> cmbDeMonAn;
    private javax.swing.JComboBox<String> cmbLoaiNuoc;
    private javax.swing.JComboBox<String> cmbSizeMonAn;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblGiaTienMonAn;
    private javax.swing.JLabel lblImageMonAn;
    private javax.swing.JLabel lblTinhTrangMonAn;
    private javax.swing.JTextArea txaGhiChuMonAn;
    // End of variables declaration//GEN-END:variables
}
