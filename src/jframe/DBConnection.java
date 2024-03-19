/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jframe;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 91955
 */
public class DBConnection {
    static Connection con;
    
    public static Connection getConnection(){
      try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "1234");
        }catch(Exception e){
            e.printStackTrace();
        }
      return con;
    }
}
