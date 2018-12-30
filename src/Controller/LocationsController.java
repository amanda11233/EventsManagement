/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Location;
import View.LocationView;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Amanda
 */
public class LocationsController {
    
    private Location model;
    private LocationView view;
    
    public LocationsController(Location model, LocationView view){
        this.model = model;
        this.view = view;
    }
    
    public void setId(int id){
        model.setId(id);
    }
    
    public int getId(){
        return model.getId();
    }
    
    public void setLocation(String location){
        model.setLocation(location);
    }
    
    public String getLocation(){
        return model.getLocation();
    }
    
    public void setCapacity(int capacity){
        model.setCapacity(capacity);
    }
    public int getCapacity(){
        return model.getCapacity();
    }
    
    public void setStatus(String status){
        model.setStatus(status);
    }
    public String getStatus(){
        return model.getStatus();
    }
    
    public void store(){
        view.store(model.getLocation(), model.getCapacity(), model.getStatus());
    }
    
    public void search(){
         view.search(model.getLocation());
    }
    
    public void update(){
        view.updateLocation(model.getId(), model.getLocation(), model.getCapacity(), model.getStatus());
    }
    public void destroy(){
        view.deleteLocation(model.getId());
    }
    
    public ArrayList getAllLocation(){
       return view.getLocation();
    }
    
    public ArrayList getLocationByName(){
        return view.getLocationByName(model.getLocation());
    }
}
