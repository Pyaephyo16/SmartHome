/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartHome;

import Lib.Source;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Admin extends javax.swing.JFrame {

    ResultSet rs = null;
    Connection conn = null;
    Statement stmt = null;
    
    int columnCount = -1;
    
    public Admin() {
        initComponents();
        allPanelFalse();
        Display();
    }
    
    private void allPanelFalse(){
        panel1.setVisible(false);
        panel2.setVisible(false);
    }
        
    private void allClearTextField(){
        txt2.setText("");
        txt1.setText("");
    }
    
    private void controlRadio(){
          if(rdbInsert.isSelected()){
            
            btnDone.setText("INSERT");
            allClearTextField();
            tbAdmin.clearSelection();
            
        }else if(rdbUpdate.isSelected()){
            
            btnDone.setText("UPDATE"); 
            allClearTextField();
            tbAdmin.clearSelection();
            
        }else if(rdbDelete.isSelected()){
            
            btnDone.setText("DELETE"); 
            allClearTextField();
            tbAdmin.clearSelection();
            
        }else if(rdbSearch.isSelected()){
            
            btnDone.setText("SEARCH"); 
            allClearTextField();
            tbAdmin.clearSelection();
            
        }else{
            btnDone.setText("DONE"); 
            allClearTextField();
            tbAdmin.clearSelection();
        }
    }  
    
    private boolean checkFields(){
     if(txt2.getText().length() !=0 && txt1.getText().length() != 0){
          return true;
             }else{
                 return false;
             }
    }    
    
    private void Display(){
        DefaultTableModel model = (DefaultTableModel) tbAdmin.getModel();
        try{
            
          Class.forName(Source.driver);
          conn = DriverManager.getConnection(Source.url,Source.userName,Source.password);
          stmt = conn.createStatement();
          
          String sql = "select * from login";
          rs = stmt.executeQuery(sql);
          
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        columnCount = resultSetMetaData.getColumnCount();
        String[] displayData = new String[columnCount];
          while(rs.next()){
              for(int i=1;i<=columnCount;i++){
                  displayData[i-1] = rs.getObject(i).toString();
              }
            model.addRow(displayData);
          }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.toString());
        }
    }  
    
    private void optionsWork(String type){
        DefaultTableModel model = (DefaultTableModel) tbAdmin.getModel();
        try{
          
          Class.forName(Source.driver);
          conn = DriverManager.getConnection(Source.url,Source.userName,Source.password);
          stmt = conn.createStatement();
          
          String sql = "";
          if(type == "INSERT"){
              sql = "insert into login values('"+txt1.getText()+"','"+txt2.getText()+"')";
              stmt.execute(sql);
              JOptionPane.showMessageDialog(this,"Add data success");
              model.setRowCount(0);
                Display();              
          }else if(type == "UPDATE"){
              sql = "update login set User_ID='"+txt1.getText()+"',"
                      + "password='"+txt2.getText()+"' where User_ID='"+txt1.getText()+"'";              
              stmt.executeUpdate(sql);
              JOptionPane.showMessageDialog(this,"Update data success");
              model.setRowCount(0);
                Display();
          }else if(type == "DELETE"){
              int index = tbAdmin.getSelectedRow();
              if(index>=0){
                 String deleteId = model.getValueAt(index,0).toString();
                 sql = "delete from login where User_ID='"+deleteId+"'";
                 stmt.executeUpdate(sql);
                 JOptionPane.showMessageDialog(this,"Delete data success");
                }else{
           JOptionPane.showMessageDialog(this,"Please select a row");
                } 
              model.setRowCount(0);
                Display();              
          }else if(type == "SEARCH"){
              String name = txt1.getText().toString();
            sql = "select * from login where User_ID like '"+name+"%'";
            
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        int searchCount = resultSetMetaData.getColumnCount();
        String[] displayData = new String[searchCount];
           rs = stmt.executeQuery(sql);
           model.setRowCount(0);
            while(rs.next()){
               for(int i=1;i<=searchCount;i++){
                displayData[i-1] = rs.getObject(i).toString();
              }
            model.addRow(displayData);
            }
          }
          allClearTextField();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.toString());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        ppAdmin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAdmin = new javax.swing.JTable();
        rdbSearch = new javax.swing.JRadioButton();
        rdbInsert = new javax.swing.JRadioButton();
        rdbUpdate = new javax.swing.JRadioButton();
        rdbDelete = new javax.swing.JRadioButton();
        btnSet = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        panel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt1 = new javax.swing.JTextField();
        panel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ppAdmin.setBackground(new java.awt.Color(255, 153, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Admin");

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tbAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User_ID", "Password"
            }
        ));
        tbAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAdminMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbAdmin);

        buttonGroup1.add(rdbSearch);
        rdbSearch.setForeground(new java.awt.Color(0, 0, 0));
        rdbSearch.setText("SEARCH");

        buttonGroup1.add(rdbInsert);
        rdbInsert.setForeground(new java.awt.Color(0, 0, 0));
        rdbInsert.setText("INSERT");

        buttonGroup1.add(rdbUpdate);
        rdbUpdate.setForeground(new java.awt.Color(0, 0, 0));
        rdbUpdate.setText("UPDATE");

        buttonGroup1.add(rdbDelete);
        rdbDelete.setForeground(new java.awt.Color(0, 0, 0));
        rdbDelete.setText("DELETE");

        btnSet.setBackground(new java.awt.Color(0, 0, 0));
        btnSet.setForeground(new java.awt.Color(255, 255, 255));
        btnSet.setText("SET");
        btnSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetActionPerformed(evt);
            }
        });

        btnDone.setBackground(new java.awt.Color(0, 0, 0));
        btnDone.setForeground(new java.awt.Color(255, 255, 255));
        btnDone.setText("DONE");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(255, 153, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("User_ID");

        txt1.setBackground(new java.awt.Color(51, 51, 51));
        txt1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(53, 53, 53)
                .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panel2.setBackground(new java.awt.Color(255, 153, 51));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Password");

        txt2.setBackground(new java.awt.Color(51, 51, 51));
        txt2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(41, 41, 41)
                .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ppAdminLayout = new javax.swing.GroupLayout(ppAdmin);
        ppAdmin.setLayout(ppAdminLayout);
        ppAdminLayout.setHorizontalGroup(
            ppAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ppAdminLayout.createSequentialGroup()
                .addGroup(ppAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ppAdminLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ppAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ppAdminLayout.createSequentialGroup()
                                .addComponent(rdbSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdbInsert)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdbUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdbDelete)
                                .addGap(2, 2, 2)
                                .addComponent(btnSet))
                            .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ppAdminLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(ppAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                            .addGroup(ppAdminLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBack))
                            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(52, 52, 52))
        );
        ppAdminLayout.setVerticalGroup(
            ppAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ppAdminLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(ppAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ppAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbSearch)
                    .addComponent(rdbInsert)
                    .addComponent(rdbUpdate)
                    .addComponent(rdbDelete)
                    .addComponent(btnSet, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ppAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ppAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       Home hm = new Home();
       this.setVisible(false);
       hm.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetActionPerformed
     if(rdbInsert.isSelected() || rdbUpdate.isSelected()){
           panel1.setVisible(true);
           panel2.setVisible(true);
       }else if(rdbSearch.isSelected()){
           panel1.setVisible(true);
           panel2.setVisible(false);
       }else if(rdbDelete.isSelected()){
           allPanelFalse();
       }
       controlRadio();
       DefaultTableModel model = (DefaultTableModel) tbAdmin.getModel();
       model.setRowCount(0);
       Display();
    }//GEN-LAST:event_btnSetActionPerformed

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
             if(btnDone.getText() != "DONE"){
            if(rdbInsert.isSelected()){
                boolean isAllFill = checkFields();
                    if(isAllFill == true){
                        optionsWork(Source.Options.INSERT.toString());
                    }else{
                     JOptionPane.showMessageDialog(this,"Please fill All Fields");   
                    }
            }else if(rdbUpdate.isSelected()){
                    boolean isAllFill = checkFields();
                    if(isAllFill == true){
                        optionsWork(Source.Options.UPDATE.toString());
                    }else{
                     JOptionPane.showMessageDialog(this,"Please fill All Fields");   
                    }
            }else if(rdbSearch.isSelected()){
                    if(txt1.getText().length() != 0){
                        optionsWork(Source.Options.SEARCH.toString());
                    }else{
                      JOptionPane.showMessageDialog(this,"Please fill a User_ID");  
                    }
            }else if(rdbDelete.isSelected()){
                    optionsWork(Source.Options.DELETE.toString());
            }    
        }else{
          JOptionPane.showMessageDialog(this,"Press \"SET\" button to after choosing an option");
        }
    }//GEN-LAST:event_btnDoneActionPerformed

    private void tbAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAdminMouseClicked
        JTextField[] txtList = {txt1,txt2};
        
        DefaultTableModel model = (DefaultTableModel) tbAdmin.getModel();
        int index = tbAdmin.getSelectedRow();
        
        for(int i=0;i<columnCount;i++){
            txtList[i].setText(model.getValueAt(index,i).toString());
        }
    }//GEN-LAST:event_tbAdminMouseClicked

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnSet;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel ppAdmin;
    private javax.swing.JRadioButton rdbDelete;
    private javax.swing.JRadioButton rdbInsert;
    private javax.swing.JRadioButton rdbSearch;
    private javax.swing.JRadioButton rdbUpdate;
    private javax.swing.JTable tbAdmin;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    // End of variables declaration//GEN-END:variables
}
