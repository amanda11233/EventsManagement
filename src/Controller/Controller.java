/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Connect;
import java.sql.Connection;

/**
 *
 * @author Amanda
 */
public class Controller{
    
    private static Connect connect;
    
    public Controller(){
      connect = connect.getInstance();
    }
    
    public void login() throws Exception{
       
        
    }
    
}
