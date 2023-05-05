/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartHome;

import javax.swing.JOptionPane;
import Lib.Source;
import java.sql.*;
import Lib.Source;

/**
 *
 * @author user
 */
public class Login extends javax.swing.JFrame {

    ResultSet rs = null;
    Connection conn = null;
    Statement stmt = null;
    
    public Login() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUserId = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        forgetPswdTxt = new javax.swing.JLabel();
        btnAddAdmin = new javax.swing.JButton();
        showPswd = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Login");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("User ID");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Password");

        txtUserId.setBackground(new java.awt.Color(51, 51, 51));
        txtUserId.setForeground(new java.awt.Color(255, 255, 255));

        txtPassword.setBackground(new java.awt.Color(51, 51, 51));
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        forgetPswdTxt.setForeground(new java.awt.Color(0, 0, 0));
        forgetPswdTxt.setText("forget password?");
        forgetPswdTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgetPswdTxtMouseClicked(evt);
            }
        });

        btnAddAdmin.setBackground(new java.awt.Color(0, 0, 0));
        btnAddAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnAddAdmin.setText("ADD ADMIN");
        btnAddAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAdminActionPerformed(evt);
            }
        });

        showPswd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPswdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(forgetPswdTxt)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtUserId)
                                        .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddAdmin)
                    .addComponent(showPswd))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(showPswd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(forgetPswdTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(87, 87, 87))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            
           Class.forName(Source.driver);
           conn = DriverManager.getConnection(Source.url,Source.userName,Source.password);
           stmt = conn.createStatement();
           
           if(txtUserId.getText().length() != 0 && txtPassword.getText().length() != 0){
               
           rs = stmt.executeQuery("select * from login where user_ID='"+txtUserId.getText()+"' and password='"+txtPassword.getText()+"'");
           
           int count = 0;
           
           while(rs.next()){
               System.out.println(""+rs.getString("user_ID"));
               count++;
           }
           
           if(count > 0){
               stmt.executeUpdate("update developerOption set token='"+Source.login+"' where user='"+Source.user+"'");
               
               JOptionPane.showMessageDialog(this,"Login Success");
               Home hm = new Home();
               this.setVisible(false);
               hm.setVisible(true);
           }else{
                JOptionPane.showMessageDialog(this,"Login Fail");
           }
               
           }else{
               JOptionPane.showMessageDialog(this,"You need to fill username or password");
           }
           
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.toString());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void forgetPswdTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgetPswdTxtMouseClicked
        ForgetPassword fp = new ForgetPassword();
        this.setVisible(false);
        fp.setVisible(true);
    }//GEN-LAST:event_forgetPswdTxtMouseClicked

    private void btnAddAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAdminActionPerformed
       AddAdmin aad = new AddAdmin();
       this.setVisible(false);
       aad.setVisible(true);
    }//GEN-LAST:event_btnAddAdminActionPerformed

    private void showPswdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPswdActionPerformed
            if(showPswd.isSelected()){
                 txtPassword.setEchoChar((char)0);
            }else{
               txtPassword.setEchoChar('*');
            }
    }//GEN-LAST:event_showPswdActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAdmin;
    private javax.swing.JLabel forgetPswdTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox showPswd;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserId;
    // End of variables declaration//GEN-END:variables
}
