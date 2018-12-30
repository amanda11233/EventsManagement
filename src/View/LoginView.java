/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Database.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

/**
 *
 * @author Amanda
 */
public class LoginView  {
    
    private static Connect connect;
    
    
    public LoginView(){
        connect = connect.getInstance(); 
    }
    
    public String getSalt(String email){
        String value = null;
        try{
            String query = "SELECT salt from password_verify where user_id = (select id from users where email = ?)";
            PreparedStatement ps = connect.execute(query);
            ps.setString(1, email);
            
            ResultSet rs = ps.executeQuery();
                  if(rs.next()){
                    
                          value = rs.getString("salt");
                      
                  }else{
                      value  = "nothing";
                  }
            
        }catch(Exception e){
            System.out.println("Error: " + e);
           e.printStackTrace();
           connect.closeConnection();
        }
        
        return value;
    }
    
   public boolean auth(String email, String password){
       
       boolean check = false;
       
       try{
        
           String query = "SELECT * FROM users where email = ? and password = ?";
           PreparedStatement pd = connect.execute(query); 
           pd.setString(1, email);
           pd.setString(2, password);
           ResultSet rs  = pd.executeQuery();
           if(rs.next()){
               check = true;
           }
           
       }catch(Exception e){
           System.out.println("Error: " + e);
           e.printStackTrace();
           connect.closeConnection();
       }
       
       return check;
       
               }
   
   
    
}
