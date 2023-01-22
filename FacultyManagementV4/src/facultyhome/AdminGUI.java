/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package facultyhome;
import javax.swing.*;
import java.awt.CardLayout;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;



/**
 *
 * @author saish
 */
public class AdminGUI extends JFrame {

    /**
     * Creates new form AdminGUI
     */
    CardLayout cardLayout;
    
    public AdminGUI() {
        initComponents();
        cardLayout = (CardLayout)(CardPanel.getLayout()); 
        
        SetProfile();
        SetFacultyTable();
        
        
        
    }
    
    void setWorkshopCount(String user)
    {
        
        
        
        try
        {   
            //Creating Connection Object
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","root");
            //Prepared Statement
            PreparedStatement st = connection.prepareStatement("Select count(id) from faculty_workshop WHERE username = ?");
            st.setString(1,user);
            
           ResultSet res = st.executeQuery();
           if(res.next())
           {
                WorkshopNOS.setText(res.getString(1));
                
           }
          

        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
        }
    }
    
    void setPublicationCount(String user)
    {
        
        try
        {   
            //Creating Connection Object
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","root");
            //Prepared Statement
            PreparedStatement st = connection.prepareStatement("Select count(id) from faculty_publications WHERE username = ?");
            st.setString(1,user);
            
           ResultSet res = st.executeQuery();
           if(res.next())
           {
                publicationNOS1.setText(res.getString(1));
                
           }
          

        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
        }
    }
    
    public void RefreshFacultyTable()
    {
        try
        {   
            //Creating Connection Object
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","root");
            //Prepared Statement
            PreparedStatement st = connection.prepareStatement("Select * from faculty_details");
            ResultSet res = st.executeQuery();
            facultyTable.setModel(DbUtils.resultSetToTableModel(res));
            

        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
        }
        
    }
    public void SetProfile()
    {
        LoginAdmin la = new LoginAdmin();
        String user=la.user;
       
        
        
        try
        {   
            //Creating Connection Object
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","root");
            //Prepared Statement
            PreparedStatement st = connection.prepareStatement("Select username,name,contact_no from admin_details WHERE username = ?");
            st.setString(1, user);
            
           ResultSet res = st.executeQuery();
           if(res.next())
           {
                profileUnameLabel.setText(res.getString(1));
                profileNameLabel.setText(res.getString(2));
                profileContactLabel.setText(res.getString(3));
           }
          

        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
        }
    }
    
    
    public void SetFacultyTable()
    {
        String uname,fname,lname,email,password,dob,qualification,designation,joinDate,salary,address;      
         try
        {   
            //Creating Connection Object
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","root");
            //Prepared Statement
            PreparedStatement st = connection.prepareStatement("Select * from faculty_details");
            
            
           ResultSet res = st.executeQuery();
           DefaultTableModel tableModel=(DefaultTableModel)facultyTable.getModel();
           while(res.next())
           {
                uname=res.getString(1);
                fname=res.getString(2);
                lname=res.getString(3);
                email=res.getString(4);
                password=res.getString(5);
                dob=res.getString(6);
                qualification=res.getString(7);
                designation=res.getString(8);
                joinDate=res.getString(9);
                salary=res.getString(10);
                address=res.getString(11);
                String[] row = {uname,fname,lname,email,password,dob,qualification,designation,joinDate,salary,address};
                
                tableModel.addRow(row);
           }
           
          

        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
        }
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        DashBoard7 = new com.k33ptoo.components.KButton();
        Logout7 = new com.k33ptoo.components.KButton();
        Add_Faculty7 = new com.k33ptoo.components.KButton();
        Manage_Faculty7 = new com.k33ptoo.components.KButton();
        Profile_Button7 = new com.k33ptoo.components.KButton();
        CardPanel = new javax.swing.JPanel();
        DashBoard = new javax.swing.JPanel();
        Right_Title1 = new javax.swing.JPanel();
        label4 = new java.awt.Label();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        dashUserTxtField = new javax.swing.JTextField();
        kButton3 = new com.k33ptoo.components.KButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        publicationNOS1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        WorkshopNOS = new javax.swing.JLabel();
        ManageFaculty = new javax.swing.JPanel();
        Title = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        facultyTable = new javax.swing.JTable();
        kButton4 = new com.k33ptoo.components.KButton();
        kButton5 = new com.k33ptoo.components.KButton();
        AddFaculty = new javax.swing.JPanel();
        Title1 = new javax.swing.JPanel();
        label2 = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        New_Faculty = new javax.swing.JPanel();
        label12 = new java.awt.Label();
        label13 = new java.awt.Label();
        Id = new java.awt.TextField();
        label14 = new java.awt.Label();
        label15 = new java.awt.Label();
        label16 = new java.awt.Label();
        label17 = new java.awt.Label();
        label18 = new java.awt.Label();
        label19 = new java.awt.Label();
        label20 = new java.awt.Label();
        label21 = new java.awt.Label();
        First = new java.awt.TextField();
        Last = new java.awt.TextField();
        Email = new java.awt.TextField();
        Pass = new java.awt.TextField();
        Salary = new java.awt.TextField();
        label22 = new java.awt.Label();
        label23 = new java.awt.Label();
        kButton1 = new com.k33ptoo.components.KButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        Profile = new javax.swing.JPanel();
        Right_Title = new javax.swing.JPanel();
        label3 = new java.awt.Label();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        kButton2 = new com.k33ptoo.components.KButton();
        profileUnameLabel = new javax.swing.JLabel();
        profileContactLabel = new javax.swing.JLabel();
        profileNameLabel = new javax.swing.JLabel();
        UpdateFaculty = new javax.swing.JPanel();
        Title2 = new javax.swing.JPanel();
        label5 = new java.awt.Label();
        jScrollPane3 = new javax.swing.JScrollPane();
        New_Faculty1 = new javax.swing.JPanel();
        label24 = new java.awt.Label();
        label25 = new java.awt.Label();
        Id1 = new java.awt.TextField();
        label26 = new java.awt.Label();
        label27 = new java.awt.Label();
        label28 = new java.awt.Label();
        label29 = new java.awt.Label();
        label30 = new java.awt.Label();
        label31 = new java.awt.Label();
        label32 = new java.awt.Label();
        label33 = new java.awt.Label();
        First1 = new java.awt.TextField();
        Last1 = new java.awt.TextField();
        Email1 = new java.awt.TextField();
        Pass1 = new java.awt.TextField();
        Salary1 = new java.awt.TextField();
        label34 = new java.awt.Label();
        label35 = new java.awt.Label();
        kButton6 = new com.k33ptoo.components.KButton();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jComboBox3 = new javax.swing.JComboBox<>();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jComboBox4 = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        ChangePass = new javax.swing.JPanel();
        Right_Title2 = new javax.swing.JPanel();
        label6 = new java.awt.Label();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        kButton7 = new com.k33ptoo.components.KButton();
        profileUnameLabel1 = new javax.swing.JLabel();
        profileContactLabel1 = new javax.swing.JLabel();
        profileNameLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        currPassTxtField = new javax.swing.JPasswordField();
        newPassTxtField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(300, 900));

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        DashBoard7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        DashBoard7.setForeground(new java.awt.Color(0, 0, 0));
        DashBoard7.setText("DashBoard");
        DashBoard7.setToolTipText("");
        DashBoard7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DashBoard7.setkBackGroundColor(new java.awt.Color(242, 242, 242));
        DashBoard7.setkEndColor(new java.awt.Color(242, 242, 242));
        DashBoard7.setkForeGround(new java.awt.Color(0, 0, 0));
        DashBoard7.setkHoverEndColor(new java.awt.Color(0, 204, 204));
        DashBoard7.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        DashBoard7.setkHoverStartColor(new java.awt.Color(0, 102, 204));
        DashBoard7.setkPressedColor(new java.awt.Color(0, 51, 204));
        DashBoard7.setkSelectedColor(new java.awt.Color(0, 102, 204));
        DashBoard7.setkStartColor(new java.awt.Color(255, 255, 255));
        DashBoard7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashBoard7ActionPerformed(evt);
            }
        });

        Logout7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Logout7.setForeground(new java.awt.Color(0, 0, 0));
        Logout7.setText("Logout");
        Logout7.setToolTipText("");
        Logout7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Logout7.setkBackGroundColor(new java.awt.Color(242, 242, 242));
        Logout7.setkEndColor(new java.awt.Color(242, 242, 242));
        Logout7.setkForeGround(new java.awt.Color(0, 0, 0));
        Logout7.setkHoverEndColor(new java.awt.Color(0, 204, 204));
        Logout7.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        Logout7.setkHoverStartColor(new java.awt.Color(0, 102, 204));
        Logout7.setkPressedColor(new java.awt.Color(0, 51, 204));
        Logout7.setkSelectedColor(new java.awt.Color(0, 102, 204));
        Logout7.setkStartColor(new java.awt.Color(255, 255, 255));
        Logout7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Logout7ActionPerformed(evt);
            }
        });

        Add_Faculty7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Add_Faculty7.setForeground(new java.awt.Color(0, 0, 0));
        Add_Faculty7.setText("Add Faculty");
        Add_Faculty7.setToolTipText("");
        Add_Faculty7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Add_Faculty7.setkBackGroundColor(new java.awt.Color(242, 242, 242));
        Add_Faculty7.setkEndColor(new java.awt.Color(242, 242, 242));
        Add_Faculty7.setkForeGround(new java.awt.Color(0, 0, 0));
        Add_Faculty7.setkHoverEndColor(new java.awt.Color(0, 204, 204));
        Add_Faculty7.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        Add_Faculty7.setkHoverStartColor(new java.awt.Color(0, 102, 204));
        Add_Faculty7.setkPressedColor(new java.awt.Color(0, 51, 204));
        Add_Faculty7.setkSelectedColor(new java.awt.Color(0, 102, 204));
        Add_Faculty7.setkStartColor(new java.awt.Color(255, 255, 255));
        Add_Faculty7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_Faculty7ActionPerformed(evt);
            }
        });

        Manage_Faculty7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Manage_Faculty7.setForeground(new java.awt.Color(0, 0, 0));
        Manage_Faculty7.setText("Manage Faculty");
        Manage_Faculty7.setToolTipText("");
        Manage_Faculty7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Manage_Faculty7.setkBackGroundColor(new java.awt.Color(242, 242, 242));
        Manage_Faculty7.setkEndColor(new java.awt.Color(242, 242, 242));
        Manage_Faculty7.setkForeGround(new java.awt.Color(0, 0, 0));
        Manage_Faculty7.setkHoverEndColor(new java.awt.Color(0, 204, 204));
        Manage_Faculty7.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        Manage_Faculty7.setkHoverStartColor(new java.awt.Color(0, 102, 204));
        Manage_Faculty7.setkPressedColor(new java.awt.Color(0, 51, 204));
        Manage_Faculty7.setkSelectedColor(new java.awt.Color(0, 102, 204));
        Manage_Faculty7.setkStartColor(new java.awt.Color(255, 255, 255));
        Manage_Faculty7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Manage_Faculty7ActionPerformed(evt);
            }
        });

        Profile_Button7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Profile_Button7.setForeground(new java.awt.Color(0, 0, 0));
        Profile_Button7.setText("Profile");
        Profile_Button7.setToolTipText("");
        Profile_Button7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Profile_Button7.setkBackGroundColor(new java.awt.Color(242, 242, 242));
        Profile_Button7.setkEndColor(new java.awt.Color(242, 242, 242));
        Profile_Button7.setkForeGround(new java.awt.Color(0, 0, 0));
        Profile_Button7.setkHoverEndColor(new java.awt.Color(0, 204, 204));
        Profile_Button7.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        Profile_Button7.setkHoverStartColor(new java.awt.Color(0, 102, 204));
        Profile_Button7.setkPressedColor(new java.awt.Color(0, 51, 204));
        Profile_Button7.setkSelectedColor(new java.awt.Color(0, 102, 204));
        Profile_Button7.setkStartColor(new java.awt.Color(255, 255, 255));
        Profile_Button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Profile_Button7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Profile_Button7, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(Logout7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Manage_Faculty7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Add_Faculty7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DashBoard7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157)
                .addComponent(DashBoard7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Add_Faculty7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Manage_Faculty7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Profile_Button7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Logout7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 316, Short.MAX_VALUE))
        );

        CardPanel.setLayout(new java.awt.CardLayout());

        DashBoard.setBackground(new java.awt.Color(255, 255, 255));
        DashBoard.setPreferredSize(new java.awt.Dimension(1300, 900));

        Right_Title1.setPreferredSize(new java.awt.Dimension(1300, 130));

        label4.setBackground(new java.awt.Color(242, 242, 242));
        label4.setFont(new java.awt.Font("Dubai", 1, 48)); // NOI18N
        label4.setText("Faculty Managment System");

        javax.swing.GroupLayout Right_Title1Layout = new javax.swing.GroupLayout(Right_Title1);
        Right_Title1.setLayout(Right_Title1Layout);
        Right_Title1Layout.setHorizontalGroup(
            Right_Title1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Right_Title1Layout.createSequentialGroup()
                .addContainerGap(399, Short.MAX_VALUE)
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(330, 330, 330))
        );
        Right_Title1Layout.setVerticalGroup(
            Right_Title1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Right_Title1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Enter Faculty Username");

        kButton3.setText("Search");
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(dashUserTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dashUserTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Total Publications");

        publicationNOS1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        publicationNOS1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        publicationNOS1.setPreferredSize(new java.awt.Dimension(75, 40));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(publicationNOS1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(publicationNOS1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Total Workshops");

        WorkshopNOS.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        WorkshopNOS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WorkshopNOS.setPreferredSize(new java.awt.Dimension(75, 40));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(WorkshopNOS, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(WorkshopNOS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DashBoardLayout = new javax.swing.GroupLayout(DashBoard);
        DashBoard.setLayout(DashBoardLayout);
        DashBoardLayout.setHorizontalGroup(
            DashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Right_Title1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(DashBoardLayout.createSequentialGroup()
                .addGroup(DashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashBoardLayout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(181, 181, 181)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DashBoardLayout.createSequentialGroup()
                        .addGap(415, 415, 415)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DashBoardLayout.setVerticalGroup(
            DashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashBoardLayout.createSequentialGroup()
                .addComponent(Right_Title1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addGroup(DashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(233, 233, 233))
        );

        CardPanel.add(DashBoard, "card2");

        ManageFaculty.setBackground(new java.awt.Color(255, 255, 255));
        ManageFaculty.setPreferredSize(new java.awt.Dimension(1300, 900));

        Title.setPreferredSize(new java.awt.Dimension(1300, 130));

        label1.setFont(new java.awt.Font("Dubai", 1, 48)); // NOI18N
        label1.setText("Faculty Managment System");

        javax.swing.GroupLayout TitleLayout = new javax.swing.GroupLayout(Title);
        Title.setLayout(TitleLayout);
        TitleLayout.setHorizontalGroup(
            TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitleLayout.createSequentialGroup()
                .addGap(365, 365, 365)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TitleLayout.setVerticalGroup(
            TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitleLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        facultyTable.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        facultyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "First Name", "Last Name", "Email_Id", "Password", "Date Of Birth", "Qualification", "Designation", "Joning Date", "Salary", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        facultyTable.setPreferredSize(new java.awt.Dimension(750, 1000));
        facultyTable.setRowHeight(40);
        facultyTable.setShowGrid(true);
        jScrollPane1.setViewportView(facultyTable);

        kButton4.setText("Delete");
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });

        kButton5.setText("Update");
        kButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ManageFacultyLayout = new javax.swing.GroupLayout(ManageFaculty);
        ManageFaculty.setLayout(ManageFacultyLayout);
        ManageFacultyLayout.setHorizontalGroup(
            ManageFacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageFacultyLayout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addGroup(ManageFacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageFacultyLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageFacultyLayout.createSequentialGroup()
                        .addComponent(kButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)
                        .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(390, 390, 390))))
        );
        ManageFacultyLayout.setVerticalGroup(
            ManageFacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageFacultyLayout.createSequentialGroup()
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addGroup(ManageFacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107))
        );

        CardPanel.add(ManageFaculty, "card3");

        AddFaculty.setBackground(new java.awt.Color(255, 255, 255));
        AddFaculty.setPreferredSize(new java.awt.Dimension(1300, 900));

        Title1.setPreferredSize(new java.awt.Dimension(1300, 130));

        label2.setFont(new java.awt.Font("Dubai", 1, 48)); // NOI18N
        label2.setText("Faculty Managment System");

        javax.swing.GroupLayout Title1Layout = new javax.swing.GroupLayout(Title1);
        Title1.setLayout(Title1Layout);
        Title1Layout.setHorizontalGroup(
            Title1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Title1Layout.createSequentialGroup()
                .addGap(0, 384, Short.MAX_VALUE)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(345, 345, 345))
        );
        Title1Layout.setVerticalGroup(
            Title1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Title1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        jScrollPane2.setPreferredSize(new java.awt.Dimension(700, 1200));

        New_Faculty.setBackground(new java.awt.Color(255, 255, 255));
        New_Faculty.setPreferredSize(new java.awt.Dimension(1300, 1300));

        label12.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label12.setText("Add New Faculty");

        label13.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label13.setText("Username:");

        Id.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N

        label14.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label14.setText("First Name:");

        label15.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label15.setText("Last Name:");

        label16.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label16.setText("Email_Id");

        label17.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label17.setText("Password:");

        label18.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label18.setText("Date of Birth:");

        label19.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label19.setText("Joining Date:");

        label20.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label20.setText("Designation:");

        label21.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label21.setText("Qualification:");

        First.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N

        Last.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N

        Email.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N

        Pass.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N

        Salary.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        Salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalaryActionPerformed(evt);
            }
        });

        label22.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label22.setText("Salary:");

        label23.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label23.setText("Address");

        kButton1.setText("Add Faculty");
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "B.E", "M.E", "B.Tech", "M.Tech" }));

        jDateChooser2.setDateFormatString("yyyy-MM-d");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HOD", "Assistant Professor", "Associate Professor" }));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane5.setViewportView(jTextArea2);

        javax.swing.GroupLayout New_FacultyLayout = new javax.swing.GroupLayout(New_Faculty);
        New_Faculty.setLayout(New_FacultyLayout);
        New_FacultyLayout.setHorizontalGroup(
            New_FacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, New_FacultyLayout.createSequentialGroup()
                .addContainerGap(419, Short.MAX_VALUE)
                .addGroup(New_FacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Salary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Last, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(First, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, 477, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addGap(404, 404, 404))
            .addGroup(New_FacultyLayout.createSequentialGroup()
                .addGroup(New_FacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(New_FacultyLayout.createSequentialGroup()
                        .addGap(552, 552, 552)
                        .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(New_FacultyLayout.createSequentialGroup()
                        .addGap(553, 553, 553)
                        .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        New_FacultyLayout.setVerticalGroup(
            New_FacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(New_FacultyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(label13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(First, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Last, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        label13.getAccessibleContext().setAccessibleName("Teacher's id:");

        jScrollPane2.setViewportView(New_Faculty);

        javax.swing.GroupLayout AddFacultyLayout = new javax.swing.GroupLayout(AddFaculty);
        AddFaculty.setLayout(AddFacultyLayout);
        AddFacultyLayout.setHorizontalGroup(
            AddFacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Title1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        AddFacultyLayout.setVerticalGroup(
            AddFacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddFacultyLayout.createSequentialGroup()
                .addComponent(Title1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        CardPanel.add(AddFaculty, "card4");

        Profile.setBackground(new java.awt.Color(255, 255, 255));
        Profile.setPreferredSize(new java.awt.Dimension(1300, 900));

        Right_Title.setPreferredSize(new java.awt.Dimension(1300, 130));

        label3.setFont(new java.awt.Font("Dubai", 1, 48)); // NOI18N
        label3.setText("Faculty Managment System");

        javax.swing.GroupLayout Right_TitleLayout = new javax.swing.GroupLayout(Right_Title);
        Right_Title.setLayout(Right_TitleLayout);
        Right_TitleLayout.setHorizontalGroup(
            Right_TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Right_TitleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(330, 330, 330))
        );
        Right_TitleLayout.setVerticalGroup(
            Right_TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Right_TitleLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Profile");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Name");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Contact no");

        kButton2.setText("Change Password");
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });

        profileUnameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        profileUnameLabel.setOpaque(true);
        profileUnameLabel.setPreferredSize(new java.awt.Dimension(150, 20));

        profileContactLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        profileContactLabel.setPreferredSize(new java.awt.Dimension(150, 20));

        profileNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        profileNameLabel.setPreferredSize(new java.awt.Dimension(150, 20));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(65, 65, 65)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(profileContactLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(profileUnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(profileNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel1)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(96, 96, 96)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(profileUnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(profileNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(profileContactLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
                .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout ProfileLayout = new javax.swing.GroupLayout(Profile);
        Profile.setLayout(ProfileLayout);
        ProfileLayout.setHorizontalGroup(
            ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Right_Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ProfileLayout.createSequentialGroup()
                .addGap(454, 454, 454)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(476, Short.MAX_VALUE))
        );
        ProfileLayout.setVerticalGroup(
            ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfileLayout.createSequentialGroup()
                .addComponent(Right_Title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        CardPanel.add(Profile, "card5");

        UpdateFaculty.setBackground(new java.awt.Color(255, 255, 255));
        UpdateFaculty.setPreferredSize(new java.awt.Dimension(1300, 900));

        Title2.setPreferredSize(new java.awt.Dimension(1300, 130));

        label5.setFont(new java.awt.Font("Dubai", 1, 48)); // NOI18N
        label5.setText("Faculty Managment System");

        javax.swing.GroupLayout Title2Layout = new javax.swing.GroupLayout(Title2);
        Title2.setLayout(Title2Layout);
        Title2Layout.setHorizontalGroup(
            Title2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Title2Layout.createSequentialGroup()
                .addGap(0, 384, Short.MAX_VALUE)
                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(345, 345, 345))
        );
        Title2Layout.setVerticalGroup(
            Title2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Title2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        jScrollPane3.setPreferredSize(new java.awt.Dimension(700, 1300));

        New_Faculty1.setBackground(new java.awt.Color(255, 255, 255));
        New_Faculty1.setPreferredSize(new java.awt.Dimension(1300, 1300));

        label24.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label24.setText("Update Faculty");

        label25.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label25.setText("Username:");

        Id1.setEditable(false);
        Id1.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N

        label26.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label26.setText("First Name:");

        label27.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label27.setText("Last Name:");

        label28.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label28.setText("Email_Id");

        label29.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label29.setText("Password:");

        label30.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label30.setText("Date of Birth:");

        label31.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label31.setText("Joining Date:");

        label32.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label32.setText("Designation:");

        label33.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label33.setText("Qualification:");

        First1.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N

        Last1.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N

        Email1.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N

        Pass1.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N

        Salary1.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        Salary1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Salary1ActionPerformed(evt);
            }
        });

        label34.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label34.setText("Salary:");

        label35.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label35.setText("Address");

        kButton6.setText("Update Faculty");
        kButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton6ActionPerformed(evt);
            }
        });

        jDateChooser3.setDateFormatString("yyyy-MM-dd");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "B.E", "M.E", "B.Tech", "M.Tech", " " }));

        jDateChooser4.setDateFormatString("yyyy-MM-d");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HOD", "Assistant Professor", "Associate Professor", " " }));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        javax.swing.GroupLayout New_Faculty1Layout = new javax.swing.GroupLayout(New_Faculty1);
        New_Faculty1.setLayout(New_Faculty1Layout);
        New_Faculty1Layout.setHorizontalGroup(
            New_Faculty1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, New_Faculty1Layout.createSequentialGroup()
                .addContainerGap(419, Short.MAX_VALUE)
                .addGroup(New_Faculty1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Salary1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Email1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Last1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(First1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Id1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pass1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox4, 0, 477, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addGap(404, 404, 404))
            .addGroup(New_Faculty1Layout.createSequentialGroup()
                .addGroup(New_Faculty1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(New_Faculty1Layout.createSequentialGroup()
                        .addGap(552, 552, 552)
                        .addComponent(label24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(New_Faculty1Layout.createSequentialGroup()
                        .addGap(534, 534, 534)
                        .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        New_Faculty1Layout.setVerticalGroup(
            New_Faculty1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(New_Faculty1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(label25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(First1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Last1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Email1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Salary1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(New_Faculty1);

        javax.swing.GroupLayout UpdateFacultyLayout = new javax.swing.GroupLayout(UpdateFaculty);
        UpdateFaculty.setLayout(UpdateFacultyLayout);
        UpdateFacultyLayout.setHorizontalGroup(
            UpdateFacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Title2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        UpdateFacultyLayout.setVerticalGroup(
            UpdateFacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateFacultyLayout.createSequentialGroup()
                .addComponent(Title2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        CardPanel.add(UpdateFaculty, "card6");

        ChangePass.setBackground(new java.awt.Color(255, 255, 255));
        ChangePass.setPreferredSize(new java.awt.Dimension(1300, 900));

        Right_Title2.setPreferredSize(new java.awt.Dimension(1300, 130));

        label6.setFont(new java.awt.Font("Dubai", 1, 48)); // NOI18N
        label6.setText("Faculty Managment System");

        javax.swing.GroupLayout Right_Title2Layout = new javax.swing.GroupLayout(Right_Title2);
        Right_Title2.setLayout(Right_Title2Layout);
        Right_Title2Layout.setHorizontalGroup(
            Right_Title2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Right_Title2Layout.createSequentialGroup()
                .addContainerGap(399, Short.MAX_VALUE)
                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(330, 330, 330))
        );
        Right_Title2Layout.setVerticalGroup(
            Right_Title2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Right_Title2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setText("Change Password");

        kButton7.setText("Change Password");
        kButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton7ActionPerformed(evt);
            }
        });

        profileUnameLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        profileUnameLabel1.setOpaque(true);
        profileUnameLabel1.setPreferredSize(new java.awt.Dimension(150, 20));

        profileContactLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        profileContactLabel1.setPreferredSize(new java.awt.Dimension(150, 20));

        profileNameLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        profileNameLabel1.setPreferredSize(new java.awt.Dimension(150, 20));

        jLabel6.setText("Current Password");

        jLabel7.setText("New Password");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(54, 54, 54))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(22, 22, 22)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(profileContactLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(profileUnameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(newPassTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(profileNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6)
                    .addComponent(currPassTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addGap(39, 39, 39)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currPassTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(profileUnameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profileNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPassTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(profileContactLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
        );

        javax.swing.GroupLayout ChangePassLayout = new javax.swing.GroupLayout(ChangePass);
        ChangePass.setLayout(ChangePassLayout);
        ChangePassLayout.setHorizontalGroup(
            ChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Right_Title2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ChangePassLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(450, 450, 450))
        );
        ChangePassLayout.setVerticalGroup(
            ChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChangePassLayout.createSequentialGroup()
                .addComponent(Right_Title2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(281, Short.MAX_VALUE))
        );

        CardPanel.add(ChangePass, "card7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(CardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DashBoard7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashBoard7ActionPerformed
        // TODO add your handling code here:
        cardLayout.show(CardPanel, "card2");
    }//GEN-LAST:event_DashBoard7ActionPerformed

    private void Logout7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Logout7ActionPerformed
        // TODO add your handling code here:
          this.setVisible(false);
          new Home().setVisible(true);
    }//GEN-LAST:event_Logout7ActionPerformed

    private void Add_Faculty7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_Faculty7ActionPerformed
        // TODO add your handling code here:
        cardLayout.show(CardPanel, "card4");
    }//GEN-LAST:event_Add_Faculty7ActionPerformed

    private void Manage_Faculty7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Manage_Faculty7ActionPerformed
        // TODO add your handling code here:
        cardLayout.show(CardPanel, "card3");
    }//GEN-LAST:event_Manage_Faculty7ActionPerformed

    private void Profile_Button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Profile_Button7ActionPerformed
        // TODO add your handling code here:
        cardLayout.show(CardPanel, "card5");
//        SetProfile();

        
        
    }//GEN-LAST:event_Profile_Button7ActionPerformed

    private void SalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SalaryActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
//        Date date1=new Date(jDateChooser1.getDate().getTime());
//        Date date2=new Date(jDateChooser2.getDate().getTime());
        
        try
        {   
            //Creating Connection Object
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","root");
            //Prepared Statement
            PreparedStatement st = connection.prepareStatement("insert into faculty_details values(?,?,?,?,?,?,?,?,?,?,?)" );
            st.setString(1,Id.getText());
            st.setString(2,First.getText());
            st.setString(3,Last.getText());
            st.setString(4,Email.getText());
            st.setString(5,Pass.getText());
            st.setString(6,((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText());
            st.setString(7,jComboBox1.getItemAt(jComboBox1.getSelectedIndex()));
            st.setString(8,jComboBox2.getItemAt(jComboBox2.getSelectedIndex()));
            st.setString(9,((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText());
            st.setString(10,Salary.getText());
            st.setString(11,jTextArea2.getText());
            
            PreparedStatement st2=connection.prepareStatement("select * from faculty_details where username=?");
            st2.setString(1,Id.getText());
            ResultSet res = st2.executeQuery();
            if(res.next())
            {
                JOptionPane.showMessageDialog(this,"Username already exists");
            }
            else
            {
                st.executeUpdate();
                JOptionPane.showMessageDialog(this,"record added");
               
                Id.setText("");
                First.setText("");
                Last.setText("");
                Email.setText("");
                Pass.setText("");
                ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).setText("");
                jComboBox1.setSelectedIndex(0);
                jComboBox2.setSelectedIndex(0);
                ((JTextField)jDateChooser2.getDateEditor().getUiComponent()).setText("");
                Salary.setText("");
                jTextArea2.setText("");
                RefreshFacultyTable();
            }
          
            
            //st.executeUpdate();
            //JOptionPane.showMessageDialog(this,"record added");
            //RefreshFacultyTable();
        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
        }
    }//GEN-LAST:event_kButton1ActionPerformed

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
        // TODO add your handling code here:
        int row = facultyTable.getSelectedRow();
        String cell = facultyTable.getModel().getValueAt(row, 0).toString();
       try
        {   
            //Creating Connection Object
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","root");
            //Prepared Statement
            PreparedStatement st = connection.prepareStatement("delete from faculty_workshop where username=?" );
            st.setString(1,cell);
            st.executeUpdate();
            PreparedStatement st2 = connection.prepareStatement("delete from faculty_publications where username=?" );
            st2.setString(1,cell);
            st2.executeUpdate();
            PreparedStatement st3 = connection.prepareStatement("delete from faculty_details where username=?" );
            st3.setString(1,cell);
            st3.executeUpdate();
            JOptionPane.showMessageDialog(this,"record deleted");
            RefreshFacultyTable();
        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
        }
    }//GEN-LAST:event_kButton4ActionPerformed

    private void Salary1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salary1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Salary1ActionPerformed

    
//=====================================================================updateRecords==================================
    
    private void kButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton6ActionPerformed
        try
        {   
            //Creating Connection Object
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","root");
            //Prepared Statement
            PreparedStatement st = connection.prepareStatement("update faculty_details set fname=?,lname=?,email=?,password=?,dob=?,qualification=?,designation=?,join_date=?,salary=?,address=? where username=?" );
        
            st.setString(11,Id1.getText());
            st.setString(1,First1.getText());
            st.setString(2,Last1.getText());
            st.setString(3,Email1.getText());
            st.setString(4,Pass1.getText());
            st.setString(5,((JTextField)jDateChooser3.getDateEditor().getUiComponent()).getText());
            st.setString(6,jComboBox3.getItemAt(jComboBox3.getSelectedIndex()));  //sus
            st.setString(7,jComboBox4.getItemAt(jComboBox4.getSelectedIndex()));   //sus
            st.setString(8,((JTextField)jDateChooser4.getDateEditor().getUiComponent()).getText());
            st.setString(9,Salary1.getText());
            st.setString(10,jTextArea1.getText());
        
            st.executeUpdate();
            JOptionPane.showMessageDialog(this,"Record Updated");
            RefreshFacultyTable();
            cardLayout.show(CardPanel, "card3");
        
        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
        }
    }//GEN-LAST:event_kButton6ActionPerformed
//====================================================================================================================
    
    
    //==============================================================update1 button======================================
    private void kButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton5ActionPerformed
        // TODO add your handling code here:
        cardLayout.show(CardPanel, "card6");
        
        int row = facultyTable.getSelectedRow();
        String cell = facultyTable.getModel().getValueAt(row, 0).toString();
        try
        {   
            //Creating Connection Object
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","root");
            //Prepared Statement
            PreparedStatement st = connection.prepareStatement("select * from faculty_details where username=?" );
            st.setString(1,cell);
            
            ResultSet res = st.executeQuery();
            while(res.next())
            {
                Id1.setText(res.getString(1));
                First1.setText(res.getString(2));
                Last1.setText(res.getString(3));
                Email1.setText(res.getString(4));
                Pass1.setText(res.getString(5));
                Salary1.setText(res.getString(10));
                jTextArea1.setText(res.getString(11));
                
                jComboBox3.setSelectedItem(res.getString(7));
                jComboBox4.setSelectedItem(res.getString(8));
                
                String dob = res.getString(6); // What ever column
                ((JTextField)jDateChooser3.getDateEditor().getUiComponent()).setText(dob);
                
                String join = res.getString(9); // What ever column
                ((JTextField)jDateChooser4.getDateEditor().getUiComponent()).setText(join);
                
                
            }
        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
        }
    }//GEN-LAST:event_kButton5ActionPerformed

    private void kButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton7ActionPerformed
        // TODO add your handling code here:
        LoginAdmin la = new LoginAdmin();
        String user=la.user;
        String currPass,newPass;
        currPass=currPassTxtField.getText();
        newPass=newPassTxtField.getText();
        
        //Creating Connection Object
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","root");
            //Prepared Statement
            PreparedStatement st = connection.prepareStatement("select password from admin_details where username=?" );
            st.setString(1,user);
            ResultSet res = st.executeQuery();
            if(res.next())
            {   if(!currPass.equals(res.getString(1)))
                {
                    JOptionPane.showMessageDialog(this,"Password does not match");
                    
                }
                else if(currPass.equals(res.getString(1))&& newPassTxtField.getText().equals(""))
                {
                     JOptionPane.showMessageDialog(this,"New Password cannot be empty");
                
                }
                else
                {
                    PreparedStatement st2 = connection.prepareStatement("Update admin_details set password=? where username=?" );
                    st2.setString(1,newPass);
                    st2.setString(2,user);
                    st2.executeUpdate();
                    JOptionPane.showMessageDialog(this,"Password changed");
                    cardLayout.show(CardPanel, "card5");
                }
            }
            

        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
        }
        
    }//GEN-LAST:event_kButton7ActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        // TODO add your handling code here:
        cardLayout.show(CardPanel, "card7");
    }//GEN-LAST:event_kButton2ActionPerformed

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        // TODO add your handling code here:
        String username;
        username=dashUserTxtField.getText();
        try
        {
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","root");
            //Prepared Statement
            PreparedStatement st = connection.prepareStatement("select username from faculty_details where username=?" );
            st.setString(1,username);
            ResultSet res=st.executeQuery();
            if(res.next())
            {
                setPublicationCount(username);
                setWorkshopCount(username);
            }
            else
            {
                JOptionPane.showMessageDialog(this,"User not found");
            }
            
        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
        }
        
        
    }//GEN-LAST:event_kButton3ActionPerformed
//===================================================================================================================================
    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AdminGUI().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddFaculty;
    private com.k33ptoo.components.KButton Add_Faculty7;
    private javax.swing.JPanel CardPanel;
    private javax.swing.JPanel ChangePass;
    private javax.swing.JPanel DashBoard;
    private com.k33ptoo.components.KButton DashBoard7;
    private java.awt.TextField Email;
    private java.awt.TextField Email1;
    private java.awt.TextField First;
    private java.awt.TextField First1;
    private java.awt.TextField Id;
    private java.awt.TextField Id1;
    private java.awt.TextField Last;
    private java.awt.TextField Last1;
    private com.k33ptoo.components.KButton Logout7;
    private javax.swing.JPanel ManageFaculty;
    private com.k33ptoo.components.KButton Manage_Faculty7;
    private javax.swing.JPanel New_Faculty;
    private javax.swing.JPanel New_Faculty1;
    private java.awt.TextField Pass;
    private java.awt.TextField Pass1;
    private javax.swing.JPanel Profile;
    private com.k33ptoo.components.KButton Profile_Button7;
    private javax.swing.JPanel Right_Title;
    private javax.swing.JPanel Right_Title1;
    private javax.swing.JPanel Right_Title2;
    private java.awt.TextField Salary;
    private java.awt.TextField Salary1;
    private javax.swing.JPanel Title;
    private javax.swing.JPanel Title1;
    private javax.swing.JPanel Title2;
    private javax.swing.JPanel UpdateFaculty;
    private javax.swing.JLabel WorkshopNOS;
    private javax.swing.JPasswordField currPassTxtField;
    private javax.swing.JTextField dashUserTxtField;
    private javax.swing.JTable facultyTable;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton2;
    private com.k33ptoo.components.KButton kButton3;
    private com.k33ptoo.components.KButton kButton4;
    private com.k33ptoo.components.KButton kButton5;
    private com.k33ptoo.components.KButton kButton6;
    private com.k33ptoo.components.KButton kButton7;
    private java.awt.Label label1;
    private java.awt.Label label12;
    private java.awt.Label label13;
    private java.awt.Label label14;
    private java.awt.Label label15;
    private java.awt.Label label16;
    private java.awt.Label label17;
    private java.awt.Label label18;
    private java.awt.Label label19;
    private java.awt.Label label2;
    private java.awt.Label label20;
    private java.awt.Label label21;
    private java.awt.Label label22;
    private java.awt.Label label23;
    private java.awt.Label label24;
    private java.awt.Label label25;
    private java.awt.Label label26;
    private java.awt.Label label27;
    private java.awt.Label label28;
    private java.awt.Label label29;
    private java.awt.Label label3;
    private java.awt.Label label30;
    private java.awt.Label label31;
    private java.awt.Label label32;
    private java.awt.Label label33;
    private java.awt.Label label34;
    private java.awt.Label label35;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private javax.swing.JPasswordField newPassTxtField;
    private javax.swing.JLabel profileContactLabel;
    private javax.swing.JLabel profileContactLabel1;
    private javax.swing.JLabel profileNameLabel;
    private javax.swing.JLabel profileNameLabel1;
    private javax.swing.JLabel profileUnameLabel;
    private javax.swing.JLabel profileUnameLabel1;
    private javax.swing.JLabel publicationNOS1;
    // End of variables declaration//GEN-END:variables
}
