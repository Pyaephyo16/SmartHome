/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartHome;

import Lib.Source;
//import com.mysql.jdbc.PreparedStatement;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author user
 */
public class CRUDTable extends javax.swing.JFrame{

  ResultSet rs = null;
    Connection conn = null;
    Statement stmt = null;
    
        //int userSelectTable = 0;
   List<String> list = new ArrayList<String>();
   Map<Object,List<Object>> dataMap = new LinkedHashMap<>();
   boolean isOut = true;
   
   int userSelectRow = -1;
   
   JTable table;
   JTable dtTable;
   CardLayout card;
   JPanel cardPane;
   
   ///Test
   private LinkedList<TableModelListener> listeners = new LinkedList<TableModelListener>();
    
    public CRUDTable() {
        initComponents();
        //DisplayDatatype();
        Display();
        Scrollable();
        allPanelFalse();
    }
    
    public void allPanelFalse(){
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        panel7.setVisible(false);
        panel8.setVisible(false);
    }
    
    public void allClearTextField(){
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setText("");
        txt6.setText("");
        txt7.setText("");
        txt8.setText("");
    }
    
    public void controlRadio(){
          if(rdbInsert.isSelected()){
            
            btnDone.setText("INSERT");
            allClearTextField();
            table.clearSelection();
            
        }else if(rdbUpdate.isSelected()){
            
            btnDone.setText("UPDATE");
             txt1.setEditable(false);
              System.out.println("set false edit");    
            allClearTextField();
            table.clearSelection();
            
        }else if(rdbDelete.isSelected()){
            
            btnDone.setText("DELETE"); 
            allClearTextField();
            allPanelFalse();
            table.clearSelection();
            
        }else{
            btnDone.setText("DONE"); 
            allClearTextField();
            table.clearSelection();
        }
    }
    
    public boolean checkFields(int numOfColumn){
           if(numOfColumn == 2){
               
             if(txt1.getText().length() !=0 && txt2.getText().length() != 0){
                 return true;
             }else{
                 return false;
             }
               
           }else if(numOfColumn == 3){
              
              if(txt1.getText().length() !=0 && txt2.getText().length() != 0 && txt3.getText().length() !=0){
                 return true;
             }else{
                 return false;
             }  
               
           }else if(numOfColumn == 4){
               
           if(txt1.getText().length() !=0 && txt2.getText().length() != 0 && txt3.getText().length() !=0 && txt4.getText().length() !=0){
                 return true;
             }else{
                 return false;
             }   
               
           }else if(numOfColumn == 5){
               
            if(txt1.getText().length() !=0 && txt2.getText().length() != 0 && txt3.getText().length() !=0 && txt4.getText().length() !=0 && txt5.getText().length() !=0){
                 return true;
             }else{
                 return false;
             }    
               
           }else if(numOfColumn == 6){
               
            if(txt1.getText().length() !=0 && txt2.getText().length() != 0 && txt3.getText().length() !=0 && txt4.getText().length() !=0 && txt5.getText().length() !=0 && txt6.getText().length() !=0){
                 return true;
             }else{
                 return false;
             } 
               
           }else if(numOfColumn == 7){

            if(txt1.getText().length() !=0 && txt2.getText().length() != 0 && txt3.getText().length() !=0 && txt4.getText().length() !=0 && txt5.getText().length() !=0 && txt6.getText().length() !=0 && txt7.getText().length() !=0){
                 return true;
             }else{
                 return false;
             }
               
           }else if(numOfColumn == 8){

            if(txt1.getText().length() !=0 && txt2.getText().length() != 0 && txt3.getText().length() !=0 && txt4.getText().length() !=0 && txt5.getText().length() !=0 && txt6.getText().length() !=0 && txt7.getText().length() !=0 && txt8.getText().length() !=0){
                 return true;
             }else{
                 return false;
             }
               
           }else{
               return false;
           }
    }
    
    public String[] prepareData(int columnCount){
    if(columnCount == 2){ 
        String[] twoColumnArray = new String[2];
        twoColumnArray[0] = txt1.getText();
        twoColumnArray[1] = txt2.getText();   
        return twoColumnArray;
    }else if(columnCount ==3){
        String[] threeColumnArray = new String[3];
        threeColumnArray[0] = txt1.getText();
        threeColumnArray[1] = txt2.getText();  
        threeColumnArray[2] = txt3.getText();
        return threeColumnArray;
    }else if(columnCount ==4){
        String[] fourColumnArray = new String[4];
        fourColumnArray[0] = txt1.getText();
        fourColumnArray[1] = txt2.getText();  
        fourColumnArray[2] = txt3.getText();
        fourColumnArray[3] = txt4.getText();
        return fourColumnArray;
    }else if(columnCount == 5){
       String[] fiveColumnArray = new String[5];
        fiveColumnArray[0] = txt1.getText();
        fiveColumnArray[1] = txt2.getText();  
        fiveColumnArray[2] = txt3.getText();
        fiveColumnArray[3] = txt4.getText();
        fiveColumnArray[4] = txt5.getText();
        return fiveColumnArray;
    }else if(columnCount == 6){
       String[] sixColumnArray = new String[6];
        sixColumnArray[0] = txt1.getText();
        sixColumnArray[1] = txt2.getText();  
        sixColumnArray[2] = txt3.getText();
        sixColumnArray[3] = txt4.getText();
        sixColumnArray[4] = txt5.getText();
        sixColumnArray[5] = txt6.getText();
        return sixColumnArray;
    }else if(columnCount == 7){
       String[] sevenColumnArray = new String[7];
        sevenColumnArray[0] = txt1.getText();
        sevenColumnArray[1] = txt2.getText();  
        sevenColumnArray[2] = txt3.getText();
        sevenColumnArray[3] = txt4.getText();
        sevenColumnArray[4] = txt5.getText();
        sevenColumnArray[5] = txt6.getText();
        sevenColumnArray[6] = txt7.getText();
        return sevenColumnArray;
    }else if(columnCount == 8){
       String[] eightColumnArray = new String[8];
        eightColumnArray[0] = txt1.getText();
        eightColumnArray[1] = txt2.getText();  
        eightColumnArray[2] = txt3.getText();
        eightColumnArray[3] = txt4.getText();
        eightColumnArray[4] = txt5.getText();
        eightColumnArray[5] = txt6.getText();
        eightColumnArray[6] = txt7.getText();
        eightColumnArray[7] = txt8.getText();
        return eightColumnArray;
    }else{
        JOptionPane.showMessageDialog(this,"Something went wrong");
        String[] emptyArray = new String[1];
        return emptyArray;
    } 
    }
    
        public void Scrollable(){
          ppCrud.setBorder(BorderFactory.createLineBorder(Color.orange));
        ppCrud.setPreferredSize(new Dimension(600,880));

        final JScrollPane scroll = new JScrollPane(ppCrud);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        setLayout(new BorderLayout());
        add(scroll, BorderLayout.CENTER);
        this.setBackground(Color.orange);
        setSize(700,720);
        setVisible(true);
    }
    
    public void tableDataFinalWork(String[] array,int columnCount,boolean isInsert){
      System.out.println("table data final work array "+Arrays.toString(array));  
        System.out.println("table data final work array length "+array.length);
        try{
            
          Class.forName(Source.driver);
          conn = DriverManager.getConnection(Source.url,Source.userName,Source.password);
          stmt = conn.createStatement();
          
          String insertSql = "";
          String updateSql = "";
          
          if(isInsert == true){
              ///Insert sql
            if(columnCount == 2){
         insertSql = "insert into "+Source.tableTable+" values('"+array[0]+"','"+array[1]+"')";
            }else if(columnCount == 3){
         insertSql = "insert into "+Source.tableTable+" values('"+array[0]+"','"+array[1]+"',"
                 + "'"+array[2]+"')";       
            }else if(columnCount == 4){
         insertSql = "insert into "+Source.tableTable+" values('"+array[0]+"','"+array[1]+"',"
                 + "'"+array[2]+"','"+array[3]+"')";                
            }else if(columnCount == 5){
         insertSql = "insert into "+Source.tableTable+" values('"+array[0]+"','"+array[1]+"',"
                 + "'"+array[2]+"','"+array[3]+"','"+array[4]+"')";                
            }else if(columnCount == 6){
         insertSql = "insert into "+Source.tableTable+" values('"+array[0]+"','"+array[1]+"',"
                 + "'"+array[2]+"','"+array[3]+"','"+array[4]+"','"+array[5]+"')";                
            }else if(columnCount == 7){
         insertSql = "insert into "+Source.tableTable+" values('"+array[0]+"','"+array[1]+"',"
                 + "'"+array[2]+"','"+array[3]+"','"+array[4]+"','"+array[5]+"','"+array[6]+"')";                  
            }else if(columnCount == 8){
         insertSql = "insert into "+Source.tableTable+" values('"+array[0]+"','"+array[1]+"',"
                 + "'"+array[2]+"','"+array[3]+"','"+array[4]+"','"+array[5]+"','"+array[6]+"',"
                 + "'"+array[7]+"')";                
            }
         System.out.println("insert query "+insertSql);
         
         stmt.execute(insertSql);
         JOptionPane.showMessageDialog(this,"Add new data success");     
         newTableData();
          }else{
               ///Update sql
            if(columnCount == 2){
          updateSql = "update "+Source.tableTable+" set "+list.get(0)+"='"+array[0]+"',"
                  + ""+list.get(1)+"='"+array[1]+"' where "+list.get(0)+"='"+array[0]+"'";
            }else if(columnCount == 3){
          updateSql = "update "+Source.tableTable+" set "+list.get(0)+"='"+array[0]+"',"
                  + ""+list.get(1)+"='"+array[1]+"',"+list.get(2)+"='"+array[2]+"'"
                  + " where "+list.get(0)+"='"+array[0]+"'";                
            }else if(columnCount == 4){
          updateSql = "update "+Source.tableTable+" set "+list.get(0)+"='"+array[0]+"',"
                  + ""+list.get(1)+"='"+array[1]+"',"
                  + ""+list.get(2)+"='"+array[2]+"',"+list.get(3)+"='"+array[3]+"'"
                  + " where "+list.get(0)+"='"+array[0]+"'";                
            }else if(columnCount == 5){
          updateSql = "update "+Source.tableTable+" set "+list.get(0)+"='"+array[0]+"',"
                  + ""+list.get(1)+"='"+array[1]+"',"+list.get(2)+"='"+array[2]+"',"
                  + ""+list.get(3)+"='"+array[3]+"',"+list.get(4)+"='"+array[4]+"' "
                  + "where "+list.get(0)+"='"+array[0]+"'";                
            }else if(columnCount == 6){
          updateSql = "update "+Source.tableTable+" set "+list.get(0)+"='"+array[0]+"',"
                  + ""+list.get(1)+"='"+array[1]+"',"+list.get(2)+"='"+array[2]+"',"
                  + ""+list.get(3)+"='"+array[3]+"',"+list.get(4)+"='"+array[4]+"',"
                  + ""+list.get(5)+"='"+array[5]+"' where "+list.get(0)+"='"+array[0]+"'";                 
            }else if(columnCount == 7){
          updateSql = "update "+Source.tableTable+" set "+list.get(0)+"='"+array[0]+"',"
                  + ""+list.get(1)+"='"+array[1]+"',"+list.get(2)+"='"+array[2]+"',"
                  + ""+list.get(3)+"='"+array[3]+"',"+list.get(4)+"='"+array[4]+"',"
                  + ""+list.get(5)+"='"+array[5]+"',"+list.get(6)+"='"+array[6]+"' "
                  + "where "+list.get(0)+"='"+array[0]+"'";                
            }else if(columnCount == 8){
          updateSql = "update "+Source.tableTable+" set "+list.get(0)+"='"+array[0]+"',"
                  + ""+list.get(1)+"='"+array[1]+"',"+list.get(2)+"='"+array[2]+"',"
                  + ""+list.get(3)+"='"+array[3]+"',"+list.get(4)+"='"+array[4]+"',"
                  + ""+list.get(5)+"='"+array[5]+"',"+list.get(6)+"='"+array[6]+"',"
                  + ""+list.get(7)+"='"+array[7]+"' where "+list.get(0)+"='"+array[0]+"'";                     
            } 
             System.out.println("update query "+updateSql); 
             stmt.executeUpdate(updateSql);
         JOptionPane.showMessageDialog(this,"Update data success");
         newTableData();
          }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.toString());
        }
    }
    
    public void deleteTableData(int columnCount,int index){
        try{
            
         Class.forName(Source.driver);
          conn = DriverManager.getConnection(Source.url,Source.userName,Source.password);
          stmt = conn.createStatement(); 
          
          String deleteId = table.getValueAt(index,0).toString();
            System.out.println("crud delete "+list.get(0)+"  "+deleteId);
          String deleteSql = "delete from "+Source.tableTable+" where "+list.get(0)+"='"+deleteId+"'";
            System.out.println("delete sql "+deleteSql);
            stmt.executeUpdate(deleteSql);
            JOptionPane.showMessageDialog(this,"Delete success");
            newTableData();
            tableListen(table);
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(this,e.toString());
        }
    }
    
   public void newTableData(){
         List<String> updateList = new ArrayList<String>();
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
                     System.out.println("newTable DAta "+name);
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
           tableListen(table);

        }catch(Exception e){
              System.out.println(e.toString());
             JOptionPane.showMessageDialog(this,e.toString());
        }
     ///CURD reach normal state
     allClearTextField();
    }
    
   
//    public void DisplayDatatype(){
//       dataMap.clear();
//       list.clear();
//        try{  
//         Class.forName(Source.driver);
//         conn = DriverManager.getConnection(Source.url,Source.userName,Source.password);
//         stmt = conn.createStatement();
//         ///Start table here  
//          String sql = "select * from "+Source.tableTable+"";  
//             rs = stmt.executeQuery(sql);
//             int count = 0;  
//             while(rs.next()){
//              count++;   
//             }
//             System.out.println("count "+count);
//             if(count > 0){
//                   Display();
//             }else{
//          System.out.println("here because of count 0");
//           Class.forName(Source.driver);
//         conn = DriverManager.getConnection(Source.url,Source.userName,Source.password);
//         stmt = conn.createStatement();
//         ///Start table here  
//          String des = "desc testDb."+Source.tableTable+"";
//         System.out.println("db des "+des);
//          stmt.executeQuery(des);
//          
//             rs = stmt.executeQuery(des);
//              ResultSetMetaData resultSetMetaData = rs.getMetaData();
//             int columnCount = resultSetMetaData.getColumnCount();
//             System.out.println("column count edit "+columnCount);
//             
//             for(int i=1;i<=columnCount;i++){
//                 String name = resultSetMetaData.getColumnName(i);
//                 if(name != null){
//                     list.add(name);
//                 }
//             }
//             System.out.println("list column name "+list.toString()+"list length "+list.size());
//             
//             while(rs.next()){
//                 List<Object> list = new ArrayList<Object>();
//                  for(int i=1;i<=columnCount;i++){
//                      Object name = rs.getObject(i);
//                      //if(name == null){
//                          //name = "-";
//                          list.add(name);
//                      //}          
//                      dataMap.put(list.get(0), list);
//                  }   
//             }  
//                   Object[][] data = new Object[dataMap.size()][columnCount];
//                    Set<Object> nameOfType = dataMap.keySet();
//                    List<Object> nameList = new ArrayList<Object>(nameOfType);
//                    for(int i=0;i<data.length;i++){
//          data[i] = dataMap.get(nameList.get(i)).toArray();
//                    }            
//                        dtTable = new JTable(data,list.toArray());
//                        System.out.println("jtable "+dtTable.toString());
//                        dtTable.setRowSelectionAllowed(false);
//                        
//                        dtTable.setBounds(24,64,600,100);                         
//                         JScrollPane jScroll = new JScrollPane(dtTable);
//                        jScroll.setBounds(24,64,600,120);
//                        
//                        cardPane = new JPanel();
//                        card = new CardLayout();
//                        cardPane.setBounds(24,64,600,120);
//                        cardPane.setLayout(card);
//                        
//                        cardPane.add(jScroll);           
//                        card.last(cardPane);
//                        ppCrud.add(cardPane); 
//                                           
//                       this.setVisible(true); 
//             }
//             
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(this,e.toString());
//        }
//        ///CURD reach normal state
//     allClearTextField();
//    }   
   
    public void Display(){
       dataMap.clear();
       list.clear();
       
      try{
          System.out.println("clear all card in panel display");
      
          cardPane.remove(dtTable);
          cardPane.removeAll();
      }catch(Exception e){
          System.out.println("no card in panel display");
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
           }
             }
             System.out.println("list column name "+list.toString()+"list length "+list.size());
             
             while(rs.next()){
                 List<Object> list = new ArrayList<Object>();
                  for(int i=1;i<=columnCount;i++){
                      Object name = rs.getObject(i);        
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
                        tableListen(table);
                        System.out.println("jtable in display "+table.toString());
                        table.setRowSelectionAllowed(true);
                        
                        table.setBounds(24,64,600,100);                         
                         JScrollPane jScroll = new JScrollPane(table);
                        jScroll.setBounds(24,64,600,120);
                        
                        cardPane = new JPanel();
                        card = new CardLayout();
                        cardPane.setBounds(24,64,600,120);
                        cardPane.setLayout(card);
                        
                        cardPane.add(jScroll);
        
                        card.last(cardPane);
                        ppCrud.add(cardPane);
                        ppCrud.setVisible(true);                    
                        this.setVisible(true); 

        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.toString());
        }
        ///CURD reach normal state
     allClearTextField();
    } 
        
        public void tableListen(JTable table){
         //table listener2
        table.addMouseListener(new MouseListener() {
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        @Override
        public void mousePressed(MouseEvent e) {
            JTextField[] txtList = {txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8};
       //String selectedCellValue = String.valueOf(table.getValueAt(table.getSelectedRow() , table.getSelectedColumn()));
        userSelectRow = table.getSelectedRow();
            if(userSelectRow >=0 ){
               for(int i=0;i<list.size();i++){
            txtList[i].setText(table.getValueAt(userSelectRow,i).toString());
        }  
            }
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseClicked(MouseEvent e) {
        }
    });
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
        ppCrud = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        panelRaido = new javax.swing.JPanel();
        rdbInsert = new javax.swing.JRadioButton();
        rdbUpdate = new javax.swing.JRadioButton();
        rdbDelete = new javax.swing.JRadioButton();
        btnSet = new javax.swing.JButton();
        panel2 = new javax.swing.JPanel();
        lb2 = new javax.swing.JLabel();
        txt2 = new javax.swing.JTextField();
        panel1 = new javax.swing.JPanel();
        lb1 = new javax.swing.JLabel();
        txt1 = new javax.swing.JTextField();
        panel3 = new javax.swing.JPanel();
        lb3 = new javax.swing.JLabel();
        txt3 = new javax.swing.JTextField();
        btnDone = new javax.swing.JButton();
        panel5 = new javax.swing.JPanel();
        lb5 = new javax.swing.JLabel();
        txt5 = new javax.swing.JTextField();
        panel6 = new javax.swing.JPanel();
        lb6 = new javax.swing.JLabel();
        txt6 = new javax.swing.JTextField();
        panel7 = new javax.swing.JPanel();
        lb7 = new javax.swing.JLabel();
        txt7 = new javax.swing.JTextField();
        panel8 = new javax.swing.JPanel();
        lb8 = new javax.swing.JLabel();
        txt8 = new javax.swing.JTextField();
        panel4 = new javax.swing.JPanel();
        lb4 = new javax.swing.JLabel();
        txt4 = new javax.swing.JTextField();
        btnShowDataType = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ppCrud.setBackground(new java.awt.Color(255, 153, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Table Data Editor");

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        panelRaido.setBackground(new java.awt.Color(255, 153, 51));

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

        javax.swing.GroupLayout panelRaidoLayout = new javax.swing.GroupLayout(panelRaido);
        panelRaido.setLayout(panelRaidoLayout);
        panelRaidoLayout.setHorizontalGroup(
            panelRaidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRaidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdbInsert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(btnSet))
        );
        panelRaidoLayout.setVerticalGroup(
            panelRaidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRaidoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelRaidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbInsert)
                    .addComponent(rdbUpdate)
                    .addComponent(rdbDelete)
                    .addComponent(btnSet, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel2.setBackground(new java.awt.Color(255, 153, 51));

        lb2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb2.setForeground(new java.awt.Color(0, 0, 0));
        lb2.setText("222");

        txt2.setBackground(new java.awt.Color(51, 51, 51));
        txt2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb2)
                    .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        panel1.setBackground(new java.awt.Color(255, 153, 51));

        lb1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb1.setForeground(new java.awt.Color(0, 0, 0));
        lb1.setText("111");

        txt1.setBackground(new java.awt.Color(51, 51, 51));
        txt1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(390, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb1)
                    .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panel3.setBackground(new java.awt.Color(255, 153, 51));

        lb3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb3.setForeground(new java.awt.Color(0, 0, 0));
        lb3.setText("333");

        txt3.setBackground(new java.awt.Color(51, 51, 51));
        txt3.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb3)
                    .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnDone.setBackground(new java.awt.Color(0, 0, 0));
        btnDone.setForeground(new java.awt.Color(255, 255, 255));
        btnDone.setText("DONE");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        panel5.setBackground(new java.awt.Color(255, 153, 51));

        lb5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb5.setForeground(new java.awt.Color(0, 0, 0));
        lb5.setText("55");

        txt5.setBackground(new java.awt.Color(51, 51, 51));
        txt5.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb5)
                    .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        panel6.setBackground(new java.awt.Color(255, 153, 51));

        lb6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb6.setForeground(new java.awt.Color(0, 0, 0));
        lb6.setText("66");

        txt6.setBackground(new java.awt.Color(51, 51, 51));
        txt6.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel6Layout = new javax.swing.GroupLayout(panel6);
        panel6.setLayout(panel6Layout);
        panel6Layout.setHorizontalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel6Layout.setVerticalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb6)
                    .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        panel7.setBackground(new java.awt.Color(255, 153, 51));

        lb7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb7.setForeground(new java.awt.Color(0, 0, 0));
        lb7.setText("77");

        txt7.setBackground(new java.awt.Color(51, 51, 51));
        txt7.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel7Layout = new javax.swing.GroupLayout(panel7);
        panel7.setLayout(panel7Layout);
        panel7Layout.setHorizontalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel7Layout.setVerticalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb7))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        panel8.setBackground(new java.awt.Color(255, 153, 51));

        lb8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb8.setForeground(new java.awt.Color(0, 0, 0));
        lb8.setText("88");

        txt8.setBackground(new java.awt.Color(51, 51, 51));
        txt8.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel8Layout = new javax.swing.GroupLayout(panel8);
        panel8.setLayout(panel8Layout);
        panel8Layout.setHorizontalGroup(
            panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(txt8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel8Layout.setVerticalGroup(
            panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb8)
                    .addComponent(txt8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        panel4.setBackground(new java.awt.Color(255, 153, 51));

        lb4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb4.setForeground(new java.awt.Color(0, 0, 0));
        lb4.setText("44");

        txt4.setBackground(new java.awt.Color(51, 51, 51));
        txt4.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb4)
                    .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnShowDataType.setBackground(new java.awt.Color(0, 0, 0));
        btnShowDataType.setForeground(new java.awt.Color(255, 255, 255));
        btnShowDataType.setText("SHOW DATATYPE");
        btnShowDataType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowDataTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ppCrudLayout = new javax.swing.GroupLayout(ppCrud);
        ppCrud.setLayout(ppCrudLayout);
        ppCrudLayout.setHorizontalGroup(
            ppCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ppCrudLayout.createSequentialGroup()
                .addGroup(ppCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ppCrudLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                        .addComponent(btnShowDataType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBack))
                    .addGroup(ppCrudLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ppCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ppCrudLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(btnDone))
                            .addComponent(panelRaido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(35, 35, 35))
        );
        ppCrudLayout.setVerticalGroup(
            ppCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ppCrudLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(ppCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnShowDataType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(135, 135, 135)
                .addComponent(panelRaido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(343, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ppCrud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ppCrud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetActionPerformed
        JPanel[] panelList = {panel1,panel2,panel3,panel4,panel5,panel6,panel7,panel8};
        JLabel[] labelList = {lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8};
        if(rdbInsert.isSelected() || rdbUpdate.isSelected()){
            System.out.println("here rdb");
            for(int i=0;i<list.size();i++){
                labelList[i].setText(list.get(i).toString());
               panelList[i].setVisible(true);
            }
        }
        
        //control panels and table with radio 
        controlRadio();
    }//GEN-LAST:event_btnSetActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Tables tb = new Tables();
        this.setVisible(false);
        tb.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        boolean isAllFill = false;
        if(btnDone.getText() != "DONE"){     
          if(rdbInsert.isSelected()){
              isAllFill = false;
             isAllFill = checkFields(list.size());
                if(isAllFill == true){
                    tableDataFinalWork(prepareData(list.size()),list.size(),true);
                }else{
                    JOptionPane.showMessageDialog(this,"Please fill All Fields");
                }
          }else if(rdbUpdate.isSelected()){
              isAllFill = false;
               isAllFill = checkFields(list.size());
                if(isAllFill == true){
                    tableDataFinalWork(prepareData(list.size()),list.size(),false);
                }else{
                    JOptionPane.showMessageDialog(this,"Please fill All Fields");
                } 
          }else if(rdbDelete.isSelected()){  
              if(userSelectRow >= 0){
                  deleteTableData(list.size(),userSelectRow);
              }else{
                  JOptionPane.showMessageDialog(this,"Select a row to delete");
              }  
          }   
         }else{
             JOptionPane.showMessageDialog(this,"Select a option first and press \"SET\" button after choosing an option");
         }
    }//GEN-LAST:event_btnDoneActionPerformed

    private void btnShowDataTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowDataTypeActionPerformed
       
        ShowDataType sdt = new ShowDataType();
        if(isOut == true){
            sdt.setVisible(true);
            btnShowDataType.setText("REMOVE DATATYPE");
            isOut = false;
        }else{
          sdt.setVisible(false);
           btnShowDataType.setText("SHOW DATATYPE");
            isOut = true; 
        }
    }//GEN-LAST:event_btnShowDataTypeActionPerformed

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
            java.util.logging.Logger.getLogger(CRUDTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUDTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUDTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUDTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUDTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnSet;
    private javax.swing.JButton btnShowDataType;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb7;
    private javax.swing.JLabel lb8;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panel5;
    private javax.swing.JPanel panel6;
    private javax.swing.JPanel panel7;
    private javax.swing.JPanel panel8;
    private javax.swing.JPanel panelRaido;
    private javax.swing.JPanel ppCrud;
    private javax.swing.JRadioButton rdbDelete;
    private javax.swing.JRadioButton rdbInsert;
    private javax.swing.JRadioButton rdbUpdate;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    private javax.swing.JTextField txt4;
    private javax.swing.JTextField txt5;
    private javax.swing.JTextField txt6;
    private javax.swing.JTextField txt7;
    private javax.swing.JTextField txt8;
    // End of variables declaration//GEN-END:variables

//    @Override
//    public int getRowCount() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public int getColumnCount() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public String getColumnName(int columnIndex) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Class<?> getColumnClass(int columnIndex) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void addTableModelListener(TableModelListener l) {
//       listeners.add(l);
//    }
//
//    @Override
//    public void removeTableModelListener(TableModelListener l) {
//       listeners.remove(l);
//    }
}
