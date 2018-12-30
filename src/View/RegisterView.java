/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Database.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Amanda
 */
public class RegisterView {
    
    
    private static Connect connect;
    
    public RegisterView(){
        connect = connect.getInstance();
    }
    
    public void register(String name, String address, long phone, String gender, String email, String password){
        try{
            String query = "INSERT INTO users (name, address, phone, gender, email, password) values (?, ?, ?, ?, ?, ?)";
            
            PreparedStatement preparedStatement = connect.execute(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            preparedStatement.setLong(3, phone);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, password);
            
            preparedStatement.executeUpdate();
                    
            
        }catch(Exception e){
            System.out.println("Error" + e);
            e.printStackTrace();
            connect.closeConnection();
        }
    }
    
    public boolean verifyEmail(String email){
        boolean check = false;
        
        try{
            String query = "SELECT * FROM users WHERE email = ?";
            PreparedStatement preparedStatement = connect.execute(query);
            preparedStatement.setString(1, email);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
              check = true;
            }
            
            
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error" + e);
            JOptionPane.showMessageDialog(null, "Something Went Wrong");
        }
        return check;
    }
    
    public void storePasswordSalt(String salt, String email){
        
        try{
           
            String query = "INSERT INTO password_verify (user_id, salt) values ((SELECT id FROM users WHERE email = ?), ?)";
            PreparedStatement preparedStatement = connect.execute(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, salt);
            
            preparedStatement.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error" + e);
            JOptionPane.showMessageDialog(null, "Something Went Wrong");
        }
        
    }
}
