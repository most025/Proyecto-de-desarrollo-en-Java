package database;

import java.sql.*;

import javax.swing.JOptionPane;
/**
 * Clase para manejar la conexión a la base de datos.
 */

public class Conexion {
 
    private static Connection conexion;
    private static Conexion instancia;
    private static final String URL ="jdbc:mysql://localhost/sistema-entrada";
    private static final String USER="root";
    private static final String PASSWORD="";
    
    //Creación del metodo para cconectarnos a la base de datos.
    public Connection ConectarBD(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion= DriverManager.getConnection(URL, USER, PASSWORD);
            JOptionPane.showMessageDialog(null,"Conexión exitosa a la base de datos");
            return conexion;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error:"+e);
        }
        return conexion;
    }

    //Metodo para cerrar la conexion a la base de datos (patron singleton).
    public void cerrarConexion() throws SQLException{
        try {
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al cerrar la conexión: "+e);
            conexion.close();
        }finally{
            conexion.close();
        }

    }
    //Método para obtener la instancia de la conexión.
    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }


}
