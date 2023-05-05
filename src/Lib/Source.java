/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lib;

import javax.naming.Context;

/**
 *
 * @author user
 */
public class Source {
    
   public static String url = "jdbc:mysql://localhost:3306/testDb";
    public static String driver = "com.mysql.jdbc.Driver";
   public static String userName = "root";
   public static String password = "ROOT";
   
   
  public static String tableTable = "";
  public static enum Options { INSERT, UPDATE, DELETE, SEARCH};
  
   ///save user 
  public static String login = "true";
  public static String logout = "false";
  public static String user = "admin";
    
}
