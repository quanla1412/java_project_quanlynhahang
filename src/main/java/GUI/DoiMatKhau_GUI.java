package GUI;

import BUS.NhanVien_BUS;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author LeAnhQuan
 */
public class DoiMatKhau_GUI extends javax.swing.JFrame {
    private NhanVien_BUS nhanVien_BUS;
    private String maNhanVien;
    /**
     * Creates new form DoiMatKhau
     */
    public DoiMatKhau_GUI(String maNhanVien) {
        initComponents();
        nhanVien_BUS = new NhanVien_BUS();
        this.maNhanVien = maNhanVien;
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
        btnSuccess = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtRetypePassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Đổi mật khẩu");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        btnSuccess.setText("Đổi mật khẩu");
        btnSuccess.setMinimumSize(new java.awt.Dimension(150, 23));
        btnSuccess.setPreferredSize(new java.awt.Dimension(150, 23));
        btnSuccess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuccessMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSuccessMouseEntered(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(btnSuccess, gridBagConstraints);

        jLabel3.setText("Nhập lại mật khẩu mới");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel2.setText("Mật khẩu mới");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        txtPassword.setMinimumSize(new java.awt.Dimension(250, 22));
        txtPassword.setPreferredSize(new java.awt.Dimension(250, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel1.add(txtPassword, gridBagConstraints);

        txtRetypePassword.setMinimumSize(new java.awt.Dimension(250, 22));
        txtRetypePassword.setPreferredSize(new java.awt.Dimension(250, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        jPanel1.add(txtRetypePassword, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuccessMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuccessMouseClicked
        // TODO add your handling code here:
        String password = Arrays.toString(txtPassword.getPassword());
        String retypePassword = Arrays.toString(txtRetypePassword.getPassword());

        if(password.equals(retypePassword)){
            boolean result = nhanVien_BUS.doiMatKhau(maNhanVien, password);
            if(result){
                JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }            
            else
                JOptionPane.showMessageDialog(this, "Đổi mật khẩu thất bại","Error", JOptionPane.ERROR_MESSAGE);
        } 
        else
                JOptionPane.showMessageDialog(this, "Nhập lại mật khẩu không đúng","Error", JOptionPane.ERROR_MESSAGE);
        
        
    }//GEN-LAST:event_btnSuccessMouseClicked

    private void btnSuccessMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuccessMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuccessMouseEntered

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
            java.util.logging.Logger.getLogger(DoiMatKhau_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new DoiMatKhau_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuccess;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtRetypePassword;
    // End of variables declaration//GEN-END:variables
}
