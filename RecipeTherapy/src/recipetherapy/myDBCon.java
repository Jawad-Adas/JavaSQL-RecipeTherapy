/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recipetherapy;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class myDBCon {
    String DBURL = "jdbc:oracle:thin:@coeoracle.aus.edu:1521:orcl";
    String DBUSER = "b00089059";
    String DBPASS = "b00089059";
    
    boolean validLogin = false;

    Connection con;
    Statement statement;
    PreparedStatement prepStatement;
    ResultSet rs;
    
    public myDBCon() {
        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Connect to Oracle Database
            con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);

        } catch (ClassNotFoundException | SQLException e) {
            javax.swing.JLabel label = new javax.swing.JLabel("SQL ErroR - Retreiving usename/password.");
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public ResultSet executeStatement(String strSQL) throws SQLException {
        // make the result set scrolable forward/backward updatable
        statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        // populate valid mgr numbers 
        rs = statement.executeQuery(strSQL);
        return rs;
    }
    
    // update, insert (return number of records affected 
    public int executePrepared(String strSQL) throws SQLException {
        prepStatement = con.prepareStatement(strSQL);
        return prepStatement.executeUpdate();
    }
    
}
