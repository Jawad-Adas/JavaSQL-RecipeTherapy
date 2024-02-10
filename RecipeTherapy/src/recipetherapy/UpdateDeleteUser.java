package recipetherapy;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class UpdateDeleteUser extends javax.swing.JFrame {

    myDBCon dbCon;
    ResultSet rs;
    ResultSet rs1;
    String currentPassword;
    String currentUsername;
    
    public UpdateDeleteUser() {
        initComponents();
        this.setLocationRelativeTo(null);
        clearErrorLabels();
        
        dbCon = new myDBCon();
        getNewData();
        
    }
    
    void getNewData(){
        try {
            String prepStmt = "Select name, email, username, password, phone_number, user_type from \"User\"";
            rs = dbCon.executeStatement(prepStmt);
            
            rs.beforeFirst();
            rs.first();
            populateFields();
            
        } catch (SQLException e) {
            javax.swing.JLabel label = new javax.swing.JLabel(e.getMessage());
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    void populateFields(){
        
        try {
            txtName.setText(rs.getString("name"));
            txtEmail.setText(rs.getString("email"));
            txtUsername.setText(rs.getString("username"));
            txtPassword.setText(rs.getString("password"));
            txtConfirmPassword.setText(rs.getString("password"));
            txtPhoneNo.setText(rs.getString("phone_number"));
            cmbUserType.setSelectedItem(rs.getString("user_type"));
            currentPassword =rs.getString("password");
            currentUsername = rs.getString("username");
            
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void EnableDisableButtons() {
        // enable/disable Previous/Next buttons
        try {
            if (rs.isFirst()) {
                btnPrevious.setEnabled(false);
            } else {
                btnPrevious.setEnabled(true);
            }
            if (rs.isLast()) {
                btnNext.setEnabled(false);
            } else {
                btnNext.setEnabled(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    boolean isValidPassword() {
        // check validity of the password value entered by the user based on your design 
        boolean result = ((txtPassword.getText().trim().length() <= 32) 
                && txtPassword.getText().trim().equals(txtConfirmPassword.getText().trim()) 
                && !txtPassword.getText().trim().isEmpty());
        
        return result;
    }
    
    boolean isValidData(){
        clearErrorLabels();
        
        boolean result = true;
        
        //check password
        if (!isValidPassword()){
            if ((txtPassword.getText().trim().length() > 32)) { 
                lblPasswordError.setText("Invalid. Cannot be more than 32 chars.");
                lblPasswordError.setVisible(true);
            }
            else if (!txtPassword.getText().trim().equals(txtConfirmPassword.getText().trim())) { 
                lblConfirmPasswordError.setText("Invalid. Must match password.");
                lblConfirmPasswordError.setVisible(true);
            }
            result = false;
        }
        
        //check username
        if(txtUsername.getText().trim().length() >25){
            lblUsernameError.setText("cant be more than 25 chars");
            lblUsernameError.setVisible(true);
            result = false;
        }
        
        //check Name
        if(txtName.getText().trim().length() >25){
            lblNameError.setText("can't be more than 25 chars");
            lblNameError.setVisible(true);
            result = false;
        }   
        
        //check Email
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(txtEmail.getText().trim());
        if(!matcher.matches()){
            lblEmailError.setText("Invalid email format");
            lblEmailError.setVisible(true);
            result = false;
        }
        
        //check Phone Number
        if(txtPhoneNo.getText().trim().length() > 15){
            lblPhoneNumberError.setText("Enter a valid phone number");
            lblPhoneNumberError.setVisible(true);
            result = false;
        }
        
        return result;
    }
    
    
    void clearErrorLabels() {
        // erase error label text and set visibility to false
        lblNameError.setText("");
        lblNameError.setVisible(false);
        lblUsernameError.setText("");
        lblUsernameError.setVisible(false);
        lblPasswordError.setText("");
        lblPasswordError.setVisible(false);
        lblConfirmPasswordError.setText("");
        lblConfirmPasswordError.setVisible(false);
        lblEmailError.setText("");
        lblEmailError.setVisible(false);
        lblPhoneNumberError.setText("");
        lblPhoneNumberError.setVisible(false);
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtPhoneNo = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblNameError = new javax.swing.JLabel();
        lblUsernameError = new javax.swing.JLabel();
        lblEmailError = new javax.swing.JLabel();
        lblPasswordError = new javax.swing.JLabel();
        lblPhoneNumberError = new javax.swing.JLabel();
        cmbUserType = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        lblConfirmPasswordError = new javax.swing.JLabel();
        showPassCheckBox = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(222, 232, 250));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("Name:");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel2.setText("Update/Delete User Information");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setText("Email:");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setText("Username:");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setText("Phone Number:");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel6.setText("Password");

        lblNameError.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        lblNameError.setForeground(new java.awt.Color(255, 0, 0));
        lblNameError.setText("error label");

        lblUsernameError.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        lblUsernameError.setForeground(new java.awt.Color(255, 0, 0));
        lblUsernameError.setText("error label");

        lblEmailError.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        lblEmailError.setForeground(new java.awt.Color(255, 0, 0));
        lblEmailError.setText("error label");

        lblPasswordError.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        lblPasswordError.setForeground(new java.awt.Color(255, 0, 0));
        lblPasswordError.setText("error label");

        lblPhoneNumberError.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        lblPhoneNumberError.setForeground(new java.awt.Color(255, 0, 0));
        lblPhoneNumberError.setText("error label");

        cmbUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1" }));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel7.setText("User Type");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel8.setText("Confirm Password:");

        lblConfirmPasswordError.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        lblConfirmPasswordError.setForeground(new java.awt.Color(255, 0, 0));
        lblConfirmPasswordError.setText("error label");

        showPassCheckBox.setText("Show Password");
        showPassCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPassCheckBoxActionPerformed(evt);
            }
        });

        jLabel9.setText("Search:");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmbUserType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(showPassCheckBox))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPhoneNumberError, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtConfirmPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                            .addComponent(txtUsername)
                            .addComponent(txtEmail)
                            .addComponent(txtName)
                            .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblEmailError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                        .addComponent(lblUsernameError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lblNameError, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPasswordError, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblConfirmPasswordError, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSearch)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNameError, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmailError, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsernameError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPasswordError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblConfirmPasswordError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPhoneNumberError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbUserType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(showPassCheckBox))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    
    private void MoveNext() {
        // move result set to next record
        try {
            if (!rs.isLast()) {
                rs.next();
                populateFields();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void MovePrevious() {
        // move result set to next record
        try {
            if (!rs.isFirst()) {
                rs.previous();
                populateFields();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {                                        
        MoveNext();
        EnableDisableButtons();
    }                                       

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {                                            
       MovePrevious();
       EnableDisableButtons();
    }                                           
    
    
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to update this record?", "Confirm Update", JOptionPane.YES_NO_OPTION);     
        if (confirmResult == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(rootPane, "Update Cancelled", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(isValidData()){
                
                int result;
                try {
                    result = dbCon.executePrepared("SELECT username FROM \"User\" WHERE username = '"
                        + txtUsername.getText().trim() + "' AND "
                        + "password = '" + txtPassword.getText().trim() + "' AND "
                        + "name = '" + txtName.getText().trim() + "' AND " 
                        + "user_type = " + cmbUserType.getSelectedItem());
                    if (result < 1){
                        try {
                            String password;
                            //if password didnt change we want to keep the same password saved so we assign it to the password String
                            if (currentPassword.equals(txtPassword.getText().trim())) {
                            password = txtPassword.getText().trim();
                            }//else we encrypt the new entered password and we assign it to the string passowrd
                            else 
                            password = encrypt(txtPassword.getText().trim());
                    
                            try{
                                result = dbCon.executePrepared("UPDATE \"User\" SET "
                                    + "password = '" + password + "', " 
                                    + "name = '" + txtName.getText().trim() + "', "
                                    + "user_type = " + cmbUserType.getSelectedItem() + ", " 
                                    + "username = '" + txtUsername.getText().trim() + "', "
                                    + "email = '" + txtEmail.getText().trim() + "', "
                                    + "phone_number = '" + txtPhoneNo.getText().trim() +"' "
                                    + "WHERE username = '" + currentUsername + "'");
                    
                                if (result > 0) {
                                javax.swing.JLabel label = new javax.swing.JLabel("User " + currentUsername + " updated successfully.");
                                label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                                JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                                getNewData();
                                }
                    
                            } catch (SQLException ex)  {
                                javax.swing.JLabel label = new javax.swing.JLabel(ex.getMessage());
                                label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                                JOptionPane.showMessageDialog(null, label, "FAIL", JOptionPane.INFORMATION_MESSAGE);
                                getNewData();
                            }
                        }catch  (NoSuchAlgorithmException ex) {
                            Logger.getLogger(UpdateDeleteUser.class.getName()).log(Level.SEVERE, null, ex);
                        }   
                    }
                }catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error updating user." + e.getMessage());
            }   
        }else{
            javax.swing.JLabel label = new javax.swing.JLabel("Please fix validation errors...");
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
        }    
    }                                         

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Confirm Delete", JOptionPane.YES_NO_OPTION);     
        if (confirmResult == JOptionPane.OK_CANCEL_OPTION) {
            JOptionPane.showMessageDialog(rootPane, "Deletion Cancelled", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            String stmt = "DELETE \"User\" WHERE username = '" + txtUsername.getText().trim() +"'";
            int result = dbCon.executePrepared(stmt);
            
            if(result>0){
                javax.swing.JLabel label = new javax.swing.JLabel("Username " + txtUsername.getText().trim() + " deleted successfully.");
                label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                getNewData();
            }
            
        } catch (SQLException ex) {
            javax.swing.JLabel label = new javax.swing.JLabel("Error deleting Record: " + ex.getMessage());
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "FAIL", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }                                         

    private void showPassCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        if(showPassCheckBox.isSelected()){
            txtPassword.setEchoChar((char) 0);
            txtConfirmPassword.setEchoChar((char) 0);
        }else{
            txtPassword.setEchoChar('*');
            txtConfirmPassword.setEchoChar('*');
        }
    }                                                

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        try {
            String prepStmt = "Select name, email, username, password, phone_number, user_type from \"User\" WHERE username = '" + txtSearch.getText().trim()+"'";
            rs1 = dbCon.executeStatement(prepStmt);
            
            if (!rs1.next()){
                 javax.swing.JLabel label = new javax.swing.JLabel(" Couldn't Find Username: " + txtSearch.getText().trim() );
                 label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                 JOptionPane.showMessageDialog(null, label, "FAIL", JOptionPane.INFORMATION_MESSAGE);
                
            }else{
                txtName.setText(rs1.getString("name"));
                txtEmail.setText(rs1.getString("email"));
                txtUsername.setText(rs1.getString("username"));
                txtPassword.setText(rs1.getString("password"));
                txtConfirmPassword.setText(rs1.getString("password"));
                txtPhoneNo.setText(rs1.getString("phone_number"));
                cmbUserType.setSelectedItem(rs1.getString("user_type"));
                currentPassword =rs1.getString("password");
                currentUsername = rs1.getString("username");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
            
        
        
        
        
        
        
        
    }                                         

    

    private String encrypt(String pass) throws NoSuchAlgorithmException {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashedpassword = md.digest(pass.getBytes());
            StringBuilder sb = new StringBuilder();
            
            for (byte b : hashedpassword) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        }catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbUserType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblConfirmPasswordError;
    private javax.swing.JLabel lblEmailError;
    private javax.swing.JLabel lblNameError;
    private javax.swing.JLabel lblPasswordError;
    private javax.swing.JLabel lblPhoneNumberError;
    private javax.swing.JLabel lblUsernameError;
    private javax.swing.JCheckBox showPassCheckBox;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhoneNo;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration                   
}