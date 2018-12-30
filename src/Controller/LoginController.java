/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.LoginView;
import Model.User;
/**
 *
 * @author Amanda
 */
public class LoginController {
    
    private LoginView view;
    private User model;
    
    public LoginController(LoginView view, User model){
        this.view = view;
        this.model = model;
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
    
      
    public boolean updateview(){
      if(  view.auth(model.getEmail(), model.getPassword()))
      {
          return true;
      }
      return false;
    }
    public String getSalt(){
      return  view.getSalt(model.getEmail());
      
    }
    
    
}
