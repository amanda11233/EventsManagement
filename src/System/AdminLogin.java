/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import Controller.AdminLoginController;

import Model.Admin;
import static System.PasswordUtils.generateSecurePassword;
import View.AdminView;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Amanda
 */
public class AdminLogin extends JFrame{
    
    public AdminLogin(){
    initComponents();    
    }
    
    private JLabel emaillbl;
    private JLabel passwordlbl;
    private JLabel msg;
    
    private JTextField emailtxt;
    private JPasswordField passwordtxt;
    
    private JButton loginbtn;
    private JButton create_accountbtn;
    
    public void initComponents(){
        setTitle("Login Form");;
        setLocationRelativeTo(null);
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        FlowLayout flow = new FlowLayout();
        
        setLayout(flow);
        
        emaillbl = new JLabel("Email:");
        emaillbl.setPreferredSize(new Dimension(150, 50));
        
        emailtxt = new JTextField();
        emailtxt.setPreferredSize(new Dimension(250, 40));
        
        passwordlbl = new JLabel("Password:");
        passwordlbl.setPreferredSize(new Dimension(150, 50));
        
        passwordtxt = new JPasswordField();
        passwordtxt.setPreferredSize(new Dimension(250, 40));
        
        msg = new JLabel();
        msg.setPreferredSize(new Dimension(400, 50));
//        msg.setForeground(Color.green);
        msg.setVisible(false);
        
        loginbtn  = new JButton("Login");
        loginbtn.setPreferredSize(new Dimension(400, 40));
        loginbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailtxt.getText();
                char[] pass = passwordtxt.getPassword();
                String password = toString().valueOf(pass);
                
                if(email.isEmpty() || password.isEmpty()){
                    
                   msg.setVisible(true);
                   msg.setText("All Input must be filled");
                   msg.setForeground(Color.red);
                }else{
                login(email, password);    
                }
                
            }
        });
        
       
        
        add(msg);
        add(emaillbl);
        add(emailtxt);
        add(passwordlbl);
        add(passwordtxt);
        add(loginbtn);
        
    }
    
    private void login(String email, String password){
        
        Admin model = new Admin();
        
        AdminView view = new AdminView();
        
        AdminLoginController controller  = new AdminLoginController(model, view);
        
        try{
            controller.setEmail(email);
        
        
        controller.setPassword(password);
        
        
        
        if(controller.adminLogin()){
            JOptionPane.showMessageDialog(null, "Logged in");
            AdminDashboard dash = new AdminDashboard();
            dash.setVisible(true);
            dash.setLocationRelativeTo(null);
            dispose();
            
        }else{
            msg.setVisible(true);
            msg.setText("Invalid Email or Password");
            msg.setForeground(Color.red);
            
        }
         
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something Went Wrong");
            e.printStackTrace();
        }
        
        
    }
    
}
