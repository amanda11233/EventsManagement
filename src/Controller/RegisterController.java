/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.User;
import View.RegisterView;
/**
 *
 * @author Amanda
 */
public class RegisterController {
    
    User model;
    RegisterView view;
    
    public RegisterController(User model, RegisterView view){
     this.model = model;
     this.view = view;
    }
    
    
    
    public void setName(String name){
        model.setName(name);
    }
    
    public String getName(){
        return model.getName();
    }
    
    public void setAddress(String address){
        model.setAddress(address);
    }
    
    public String getAddress(){
        return model.getAddress();
    }
    
    public void setPhone(long phone){
        model.setPhone(phone);
    }
    
    public long getPhone(){
        return model.getPhone();
    }
    
    public void setGender(String gender){
        model.setGender(gender);
    }
    
    public String getGender(){
        return model.getGender();
    }
    
    public void setEmail(String email){
        model.setEmail(email);
    }
    
    public String getEmail(){
        return model.getEmail();
    }
    
    public void setSalt(String salt){
        model.setSalt(salt);
    }
    
    public String getSalt(){
        return model.getSalt();
    }
    
    public void setPassword(String password){
        model.setPassword(password);
    }
    
    public String getPassword(){
        return model.getPassword();
    }
    
    public void register(){
        view.register(model.getName(), model.getAddress(), model.getPhone(), model.getGender(), model.getEmail(), model.getPassword());
    }
    public boolean verifyEmail(){
        
        if(view.verifyEmail(getEmail())){
            return true;
        }
        return false;
    }
    public void storeSalt(){
        view.storePasswordSalt(model.getSalt(), model.getEmail());
    }
}
