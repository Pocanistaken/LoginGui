
package me.pocan.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database implements IDatabase{
    private String hostname,username,password,database;
    private int port;
    private Connection con = null;
    
    public Database(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;  
    }

    @Override
    public Connection connectDatabase(String database, String username, String password) {
        
        String request = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useUnicode=true&characterEncoding=utf8";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(request, username, password);
            return con;
        } catch (ClassNotFoundException e) {
            System.out.println("Driver is not found");
            return null;
        } catch (SQLException ex) {      
            System.out.println("Connection is failed.");
            return null;
        }
        
    }




    
}
