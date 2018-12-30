/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import Controller.RegisterController;
import Model.User;
import View.RegisterView;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.swing.*;

/**
 *
 * @author Amanda
 */
public class Register extends JFrame {
    
    public Register(){
        initComponents();
    }
    
    private JLabel msg;
    private JLabel namelbl;
    private JLabel addresslbl;
    private JLabel phonelbl;
    private JLabel genderlbl;
    private JLabel emaillbl;
    private JLabel passwordlbl;
    private JLabel confirm_passwordlbl;
    
    private JTextField nametxt;
    private JTextField addresstxt;
    private JTextField phonetxt;
    private JComboBox gendertxt;
    private JTextField emailtxt;
    private JPasswordField passwordtxt;
    private JPasswordField confirm_passwordtxt;
    
    private JButton registerbtn;
    
    private String genderOptions[] = {"Male", "Female"};
    
   
    private void initComponents(){
        setSize(500, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        FlowLayout flow = new FlowLayout();
        
        setLayout(flow);
        
        msg = new JLabel();
        msg.setPreferredSize(new Dimension(400, 50));
        msg.setVisible(false);
        
        Dimension labelSize = new Dimension(150, 50);
        Dimension txtSize = new Dimension(250, 40);
        Dimension btnSize = new Dimension(400, 40);
        
        namelbl = new JLabel("Name:");
        namelbl.setPreferredSize(labelSize);
        
        nametxt = new JTextField();
        nametxt.setPreferredSize(txtSize);
        
        addresslbl = new JLabel("Address:");
        addresslbl.setPreferredSize(labelSize);
        
        addresstxt = new JTextField();
        addresstxt.setPreferredSize(txtSize);
        
        phonelbl = new JLabel("Phone:");
        phonelbl.setPreferredSize(labelSize);
        
        phonetxt = new JTextField();
        phonetxt.setPreferredSize(txtSize);
        
        genderlbl = new JLabel("Gender:");
        genderlbl.setPreferredSize(labelSize);
        
        gendertxt = new JComboBox();
        gendertxt.setPreferredSize(txtSize);
        for(int i = 0; i < genderOptions.length; i++){
            gendertxt.addItem(genderOptions[i]);
        }
        
        
        emaillbl = new JLabel("Email:");
        emaillbl.setPreferredSize(labelSize);
        
        emailtxt = new JTextField();
        emailtxt.setPreferredSize(txtSize);
        
        passwordlbl = new JLabel("Password:");
        passwordlbl.setPreferredSize(labelSize);
        
        passwordtxt = new JPasswordField();
        passwordtxt.setPreferredSize(txtSize);
        
        confirm_passwordlbl = new JLabel("Confirm Password:");
        confirm_passwordlbl.setPreferredSize(labelSize);
        
        confirm_passwordtxt = new JPasswordField();
        confirm_passwordtxt.setPreferredSize(txtSize);
        
        registerbtn = new JButton("Register");
        registerbtn.setPreferredSize(btnSize);
        registerbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String name = nametxt.getText();
                String address = addresstxt.getText();
                String phone = phonetxt.getText();
                
                String gender  = gendertxt.getSelectedItem().toString();
                String email = emailtxt.getText();
                
                char[] pass = passwordtxt.getPassword();
                String password = toString().valueOf(pass);
                
                char[] confirm_pass = confirm_passwordtxt.getPassword();
                String confirm_password = toString().valueOf(confirm_pass);
                
                if(name.isEmpty() || address.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty() ||
                        confirm_password.isEmpty()){
                    msg.setVisible(true);
                    msg.setText("All Input Must Be Filled");
                    msg.setForeground(Color.red);
                }else{
               
                    
                    long phonenumber  = Long.parseLong(phonetxt.getText());
                        
                    if(password.equals(confirm_password)){
                        register(name, address, phonenumber, gender, email, password);
                    }else{
                        
                         msg.setVisible(true);
                    msg.setText("Password Mismatch");
                    msg.setForeground(Color.red);
                    }
                }
                 
                    
            }
        });
        
        
        
        add(msg);
        add(namelbl);
        add(nametxt);
        add(addresslbl);
        add(addresstxt);
        add(phonelbl);
        add(phonetxt);
        add(genderlbl);
        add(gendertxt);
        add(emaillbl);
        add(emailtxt);
        add(passwordlbl);
        add(passwordtxt);
        add(confirm_passwordlbl);
        add(confirm_passwordtxt);
        add(registerbtn);
        
        
        
    }
    
    private void register(String name, String address, long phone, String gender, String email, String password){
        
        User model = new User();
        RegisterView view = new RegisterView();
        
        RegisterController controller = new RegisterController(model, view);
        
        controller.setName(name);
        controller.setAddress(address);
        controller.setPhone(phone);
        controller.setGender(gender);
        controller.setEmail(email);
        
        String salt = PasswordUtils.getSalt(30); 
        
        
        String securePassword = PasswordUtils.generateSecurePassword(password, salt);
        controller.setPassword(securePassword);
        controller.setSalt(salt);
        
        try{
            if(controller.verifyEmail()){
               msg.setVisible(true);
               msg.setText("Email Already Exists");
               msg.setForeground(Color.red);
               
            }else{
            controller.register();
            controller.storeSalt();
            JOptionPane.showMessageDialog(null, "Successfully Registered");
            dispose();
            Login login = new Login();
            login.setVisible(true);
            login.setLocationRelativeTo(null);
            
            }
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something Went Wrong");
        }
        
        
        
    }
    
       
}
