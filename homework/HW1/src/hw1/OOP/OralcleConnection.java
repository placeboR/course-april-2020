package hw1.OOP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OralcleConnection implements DatabaseConnection {
    private String dataSource;
    public Connection getConnection(){
        dataSource = new String("OracleConnection");
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin@localhost:1521:placeboR", "root", "123456");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
