/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import static jframe.DBConnection.con;
import java.sql.Statement; // Import PreparedStatement
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;


/**
 *
 * @author 91955
 */
public class ManageStudents extends javax.swing.JFrame {
    

    public ManageStudents() {
        initComponents();
       setStudentDetailsToTable();
    }
    //set book details
    String studentname,course,branch;
    int studentid;
        DefaultTableModel model;
    public void setStudentDetailsToTable(){
    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "1234");
            Statement st = con.createStatement();
           var rs =  st.executeQuery("select * from Student_details");
           
           while(rs.next()){
               String studentid = rs.getString("student_id");
               String studentname = rs.getString("name");
               String course = rs.getString("course");
               String branch = rs.getString("branch");
               
               Object[] obj = {studentid,studentname,course,branch};
               model = (DefaultTableModel) tbl_studentdetails.getModel();
               model.addRow(obj);
           }
        }catch(Exception e){
            e.printStackTrace();
        }
       
      
        
}
      public boolean addStudent(){
          boolean isAdded = false;
          studentid = Integer.parseInt(txt_studentid.getText());
          studentname =txt_studentname.getText(); 
          course = combo_coursename.getSelectedItem().toString();
          branch = combo_branch.getSelectedItem().toString();
          
          try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "1234");
            String sql = "insert into student_details values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,studentid);
            pst.setString(2,studentname);
            pst.setString(3,course);
            pst.setString(4,branch);
            
            int rowCount = pst.executeUpdate();
            if(rowCount>0){
                isAdded = true;
            }
            else{
                isAdded = false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    return isAdded;
}
      
      
      //clear table 
      public void clearTable(){
      DefaultTableModel model = (DefaultTableModel) tbl_studentdetails.getModel();
      model.setRowCount(0);
      }
   //update student details
      public boolean updateStudent(){
          boolean isUpdated = false;
          studentid = Integer.parseInt(txt_studentid.getText());
          studentname =txt_studentname.getText(); 
          course = combo_coursename.getSelectedItem().toString();
          branch = combo_branch.getSelectedItem().toString();
          try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "1234");
            String sql = "update student_details set name = ?,course =?,branch=? where student_id =?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,studentname);
            pst.setString(2,course);
            pst.setString(3,branch);
            pst.setInt(4,studentid);
            
            int rowCount = pst.executeUpdate();
            if(rowCount>0){
                isUpdated = true;
            }
            else{
                isUpdated = false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
          return isUpdated;
      }
      
      public boolean deleteStudent(){
          boolean isdeleted = false;
           studentid = Integer.parseInt(txt_studentid.getText());
          try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "1234");
            String sql = "delete from student_details where student_id =?";
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1,studentid);
             int rowCount = pst.executeUpdate();
            if(rowCount>0){
                isdeleted = true;
            }
            else{
                isdeleted = false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
          return isdeleted;
      }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_studentid = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_studentname = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rSButtonMetro1 = new rojerusan.RSButtonMetro();
        rSButtonMetro2 = new rojerusan.RSButtonMetro();
        rSButtonMetro3 = new rojerusan.RSButtonMetro();
        combo_branch = new javax.swing.JComboBox<>();
        combo_coursename = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_studentdetails = new rojeru_san.complementos.RSTableMetro();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 102));

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 40));

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
        jPanel1.add(txt_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 50, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Enter the Student Id");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 50, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Enter the Name");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));

        txt_studentname.setPlaceholder("Enter Name");
        txt_studentname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentnameFocusLost(evt);
            }
        });
        txt_studentname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentnameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Enter Course");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 50, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Branch");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 50, 40));

        rSButtonMetro1.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonMetro1.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonMetro1.setText("Delete");
        rSButtonMetro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonMetro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, -1, 30));

        rSButtonMetro2.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonMetro2.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonMetro2.setText("ADD");
        rSButtonMetro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonMetro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, 30));

        rSButtonMetro3.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonMetro3.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonMetro3.setText("Update");
        rSButtonMetro3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonMetro3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, -1, 30));

        combo_branch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        combo_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CSE", "ECE ", "IT", "Mech" }));
        combo_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_branchActionPerformed(evt);
            }
        });
        jPanel1.add(combo_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 200, 30));

        combo_coursename.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        combo_coursename.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Btech", "BSC ", "Mtech" }));
        combo_coursename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_coursenameActionPerformed(evt);
            }
        });
        jPanel1.add(combo_coursename, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 200, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 500));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_studentdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Couse", "Branch"
            }
        ));
        tbl_studentdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentdetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_studentdetails);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        jLabel2.setText("Manage Students");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(223, 223, 223))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 610, 500));

        setSize(new java.awt.Dimension(1086, 522));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       HomePage home = new HomePage();
       home.setVisible(true);
       dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_studentidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentidFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentidFocusLost

    private void txt_studentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentidActionPerformed

    private void txt_studentnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentnameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentnameFocusLost

    private void txt_studentnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentnameActionPerformed

    private void rSButtonMetro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro1ActionPerformed
        // TODO add your handling code here:
         if(deleteStudent() == true){
              JOptionPane.showMessageDialog(this,"student deleted");
              clearTable();
              setStudentDetailsToTable();
        }
        else{
        JOptionPane.showMessageDialog(this,"failed");
    }//GEN-LAST:event_rSButtonMetro1ActionPerformed
    }
    private void rSButtonMetro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro2ActionPerformed
        if(addStudent() == true){
              JOptionPane.showMessageDialog(this,"Student addddedd");
              clearTable();
              setStudentDetailsToTable();
        }
        else{
        JOptionPane.showMessageDialog(this,"failed");
    }
    }//GEN-LAST:event_rSButtonMetro2ActionPerformed

    private void rSButtonMetro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro3ActionPerformed
        // TODO add your handling code here:
         if(updateStudent() == true){
              JOptionPane.showMessageDialog(this,"student updated");
              clearTable();
              setStudentDetailsToTable();
        }
        else{
        JOptionPane.showMessageDialog(this,"failed");
    }//GEN-LAST:event_rSButtonMetro3ActionPerformed
    }
    private void tbl_studentdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentdetailsMouseClicked
        int rowNo = tbl_studentdetails.getSelectedRow();
        TableModel model = tbl_studentdetails.getModel();
        
        txt_studentid.setText(model.getValueAt(rowNo, 0).toString());
        txt_studentname.setText(model.getValueAt(rowNo, 1).toString());
        combo_coursename.setSelectedItem(model.getValueAt(rowNo, 2).toString());
         combo_branch.setSelectedItem(model.getValueAt(rowNo, 2).toString());
    }//GEN-LAST:event_tbl_studentdetailsMouseClicked

    private void combo_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_branchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_branchActionPerformed

    private void combo_coursenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_coursenameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_coursenameActionPerformed

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
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_branch;
    private javax.swing.JComboBox<String> combo_coursename;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSButtonMetro rSButtonMetro1;
    private rojerusan.RSButtonMetro rSButtonMetro2;
    private rojerusan.RSButtonMetro rSButtonMetro3;
    private rojeru_san.complementos.RSTableMetro tbl_studentdetails;
    private app.bolivia.swing.JCTextField txt_studentid;
    private app.bolivia.swing.JCTextField txt_studentname;
    // End of variables declaration//GEN-END:variables
}
