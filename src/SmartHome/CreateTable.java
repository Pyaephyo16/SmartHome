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
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author user
 */
public class CreateTable extends javax.swing.JFrame {

    ResultSet rs = null;
    Connection conn = null;
    Statement stmt = null;
    
    int numberOfColumn =0;
    String tableName = "";
    
    public CreateTable() {
        initComponents();
        Show();
    }
    
    public void Show(){
        panelCT.setBorder(BorderFactory.createLineBorder(Color.orange));
        panelCT.setPreferredSize(new Dimension(600,780));

        final JScrollPane scroll = new JScrollPane(panelCT);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        setLayout(new BorderLayout());
        add(scroll, BorderLayout.CENTER);
        this.setBackground(Color.orange);
        setSize(700,700);
        setVisible(true);
        
       panelAllFalse();
       dataCountFalse();
    }
    
    public void panelAllFalse(){
         ///panel visible remove
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        panel7.setVisible(false);
        panel8.setVisible(false);
    }
    
        public void dataCountFalse(){
         ///panel visible remove
        comboData1.setVisible(false);
        comboData2.setVisible(false);
        comboData3.setVisible(false);
        comboData4.setVisible(false);
        comboData5.setVisible(false);
        comboData6.setVisible(false);
        comboData7.setVisible(false);
        comboData8.setVisible(false);
    }
    
    public void panelShow(int count){
        panelAllFalse();
      JPanel[] panelList = {panel1,panel2,panel3,panel4,panel5,panel6,panel7,panel8};
      int allPanelCount = 8;
      
      for(int i=0;i<count;i++){
          panelList[i].setVisible(true);
          
      }
      int temp = allPanelCount - count;
      
        System.out.println("count "+count+"  remain "+temp);
      for(int j=count;j<temp;j++){
          panelList[j].setVisible(false);
           
      }   
    }
    
public void startCreate(int columnCount){
    if(columnCount == 2){
        String[] twoColumnAdd = new String[8];
        System.arraycopy(prepareColumn1(),0,twoColumnAdd,0,4);
        System.arraycopy(prepareColumn2(),0,twoColumnAdd,4,4);
        
        System.out.println("2 length check "+twoColumnAdd[7]); 
        createTable(twoColumnAdd,columnCount);
    }else if(columnCount ==3){
        String[] twoColumnAdd = new String[12];
        System.arraycopy(prepareColumn1(),0,twoColumnAdd,0,4);
        System.arraycopy(prepareColumn2(),0,twoColumnAdd,4,4);
        System.arraycopy(prepareColumn3(),0,twoColumnAdd,8,4);
        
        System.out.println("3 length check "+twoColumnAdd[11]);  
        createTable(twoColumnAdd,columnCount);
    }else if(columnCount ==4){
        String[] twoColumnAdd = new String[16];
        System.arraycopy(prepareColumn1(),0,twoColumnAdd,0,4);
        System.arraycopy(prepareColumn2(),0,twoColumnAdd,4,4);
        System.arraycopy(prepareColumn3(),0,twoColumnAdd,8,4);
        System.arraycopy(prepareColumn4(),0,twoColumnAdd,12,4);
        
        System.out.println("4 length check "+twoColumnAdd[15]);  
        createTable(twoColumnAdd,columnCount);
    }else if(columnCount == 5){
        String[] twoColumnAdd = new String[20];
        System.arraycopy(prepareColumn1(),0,twoColumnAdd,0,4);
        System.arraycopy(prepareColumn2(),0,twoColumnAdd,4,4);
        System.arraycopy(prepareColumn3(),0,twoColumnAdd,8,4);
        System.arraycopy(prepareColumn4(),0,twoColumnAdd,12,4);
        System.arraycopy(prepareColumn5(),0,twoColumnAdd,16,4);
        
        System.out.println("5 length check "+twoColumnAdd[19]); 
        createTable(twoColumnAdd,columnCount);
    }else if(columnCount == 6){
        String[] twoColumnAdd = new String[24];
        System.arraycopy(prepareColumn1(),0,twoColumnAdd,0,4);
        System.arraycopy(prepareColumn2(),0,twoColumnAdd,4,4);
        System.arraycopy(prepareColumn3(),0,twoColumnAdd,8,4);
        System.arraycopy(prepareColumn4(),0,twoColumnAdd,12,4);
        System.arraycopy(prepareColumn5(),0,twoColumnAdd,16,4);
        System.arraycopy(prepareColumn6(),0,twoColumnAdd,20,4);
        
        System.out.println("6 length check "+twoColumnAdd[23]);
        createTable(twoColumnAdd,columnCount);
    }else if(columnCount == 7){
        String[] twoColumnAdd = new String[28];
        System.arraycopy(prepareColumn1(),0,twoColumnAdd,0,4);
        System.arraycopy(prepareColumn2(),0,twoColumnAdd,4,4);
        System.arraycopy(prepareColumn3(),0,twoColumnAdd,8,4);
        System.arraycopy(prepareColumn4(),0,twoColumnAdd,12,4);
        System.arraycopy(prepareColumn5(),0,twoColumnAdd,16,4);
        System.arraycopy(prepareColumn6(),0,twoColumnAdd,20,4);
        System.arraycopy(prepareColumn7(),0,twoColumnAdd,24,4);
        
        System.out.println("7 length check "+twoColumnAdd[27]); 
        createTable(twoColumnAdd,columnCount);
    }else if(columnCount == 8){
        String[] twoColumnAdd = new String[32];
        System.arraycopy(prepareColumn1(),0,twoColumnAdd,0,4);
        System.arraycopy(prepareColumn2(),0,twoColumnAdd,4,4);
        System.arraycopy(prepareColumn3(),0,twoColumnAdd,8,4);
        System.arraycopy(prepareColumn4(),0,twoColumnAdd,12,4);
        System.arraycopy(prepareColumn5(),0,twoColumnAdd,16,4);
        System.arraycopy(prepareColumn6(),0,twoColumnAdd,20,4);
        System.arraycopy(prepareColumn7(),0,twoColumnAdd,24,4);
        System.arraycopy(prepareColumn8(),0,twoColumnAdd,28,4);
        
        System.out.println("8 length check "+twoColumnAdd[31]);
        createTable(twoColumnAdd,columnCount);
    }else{
        JOptionPane.showMessageDialog(this,"Something went wrong");
    } 
}  

public void createTable(String[] array,int columnCount){
    System.out.println("array length "+array.length+" columnCount "+columnCount+" table name "+tableName);
    
    try{
        
        Class.forName(Source.driver);
        conn = DriverManager.getConnection(Source.url,Source.userName,Source.password);
        stmt = conn.createStatement();
        
        String sql = "";
        
        if(columnCount == 2){
        sql = "create table "+tableName+"("
                + ""+array[0]+" "+array[1]+" "+array[2]+" "+array[3]+","
                + ""+array[4]+" "+array[5]+" "+array[6]+" "+array[7]+")";
        System.out.println("sql 2 "+sql);  
        }else if(columnCount == 3){
        sql = "create table "+tableName+"("
                + ""+array[0]+" "+array[1]+" "+array[2]+" "+array[3]+","
                + ""+array[4]+" "+array[5]+" "+array[6]+" "+array[7]+","
                + ""+array[8]+" "+array[9]+" "+array[10]+" "+array[11]+")";
        System.out.println("sql 3 "+sql);   
        }else if(columnCount == 4){
        sql = "create table "+tableName+"("
                + ""+array[0]+" "+array[1]+" "+array[2]+" "+array[3]+","
                + ""+array[4]+" "+array[5]+" "+array[6]+" "+array[7]+","
                + ""+array[8]+" "+array[9]+" "+array[10]+" "+array[11]+","
                + ""+array[12]+" "+array[13]+" "+array[14]+" "+array[15]+")";
        System.out.println("sql 4 "+sql);            
        }else if(columnCount == 5){
        sql = "create table "+tableName+"("
                + ""+array[0]+" "+array[1]+" "+array[2]+" "+array[3]+","
                + ""+array[4]+" "+array[5]+" "+array[6]+" "+array[7]+","
                + ""+array[8]+" "+array[9]+" "+array[10]+" "+array[11]+","
                + ""+array[12]+" "+array[13]+" "+array[14]+" "+array[15]+","
                + ""+array[16]+" "+array[17]+" "+array[18]+" "+array[19]+")";
        System.out.println("sql 5 "+sql);             
        }else if(columnCount == 6){
        sql = "create table "+tableName+"("
                + ""+array[0]+" "+array[1]+" "+array[2]+" "+array[3]+","
                + ""+array[4]+" "+array[5]+" "+array[6]+" "+array[7]+","
                + ""+array[8]+" "+array[9]+" "+array[10]+" "+array[11]+","
                + ""+array[12]+" "+array[13]+" "+array[14]+" "+array[15]+","
                + ""+array[16]+" "+array[17]+" "+array[18]+" "+array[19]+","
                + ""+array[20]+" "+array[21]+" "+array[22]+" "+array[23]+")";
        System.out.println("sql 6 "+sql);             
        }else if(columnCount == 7){
        sql = "create table "+tableName+"("
                + ""+array[0]+" "+array[1]+" "+array[2]+" "+array[3]+","
                + ""+array[4]+" "+array[5]+" "+array[6]+" "+array[7]+","
                + ""+array[8]+" "+array[9]+" "+array[10]+" "+array[11]+","
                + ""+array[12]+" "+array[13]+" "+array[14]+" "+array[15]+","
                + ""+array[16]+" "+array[17]+" "+array[18]+" "+array[19]+","
                + ""+array[20]+" "+array[21]+" "+array[22]+" "+array[23]+","
                + ""+array[24]+" "+array[25]+" "+array[26]+" "+array[27]+")";
        System.out.println("sql 7 "+sql);             
        }else if(columnCount == 8){
        sql = "create table "+tableName+"("
                + ""+array[0]+" "+array[1]+" "+array[2]+" "+array[3]+","
                + ""+array[4]+" "+array[5]+" "+array[6]+" "+array[7]+","
                + ""+array[8]+" "+array[9]+" "+array[10]+" "+array[11]+","
                + ""+array[12]+" "+array[13]+" "+array[14]+" "+array[15]+","
                + ""+array[16]+" "+array[17]+" "+array[18]+" "+array[19]+","
                + ""+array[20]+" "+array[21]+" "+array[22]+" "+array[23]+","
                + ""+array[24]+" "+array[25]+" "+array[26]+" "+array[27]+","
                + ""+array[28]+" "+array[29]+" "+array[30]+" "+array[31]+")";
        System.out.println("sql 7 "+sql);             
        }else{
            JOptionPane.showMessageDialog(this,"No match columncount with data");
        }
        
        stmt.executeUpdate(sql);
        JOptionPane.showMessageDialog(this,"Create table successfully");
        clearAll();
        
    }catch(Exception e){
        JOptionPane.showMessageDialog(this,"final error "+e.toString());
    }
}

public void clearAll(){
    //table name
    txtTableName.setText("");
    
    //column names
    txt1.setText("");
    txt2.setText("");
    txt3.setText("");
    txt4.setText("");
    txt5.setText("");
    txt6.setText("");
    txt7.setText("");
    txt8.setText("");
    
    //column datatype
    comboNumOfColumn.setSelectedIndex(0);
    combo1.setSelectedIndex(0);
    combo2.setSelectedIndex(0);
    combo3.setSelectedIndex(0);
    combo4.setSelectedIndex(0);
    combo5.setSelectedIndex(0);
    combo6.setSelectedIndex(0);
    combo7.setSelectedIndex(0);
    combo8.setSelectedIndex(0);
    
    //column data count
    comboData1.setSelectedIndex(0);
    comboData2.setSelectedIndex(0);
    comboData3.setSelectedIndex(0);
    comboData4.setSelectedIndex(0);
    comboData5.setSelectedIndex(0);
    comboData6.setSelectedIndex(0);
    comboData7.setSelectedIndex(0);
    comboData8.setSelectedIndex(0);
    
    //not null check box
    null1.setSelected(false);
    null2.setSelected(false);
    null3.setSelected(false);
    null4.setSelected(false);
    null5.setSelected(false);
    null6.setSelected(false);
    null7.setSelected(false);
    null8.setSelected(false);
    
    //pk check box
    pk1.setSelected(false);
    pk2.setSelected(false);
    pk3.setSelected(false);
    pk4.setSelected(false);
    pk5.setSelected(false);
    pk6.setSelected(false);
    pk7.setSelected(false);
    pk8.setSelected(false);
    
    //all panel false
    panelAllFalse();
}



public String[] prepareColumn1(){
     String datatype = "";
     String nullType = "";
     String pk = "";
     String name = "";

          
        if(txt1.getText().length() != 0){
          if(combo1.getSelectedIndex() != 0){
                //column1 datatype
            if(combo1.getSelectedIndex()==1 || combo1.getSelectedIndex()==2){
                datatype = combo1.getSelectedItem().toString()+"("+comboData1.getSelectedItem().toString()+")";
            }else{
                datatype = combo1.getSelectedItem().toString();
            }
            
            //column1 null or not null
            if(null1.isSelected()){
                 nullType = "not null";
            }
            
            //column1 pk or not pk
            if(pk1.isSelected()){
                pk="primary key";
            }
            
            //column1 name
             name = txt1.getText();
        
          }else{
               JOptionPane.showMessageDialog(this,"Fill column 1 datatype");
          }
        }else{
            JOptionPane.showMessageDialog(this,"Fill column 1 name");
        }
        System.out.println("column1 select "+name+" "+datatype+" "+nullType+" "+pk);
        String[] data = {name,datatype,nullType,pk};
        return data;     
}

public String[] prepareColumn2(){
     String datatype = "";
     String nullType = "";
     String pk = "";
     String name = "";

          
        if(txt2.getText().length() != 0){
          if(combo2.getSelectedIndex()!=0){
                //column2 datatype
            if(combo2.getSelectedIndex()==1 || combo2.getSelectedIndex()==2){
                datatype = combo2.getSelectedItem().toString()+"("+comboData2.getSelectedItem().toString()+")";
            }else{
                datatype = combo2.getSelectedItem().toString();
            }
            
            //column2 null or not null
            if(null2.isSelected()){
                 nullType = "not null";
            }
            
            //column2 pk or not pk
            if(pk2.isSelected()){
                pk="primary key";
            }
            
            //column2 name
             name = txt2.getText();
          }else{
           JOptionPane.showMessageDialog(this,"Fill column 2 datatype");   
          }
        }else{
            JOptionPane.showMessageDialog(this,"Fill column 2 name");
        }
        System.out.println("column2 select "+name+" "+datatype+" "+nullType+" "+pk);
        String[] data = {name,datatype,nullType,pk};
        return data;     
}

public String[] prepareColumn3(){
     String datatype = "";
     String nullType = "";
     String pk = "";
     String name = "";

          
        if(txt3.getText().length() != 0){
            if(combo3.getSelectedIndex()!=0){
                //column3 datatype
            if(combo3.getSelectedIndex()==1 || combo3.getSelectedIndex()==2){
                datatype = combo3.getSelectedItem().toString()+"("+comboData3.getSelectedItem().toString()+")";
            }else{
                datatype = combo3.getSelectedItem().toString();
            }
            
            //column3 null or not null
            if(null3.isSelected()){
                 nullType = "not null";
            }
            
            //column3 pk or not pk
            if(pk3.isSelected()){
                pk="primary key";
            }
            
            //column3 name
             name = txt3.getText();   
            }else{
                JOptionPane.showMessageDialog(this,"Fill column 3 datatype"); 
            }
        }else{
            JOptionPane.showMessageDialog(this,"Fill column 3 name");
        }
        System.out.println("column3 select "+name+" "+datatype+" "+nullType+" "+pk);
        String[] data = {name,datatype,nullType,pk};
        return data;     
}

public String[] prepareColumn4(){
     String datatype = "";
     String nullType = "";
     String pk = "";
     String name = "";

          
        if(txt4.getText().length() != 0){
          if(combo4.getSelectedIndex()!=0){
                //column4 datatype
            if(combo4.getSelectedIndex()==1 || combo4.getSelectedIndex()==2){
                datatype = combo4.getSelectedItem().toString()+"("+comboData4.getSelectedItem().toString()+")";
            }else{
                datatype = combo4.getSelectedItem().toString();
            }
            
            //column4 null or not null
            if(null4.isSelected()){
                 nullType = "not null";
            }
            
            //column4 pk or not pk
            if(pk4.isSelected()){
                pk="primary key";
            }
            
            //column4 name
             name = txt4.getText();
          }else{
           JOptionPane.showMessageDialog(this,"Fill column 4 datatype");   
          }
        }else{
            JOptionPane.showMessageDialog(this,"Fill column 4 name");
        }
        System.out.println("column4 select "+name+" "+datatype+" "+nullType+" "+pk);
        String[] data = {name,datatype,nullType,pk};
        return data;     
}

public String[] prepareColumn5(){
     String datatype = "";
     String nullType = "";
     String pk = "";
     String name = "";

          
        if(txt5.getText().length() != 0){
            if(combo5.getSelectedIndex()!=0){
             //column5 datatype
            if(combo5.getSelectedIndex()==1 || combo5.getSelectedIndex()==2){
                datatype = combo5.getSelectedItem().toString()+"("+comboData5.getSelectedItem().toString()+")";
            }else{
                datatype = combo5.getSelectedItem().toString();
            }
            
            //column5 null or not null
            if(null5.isSelected()){
                 nullType = "not null";
            }
            
            //column5 pk or not pk
            if(pk5.isSelected()){
                pk="primary key";
            }
            
            //column5 name
             name = txt5.getText();   
            }else{
            JOptionPane.showMessageDialog(this,"Fill column 5 datatype");    
            }
        }else{
            JOptionPane.showMessageDialog(this,"Fill column 5 name");
        }
        System.out.println("column5 select "+name+" "+datatype+" "+nullType+" "+pk);
        String[] data = {name,datatype,nullType,pk};
        return data;     
}

public String[] prepareColumn6(){
     String datatype = "";
     String nullType = "";
     String pk = "";
     String name = "";

          
        if(txt6.getText().length() != 0){
          if(combo6.getSelectedIndex()!=0){
                //column6 datatype
            if(combo6.getSelectedIndex()==1 || combo6.getSelectedIndex()==2){
                datatype = combo6.getSelectedItem().toString()+"("+comboData6.getSelectedItem().toString()+")";
            }else{
                datatype = combo6.getSelectedItem().toString();
            }
            
            //column6 null or not null
            if(null6.isSelected()){
                 nullType = "not null";
            }
            
            //column6 pk or not pk
            if(pk6.isSelected()){
                pk="primary key";
            }
            
            //column1 name
             name = txt6.getText();
          }else{
              JOptionPane.showMessageDialog(this,"Fill column 6 datatype");
          }
        }else{
            JOptionPane.showMessageDialog(this,"Fill column 6 name");
        }
        System.out.println("column6 select "+name+" "+datatype+" "+nullType+" "+pk);
        String[] data = {name,datatype,nullType,pk};
        return data;     
}

public String[] prepareColumn7(){
     String datatype = "";
     String nullType = "";
     String pk = "";
     String name = "";

          
        if(txt7.getText().length() != 0){
           if(combo7.getSelectedIndex()!=0){
             //column7 datatype
            if(combo7.getSelectedIndex()==1 || combo7.getSelectedIndex()==2){
                datatype = combo7.getSelectedItem().toString()+"("+comboData7.getSelectedItem().toString()+")";
            }else{
                datatype = combo7.getSelectedItem().toString();
            }
            
            //column7 null or not null
            if(null7.isSelected()){
                 nullType = "not null";
            }
            
            //column7 pk or not pk
            if(pk7.isSelected()){
                pk="primary key";
            }
            
            //column7 name
             name = txt7.getText();   
           }else{
                JOptionPane.showMessageDialog(this,"Fill column 7 datatype");
           }
        }else{
            JOptionPane.showMessageDialog(this,"Fill column 7 name");
        }
        System.out.println("column7 select "+name+" "+datatype+" "+nullType+" "+pk);
        String[] data = {name,datatype,nullType,pk};
        return data;     
}

public String[] prepareColumn8(){
     String datatype = "";
     String nullType = "";
     String pk = "";
     String name = "";

          
        if(txt8.getText().length() != 0){
        if(combo8.getSelectedIndex()!=0){
                //column8 datatype
            if(combo8.getSelectedIndex()==1 || combo8.getSelectedIndex()==2){
                datatype = combo8.getSelectedItem().toString()+"("+comboData8.getSelectedItem().toString()+")";
            }else{
                datatype = combo8.getSelectedItem().toString();
            }
            
            //column8 null or not null
            if(null8.isSelected()){
                 nullType = "not null";
            }
            
            //column8 pk or not pk
            if(pk8.isSelected()){
                pk="primary key";
            }
            
            //column8 name
             name = txt8.getText();
        }else{
            JOptionPane.showMessageDialog(this,"Fill column 8 datatype");
        }
        }else{
            JOptionPane.showMessageDialog(this,"Fill column 8 name");
        }
        System.out.println("column8 select "+name+" "+datatype+" "+nullType+" "+pk);
        String[] data = {name,datatype,nullType,pk};
        return data;     
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCT = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboNumOfColumn = new javax.swing.JComboBox<>();
        panel1 = new javax.swing.JPanel();
        txt1 = new javax.swing.JTextField();
        combo1 = new javax.swing.JComboBox<>();
        comboData1 = new javax.swing.JComboBox<>();
        null1 = new javax.swing.JCheckBox();
        pk1 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        panel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txt3 = new javax.swing.JTextField();
        combo3 = new javax.swing.JComboBox<>();
        comboData3 = new javax.swing.JComboBox<>();
        null3 = new javax.swing.JCheckBox();
        pk3 = new javax.swing.JCheckBox();
        panel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txt4 = new javax.swing.JTextField();
        combo4 = new javax.swing.JComboBox<>();
        comboData4 = new javax.swing.JComboBox<>();
        null4 = new javax.swing.JCheckBox();
        pk4 = new javax.swing.JCheckBox();
        panel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txt2 = new javax.swing.JTextField();
        combo2 = new javax.swing.JComboBox<>();
        comboData2 = new javax.swing.JComboBox<>();
        null2 = new javax.swing.JCheckBox();
        pk2 = new javax.swing.JCheckBox();
        panel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txt5 = new javax.swing.JTextField();
        combo5 = new javax.swing.JComboBox<>();
        comboData5 = new javax.swing.JComboBox<>();
        null5 = new javax.swing.JCheckBox();
        pk5 = new javax.swing.JCheckBox();
        panel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txt6 = new javax.swing.JTextField();
        combo6 = new javax.swing.JComboBox<>();
        comboData6 = new javax.swing.JComboBox<>();
        null6 = new javax.swing.JCheckBox();
        pk6 = new javax.swing.JCheckBox();
        panel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txt7 = new javax.swing.JTextField();
        combo7 = new javax.swing.JComboBox<>();
        comboData7 = new javax.swing.JComboBox<>();
        null7 = new javax.swing.JCheckBox();
        pk7 = new javax.swing.JCheckBox();
        panel8 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txt8 = new javax.swing.JTextField();
        combo8 = new javax.swing.JComboBox<>();
        comboData8 = new javax.swing.JComboBox<>();
        null8 = new javax.swing.JCheckBox();
        pk8 = new javax.swing.JCheckBox();
        btnBack = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnSet = new javax.swing.JButton();
        txtTableName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelCT.setBackground(new java.awt.Color(255, 153, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Create Table");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Number of Column");

        comboNumOfColumn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "2", "3", "4", "5", "6", "7", "8" }));

        panel1.setBackground(new java.awt.Color(255, 153, 51));

        txt1.setBackground(new java.awt.Color(51, 51, 51));
        txt1.setForeground(new java.awt.Color(255, 255, 255));

        combo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "VARCHAR", "CHAR", "INT", "TINYINT", "DECIMAL", "DOUBLE", "TEXT" }));
        combo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                combo1MousePressed(evt);
            }
        });
        combo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo1ActionPerformed(evt);
            }
        });

        comboData1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6", "8", "10", "20", "40", "60", "80", "100" }));

        null1.setForeground(new java.awt.Color(0, 0, 0));
        null1.setText("Not Null");

        pk1.setForeground(new java.awt.Color(0, 0, 0));
        pk1.setText("primary key");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Column Name");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboData1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(null1)
                .addGap(18, 18, 18)
                .addComponent(pk1)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboData1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(null1)
                    .addComponent(pk1)
                    .addComponent(jLabel3))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        panel3.setBackground(new java.awt.Color(255, 153, 51));

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Column Name");

        txt3.setBackground(new java.awt.Color(51, 51, 51));
        txt3.setForeground(new java.awt.Color(255, 255, 255));

        combo3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "VARCHAR", "CHAR", "INT", "TINYINT", "DECIMAL", "DOUBLE", "TEXT" }));
        combo3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                combo3MousePressed(evt);
            }
        });
        combo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo3ActionPerformed(evt);
            }
        });

        comboData3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6", "8", "10", "20", "40", "60", "80", "100" }));

        null3.setForeground(new java.awt.Color(0, 0, 0));
        null3.setText("Not Null");

        pk3.setForeground(new java.awt.Color(0, 0, 0));
        pk3.setText("primary key");

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combo3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboData3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(null3)
                .addGap(18, 18, 18)
                .addComponent(pk3)
                .addContainerGap())
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(combo3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboData3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(null3)
                    .addComponent(pk3))
                .addGap(20, 20, 20))
        );

        panel4.setBackground(new java.awt.Color(255, 153, 51));

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Column Name");

        txt4.setBackground(new java.awt.Color(51, 51, 51));
        txt4.setForeground(new java.awt.Color(255, 255, 255));

        combo4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "VARCHAR", "CHAR", "INT", "TINYINT", "DECIMAL", "DOUBLE", "TEXT" }));
        combo4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                combo4MousePressed(evt);
            }
        });
        combo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo4ActionPerformed(evt);
            }
        });

        comboData4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6", "8", "10", "20", "40", "60", "80", "100" }));

        null4.setForeground(new java.awt.Color(0, 0, 0));
        null4.setText("Not Null");

        pk4.setForeground(new java.awt.Color(0, 0, 0));
        pk4.setText("primary key");

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combo4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboData4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(null4)
                .addGap(18, 18, 18)
                .addComponent(pk4)
                .addContainerGap())
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboData4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(null4)
                    .addComponent(pk4))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panel2.setBackground(new java.awt.Color(255, 153, 51));
        panel2.setForeground(new java.awt.Color(255, 153, 51));

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Column Name");

        txt2.setBackground(new java.awt.Color(51, 51, 51));
        txt2.setForeground(new java.awt.Color(255, 255, 255));

        combo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "VARCHAR", "CHAR", "INT", "TINYINT", "DECIMAL", "DOUBLE", "TEXT" }));
        combo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                combo2MousePressed(evt);
            }
        });
        combo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo2ActionPerformed(evt);
            }
        });

        comboData2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6", "8", "10", "20", "40", "60", "80", "100" }));

        null2.setForeground(new java.awt.Color(0, 0, 0));
        null2.setText("Not Null");

        pk2.setForeground(new java.awt.Color(0, 0, 0));
        pk2.setText("primary key");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combo2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboData2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(null2)
                .addGap(18, 18, 18)
                .addComponent(pk2)
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboData2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(null2)
                    .addComponent(pk2))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panel5.setBackground(new java.awt.Color(255, 153, 51));

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Column Name");

        txt5.setBackground(new java.awt.Color(51, 51, 51));
        txt5.setForeground(new java.awt.Color(255, 255, 255));

        combo5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "VARCHAR", "CHAR", "INT", "TINYINT", "DECIMAL", "DOUBLE", "TEXT" }));
        combo5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                combo5MousePressed(evt);
            }
        });
        combo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo5ActionPerformed(evt);
            }
        });

        comboData5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6", "8", "10", "20", "40", "60", "80", "100" }));

        null5.setForeground(new java.awt.Color(0, 0, 0));
        null5.setText("Not Null");

        pk5.setForeground(new java.awt.Color(0, 0, 0));
        pk5.setText("primary key");

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combo5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboData5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(null5)
                .addGap(18, 18, 18)
                .addComponent(pk5)
                .addContainerGap())
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboData5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(null5)
                    .addComponent(pk5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel6.setBackground(new java.awt.Color(255, 153, 51));

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Column Name");

        txt6.setBackground(new java.awt.Color(51, 51, 51));
        txt6.setForeground(new java.awt.Color(255, 255, 255));

        combo6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "VARCHAR", "CHAR", "INT", "TINYINT", "DECIMAL", "DOUBLE", "TEXT" }));
        combo6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                combo6MousePressed(evt);
            }
        });
        combo6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo6ActionPerformed(evt);
            }
        });

        comboData6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6", "8", "10", "20", "40", "60", "80", "100" }));

        null6.setForeground(new java.awt.Color(0, 0, 0));
        null6.setText("Not Null");

        pk6.setForeground(new java.awt.Color(0, 0, 0));
        pk6.setText("primary key");

        javax.swing.GroupLayout panel6Layout = new javax.swing.GroupLayout(panel6);
        panel6.setLayout(panel6Layout);
        panel6Layout.setHorizontalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combo6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboData6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(null6)
                .addGap(18, 18, 18)
                .addComponent(pk6)
                .addContainerGap())
        );
        panel6Layout.setVerticalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboData6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(null6)
                    .addComponent(pk6))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panel7.setBackground(new java.awt.Color(255, 153, 51));

        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Column Name");

        txt7.setBackground(new java.awt.Color(51, 51, 51));
        txt7.setForeground(new java.awt.Color(255, 255, 255));

        combo7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "VARCHAR", "CHAR", "INT", "TINYINT", "DECIMAL", "DOUBLE", "TEXT" }));
        combo7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                combo7MousePressed(evt);
            }
        });
        combo7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo7ActionPerformed(evt);
            }
        });

        comboData7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6", "8", "10", "20", "40", "60", "80", "100" }));

        null7.setForeground(new java.awt.Color(0, 0, 0));
        null7.setText("Not Null");

        pk7.setForeground(new java.awt.Color(0, 0, 0));
        pk7.setText("primary key");

        javax.swing.GroupLayout panel7Layout = new javax.swing.GroupLayout(panel7);
        panel7.setLayout(panel7Layout);
        panel7Layout.setHorizontalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel7Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combo7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboData7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(null7)
                .addGap(18, 18, 18)
                .addComponent(pk7)
                .addContainerGap())
        );
        panel7Layout.setVerticalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboData7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(null7)
                    .addComponent(pk7))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panel8.setBackground(new java.awt.Color(255, 153, 51));

        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Column Name");

        txt8.setBackground(new java.awt.Color(51, 51, 51));
        txt8.setForeground(new java.awt.Color(255, 255, 255));

        combo8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "VARCHAR", "CHAR", "INT", "TINYINT", "DECIMAL", "DOUBLE", "TEXT" }));
        combo8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                combo8MousePressed(evt);
            }
        });
        combo8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo8ActionPerformed(evt);
            }
        });

        comboData8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6", "8", "10", "20", "40", "60", "80", "100" }));

        null8.setForeground(new java.awt.Color(0, 0, 0));
        null8.setText("Not Null");

        pk8.setForeground(new java.awt.Color(0, 0, 0));
        pk8.setText("primary key");

        javax.swing.GroupLayout panel8Layout = new javax.swing.GroupLayout(panel8);
        panel8.setLayout(panel8Layout);
        panel8Layout.setHorizontalGroup(
            panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel8Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combo8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboData8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(null8)
                .addGap(18, 18, 18)
                .addComponent(pk8)
                .addContainerGap())
        );
        panel8Layout.setVerticalGroup(
            panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txt8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboData8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(null8)
                    .addComponent(pk8))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnCreate.setBackground(new java.awt.Color(0, 0, 0));
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setText("CREATE");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnSet.setBackground(new java.awt.Color(0, 0, 0));
        btnSet.setForeground(new java.awt.Color(255, 255, 255));
        btnSet.setText("SET");
        btnSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetActionPerformed(evt);
            }
        });

        txtTableName.setBackground(new java.awt.Color(51, 51, 51));
        txtTableName.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Table Name");

        javax.swing.GroupLayout panelCTLayout = new javax.swing.GroupLayout(panelCT);
        panelCT.setLayout(panelCTLayout);
        panelCTLayout.setHorizontalGroup(
            panelCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCTLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelCTLayout.createSequentialGroup()
                        .addGroup(panelCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(panelCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTableName)
                            .addComponent(comboNumOfColumn, 0, 96, Short.MAX_VALUE))
                        .addGroup(panelCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCTLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSet, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCTLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(130, 130, 130)))
                        .addGroup(panelCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCreate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBack, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(253, 253, 253))
        );
        panelCTLayout.setVerticalGroup(
            panelCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCTLayout.createSequentialGroup()
                .addGroup(panelCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCTLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCTLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTableName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(comboNumOfColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(panel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetActionPerformed
        if(comboNumOfColumn.getSelectedIndex() != 0){
            
             numberOfColumn = Integer.parseInt(comboNumOfColumn.getSelectedItem().toString());
            
            switch(numberOfColumn){
                case 2:panelShow(2);break;
                case 3:panelShow(3);break;
                case 4:panelShow(4);break;
                case 5:panelShow(5);break;
                case 6:panelShow(6);break;
                case 7:panelShow(7);break;
                case 8:panelShow(8);break;
            }
            
        }else{
            JOptionPane.showMessageDialog(this,"Select number of column to create");
        }
    }//GEN-LAST:event_btnSetActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
   
        if(txtTableName.getText().length() != 0){
            tableName = txtTableName.getText().toString();
            if(numberOfColumn > 0){
               startCreate(numberOfColumn);       
        }else{
            JOptionPane.showMessageDialog(this,"First select require column to create table");
        }
        }else{
            JOptionPane.showMessageDialog(this,"Enter table name first");
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void combo1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo1MousePressed

    }//GEN-LAST:event_combo1MousePressed

    private void combo2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo2MousePressed

    }//GEN-LAST:event_combo2MousePressed

    private void combo3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo3MousePressed

    }//GEN-LAST:event_combo3MousePressed

    private void combo4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo4MousePressed
        
    }//GEN-LAST:event_combo4MousePressed

    private void combo5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo5MousePressed

    }//GEN-LAST:event_combo5MousePressed

    private void combo6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo6MousePressed

    }//GEN-LAST:event_combo6MousePressed

    private void combo7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo7MousePressed

    }//GEN-LAST:event_combo7MousePressed

    private void combo8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo8MousePressed

    }//GEN-LAST:event_combo8MousePressed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       Tables tb = new Tables();
       this.setVisible(false);
       tb.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void combo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo1ActionPerformed
   if(combo1.getSelectedIndex()==1 || combo1.getSelectedIndex()==2){
            comboData1.setVisible(true);
        }else{
            comboData1.setVisible(false);
        }
    }//GEN-LAST:event_combo1ActionPerformed

    private void combo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo2ActionPerformed
       if(combo2.getSelectedIndex()==1 || combo2.getSelectedIndex()==2){
            comboData2.setVisible(true);
        }else{
            comboData2.setVisible(false);
        }
    }//GEN-LAST:event_combo2ActionPerformed

    private void combo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo3ActionPerformed
               if(combo3.getSelectedIndex()==1 || combo3.getSelectedIndex()==2){
            comboData3.setVisible(true);
        }else{
            comboData3.setVisible(false);
        }
    }//GEN-LAST:event_combo3ActionPerformed

    private void combo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo4ActionPerformed
       if(combo4.getSelectedIndex()==1 || combo4.getSelectedIndex()==2){
            comboData4.setVisible(true);
        }else{
            comboData4.setVisible(false);
        }
    }//GEN-LAST:event_combo4ActionPerformed

    private void combo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo5ActionPerformed
           if(combo5.getSelectedIndex()==1 || combo5.getSelectedIndex()==2){
            comboData5.setVisible(true);
        }else{
            comboData5.setVisible(false);
        }
    }//GEN-LAST:event_combo5ActionPerformed

    private void combo6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo6ActionPerformed
             if(combo6.getSelectedIndex()==1 || combo6.getSelectedIndex()==2){
            comboData6.setVisible(true);
        }else{
            comboData6.setVisible(false);
        }
    }//GEN-LAST:event_combo6ActionPerformed

    private void combo7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo7ActionPerformed
         if(combo7.getSelectedIndex()==1 || combo7.getSelectedIndex()==2){
            comboData7.setVisible(true);
        }else{
            comboData7.setVisible(false);
        }
    }//GEN-LAST:event_combo7ActionPerformed

    private void combo8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo8ActionPerformed
              if(combo8.getSelectedIndex()==1 || combo8.getSelectedIndex()==2){
            comboData8.setVisible(true);
        }else{
            comboData8.setVisible(false);
        }
    }//GEN-LAST:event_combo8ActionPerformed

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
            java.util.logging.Logger.getLogger(CreateTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnSet;
    private javax.swing.JComboBox<String> combo1;
    private javax.swing.JComboBox<String> combo2;
    private javax.swing.JComboBox<String> combo3;
    private javax.swing.JComboBox<String> combo4;
    private javax.swing.JComboBox<String> combo5;
    private javax.swing.JComboBox<String> combo6;
    private javax.swing.JComboBox<String> combo7;
    private javax.swing.JComboBox<String> combo8;
    private javax.swing.JComboBox<String> comboData1;
    private javax.swing.JComboBox<String> comboData2;
    private javax.swing.JComboBox<String> comboData3;
    private javax.swing.JComboBox<String> comboData4;
    private javax.swing.JComboBox<String> comboData5;
    private javax.swing.JComboBox<String> comboData6;
    private javax.swing.JComboBox<String> comboData7;
    private javax.swing.JComboBox<String> comboData8;
    private javax.swing.JComboBox<String> comboNumOfColumn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JCheckBox null1;
    private javax.swing.JCheckBox null2;
    private javax.swing.JCheckBox null3;
    private javax.swing.JCheckBox null4;
    private javax.swing.JCheckBox null5;
    private javax.swing.JCheckBox null6;
    private javax.swing.JCheckBox null7;
    private javax.swing.JCheckBox null8;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panel5;
    private javax.swing.JPanel panel6;
    private javax.swing.JPanel panel7;
    private javax.swing.JPanel panel8;
    private javax.swing.JPanel panelCT;
    private javax.swing.JCheckBox pk1;
    private javax.swing.JCheckBox pk2;
    private javax.swing.JCheckBox pk3;
    private javax.swing.JCheckBox pk4;
    private javax.swing.JCheckBox pk5;
    private javax.swing.JCheckBox pk6;
    private javax.swing.JCheckBox pk7;
    private javax.swing.JCheckBox pk8;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    private javax.swing.JTextField txt4;
    private javax.swing.JTextField txt5;
    private javax.swing.JTextField txt6;
    private javax.swing.JTextField txt7;
    private javax.swing.JTextField txt8;
    private javax.swing.JTextField txtTableName;
    // End of variables declaration//GEN-END:variables

    private String[] add(String[] prepareColumn1, String[] prepareColumn10) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}




