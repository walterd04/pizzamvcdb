package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Create a connection to a MySQL database in the simplest fashion possible.
 *
 * @author John Phillips
 * @version 20170304
 *
 */
public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://34.206.148.46:3306/jdoe?useSSL=false", "jdoe", "mucis");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdoe?useSSL=false", "jdoe", "mucis"); 
            System.out.println("Connected to DB at " + LocalDateTime.now());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public static void main(String[] args) {
        getConnection();
    }
}
