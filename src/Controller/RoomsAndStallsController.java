/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RoomStall;
import View.RoomsAndStallsView;

/**
 *
 * @author Amanda
 */
public class RoomsAndStallsController {
    
    private RoomStall model;
    private RoomsAndStallsView view;
    
    
    public RoomsAndStallsController(RoomStall model, RoomsAndStallsView view){
        this.model = model;
        this.view = view;
    }
    
    public int getId(){
        return model.getId();
    }
    public void setId(int id){
        model.setId(id);
    }   
    
    public int getStallNum(){
        return model.getStallNum();
    }
    public void setStallNum(int stall_number){
        model.setStallNum(stall_number);
    }
    
    public int getLocationId(){
        return model.getLocationId();
    }
    public void setLocationId(int location_id){
        model.setLocationId(location_id);
    }
    
    public String getType(){
        return model.getType();
    }
    public void setType(String type){
        model.setType(type);
    }
    
    public String getSize(){
        return model.getSize();
    }
    public void setSize(String size){
        model.setSize(size);
    }
    
    public String getStatus(){
        return model.getStatus();
    }
    public void setStatus(String status){
        model.setStatus(status);
    }
    
       public String getDayFrom(){
        return model.getDayFrom();
    }
    public void setDayFrom(String dayfrom){
        model.setDayFrom(dayfrom);
    }
    
    public String getDayTo(){
       return model.getDayTo();
    }
    public void setDayTo(String dayto){
        model.setDayTo(dayto);
    }
    public void store(){
        view.addRoomsStalls(model.getStallNum(), model.getLocationId(), model.getType(), model.getSize(), model.getDayFrom(), model.getDayTo(), model.getStatus());
    }
    
    public boolean checkStallsAvailability(){
        return view.checkStallAvailability(model.getStallNum(), model.getLocationId());
    }
    public int checkLocationCapacity(){
        return view.checkLocationCapacity(model.getLocationId());
    }
    public void searchRoomsOrStalls(){
        view.searchRoomsOrStalls(model.getLocationId(), model.getType());
    }
    public void destroy(){
        view.deleteRoomsAndStalls(model.getId());
    }
}
