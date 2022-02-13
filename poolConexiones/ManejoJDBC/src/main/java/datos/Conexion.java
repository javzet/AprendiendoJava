package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/"
            + "test?useSSL=false&useTimezone=true&"
            + "serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "1379";
    
    public static DataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASSWORD);
        
        // Deninimos el tamaño inicial del pool de conexiones
        ds.setInitialSize(5);
        
        return ds;
    }

    public static Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        return getDataSource().getConnection();
        
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void close(Statement smnt) {
        try {
            smnt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Mejor performance que el anterior
    public static void close(PreparedStatement smnt) {
        try {
            smnt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
