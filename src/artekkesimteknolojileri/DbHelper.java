/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package artekkesimteknolojileri;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author alims
 */
public class DbHelper {
    
    static private Connection connection;
    
    private static final String userName = "user";
    private static final String password = "pw";
    private static final String dbUrl = "jdbc:mysql://";
    
    public static Connection getConnection() throws SQLException{
        if (connection == null) {
            connection = DriverManager.getConnection(dbUrl, userName, password);
        }
        
        return connection;
    }
    
    public static void setData(String data) throws SQLException {
        DbHelper.getConnection().createStatement().executeUpdate(data);
    }
    
    public static PreparedStatement setPrepareData(String data) throws SQLException {
        return DbHelper.getConnection().prepareStatement(data);
    }
    
    public static ResultSet getData(String data) throws SQLException {
        return DbHelper.getConnection().createStatement().executeQuery(data);
    }
    
    public static void showErrorMessage(SQLException exception){
        System.out.println("Error: " + exception.getMessage());
        System.out.println("Error Code: " + exception.getErrorCode());
    }

    
}
