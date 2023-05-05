/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartHome;

import Lib.Source;
import java.awt.CardLayout;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EditTable extends javax.swing.JFrame {

        ResultSet rs = null;
    Connection conn = null;
    Statement stmt = null;
    
        //int userSelectTable = 0;
   List<String> list = new ArrayList<String>();
   Map<Object,List<Object>> dataMap = new LinkedHashMap<>();
     List<String> updateList = new ArrayList<String>();
   
   JTable table;
   CardLayout card;
   JPanel cardPane;
   
   //new declare
    
    public EditTable() {
        initComponents();
        Display();
        comboDataUpdate.setVisible(false);
        comboDataAdd.setVisible(false);
    }
    
  public void ChangeName(JTable table, int col_index, String col_name){
  table.getColumnModel().getColumn(col_index).setHeaderValue(col_name);
  }
  
     public void newTableData(){
       updateList.clear();
   Map<Object,List<Object>> updateDataMap = new LinkedHashMap<>(); 
          try{
         Class.forName(Source.driver);
          conn = DriverManager.getConnection(Source.url,Source.userName,Source.password);
          stmt = conn.createStatement(); 
          
          String sql = "select * from "+Source.tableTable+"";
           rs = stmt.executeQuery(sql);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
             int columnCount = resultSetMetaData.getColumnCount();
              System.out.println("column count newTableData"+columnCount);
             
             for(int i=1;i<=columnCount;i++){
                 String name = resultSetMetaData.getColumnName(i);
                     updateList.add(name);
             } 
              System.out.println("updatelist "+Arrays.toString(updateList.toArray()));

        while(rs.next()){
        List<Object> list = new ArrayList<Object>();
                  for(int i=1;i<=columnCount;i++){
                      Object name = rs.getObject(i);
                          list.add(name);         
                      updateDataMap.put(list.get(0), list);
                  } 
        }
    Object[][] data = new Object[updateDataMap.size()][columnCount];
                 System.out.println("2d array size "+updateDataMap.size());
                    Set<Object> nameOfType = updateDataMap.keySet();
                    List<Object> nameList = new ArrayList<Object>(nameOfType);
                    System.out.println("name list check "+Arrays.toString(nameList.toArray()));
                    
   for(int i=0;i<data.length;i++){
      System.out.println("2d change "+data.length+"  "+i+"    "+nameList.get(i));
              data[i] = updateDataMap.get(nameList.get(i)).toArray();
       }
           DefaultTableModel model = new DefaultTableModel(data,updateList.toArray());
           table.setModel(model);

        }catch(Exception e){
              System.out.println(e.toString());
             JOptionPane.showMessageDialog(this,e.toString());
        }
    }
    
    public void Display(){
       dataMap.clear();
       list.clear();
             try{
          cardPane.removeAll();
      }catch(Exception e){
          System.out.println("no card in panel");
      }
        try{
            
         Class.forName(Source.driver);
         conn = DriverManager.getConnection(Source.url,Source.userName,Source.password);
         stmt = conn.createStatement();
         
         ///Start table here  
          String sql = "select * from "+Source.tableTable+""; 
              
             rs = stmt.executeQuery(sql);
              ResultSetMetaData resultSetMetaData = rs.getMetaData();
             int columnCount = resultSetMetaData.getColumnCount();
             System.out.println("column count edit "+columnCount);
             
             for(int i=1;i<=columnCount;i++){
                 String name = resultSetMetaData.getColumnName(i);
                 if(name != null){
                     list.add(name);
                     updateList.add(name);
                     
                 }
             }
             System.out.println("list column name "+list.toString());
             
             while(rs.next()){
                 
                 List<Object> list = new ArrayList<Object>();
                  for(int i=1;i<=columnCount;i++){
                      Object name = rs.getObject(i);
                      //if(name == null){
                          //name = "-";
                          list.add(name);
                      //}          
                      dataMap.put(list.get(0), list);
                  }   
             }  
                

                    Object[][] data = new Object[dataMap.size()][columnCount];
                 
                    Set<Object> nameOfType = dataMap.keySet();
                    List<Object> nameList = new ArrayList<Object>(nameOfType);
                    
                    for(int i=0;i<data.length;i++){
                         data[i] = dataMap.get(nameList.get(i)).toArray();
                    }            
                        table = new JTable(data,list.toArray());
//                        table.setColumnSelectionAllowed(true);
//                        JTableHeader header = table.getTableHeader();
//                        header.addMouseListener(new TableHeaderMouseListener());
                        
                        table.setBounds(24,64,600,100);                         
                         JScrollPane jScroll = new JScrollPane(table);
                        jScroll.setBounds(24,64,600,120);
                        
                        cardPane = new JPanel();
                        card = new CardLayout();
                        cardPane.setBounds(24,64,600,120);
                        cardPane.setLayout(card);
                        cardPane.add(jScroll);
                        
                        
                        ppEdit.add(cardPane); 
                        card.last(cardPane);
                        //pp1.add(jScroll);
                                           
                       this.setVisible(true); 
 
            
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

        ppEdit = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnupdateColumn = new javax.swing.JButton();
        btnDeleteColumn = new javax.swing.JButton();
        btnAddColumn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUpdateOld = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtUpdateNew = new javax.swing.JTextField();
        comboUpdateColumn = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtAddColumn = new javax.swing.JTextField();
        comboAddColumn = new javax.swing.JComboBox<>();
        comboDataUpdate = new javax.swing.JComboBox<>();
        comboDataAdd = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtDeleteColumn = new javax.swing.JTextField();
        btnDeleteTable = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ppEdit.setBackground(new java.awt.Color(255, 153, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("EDIT TABLE");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnupdateColumn.setBackground(new java.awt.Color(0, 0, 0));
        btnupdateColumn.setForeground(new java.awt.Color(255, 255, 255));
        btnupdateColumn.setText("UPDATE COLUMN");
        btnupdateColumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateColumnActionPerformed(evt);
            }
        });

        btnDeleteColumn.setBackground(new java.awt.Color(0, 0, 0));
        btnDeleteColumn.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteColumn.setText("DELETE COLUMN");
        btnDeleteColumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteColumnActionPerformed(evt);
            }
        });

        btnAddColumn.setBackground(new java.awt.Color(0, 0, 0));
        btnAddColumn.setForeground(new java.awt.Color(255, 255, 255));
        btnAddColumn.setText("ADD COLUMN");
        btnAddColumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddColumnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Column Editors");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Old Name");

        txtUpdateOld.setBackground(new java.awt.Color(51, 51, 51));
        txtUpdateOld.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("New Name");

        txtUpdateNew.setBackground(new java.awt.Color(51, 51, 51));
        txtUpdateNew.setForeground(new java.awt.Color(255, 255, 255));

        comboUpdateColumn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Type", "VARCHAR", "CHAR", "INT", "TINYINT", "DECIMAL", "DOUBLE", "TEXT" }));
        comboUpdateColumn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                comboUpdateColumnMousePressed(evt);
            }
        });
        comboUpdateColumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboUpdateColumnActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("New Name");

        txtAddColumn.setBackground(new java.awt.Color(51, 51, 51));
        txtAddColumn.setForeground(new java.awt.Color(255, 255, 255));

        comboAddColumn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Type", "VARCHAR", "CHAR", "INT", "TINYINT", "DECIMAL", "DOUBLE", "TEXT" }));
        comboAddColumn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                comboAddColumnMousePressed(evt);
            }
        });
        comboAddColumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAddColumnActionPerformed(evt);
            }
        });

        comboDataUpdate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6", "8", "10", "20", "40", "60", "80", "100" }));

        comboDataAdd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6", "8", "10", "20", "40", "60", "80", "100" }));

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Column Name");

        txtDeleteColumn.setBackground(new java.awt.Color(51, 51, 51));
        txtDeleteColumn.setForeground(new java.awt.Color(255, 255, 255));

        btnDeleteTable.setBackground(new java.awt.Color(0, 0, 0));
        btnDeleteTable.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteTable.setText("DELETE TABLE");
        btnDeleteTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ppEditLayout = new javax.swing.GroupLayout(ppEdit);
        ppEdit.setLayout(ppEditLayout);
        ppEditLayout.setHorizontalGroup(
            ppEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ppEditLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(ppEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ppEditLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ppEditLayout.createSequentialGroup()
                        .addGroup(ppEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ppEditLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(ppEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDeleteColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ppEditLayout.createSequentialGroup()
                                        .addGroup(ppEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(ppEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5)
                                                .addComponent(txtUpdateOld, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtAddColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(ppEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addGroup(ppEditLayout.createSequentialGroup()
                                                .addGroup(ppEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ppEditLayout.createSequentialGroup()
                                                        .addComponent(comboAddColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(26, 26, 26)
                                                        .addComponent(comboDataAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(10, 10, 10))
                                                    .addGroup(ppEditLayout.createSequentialGroup()
                                                        .addComponent(txtUpdateNew, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(27, 27, 27)
                                                        .addComponent(comboUpdateColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)))
                                                .addComponent(comboDataUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addGroup(ppEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAddColumn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDeleteColumn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(ppEditLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnupdateColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ppEditLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDeleteTable, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))
                        .addGap(25, 25, 25))
                    .addGroup(ppEditLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        ppEditLayout.setVerticalGroup(
            ppEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ppEditLayout.createSequentialGroup()
                .addGroup(ppEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ppEditLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(ppEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ppEditLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnDeleteTable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(ppEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ppEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnupdateColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUpdateOld, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUpdateNew, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboUpdateColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDataUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ppEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ppEditLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ppEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboAddColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboDataAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ppEditLayout.createSequentialGroup()
                        .addComponent(btnAddColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGroup(ppEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ppEditLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDeleteColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnDeleteColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ppEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ppEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Tables table = new Tables();
       this.setVisible(false);
       table.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnupdateColumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateColumnActionPerformed
           try{
              Class.forName(Source.driver);
              conn = DriverManager.getConnection(Source.url,Source.userName,Source.password);
              stmt = conn.createStatement();
              
              String oldName = txtUpdateOld.getText();
              String newName = txtUpdateNew.getText();
              String dataType = comboUpdateColumn.getSelectedItem().toString();
              String varcharCount = "6";
              
              if(comboUpdateColumn.getSelectedIndex() == 1 || comboUpdateColumn.getSelectedIndex()==2){  
                  varcharCount = comboDataUpdate.getSelectedItem().toString();
                  String temp1 = "("+varcharCount+")";
                   varcharCount = dataType+temp1;    
              }     
              if(oldName.length() != 0 && newName.length() !=0){
                    if(updateList.contains(oldName)){
                      String sql = "";
              if(comboUpdateColumn.getSelectedIndex() == 1 || comboUpdateColumn.getSelectedIndex()==2){
         sql = "alter table "+Source.tableTable+" change column "+oldName+" "+newName+" "+varcharCount+"";
              }else{
              sql = "alter table "+Source.tableTable+" change column "+oldName+" "+newName+" "+dataType+""; 
              }
              System.out.println("sql "+sql);
              
             boolean rt = stmt.execute(sql);
            newTableData();
             txtUpdateOld.setText("");
             txtUpdateNew.setText("");
             comboUpdateColumn.setSelectedIndex(0);
             comboDataUpdate.setSelectedIndex(0);
                    }else{
     JOptionPane.showMessageDialog(this,"This column does not include in the "+Source.tableTable+" table");
                    }
                  
              }else{
                  JOptionPane.showMessageDialog(this,"You need to fill old or new column names");
              }
              
           }catch(Exception e){
               JOptionPane.showMessageDialog(this, e.toString());
           }
    }//GEN-LAST:event_btnupdateColumnActionPerformed

    private void comboUpdateColumnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboUpdateColumnMousePressed

    }//GEN-LAST:event_comboUpdateColumnMousePressed

    private void btnAddColumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddColumnActionPerformed
       try{
              Class.forName(Source.driver);
              conn = DriverManager.getConnection(Source.url,Source.userName,Source.password);
              stmt = conn.createStatement();
              
              String newName = txtAddColumn.getText();
              String dataType = comboAddColumn.getSelectedItem().toString();
              String varcharCount = "6";
              if(comboAddColumn.getSelectedIndex() == 1 || comboAddColumn.getSelectedIndex()==2){  
                  varcharCount = comboDataAdd.getSelectedItem().toString();
                  String temp1 = "("+varcharCount+")";
                   varcharCount = dataType+temp1;
              }
              if(newName.length() !=0){
                      String sql = "";
              if(comboAddColumn.getSelectedIndex() == 1 || comboAddColumn.getSelectedIndex()==2){
              sql = "alter table "+Source.tableTable+" add "+newName+" "+varcharCount+"";
              }else{
              sql = "alter table "+Source.tableTable+" add "+newName+" "+dataType+""; 
              }
              System.out.println("sql "+sql);
              
             boolean rt = stmt.execute(sql);
             newTableData();
             txtAddColumn.setText("");
             comboAddColumn.setSelectedIndex(0);
             comboDataAdd.setSelectedIndex(0);
             System.out.println("return value "+rt);        
              }else{
                  JOptionPane.showMessageDialog(this,"You need to fill old or new column names");
              }
              
           }catch(Exception e){
               JOptionPane.showMessageDialog(this, e.toString());
           }
    }//GEN-LAST:event_btnAddColumnActionPerformed

    private void comboAddColumnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboAddColumnMousePressed

    }//GEN-LAST:event_comboAddColumnMousePressed

    private void btnDeleteColumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteColumnActionPerformed
        try{
           Class.forName(Source.driver);
           conn = DriverManager.getConnection(Source.url,Source.userName,Source.password);
           stmt = conn.createStatement();  
           
           String deleteColumnName = txtDeleteColumn.getText();
           if(deleteColumnName.length() != 0){
             if(updateList.contains(deleteColumnName)){
                 
             String sql = "alter table "+Source.tableTable+" drop column "+deleteColumnName+"";
             stmt.execute(sql);
             newTableData();
             txtDeleteColumn.setText("");    
             }else{
    JOptionPane.showMessageDialog(this,"This column does not include in the "+Source.tableTable+" table"); 
             } 
           }else{
                JOptionPane.showMessageDialog(this,"You need to fill column name to delete");
           }       
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.toString());
        }
    }//GEN-LAST:event_btnDeleteColumnActionPerformed

    private void btnDeleteTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTableActionPerformed
        int rtv = JOptionPane.showConfirmDialog(this,"Do you want to delete "+Source.tableTable+"?");
        if(rtv == 0){
            try{
             Class.forName(Source.driver);
             conn = DriverManager.getConnection(Source.url,Source.userName,Source.password);
             stmt = conn.createStatement();
             
             stmt.executeUpdate("drop table "+Source.tableTable+"");
             this.setVisible(false);
             Tables tb = new Tables();
             tb.setVisible(true);
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,e.toString());
            }
        }
    }//GEN-LAST:event_btnDeleteTableActionPerformed

    private void comboUpdateColumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboUpdateColumnActionPerformed
             if(comboUpdateColumn.getSelectedIndex() == 1 || comboUpdateColumn.getSelectedIndex()==2){  
                  comboDataUpdate.setVisible(true);             
              }else{
                 comboDataUpdate.setVisible(false);  
             }
    }//GEN-LAST:event_comboUpdateColumnActionPerformed

    private void comboAddColumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAddColumnActionPerformed
                  if(comboAddColumn.getSelectedIndex() == 1 || comboAddColumn.getSelectedIndex()==2){  
                  comboDataAdd.setVisible(true);             
              }else{
                 comboDataAdd.setVisible(false);  
             }
    }//GEN-LAST:event_comboAddColumnActionPerformed

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
            java.util.logging.Logger.getLogger(EditTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddColumn;
    private javax.swing.JButton btnDeleteColumn;
    private javax.swing.JButton btnDeleteTable;
    private javax.swing.JButton btnupdateColumn;
    private javax.swing.JComboBox<String> comboAddColumn;
    private javax.swing.JComboBox<String> comboDataAdd;
    private javax.swing.JComboBox<String> comboDataUpdate;
    private javax.swing.JComboBox<String> comboUpdateColumn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel ppEdit;
    private javax.swing.JTextField txtAddColumn;
    private javax.swing.JTextField txtDeleteColumn;
    private javax.swing.JTextField txtUpdateNew;
    private javax.swing.JTextField txtUpdateOld;
    // End of variables declaration//GEN-END:variables
}
