
package Ventanas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    private Connection conexion;
    
    public static Connection con;
    private static final String driver = "com.mysql.jdbc.Driver"; 
    private static final String user = "root";
    private static final String pass = "";
    private static final String url = "jdbc:mysql://localhost:3306/zoologico"; 
    
    public Connection conectar() {
        con = null;
        try {
            Class.forName(driver); 
            con = DriverManager.getConnection(url, user, pass);
            if (con != null) {
                System.out.println("Conexión exitosa");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error en el controlador: " + e.toString());
        }
        return con;
    }
    
}
