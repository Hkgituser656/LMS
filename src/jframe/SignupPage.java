/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; // Import PreparedStatement
import java.sql.SQLException; // Import SQLException
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import static jframe.DBConnection.con;

public class SignupPage extends javax.swing.JFrame {

  
    public SignupPage() {
        initComponents();
    }
    //user table method
    public void insertSignupDetails(){
        String name = txt_username.getText();
        String pwd = txt_password.getText();
        String email = jCTextField3.getText();
        String contact = jCTextField4.getText();
        
        try{
           Connection con = DBConnection.getConnection();
           String sql = "insert into admin(name,password,email,contact) values(?,?,?,?)";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setString(1, name);
           pst.setString(2, pwd);
           pst.setString(3, email);
           pst.setString(4, contact);
           
           int updatedRowCount = pst.executeUpdate();
           
           if(updatedRowCount>0){
                   JOptionPane.showMessageDialog(this,"Recorded Success");
                   LoginPage page = new LoginPage();
                   page.setVisible(true);
                   dispose();
                   
           }else{
            JOptionPane.showMessageDialog(this,"Failed");
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    //validation
    public boolean validateSignup(){
         String name = txt_username.getText();
        String pwd = txt_password.getText();
        String email = jCTextField3.getText();
        String contact = jCTextField4.getText();
        
        if(name.equals("")){
                        JOptionPane.showMessageDialog(this,"Enter username");
                        return false;
        }
        if(pwd.equals("")){
                        JOptionPane.showMessageDialog(this,"Enter password");
                        return false;
        }
        if(email.equals("")){
                        JOptionPane.showMessageDialog(this,"Enter email");
                        return false;
        }
        if(contact.equals("")){
                        JOptionPane.showMessageDialog(this,"Enter Contact");
                        return false;
        }
        return true;
    }
   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_username = new app.bolivia.swing.JCTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_password = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jCTextField3 = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jCTextField4 = new app.bolivia.swing.JCTextField();
        jLabel13 = new javax.swing.JLabel();
        rSButtonIconD1 = new rojerusan.RSButtonIconD();
        rSButtonIconD2 = new rojerusan.RSButtonIconD();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bit.PNG"))); // NOI18N
        jLabel3.setToolTipText("");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 57, 800, 570));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("BIT DIGITAL LIBRARY MANAGEMENT SYSTEM");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 700));

        jPanel2.setBackground(new java.awt.Color(0, 102, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 50, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SignUpPage");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Create New Account");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, -1));

        txt_username.setPlaceholder("Enter username");
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Username");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 50, 40));

        txt_password.setPlaceholder("Enter username");
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Password");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 50, -1));

        jCTextField3.setPlaceholder("Enter username");
        jCTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextField3ActionPerformed(evt);
            }
        });
        jPanel2.add(jCTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Email");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 50, 40));

        jCTextField4.setPlaceholder("Enter username");
        jCTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextField4ActionPerformed(evt);
            }
        });
        jPanel2.add(jCTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Contact");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, -1, -1));

        rSButtonIconD1.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonIconD1.setText("Login");
        rSButtonIconD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconD1ActionPerformed(evt);
            }
        });
        jPanel2.add(rSButtonIconD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 530, 190, 20));

        rSButtonIconD2.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonIconD2.setText("Signup");
        rSButtonIconD2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconD2ActionPerformed(evt);
            }
        });
        jPanel2.add(rSButtonIconD2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, 190, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 410, 600));

        setSize(new java.awt.Dimension(1224, 607));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void jCTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextField3ActionPerformed

    private void jCTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextField4ActionPerformed

    private void rSButtonIconD2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconD2ActionPerformed
     if(validateSignup() == true){
        insertSignupDetails();
}
    }//GEN-LAST:event_rSButtonIconD2ActionPerformed

    private void rSButtonIconD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconD1ActionPerformed
        new LoginPage().setVisible(true);
    }//GEN-LAST:event_rSButtonIconD1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.bolivia.swing.JCTextField jCTextField3;
    private app.bolivia.swing.JCTextField jCTextField4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private rojerusan.RSButtonIconD rSButtonIconD1;
    private rojerusan.RSButtonIconD rSButtonIconD2;
    private app.bolivia.swing.JCTextField txt_password;
    private app.bolivia.swing.JCTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
