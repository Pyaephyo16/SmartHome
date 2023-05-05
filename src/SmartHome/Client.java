/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartHome;

import Lib.Source;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.*;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Client extends javax.swing.JFrame {

  ResultSet rs = null;
    Connection conn = null;
    Statement stmt = null;
    
    int columnCount = -1;
 
    
    public Client() {
        initComponents();
        Scrollable();
        allPanelFalse();
        Display();
    }
    
    private void allPanelFalse(){
        panel1.setVisible(false);
        panel2.setVisible(false);
    }
    
    private void Scrollable(){
          ppClient.setBorder(BorderFactory.createLineBorder(Color.orange));
        ppClient.setPreferredSize(new Dimension(600,800));

        final JScrollPane scroll = new JScrollPane(ppClient);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        setLayout(new BorderLayout());
        add(scroll, BorderLayout.CENTER);
        this.setBackground(Color.orange);
        setSize(700,720);
        setVisible(true);
    }

    private void allClearTextField(){
        txt2.setText("");
        txt1.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setText("");
        txt6.setText("");
        txt7.setText("");
    }
    
    private void controlRadio(){
          if(rdbInsert.isSelected()){
            
            btnDone.setText("INSERT");
            allClearTextField();
            tbClient.clearSelection();
            
        }else if(rdbUpdate.isSelected()){
            
            btnDone.setText("UPDATE"); 
            txt1.setEditable(false);
              System.out.println("set false edit");
            allClearTextField();
            tbClient.clearSelection();
            
        }else if(rdbDelete.isSelected()){
            
            btnDone.setText("DELETE"); 
            allClearTextField();
            tbClient.clearSelection();
            
        }else if(rdbSearch.isSelected()){
            
            btnDone.setText("SEARCH"); 
            allClearTextField();
            tbClient.clearSelection();
            
        }else{
            btnDone.setText("DONE"); 
            allClearTextField();
            tbClient.clearSelection();
        }
    }
    
    private void Display(){
        DefaultTableModel model = (DefaultTableModel) tbClient.getModel();
        try{
            
          Class.forName(Source.driver);
          conn = DriverManager.getConnection(Source.url,Source.userName,Source.password);
          stmt = conn.createStatement();
          
          String sql = "select * from client";
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

    private boolean checkFields(int numOfColumn){
            if(txt2.getText().length() !=0 && txt1.getText().length() != 0 && txt3.getText().length() !=0 && txt4.getText().length() !=0 && txt5.getText().length() !=0 && txt6.getText().length() !=0 && txt7.getText().length() !=0){
                 if(txt6.getText().equals("male") || txt6.getText().equals("female")){
                     return true;
                 }else{
                     JOptionPane.showMessageDialog(this,"Only \"male\" and \"female\" allow for Client_Gender");
                     return false;
                 }
             }else{
                 return false;
             }
    }
    
    private void optionsWork(String type){
        DefaultTableModel model = (DefaultTableModel) tbClient.getModel();
        try{
          
            Class.forName(Source.driver);
          conn = DriverManager.getConnection(Source.url,Source.userName,Source.password);
          stmt = conn.createStatement();
          
          String sql = "";
          if(type == "INSERT"){
              sql = "insert into client values('"+txt1.getText()+"',"
                      + "'"+txt2.getText()+"','"+txt3.getText()+"',"
                      + "'"+txt4.getText()+"','"+txt5.getText()+"',"
                      + "'"+txt6.getText()+"','"+txt7.getText()+"')";
              stmt.execute(sql);
              JOptionPane.showMessageDialog(this,"Add data success");
              model.setRowCount(0);
                Display();              
          }else if(type == "UPDATE"){
              sql = "update client set Client_ID='"+txt1.getText()+"',"
                      + "Client_Name='"+txt2.getText()+"',"
                      + "Client_Add='"+txt3.getText()+"',"
                      + "Client_Tel='"+txt4.getText()+"',"
                      + "Client_Email='"+txt5.getText()+"',"
                      + "Client_Gender='"+txt6.getText()+"',"
                      + "Client_Age='"+txt7.getText()+"' where Client_ID='"+txt1.getText()+"'";              
              System.out.println("update sql "+sql);
              stmt.executeUpdate(sql);
              JOptionPane.showMessageDialog(this,"Update data success");
              model.setRowCount(0);
                Display();
          }else if(type == "DELETE"){
              int index = tbClient.getSelectedRow();
              if(index>=0){
                 String deleteId = model.getValueAt(index,0).toString();
                 sql = "delete from client where Client_ID='"+deleteId+"'";
                 stmt.executeUpdate(sql);
                 JOptionPane.showMessageDialog(this,"Delete data success");
                }else{
           JOptionPane.showMessageDialog(this,"Please select a row");
                } 
              model.setRowCount(0);
                Display();              
          }else if(type == "SEARCH"){
              String name = txt2.getText().toString();
            sql = "select * from client where Client_Name like '"+name+"%'";
            
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
        ppClient = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbClient = new javax.swing.JTable();
        rdbInsert = new javax.swing.JRadioButton();
        rdbUpdate = new javax.swing.JRadioButton();
        rdbDelete = new javax.swing.JRadioButton();
        btnSet = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        panel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt2 = new javax.swing.JTextField();
        rdbSearch = new javax.swing.JRadioButton();
        panel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt3 = new javax.swing.JTextField();
        txt1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt7 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ppClient.setBackground(new java.awt.Color(255, 153, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Client");

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tbClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Client_ID", "Client_Name", "Client_Add", "Client_Tel", "Client_Email", "Client_Gender", "Client_Age"
            }
        ));
        tbClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClientMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbClient);

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
        jLabel2.setText("Client_Name");

        txt2.setBackground(new java.awt.Color(51, 51, 51));
        txt2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(45, 45, 45)
                .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        buttonGroup1.add(rdbSearch);
        rdbSearch.setForeground(new java.awt.Color(0, 0, 0));
        rdbSearch.setText("SEARCH");

        panel2.setBackground(new java.awt.Color(255, 153, 51));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Client_ID");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Client_Add");

        txt3.setBackground(new java.awt.Color(51, 51, 51));
        txt3.setForeground(new java.awt.Color(255, 255, 255));
        txt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt3ActionPerformed(evt);
            }
        });

        txt1.setBackground(new java.awt.Color(51, 51, 51));
        txt1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Client_Tel");

        txt5.setBackground(new java.awt.Color(51, 51, 51));
        txt5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Client_Email");

        txt6.setBackground(new java.awt.Color(51, 51, 51));
        txt6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Client_Gender");

        txt4.setBackground(new java.awt.Color(51, 51, 51));
        txt4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Client_Age");

        txt7.setBackground(new java.awt.Color(51, 51, 51));
        txt7.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(35, 35, 35)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(27, 27, 27)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)))
        );

        javax.swing.GroupLayout ppClientLayout = new javax.swing.GroupLayout(ppClient);
        ppClient.setLayout(ppClientLayout);
        ppClientLayout.setHorizontalGroup(
            ppClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ppClientLayout.createSequentialGroup()
                .addGroup(ppClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ppClientLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(ppClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ppClientLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBack))
                            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(ppClientLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ppClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ppClientLayout.createSequentialGroup()
                                .addComponent(rdbSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdbInsert)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdbUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdbDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSet))
                            .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38))
        );
        ppClientLayout.setVerticalGroup(
            ppClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ppClientLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(ppClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ppClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbInsert)
                    .addComponent(rdbUpdate)
                    .addComponent(rdbDelete)
                    .addComponent(btnSet, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ppClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ppClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       Home hm = new Home();
       this.setVisible(false);
       hm.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt3ActionPerformed

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
       DefaultTableModel model = (DefaultTableModel) tbClient.getModel();
       model.setRowCount(0);       
       Display();
    }//GEN-LAST:event_btnSetActionPerformed

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        if(btnDone.getText() != "DONE"){
            
            if(rdbInsert.isSelected()){
                boolean isAllFill = checkFields(columnCount);
                    if(isAllFill == true){
                        optionsWork(Source.Options.INSERT.toString());
                    }else{
                     JOptionPane.showMessageDialog(this,"Please fill All Fields");   
                    }
            }else if(rdbUpdate.isSelected()){
                    boolean isAllFill = checkFields(columnCount);
                    if(isAllFill == true){
                        optionsWork(Source.Options.UPDATE.toString());
                    }else{
                     JOptionPane.showMessageDialog(this,"Please fill All Fields");   
                    }
            }else if(rdbSearch.isSelected()){
                    if(txt2.getText().length() != 0){
                        optionsWork(Source.Options.SEARCH.toString());
                    }else{
                      JOptionPane.showMessageDialog(this,"Please fill a Client_Name");  
                    }
            }else if(rdbDelete.isSelected()){
                    optionsWork(Source.Options.DELETE.toString());
            }
            
        }else{
          JOptionPane.showMessageDialog(this,"Press \"SET\" button to after choosing an option");
        }

    }//GEN-LAST:event_btnDoneActionPerformed

    private void tbClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClientMouseClicked
        JTextField[] txtList = {txt1,txt2,txt3,txt4,txt5,txt6,txt7};
        
        DefaultTableModel model = (DefaultTableModel) tbClient.getModel();
        int index = tbClient.getSelectedRow();
        
        for(int i=0;i<columnCount;i++){
            txtList[i].setText(model.getValueAt(index,i).toString());
        }
    }//GEN-LAST:event_tbClientMouseClicked

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
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel ppClient;
    private javax.swing.JRadioButton rdbDelete;
    private javax.swing.JRadioButton rdbInsert;
    private javax.swing.JRadioButton rdbSearch;
    private javax.swing.JRadioButton rdbUpdate;
    private javax.swing.JTable tbClient;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    private javax.swing.JTextField txt4;
    private javax.swing.JTextField txt5;
    private javax.swing.JTextField txt6;
    private javax.swing.JTextField txt7;
    // End of variables declaration//GEN-END:variables
}
