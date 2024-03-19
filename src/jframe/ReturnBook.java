/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import static jframe.DBConnection.con;
import java.sql.Connection;
// Other existing import statements...
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author 91955
 */
public class ReturnBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public ReturnBook() {
        initComponents();
    }
    public void getissuebookDetails(){
       
        int bookId = Integer.parseInt(txt_bookid.getText());
        int studentId = Integer.parseInt(txt_studentid.getText());
        try{
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where book_id = ? and student_id =? and status = ?";
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1, bookId);
             pst.setInt(2,studentId);
             pst.setString(3, "pending");
        
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
           
            lbl_issueid.setText(rs.getString("id"));
            lbl_bookname.setText(rs.getString("book_name"));
            lbl_studentname.setText(rs.getString("student_name"));
            lbl_issueDate.setText(rs.getString("issue_date"));
            lbl_dueDate.setText(rs.getString("due_date"));
            lbl_bookError.setText("");
        }
        else{
            lbl_bookError.setText("Not Found");
             lbl_issueid.setText("");
            lbl_bookname.setText("");
            lbl_studentname.setText("");
            lbl_issueDate.setText("");
            lbl_dueDate.setText("");
        }
        }catch(Exception e){
            e.printStackTrace();
        }
       
    }
    
    public boolean returnBook(){
        boolean isReturned = false; 
         int bookId = Integer.parseInt(txt_bookid.getText());
        int studentId = Integer.parseInt(txt_studentid.getText());
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = "update issue_book_details set status = ? where student_id =? and  book_id = ?  and status = ? ";
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1, "returned");
             pst.setInt(2, studentId);
             pst.setInt(3, bookId);
             pst.setString(4, "pending");
             
            int rowCount = pst.executeUpdate();
            if (rowCount > 0){
              isReturned = true;
            }             
            else{
                 isReturned = false;
           }
             
             }catch(Exception e){
            e.printStackTrace();
        }
    return isReturned;
    }
       
        public void updateBookCount(){
             int bookid = Integer.parseInt(txt_bookid.getText());
              try{
            Connection con = DBConnection.getConnection();
            String sql = "update book_details set quantity = quantity+1 where book_id = ?";
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1, bookid);
             int rowCount = pst.executeUpdate();
            if(rowCount>0){
                JOptionPane.showMessageDialog(this,"Bookss Updated");
                
            }
            else{
                JOptionPane.showMessageDialog(this,"not updated");
             }
              }catch(Exception e){
            e.printStackTrace();
        }
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_mail = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbl_bookname = new javax.swing.JLabel();
        lbl_studentname = new javax.swing.JLabel();
        lbl_issueid = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lbl_bookerror = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lbl_issueDate = new javax.swing.JLabel();
        lbl_dueDate = new javax.swing.JLabel();
        panel_mail1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_quantity1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbl_bookname1 = new javax.swing.JLabel();
        lbl_bookauthor1 = new javax.swing.JLabel();
        lbl_bookid1 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt_bookid = new app.bolivia.swing.JCTextField();
        txt_studentid = new app.bolivia.swing.JCTextField();
        jLabel27 = new javax.swing.JLabel();
        rSButtonMetro1 = new rojerusan.RSButtonMetro();
        jLabel2 = new javax.swing.JLabel();
        rSButtonMetro2 = new rojerusan.RSButtonMetro();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_mail.setBackground(new java.awt.Color(255, 255, 255));
        panel_mail.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BACK");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        panel_mail.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 40));

        jPanel3.setBackground(new java.awt.Color(0, 102, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel11.setText("Book Details");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        lbl_bookError.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 140, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Book Name");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Student Name");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Issue ID:");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        lbl_bookname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_bookname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 140, 30));

        lbl_studentname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_studentname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 140, 30));

        lbl_issueid.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_issueid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_issueid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 140, 30));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Due Date");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        lbl_bookerror.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_bookerror.setForeground(new java.awt.Color(255, 255, 102));
        jPanel3.add(lbl_bookerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 120, 30));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Issue Date");
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        lbl_issueDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_issueDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 140, 30));

        lbl_dueDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_dueDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 140, 30));

        panel_mail.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 570));

        panel_mail1.setBackground(new java.awt.Color(255, 255, 255));
        panel_mail1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("BACK");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel9)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        panel_mail1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 40));

        jPanel6.setBackground(new java.awt.Color(255, 102, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel20.setText("Book Details");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Quantity");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        lbl_quantity1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_quantity1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(lbl_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 140, 30));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Book Name");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Book Author");
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Book ID:");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        lbl_bookname1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_bookname1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(lbl_bookname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 140, 30));

        lbl_bookauthor1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_bookauthor1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(lbl_bookauthor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 140, 30));

        lbl_bookid1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_bookid1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(lbl_bookid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 140, 30));

        panel_mail1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 510));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setText("Enter the Book ID ");
        panel_mail1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 170, -1, -1));

        txt_bookid.setPlaceholder("book i d");
        txt_bookid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookidFocusLost(evt);
            }
        });
        txt_bookid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookidActionPerformed(evt);
            }
        });
        panel_mail1.add(txt_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 200, -1, -1));

        txt_studentid.setPlaceholder("Student ID");
        txt_studentid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentidFocusLost(evt);
            }
        });
        txt_studentid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentidActionPerformed(evt);
            }
        });
        panel_mail1.add(txt_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 280, -1, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel27.setText("Enter the Student ID ");
        panel_mail1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 250, -1, -1));

        rSButtonMetro1.setText("Return Book");
        rSButtonMetro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro1ActionPerformed(evt);
            }
        });
        panel_mail1.add(rSButtonMetro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 430, 160, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel2.setText("Return Book");
        panel_mail1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 80, -1, -1));

        rSButtonMetro2.setText("Find");
        rSButtonMetro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro2ActionPerformed(evt);
            }
        });
        panel_mail1.add(rSButtonMetro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 360, 160, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bit.PNG"))); // NOI18N
        panel_mail1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 620, 560));

        panel_mail.add(panel_mail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 570));

        getContentPane().add(panel_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 590));

        setSize(new java.awt.Dimension(1087, 574));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_studentidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentidFocusLost
      
    }//GEN-LAST:event_txt_studentidFocusLost

    private void txt_studentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentidActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void txt_bookidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookidFocusLost
       
    }//GEN-LAST:event_txt_bookidFocusLost

    private void txt_bookidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookidActionPerformed

    private void rSButtonMetro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro1ActionPerformed
      if(returnBook() == true){
          JOptionPane.showMessageDialog(this,"Boook returned successfully");
          updateBookCount();
      }
      else{
        JOptionPane.showMessageDialog(this,"Boook returned Failed");
    }
    }//GEN-LAST:event_rSButtonMetro1ActionPerformed

    private void rSButtonMetro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro2ActionPerformed
      getissuebookDetails();
    }//GEN-LAST:event_rSButtonMetro2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookauthor1;
    private javax.swing.JLabel lbl_bookerror;
    private javax.swing.JLabel lbl_bookid1;
    private javax.swing.JLabel lbl_bookname;
    private javax.swing.JLabel lbl_bookname1;
    private javax.swing.JLabel lbl_dueDate;
    private javax.swing.JLabel lbl_issueDate;
    private javax.swing.JLabel lbl_issueid;
    private javax.swing.JLabel lbl_quantity1;
    private javax.swing.JLabel lbl_studentname;
    private javax.swing.JPanel panel_mail;
    private javax.swing.JPanel panel_mail1;
    private rojerusan.RSButtonMetro rSButtonMetro1;
    private rojerusan.RSButtonMetro rSButtonMetro2;
    private app.bolivia.swing.JCTextField txt_bookid;
    private app.bolivia.swing.JCTextField txt_studentid;
    // End of variables declaration//GEN-END:variables
}
