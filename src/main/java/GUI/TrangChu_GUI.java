/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

/**
 *
 * @author tuant
 */
public class TrangChu_GUI extends javax.swing.JFrame {

    /**
     * Creates new form TrangChu_GUI
     */
    public TrangChu_GUI() {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setMinimumSize(new java.awt.Dimension(200, 100));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 103));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Trang chủ");
        jPanel3.add(jLabel1, new java.awt.GridBagConstraints());

        jPanel1.add(jPanel3, java.awt.BorderLayout.LINE_START);

        jPanel4.setMinimumSize(new java.awt.Dimension(200, 100));
        jPanel4.setPreferredSize(new java.awt.Dimension(200, 103));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Huỳnh Tuấn Thanh");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        jPanel4.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Đăng xuất");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 10);
        jPanel4.add(jLabel3, gridBagConstraints);

        jPanel1.add(jPanel4, java.awt.BorderLayout.LINE_END);

        jPanel5.setPreferredSize(new java.awt.Dimension(350, 103));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 103, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\tuant\\OneDrive\\Máy tính\\anh qlnh\\person_add_FILL0_wght400_GRAD0_opsz48.png")); // NOI18N
        jButton1.setText("<html>\n<p style =\"margin-top:60px;\"> Quản lý phục vụ</p>\n</html>");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setIconTextGap(10);
        jButton1.setMinimumSize(new java.awt.Dimension(200, 130));
        jButton1.setPreferredSize(new java.awt.Dimension(200, 130));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 10);
        jPanel2.add(jButton1, gridBagConstraints);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\tuant\\OneDrive\\Máy tính\\anh qlnh\\local_pizza_FILL0_wght400_GRAD0_opsz48.png")); // NOI18N
        jButton2.setText("<html>\n<p style =\"margin-top:60px;\">Quản lý món ăn </p>\n</html>");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setMinimumSize(new java.awt.Dimension(200, 130));
        jButton2.setPreferredSize(new java.awt.Dimension(200, 130));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        jPanel2.add(jButton2, gridBagConstraints);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\tuant\\OneDrive\\Máy tính\\anh qlnh\\local_pizza_FILL0_wght400_GRAD0_opsz48.png")); // NOI18N
        jButton3.setText("<html>\n<p style =\"margin-top:60px;\"> Quản lý biến thể món ăn</p>\n</html>");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setMinimumSize(new java.awt.Dimension(200, 130));
        jButton3.setPreferredSize(new java.awt.Dimension(200, 130));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        jPanel2.add(jButton3, gridBagConstraints);

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\tuant\\OneDrive\\Máy tính\\anh qlnh\\table_FILL0_wght400_GRAD0_opsz48.png")); // NOI18N
        jButton4.setText("<html>\n<p style =\"margin-top:60px;\">Quản lý bàn </p>\n</html>");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setMinimumSize(new java.awt.Dimension(200, 130));
        jButton4.setPreferredSize(new java.awt.Dimension(200, 130));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        jPanel2.add(jButton4, gridBagConstraints);

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\tuant\\OneDrive\\Máy tính\\anh qlnh\\receipt_long_FILL0_wght400_GRAD0_opsz48.png")); // NOI18N
        jButton5.setText("<html>\n<p style =\"margin-top:60px;\"> Quản lý hóa đơn</p>\n</html>");
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setMinimumSize(new java.awt.Dimension(200, 130));
        jButton5.setPreferredSize(new java.awt.Dimension(200, 130));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 10);
        jPanel2.add(jButton5, gridBagConstraints);

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\tuant\\OneDrive\\Máy tính\\anh qlnh\\groups_FILL0_wght400_GRAD0_opsz48.png")); // NOI18N
        jButton6.setText("<html>\n<p style =\"margin-top:60px;\">Quản lý nhân viên</p>\n</html>");
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setMinimumSize(new java.awt.Dimension(200, 130));
        jButton6.setPreferredSize(new java.awt.Dimension(200, 130));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        jPanel2.add(jButton6, gridBagConstraints);

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon("C:\\Users\\tuant\\OneDrive\\Máy tính\\anh qlnh\\person_FILL0_wght400_GRAD0_opsz48.png")); // NOI18N
        jButton7.setText("<html>\n<p style =\"margin-top:60px;\">Quản lý khách hàng</p>\n</html>");
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setMinimumSize(new java.awt.Dimension(180, 100));
        jButton7.setPreferredSize(new java.awt.Dimension(200, 130));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        jPanel2.add(jButton7, gridBagConstraints);

        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon("C:\\Users\\tuant\\OneDrive\\Máy tính\\anh qlnh\\manage_accounts_FILL0_wght400_GRAD0_opsz48.png")); // NOI18N
        jButton8.setText("<html>\n<p style =\"margin-top:60px;\">Quản lý tài khoản</p>\n</html>");
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setMinimumSize(new java.awt.Dimension(200, 130));
        jButton8.setPreferredSize(new java.awt.Dimension(200, 130));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        jPanel2.add(jButton8, gridBagConstraints);

        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon("C:\\Users\\tuant\\OneDrive\\Máy tính\\anh qlnh\\manage_accounts_FILL0_wght400_GRAD0_opsz48.png")); // NOI18N
        jButton9.setText("<html>\n<p style =\"margin-top:60px;\"> Quản lý quyền</p>\n</html>");
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setMinimumSize(new java.awt.Dimension(200, 130));
        jButton9.setPreferredSize(new java.awt.Dimension(200, 130));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 10);
        jPanel2.add(jButton9, gridBagConstraints);

        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon("C:\\Users\\tuant\\OneDrive\\Máy tính\\anh qlnh\\monitoring_FILL0_wght400_GRAD0_opsz48.png")); // NOI18N
        jButton10.setText("<html>\n<p style =\"margin-top:60px;\"> Báo cáo & Thống kê</p>\n</html>");
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setMinimumSize(new java.awt.Dimension(200, 130));
        jButton10.setPreferredSize(new java.awt.Dimension(200, 130));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        jPanel2.add(jButton10, gridBagConstraints);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(TrangChu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChu_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
