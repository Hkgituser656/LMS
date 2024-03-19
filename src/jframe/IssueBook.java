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
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
    public void getBookDetails(){
        int bookid  = Integer.parseInt(txt_bookid.getText());
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from Book_details where book_id = ?");
             pst.setInt(1,bookid);
             ResultSet rs = pst.executeQuery();
             
             if(rs.next()){
                 lbl_bookid.setText(rs.getString("book_id"));
                 lbl_bookname.setText(rs.getString("book_name"));
                 lbl_author.setText(rs.getString("author"));
                 lbl_quantity.setText(rs.getString("quantity"));
             }else{
            lbl_bookerror.setText("Invalid Book ID");
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
        public void getStudentDetails(){
        int studentid  = Integer.parseInt(txt_studentid.getText());
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from student_details where student_id = ?");
             pst.setInt(1,studentid);
             ResultSet rs = pst.executeQuery();
             
            if(rs.next()){
                 lbl_studentid.setText(rs.getString("student_id"));
                 lbl_studentname.setText(rs.getString("name"));
                 lbl_course.setText(rs.getString("course"));
                 lbl_branch.setText(rs.getString("branch"));
             }
             else{
                     lbl_studenterror.setText("Invalid Student ID");
                  }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
        public boolean issuebook(){
            boolean isIssued = false;
            int bookid = Integer.parseInt(txt_bookid.getText());
            int studentid = Integer.parseInt(txt_studentid.getText());
            String bookname  = lbl_bookname.getText();
            String studentname  = lbl_studentname.getText();
            Date uIssueDate  = date_issuedate.getDatoFecha();
             Date uDueDate  = date_duedate.getDatoFecha();
            
            long l1 = uIssueDate.getTime();
            long l2 = uDueDate.getTime();
            
             
            java.sql.Date sIssueDate = new java.sql.Date(l1); 
             java.sql.Date sDueDate = new java.sql.Date(l2); 
             
             try{
            Connection con = DBConnection.getConnection();
            String sql = "insert into issue_book_details(book_id, book_name, student_id, student_name, issue_date, due_date, status) values(?,?,?,?,?,?,?)";

           // String sql = "insert into issue_book_details(book_id,book_name,student_id,student_name,issue_date,due_date) values(?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,bookid);
            pst.setString(2,bookname);
            pst.setInt(3,studentid);
            pst.setString(4,studentname);
            pst.setDate(5,sIssueDate);
            pst.setDate(6,sDueDate);
            pst.setString(7,"pending");
            
            int rowCount = pst.executeUpdate();
            if(rowCount>0){
                isIssued = true;
            }
            else{
                 isIssued = false;
             }
           
        }catch(Exception e){
            e.printStackTrace();
        }
             return isIssued ;
        }
        
        
        public void updateBookCount(){
             int bookid = Integer.parseInt(txt_bookid.getText());
              try{
            Connection con = DBConnection.getConnection();
            String sql = "update book_details set quantity = quantity-1 where book_id = ?";
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1, bookid);
             int rowCount = pst.executeUpdate();
            if(rowCount>0){
                JOptionPane.showMessageDialog(this,"Bookss Updated");
                int initialCount = Integer.parseInt(lbl_quantity.getText());
                lbl_quantity.setText(Integer.toString(initialCount -1));
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
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_studentname = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        lbl_studentid = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_studenterror = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbl_bookname = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        lbl_bookid = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lbl_bookerror = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panel_mail1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lbl_branch1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbl_studentname1 = new javax.swing.JLabel();
        lbl_course1 = new javax.swing.JLabel();
        lbl_studentid1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
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
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt_bookid = new app.bolivia.swing.JCTextField();
        txt_studentid = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        date_issuedate = new rojeru_san.componentes.RSDateChooser();
        jLabel27 = new javax.swing.JLabel();
        date_duedate = new rojeru_san.componentes.RSDateChooser();
        jLabel28 = new javax.swing.JLabel();
        rSButtonMetro1 = new rojerusan.RSButtonMetro();

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

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Branch");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        lbl_branch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_branch.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 140, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Student Name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Course");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Student ID:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        lbl_studentname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_studentname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 140, 30));

        lbl_course.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 140, 30));

        lbl_studentid.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_studentid.setForeground(new java.awt.Color(255, 255, 255));
        lbl_studentid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_studentidFocusLost(evt);
            }
        });
        jPanel1.add(lbl_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 140, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel4.setText("Student Details");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        lbl_studenterror.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_studenterror.setForeground(new java.awt.Color(255, 255, 51));
        jPanel1.add(lbl_studenterror, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 110, 30));

        panel_mail.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 360, 570));

        jPanel3.setBackground(new java.awt.Color(0, 102, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel11.setText("Book Details");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        lbl_quantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 140, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Book Name");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Book Author");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Book ID:");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        lbl_bookname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_bookname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 140, 30));

        lbl_author.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 140, 30));

        lbl_bookid.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_bookid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 140, 30));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Quantity");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        lbl_bookerror.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_bookerror.setForeground(new java.awt.Color(255, 255, 102));
        jPanel3.add(lbl_bookerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 120, 30));

        panel_mail.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 570));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel2.setText("Issue Book");
        panel_mail.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 80, -1, -1));

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

        jPanel5.setBackground(new java.awt.Color(51, 51, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Branch");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        lbl_branch1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_branch1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_branch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 140, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Student Name");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Course");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Student ID:");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        lbl_studentname1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_studentname1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_studentname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 140, 30));

        lbl_course1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_course1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_course1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 140, 30));

        lbl_studentid1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_studentid1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_studentid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 140, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel19.setText("Student Details");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        panel_mail1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 360, 510));

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

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel25.setText("Issue Book");
        panel_mail1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 80, -1, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setText("Enter the Book ID ");
        panel_mail1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 170, -1, -1));

        txt_bookid.setPlaceholder("Book ID");
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

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Issue Date");
        panel_mail1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 330, -1, -1));

        date_issuedate.setPlaceholder("Isuue date");
        panel_mail1.add(date_issuedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 360, 220, 30));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel27.setText("Enter the Student ID ");
        panel_mail1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 250, -1, -1));

        date_duedate.setPlaceholder("Due date");
        panel_mail1.add(date_duedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 440, 220, 30));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel28.setText("Due Date");
        panel_mail1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 410, -1, -1));

        rSButtonMetro1.setText("Issue Book");
        rSButtonMetro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro1ActionPerformed(evt);
            }
        });
        panel_mail1.add(rSButtonMetro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 490, 160, 30));

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
       if(!txt_studentid.getText().equals("")){
        getStudentDetails();
        }
    }//GEN-LAST:event_txt_studentidFocusLost

    private void txt_studentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentidActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void txt_bookidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookidFocusLost
        if(!txt_bookid.getText().equals("")){
        getBookDetails();
        }
    }//GEN-LAST:event_txt_bookidFocusLost

    private void txt_bookidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookidActionPerformed

    private void rSButtonMetro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro1ActionPerformed
      if( issuebook() == true){
          JOptionPane.showMessageDialog(this,"Issued bOok");
          updateBookCount();
      }
      else{
           JOptionPane.showMessageDialog(this,"Falied");
      }
    }//GEN-LAST:event_rSButtonMetro1ActionPerformed

    private void lbl_studentidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_studentidFocusLost
      
    }//GEN-LAST:event_lbl_studentidFocusLost

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_duedate;
    private rojeru_san.componentes.RSDateChooser date_issuedate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookauthor1;
    private javax.swing.JLabel lbl_bookerror;
    private javax.swing.JLabel lbl_bookid;
    private javax.swing.JLabel lbl_bookid1;
    private javax.swing.JLabel lbl_bookname;
    private javax.swing.JLabel lbl_bookname1;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_branch1;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_course1;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_quantity1;
    private javax.swing.JLabel lbl_studenterror;
    private javax.swing.JLabel lbl_studentid;
    private javax.swing.JLabel lbl_studentid1;
    private javax.swing.JLabel lbl_studentname;
    private javax.swing.JLabel lbl_studentname1;
    private javax.swing.JPanel panel_mail;
    private javax.swing.JPanel panel_mail1;
    private rojerusan.RSButtonMetro rSButtonMetro1;
    private app.bolivia.swing.JCTextField txt_bookid;
    private app.bolivia.swing.JCTextField txt_studentid;
    // End of variables declaration//GEN-END:variables
}
