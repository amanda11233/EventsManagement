/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Amanda
 */
public class Main extends JFrame{
    
    public Main(){
        initComponents();
    }
    
    private static final String adminpass = "ADM11233";
    private JPanel panel;
    private JPanel panel2;
    
    private JLabel welcomelbl;
    private JButton userbtn;
    private JButton adminbtn;
    
    private JTextField passwordtxt;
    private JButton adminauthbtn;
    
    public void initComponents(){
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        Dimension preferredsize = new Dimension(150, 40);
        
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
         panel2 = new JPanel();
        
        
        Font font = new Font("Arial", Font.BOLD, 40);
        welcomelbl = new JLabel("Welcome");
        welcomelbl.setFont(font);
        welcomelbl.setHorizontalAlignment(SwingConstants.CENTER);
        welcomelbl.setPreferredSize(new Dimension(100, 200));
        
        userbtn = new JButton("User Login");
        userbtn.setPreferredSize(preferredsize);
        
        userbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        
                Login login = new Login();
                login.setVisible(true);
                login.setLocationRelativeTo(null);
                dispose();
            
            }
        });
        
        
        passwordtxt = new JTextField();
        passwordtxt.setPreferredSize(new Dimension(350, 50));
        passwordtxt.setHorizontalAlignment(JTextField.CENTER);
        adminauthbtn = new JButton("Verify");
        adminauthbtn.setPreferredSize(preferredsize);
        
        adminbtn = new JButton("Admin Login");
        adminbtn.setPreferredSize(preferredsize);
        
        
            JFrame auth = new JFrame();
            auth.setSize(400, 200);
            auth.setLayout(new FlowLayout());
            
        adminbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        
            
            auth.setVisible(true);
            auth.setLocationRelativeTo(null);
            
            }
        });
        
        
        
        adminauthbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String password = passwordtxt.getText();
                
                adminVerify(password);
                auth.dispose();
            
            }
        });
        
        
        
        add(panel, BorderLayout.CENTER);
        add(welcomelbl,  BorderLayout.NORTH);
        panel.add(userbtn);
        panel.add(adminbtn);
        auth.add(passwordtxt);
            auth.add(adminauthbtn);
    }
    
    private void adminVerify(String password){
     
        if(password.equals(adminpass)){
            AdminLogin adminlogin = new AdminLogin();
            adminlogin.setVisible(true);
            adminlogin.setLocationRelativeTo(null);
            
            dispose();
            
        }else{
            JOptionPane.showMessageDialog(null, "Invalid Password");
        }
        
    }
    
    public static void main(String args[]){
        AdminDashboard main = new AdminDashboard();
        main.setVisible(true);
        main.setLocationRelativeTo(null);
    }
}
