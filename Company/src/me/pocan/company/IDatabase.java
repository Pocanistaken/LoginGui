
package me.pocan.company;

import java.sql.Connection;


public interface IDatabase {;
    public Connection connectDatabase(String database, String username, String password);
    
    
    
}
