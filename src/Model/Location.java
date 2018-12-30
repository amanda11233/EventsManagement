/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Amanda
 */
public class Location {
    
    private int id;
    private String location;
    private int capacity;
    private String status;
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    
    public void setLocation(String location){
        this.location = location;
    }
    public String getLocation(){
        return location;
    }
    
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    public int getCapacity(){
        return capacity;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return status;
    }
    
}
