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
public class RoomStall {
    
    private int id;
    private int stall_number;
    private int location_id;
    private String type;
    private String size;
    private String status;
    private String dayfrom;
    private String dayto;
    
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public void setStallNum(int stall_number){
        this.stall_number = stall_number;
    }
    public int getStallNum(){
        return stall_number;
    }
    
    public int getLocationId(){
        return location_id;
    }
    public void setLocationId(int location_id){
        this.location_id = location_id;
    }
    
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
   
    public String getSize(){
        return size;
    }
    public void setSize(String size){
        this.size = size;
    }
    
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    
    public String getDayFrom(){
        return dayfrom;
    }
    public void setDayFrom(String dayfrom){
        this.dayfrom = dayfrom;
    }
    
    public String getDayTo(){
        return dayto;
    }
    public void setDayTo(String dayto){
        this.dayto = dayto;
    }
}
