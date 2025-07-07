import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import database.Conexion;

public class EntradaEstudiante extends EntradaGeneral {
    Conexion conectarBD= Conexion.getInstancia();

    public EntradaEstudiante(){
        
    }

    public EntradaEstudiante(String tipo, String asiento) {
        super(tipo, asiento);
    }
    //metodo heredado de la clase Entrada General.
    @Override
    public double calcularPrecio() {
    return PRECIO-(PRECIO*60/100);  
}
@Override
public void generarAsiento() {
    Connection conexion= null;
    PreparedStatement prepararConsulta=null;
    try {
        conexion= conectarBD.ConectarBD();
        String sql="SELECT * FROM salaDeCine WHERE tipo_entrada='Entrada para Estudiantes'";
        prepararConsulta= conexion.prepareStatement(sql);
        ResultSet consulta= prepararConsulta.executeQuery();
        StringBuilder informacion= new StringBuilder();
        while(consulta.next()){
            String nombre= consulta.getString("nombre");
            String edad = consulta.getString("edad");
            String entradas=consulta.getString("tipo_entrada");
            String asiento= consulta.getString("asientos");
            // imprimir los datos extraidos de la tabla sala_cine.
            informacion.append("Nombre: ").append(nombre).append("\n")
                        .append("Edad: ").append(edad).append("\n")
                        .append("Tipo de Entrada: ").append(entradas).append("\n")
                        .append("Asiento: ").append(asiento).append("\n")
                        .append("Precio: ").append(calcularPrecio()).append("\n\n");
        }
        if (informacion.length()>0) {
            JOptionPane.showMessageDialog(null, informacion.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron datos para mostrar.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al Extraer los datos: " + e.getMessage());
    }
    
}
}
