/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.NhanVien_BUS;
import DTO.TaiKhoan_DTO;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author tuant
 */
public class DangNhap_GUI extends javax.swing.JFrame {
    NhanVien_BUS nhanVien_BUS;
    
    /**
     * Creates new form DangNhap_GUI
     */
    public DangNhap_GUI() {
        initComponents();
        nhanVien_BUS = new NhanVien_BUS();
    }
    
    private void logIn(){
        String username = txtTaiKhoan.getText().trim();
        String password = new String(txtMatKhau.getPassword());
        
        TaiKhoan_DTO taiKhoan_DTO = new TaiKhoan_DTO(username, password);
        
        if(nhanVien_BUS.dangNhap(taiKhoan_DTO)){
            TrangChuNew_GUI trangChu_GUI = new TrangChuNew_GUI(username);
            trangChu_GUI.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Đăng nhập thất bại","Error", JOptionPane.ERROR_MESSAGE);
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

        btnDangNhap = new javax.swing.JButton();
        txtTaiKhoan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập\n");
        setMinimumSize(new java.awt.Dimension(400, 300));
        setPreferredSize(new java.awt.Dimension(400, 300));
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.setMaximumSize(new java.awt.Dimension(88, 40));
        btnDangNhap.setMinimumSize(new java.awt.Dimension(150, 40));
        btnDangNhap.setPreferredSize(new java.awt.Dimension(150, 40));
        btnDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDangNhapMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDangNhapMouseEntered(evt);
            }
        });
        btnDangNhap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnDangNhapKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(16, 20, 4, 20);
        getContentPane().add(btnDangNhap, gridBagConstraints);

        txtTaiKhoan.setMinimumSize(new java.awt.Dimension(250, 22));
        txtTaiKhoan.setPreferredSize(new java.awt.Dimension(250, 22));
        txtTaiKhoan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTaiKhoanKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 20);
        getContentPane().add(txtTaiKhoan, gridBagConstraints);

        jLabel3.setText("Mật khẩu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 20);
        getContentPane().add(jLabel3, gridBagConstraints);

        jLabel2.setText("Tài khoản");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 20);
        getContentPane().add(jLabel2, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý nhà hàng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 20);
        getContentPane().add(jLabel1, gridBagConstraints);

        txtMatKhau.setToolTipText("Nhập mật khẩu");
        txtMatKhau.setMinimumSize(new java.awt.Dimension(250, 22));
        txtMatKhau.setPreferredSize(new java.awt.Dimension(250, 22));
        txtMatKhau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMatKhauKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 20, 4, 20);
        getContentPane().add(txtMatKhau, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangNhapMouseClicked
        // TODO add your handling code here:
        logIn();
    }//GEN-LAST:event_btnDangNhapMouseClicked

    private void btnDangNhapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangNhapMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDangNhapMouseEntered

    private void btnDangNhapKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnDangNhapKeyPressed
        // TODO add your handling code here:
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                logIn();
                break;
            default:
        }
    }//GEN-LAST:event_btnDangNhapKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                logIn();
                break;
            default:
        }
    }//GEN-LAST:event_formKeyPressed

    private void txtTaiKhoanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTaiKhoanKeyPressed
        // TODO add your handling code here:        
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                logIn();
                break;
            default:
        }
    }//GEN-LAST:event_txtTaiKhoanKeyPressed

    private void txtMatKhauKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatKhauKeyPressed
        // TODO add your handling code here:        
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                logIn();
                break;
            default:
        }
    }//GEN-LAST:event_txtMatKhauKeyPressed

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
            java.util.logging.Logger.getLogger(DangNhap_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhap_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhap_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhap_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhap_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
