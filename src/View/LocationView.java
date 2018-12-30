/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Database.Connect;
import System.Locations;
import static System.Locations.tablemodel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Amanda
 */
public class LocationView {
    
    private static  Connect connect;
    
    public LocationView(){
        connect = connect.getInstance();
    }
    
    public ArrayList getLocation(){
        ArrayList data = new ArrayList();
        
        try{
            String query = "SELECT * FROM locations ";
            PreparedStatement ps = connect.execute(query);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                data.add(rs.getInt("id"));
                data.add(rs.getString("location"));
                data.add(rs.getInt("capacity"));
                data.add(rs.getString("status"));
                
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error in storing location");
            e.printStackTrace();
            connect.closeConnection();
        }
        
        return data;
    }
    
    public void store(String location, int capacity, String status){
        
        try{
            String query = "INSERT INTO locations (location, capacity, status) VALUES (?, ?, ?)";
            PreparedStatement ps = connect.execute(query);
            ps.setString(1, location);
            ps.setInt(2, capacity);
            ps.setString(3, status);
            
            ps.executeUpdate();
           
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error in storing location");
            e.printStackTrace();
            connect.closeConnection();
        }
    }
    
    public void search(String location){
        
        try{
            String query = "Select * from locations where location LIKE ?";
            PreparedStatement ps = connect.execute(query);
            ps.setString(1, "%" + location + "%");
            
            ResultSet rs = ps.executeQuery();
           
            int i = 0;
            
            while(rs.next()){
               i++;
               String id  = toString().valueOf(rs.getInt("id"));
               String cap  = toString().valueOf(rs.getInt("capacity"));
               String loc = rs.getString("location");
               String stat = rs.getString("status");
               tablemodel.addRow(new Object[]{id, loc, cap, stat});  
                
            }
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Something Went Wrong");
        e.printStackTrace();
        connect.closeConnection();
    }
       
    }
    
    
    public void updateLocation(int id, String location, int capacity, String status){
        try{
            String query = "UPDATE locations SET location = ? , capacity = ? , status = ? where id = ?";
            PreparedStatement ps = connect.execute(query);
            ps.setString(1, location);
            ps.setInt(2, capacity);
            ps.setString(3, status);
            ps.setInt(4, id);
            
            ps.executeUpdate();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something Went Wrong");
        e.printStackTrace();
            connect.closeConnection();
        }
    }
    
    public void deleteLocation(int id){
        
        try{
            String query = "Delete from locations where id = ?";
            PreparedStatement ps = connect.execute(query);
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something Went Wrong");
            e.printStackTrace();
            connect.closeConnection();
        }
    }
    
    public ArrayList getLocationByName(String location){
        ArrayList data = new ArrayList();
        
        try{
            String query = "SELECT id,capacity from locations where location = ?";
            PreparedStatement ps = connect.execute(query);
            ps.setString(1, location);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
               data.add(rs.getInt("id"));
               data.add(rs.getInt("capacity"));
            }
            
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "Something Went Wrong");
             e.printStackTrace();
             connect.closeConnection();
        }
        
        return data;
    }
    
}
