package hw1.OOP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlServerConnection implements DatabaseConnection {
    private String dataSource;
    public Connection getConnection(){
        dataSource = new String("SqlServerConnection");
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://<server>:<port>;databaseName=placeboR;user=<user>;password=<password>");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
