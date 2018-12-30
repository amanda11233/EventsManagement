/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Database.Connect;
import System.RoomsAndStalls;
import static System.RoomsAndStalls.stalltablemodel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;

/**
 *
 * @author Amanda
 */
public class RoomsAndStallsView {
    
    private static Connect connect;
    
    public RoomsAndStallsView(){
        connect = connect.getInstance();
    }
    
    public void addRoomsStalls(int stallNumber, int location_id, String type, String size, String dayfrom, String dayto, String status){
        
        try{
            String query = "INSERT INTO rooms_stalls (stall_number, location_id, type, size, dayFrom, dayTo,  status) values (?,?,?,?,?,?,?)";
            PreparedStatement ps = connect.execute(query);
            ps.setInt(1, stallNumber);
            ps.setInt(2, location_id);
            ps.setString(3, type);
            ps.setString(4, size + " sq ft");
            ps.setString(5, dayfrom);
            ps.setString(6, dayto);
            ps.setString(7, status);
            
            ps.executeUpdate();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something Went Wrong");
            e.printStackTrace();
        }
    }
    
    public boolean checkStallAvailability(int stallNumber, int location_id){
        boolean returnValue = false;
        
        try{
        String query = "Select * from rooms_stalls where stall_number = ? and location_id = ?";
        PreparedStatement ps = connect.execute(query);
        ps.setInt(1, stallNumber);
        ps.setInt(2, location_id);
        
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                returnValue = true;
            }
        
        
            }catch(Exception e){
         JOptionPane.showMessageDialog(null, "Something Went Wrong");
            e.printStackTrace();
    }
        
        return returnValue;
    }
    public int checkLocationCapacity(int location_id){
       int rowCount = 0;
        try{
            String query = "Select count(*) as count, capacity from rooms_stalls rs inner join locations l on rs.location_id = l.id and location_id = ?";
            PreparedStatement ps = connect.execute(query);
            ps.setInt(1, location_id);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                rowCount = rs.getInt("count");
            
            if(rowCount >= rs.getInt("capacity")){
                String updateQuery = "update locations set status = ? where id = ?";
                PreparedStatement ps2 = connect.execute(updateQuery);
                ps2.setString(1, "Booked");
                ps2.setInt(2, location_id);
                
                ps2.executeUpdate();
            }else{
                
            }
            }
            
            
           
            
        }catch(Exception e)
        {
           JOptionPane.showMessageDialog(null, "Something Went Wrong");
            e.printStackTrace(); 
        }
        return rowCount;
    }
    
    public void searchRoomsOrStalls(int location_id, String type){
        boolean check = false;
        try{
            String query = "select * from rooms_stalls rs inner join locations l on l.id = rs.location_id and location_id = ? and type = ?";
            PreparedStatement ps = connect.execute(query);
            ps.setInt(1, location_id);
            ps.setString(2, type);
            
            ResultSet rs = ps.executeQuery();
            
               while(rs.next()){
                   check = true;
                int id = rs.getInt("id");
                int number = rs.getInt("stall_number");
                String gettype = rs.getString("type");
                String size = rs.getString("size");
                String status = rs.getString("status");
                String location = rs.getString("location");
                String from = rs.getString("dayFrom");
                String to = rs.getString("dayTo");
                stalltablemodel.addRow(new Object[]{id, number,location, gettype, size, from, to, status});
            
            }
            
                
     
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "Something Went Wrong");
            e.printStackTrace(); 
            connect.closeConnection();
        }
    }
    
    public void deleteRoomsAndStalls(int id){
        try{
            String query = "Delete from rooms_stalls where id = ?";
            PreparedStatement ps = connect.execute(query);
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "Something Went Wrong");
            e.printStackTrace(); 
            connect.closeConnection();
        }
    }
}
