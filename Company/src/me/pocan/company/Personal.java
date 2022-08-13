
package me.pocan.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Personal {
    
    
    PreparedStatement preparedStatement = null;
    
    public Personal() {
        
    }
    
    public boolean LoginChecker(String username, String password, Connection con) {
        try {
            String request = "Select * from users where username = ? and password = ?";
            
            preparedStatement = con.prepareStatement(request);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
    
    
            
