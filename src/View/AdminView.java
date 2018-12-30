/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Database.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Amanda
 */
public class AdminView {
    
    
    private static Connect connect;
    
    public AdminView(){
        connect = connect.getInstance();
    }
    
    public boolean adminlogin(String email, String password){
        boolean returnValue = false;
        
        try{
            String query = "SELECT * FROM admins WHERE email = ? AND password = ?";
            PreparedStatement ps = connect.execute(query);
            ps.setString(1, email);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                returnValue = true;
            }
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, "Something Went Wrong");
            e.printStackTrace();
            
        }
        
        return returnValue;
    }
}
