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
 * @author Dimple
 */
public class FacultyMain extends JFrame {

    /**
     * Creates new form Faculty
     */
    CardLayout cardLayout;
   
    public FacultyMain() {
        initComponents();
        cardLayout = (CardLayout)(CardPanelF.getLayout());
        SetProfile();
        SetWorkshopTable();
        SetPublicationTable();
        setDashboard();
    }
    
    void setWorkshopCount()
    {
        LoginFaculty lf = new LoginFaculty();
        String user=lf.userFaculty;
        
        
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
    
    void setPublicationCount()
    {
        LoginFaculty lf = new LoginFaculty();
        String user=lf.userFaculty;
        
        
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
                publicationNOS.setText(res.getString(1));
                
           }
          

        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
        }
    }
    void setDashboard()
    {
        setWorkshopCount();
        setPublicationCount();
        
    }

    void SetPublicationTable()
    {
        String id,description,publishDate;  
        LoginFaculty lf = new LoginFaculty();
        String user=lf.userFaculty;
        try
        {   
            //Creating Connection Object
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","root");
            //Prepared Statement
            PreparedStatement st = connection.prepareStatement("Select * from faculty_publications where username=?");
            
           st.setString(1, user); 
           ResultSet res = st.executeQuery();
           DefaultTableModel tableModel=(DefaultTableModel)tblPublicationDetails.getModel();
           while(res.next())
           {
                id=res.getString(1);
                description=res.getString(2);
                publishDate=res.getString(3);
                
               
                String[] row = {id,description,publishDate};
                
                tableModel.addRow(row);
           }
           
          

        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
        }
        
    }
    
    public void RefreshPublicationTable()
    {
        LoginFaculty lf = new LoginFaculty();
        String user=lf.userFaculty;
        try
        {   
            //Creating Connection Object
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","root");
            //Prepared Statement
            PreparedStatement st = connection.prepareStatement("Select id,description,publish_date from faculty_publications where username=?");
            st.setString(1, user); 
            ResultSet res = st.executeQuery();
            tblPublicationDetails.setModel(DbUtils.resultSetToTableModel(res));
            setDashboard(); //addition

        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
        }
        
    }
    
    public void RefreshWorkshopTable()
    {
        LoginFaculty lf = new LoginFaculty();
        String user=lf.userFaculty;
        try
        {   
            //Creating Connection Object
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","root");
            //Prepared Statement
            PreparedStatement st = connection.prepareStatement("Select id,description,start_date,end_date from faculty_workshop where username=?");
            st.setString(1, user); 
            ResultSet res = st.executeQuery();
            tblWorkshop.setModel(DbUtils.resultSetToTableModel(res));
            setDashboard(); //addition

        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
        }
        
    }
    
//    void AddPublicationRecord()
//    {
//        String id,description,publishDate;  
//        LoginFaculty lf = new LoginFaculty();
//        String user=lf.userFaculty;
//        try
//        {   
//            //Creating Connection Object
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","root");
//            //Prepared Statement
//            PreparedStatement st = connection.prepareStatement("Select * from faculty_publications where username=? order by id DESC LIMIT 1");
//            
//           st.setString(1, user); 
//           ResultSet res = st.executeQuery();
//           DefaultTableModel tableModel=(DefaultTableModel)tblPublicationDetails.getModel();
//           while(res.next())
//           {
//                id=res.getString(1);
//                description=res.getString(2);
//                publishDate=res.getString(3);
//                
//               
//                String[] row = {id,description,publishDate};
//                
//                tableModel.addRow(row);
//           }
//           
//          
//
//        }
//        catch(SQLException e1)
//        {
//            e1.printStackTrace();
//        }
//        
//    }
    
    void SetWorkshopTable()
    {
        String id,description,startDate,endDate;  
        LoginFaculty lf = new LoginFaculty();
        String user=lf.userFaculty;
         try
        {   
            //Creating Connection Object
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","root");
            //Prepared Statement
            PreparedStatement st = connection.prepareStatement("Select * from faculty_workshop where username=?");
            
           st.setString(1, user); 
           ResultSet res = st.executeQuery();
           DefaultTableModel tableModel=(DefaultTableModel)tblWorkshop.getModel();
           while(res.next())
           {
                id=res.getString(1);
                description=res.getString(2);
                startDate=res.getString(3);
                endDate=res.getString(4);
               
                String[] row = {id,description,startDate,endDate};
                
                tableModel.addRow(row);
           }
           
          

        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
        }
    }
    
    
//    void AddWorkshopRecord()
//    {
//        String id,description,startDate,endDate;  
//        LoginFaculty lf = new LoginFaculty();
//        String user=lf.userFaculty;
//         try
//        {   
//            //Creating Connection Object
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","root");
//            //Prepared Statement
//            PreparedStatement st = connection.prepareStatement("Select * from faculty_workshop where username=? order by id DESC LIMIT 1");
//            
//           st.setString(1, user); 
//           ResultSet res = st.executeQuery();
//           DefaultTableModel tableModel=(DefaultTableModel)tblWorkshop.getModel();
//           while(res.next())
//           {
//                id=res.getString(1);
//                description=res.getString(2);
//                startDate=res.getString(3);
//                endDate=res.getString(4);
//               
//                String[] row = {id,description,startDate,endDate};
//                
//                tableModel.addRow(row);
//           }
//           
//          
//
//        }
//        catch(SQLException e1)
//        {
//            e1.printStackTrace();
//        }
//    }
    void SetProfile()
    {
        LoginFaculty lf = new LoginFaculty();
        String user=lf.userFaculty;
        System.out.print(user);
        
        try
        {   
            //Creating Connection Object
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","root");
            //Prepared Statement
            PreparedStatement st = connection.prepareStatement("Select username,fname,lname,email,qualification,designation from faculty_details WHERE username = ?");
            st.setString(1,user);
            
           ResultSet res = st.executeQuery();
           if(res.next())
           {
                profileUnameLabel.setText(res.getString(1));
                profileNameLabel.setText(res.getString(2)+" "+res.getString(3));
                profileEmailLabel.setText(res.getString(4));
                profileDesigLabel.setText(res.getString(6));
                profileQualifyLabel.setText(res.getString(5));
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
        btnWorkshops = new com.k33ptoo.components.KButton();
        jPanel4 = new javax.swing.JPanel();
        btnDashboard = new com.k33ptoo.components.KButton();
        btnPublications = new com.k33ptoo.components.KButton();
        btnProfile = new com.k33ptoo.components.KButton();
        btnLogout = new com.k33ptoo.components.KButton();
        CardPanelF = new javax.swing.JPanel();
        dashboard = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        publicationNOS = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        WorkshopNOS = new javax.swing.JLabel();
        workshop = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblWkName = new javax.swing.JLabel();
        lblWktitle = new javax.swing.JLabel();
        lblStartDate = new javax.swing.JLabel();
        lblEndDate = new javax.swing.JLabel();
        btnAddWkD = new com.k33ptoo.components.KButton();
        workshopStartDate = new com.toedter.calendar.JDateChooser();
        workshopEndDate = new com.toedter.calendar.JDateChooser();
        workshopTxtField = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        lblWktitle2 = new javax.swing.JLabel();
        scrlpaneWk = new javax.swing.JScrollPane();
        tblWorkshop = new javax.swing.JTable();
        btnDeleteWkD = new com.k33ptoo.components.KButton();
        publications = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        lblPublicationName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblPublishedDate = new javax.swing.JLabel();
        btnAdd = new com.k33ptoo.components.KButton();
        txtPublicationName = new javax.swing.JTextField();
        dtPublishedDate = new com.toedter.calendar.JDateChooser();
        jPanel20 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        scrlPane = new javax.swing.JScrollPane();
        tblPublicationDetails = new javax.swing.JTable();
        btnDelete = new com.k33ptoo.components.KButton();
        profile = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        kButton2 = new com.k33ptoo.components.KButton();
        kButton3 = new com.k33ptoo.components.KButton();
        profileUnameLabel = new javax.swing.JLabel();
        profileQualifyLabel = new javax.swing.JLabel();
        profileNameLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        profileEmailLabel = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        profileDesigLabel = new javax.swing.JLabel();
        ChangePass = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        kButton7 = new com.k33ptoo.components.KButton();
        profileUnameLabel1 = new javax.swing.JLabel();
        profileContactLabel1 = new javax.swing.JLabel();
        profileNameLabel1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        currPassTxtField = new javax.swing.JPasswordField();
        newPassTxtField = new javax.swing.JPasswordField();
        Right_Title2 = new javax.swing.JPanel();
        label6 = new java.awt.Label();
        EditProfile = new javax.swing.JPanel();
        Title3 = new javax.swing.JPanel();
        label7 = new java.awt.Label();
        jScrollPane4 = new javax.swing.JScrollPane();
        New_Faculty2 = new javax.swing.JPanel();
        label36 = new java.awt.Label();
        label37 = new java.awt.Label();
        Id2 = new java.awt.TextField();
        label38 = new java.awt.Label();
        label39 = new java.awt.Label();
        label40 = new java.awt.Label();
        label44 = new java.awt.Label();
        label45 = new java.awt.Label();
        First2 = new java.awt.TextField();
        Last2 = new java.awt.TextField();
        Email2 = new java.awt.TextField();
        label47 = new java.awt.Label();
        kButton8 = new com.k33ptoo.components.KButton();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setResizable(false);
        setSize(new java.awt.Dimension(1600, 900));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        btnWorkshops.setText("Workshops");
        btnWorkshops.setBorderPainted(false);
        btnWorkshops.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnWorkshops.setkBackGroundColor(new java.awt.Color(242, 242, 242));
        btnWorkshops.setkEndColor(new java.awt.Color(242, 242, 242));
        btnWorkshops.setkForeGround(new java.awt.Color(0, 0, 0));
        btnWorkshops.setkHoverEndColor(new java.awt.Color(0, 204, 204));
        btnWorkshops.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnWorkshops.setkHoverStartColor(new java.awt.Color(0, 102, 204));
        btnWorkshops.setkPressedColor(new java.awt.Color(0, 51, 204));
        btnWorkshops.setkSelectedColor(new java.awt.Color(0, 102, 204));
        btnWorkshops.setkStartColor(new java.awt.Color(255, 255, 255));
        btnWorkshops.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWorkshopsActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(0, 0, 153));
        jPanel4.setPreferredSize(new java.awt.Dimension(0, 130));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        btnDashboard.setText("Dashboard");
        btnDashboard.setBorderPainted(false);
        btnDashboard.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDashboard.setkBackGroundColor(new java.awt.Color(242, 242, 242));
        btnDashboard.setkEndColor(new java.awt.Color(242, 242, 242));
        btnDashboard.setkForeGround(new java.awt.Color(0, 0, 0));
        btnDashboard.setkHoverEndColor(new java.awt.Color(0, 204, 204));
        btnDashboard.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnDashboard.setkHoverStartColor(new java.awt.Color(0, 102, 204));
        btnDashboard.setkPressedColor(new java.awt.Color(0, 51, 204));
        btnDashboard.setkSelectedColor(new java.awt.Color(0, 102, 204));
        btnDashboard.setkStartColor(new java.awt.Color(255, 255, 255));
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });

        btnPublications.setText("Publications");
        btnPublications.setBorderPainted(false);
        btnPublications.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPublications.setkBackGroundColor(new java.awt.Color(242, 242, 242));
        btnPublications.setkEndColor(new java.awt.Color(242, 242, 242));
        btnPublications.setkForeGround(new java.awt.Color(0, 0, 0));
        btnPublications.setkHoverEndColor(new java.awt.Color(0, 204, 204));
        btnPublications.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnPublications.setkHoverStartColor(new java.awt.Color(0, 102, 204));
        btnPublications.setkPressedColor(new java.awt.Color(0, 51, 204));
        btnPublications.setkSelectedColor(new java.awt.Color(0, 102, 204));
        btnPublications.setkStartColor(new java.awt.Color(255, 255, 255));
        btnPublications.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublicationsActionPerformed(evt);
            }
        });

        btnProfile.setText("Profile");
        btnProfile.setBorderPainted(false);
        btnProfile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnProfile.setkBackGroundColor(new java.awt.Color(242, 242, 242));
        btnProfile.setkEndColor(new java.awt.Color(242, 242, 242));
        btnProfile.setkForeGround(new java.awt.Color(0, 0, 0));
        btnProfile.setkHoverEndColor(new java.awt.Color(0, 204, 204));
        btnProfile.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnProfile.setkHoverStartColor(new java.awt.Color(0, 102, 204));
        btnProfile.setkPressedColor(new java.awt.Color(0, 51, 204));
        btnProfile.setkSelectedColor(new java.awt.Color(0, 102, 204));
        btnProfile.setkStartColor(new java.awt.Color(255, 255, 255));
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });

        btnLogout.setText("Logout");
        btnLogout.setBorderPainted(false);
        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogout.setkBackGroundColor(new java.awt.Color(242, 242, 242));
        btnLogout.setkEndColor(new java.awt.Color(242, 242, 242));
        btnLogout.setkForeGround(new java.awt.Color(0, 0, 0));
        btnLogout.setkHoverEndColor(new java.awt.Color(0, 204, 204));
        btnLogout.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnLogout.setkHoverStartColor(new java.awt.Color(0, 102, 204));
        btnLogout.setkPressedColor(new java.awt.Color(0, 51, 204));
        btnLogout.setkSelectedColor(new java.awt.Color(0, 102, 204));
        btnLogout.setkStartColor(new java.awt.Color(255, 255, 255));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(btnProfile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPublications, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnWorkshops, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnWorkshops, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnPublications, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CardPanelF.setBackground(new java.awt.Color(255, 255, 255));
        CardPanelF.setPreferredSize(new java.awt.Dimension(1300, 900));
        CardPanelF.setLayout(new java.awt.CardLayout());

        dashboard.setBackground(new java.awt.Color(255, 255, 255));
        dashboard.setPreferredSize(new java.awt.Dimension(1300, 900));

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));
        jPanel12.setPreferredSize(new java.awt.Dimension(1300, 130));

        jLabel5.setFont(new java.awt.Font("Dubai", 1, 48)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Faculty Management System");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(366, 366, 366)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                .addGap(325, 325, 325))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("My Publications");

        publicationNOS.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        publicationNOS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        publicationNOS.setPreferredSize(new java.awt.Dimension(75, 40));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(publicationNOS, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(publicationNOS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("My Workshops");

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
                .addContainerGap(84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dashboardLayout = new javax.swing.GroupLayout(dashboard);
        dashboard.setLayout(dashboardLayout);
        dashboardLayout.setHorizontalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(dashboardLayout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dashboardLayout.setVerticalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(273, 273, 273)
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(289, Short.MAX_VALUE))
        );

        CardPanelF.add(dashboard, "card2");

        workshop.setBackground(new java.awt.Color(255, 255, 255));
        workshop.setPreferredSize(new java.awt.Dimension(1300, 900));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(1300, 130));

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Faculty Management System");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(366, 366, 366)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                .addGap(325, 325, 325))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(204, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setPreferredSize(new java.awt.Dimension(565, 345));

        lblWkName.setText("Workshop Name");

        lblWktitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblWktitle.setText("Add Workshop Details");

        lblStartDate.setText("Starting Date");

        lblEndDate.setText("End Date");

        btnAddWkD.setText("Add");
        btnAddWkD.setkBackGroundColor(new java.awt.Color(51, 51, 255));
        btnAddWkD.setkEndColor(new java.awt.Color(51, 51, 255));
        btnAddWkD.setkHoverEndColor(new java.awt.Color(0, 102, 255));
        btnAddWkD.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnAddWkD.setkHoverStartColor(new java.awt.Color(0, 51, 255));
        btnAddWkD.setkPressedColor(new java.awt.Color(0, 51, 204));
        btnAddWkD.setkSelectedColor(new java.awt.Color(0, 102, 255));
        btnAddWkD.setkStartColor(new java.awt.Color(0, 0, 204));
        btnAddWkD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddWkDActionPerformed(evt);
            }
        });

        workshopStartDate.setDateFormatString("yyyy-MM-dd");
        workshopStartDate.setMaxSelectableDate(new java.util.Date(253370748707000L));
        workshopStartDate.setPreferredSize(new java.awt.Dimension(65, 20));

        workshopEndDate.setDateFormatString("yyyy-MM-dd");
        workshopEndDate.setPreferredSize(new java.awt.Dimension(65, 20));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblWkName, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblWktitle, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(workshopStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                .addComponent(workshopEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(workshopTxtField))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(btnAddWkD, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(lblWktitle, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblWkName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(workshopTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(workshopStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(workshopEndDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEndDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(btnAddWkD, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jPanel7.setBackground(new java.awt.Color(204, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel7.setPreferredSize(new java.awt.Dimension(565, 345));

        lblWktitle2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblWktitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWktitle2.setText("My Workshops");

        tblWorkshop.setAutoCreateRowSorter(true);
        tblWorkshop.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblWorkshop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr. No.", "Name", "Start Date", "End Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblWorkshop.setRowHeight(30);
        tblWorkshop.setShowGrid(true);
        tblWorkshop.getTableHeader().setResizingAllowed(false);
        tblWorkshop.getTableHeader().setReorderingAllowed(false);
        scrlpaneWk.setViewportView(tblWorkshop);

        btnDeleteWkD.setText("Delete");
        btnDeleteWkD.setkBackGroundColor(new java.awt.Color(51, 51, 255));
        btnDeleteWkD.setkEndColor(new java.awt.Color(51, 51, 255));
        btnDeleteWkD.setkHoverEndColor(new java.awt.Color(0, 102, 255));
        btnDeleteWkD.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnDeleteWkD.setkHoverStartColor(new java.awt.Color(0, 51, 255));
        btnDeleteWkD.setkPressedColor(new java.awt.Color(0, 51, 204));
        btnDeleteWkD.setkSelectedColor(new java.awt.Color(0, 102, 255));
        btnDeleteWkD.setkStartColor(new java.awt.Color(0, 0, 204));
        btnDeleteWkD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteWkDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnDeleteWkD, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(321, 321, 321))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(scrlpaneWk, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(313, 313, 313)
                        .addComponent(lblWktitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(lblWktitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(scrlpaneWk, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnDeleteWkD, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout workshopLayout = new javax.swing.GroupLayout(workshop);
        workshop.setLayout(workshopLayout);
        workshopLayout.setHorizontalGroup(
            workshopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workshopLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(workshopLayout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addGroup(workshopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        workshopLayout.setVerticalGroup(
            workshopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workshopLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        CardPanelF.add(workshop, "card3");

        publications.setBackground(new java.awt.Color(255, 255, 255));
        publications.setPreferredSize(new java.awt.Dimension(1300, 900));

        jPanel18.setBackground(new java.awt.Color(204, 204, 204));
        jPanel18.setPreferredSize(new java.awt.Dimension(1300, 130));

        jLabel9.setFont(new java.awt.Font("Dubai", 1, 48)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Faculty Management System");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(366, 366, 366)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                .addGap(325, 325, 325))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel19.setBackground(new java.awt.Color(204, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel19.setPreferredSize(new java.awt.Dimension(565, 345));

        lblPublicationName.setText("Publication Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Add Publication Details");

        lblPublishedDate.setText("Published Date");

        btnAdd.setText("Add");
        btnAdd.setkBackGroundColor(new java.awt.Color(51, 51, 255));
        btnAdd.setkEndColor(new java.awt.Color(51, 51, 255));
        btnAdd.setkHoverEndColor(new java.awt.Color(0, 102, 255));
        btnAdd.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnAdd.setkHoverStartColor(new java.awt.Color(0, 51, 255));
        btnAdd.setkPressedColor(new java.awt.Color(0, 51, 204));
        btnAdd.setkSelectedColor(new java.awt.Color(0, 102, 255));
        btnAdd.setkStartColor(new java.awt.Color(0, 0, 204));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        dtPublishedDate.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(188, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addComponent(lblPublicationName, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(txtPublicationName, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(lblPublishedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtPublishedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(178, 178, 178))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPublicationName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPublicationName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPublishedDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtPublishedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jPanel20.setBackground(new java.awt.Color(204, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Publication Details");

        tblPublicationDetails.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblPublicationDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPublicationDetails.setRowHeight(30);
        tblPublicationDetails.setShowGrid(true);
        tblPublicationDetails.getTableHeader().setResizingAllowed(false);
        tblPublicationDetails.getTableHeader().setReorderingAllowed(false);
        scrlPane.setViewportView(tblPublicationDetails);

        btnDelete.setText("Delete");
        btnDelete.setkBackGroundColor(new java.awt.Color(51, 51, 255));
        btnDelete.setkEndColor(new java.awt.Color(51, 51, 255));
        btnDelete.setkHoverEndColor(new java.awt.Color(0, 102, 255));
        btnDelete.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnDelete.setkHoverStartColor(new java.awt.Color(0, 51, 255));
        btnDelete.setkPressedColor(new java.awt.Color(0, 51, 204));
        btnDelete.setkSelectedColor(new java.awt.Color(0, 102, 255));
        btnDelete.setkStartColor(new java.awt.Color(0, 0, 204));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(scrlPane, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(324, 324, 324)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(scrlPane, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout publicationsLayout = new javax.swing.GroupLayout(publications);
        publications.setLayout(publicationsLayout);
        publicationsLayout.setHorizontalGroup(
            publicationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(publicationsLayout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(publicationsLayout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addGroup(publicationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        publicationsLayout.setVerticalGroup(
            publicationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(publicationsLayout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );

        CardPanelF.add(publications, "card4");

        profile.setBackground(new java.awt.Color(255, 255, 255));
        profile.setPreferredSize(new java.awt.Dimension(1300, 900));

        jPanel13.setBackground(new java.awt.Color(204, 204, 204));
        jPanel13.setPreferredSize(new java.awt.Dimension(1300, 130));

        jLabel7.setFont(new java.awt.Font("Dubai", 1, 48)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Faculty Management System");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(366, 366, 366)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                .addGap(325, 325, 325))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Profile");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Username");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Name");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Qualification");

        kButton2.setText("Change Password");
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });

        kButton3.setText("Edit Profile");
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });

        profileUnameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        profileUnameLabel.setPreferredSize(new java.awt.Dimension(150, 20));

        profileQualifyLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        profileQualifyLabel.setPreferredSize(new java.awt.Dimension(150, 20));

        profileNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        profileNameLabel.setPreferredSize(new java.awt.Dimension(150, 20));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Email");

        profileEmailLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        profileEmailLabel.setPreferredSize(new java.awt.Dimension(150, 20));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Designation");

        profileDesigLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        profileDesigLabel.setPreferredSize(new java.awt.Dimension(150, 20));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(kButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(profileEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(profileDesigLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10))
                                .addGap(59, 59, 59)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(profileQualifyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(profileUnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(profileNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(129, 129, 129))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addGap(95, 95, 95)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(profileUnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(profileNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(profileQualifyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(profileEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(profileDesigLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
                .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout profileLayout = new javax.swing.GroupLayout(profile);
        profile.setLayout(profileLayout);
        profileLayout.setHorizontalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileLayout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(profileLayout.createSequentialGroup()
                .addGap(474, 474, 474)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        profileLayout.setVerticalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileLayout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        CardPanelF.add(profile, "card5");

        ChangePass.setBackground(new java.awt.Color(255, 255, 255));
        ChangePass.setPreferredSize(new java.awt.Dimension(1300, 900));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel20.setText("Change Password");

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

        jLabel21.setText("Current Password");

        jLabel22.setText("New Password");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(54, 54, 54))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(jLabel22)
                            .addGap(22, 22, 22)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(profileContactLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(profileUnameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(newPassTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(profileNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel21)
                    .addComponent(currPassTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel20)
                .addGap(39, 39, 39)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currPassTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(profileUnameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profileNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPassTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(profileContactLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
        );

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

        javax.swing.GroupLayout ChangePassLayout = new javax.swing.GroupLayout(ChangePass);
        ChangePass.setLayout(ChangePassLayout);
        ChangePassLayout.setHorizontalGroup(
            ChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Right_Title2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ChangePassLayout.createSequentialGroup()
                .addGap(439, 439, 439)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ChangePassLayout.setVerticalGroup(
            ChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChangePassLayout.createSequentialGroup()
                .addComponent(Right_Title2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 267, Short.MAX_VALUE))
        );

        CardPanelF.add(ChangePass, "card6");

        EditProfile.setBackground(new java.awt.Color(255, 255, 255));
        EditProfile.setPreferredSize(new java.awt.Dimension(1300, 900));

        Title3.setPreferredSize(new java.awt.Dimension(1300, 130));

        label7.setFont(new java.awt.Font("Dubai", 1, 48)); // NOI18N
        label7.setText("Faculty Managment System");

        javax.swing.GroupLayout Title3Layout = new javax.swing.GroupLayout(Title3);
        Title3.setLayout(Title3Layout);
        Title3Layout.setHorizontalGroup(
            Title3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Title3Layout.createSequentialGroup()
                .addGap(0, 384, Short.MAX_VALUE)
                .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(345, 345, 345))
        );
        Title3Layout.setVerticalGroup(
            Title3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Title3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        jScrollPane4.setPreferredSize(new java.awt.Dimension(700, 600));

        New_Faculty2.setBackground(new java.awt.Color(255, 255, 255));
        New_Faculty2.setPreferredSize(new java.awt.Dimension(1300, 1050));

        label36.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label36.setText("Update Profile");

        label37.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label37.setText("Username:");

        Id2.setEditable(false);
        Id2.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N

        label38.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label38.setText("First Name:");

        label39.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label39.setText("Last Name:");

        label40.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label40.setText("Email_Id");

        label44.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label44.setText("Designation:");

        label45.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label45.setText("Qualification:");

        First2.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N

        Last2.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N

        Email2.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N

        label47.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        label47.setText("Address");

        kButton8.setText("Update Profile");
        kButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton8ActionPerformed(evt);
            }
        });

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "B.E", "M.E", "B.Tech", "M.Tech", " " }));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HOD", "Assistant Professor", "Associate Professor", " " }));
        jComboBox6.setEnabled(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        javax.swing.GroupLayout New_Faculty2Layout = new javax.swing.GroupLayout(New_Faculty2);
        New_Faculty2.setLayout(New_Faculty2Layout);
        New_Faculty2Layout.setHorizontalGroup(
            New_Faculty2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, New_Faculty2Layout.createSequentialGroup()
                .addContainerGap(419, Short.MAX_VALUE)
                .addGroup(New_Faculty2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Email2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Last2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(First2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Id2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox6, 0, 477, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addGap(404, 404, 404))
            .addGroup(New_Faculty2Layout.createSequentialGroup()
                .addGroup(New_Faculty2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(New_Faculty2Layout.createSequentialGroup()
                        .addGap(552, 552, 552)
                        .addComponent(label36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(New_Faculty2Layout.createSequentialGroup()
                        .addGap(535, 535, 535)
                        .addComponent(kButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        New_Faculty2Layout.setVerticalGroup(
            New_Faculty2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(New_Faculty2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(label37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Id2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(First2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Last2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Email2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(kButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(New_Faculty2);

        javax.swing.GroupLayout EditProfileLayout = new javax.swing.GroupLayout(EditProfile);
        EditProfile.setLayout(EditProfileLayout);
        EditProfileLayout.setHorizontalGroup(
            EditProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Title3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        EditProfileLayout.setVerticalGroup(
            EditProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditProfileLayout.createSequentialGroup()
                .addComponent(Title3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        CardPanelF.add(EditProfile, "card7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(CardPanelF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CardPanelF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnWorkshopsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWorkshopsActionPerformed
        
        cardLayout.show(CardPanelF,"card3");
    }//GEN-LAST:event_btnWorkshopsActionPerformed

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        
        cardLayout.show(CardPanelF,"card2");
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnPublicationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublicationsActionPerformed
        
        cardLayout.show(CardPanelF,"card4");
    }//GEN-LAST:event_btnPublicationsActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        
        cardLayout.show(CardPanelF,"card5");
        //SetProfile();
    }//GEN-LAST:event_btnProfileActionPerformed

    private void btnAddWkDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddWkDActionPerformed
        // TODO add your handling code here:
        
        LoginFaculty lf = new LoginFaculty();
        String user=lf.userFaculty;
        try
        {   
            //Creating Connection Object
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","root");
            //Prepared Statement
            PreparedStatement st = connection.prepareStatement("insert into faculty_workshop(description,start_date,end_date,username) values(?,?,?,?)");
            st.setString(1,workshopTxtField.getText());
            st.setString(2,((JTextField)workshopStartDate.getDateEditor().getUiComponent()).getText());
            st.setString(3,((JTextField)workshopEndDate.getDateEditor().getUiComponent()).getText());
            st.setString(4,user);
            
            
            
            st.executeUpdate();
            JOptionPane.showMessageDialog(this,"record added");
//            SetWorkshopTable();
            RefreshWorkshopTable();
        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
        }
    }//GEN-LAST:event_btnAddWkDActionPerformed

    private void btnDeleteWkDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteWkDActionPerformed
        // TODO add your handling code here:
       int row = tblWorkshop.getSelectedRow();
       String cell = tblWorkshop.getModel().getValueAt(row, 0).toString();
       try
        {   
            //Creating Connection Object
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","root");
            //Prepared Statement
            PreparedStatement st = connection.prepareStatement("delete from faculty_workshop where id=?" );
            st.setString(1,cell);
            st.executeUpdate();
            JOptionPane.showMessageDialog(this,"record deleted");
            RefreshWorkshopTable();
        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
        }
    }//GEN-LAST:event_btnDeleteWkDActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int row = tblPublicationDetails.getSelectedRow();
       String cell = tblPublicationDetails.getModel().getValueAt(row, 0).toString();
       try
        {   
            //Creating Connection Object
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","root");
            //Prepared Statement
            PreparedStatement st = connection.prepareStatement("delete from faculty_publications where id=?" );
            st.setString(1,cell);
            st.executeUpdate();
            JOptionPane.showMessageDialog(this,"record deleted");
            RefreshPublicationTable();
        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Home().setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        LoginFaculty lf = new LoginFaculty();
        String user=lf.userFaculty;
        try
        {   
            //Creating Connection Object
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","root");
            //Prepared Statement
            PreparedStatement st = connection.prepareStatement("insert into faculty_publications(description,publish_date,username) values(?,?,?)");
            st.setString(1,txtPublicationName.getText());
            st.setString(2,((JTextField)dtPublishedDate.getDateEditor().getUiComponent()).getText());
            st.setString(3,user);
            
            
            
            st.executeUpdate();
            JOptionPane.showMessageDialog(this,"record added");
//          SetWorkshopTable();
//            AddPublicationRecord();
            RefreshPublicationTable();
            
        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void kButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton7ActionPerformed
        // TODO add your handling code here:
        LoginFaculty lf = new LoginFaculty();
        String user=lf.userFaculty;
        String currPass,newPass;
        currPass=currPassTxtField.getText();
        newPass=newPassTxtField.getText();

        //Creating Connection Object
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","root");
            //Prepared Statement
            PreparedStatement st = connection.prepareStatement("select password from faculty_details where username=?" );
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
                    PreparedStatement st2 = connection.prepareStatement("Update faculty_details set password=? where username=?" );
                    st2.setString(1,newPass);
                    st2.setString(2,user);
                    st2.executeUpdate();
                    JOptionPane.showMessageDialog(this,"Password changed");
                   cardLayout.show(CardPanelF,"card5");
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
        cardLayout.show(CardPanelF,"card6");
    }//GEN-LAST:event_kButton2ActionPerformed

    private void kButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton8ActionPerformed
        // TODO add your handling code
        try
        {   
            //Creating Connection Object
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","root");
            //Prepared Statement
            PreparedStatement st = connection.prepareStatement("update faculty_details set fname=?,lname=?,email=?,qualification=?,address=? where username=?" ); //sus removed desihnation
        
            
            st.setString(1,First2.getText());
            st.setString(2,Last2.getText());
            st.setString(3,Email2.getText());
            st.setString(4,jComboBox5.getItemAt(jComboBox5.getSelectedIndex())); //sus
//            st.setString(5,jComboBox6.getItemAt(jComboBox6.getSelectedIndex())); //sus 
            st.setString(5,jTextArea1.getText());
            st.setString(6,Id2.getText());
        
            st.executeUpdate();
            JOptionPane.showMessageDialog(this,"Profile Updated");
            SetProfile();
            cardLayout.show(CardPanelF, "card5");
        
        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
        }
        
    }//GEN-LAST:event_kButton8ActionPerformed

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        // TODO add your handling code here:
        cardLayout.show(CardPanelF,"card7");
        LoginFaculty lf = new LoginFaculty();
        String user=lf.userFaculty;
       
        try
        {   
            //Creating Connection Object
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","root");
            //Prepared Statement
            PreparedStatement st = connection.prepareStatement("select username,fname,lname,email,qualification,designation,address from faculty_details where username=?" );
            st.setString(1,user);
            
            ResultSet res = st.executeQuery();
            while(res.next())
            {
                Id2.setText(res.getString(1));
                First2.setText(res.getString(2));
                Last2.setText(res.getString(3));
                Email2.setText(res.getString(4));
                jComboBox5.setSelectedItem(res.getString(5));
                jComboBox6.setSelectedItem(res.getString(6));
                jTextArea1.setText(res.getString(7));
 
                
            }
        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
        }
    }//GEN-LAST:event_kButton3ActionPerformed

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
//            java.util.logging.Logger.getLogger(FacultyMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FacultyMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FacultyMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FacultyMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FacultyMain().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CardPanelF;
    private javax.swing.JPanel ChangePass;
    private javax.swing.JPanel EditProfile;
    private java.awt.TextField Email2;
    private java.awt.TextField First2;
    private java.awt.TextField Id2;
    private java.awt.TextField Last2;
    private javax.swing.JPanel New_Faculty2;
    private javax.swing.JPanel Right_Title2;
    private javax.swing.JPanel Title3;
    private javax.swing.JLabel WorkshopNOS;
    private com.k33ptoo.components.KButton btnAdd;
    private com.k33ptoo.components.KButton btnAddWkD;
    private com.k33ptoo.components.KButton btnDashboard;
    private com.k33ptoo.components.KButton btnDelete;
    private com.k33ptoo.components.KButton btnDeleteWkD;
    private com.k33ptoo.components.KButton btnLogout;
    private com.k33ptoo.components.KButton btnProfile;
    private com.k33ptoo.components.KButton btnPublications;
    private com.k33ptoo.components.KButton btnWorkshops;
    private javax.swing.JPasswordField currPassTxtField;
    private javax.swing.JPanel dashboard;
    private com.toedter.calendar.JDateChooser dtPublishedDate;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private com.k33ptoo.components.KButton kButton2;
    private com.k33ptoo.components.KButton kButton3;
    private com.k33ptoo.components.KButton kButton7;
    private com.k33ptoo.components.KButton kButton8;
    private java.awt.Label label36;
    private java.awt.Label label37;
    private java.awt.Label label38;
    private java.awt.Label label39;
    private java.awt.Label label40;
    private java.awt.Label label44;
    private java.awt.Label label45;
    private java.awt.Label label47;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private javax.swing.JLabel lblEndDate;
    private javax.swing.JLabel lblPublicationName;
    private javax.swing.JLabel lblPublishedDate;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblWkName;
    private javax.swing.JLabel lblWktitle;
    private javax.swing.JLabel lblWktitle2;
    private javax.swing.JPasswordField newPassTxtField;
    private javax.swing.JPanel profile;
    private javax.swing.JLabel profileContactLabel1;
    private javax.swing.JLabel profileDesigLabel;
    private javax.swing.JLabel profileEmailLabel;
    private javax.swing.JLabel profileNameLabel;
    private javax.swing.JLabel profileNameLabel1;
    private javax.swing.JLabel profileQualifyLabel;
    private javax.swing.JLabel profileUnameLabel;
    private javax.swing.JLabel profileUnameLabel1;
    private javax.swing.JLabel publicationNOS;
    private javax.swing.JPanel publications;
    private javax.swing.JScrollPane scrlPane;
    private javax.swing.JScrollPane scrlpaneWk;
    private javax.swing.JTable tblPublicationDetails;
    private javax.swing.JTable tblWorkshop;
    private javax.swing.JTextField txtPublicationName;
    private javax.swing.JPanel workshop;
    private com.toedter.calendar.JDateChooser workshopEndDate;
    private com.toedter.calendar.JDateChooser workshopStartDate;
    private javax.swing.JTextField workshopTxtField;
    // End of variables declaration//GEN-END:variables
}
