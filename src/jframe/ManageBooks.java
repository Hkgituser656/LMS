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
public class ManageBooks extends javax.swing.JFrame {
    
    /**
     * Creates new form ManageBooks
     */
    public ManageBooks() {
        initComponents();
       setBookDetailsToTable();
    }
    //set book details
    String bookname,author;
        int bookid,quantity;
        DefaultTableModel model;
    public void setBookDetailsToTable(){
    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "1234");
            Statement st = con.createStatement();
           var rs =  st.executeQuery("select * from book_details");
           
           while(rs.next()){
               String bookID = rs.getString("book_id");
               String bookName = rs.getString("book_name");
               String author = rs.getString("author");
               String quantity = rs.getString("quantity");
               
               Object[] obj = {bookID,bookName,author,quantity};
               model = (DefaultTableModel) tbl_bookDetails.getModel();
               model.addRow(obj);
           }
        }catch(Exception e){
            e.printStackTrace();
        }
       
      
        
}
      public boolean addBook(){
          boolean isAdded = false;
          bookid = Integer.parseInt(txt_bookid.getText());
          bookname =txt_bookname.getText(); 
          author =txt_authorname.getText(); 
          quantity = Integer.parseInt(txt_quantity.getText()); 
          
          try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "1234");
            String sql = "insert into book_details values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,bookid);
            pst.setString(2,bookname);
            pst.setString(3,author);
            pst.setInt(4,quantity);
            
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
      DefaultTableModel model = (DefaultTableModel) tbl_bookDetails.getModel();
      model.setRowCount(0);
      }
   //update book
      public boolean updateBook(){
           boolean isUpdated = false;
          bookid = Integer.parseInt(txt_bookid.getText());
          bookname =txt_bookname.getText(); 
          author =txt_authorname.getText(); 
          quantity = Integer.parseInt(txt_quantity.getText()); 
          
          try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "1234");
            String sql = "update book_details set book_name = ?,author =?,quantity=? where book_id =?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,bookname);
            pst.setString(2,author);
            pst.setInt(3,quantity);
            pst.setInt(4,bookid);
            
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
      
      public boolean deleteBook(){
          boolean isdeleted = false;
           bookid = Integer.parseInt(txt_bookid.getText());
          try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "1234");
            String sql = "delete from book_details where book_id =?";
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1,bookid);
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
        txt_bookid = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_bookname = new app.bolivia.swing.JCTextField();
        txt_authorname = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_quantity = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        rSButtonMetro1 = new rojerusan.RSButtonMetro();
        rSButtonMetro2 = new rojerusan.RSButtonMetro();
        rSButtonMetro3 = new rojerusan.RSButtonMetro();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojeru_san.complementos.RSTableMetro();
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
        jPanel1.add(txt_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 50, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Enter the book Id");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 50, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Enterthe book Name");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));

        txt_bookname.setPlaceholder("Enter Book Name");
        txt_bookname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_booknameFocusLost(evt);
            }
        });
        txt_bookname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_booknameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        txt_authorname.setPlaceholder("Author Name");
        txt_authorname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_authornameFocusLost(evt);
            }
        });
        txt_authorname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_authornameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_authorname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Author name ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 50, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Quantity");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, -1, -1));

        txt_quantity.setPlaceholder("Quantity");
        txt_quantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_quantityFocusLost(evt);
            }
        });
        txt_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quantityActionPerformed(evt);
            }
        });
        jPanel1.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, -1, -1));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 500));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Name", "Author", "Quantity"
            }
        ));
        tbl_bookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_bookDetails);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jLabel2.setText("Manage Books");

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

    private void txt_bookidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookidFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookidFocusLost

    private void txt_bookidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookidActionPerformed

    private void txt_booknameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_booknameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_booknameFocusLost

    private void txt_booknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_booknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_booknameActionPerformed

    private void txt_authornameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_authornameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_authornameFocusLost

    private void txt_authornameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_authornameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_authornameActionPerformed

    private void txt_quantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantityFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantityFocusLost

    private void txt_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantityActionPerformed

    private void rSButtonMetro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro1ActionPerformed
        // TODO add your handling code here:
         if(deleteBook() == true){
              JOptionPane.showMessageDialog(this,"book deleted");
              clearTable();
              setBookDetailsToTable();
        }
        else{
        JOptionPane.showMessageDialog(this,"failsed");
    }//GEN-LAST:event_rSButtonMetro1ActionPerformed
    }
    private void rSButtonMetro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro2ActionPerformed
        if(addBook() == true){
              JOptionPane.showMessageDialog(this,"book addddedd");
              clearTable();
              setBookDetailsToTable();
        }
        else{
        JOptionPane.showMessageDialog(this,"failsed");
    }
    }//GEN-LAST:event_rSButtonMetro2ActionPerformed

    private void rSButtonMetro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro3ActionPerformed
        // TODO add your handling code here:
         if(updateBook() == true){
              JOptionPane.showMessageDialog(this,"book updated");
              clearTable();
              setBookDetailsToTable();
        }
        else{
        JOptionPane.showMessageDialog(this,"failed");
    }//GEN-LAST:event_rSButtonMetro3ActionPerformed
    }
    private void tbl_bookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookDetailsMouseClicked
        int rowNo = tbl_bookDetails.getSelectedRow();
        TableModel model = tbl_bookDetails.getModel();
        
        txt_bookid.setText(model.getValueAt(rowNo, 0).toString());
        txt_bookname.setText(model.getValueAt(rowNo, 1).toString());
        txt_authorname.setText(model.getValueAt(rowNo, 2).toString());
       txt_quantity.setText(model.getValueAt(rowNo, 3).toString());
    }//GEN-LAST:event_tbl_bookDetailsMouseClicked

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
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private rojeru_san.complementos.RSTableMetro tbl_bookDetails;
    private app.bolivia.swing.JCTextField txt_authorname;
    private app.bolivia.swing.JCTextField txt_bookid;
    private app.bolivia.swing.JCTextField txt_bookname;
    private app.bolivia.swing.JCTextField txt_quantity;
    // End of variables declaration//GEN-END:variables
}
