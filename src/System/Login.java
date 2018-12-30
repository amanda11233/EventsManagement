/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import Controller.LoginController;
import Model.User;
import static System.PasswordUtils.generateSecurePassword;
import View.LoginView;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Amanda
 */
public class Login extends JFrame{
    
    public Login(){
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
        
        create_accountbtn = new JButton("Create a new Account");
        create_accountbtn.setPreferredSize(new Dimension(400, 40));
        create_accountbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Register register = new Register();
                register.setVisible(true);
//                register.setLocationRelativeTo(null);
            }
        });
        
        add(msg);
        add(emaillbl);
        add(emailtxt);
        add(passwordlbl);
        add(passwordtxt);
        add(loginbtn);
        add(create_accountbtn);
    }
    
    private void login(String email, String password){
        
        User model = new User();
        
        LoginView view = new LoginView();
        
        LoginController controller  = new LoginController(view, model);
        try{
            controller.setEmail(email);
           String salt = controller.getSalt();
       
        String securePassword = PasswordUtils.generateSecurePassword(password, salt);
        
        
        controller.setPassword(securePassword);
        
        
        
        if(controller.updateview()){
            JOptionPane.showMessageDialog(null, "Logged in");
            
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
