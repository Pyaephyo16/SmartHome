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
public class Item extends javax.swing.JFrame {

      ResultSet rs = null;
    Connection conn = null;
    Statement stmt = null;
    
    int columnCount = -1;
    
    public Item() {
        initComponents();
        Scrollable();
        allPanelFalse();
        Display();
        DisplayForeign();
    }
    
        private void allPanelFalse(){
        panel1.setVisible(false);
        panel2.setVisible(false);
    }
        
 private void allClearTextField(){
        txt2.setText("");
        txt1.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setText("");
        txt6.setSelectedIndex(0);
    }
    
       private void Scrollable(){
          ppItem.setBorder(BorderFactory.createLineBorder(Color.orange));
        ppItem.setPreferredSize(new Dimension(600,800));

        final JScrollPane scroll = new JScrollPane(ppItem);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        setLayout(new BorderLayout());
        add(scroll, BorderLayout.CENTER);
        this.setBackground(Color.orange);
        setSize(700,720);
        setVisible(true);
    }
       
   private boolean checkFields(int numOfColumn){
   if(txt2.getText().length() !=0 && txt1.getText().length() != 0 && txt3.getText().length() !=0 && txt4.getText().length() !=0 && txt5.getText().length() !=0){
             return true;
             }else{
                 return false;
             }
    } 

    private void optionsWork(String type){
        DefaultTableModel model = (DefaultTableModel) tbItem.getModel();
        try{
          
          Class.forName(Source.driver);
          conn = DriverManager.getConnection(Source.url,Source.userName,Source.password);
          stmt = conn.createStatement();
          
          String sql = "";
          if(type == "INSERT"){
              sql = "insert into item values('"+txt1.getText()+"',"
                      + "'"+txt2.getText()+"','"+txt3.getText()+"',"
                      + "'"+txt4.getText()+"','"+txt5.getText()+"',"
                      + "'"+txt6.getSelectedItem().toString()+"')";
              stmt.execute(sql);
              JOptionPane.showMessageDialog(this,"Add data success");
              model.setRowCount(0);
                Display();              
          }else if(type == "UPDATE"){
              sql = "update item set Item_ID='"+txt1.getText()+"',"
                      + "Item_Name='"+txt2.getText()+"',"
                      + "Item_Type='"+txt3.getText()+"',"
                      + "Item_Quantity='"+txt4.getText()+"',"
                      + "Item_Price='"+txt5.getText()+"',"
                      + "Client_ID='"+txt6.getSelectedItem().toString()+"' where Item_ID='"+txt1.getText()+"'";              
              System.out.println("update sql "+sql);
              stmt.executeUpdate(sql);
              JOptionPane.showMessageDialog(this,"Update data success");
              model.setRowCount(0);
                Display();
          }else if(type == "DELETE"){
              int index = tbItem.getSelectedRow();
              if(index>=0){
                 String deleteId = model.getValueAt(index,0).toString();
                 sql = "delete from item where Item_ID='"+deleteId+"'";
                 stmt.executeUpdate(sql);
                 JOptionPane.showMessageDialog(this,"Delete data success");
                }else{
           JOptionPane.showMessageDialog(this,"Please select a row");
                } 
              model.setRowCount(0);
                Display();              
          }else if(type == "SEARCH"){
              String name = txt2.getText().toString();
            sql = "select * from item where Item_Name like '"+name+"%'";
            
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
       
    private void controlRadio(){
          if(rdbInsert.isSelected()){
            
            btnDone.setText("INSERT");
            allClearTextField();
            tbItem.clearSelection();
            
        }else if(rdbUpdate.isSelected()){
            
            btnDone.setText("UPDATE"); 
             txt1.setEditable(false);
              System.out.println("set false edit");
            allClearTextField();
            tbItem.clearSelection();
            
        }else if(rdbDelete.isSelected()){
            
            btnDone.setText("DELETE"); 
            allClearTextField();
            tbItem.clearSelection();
            
        }else if(rdbSearch.isSelected()){
            
            btnDone.setText("SEARCH"); 
            allClearTextField();
            tbItem.clearSelection();
            
        }else{
            btnDone.setText("DONE"); 
            allClearTextField();
            tbItem.clearSelection();
        }
    }       
       
    private void Display(){
        DefaultTableModel model = (DefaultTableModel) tbItem.getModel();
        try{
            
          Class.forName(Source.driver);
          conn = DriverManager.getConnection(Source.url,Source.userName,Source.password);
          stmt = conn.createStatement();
          
          String sql = "select * from item";
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

    private void DisplayForeign(){
        try{
          Class.forName(Source.driver);
          conn = DriverManager.getConnection(Source.url,Source.userName,Source.password);
          stmt = conn.createStatement();
          
          String sql = "select * from client";
          rs = stmt.executeQuery(sql);
          
          while(rs.next()){
               txt6.addItem(rs.getString("Client_ID").toString());
          }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.toString());
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
        ppItem = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbItem = new javax.swing.JTable();
        rdbSearch = new javax.swing.JRadioButton();
        rdbInsert = new javax.swing.JRadioButton();
        rdbUpdate = new javax.swing.JRadioButton();
        rdbDelete = new javax.swing.JRadioButton();
        btnSet = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        panel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt2 = new javax.swing.JTextField();
        panel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt4 = new javax.swing.JTextField();
        txt1 = new javax.swing.JTextField();
        txt3 = new javax.swing.JTextField();
        txt5 = new javax.swing.JTextField();
        txt6 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ppItem.setBackground(new java.awt.Color(255, 153, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Items");

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tbItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item_ID", "Item_Name", "Item_Type", "Item_Quantity", "Item_Price", "Client_ID"
            }
        ));
        tbItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbItemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbItem);

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
        jLabel2.setText("Item_Name");

        txt2.setBackground(new java.awt.Color(51, 51, 51));
        txt2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(39, 39, 39)
                .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)))
        );

        panel2.setBackground(new java.awt.Color(255, 153, 51));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Item_ID");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Item_Type");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Item_Quantity");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Item_Price");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Client_ID");

        txt4.setBackground(new java.awt.Color(51, 51, 51));
        txt4.setForeground(new java.awt.Color(255, 255, 255));

        txt1.setBackground(new java.awt.Color(51, 51, 51));
        txt1.setForeground(new java.awt.Color(255, 255, 255));

        txt3.setBackground(new java.awt.Color(51, 51, 51));
        txt3.setForeground(new java.awt.Color(255, 255, 255));

        txt5.setBackground(new java.awt.Color(51, 51, 51));
        txt5.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(44, 44, 44)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5))
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel5))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ppItemLayout = new javax.swing.GroupLayout(ppItem);
        ppItem.setLayout(ppItemLayout);
        ppItemLayout.setHorizontalGroup(
            ppItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ppItemLayout.createSequentialGroup()
                .addGroup(ppItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ppItemLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ppItemLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(ppItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ppItemLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(rdbSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdbInsert)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdbUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdbDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSet, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ppItemLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBack))
                            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(51, 51, 51))
        );
        ppItemLayout.setVerticalGroup(
            ppItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ppItemLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(ppItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ppItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbSearch)
                    .addComponent(rdbInsert)
                    .addComponent(rdbUpdate)
                    .addComponent(rdbDelete)
                    .addComponent(btnSet, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ppItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ppItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
       DefaultTableModel model = (DefaultTableModel) tbItem.getModel();
       model.setRowCount(0);       
       Display();
    }//GEN-LAST:event_btnSetActionPerformed

    private void tbItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbItemMouseClicked
        JTextField[] txtList = {txt1,txt2,txt3,txt4,txt5};
        
        DefaultTableModel model = (DefaultTableModel) tbItem.getModel();
        int index = tbItem.getSelectedRow();
        
        for(int i=0;i<columnCount-1;i++){
            txtList[i].setText(model.getValueAt(index,i).toString());
        }
        txt6.setSelectedItem(model.getValueAt(index,5).toString());
    }//GEN-LAST:event_tbItemMouseClicked

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
                      JOptionPane.showMessageDialog(this,"Please fill a Item_Name");  
                    }
            }else if(rdbDelete.isSelected()){
                    optionsWork(Source.Options.DELETE.toString());
            }
            
        }else{
          JOptionPane.showMessageDialog(this,"Press \"SET\" button to after choosing an option");
        }      
    }//GEN-LAST:event_btnDoneActionPerformed

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
            java.util.logging.Logger.getLogger(Item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Item().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel ppItem;
    private javax.swing.JRadioButton rdbDelete;
    private javax.swing.JRadioButton rdbInsert;
    private javax.swing.JRadioButton rdbSearch;
    private javax.swing.JRadioButton rdbUpdate;
    private javax.swing.JTable tbItem;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    private javax.swing.JTextField txt4;
    private javax.swing.JTextField txt5;
    private javax.swing.JComboBox<String> txt6;
    // End of variables declaration//GEN-END:variables
}
