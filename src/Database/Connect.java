/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Amanda
 */
public class Connect implements Config{
    
    public Connection con;
    PreparedStatement preparedStatement;
    private static Connect connect;
    
    public Connect(){
        openConnection();
    }
    
    public static Connect getInstance(){
        if(connect == null){
            connect = new Connect();
        }
        return connect;
    }
    
   
    
    public void openConnection() {
        try{
            Class.forName(driver);
            con  = DriverManager.getConnection(url, username, password);
        }catch(Exception e){
            System.out.println("Error in Opening Connection");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Unable to Connect To Servers");
            
        }
    }
    
    public PreparedStatement execute(String query) {
        try{
            return preparedStatement = con.prepareStatement(query);
        }catch(Exception e){
            System.out.println("Database.Connect.execute()");
            e.printStackTrace();
        }
        return  null;
    }
   
    public void closeConnection(){
        try{
            if(!con.isClosed() || con!=null){
                con.close();
            }
        }catch(Exception e){
            System.out.println("Database.Connect.closeConnection()");
            e.printStackTrace();
        }
    }
}
