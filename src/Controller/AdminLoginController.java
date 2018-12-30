/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Admin;
import View.AdminView;
/**
 *
 * @author Amanda
 */
public class AdminLoginController {
    
    private Admin model;
    private AdminView view;
    
    public AdminLoginController(Admin model, AdminView view){
        this.model = model;
        this.view = view;
    }
    
    
    public void setEmail(String email){
        model.setEmail(email);
    }
    public String getEmail(){
            return model.getEmail();
    }
    
    public void setPassword(String password){
        model.setPassword(password);
    }
    
    public String getPassword(){
        return model.getPassword();
    }
    
    public boolean adminLogin(){
        
        return view.adminlogin(model.getEmail(), model.getPassword());
    }
    
    
}
